package com.mycompany.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.mycompany.pages.PageFactoryBase;
import com.mycompany.pages.PageMethods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.mycompany.pages.HomePage;
import com.mycompany.util.Browser;
import com.mycompany.util.ExcelReader;


public class TestBaseER {

	protected WebDriver driver;
	protected HomePage homePage;
	protected PageFactoryBase pageBase;
	protected static Properties testConfig;
	public ExtentReports extent;
	public ExtentTest extentTest; 
	
		
	@BeforeSuite
	public void  beforeSuit() throws FileNotFoundException, IOException {
		testConfig = new Properties();
		testConfig.load(new FileInputStream("TestConfig.properties"));
	}
		
	  @BeforeMethod
	  public void beforeMethod() throws MalformedURLException  
	  {
		 driver = Browser.createDriver(testConfig.getProperty("browser"));
		 driver.get(testConfig.getProperty("baseUrl"));
         homePage = new HomePage(driver);
         pageBase = new PageFactoryBase(driver);
		 
		
	  }
	 
	  @BeforeTest
			public void setExtent(){
				extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
				extent.addSystemInfo("Host Name", "CheapTickets");
				extent.addSystemInfo("Team", "RainMakers");
				extent.addSystemInfo("Environment", "QA");
				
			}
		  
		  @AfterTest
			public void endReport(){
				extent.flush();
				extent.close();
			}
			
			public static String getScreenshotForFail(WebDriver driver, String screenshotName) throws IOException{
				String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				// after execution, you could see a folder "FailedTestsScreenshots"
				// under src folder
				String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
						+ ".png";
				File finalDestination = new File(destination);
				FileUtils.copyFile(source, finalDestination);
				return destination;
			}
			
			
			public static String getScreenshotForSuccess(WebDriver driver, String screenshotName) throws IOException{
				String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				// after execution, you could see a folder "FailedTestsScreenshots"
				// under src folder
				String destination = System.getProperty("user.dir") + "/SuccessTestsScreenshots/" + screenshotName + dateName
						+ ".png";
				File finalDestination = new File(destination);
				FileUtils.copyFile(source, finalDestination);
				return destination;
			}
			
          
	  
	  
	  @DataProvider
	  public Object[][] dataProvider(Method method)
	  {
		ExcelReader ddh = new ExcelReader(testConfig.getProperty("mastertestdatafile"));
			
		Object[][] testData= ddh.getTestCaseDataSets(testConfig.getProperty("testdatasheet"), method.getName());
		
		return testData;
		 }

	  @AfterMethod
		public void tearDown(ITestResult result) throws IOException, InterruptedException{
			
			if(result.getStatus()==ITestResult.FAILURE){
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
				
				String screenshotPath = getScreenshotForFail(driver, result.getName());
				extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
				//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
			}
			else if(result.getStatus()==ITestResult.SKIP){
				extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
			}
			else if(result.getStatus()==ITestResult.SUCCESS){
				extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

				String screenshotPath = getScreenshotForSuccess(driver, result.getName()); //1
				extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report //2
			}
			
			
			extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
			 Browser.quitDriver(driver);
		}
}
