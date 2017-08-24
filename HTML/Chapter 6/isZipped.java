package com.packt.webdriver.chapter6;

import org.openqa.selenium.io.FileHandler;

public class isZipped {
	public static void main(String... args){
		System.out.println(FileHandler.isZipped("C:\\Dest.zip"));
	}
}
