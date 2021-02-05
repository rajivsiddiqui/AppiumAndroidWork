package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPage {
	public CheckoutPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	@AndroidFindBy(xpath="//*[@text='ADD TO CART']")
	public List<WebElement> SelectProduct;
	 
	
	//driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"))
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productList;
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"))
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement checkout;
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl"))
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	
	public WebElement totalAmount;
	
	public List<WebElement> getProductList()
	{
		
		return productList;
	}
	
	public List<WebElement> getSelectProduct()
	{
		
		return SelectProduct;
	}
	
	public WebElement getCheckOut()
	{
		
		return checkout;
	}
	
	public WebElement getTotalAmount()
	{
		
		return totalAmount;
	}
}
