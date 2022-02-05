package com.framework.utility;

import org.jetbrains.annotations.NotNull;
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
	
	public String getUrl(@NotNull String env) {
		if (env.equals("qa")) {
			return pro.getProperty("qaUrl");
		} else if (env.equals("uat")) {
			return pro.getProperty("uatUrl");
		}else{
			System.out.println("Url not found");
			return "URl not found";
		}
	}

}
