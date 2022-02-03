package com.framework.utility;

import java.io.File;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	//Handle Screenshots , alerts, frames, windows , Sync issue, javascript executor
	
	public static String captureScreenshot(WebDriver driver) {
		String screenshotPath = System.getProperty("user.dir")+"/ScreenShots/CRMPRO"+getCurrentDateTime()+".png";
		
		try
		{
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File(screenshotPath));
		}
		catch(Exception e)
		{
			System.out.println("Unable to capture the screenshot"+ e.getMessage());
		
		}
		return screenshotPath;
	}
	
	public static String getCurrentDateTime() {
		DateFormat currentFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		
		return currentFormat.format(currentDate);
		
	}
}
