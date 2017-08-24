package com.packt.webdriver.chapter6;

import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class CreateDirectory {
	public static void main(String... args){
		try {
			FileHandler.createDir(new File("C:\\SelDir"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
