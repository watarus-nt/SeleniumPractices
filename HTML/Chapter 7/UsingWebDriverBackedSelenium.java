package com.packt.webdriver.chapter7;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsingWebDriverBackedSelenium {
	public static void main(String... args){
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://www.google.com.au/";
		Selenium sel = new WebDriverBackedSelenium(driver, baseUrl);
		
		sel.open("http://www.google.com.au/");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sel.type("name=q", "Packt Publishing");
		sel.click("name=btnG");;		
	}
}
