package com.instras;

import com.codename1.io.Util;
import com.codename1.util.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Utility method for working with cassette flow data
 * 
 * @author Nathan
 */
public class CassetteFlowUtil {
    /**
     * Method to create the tape db as a String
     * 
     * @param data 
     * @return HashMap containing tape database 
     */
    public static HashMap<String, ArrayList<String>> createTapeDBFromString(String data) {
        HashMap<String, ArrayList<String>> remoteDB = new HashMap<>();
        
        for (String line : Util.split(data, "\n")) {
            String[] sa = Util.split(line, "\t");
            String key = sa[0];
            
            ArrayList<String> audioIds = new ArrayList<>();
            for (int i = 1; i < sa.length; i++) {
                if(!sa[i].isEmpty()) {
                    audioIds.add(sa[i]);
                }
            }

            remoteDB.put(key, audioIds);
        }
        
        return remoteDB;
    }
    
    /**
     * Method to create the audio db from a String
     * 
     * @param data 
     * @return Hash map containing the audio database 
     */
    public static HashMap<String, AudioInfo> createAudioInfoDBFromString(String data) {
        HashMap<String, AudioInfo> remoteDB = new HashMap<>();

        for (String line : Util.split(data, "\n")) {
            String[] sa = Util.split(line, "\t");
            
            if(sa.length == 4) {
                String id = sa[0];
                int playtime = Integer.parseInt(sa[1]);
                String playtimeString = CassetteFlowUtil.getTimeString(playtime);
                int bitRate = Integer.parseInt(sa[2]);
                String filename = StringUtil.replaceFirst(sa[3], "/sdcard/", "");

                AudioInfo audioInfo = new AudioInfo(filename, id, playtime, playtimeString, bitRate);
                remoteDB.put(id, audioInfo);
            }
        }
        
        return remoteDB;
    }
    
    /**
     * Method to get the time in seconds as a string
     * 
     * @param totalSecs
     * @return 
     */
    public static String getTimeString(int totalSecs) {
        int hours = totalSecs / 3600;
        int minutes = (totalSecs % 3600) / 60;
        int seconds = totalSecs % 60;
        
        String time = "0" + hours + ":";
        
        if(minutes < 10) {
            time  += "0" + minutes; 
        } else {
            time  += minutes; 
        }
        
        if(seconds < 10) {
            time  += ":0" + seconds; 
        } else {
            time  += ":" + seconds; 
        }
        
        return time;
    }
    
    /**
     * Pad a string with left zeros
     * @param inputString
     * @param length
     * @return 
     */
    public static String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }
    
    /**
     * Pad an integer with a certain number of zeroes
     * @param num
     * @param pad
     * @return 
     */
    public static String intPadLeftZeroes(int num, int pad) {
        String result = String.valueOf(num);
        int length = result.length();
        if (length >= pad) {
            return result;
        }
        char[] z = new char[pad - length];
        for (int i = 0; i < z.length; i++) {
            z[i] = '0';
        }
        return "" + new String(z) + Integer.toString(num);
    }
}
