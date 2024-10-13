package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {	
// function to load  config.properties file	
	 private static Properties properties = new Properties();

	    static {
	        try {
	            FileInputStream configStream = new FileInputStream("src/test/resources/config.properties");
	            properties.load(configStream);       
	           
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static String getUrl(String key) {
	        return properties.getProperty(key);
	    }

}
