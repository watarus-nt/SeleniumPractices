package com.packt.webdriver.chapter6;

import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class CopyResource {
	public static void main(String... args){
		try {
			FileHandler.copyResource(new File("C:\\Dest\\"), FileHandler.class, "C:\\Src\\selenium.jar");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
