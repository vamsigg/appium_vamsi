package androidapp.vamsi_appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Appiumbasics extends baseclass{

	@Test   //apidemoapp
	public void WifiSettingsName() throws MalformedURLException
	{
	    //code to start server	
		//AndroidDriver,IOSDriver
		//Appium code - > Appium Server -> Mobile 		
		//Actual automation
		
		//Xpath, id, accessibilityId, classname, androidUIAutomator  
		//tagName[@attribute='value']  -> //tagName
		//classname is also preferable to appiumby
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click(); 
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle,"WiFi settings");	
		driver.findElement(By.id("android:id/edit")).sendKeys("vamsi Wifi");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();	
     }
}
