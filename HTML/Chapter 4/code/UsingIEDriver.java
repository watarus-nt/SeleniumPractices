package com.packt.webdriver.practicalGuide.chapter4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class UsingIEDriver {

	public static void main(String... args) {
		System.setProperty("webdriver.ie.driver",
				"C:\\IEDriverServer_Win32_2.35.3\\IEDriverServer.exe");

		DesiredCapabilities ieCapabilities = DesiredCapabilities
				.internetExplorer();
		ieCapabilities
				.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
		WebDriver driver = new InternetExplorerDriver(ieCapabilities);
		driver.get("http://www.google.com");
	}
}
