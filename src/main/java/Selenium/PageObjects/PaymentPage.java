package Selenium.PageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.AbstractComponents.AbstractComponents;




public class PaymentPage extends AbstractComponents{

	WebDriver driver;
	
	public PaymentPage(WebDriver driver)
	{ 
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div /input[@placeholder='Select Country']")
	WebElement countryField;
	
	@FindBy(xpath="//button[contains(@class, 'ta-item')]")
	List<WebElement> countryList;
	
	@FindBy(css=".action__submit")
	WebElement submitBtn;
	
	By country= By.cssSelector(".ta-results");
	By cont=By.xpath("//div /input[@placeholder='Select Country']");
	By confmMsg=By.cssSelector(".hero-primary");
	
	/*public void paymentDetails(String cName)
	{
		
		
		selectCountry(cName);
		placeOrder();
		
		
	}*/
	
	public void enterCountry(String cName)
	{
	  countryField.sendKeys(cName);
	  waitForElementVisibilty(country);
	  selectCountry(cName);
	}
	
	public void selectCountry(String cName)
	{
		for(WebElement cc:countryList)
		{
			if(cc.getText().equalsIgnoreCase(cName))
			{
				cc.click();
			}
		}
	}
	
	public confmPage placeOrder()
	{
		 Actions actions = new Actions(driver);

		 actions.moveToElement(submitBtn).click().perform();
		 waitForElementVisibilty(confmMsg);
		 confmPage msg=new confmPage(driver);
		 return msg;
		 
	}
	
}

