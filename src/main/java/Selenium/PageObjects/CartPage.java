package Selenium.PageObjects;


import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.AbstractComponents.AbstractComponents;




public class CartPage extends AbstractComponents{

	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{ 
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	
	@FindBy(css=".subtotal button")
	WebElement checkoutBtn;		
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartprd;
	
	
	
	By cartPrd= By.cssSelector(".cartSection h3");
	By cont=By.xpath("//div /input[@placeholder='Select Country']");
	
	
	public PaymentPage checkOut()
	{
		//cartButton.click();
		//waitForElementVisibilty(cartPrd);
		//cartList(productName);
		checkoutBtn.click();
		waitForElementVisibilty(cont);
		PaymentPage paymentDetails=new PaymentPage(driver);
		return paymentDetails;
	}
	
	
	public  boolean productMatch(String productName)
	{
		Boolean match=cartprd.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		return match;
	}
	
}