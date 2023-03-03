package userActions;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import runner.*;

public class MenuActions extends Setup {

	public MenuActions() {
		// TODO Auto-generated constructor stub
	}
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

	public void runWeldScanner() throws InterruptedException {
				
		WebElement e = AppSession.findElementByName("Process Alt+o");
		e.click();
		//After clicking the top menu item, a new process window is created and can not be accessed via the appsession.
		//A new session to find sub-menu items is needed.
		WindowsDriver ds = newWindowsSession();
		ds.findElementByName("Autoscan Alt+A").click();
		ds.findElementByName("Weld Scanner Alt+W").click();
		ds.close();
		
		//Once done clicking through menu items, return back to main appsession to navigate
		AppSession.findElementByName("Scan Enter").click();
		AppSession.findElementByName("Yes Enter").click();
		Thread.sleep(100);
		int seconds = 0;
		while(AppSession.findElementByName("Done").isEnabled()==false) {
			Thread.sleep(1000);
			seconds++;
			//System.out.println(seconds);
			if(seconds ==500) {
				AppSession.findElementByName("Cancel").click();
			}
		}

		if (AppSession.findElementByName("Done").isEnabled()) {
			AppSession.findElementByName("Done").click();
		}
	}
	
	
	public void runPitScanner() throws InterruptedException {
		
		WebElement e = AppSession.findElementByName("Process Alt+o");
		e.click();
		//After clicking the top menu item, a new process window is created and can not be accessed via the appsession.
		//A new session to find sub-menu items is needed.
		WindowsDriver ds = newWindowsSession();
		ds.findElementByName("Auto Scan Alt+S").click();
		ds.findElementByName("Pits Alt+P").click();
		ds.close();

		//Once done clicking through menu items, return back to main appsession to navigate
		AppSession.findElementByName("Scan Enter").click();
		AppSession.findElementByName("Yes Enter").click();
		Thread.sleep(100);
		int seconds = 0;
		while(AppSession.findElementByName("Done").isEnabled()==false) {
			Thread.sleep(1000);
			seconds++;
			System.out.println(seconds);
			if(seconds ==500) {
				AppSession.findElementByName("Cancel").click();
			}
		}

		if (AppSession.findElementByName("Done").isEnabled()) {
			AppSession.findElementByName("Done").click();
		}
	}
	
	public void getAppVersion() {
		String titleBar = AppSession.findElementByAccessibilityId("TitleBar").getText();
		String test = "blah";
	}
	
	public void runRenumberDatabase() {
		WebElement e = AppSession.findElementByName("Process Alt+o");
		e.click();
	
		WindowsDriver ds = newWindowsSession();
		ds.findElementByName("Renumber database Alt+u").click();
		ds.close();
		
		AppSession.findElementByName("Yes Enter").click();
		//TODO need to key off pop up dialog to move to next step
		AppSession.findElementByName("OK Enter").click();
	}

}
