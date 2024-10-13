package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	
	
	 private static Properties properties = new Properties();

	    static {
	        try {
	            FileInputStream configStream = new FileInputStream("src/test/resources/config.properties");
	            properties.load(configStream);
	           String url = properties.getProperty("base.url");
	           String urlend = properties.getProperty("auth.controller.endpoint");
	           System.out.println("URL: " + url);
	           System.out.println("URL: " + urlend);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static String getUrl(String key) {
	        return properties.getProperty(key);
	    }

}
