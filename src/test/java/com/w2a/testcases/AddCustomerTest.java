package com.w2a.testcases;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class AddCustomerTest extends TestBase {

	@Test (dataProvider="getData")
	public void addCustomer(String firstName, String lastName, String postCode, String alerttext) { //перечисляем в скобках колонки
	//нажать на кнопку addCustomer
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/button[1]"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/div[1]/input"))).sendKeys(firstName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/div[2]/input"))).sendKeys(lastName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/div[3]/input"))).sendKeys(postCode);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/button"))).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(alerttext));
		alert.accept();//нажимается кнопка ок. принять тоесть
		
	}
    @DataProvider //создаем дата провайдер
	public Object[][] getData(){
		
    	String sheetName = "AddCustomerTest";
    	int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];//ряд -1 тк первый ряд шапка, 2 ряда 3 колонки
		
		for(int rowNum=2; rowNum<=rows; rowNum++) {//логика дата провайдера - начнет читать со второй строки, тк первая шапка
			for(int colNum = 0; colNum<cols; colNum++) {//затем читает колонки, нулевая колонка это самая первая
				
				//data[0][0] then data [0][1] etc
			data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
			}
			
		}
		
		return data; 
	}

    	
    	
	}
	
	

