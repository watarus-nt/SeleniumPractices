package com.packt.webdriver.chapter9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testAddNewPost {
   public static void main(String... args) {
	   WebDriver driver = new FirefoxDriver();
	   
	   // Login to Admin portal
	   driver.get("http://pageobjectpattern.wordpress.com/wp-admin");
	   WebElement email = driver.findElement(By.id("user_login"));
	   WebElement pwd = driver.findElement(By.id("user_pass"));
	   WebElement submit = driver.findElement(By.id("wp-submit"));
	   email.sendKeys("pageobjectpattern@gmail.com");
	   pwd.sendKeys("webdriver123");
	   submit.click();	   
	   
	   // Go to New Posts page
	   driver.get("http://pageobjectpattern.wordpress.com/wp-admin/edit.php");
	   WebElement addNewPost = driver.findElement(By.linkText("Add New"));
	   addNewPost.click();
	   
	   // Add New Post
	   driver.switchTo().frame("content_ifr");
	   WebElement postBody = driver.findElement(By.id("tinymce"));
	   postBody.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
	   		"Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
	   		"when an unknown printer took a galley of type and scrambled it to make a type " +
	   		"specimen book. It has survived not only five centuries, but also the leap into " +
	   		"electronic typesetting, remaining essentially unchanged. " +
	   		"It was popularised in the 1960s with the release of Letraset sheets containing " +
	   		"Lorem Ipsum passages, and more recently with desktop publishing software like " +
	   		"Aldus PageMaker including versions of Lorem Ipsum.");
	   
	   driver.switchTo().defaultContent();
	   WebElement title = driver.findElement(By.id("title"));
	   title.click();
	   title.sendKeys("My First Post");
	   WebElement publish = driver.findElement(By.id("publish"));
	   publish.click();
	   
   }
}
