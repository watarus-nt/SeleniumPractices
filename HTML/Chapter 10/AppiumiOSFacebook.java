package com.packt.webdriver.chapter10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class AppiumiOSFacebook {
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
		remoteWebDriver.get("http://www.facebook.com");
		System.out.println("The current url is: "+remoteWebDriver.getCurrentUrl());
		
		WebElement email = remoteWebDriver.findElement(By.name("email"));
		WebElement password = remoteWebDriver.findElement(By.name("pass"));
		WebElement login = remoteWebDriver.findElement(By.name("login"));
		
		email.sendKeys("test.appium@gmail.com");
		password.sendKeys("123456");
		login.click();
		
		remoteWebDriver.quit();
	}

}

