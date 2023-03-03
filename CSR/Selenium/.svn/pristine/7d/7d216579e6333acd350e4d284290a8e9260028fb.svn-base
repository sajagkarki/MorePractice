package runner;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import helperClasses.Zephyr;
import io.appium.java_client.windows.WindowsDriver;

public class Setup {

	protected static WindowsDriver AppSession = null;
	private static WebElement AppResult = null;
	private static String server = "";
	public void StartDriver(String s) {
		server = s;


		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("app", "D:\\P6CAR\\P6\\P6\\P6\\P6.exe");
			WindowsDriver winDriver = AppSession = new WindowsDriver(new URL("http://"+server+":4723"), capabilities);
			winDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		
	}
	
	public void openZephyrConnection() throws IOException {
		Zephyr z = new Zephyr();
		z.getProjectID();
	}
	
	public String getServer() {
		return server;
	}

}
