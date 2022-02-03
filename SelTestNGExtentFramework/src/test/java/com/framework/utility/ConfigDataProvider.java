package com.framework.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	public ConfigDataProvider() {
		
		try {
			File configSrc = new File("./Config/Config.properties");
			FileInputStream configFis = new FileInputStream(configSrc);
			pro = new Properties();
			pro.load(configFis);
		}
		catch(Exception e)
		{
			System.out.println("Unable to load configuration file"+ e.getMessage());
		}
	}
	
	public String getDataFromConfig(String propertyKey) {
		return pro.getProperty(propertyKey);
		
	}
	
	public String getBrowser() {
		return pro.getProperty("Browser");
		
	}
	
	public String getUrl() {
		return pro.getProperty("qaUrl");
	}

}
