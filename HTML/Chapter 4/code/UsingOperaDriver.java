package com.packt.webdriver.practicalGuide.chapter4;

import com.opera.core.systems.OperaDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsingOperaDriver {
	public static void main(String... args){
		  System.setProperty("os.name","windows"); 
		  System.setProperty("opera.binary", "C:\\Program Files\\Opera\\opera.exe");
		  WebDriver driver = new OperaDriver();
		  driver.get("http://www.google.com");
		  driver.findElement(By.name("q")).sendKeys("Packt Publishing");
		  driver.findElement(By.name("btnG")).click();
		  driver.quit();
	  }
}
