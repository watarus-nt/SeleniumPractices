package com.packt.webdriver.practicalGuide.chapter4;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxProfile {
	
	public static void main(String... args) {
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
	}

}
