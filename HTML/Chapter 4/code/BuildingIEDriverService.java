package com.packt.webdriver.practicalGuide.chapter4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BuildingIEDriverService {
	public static void main(String... args){
		System.setProperty("webdriver.ie.driver",
				"C:\\IEDriverServer_Win32_2.35.3\\IEDriverServer.exe");
		
		InternetExplorerDriverService.Builder builder 
			      = new InternetExplorerDriverService.Builder();
		
		InternetExplorerDriverService srvc = builder.usingPort(5555).withHost("127.0.0.1").build();
		
		DesiredCapabilities ieCapabilities = DesiredCapabilities
				.internetExplorer();
		ieCapabilities
				.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
		
		WebDriver driver = new InternetExplorerDriver(srvc, ieCapabilities);
		driver.get("http://www.google.com");
		driver.quit();
	}
}
