package Selenium.PageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.AbstractComponents.AbstractComponents;



public class ProductCatologue extends AbstractComponents{

	WebDriver driver;
	
	public ProductCatologue(WebDriver driver)
	{ 
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By findBy= By.cssSelector(".mb-3");
	By toastMsg=By.cssSelector("#toast-container");
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	////div[@class='card-body']/button[2]
	//By prodBy=By.xpath("//div[@class='container']//div[1]//div[1]//div[1]//button[2]");
	
	By prodBy=By.cssSelector(".card-body button:last-of-type");
	
	public List<WebElement> getProductList()
	{
		waitForElementVisibilty(findBy);
		//products.stream().collect(Collectors.toList());
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prodElement=getProductList().stream().filter(s->s.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
		System.out.println(prodElement.getText());
		return prodElement;
	}
	
	// main method
	    public CartPage addProductToCart(String productName) {
	    getProductByName(productName).findElement(prodBy).click();
	    waitForElementVisibilty(toastMsg);
	    waitForElementInvisibility(spinner);
	    CartPage cart=new CartPage(driver);
	    return cart;
	}
	

}