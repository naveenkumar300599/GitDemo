package Selenium.AbstractComponents;

//import static org.testng.AssertJUnit.assertTrue;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Selenium.PageObjects.CartPage;
import Selenium.PageObjects.OrderPage;
import dev.failsafe.internal.util.Assert;

public class AbstractComponents {
	WebDriver driver;
	

	public AbstractComponents(WebDriver driver) {
		
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".btn.btn-custom[routerlink='/dashboard/cart']")
	WebElement cartButton;
	
	@FindBy(xpath=".//button[@routerlink='/dashboard/myorders']")
	WebElement ordersButton;
	
	@FindBy(css="tr td:nth-child(3)")
	WebElement ordPrd;
	
	By cartprd=By.cssSelector(".cartSection h3");
	
	
	
	public void waitForElementVisibilty(By visible)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(visible));
		
		
	}
	
	public void waitForElementInvisibility(WebElement invisible)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(invisible));
		}
	
	public void waitforWebElementVisibility(WebElement visible)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(visible));
		
	}	
	
	public CartPage goToCart()
	{
		cartButton.click();
		waitForElementVisibilty(cartprd);
		CartPage cart=new CartPage(driver);
		return cart;
		
		
	}
	 public OrderPage goToOrdersPage()
	{
		 waitforWebElementVisibility(ordersButton);
		ordersButton.click();
		waitforWebElementVisibility(ordPrd);
		OrderPage orders=new OrderPage(driver);
		return orders;
		
	}
}
	
	/*public boolean assertMethod(Boolean value)
	{
		Boolean match=Assert.assertTrue(value);
		return match;
	}*/
	


