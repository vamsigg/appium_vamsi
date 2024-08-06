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

public class LongPress extends baseclass{

	@Test  //apidemoapp
	public void LongPressGesture() throws MalformedURLException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
	
		WebElement ele=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longPressAction(ele);                       //"(//android.widget.TextView)[2]"
		
	    String menuText =driver.findElement(By.id("android:id/title")).getText();
	    Assert.assertEquals(menuText, "Sample menu");
	    Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());		
	}
}
