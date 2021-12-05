package com.w2a.testcases;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class BankManagerLoginTest extends TestBase {

	@Test
	public void loginAsBankManger() throws InterruptedException {
	
		//Assert.assertEquals("abc", "xyz");
		log.debug("Inside loginTest");
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(OR.getProperty("bmlBtn")))).click();
		
		//Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustEbtn"))),"Login not successful");
		
		log.debug("Login executed");
		
	
		
		//Assert.fail("Login failed");
		
		
		
	
	}
	
	
}
