package Selenium.PageObjects;

import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents {
	
	    WebDriver driver;
		
		public OrderPage(WebDriver driver)
		{ 
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
		
		
		
		
		@FindBy(css=".subtotal button")
		WebElement checkoutBtn;		
		
		@FindBy(css="tr td:nth-child(3)")
		List<WebElement> orderProducts;
		
		
		
		By cartPrd= By.cssSelector(".cartSection h3");
		By cont=By.xpath("//div /input[@placeholder='Select Country']");

		
		
		
		public  boolean verifyOrder(String productName)
		{
			Boolean match=orderProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
			return match;
		}

}
