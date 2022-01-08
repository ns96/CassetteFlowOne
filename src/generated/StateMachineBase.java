/**
 * This class contains generated code from the Codename One Designer, DO NOT MODIFY!
 * This class is designed for subclassing that way the code generator can overwrite it
 * anytime without erasing your changes which should exist in a subclass!
 * For details about this file and how it works please read this blog post:
 * http://codenameone.blogspot.com/2010/10/ui-builder-class-how-to-actually-use.html
*/
package generated;

import com.codename1.ui.*;
import com.codename1.ui.util.*;
import com.codename1.ui.plaf.*;
import java.util.Hashtable;
import com.codename1.ui.events.*;

public abstract class StateMachineBase extends UIBuilder {
    private Container aboutToShowThisContainer;
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    /**
    * @deprecated use the version that accepts a resource as an argument instead
    
**/
    protected void initVars() {}

    protected void initVars(Resources res) {}

    public StateMachineBase(Resources res, String resPath, boolean loadTheme) {
        startApp(res, resPath, loadTheme);
    }

    public Container startApp(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("OnOffSwitch", com.codename1.components.OnOffSwitch.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("TextArea", com.codename1.ui.TextArea.class);
        UIBuilder.registerCustomComponent("ComboBox", com.codename1.ui.ComboBox.class);
        UIBuilder.registerCustomComponent("Picker", com.codename1.ui.spinner.Picker.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("Tabs", com.codename1.ui.Tabs.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        UIBuilder.registerCustomComponent("RadioButton", com.codename1.ui.RadioButton.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    if(resPath.endsWith(".res")) {
                        res = Resources.open(resPath);
                        System.out.println("Warning: you should construct the state machine without the .res extension to allow theme overlays");
                    } else {
                        res = Resources.openLayered(resPath);
                    }
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        if(res != null) {
            setResourceFilePath(resPath);
            setResourceFile(res);
            initVars(res);
            return showForm(getFirstFormName(), null);
        } else {
            Form f = (Form)createContainer(resPath, getFirstFormName());
            initVars(fetchResourceFile());
            beforeShow(f);
            f.show();
            postShow(f);
            return f;
        }
    }

    protected String getFirstFormName() {
        return "Main";
    }

    public Container createWidget(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("OnOffSwitch", com.codename1.components.OnOffSwitch.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("TextArea", com.codename1.ui.TextArea.class);
        UIBuilder.registerCustomComponent("ComboBox", com.codename1.ui.ComboBox.class);
        UIBuilder.registerCustomComponent("Picker", com.codename1.ui.spinner.Picker.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("Tabs", com.codename1.ui.Tabs.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        UIBuilder.registerCustomComponent("RadioButton", com.codename1.ui.RadioButton.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    res = Resources.openLayered(resPath);
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        return createContainer(resPath, "Main");
    }

    protected void initTheme(Resources res) {
            String[] themes = res.getThemeResourceNames();
            if(themes != null && themes.length > 0) {
                UIManager.getInstance().setThemeProps(res.getTheme(themes[0]));
            }
    }

    public StateMachineBase() {
    }

    public StateMachineBase(String resPath) {
        this(null, resPath, true);
    }

    public StateMachineBase(Resources res) {
        this(res, null, true);
    }

    public StateMachineBase(String resPath, boolean loadTheme) {
        this(null, resPath, loadTheme);
    }

    public StateMachineBase(Resources res, boolean loadTheme) {
        this(res, null, loadTheme);
    }

    public com.codename1.ui.Label findLabel11(Component root) {
        return (com.codename1.ui.Label)findByName("Label11", root);
    }

    public com.codename1.ui.Label findLabel11() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label11", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label11", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer9(Component root) {
        return (com.codename1.ui.Container)findByName("Container9", root);
    }

    public com.codename1.ui.Container findContainer9() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container9", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container9", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.spinner.Picker findAddressPicker(Component root) {
        return (com.codename1.ui.spinner.Picker)findByName("addressPicker", root);
    }

    public com.codename1.ui.spinner.Picker findAddressPicker() {
        com.codename1.ui.spinner.Picker cmp = (com.codename1.ui.spinner.Picker)findByName("addressPicker", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.spinner.Picker)findByName("addressPicker", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findRevButton(Component root) {
        return (com.codename1.ui.Button)findByName("revButton", root);
    }

    public com.codename1.ui.Button findRevButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("revButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("revButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton1(Component root) {
        return (com.codename1.ui.Button)findByName("Button1", root);
    }

    public com.codename1.ui.Button findButton1() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel(Component root) {
        return (com.codename1.ui.Label)findByName("Label", root);
    }

    public com.codename1.ui.Label findLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer3(Component root) {
        return (com.codename1.ui.Container)findByName("Container3", root);
    }

    public com.codename1.ui.Container findContainer3() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer10(Component root) {
        return (com.codename1.ui.Container)findByName("Container10", root);
    }

    public com.codename1.ui.Container findContainer10() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container10", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container10", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer4(Component root) {
        return (com.codename1.ui.Container)findByName("Container4", root);
    }

    public com.codename1.ui.Container findContainer4() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container4", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container4", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextArea findTracksTextArea(Component root) {
        return (com.codename1.ui.TextArea)findByName("tracksTextArea", root);
    }

    public com.codename1.ui.TextArea findTracksTextArea() {
        com.codename1.ui.TextArea cmp = (com.codename1.ui.TextArea)findByName("tracksTextArea", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextArea)findByName("tracksTextArea", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer1(Component root) {
        return (com.codename1.ui.Container)findByName("Container1", root);
    }

    public com.codename1.ui.Container findContainer1() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer2(Component root) {
        return (com.codename1.ui.Container)findByName("Container2", root);
    }

    public com.codename1.ui.Container findContainer2() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer7(Component root) {
        return (com.codename1.ui.Container)findByName("Container7", root);
    }

    public com.codename1.ui.Container findContainer7() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container7", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container7", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer8(Component root) {
        return (com.codename1.ui.Container)findByName("Container8", root);
    }

    public com.codename1.ui.Container findContainer8() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container8", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container8", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer5(Component root) {
        return (com.codename1.ui.Container)findByName("Container5", root);
    }

    public com.codename1.ui.Container findContainer5() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container5", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container5", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findConnectButton(Component root) {
        return (com.codename1.ui.Button)findByName("connectButton", root);
    }

    public com.codename1.ui.Button findConnectButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("connectButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("connectButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer6(Component root) {
        return (com.codename1.ui.Container)findByName("Container6", root);
    }

    public com.codename1.ui.Container findContainer6() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container6", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container6", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findPlayForwardButton(Component root) {
        return (com.codename1.ui.Button)findByName("playForwardButton", root);
    }

    public com.codename1.ui.Button findPlayForwardButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("playForwardButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("playForwardButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer(Component root) {
        return (com.codename1.ui.Container)findByName("Container", root);
    }

    public com.codename1.ui.Container findContainer() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextArea findConsoleTextArea(Component root) {
        return (com.codename1.ui.TextArea)findByName("consoleTextArea", root);
    }

    public com.codename1.ui.TextArea findConsoleTextArea() {
        com.codename1.ui.TextArea cmp = (com.codename1.ui.TextArea)findByName("consoleTextArea", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextArea)findByName("consoleTextArea", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTextField(Component root) {
        return (com.codename1.ui.TextField)findByName("TextField", root);
    }

    public com.codename1.ui.TextField findTextField() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TextField", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TextField", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findMuteButton(Component root) {
        return (com.codename1.ui.Button)findByName("muteButton", root);
    }

    public com.codename1.ui.Button findMuteButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("muteButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("muteButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Tabs findTabs1(Component root) {
        return (com.codename1.ui.Tabs)findByName("Tabs1", root);
    }

    public com.codename1.ui.Tabs findTabs1() {
        com.codename1.ui.Tabs cmp = (com.codename1.ui.Tabs)findByName("Tabs1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Tabs)findByName("Tabs1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findPauseButton(Component root) {
        return (com.codename1.ui.Button)findByName("pauseButton", root);
    }

    public com.codename1.ui.Button findPauseButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("pauseButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("pauseButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.ComboBox findComboBox(Component root) {
        return (com.codename1.ui.ComboBox)findByName("ComboBox", root);
    }

    public com.codename1.ui.ComboBox findComboBox() {
        com.codename1.ui.ComboBox cmp = (com.codename1.ui.ComboBox)findByName("ComboBox", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.ComboBox)findByName("ComboBox", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findFfButton(Component root) {
        return (com.codename1.ui.Button)findByName("ffButton", root);
    }

    public com.codename1.ui.Button findFfButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("ffButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("ffButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findRadioButton(Component root) {
        return (com.codename1.ui.RadioButton)findByName("RadioButton", root);
    }

    public com.codename1.ui.RadioButton findRadioButton() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("RadioButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("RadioButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton7(Component root) {
        return (com.codename1.ui.Button)findByName("Button7", root);
    }

    public com.codename1.ui.Button findButton7() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button7", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button7", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findRecButton(Component root) {
        return (com.codename1.ui.Button)findByName("recButton", root);
    }

    public com.codename1.ui.Button findRecButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("recButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("recButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findVolUpButton(Component root) {
        return (com.codename1.ui.Button)findByName("volUpButton", root);
    }

    public com.codename1.ui.Button findVolUpButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("volUpButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("volUpButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.components.OnOffSwitch findOnOffSwitch(Component root) {
        return (com.codename1.components.OnOffSwitch)findByName("OnOffSwitch", root);
    }

    public com.codename1.components.OnOffSwitch findOnOffSwitch() {
        com.codename1.components.OnOffSwitch cmp = (com.codename1.components.OnOffSwitch)findByName("OnOffSwitch", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.components.OnOffSwitch)findByName("OnOffSwitch", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findVolDownButton(Component root) {
        return (com.codename1.ui.Button)findByName("volDownButton", root);
    }

    public com.codename1.ui.Button findVolDownButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("volDownButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("volDownButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findClearButton(Component root) {
        return (com.codename1.ui.Button)findByName("clearButton", root);
    }

    public com.codename1.ui.Button findClearButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("clearButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("clearButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel5(Component root) {
        return (com.codename1.ui.Label)findByName("Label5", root);
    }

    public com.codename1.ui.Label findLabel5() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label5", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label5", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel4(Component root) {
        return (com.codename1.ui.Label)findByName("Label4", root);
    }

    public com.codename1.ui.Label findLabel4() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label4", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label4", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel7(Component root) {
        return (com.codename1.ui.Label)findByName("Label7", root);
    }

    public com.codename1.ui.Label findLabel7() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label7", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label7", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel6(Component root) {
        return (com.codename1.ui.Label)findByName("Label6", root);
    }

    public com.codename1.ui.Label findLabel6() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label6", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label6", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findRadioButton9(Component root) {
        return (com.codename1.ui.RadioButton)findByName("RadioButton9", root);
    }

    public com.codename1.ui.RadioButton findRadioButton9() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("RadioButton9", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("RadioButton9", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findRadioButton7(Component root) {
        return (com.codename1.ui.RadioButton)findByName("RadioButton7", root);
    }

    public com.codename1.ui.RadioButton findRadioButton7() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("RadioButton7", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("RadioButton7", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findCfAddressTextField(Component root) {
        return (com.codename1.ui.TextField)findByName("cfAddressTextField", root);
    }

    public com.codename1.ui.TextField findCfAddressTextField() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("cfAddressTextField", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("cfAddressTextField", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findRadioButton8(Component root) {
        return (com.codename1.ui.RadioButton)findByName("RadioButton8", root);
    }

    public com.codename1.ui.RadioButton findRadioButton8() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("RadioButton8", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("RadioButton8", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextArea findTrackTextArea(Component root) {
        return (com.codename1.ui.TextArea)findByName("trackTextArea", root);
    }

    public com.codename1.ui.TextArea findTrackTextArea() {
        com.codename1.ui.TextArea cmp = (com.codename1.ui.TextArea)findByName("trackTextArea", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextArea)findByName("trackTextArea", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findRadioButton5(Component root) {
        return (com.codename1.ui.RadioButton)findByName("RadioButton5", root);
    }

    public com.codename1.ui.RadioButton findRadioButton5() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("RadioButton5", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("RadioButton5", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findTrackLabel(Component root) {
        return (com.codename1.ui.Label)findByName("trackLabel", root);
    }

    public com.codename1.ui.Label findTrackLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("trackLabel", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("trackLabel", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findRadioButton6(Component root) {
        return (com.codename1.ui.RadioButton)findByName("RadioButton6", root);
    }

    public com.codename1.ui.RadioButton findRadioButton6() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("RadioButton6", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("RadioButton6", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findPlayBackButton(Component root) {
        return (com.codename1.ui.Button)findByName("playBackButton", root);
    }

    public com.codename1.ui.Button findPlayBackButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("playBackButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("playBackButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findRadioButton3(Component root) {
        return (com.codename1.ui.RadioButton)findByName("RadioButton3", root);
    }

    public com.codename1.ui.RadioButton findRadioButton3() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("RadioButton3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("RadioButton3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel1(Component root) {
        return (com.codename1.ui.Label)findByName("Label1", root);
    }

    public com.codename1.ui.Label findLabel1() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findRadioButton4(Component root) {
        return (com.codename1.ui.RadioButton)findByName("RadioButton4", root);
    }

    public com.codename1.ui.RadioButton findRadioButton4() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("RadioButton4", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("RadioButton4", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findRadioButton1(Component root) {
        return (com.codename1.ui.RadioButton)findByName("RadioButton1", root);
    }

    public com.codename1.ui.RadioButton findRadioButton1() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("RadioButton1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("RadioButton1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel3(Component root) {
        return (com.codename1.ui.Label)findByName("Label3", root);
    }

    public com.codename1.ui.Label findLabel3() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findRadioButton2(Component root) {
        return (com.codename1.ui.RadioButton)findByName("RadioButton2", root);
    }

    public com.codename1.ui.RadioButton findRadioButton2() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("RadioButton2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("RadioButton2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel2(Component root) {
        return (com.codename1.ui.Label)findByName("Label2", root);
    }

    public com.codename1.ui.Label findLabel2() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.ComboBox findR2rComboBox(Component root) {
        return (com.codename1.ui.ComboBox)findByName("r2rComboBox", root);
    }

    public com.codename1.ui.ComboBox findR2rComboBox() {
        com.codename1.ui.ComboBox cmp = (com.codename1.ui.ComboBox)findByName("r2rComboBox", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.ComboBox)findByName("r2rComboBox", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findStopButton(Component root) {
        return (com.codename1.ui.Button)findByName("stopButton", root);
    }

    public com.codename1.ui.Button findStopButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("stopButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("stopButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findR2rStatusLabel(Component root) {
        return (com.codename1.ui.Label)findByName("r2rStatusLabel", root);
    }

    public com.codename1.ui.Label findR2rStatusLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("r2rStatusLabel", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("r2rStatusLabel", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findTapeIDLabel(Component root) {
        return (com.codename1.ui.Label)findByName("tapeIDLabel", root);
    }

    public com.codename1.ui.Label findTapeIDLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("tapeIDLabel", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("tapeIDLabel", aboutToShowThisContainer);
        }
        return cmp;
    }

    protected void exitForm(Form f) {
        if("Main".equals(f.getName())) {
            exitMain(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void exitMain(Form f) {
    }

    protected void beforeShow(Form f) {
    aboutToShowThisContainer = f;
        if("Main".equals(f.getName())) {
            beforeMain(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeMain(Form f) {
    }

    protected void beforeShowContainer(Container c) {
        aboutToShowThisContainer = c;
        if("Main".equals(c.getName())) {
            beforeContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeContainerMain(Container c) {
    }

    protected void postShow(Form f) {
        if("Main".equals(f.getName())) {
            postMain(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postMain(Form f) {
    }

    protected void postShowContainer(Container c) {
        if("Main".equals(c.getName())) {
            postContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postContainerMain(Container c) {
    }

    protected void onCreateRoot(String rootName) {
        if("Main".equals(rootName)) {
            onCreateMain();
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void onCreateMain() {
    }

    protected Hashtable getFormState(Form f) {
        Hashtable h = super.getFormState(f);
        if("Main".equals(f.getName())) {
            getStateMain(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

            return h;
    }


    protected void getStateMain(Form f, Hashtable h) {
    }

    protected void setFormState(Form f, Hashtable state) {
        super.setFormState(f, state);
        if("Main".equals(f.getName())) {
            setStateMain(f, state);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void setStateMain(Form f, Hashtable state) {
    }

    protected boolean setListModel(List cmp) {
        String listName = cmp.getName();
        if("ComboBox".equals(listName)) {
            return initListModelComboBox(cmp);
        }
        if("r2rComboBox".equals(listName)) {
            return initListModelR2rComboBox(cmp);
        }
        return super.setListModel(cmp);
    }

    protected boolean initListModelComboBox(List cmp) {
        return false;
    }

    protected boolean initListModelR2rComboBox(List cmp) {
        return false;
    }

    protected void handleComponentAction(Component c, ActionEvent event) {
        Container rootContainerAncestor = getRootAncestor(c);
        if(rootContainerAncestor == null) return;
        String rootContainerName = rootContainerAncestor.getName();
        Container leadParentContainer = c.getParent().getLeadParent();
        if(leadParentContainer != null && leadParentContainer.getClass() != Container.class) {
            c = c.getParent().getLeadParent();
        }
        if(rootContainerName == null) return;
        if(rootContainerName.equals("Main")) {
            if("connectButton".equals(c.getName())) {
                onMain_ConnectButtonAction(c, event);
                return;
            }
            if("trackTextArea".equals(c.getName())) {
                onMain_TrackTextAreaAction(c, event);
                return;
            }
            if("tracksTextArea".equals(c.getName())) {
                onMain_TracksTextAreaAction(c, event);
                return;
            }
            if("RadioButton".equals(c.getName())) {
                onMain_RadioButtonAction(c, event);
                return;
            }
            if("RadioButton1".equals(c.getName())) {
                onMain_RadioButton1Action(c, event);
                return;
            }
            if("RadioButton2".equals(c.getName())) {
                onMain_RadioButton2Action(c, event);
                return;
            }
            if("RadioButton3".equals(c.getName())) {
                onMain_RadioButton3Action(c, event);
                return;
            }
            if("RadioButton4".equals(c.getName())) {
                onMain_RadioButton4Action(c, event);
                return;
            }
            if("RadioButton5".equals(c.getName())) {
                onMain_RadioButton5Action(c, event);
                return;
            }
            if("RadioButton6".equals(c.getName())) {
                onMain_RadioButton6Action(c, event);
                return;
            }
            if("RadioButton7".equals(c.getName())) {
                onMain_RadioButton7Action(c, event);
                return;
            }
            if("RadioButton8".equals(c.getName())) {
                onMain_RadioButton8Action(c, event);
                return;
            }
            if("RadioButton9".equals(c.getName())) {
                onMain_RadioButton9Action(c, event);
                return;
            }
            if("ComboBox".equals(c.getName())) {
                onMain_ComboBoxAction(c, event);
                return;
            }
            if("volDownButton".equals(c.getName())) {
                onMain_VolDownButtonAction(c, event);
                return;
            }
            if("muteButton".equals(c.getName())) {
                onMain_MuteButtonAction(c, event);
                return;
            }
            if("volUpButton".equals(c.getName())) {
                onMain_VolUpButtonAction(c, event);
                return;
            }
            if("addressPicker".equals(c.getName())) {
                onMain_AddressPickerAction(c, event);
                return;
            }
            if("r2rComboBox".equals(c.getName())) {
                onMain_R2rComboBoxAction(c, event);
                return;
            }
            if("playBackButton".equals(c.getName())) {
                onMain_PlayBackButtonAction(c, event);
                return;
            }
            if("Button1".equals(c.getName())) {
                onMain_Button1Action(c, event);
                return;
            }
            if("playForwardButton".equals(c.getName())) {
                onMain_PlayForwardButtonAction(c, event);
                return;
            }
            if("revButton".equals(c.getName())) {
                onMain_RevButtonAction(c, event);
                return;
            }
            if("stopButton".equals(c.getName())) {
                onMain_StopButtonAction(c, event);
                return;
            }
            if("ffButton".equals(c.getName())) {
                onMain_FfButtonAction(c, event);
                return;
            }
            if("recButton".equals(c.getName())) {
                onMain_RecButtonAction(c, event);
                return;
            }
            if("Button7".equals(c.getName())) {
                onMain_Button7Action(c, event);
                return;
            }
            if("pauseButton".equals(c.getName())) {
                onMain_PauseButtonAction(c, event);
                return;
            }
            if("TextField".equals(c.getName())) {
                onMain_TextFieldAction(c, event);
                return;
            }
            if("cfAddressTextField".equals(c.getName())) {
                onMain_CfAddressTextFieldAction(c, event);
                return;
            }
            if("clearButton".equals(c.getName())) {
                onMain_ClearButtonAction(c, event);
                return;
            }
            if("consoleTextArea".equals(c.getName())) {
                onMain_ConsoleTextAreaAction(c, event);
                return;
            }
        }
    }

      protected void onMain_ConnectButtonAction(Component c, ActionEvent event) {
      }

      protected void onMain_TrackTextAreaAction(Component c, ActionEvent event) {
      }

      protected void onMain_TracksTextAreaAction(Component c, ActionEvent event) {
      }

      protected void onMain_RadioButtonAction(Component c, ActionEvent event) {
      }

      protected void onMain_RadioButton1Action(Component c, ActionEvent event) {
      }

      protected void onMain_RadioButton2Action(Component c, ActionEvent event) {
      }

      protected void onMain_RadioButton3Action(Component c, ActionEvent event) {
      }

      protected void onMain_RadioButton4Action(Component c, ActionEvent event) {
      }

      protected void onMain_RadioButton5Action(Component c, ActionEvent event) {
      }

      protected void onMain_RadioButton6Action(Component c, ActionEvent event) {
      }

      protected void onMain_RadioButton7Action(Component c, ActionEvent event) {
      }

      protected void onMain_RadioButton8Action(Component c, ActionEvent event) {
      }

      protected void onMain_RadioButton9Action(Component c, ActionEvent event) {
      }

      protected void onMain_ComboBoxAction(Component c, ActionEvent event) {
      }

      protected void onMain_VolDownButtonAction(Component c, ActionEvent event) {
      }

      protected void onMain_MuteButtonAction(Component c, ActionEvent event) {
      }

      protected void onMain_VolUpButtonAction(Component c, ActionEvent event) {
      }

      protected void onMain_AddressPickerAction(Component c, ActionEvent event) {
      }

      protected void onMain_R2rComboBoxAction(Component c, ActionEvent event) {
      }

      protected void onMain_PlayBackButtonAction(Component c, ActionEvent event) {
      }

      protected void onMain_Button1Action(Component c, ActionEvent event) {
      }

      protected void onMain_PlayForwardButtonAction(Component c, ActionEvent event) {
      }

      protected void onMain_RevButtonAction(Component c, ActionEvent event) {
      }

      protected void onMain_StopButtonAction(Component c, ActionEvent event) {
      }

      protected void onMain_FfButtonAction(Component c, ActionEvent event) {
      }

      protected void onMain_RecButtonAction(Component c, ActionEvent event) {
      }

      protected void onMain_Button7Action(Component c, ActionEvent event) {
      }

      protected void onMain_PauseButtonAction(Component c, ActionEvent event) {
      }

      protected void onMain_TextFieldAction(Component c, ActionEvent event) {
      }

      protected void onMain_CfAddressTextFieldAction(Component c, ActionEvent event) {
      }

      protected void onMain_ClearButtonAction(Component c, ActionEvent event) {
      }

      protected void onMain_ConsoleTextAreaAction(Component c, ActionEvent event) {
      }

}
