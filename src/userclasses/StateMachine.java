/**
 * Your application code goes here<br>
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */


package userclasses;

import ca.weblite.codename1.json.JSONException;
import ca.weblite.codename1.json.JSONObject;
import com.codename1.bluetoothle.Bluetooth;
import com.codename1.charts.util.ColorUtil;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.io.Preferences;
import com.codename1.io.Util;
import com.codename1.location.LocationManager;
import generated.StateMachineBase;
import com.codename1.ui.*; 
import com.codename1.ui.events.*;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.util.Base64;
import com.codename1.util.StringUtil;
import com.instras.CassetteFlowUtil;
import com.instras.AudioInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * A simple program to connect to the LyraT board
 * @author Nathan Stevens
 * @version 0.1 11/29/2021
 */
public class StateMachine extends StateMachineBase {
    private String UUID_SERVICE;
    private String UUID_TX;
    
    // The Service and RX/TX UUID for the SH-H3 Bluetooth adapter
    // http://www.dsdtech-global.com/2017/07/dsd-tech-sh-h3-bluetooth-dual-mode.html
    private final String SH3_UUID_SERVICE = "0000fee7-0000-1000-8000-00805f9b34fb";
    private final String UUID_RX = "0000ffe1-0000-1000-8000-00805f9b34fb";
    private final String SH3_UUID_TX = "0000ffe1-0000-1000-8000-00805f9b34fb";
    
    
    // used to connecting to the BT21A08 8 channel relay instead
    // https://www.ebay.com/itm/332053662718
    private final String BT04_UUID_SERVICE = "0000ffe0-0000-1000-8000-00805f9b34fb";
    private final String BT04_UUID_TX = "0000ffe2-0000-1000-8000-00805f9b34fb";
    private boolean useBT04;
    
    // variables used when connecting to bluetooth device
    private Bluetooth bt;
    private Map devices;
    private String bleAddress;
    private boolean connected = false;

    private boolean onSimulator;
    
    private Form mainForm;
    
    private TextArea console;
    
    private boolean readData;
    
    // stores mp3/flac and tape information from the cassetteflow device
    private HashMap<String, AudioInfo> audioDB;
    private HashMap<String, ArrayList<String>> tapeDB;
    private boolean connectedCF;
    
    // store the the url of the lyraT or CF server
    private String cfAddress;
    
    // variables that need to updated
    private String tapeID;
    private String trackList;
    private String trackInfo;
    private String audioName;
    
    private int  dataErrors;
    
    // keep track if we FF or RR on reel to reel
    private boolean ffOrRewind;
    
    public StateMachine(String resFile) {
        super(resFile);
        // do not modify, write code in initVars and initialize class members there,
        // the constructor might be invoked too late due to race conditions that might occur
    }
    
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    protected void initVars(Resources res) {
        bt = new Bluetooth();
        bleAddress = "";
        
        devices = new HashMap();
        
        String os = System.getProperty("os.name");
        if (os != null && os.indexOf("Windows") != -1) {
            System.out.println("Running on simulator");
            bt = null;
            onSimulator = true;
        } else {
            onSimulator = false;
        }

        tapeID = "N/A";
        trackList = "N/A";
        trackInfo = "N/A";
        audioName = "???";
        
        // specifify the read data to continue reading from server
        readData = true;
        connectedCF = false;
        
        dataErrors = 0;
        
        ffOrRewind = false;
        
        // set the default BT information for connecting to devices
        UUID_SERVICE = "";
        UUID_TX = "";
        
        // specify if the BT04-A 8 channel relay is being used
        useBT04 = false;
        
        // set the server preferences
        cfAddress = Preferences.get("cf.address", "http://192.168.1.154:8192");
    }
    
    /**
     * Scan for Bluetooth BLE devices, otherwise just add a dummy 
     */
    protected void scan() {
        try {
            bt.initialize(true, false, "bluetoothleplugin");
            scanBluetoothDevices();
        } catch (Exception ex) {
            addDummyDevices();
            bt = null;
            print("Error Scanning BT\n" + ex.toString(), false);
        }
    }
    
