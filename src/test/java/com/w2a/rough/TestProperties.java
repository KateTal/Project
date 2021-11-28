package com.w2a.rough;


import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		
		//������� ������ ������ Properties
		Properties config = new Properties();
		//FileInputStream fis = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\DataDrivenFramework\\src\\test\\resources\\properties\\Config.properties");
	// ���� ����� ����� �� ������� �����
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
	// ��������� ����
		config.load(fis);
		
		//���� ����� ��� ������� ����� OR
		Properties OR = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
		
		
		System.out.println(config.getProperty("browser"));
		System.out.println(OR.getProperty("bmlBtn"));
	
	}
}
