package com.packt.webdriver.chapter10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class AppiumAndroid {
public static void main(String... args){
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("device", "Android");
		desiredCapabilities.setCapability("app", "chrome");  
		
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
		ele.sendKeys("Packt Publishing");
		
		WebElement searchButton = remoteWebDriver.findElement(By.name("btnG"));
		System.out.println(searchButton.getSize());
		searchButton.click();
		
		remoteWebDriver.quit();
	}
}

