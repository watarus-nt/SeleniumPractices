package com.packt.webdriver.practicalGuide.chapter2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveByOffSet {
	public static void main(String... args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("file://C:/Selectable.html");
		WebElement three = driver.findElement(By.name("three"));
		System.out.println("X coordinate: " + three.getLocation().getX()
				+ "  Y coordinate: " + three.getLocation().getY());
		Actions builder = new Actions(driver);
		builder.moveByOffset(three.getLocation().getX() + 1, three
				.getLocation().getY() + 1);
		builder.perform();
	}
}
