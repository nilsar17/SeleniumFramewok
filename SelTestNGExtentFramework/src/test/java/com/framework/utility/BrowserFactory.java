package com.framework.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;
import java.util.Set;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;


public class BrowserFactory {

    public static WebDriver startApplication(WebDriver driver, String browserName, String appUrl) throws MalformedURLException {
        if(browserName.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver");
            URL remoteUrl = new URL("http://localhost:4444/wd/hub");
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new RemoteWebDriver(remoteUrl, chromeOptions);

        }else if (browserName.equals("Firefox")){
            System.out.println("We do not support Firefox");

        }else if(browserName.equals("IE")){
            System.out.println("We do not support Firefox");

        }else {
            System.out.println("We do not support Firefox");
        }

        //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appUrl);
        //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        return driver;
    }

    public static void switchTab(WebDriver driver, String tabTitle) {
    	String pageTitle;
    	
    	Set<String> handles = driver.getWindowHandles();
		for (String currentHandle : handles) {
			pageTitle = driver.switchTo().window(currentHandle).getTitle();
			if (pageTitle.equals(tabTitle)){
				break;
			}
		}
    }
    public static void quitBrowser(WebDriver driver){
        driver.quit();
    }

}
