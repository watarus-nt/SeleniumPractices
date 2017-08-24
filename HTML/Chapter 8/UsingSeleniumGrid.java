package com.packt.webdriver.chapter8;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class UsingSeleniumGrid {
  public static void main(String... args){
	  DesiredCapabilities capabilities 
      = new DesiredCapabilities();
	  capabilities.setPlatform(Platform.MAC);
	  capabilities.setBrowserName("firefox");
	  RemoteWebDriver remoteWD = null;
	  try {
		  	remoteWD = new RemoteWebDriver(
		  			new URL("http://172.16.87.131:1111/wd/hub"),
		  			capabilities);
	  } catch (MalformedURLException e) {
		  e.printStackTrace();
	  }
	  remoteWD.get("http://www.google.com");
	  WebElement element = remoteWD.findElement(By.name("q"));
	  element.sendKeys("Packt Publishing");
	  try {
		Thread.sleep(60000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	  remoteWD.quit();	  
  }
}
