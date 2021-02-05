package E2E_MobileAutomation.RahulMobileAutomaiton;

//import java.net.MalformedURLException;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//
//import org.openqa.selenium.By.ByClassName;
//
/////import MobileAutomation.base;
//
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import io.appium.java_client.MobileBy;
//
//import io.appium.java_client.TouchAction;
//
//import io.appium.java_client.android.AndroidDriver;
//
//import io.appium.java_client.android.AndroidElement;
//import pageObjects.CheckoutPage;
//import pageObjects.FormPage;
//
//import static io.appium.java_client.touch.TapOptions.tapOptions;
//
//import static io.appium.java_client.touch.offset.ElementOption.element;
//
//import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//
//import static java.time.Duration.ofSeconds;
//
//import java.io.IOException;

///import junit.framework.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.CheckoutPage;
import pageObjects.FormPage;


public class Ecommerce_tc_4 extends base {

	@Test
	public void totalValidation() throws IOException, InterruptedException 
	{
		service=startServer();
		
		AndroidDriver<AndroidElement> driver = Capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		FormPage FP=new FormPage(driver);
		
		

		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		FP.getNameField().sendKeys("Hello");

		driver.hideKeyboard();
		

		//driver.findElement(By.xpath("//*[@text='Female']")).click();
		FP.getFimeleOption().click();
		
		//driver.findElement(By.id("android:id/text1")).click();
		FP.getcountrySelection().click();

//		driver.findElementByAndroidUIAutomator(
//				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		
		Utilities utilities =new Utilities(driver);
		utilities.scrollToText("Argentina");
		
		// driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new
		// UiSelector().scrollable(true).instance(0)).scrollIntoView(new
		// UiSelector().textMatches(\"" + containedText + "\").instance(0))"));

		//driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		FP.getcountrySelected().click();

		//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		FP.getShopBtton().click();

		CheckoutPage CP = new CheckoutPage(driver);
		
		 //driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		 CP.getSelectProduct().get(0).click();
		//driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		 CP.getSelectProduct().get(0).click();
		 
	     //driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		 CP.getCheckOut().click();

		Thread.sleep(4000);

		int count = CP.getProductList().size();

		double sum = 0;

		for (int i = 0; i < count; i++)

		{

			String amount1 = CP.getProductList().get(i).getText();

			double amount = getAmount(amount1);

			sum = sum + amount;// 280.97+116.97

		}

		System.out.println(sum + "sum of products");

		String total = CP.getTotalAmount().getText();

		total = total.substring(1);

		double totalValue = Double.parseDouble(total);

		System.out.println(totalValue + "Total value of products");

		Assert.assertEquals(sum, totalValue);
		//Assert.assertNotEquals(sum, totalValue);
		service.stop();

}

	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
	//taskkill /F /IM node.exe
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		
	}	
	
	public static double getAmount(String value)

	{

		value = value.substring(1);

		double amount2value = Double.parseDouble(value);

		return amount2value;

	}

}