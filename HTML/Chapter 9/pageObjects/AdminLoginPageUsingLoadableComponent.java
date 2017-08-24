package com.packt.webdriver.chapter9.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class AdminLoginPageUsingLoadableComponent extends LoadableComponent<AdminLoginPageUsingLoadableComponent>{
	WebDriver driver;
	@FindBy(how=How.ID, using="user_login")
	WebElement email;

	@FindBy(how=How.ID, using="user_pass")
	WebElement password;
	
	@FindBy(how=How.ID, using="wp-submit")
	WebElement submit;

    	
	public AdminLoginPageUsingLoadableComponent(WebDriver driver){
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	public AllPostsPage login(){
		email.sendKeys("pageobjectpattern@gmail.com");
		password.sendKeys("webdriver123");
		submit.click();
		return PageFactory.initElements(driver, 
				AllPostsPage.class);
	}

	@Override
	protected void load() {
		driver.get("http://pageobjectpattern.wordpress.com/wp-admin");
	}

	@Override
	protected void isLoaded() throws Error {
		Assert.assertTrue(driver.getCurrentUrl().contains("wp-admin"));
	}
}
