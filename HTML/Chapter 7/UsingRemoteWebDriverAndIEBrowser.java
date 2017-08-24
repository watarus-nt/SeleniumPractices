package com.packt.webdriver.chapter7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class UsingRemoteWebDriverAndIEBrowser {
	public static void main(String... args){
		DesiredCapabilities capabilities =  new DesiredCapabilities();
		capabilities.setBrowserName("internet explorer");
		RemoteWebDriver remoteWD = null;
		try {
			remoteWD = 
					new RemoteWebDriver(new URL("http://<remotewebdriver-server-ip>:4444/wd/hub"),capabilities);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		remoteWD.get("http://www.google.com");
		WebElement element = remoteWD.findElement(By.name("q"));
		element.sendKeys("Packt Publishing");
	}
}
