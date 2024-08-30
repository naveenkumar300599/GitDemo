package Selenium.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.AbstractComponents.AbstractComponents;



public class LandingPage extends AbstractComponents{

	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css="div[aria-label='Incorrect email or password.']")
	WebElement invalidLoginMsg;
	
	public ProductCatologue logIn(String email,String userPassword)
	{
	  userEmail.sendKeys(email);
	  password.sendKeys(userPassword);
	  login.click();
	  ProductCatologue prd=new ProductCatologue(driver);
	  return prd;
	}
	
	public String getLoginErrorMsg()
	{
		waitforWebElementVisibility(invalidLoginMsg);
		return invalidLoginMsg.getText();
		
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
}
