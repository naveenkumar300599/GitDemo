package Selenium.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class confmPage {

	WebDriver driver;
	
	public confmPage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css=".hero-primary")
	WebElement cnfmMsg;
	
	public String getcnfmMsg()
	{
		return cnfmMsg.getText();
	}
	
}