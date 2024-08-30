package Selenium.StepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import Selenium.PageObjects.CartPage;
import Selenium.PageObjects.LandingPage;
import Selenium.PageObjects.PaymentPage;
import Selenium.PageObjects.ProductCatologue;
import Selenium.PageObjects.confmPage;
import Selenium.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDefinition extends BaseTest {
	
	LandingPage landingPage;
	ProductCatologue prd;
	confmPage msg;
	
	@Given("landed on Ecommerce page")
	public void landed_on_Ecommerce_Page() throws IOException
	{
		landingPage=launchApplication();
	}
	
	@Given("^Log in to the Ecommerce website with name (.+) and password (.+)$")
	public void Log_in_to_the_Ecommerce_website_with_name_and_password(String name,String password)
	{
		  prd=landingPage.logIn(name,password);
	}
	
	@When("^Add product (.+) to cart$")
	public void Add_product_to_cart(String productName)
	{
		   List<WebElement> product=prd.getProductList();
	       prd.addProductToCart(productName);
	}
	@When("^checkout product (.+) and submit the order$")
    public void checkout_product_and_submit_the_order(String productName)
	{
		CartPage cart=prd.goToCart();
	    Boolean match= cart.productMatch(productName);
	    Assert.assertTrue(match);
	    PaymentPage paymentDetails=cart.checkOut();
	    paymentDetails.enterCountry("India");
	    msg= paymentDetails.placeOrder();
	}
	@Then("verify the msg {string} in confirmation page")
	public void verify_the_msg_in_confirmation_page(String string)
	{
		   Boolean msgOut=msg.getcnfmMsg().equalsIgnoreCase(string);
	       Assert.assertTrue(msgOut);
	       driver.close();
		
	}	
	@Then("{string} msg is displayed")
	public void msg_is_displayed(String string)
	{
		 Assert.assertEquals(string, landingPage.getLoginErrorMsg());
	}
	   
	}
	

