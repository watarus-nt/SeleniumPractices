package com.packt.webdriver.chapter9.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DeletePostPage {
WebDriver driver;
	
	@FindBy(how=How.LINK_TEXT, using="Move to Trash")
	WebElement moveToTrash;
	
	public DeletePostPage(WebDriver driver){
		this.driver = driver;
		System.out.println(driver.getCurrentUrl());
	}
	
	public void delete(){
		moveToTrash.click();
	}
}
