package pages;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;

import utility.BrowserFactory;
import utility.ConfigurationDataProvider;
import utility.ExcelDataProvider;
import utility.ExtentManager;
import utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigurationDataProvider config;
//	public ExtentReports report;
//	public ExtentTest logger;
	public String BrowserName;
	
	static String fileName = System.getProperty("user.dir") + "/Reports/test"+ Helper.getCurrentDateTime() + ".html";
	public static ExtentReports extent = ExtentManager.createInstance(fileName);
	public static ExtentTest test;
	public static ThreadLocal<ExtentTest> extentReport = new ThreadLocal<ExtentTest>();
	public static List<GalenTestInfo> objGalentestsList;
	public static HtmlReportBuilder htmlReportBuilder;
	public static GalenTestInfo objSingleGalenTest;
	

	@BeforeSuite
	public void setUpSuite() {
		Reporter.log("IN BEFORE SUITE", true);
		objGalentestsList = new LinkedList<GalenTestInfo>();
		htmlReportBuilder = new HtmlReportBuilder();
	}
	
	@BeforeTest
	public void setBeforeTest() {
		Reporter.log("IN BEFORE TEST", true);
	}
	
	@Parameters("browser")
	@BeforeClass 
	public void configTest(String browser) {		
		System.out.println();
		Reporter.log("IN BEFORE CLASS", true);
		config = new ConfigurationDataProvider();
		excel = new ExcelDataProvider();
		
		BrowserName = browser;
		
		driver = BrowserFactory.startApplication(driver, browser, config.getFromConfig("testUrl"));
		System.out.println("driver :" + driver);
	}

	@BeforeMethod
	public void setBeforeMethod(){
		Reporter.log("IN BEFORE METHOD :", true);
	}
	
	@AfterMethod
	public void setAfterMethod(ITestResult result) throws IOException {
		Reporter.log("IN AFTER METHOD :", true);

		if (result.getStatus() == ITestResult.FAILURE) {
			extentReport.get().fail("Test FAILED",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentReport.get().pass("Test PASSED",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
//		} else if (result.getStatus() == ITestResult.SKIP) {
//			extentReport.get().skip("Test SKIPPED",
//					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
	} 
	
	@AfterClass
	public void setAfterClass() {
		Reporter.log("IN AFTER CLASS :", true);
		System.out.println("driver :" + driver);
		BrowserFactory.closeBrowser(driver);
	}
	
	@AfterTest
	public void setAfterTest() {
		Reporter.log("IN AFTER TEST", true);
	}
	
	@AfterSuite
	public void setAfterSuite() throws IOException {
		Reporter.log("IN AFTER SUITE", true);
        htmlReportBuilder.build(objGalentestsList, "UI_Galen_Reports");
	}
}