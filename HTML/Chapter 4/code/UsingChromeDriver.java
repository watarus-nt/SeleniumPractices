package com.packt.webdriver.practicalGuide.chapter4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingChromeDriver {
	public static void main(String... args){
		System.setProperty("webdriver.chrome.driver", 
				"C:\\chromedriver_win32_2.2\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Chrome Driver");
	}
}
