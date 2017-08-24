package com.packt.webdriver.chapter6;

import org.openqa.selenium.io.TemporaryFilesystem;

import java.io.File;

public class DefaultTemporaryFileSystem {
	public static void main(String... args) {
		File f = TemporaryFilesystem.getDefaultTmpFS()
				.createTempDir("prefix", "suffix");
		System.out.println(f.getAbsolutePath());
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
