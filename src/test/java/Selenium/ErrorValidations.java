package Selenium;

import java.io.IOException;
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
import org.testng.annotations.Test;

import Selenium.PageObjects.CartPage;
import Selenium.PageObjects.LandingPage;
import Selenium.PageObjects.PaymentPage;
import Selenium.PageObjects.ProductCatologue;
import Selenium.PageObjects.confmPage;
import Selenium.TestComponents.BaseTest;
import junit.framework.Assert;

public class ErrorValidations extends BaseTest{
	
	
@Test
	public void invalidLoginTest() throws IOException 
	{	
      
        String productName="ZARA COAT 3";
      
        landingPage.logIn("naveen30@gmail.com", "Naveen@selenium243");
       
       Assert.assertEquals("Incorrect email or password.", landingPage.getLoginErrorMsg());
       
       System.out.println(landingPage.getLoginErrorMsg());
       
     }

@Test
public void VerifyProductTest() throws IOException
{	
   
    String productName="ZARA COAT 3";
    
    ProductCatologue prd=landingPage.logIn("naveen30@gmail.com", "Naveen@selenium24");
   
    List<WebElement> product=prd.getProductList();
   
    prd.addProductToCart(productName);
   
    CartPage cart=prd.goToCart();
    Boolean match= cart.productMatch("ZARA COAT 33");
    Assert.assertFalse(match);
}
}
     
	
      
       
       
       
	


