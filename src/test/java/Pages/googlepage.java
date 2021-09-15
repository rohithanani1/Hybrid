package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Extent_Reports.ExtentReport;

public class googlepage {
	static WebDriver driver;
	
	ExtentTest logger;
	ExtentReports extent;
	String ScreenShotPath;
	String TestScriptName;
	
  @Test
   
public void googlepage(WebDriver driver, String TestScriptName, ExtentTest logger, ExtentReports extent) {
	 this.driver=driver;
	  this.extent=extent;
	  this.logger=logger;
	  this.TestScriptName=TestScriptName;
		
	  
 }
 public void googlenext() throws Exception {
	  findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/div/button/span")).click();
		
		ScreenShotPath=ExtentReport.capture(driver,TestScriptName);
		logger.pass("MyHomePage Website",MediaEntityBuilder.createScreenCaptureFromPath(ScreenShotPath).build());
 }
 public WebElement findElement(By by) throws Exception {

		WebElement elem = driver.findElement(by);

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", elem);

		}
		return elem;
	}
}