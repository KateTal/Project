package testcases;


import base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import utilities.TestUtil;


public class OpenAccountTest extends TestBase {
	WebElement dropdown;
	@Test (dataProviderClass= TestUtil.class, dataProvider="dp")
	public void openAccountTest(String customer, String currency, String alerttext) {

		
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(OR.getProperty("bmlBtn")))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/button[2]"))).click();


		dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"userSelect\"]")));
		Select select = new Select(dropdown);
		select.selectByVisibleText(customer);
		
		dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"currency\"]")));
		select = new Select(dropdown);

		select.selectByVisibleText(currency);
		
		
		

		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(OR.getProperty("process_CSS")))).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(alerttext));
		alert.accept();//нажимается кнопка ок. принять тоесть

		Assert.fail();
}

}
