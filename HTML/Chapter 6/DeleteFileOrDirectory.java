package com.packt.webdriver.chapter6;

import org.openqa.selenium.io.FileHandler;

import java.io.File;

public class DeleteFileOrDirectory {	
	public static void main(String... args){
		FileHandler.delete(new File("C:\\SelDir\\"));
	}
}
