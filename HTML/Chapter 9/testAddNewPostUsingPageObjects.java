package com.packt.webdriver.chapter9;

import com.packt.webdriver.chapter9.pageObjects.AdminLoginPage;
import com.packt.webdriver.chapter9.pageObjects.AllPostsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class testAddNewPostUsingPageObjects {
	public static void main(String... args){
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32_2.2\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		AdminLoginPage loginPage = PageFactory.initElements(driver, 
				AdminLoginPage.class);	
		AllPostsPage allPostsPage = loginPage.login();
		
		allPostsPage.createANewPost("Creating New Post using PageObjects", 
				"Its good to use PageObjects");		
	}
}
