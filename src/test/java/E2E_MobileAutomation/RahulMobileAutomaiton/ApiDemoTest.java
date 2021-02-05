package E2E_MobileAutomation.RahulMobileAutomaiton;

import java.io.IOException;
//import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomePage;
import pageObjects.Preferences;
//import practise.AppiumFramework.TestData;





public class ApiDemoTest extends base{

	@Test(dataProvider="InputData",dataProviderClass=TestData.class)
	public void apiDemo(String input) throws IOException, InterruptedException 
	{
		service=startServer();
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver=Capabilities("apiDemo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/*     xpath syntax
		 *    //tagname[@attribute='value']
		 *    here tagname is the class value
		*/
		
		HomePage h=new HomePage(driver);
		h.Preferences.click();
		 
		Preferences p=new Preferences(driver);
		p.dependencies.click();
		 
//		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
//		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
//	    
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys(input);
		//driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		 p.buttons.get(1).click();
		 service.stop();
		//""
		
		
//		driver.findElement(By.id("android:id/text1")).click();
//		driver.findElement(By.id("android:id/text1")).click();
//		driver.findElement(By.id("android:id/checkbox")).click();
//		
		
		
	}
//	@BeforeTest
//	public void killAllNodes() throws IOException, InterruptedException
//	{
//	//taskkill /F /IM node.exe
//		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
//		Thread.sleep(3000);
//		
//	}
	

}
