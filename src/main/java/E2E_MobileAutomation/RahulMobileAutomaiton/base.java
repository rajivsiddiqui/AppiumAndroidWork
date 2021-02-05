package E2E_MobileAutomation.RahulMobileAutomaiton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
//************
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class base {

	//********Start Appium Server Start method************
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement>  driver;
	
	public AppiumDriverLocalService startServer()
	{
		//
	boolean flag=	checkIfServerIsRunnning(4723);
	if(!flag)
	{
		
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
		return service;
		
	}
	
public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
		
	}
//*****************Closed Appium server start method******************


//******************Start Emulator method*******************
public static void startEmulator() throws IOException, InterruptedException
{

	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat");
	Thread.sleep(6000);
}
// ***************Close Emulator method	********************



	public static AndroidDriver<AndroidElement> Capabilities(String appName) throws IOException, InterruptedException{
		// TODO Auto-generated method stub

		//System.getProperty("usr.dir")+"\\src\\global.properties");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\E2E_MobileAutomation\\RahulMobileAutomaiton\\global.properties");
		//FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\practise\\AppiumFramework\\global.properties");

		//C:\QA_IBCS\WORK\RahulMobileAutomaiton\src\main\java\E2E_MobileAutomation\RahulMobileAutomaiton\global.properties
		
		Properties prop =new Properties();
		prop.load(fis);
		//String getAppName= (String) prop.get(appName);
		
		
		AndroidDriver<AndroidElement> driver;
		
		File f=new File("src");
		File fs=new File(f,(String) prop.get(appName));
		DesiredCapabilities cap = new DesiredCapabilities();
		
		//String device =(String) prop.get("device");
		String device= System.getProperty("deviceName");
		 if(device.contains("Emulator"))
		  {
		  startEmulator();
		  }
		 
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);//Emulator name
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());//app location select
		
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

//	public static void getScreenshot(String s) throws IOException
//	{
//	//Thread.sleep(6000);	
//	File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
//	
//	}
	

}
