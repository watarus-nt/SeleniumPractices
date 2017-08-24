package com.packt.webdriver.chapter6;

import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ReadFileAsString {
	public static void main(String... args){
		try {
			String fileContent = FileHandler.readAsString(new File("C:\\Src\\file1.txt"));
			System.out.println(fileContent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
