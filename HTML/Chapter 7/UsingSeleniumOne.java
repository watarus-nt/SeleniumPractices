package com.packt.webdriver.chapter7;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class UsingSeleniumOne {
	public static void main(String... args){
		Selenium sel = new DefaultSelenium("localhost",4444,"*firefox",
				"http://www.google.com");
		sel.start();
		sel.open("http://www.google.com.au/");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sel.type("name=q", "Packt Publishing");
		sel.click("name=btnG");;
		
	}

}
