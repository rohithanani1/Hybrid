package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class HomePge {

	static WebDriver driver;
	ExtentTest logger;
	ExtentReports extent;
	String ScreenShotPath;
	String TestScriptName;

	@Test
	
	public void HomePge(WebDriver driver, String TestScriptName, ExtentTest logger, ExtentReports extent) {
		this.driver =driver;
		this.extent = extent;
		this.logger=logger;
		this.TestScriptName=TestScriptName;
		
	}
	
		
		public void MyHomePage(String Firstname,String Lastname,String Username,String Password,String Conform) throws Exception
		{
			
			
		findElement(By.id("firstName")).sendKeys(Firstname);
		findElement(By.id("lastName")).sendKeys(Lastname);
		findElement(By.id("username")).sendKeys(Username);
		findElement(By.name("Passwd")).sendKeys(Password);
		findElement(By.name("ConfirmPasswd")).sendKeys(Conform);
		
	
	}
	public WebElement findElement(By by) throws Exception {

		WebElement elem = driver.findElement(by);

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", elem);

		}
		return elem;
	}
}
