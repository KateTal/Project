package testcases;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class AddCustomerTest extends TestBase {

	@Test (dataProviderClass=TestUtil.class, dataProvider="dp")
	public void addCustomerTest(String firstName, String lastName, String postCode, String alerttext) { //перечисляем в скобках колонки
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
		

		log.debug("test Add Customer fullfiled");

		
	}
    
    	
	}
	
	

