package com.packt.webdriver.chapter10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class AppiumiOS {
	public static void main(String... args){
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("device", "iPhone Simulator");
		desiredCapabilities.setCapability("version", "7.0");
		desiredCapabilities.setCapability("app", "safari");  
		URL url = null;
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		WebDriver remoteWebDriver = new RemoteWebDriver(url, desiredCapabilities);
		remoteWebDriver.get("http://www.google.com");
		WebElement ele = remoteWebDriver.findElement(By.name("q"));
		ele.click();
		ele.sendKeys("This is a test");	
		WebElement searchButton = remoteWebDriver.findElement(By.name("btnG"));
		System.out.println(searchButton.getSize());
		searchButton.click();
		
		remoteWebDriver.quit();
	}
}