    /**
     * Scan for bluetooth devices
     *
     * @throws IOException
     */
    private void scanBluetoothDevices() throws IOException {
        print("Scanning BT ...", false);
        
        // work around for latest android update wich requires access to location
        // to scan for BLE devices. Why, I don't know?
        LocationManager.getLocationManager().getCurrentLocationSync();
        
        bt.startScan(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    JSONObject res = (JSONObject) evt.getSource();
                    //print("BT Scan Response\n" + res, true);

                    if (res.getString("status").equals("scanResult")) {
                        //if this is a new device add it
                        if (!devices.containsKey(res.getString("address"))) {
                            if (!res.getString("name").equals("null")) {
                                devices.put(res.getString("address"), res);
                                updateAddressPicker();
                            }
                        }
                    }
                } catch (JSONException ex) {
                    print("Error Scanning BT\n"  + ex.getMessage(), false);
                }
            }
        }, null, true, Bluetooth.SCAN_MODE_BALANCED, Bluetooth.MATCH_MODE_STICKY,
                Bluetooth.MATCH_NUM_MAX_ADVERTISEMENT, Bluetooth.CALLBACK_TYPE_ALL_MATCHES);
    }
    
    /**
     * Add dummy Bluetooth devices for simulator
     */
    private void addDummyDevices() {
        try {
            // add somedum data for testing
            for (int i = 1; i <= 5; i++) {
                JSONObject obj = new JSONObject();
                obj.put("address", "00:00:00:00:00:00");
                obj.put("name", "Dummy BLE" + i);
                devices.put("00:00:00:00:00:0" + i, obj);
            }

            updateAddressPicker();
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Update the address picker
     */
    private void updateAddressPicker() throws JSONException {
        Picker addressPicker = findAddressPicker();
        ArrayList<String> al = new ArrayList<>();

        Set keys = devices.keySet();
        for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
            String address = (String) iterator.next();
            JSONObject obj = (JSONObject) devices.get(address);
            String name = obj.getString("name");
            al.add(name + " || " + address);
        }

        String[] addresses = al.toArray(new String[al.size()]);
        addressPicker.setStrings(addresses);
    }

    @Override
    protected void beforeMain(Form f) {
        super.beforeMain(f); //To change body of generated methods, choose Tools | Templates.

        // the main form
        mainForm = f;

        // set the console text area
        console = findConsoleTextArea(f);
        
        Label label = findTapeIDLabel(f);
        label.getStyle().setFgColor(ColorUtil.BLUE);
        
        label = findTrackLabel(f);
        label.getStyle().setFgColor(ColorUtil.GREEN);
        
        findCfAddressTextField(f).setText(cfAddress);
    }
    
    @Override
    protected void postMain(Form f) {
        scan();
    }
    
    /**
     * Print method to append to the console
     *
     * @param text
     */
    private void print(String text, boolean append) {
        Display.getInstance().callSerially(new Runnable() {
            @Override
            public void run() {
                if (append) {
                    String oldText = console.getText();
                    String newText = oldText + "\n" + text;

                    console.setText(newText);
                } else {
                    console.setText(text);
                }
            }
        });
    }

    @Override
    protected void onMain_ConnectButtonAction(Component c, ActionEvent event) {
        if(connectedCF) {
            findConnectButton().setText("CONNECT");
            
            readData = false;
            connectedCF = false;
            return;
        }
        
        String baseUrl = findCfAddressTextField().getText();
        String mp3DBUrl = baseUrl + "/mp3db";
        String tapeDBUrl = baseUrl + "/tapedb";
        String infoUrl = baseUrl + "/info";
                
        String mp3DBString = getDataFromUrl(mp3DBUrl);
        audioDB = CassetteFlowUtil.createAudioInfoDBFromString(mp3DBString);
        //System.out.println(mp3DBString + "\n\n");
        
        // load the tape database
        String tapeDBString = getDataFromUrl(tapeDBUrl);
        tapeDB = CassetteFlowUtil.createTapeDBFromString(tapeDBString);
        
        findTracksTextArea().setText(mp3DBString + "\n\n" + tapeDBString);
        
        // now start the thread to update the UI
        readData = true;
        trackList = "";
        dataErrors = 0;
        audioName = "???";
        
        Thread thread = new Thread(() -> {
            while(readData) {
                String data = getDataFromUrl(infoUrl);
                showCurrentTrack(data);
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) { }
            }
            
            tapeID = "N/A";
            
            // update the UI to indicate we not connected
            findTapeIDLabel(mainForm).setText("TAPE ID: N/A");
            findTracksTextArea(mainForm).setText("");
            findTrackTextArea(mainForm).setText("");
        });
        thread.start();
        
        // store the CF server
        cfAddress = baseUrl;
        Preferences.set("cf.address", cfAddress);
        
        findConnectButton().setText("DISCONNECT");
        connectedCF = true;
    }
    
    /**
     * Shows the current playback information
     * 
     * @param data 
     */
    private void showCurrentTrack(String data) {
        trackInfo = "PLAYBACK STOPPED";
        System.out.println("Line Data: " + data);
        if(data.contains("_")) {
            String[] sa1 = Util.split(data, " ");
            String[] sa2 = Util.split(sa1[1], "_");
            
            // check to make sure we have valid line, by seeing if we can
            // convert total time string to integer
            String tapeCounter = "????";
            try {
                int seconds = Integer.parseInt(sa2[4]);
                tapeCounter = CassetteFlowUtil.getTimeString(seconds);
            } catch(Exception ex) {
                dataErrors++;
                print("\nInvalid Data: " + data, true);
                return;
            }
            
            if(!sa2[0].equals(tapeID)) {
                trackList = "";
                
                tapeID = sa2[0];
                String numString;
                ArrayList<String> tracks = tapeDB.get(tapeID);
                
                if(tracks != null) {
                    for (int i = 0; i < tracks.size(); i++) {
                        String audioId = tracks.get(i);
                        AudioInfo audioInfo = audioDB.get(audioId);

                        int trackNum = i + 1;
                        numString = (trackNum < 10) ? "0" + trackNum : "" + trackNum;
                        String track = "[" + numString + "] " + audioInfo;
                        trackList += track + "\n";
                    }
                } else {
                    trackList = "UNKNOWN";
                }
            }
            
            // get the information for this track
            AudioInfo audioInfo = audioDB.get(sa2[2]);
            String audioLengthString = "????";
             
            if(audioInfo != null) {
                audioName = audioInfo.getName();
                audioLengthString = CassetteFlowUtil.padLeftZeros("" + audioInfo.getLength(), 4);
            } else {
                print("\nInvalid Data: " + data, true);
                dataErrors++;
            }
            
            String playTime = sa2[3] + "/" + audioLengthString;
            String totalTimeString = "Tape Counter: " + CassetteFlowUtil.padLeftZeros(sa2[4], 4) + " (" + tapeCounter + ")";
            String errorString = "Data Errors: " + dataErrors;
                    
            trackInfo = "[" + sa2[1] +"] " + audioName + "\nPlaytime: " + playTime + "\n" + totalTimeString + "\n" + errorString;
        }
        
        // update the UI
        Display.getInstance().callSerially(() -> {
            findTapeIDLabel(mainForm).setText("TAPE ID: " + tapeID);
            findTracksTextArea(mainForm).setText(trackList);
            findTrackTextArea(mainForm).setText(trackInfo);
        });
    }
    
    private String getDataFromUrl(String url) {
        ConnectionRequest cr = new ConnectionRequest(url, false);
        NetworkManager.getInstance().addToQueueAndWait(cr);
        
        String resultString = "";
        
        if (cr.getResponseCode() == 200) {
            try {
                byte[] initialArray = cr.getResponseData();
                resultString = new String(initialArray);
            } catch (Exception eee) {
                resultString = "Error => " + resultString + eee.getMessage();
            }

            System.out.println(resultString);
        }
        
        return resultString;
    }
    
    @Override
    protected void onMain_AddressPickerAction(Component c, ActionEvent event) {
        Picker addressPicker = (Picker) c;
        String ss = addressPicker.getSelectedString();

        if (ss != null) {
            java.util.List<String> btList = StringUtil.tokenize(ss, "||");
            
            if(btList.get(0).trim().equals("BT04-A")) {
                UUID_SERVICE = BT04_UUID_SERVICE;
                UUID_TX = BT04_UUID_TX;
                useBT04 = true;
                print("Connecting BT04: " + UUID_SERVICE + " / " + UUID_TX, false);
            } else {
                UUID_SERVICE = SH3_UUID_SERVICE;
                UUID_TX = SH3_UUID_TX;
                print("Connecting SH3: " + UUID_SERVICE + " / " + UUID_TX, false);
            }
            
            String address = btList.get(1).trim();
            connect(address);
        }
    }
    
    
    /**
     * Connect to a particular bluetooth device
     *
     * @param address
     */
    private void connect(String address) {
        bleAddress = address;

        if (bt == null) {
            String message = "BLE device not supported ...";
            print(message, false);

            // ***DEBUG CODE***
            //enableButtons(true);
            connected = true;
            return;
        }

        if (!connected) {
            // start an infinite progress dialog
            final Dialog ip = new InfiniteProgress().showInfiniteBlocking();

            try {
                bt.connect(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        ip.dispose();

                        Object obj = evt.getSource();
                        print("Bluetooth LE Connected:\n" + obj, true);
                        
                        discover(); // must be called on Andriod. Won't do anything on ios though
                        
                        connected = true;
                        
                        //enableButtons(true);
                        Label label = findR2rStatusLabel();
                        label.setText("STATUS: CONNECTED");
                        label.getStyle().setFgColor(ColorUtil.GREEN);
                    }

                }, address);
            } catch (IOException ex) {
                ip.dispose();

                String message = "Error connecting to bluetooth device: " + address;
                print(message + "\n" + ex.getMessage(), false);
            }
        } else {
            String message = "BLE device already connected to: " + address;
            print(message, false);
        }
    }
    
    /**
     * This method needs to be called on Android otherwise the service is not
     * found
     */
    private void discover() {
        try {
            bt.discover(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Object obj = evt.getSource();
                    //print("\nBLE Discovered: " + obj, true);
                    print("\nBLE Services Discovered ...", true);
                    
                    addSubscriber();
                }

            }, bleAddress);

        } catch (Exception ex) {
            print(ex.getMessage(), false);
        }

        // if we running on isos add the subscriber here since the above bt call
        // does nothing?
        if (Display.getInstance().getPlatformName().equals("ios")) {
            print("Adding subscriber for iOS Device", true);
            addSubscriber();
        }
    }
    
    /**
     * Method to listen for incoming data
     */
    private void addSubscriber() {
        try {
            bt.subscribe(new ActionListener() {
                StringBuilder sb = new StringBuilder();

                @Override
                public void actionPerformed(ActionEvent evt) {
                    JSONObject dataIncoming = (JSONObject) evt.getSource();
                    String base64Value = "";
                    try {
                        print("\nIncoming Data: " + dataIncoming, true);
                        if (dataIncoming.getString("status").equals("subscribedResult")) {
                            base64Value = dataIncoming.getString("value");
                        }
                    } catch (JSONException e) {
                        console.setText("Error reading data: " + e.getMessage());
                    }

                    //String message = new String(Base64.decode(base64Value.getBytes()));
                    String message = base64Value;
                    sb.append(message);
                    
                    if (message.endsWith("\r\n")) {
                        processData(sb.toString());
                        sb = new StringBuilder();
                    }
                }

            }, bleAddress, UUID_SERVICE, UUID_RX);

            String message = console.getText() + "\nSubcriber added ...";
            console.setText(message);
        } catch (IOException ex) {
            String message = "Error Subscribing: " + ex.getMessage();
            console.setText(message);
        }
    }

    private void processData(String data) {
        data = data.trim();
        print("\nData received: " + data, true);
    }
    
    /**
     * Used for send the long text since apparent BLE you can only send 23 bytes
     * at a time. As such split ascii text into chunks of 20 characters to
     * prevent any issues
     *
     */
    private void splitAndSend(String text) {
        text += "\r\n";

        // first split data in chunk size of 20 chracters
        ArrayList<String> chunks = new ArrayList<>();

        char[] data = text.toCharArray();
        int len = data.length;
        int chunkSize = 20;

        for (int i = 0; i < len; i += chunkSize) {
            chunks.add(new String(data, i, Math.min(chunkSize, len - i)));
        }

        // now send chunks amd wait 100 ms to prevent any erros
        for (String chunk : chunks) {
            sendText(chunk);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
    }
    
    /**
     * Send text but first then encode in base64 otherwise it doesn't work
     *
     * @param text
     */
    private void sendText(String text) {
        // check to make sure we not running on simulator
        if (bt == null) {
            print("Test Mode Data Sent: " + text, true);
            return;
        }
        
        try {
            String b64String = Base64.encode(text.getBytes());
            print("\nSending: " + text, true);
            
            bt.write(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (text.endsWith("\r\n")) {
                        print("Data Sent: " + text, true);
                    } else {
                        print("Send Error: " + evt.toString(), false);
                    }
                }

            }, bleAddress, UUID_SERVICE, UUID_TX, b64String, true);
        } catch (IOException ex) {
            String message = "Error sending: " + text + "\n"
                    + UUID_SERVICE + "\n"
                    + UUID_TX + "\n"
                    + ex.getMessage();
            print(message, false);
        }
    }
    
    @Override
    protected void onMain_PlayForwardButtonAction(Component c, ActionEvent event) {
        if(ffOrRewind) {
            try {
                sendText("STOP\r\n");
                Thread.sleep(1500);
            } catch (InterruptedException ex) { }
        }
        
        if(useBT04) {
            sendText("A0\r\n");
        } else {
            sendText("PLAY\r\n");
        }
        
        ffOrRewind = false;
    }

    @Override
    protected void onMain_StopButtonAction(Component c, ActionEvent event) {
        sendText("STOP\r\n");
        ffOrRewind = false;
    }

    @Override
    protected void onMain_RevButtonAction(Component c, ActionEvent event) {
        sendText("REV\r\n");
        ffOrRewind = true;
    }

    @Override
    protected void onMain_FfButtonAction(Component c, ActionEvent event) {
        sendText("FF\r\n");
        ffOrRewind = true;
    }

    @Override
    protected void onMain_RecButtonAction(Component c, ActionEvent event) {
        sendText("REC\r\n");
        ffOrRewind = false;
    }

    @Override
    protected void onMain_PauseButtonAction(Component c, ActionEvent event) {
        sendText("PAUSE\r\n");
        ffOrRewind = false;
    }

    @Override
    protected void onMain_ClearButtonAction(Component c, ActionEvent event) {
        findConsoleTextArea().setText("");
    }
}
