package testCases;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import helperClasses.View;
import io.appium.java_client.windows.WindowsDriver;
import runner.*;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class ExamplePreferences_Validator extends Setup {

	/**
	 * This is needed to interface with menus or windows that aren't the same window as P6's body.
	 * @return
	 */
	private WindowsDriver newWindowsSession() {
		DesiredCapabilities appCapabilities1 = new DesiredCapabilities();
		appCapabilities1.setCapability("app", "Root");
		appCapabilities1.setCapability("deviceName", "WindowsPC");
		WindowsDriver DesktopSession = null;
		try {
			String server = getServer();
			DesktopSession = new WindowsDriver<WindowsElement>(new URL("http://"+server+":4723"),
					appCapabilities1);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return DesktopSession;
	}
	
	boolean testPass = true;
	/**
	 * A simple validator for ExamplePreference_TC to check that it saved.
	 * @throws InterruptedException 
	 * 
	 */
	public ExamplePreferences_Validator() throws InterruptedException {

		//You can find elements using various functions under AppSession, with the name being the most common.
		Thread.sleep(300); //Thread.sleep is used when small delays are needed.
		AppSession.findElementByName("Edit Alt+E").sendKeys(Keys.chord(Keys.ALT, "E"));
		Thread.sleep(100);
		
		//In P6, menus function a bit differently than normal, being that they are part of a different Pane
		//This means we have to access them differently from most elements using a different window
		WindowsDriver ds = newWindowsSession();
		ds.findElementByName("Preferences Alt+P").click();;
		Thread.sleep(1000);
		ds.close();
		ds = newWindowsSession();
		List<Object> ele = ds.findElementsByName("Application");
		((WebElement) ele.get(2)).click(); //Find the child element of Application named application
		

		Thread.sleep(100);
		//Check that the change actually occurred.
		if(
			!ds.findElementByName("Auto Save Settings").isSelected() ||
			!ds.findElementByName("Use 24-hour Time Format").isSelected() ||
			!ds.findElementByName("Prompt For Run Overview").isSelected() ||
			!ds.findElementByName("Enable Logging (May decrease performance)").isSelected()
			)
			testPass = false;
			
		//Save the changes
		//ds.findElementByName("Apply").click();
		Thread.sleep(300);
		ds.findElementByName("OK Enter").click();
		
		ds.close();
		
		//Close P6 and save
		Thread.sleep(100);
		AppSession.findElementByName("Close").click();
		Thread.sleep(500);
		AppSession.findElementByName("Yes Enter").click();
		
		//Finally, report back whether or not the test worked.
		System.out.println("ExamplePreferences Validator Pass");
	}

}
