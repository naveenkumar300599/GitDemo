package Selenium.resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportNG {
	

       public static ExtentReports getReportObject() {
		String reportPath=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(reportPath);
		
		reporter.config().setDocumentTitle("Test Report");
		reporter.config().setReportName("Detailed report");
		
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("test", "naveen");
		return extent;
	}

    }
