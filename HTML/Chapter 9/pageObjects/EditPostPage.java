package com.packt.webdriver.chapter9.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditPostPage {
WebDriver driver;
	
	@FindBy(how=How.ID, using="content_ifr")
	WebElement newPostContentFrame;
	
	@FindBy(how=How.ID, using="tinymce")
	WebElement newPostContentBody;
	
	@FindBy(how=How.ID, using="title")
	WebElement newPostTitle;
	
	@FindBy(how=How.ID, using="publish")
	WebElement newPostPublish;
	
	public EditPostPage(WebDriver driver){
		this.driver = driver;
		System.out.println(driver.getCurrentUrl());
	}
	
	public void editPost(String title, String descContent){
		 driver.switchTo().frame(newPostContentFrame);
		 newPostContentBody.clear();
		 newPostContentBody.sendKeys(descContent);
		   
		 driver.switchTo().defaultContent();
		 newPostTitle.click();
		 newPostTitle.clear();
		 newPostTitle.sendKeys(title);
		 
		 newPostPublish.click();
	}

}
