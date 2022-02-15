# CassetteFlowOne
A simple [CodenameOne](https://cloud.codenameone.com/) base mobile application 
for connecting to the CassetteFlow system currently under development using the 
[ESP32LyraT](https://github.com/ns96/cassetteflow) audio board and 
[Desktop Java](https://github.com/ns96/cassetteflowJava). It also provides basic
functionality for the control of a Teac A-2300SD (or similar) Reel To Reel tape deck.

![Main GUI](cfo01.png)

## Installation
Here are the key steps to [Side Load](https://www.digitaltrends.com/mobile/how-to-sideload-an-apk/) 
the app on Android devices. Once side loading has been activated here are 
the steps to install and run application.

1. Download the latest APK file from [here](https://github.com/ns96/CassetteFlowOne/releases/download/v0.2.13/CassetteFlow-release.apk). 
2. Confirm installation and lunch application. 
3. Allow application to use device location (needed for bluetooth connections).
4. In the application, select the “R2R” tab and wait for, then click on “...” to select “H3 || ******” then press OK.
5. If connection is successful the application show return to the main screen showing status “CONNECTED”. 
The RED led on the SH-H3 module should also be solid, instead on blinking.
6. Now use the buttons to control the deck. All functions work like the physical buttons, 
except
    - When FF or REV, the “PLAY” button can be pressed directly without first pressing the “STOP” button like when using the keys on the deck.  
    - Pressing the “REC” button simple arms the device (same as pressing the PAUSE and REC keys on deck). “PLAY” must then be pressed to start recording. 

