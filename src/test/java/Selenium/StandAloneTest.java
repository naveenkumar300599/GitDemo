package Selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Selenium.PageObjects.LandingPage;
import junit.framework.Assert;

public class StandAloneTest {

	public static void main(String[] args){
		
        WebDriver driver=new ChromeDriver();
        
        String productName="ZARA COAT 3";
        driver.manage().window().maximize();
        
       LandingPage landingPage=new LandingPage(driver);
        driver.get("https://rahulshettyacademy.com/client");

       driver.findElement(By.id("userEmail")).sendKeys("naveen30@gmail.com");
       driver.findElement(By.id("userPassword")).sendKeys("Naveen@selenium24");
       driver.findElement(By.id("login")).click();
       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
       
       
       List<WebElement> product=driver.findElements(By.xpath("//div[contains(@class, 'mb-3')]"));
      
   
  //Streams---
      
       WebElement pro=product.stream().filter(s->s.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
       pro.findElement(By.xpath("//div[@class='card-body']/button[2]")).click();
       
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
       
       
       driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
       
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));
       
      
       
       List<WebElement> cart=driver.findElements(By.cssSelector(".cartSection h3"));
       Boolean match=cart.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
       System.out.println(match);
       Assert.assertTrue(match);
       driver.findElement(By.cssSelector(".subtotal button")).click();
       driver.findElement(By.xpath("//div /input[@placeholder='Select Country']")).sendKeys("Ind");
        
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
       //driver.findElements(By.xpath("(//button[contains(@class, 'ta-item')])[2]"));
       
      List<WebElement> country=driver.findElements(By.xpath("(//button[contains(@class, 'ta-item')])[2]"));
      // List<String> cc=country.stream().map(s->s.getText()).collect(Collectors.toList());
       //System.out.println(cc);
       
       
      
	 for(WebElement fc:country)
			
	{
		if(fc.getText().equalsIgnoreCase("India"))
	{
		System.out.println("Inside click loop");
		fc.click();
	}
       
	}
	
	 WebElement element = driver.findElement(By.cssSelector(".action__submit"));

	 Actions actions = new Actions(driver);

	 actions.moveToElement(element).click().perform(); 
	 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
	 
	 String confmMsg=driver.findElement(By.cssSelector(".hero-primary")).getText();
	 boolean n=confmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER.");
	 
	 Assert.assertTrue(n);
	 System.out.println("Order Placed! Thanks for your order");
	 
	 driver.close();
	
	}
}







      //WebElement fc=country.stream().filter(s->s.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
       
       //fc.click();
       
       
       
       
       
       
       
       
       
       
 
  //to get a list of webelement from stream   ----
       //List<WebElement> prod=product.stream().filter(s->s.findElement(By.tagName("b")).getText().equals(productName)).collect(Collectors.toList());
       //System.out.println(prod.size()); 
 // for loop-----      
    /*for(WebElement pr:product)
        {
        	String item=pr.findElement(By.tagName("b")).getText();
        	if(item.equals(productName))
        	{
        		pr.findElement(By.xpath("//div[@class='card-body']/button[2]")).click();
        	}
        }*/
       
  
     
	
      
       
       
       
	


