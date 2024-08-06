package androidapp.vamsi_appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class baseclass {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException
	{     
		 service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				   .withIPAddress("127.0.0.1").usingPort(4723).build();
		 service.start();
		 	 
		 UiAutomator2Options options = new UiAutomator2Options();
	     options.setDeviceName("vamsiphone");      //emulator
	   //options.setDeviceName("Android Device");  //real device
	   //options.setChromedriverExecutable("//Users//gangulagvkvamsikumar//Downloads//chromedriver-mac-arm64//chromedriver");   //for habdling drowser activity
	    //options.setApp("//Users//gangulagvkvamsikumar//eclipse-workspace//vamsi_appium//src//test//java//resources//ApiDemos-debug.apk");	
	   options.setApp("//Users//gangulagvkvamsikumar//eclipse-workspace//vamsi_appium//src//test//java//resources//General-Store.apk");
			
	     driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);   //server,capabilites like device name,app name,android version
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
        service.stop();
	}
	
	public void longPressAction(WebElement ele)   //for handling both web and mobile we mention remotewebelement
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						                                                                       "duration",2000));
	}
	
	public void scrollToEndAction()
	{
		boolean canScrollMore;
		do
		{
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200,
	                                                                                                                    "direction", "down",
	                                                                                                                    "percent", 3.0));
	     //is it still scrollable than it will return as true		                                                                               
		}while(canScrollMore);
	}
	
	/*public void scrolltotarget(WebElement ele)
	{
		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),	 
			                                                                                 "direction", "down",
			                                                                                   "percent", 1.0));
	}*/
	
	public void swipeAction(WebElement ele,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),	 
			                                                                                "direction", direction,
			                                                                                  "percent", 0.1));	
	}
	
	public void draganddrop(WebElement source,int xcor,int ycor)
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of("elementId", ((RemoteWebElement)source).getId(),
			                                                                                    "endX", xcor,
			                                                                                    "endY", ycor));
	}
	
	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;	
	}
}
