package runner;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;

public class Setup {

	protected static String run = "CushingToPayson";
	protected static WindowsDriver AppSession = null;
	protected static String imageLocation = "C:\\runs\\20180510_CVR_180346_CushingtoPayson-10x\\ILI\\Photos\\Tool as Built\\";

	public void StartDriver(String server, String port) {

		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//capabilities.setCapability("app", "C:\\Users\\a7153\\Desktop\\FTRR\\FTRR4.exe");
			capabilities.setCapability("app", "D:\\car\\FieldTechNew\\FieldTechNew\\bin\\Debug\\FieldTechNew.exe");
			WindowsDriver winDriver = AppSession = new WindowsDriver(new URL("http://" + server + ":"+port),
					capabilities);
			winDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

	}

	/*
	 * public void openZephyrConnection() throws IOException { Zephyr z = new
	 * Zephyr(); z.getProjectID(); }
	 */

}
