package com.w2a.rough;


import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		
		//создать объект класса Properties
		Properties config = new Properties();
		//FileInputStream fis = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\DataDrivenFramework\\src\\test\\resources\\properties\\Config.properties");
	// либо чтобы точно не поехала папка
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
	// загрузить файл
		config.load(fis);
		
		//тоже самое для второго файла OR
		Properties OR = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
		
		
		System.out.println(config.getProperty("browser"));
		System.out.println(OR.getProperty("bmlBtn"));
	
	}
}
