package iosapp.vamsi_appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSBaseTest {

	public IOSDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException
	{	
		 service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				       .withIPAddress("127.0.0.1").usingPort(4723).build();
		 service.start();
			
		 XCUITestOptions options = new XCUITestOptions();	
		 options.setDeviceName("iPhone 15");
	     options.setApp("/Users/gangulagvkvamsikumar/eclipse-workspace/vamsi_appium/src/test/java/resources/UIKitCatalog.app");
	     //options.setApp("//Users//gangulagvkvamsikumar//eclipse-workspace//vamsi_appium//src//test//java//resources//TestApp 3.app");
	     options.setPlatformVersion("17.5");                    //mandatory to set version no in ios  
		 options.setWdaLaunchTimeout(Duration.ofSeconds(20));   //Appium install Webdriver Agent ->helps to automate IOS Apps. so there is some delay
				
		 driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(),options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
        service.stop();
	}
}
