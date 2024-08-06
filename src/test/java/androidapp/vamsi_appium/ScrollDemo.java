package androidapp.vamsi_appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends baseclass{

	@Test    //apidemoapp
	public void ScrollDemoTest() throws MalformedURLException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//where to scroll is known prior
	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));	
	
	/*	WebElement scrollto=driver.findElement(AppiumBy.accessibilityId("WebView"));
		scrolltotarget(scrollto);*/
		
		//No prior idea
		scrollToEndAction();		
	}
}
