package com.framework.utility;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrowserFactory {

    public static WebDriver startApplication(WebDriver driver, String browserName, String appUrl){
        if(browserName.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver");
            driver = new ChromeDriver();

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
