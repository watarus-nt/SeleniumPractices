package com.packt.webdriver.chapter6;

import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class CopyFromSrcToDestDir {
	public static void main(String... args){
		try {
			FileHandler.copy(new File("C:\\Src\\"), new File("C:\\Dest\\"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
