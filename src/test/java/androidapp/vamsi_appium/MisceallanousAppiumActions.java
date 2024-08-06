package androidapp.vamsi_appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MisceallanousAppiumActions extends baseclass{

	@Test  //apidemoapp
	public void Miscellanous() throws MalformedURLException
	{
		//adb shell dumpsys window | grep -E 'mCurrentFocus'  - MAC
		//adb shell dumpsys window | find "mCurrentFocus"     - Windows

		//App Package-->one pakage  & App Activity-->everypage is one activity,many activities
		
		//for moving directly to that particular page
		Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
		//driver.startActivity(activity);
		((JavascriptExecutor) driver).executeScript("mobile: startActivity",ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));	
		driver.findElement(By.id("android:id/checkbox")).click();
	
		DeviceRotation landScape = new DeviceRotation(0, 0, 90);
		driver.rotate(landScape);		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click(); 
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");	
	
		//copy paste
		//copy to clipboard- paste it back from clipboard
		driver.setClipboardText("Rahul Wifi");   //this is alredy copied to clipboard by this command
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
	
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));			
	}	
}
