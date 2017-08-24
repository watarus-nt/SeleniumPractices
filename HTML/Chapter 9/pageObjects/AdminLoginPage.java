package com.packt.webdriver.chapter9.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage{
	WebDriver driver;
	@FindBy(how=How.ID, using="user_login")
	WebElement email;

	@FindBy(how=How.ID, using="user_pass")
	WebElement password;
	
	@FindBy(how=How.ID, using="wp-submit")
	WebElement submit;

    	
	public AdminLoginPage(WebDriver driver){
		this.driver = driver;
		driver.get("http://pageobjectpattern.wordpress.com/wp-admin");
	}
	
	public AllPostsPage login(){
		email.sendKeys("pageobjectpattern@gmail.com");
		password.sendKeys("webdriver123");
		submit.click();
		return PageFactory.initElements(driver, 
				AllPostsPage.class);
	}
}
