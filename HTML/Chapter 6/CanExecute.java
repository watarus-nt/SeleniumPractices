package com.packt.webdriver.chapter6;

import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class CanExecute {
	public static void main(String... args){
		try {
			System.out.println(FileHandler.canExecute(new File("C:\\Src\\file1.txt")));
			FileHandler.makeExecutable(new File("C:\\Src\\file1.txt"));
			System.out.println(FileHandler.canExecute(new File("C:\\Src\\file1.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
