package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	public FormPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	private WebElement femaleOption;
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	//driver.findElement(By.xpath("//*[@text='Argentina']")).click();
	//driver.findElement(By.xpath("//*[@text='Argentina']"))
	@AndroidFindBy(xpath="//*[@text='Argentina']")
	private WebElement countrySelected;
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	
	public WebElement getNameField()
	{
		//System.out.println("trying to find the Name field");
		return nameField;
	}
	
	public WebElement getFimeleOption()
	{
		//System.out.println("trying to find the Name field");
		return femaleOption;
	}
	
	public WebElement getcountrySelection()
	{
		//System.out.println("Selecting the option from dropdown");
		return countrySelection;
	}
	
	public WebElement getcountrySelected()
	{
		//System.out.println("Selecting the option from dropdown");
		return countrySelected;
	}
	
	public WebElement getShopBtton()
	{
		//System.out.println("trying to find the Name field");
		return shopButton;
	}
	
	
}
