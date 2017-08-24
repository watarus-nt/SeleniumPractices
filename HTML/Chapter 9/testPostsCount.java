package com.packt.webdriver.chapter9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class testPostsCount {
	public static void main(String... args){
		WebDriver driver = new FirefoxDriver();
		   
		   // Login to Admin portal
		   driver.get("http://pageobjectpattern.wordpress.com/wp-admin");
		   WebElement email = driver.findElement(By.id("user_login"));
		   WebElement pwd = driver.findElement(By.id("user_pass"));
		   WebElement submit = driver.findElement(By.id("wp-submit"));
		   email.sendKeys("pageobjectpattern@gmail.com");
		   pwd.sendKeys("webdriver123");
		   submit.click();	   
		   
		   // Go to a Particular Post page
		   driver.get("http://pageobjectpattern.wordpress.com/wp-admin/edit.php");
		   WebElement postsContainer = driver.findElement(By.id("the-list"));
		   List postsList = postsContainer.findElements(By.tagName("tr"));
           System.out.println(postsList.size());   
	}
}
