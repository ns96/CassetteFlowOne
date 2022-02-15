package com.instras;

/**
 * Stores information about the MP3 file loaded from the server
 * 
 * @author Nathan
 */
public class AudioInfo {
    private String hash10C;
    private String filename;
    private int length;
    private String lengthAsTime;
    private int bitRate;
    private String parentDirectoryName = "";
    
    public AudioInfo(String filename, String hash10C, int length, String lengthAsTime, int bitRate) {
        this.filename = filename;
        this.hash10C = hash10C;
        this.length = length;
        this.lengthAsTime = lengthAsTime;
        this.bitRate = bitRate;
    }

    public String getHash10C() {
        return hash10C;
    }

    public String getFilename() {
        return filename;
    }

    public int getLength() {
        return length;
    }
    
    public String getLengthAsTime() {
        return lengthAsTime;
    }
    
    public int getBitRate() {
        return bitRate;
    }
    
    public String getName() {
        return filename + " (" + lengthAsTime + ")";
    }
    
    @Override
    public String toString() {
        return getName();
    }
}
