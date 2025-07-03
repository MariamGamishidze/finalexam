package oop.finalexam.t3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private String serverUrl;
    private String botName;
    
    public ConfigManager(String configPath) throws IOException {
        Properties props = new Properties();
        
        // Try multiple possible paths for the config file
        String[] possiblePaths = {
            configPath,                    // Current directory
            "../" + configPath,           // Parent directory  
            "../../" + configPath,        // Two levels up
            "../../../" + configPath      // Three levels up
        };
        
        FileInputStream fis = null;
        IOException lastException = null;
        
        for (String path : possiblePaths) {
            try {
                fis = new FileInputStream(path);
                System.out.println("Found config file at: " + path);
                break;
            } catch (IOException e) {
                lastException = e;
                // Continue to next path
            }
        }
        
        if (fis == null) {
            System.err.println("Could not find config.properties in any of these locations:");
            for (String path : possiblePaths) {
                System.err.println("  - " + path);
            }
            throw new IOException("Could not find " + configPath + " in any expected location", lastException);
        }
        
        try {
            props.load(fis);
            this.serverUrl = props.getProperty("server.url");
            this.botName = props.getProperty("bot.name");
        } finally {
            fis.close();
        }
    }
    
    public String getServerUrl() { return serverUrl; }
    public String getBotName() { return botName; }
}