package Selenium.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import Selenium.PageObjects.LandingPage;

public class BaseTest{
	
	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException
	{
		
		
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\navee\\eclipse-workspace\\SeleniumFrameWork\\src\\main\\java\\Selenium\\resources\\GlobalData.properties");
		prop.load(fis);
		//String browserName=prop.getProperty("browser");
		
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
			
		{   
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless"))
			{   
			    
			  options.addArguments("headless");
			}
			driver =new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
		}
		
		
		
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException
	{
       initializeDriver();
       landingPage=new LandingPage(driver);
       landingPage.goTo();
       return landingPage;
       
    }
	
	@AfterMethod(alwaysRun=true)
	public void close()
	{
		driver.close();
	}
	public List<HashMap<String,String>> getJsonDataToMap() throws IOException
	{
		///read json to string
		
		String jsonToString=FileUtils.readFileToString(new File("C:\\Users\\navee\\eclipse-workspace\\SeleniumFrameWork\\src\\test\\java\\Selenium\\Data\\PurchaseOrder.json"),StandardCharsets.UTF_8);
		
		//string to hashmap(jackson databind)
		
		ObjectMapper map=new ObjectMapper();
		
		List<HashMap<String,String>> data=map.readValue(jsonToString, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}
	
	public String getScreenshot(String testName,WebDriver driver) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"\\reports\\"+testName+".png");
		FileUtils.copyFile(src, file);
		return System.getProperty("user.dir")+"\\reports\\"+testName+".png";
		
	}
	
	
}
