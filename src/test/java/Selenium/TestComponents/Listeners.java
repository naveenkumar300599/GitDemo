package Selenium.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Selenium.resources.extentReportNG;

public class Listeners extends BaseTest implements ITestListener 
{
    ExtentTest test;
    ExtentReports extent=extentReportNG.getReportObject();
    ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	
	public void onTestStart(ITestResult result) {
		
		test= extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
		
		
	}
	
		 
		 public void onTestSuccess(ITestResult result) 
		 
		 {
			 extentTest.get().log(Status.PASS, "test.passed");
			 
		    
			  }

		
		  public void onTestFailure(ITestResult result) {
			  
			  
		   try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1)
		   {
			e1.printStackTrace();
		}	  
		   test.fail(result.getThrowable());
		   String filePath=null;
		   try {
			 filePath=getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		   extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		  }

		 
		  public void onFinish(ITestContext context) {
		    extent.flush();
		  }
}


