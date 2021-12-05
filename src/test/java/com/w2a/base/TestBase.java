package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.utilities.ExcelReader;







public class TestBase {

	/* �� ������ ��������� ������ ���������������� ��� ���������:
	 * WebDriver
	 * Properties
	 * Logs
	 * ExtentReports
	 * DataBase part
	 * Excel part
	 * Mail part
	 * 
	 * 
	 */
	public static WebDriver driver; // 4 ������� ���������� � � ����� Config.properties  ����� �� ������� ����� �������� browser = chrome, ��� �������� ����� �������� ���� ������� ���������(�����) 
	public static Properties config = new Properties();//��������� �� ������ TestProperties � �������� public static 
	public static Properties OR = new Properties();//��������� �� ������ TestProperties � �������� public static
    public static FileInputStream fis;
    public static Logger log = Logger.getLogger("devpinoyLogger");//apache log4j...
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	
	
	
	
	
	@BeforeSuite //�� ������� ������ ����� ������ �������������� ����� ����� ����������� �� �����,  1.add testng library, 2.import....
	public void setUp() {
		if (driver==null) {
			//���� ������� �� ��������� �� ���� � ����������, �������� ��� TestProperties
			
			//FileInputStream fis; ������� �� ������� ��� ����������������
			try {
				fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    try {
				config.load(fis);
				log.debug("Config file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    try {
				fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//���� ������ �������� ��� ������������� ����-���, ������ ���������� �������
			// � �������� ��� �������� ������� ����� � ����� resourses/executables, ������ �� ����� �������� � ������ ���������� � � ������� �������� ����� paste
			
			
			if(config.getProperty("browser").equals("firefox")) {
				
				//  ���� ������ ������ ������ ���System.setProperty("webdriver.gecko.driver", "gecko.exe");
				// ���� ����� �� ����� ���
				driver = new FirefoxDriver();
			} else if(config.getProperty("browser").equals("chrome")) {
				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
				log.debug("Chrome launched");
			} else if(config.getProperty("browser").equals("ie")) {
				
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			
			driver.get(config.getProperty("testsiteurl"));
			log.debug("Navigated to:"+ config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
		}
		
	}
	public boolean isElementPresent(By by) {
		
		try {
		driver.findElement(by);
		return true;
		
	} catch(NoSuchElementException e) {
		
		return false;
	}
	
	}
	
	@AfterSuite // 3.���������������� ����� ���������� ���� ����������
	public void tearDown() {
		
		//if(driver!=null) {
			
		//driver.quit();
		//}
		
		log.debug("test complited");
	}
	
}
