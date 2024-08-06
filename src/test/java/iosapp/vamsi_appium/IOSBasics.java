package iosapp.vamsi_appium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSBasics extends IOSBaseTest{

	@Test
	public void IOSBasicsTest()
	{
	  //Xpath, id, classname, accessibility id, iosClassCHain, IOSPredicateString,
		
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		
	    //Xpath -XMl language - App source(xpath is very slow in ios so we are using iosclasschain similar to xpath)
	    //driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Text Entry']")).click();
		
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label =='Text Entry'`]")).click();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hello World");   //as it is a single element we can use tag directly
		driver.findElement(AppiumBy.accessibilityId("OK")).click();
	  //driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Cancel'"));  //regular expression and case sensitive
	  //driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Confirm / Cancel'"));		
		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")).click();
    	String text=driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[c] 'A message'")).getText();
	    System.out.println(text);	
		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'")).click();  //we can change the attributes 
	}
}
