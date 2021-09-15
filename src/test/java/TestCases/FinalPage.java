package TestCases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;
import Extent_Reports.ExtentReport;
import Pages.HomePge;
import Pages.googlepage;

public class FinalPage {
	
	 static WebDriver driver;
	
	Map<String, HashMap<String, String>> Datatable = new HashMap<String, HashMap<String, String>>();
	
	ExtentTest logger;
	ExtentReports extent;
	String ScreenShotPath;
	public static String TestScriptName;
	public static String TestName;
	
	
	@BeforeTest
	public void openbrowser() throws Exception {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		// WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		driver=TestBrowser.OpenChromeBrowser();
		driver.get(
				"https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
		//driver.manage().window().maximize();
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Datatable=eat.getDataTable("C:\\HTML Report\\OrangeHRM6//google_page.xlsx", "Sheet1");
		
		TestScriptName=(Datatable.get("TC01").get("google"));
		
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a");
		 Date now = new Date();
		 String strDate = sdfDate.format(now);
		 
		 TestName=TestScriptName+"_"+strDate+".html";
		 TestScriptName=TestScriptName+"_"+strDate;
		 String TestHtmlName="C:/HTML Report/test-output/ExtentReportScreenShots/"+ TestScriptName +"/"+TestName;
		  
	
		 ExtentHtmlReporter reporter=new ExtentHtmlReporter(TestHtmlName);
		 System.out.println("Html Report path is : "+TestHtmlName);
		 
		 extent=new ExtentReports();
		 extent.attachReporter(reporter);
		 logger=extent.createTest(TestName);
	}

	
  @Test
  public void myfinalpage() throws Exception {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  String FirstName= Datatable.get("TC01").get("FirstName");
		String LastName= Datatable.get("TC01").get("LastName");
		String Username= Datatable.get("TC01").get("Username");
		String Password= Datatable.get("TC01").get("Password");
		String Conform= Datatable.get("TC01").get("Conform");
		
		HomePge hp = new HomePge();
		hp.HomePge(driver,TestScriptName,logger,extent);
		hp.MyHomePage(FirstName,LastName, Username, Password, Conform);
		
		
		googlepage gp = new googlepage();
		gp.googlepage(driver,TestScriptName,logger,extent);
		gp.googlenext();
				
		
  }
 
  @AfterTest 
	public void  TestCloser()throws Exception {	
		driver.quit();
		extent.flush();
	}
  
}
