package com.packt.webdriver.chapter8;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TestScriptWithSleepTimeMorethanNodeTime {
	public static void main(String... args){
		  DesiredCapabilities capabilities 
	      = new DesiredCapabilities();
		  capabilities.setPlatform(Platform.MAC);
		  capabilities.setBrowserName("chrome");
		  RemoteWebDriver remoteWD = null;
		  try {
			  	remoteWD = new RemoteWebDriver(
			  			new URL("http://172.16.87.131:1111/wd/hub"),
			  			capabilities);
		  } catch (MalformedURLException e) {
			  e.printStackTrace();
		  }
		  remoteWD.get("http://www.google.com");
		  try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		  remoteWD.quit();	  
	  }
}
