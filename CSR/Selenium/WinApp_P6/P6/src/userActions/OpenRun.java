package userActions;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import runner.*;

public class OpenRun  extends Setup  {

	public OpenRun() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("deprecation")
	public void openRun(String run, String dir) {

		try {
			clearRSFViews(dir, run);
			AppSession.findElementByName("Open").click();
			Thread.sleep(1000);
			// AppSession.getKeyboard().sendKeys(dir);;
			Actions actions = new Actions(AppSession);
			actions.sendKeys(dir + run).perform();
			actions.sendKeys(Keys.ENTER).perform();
			// wait 5 seconds to load the run
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void clearRSFViews(String dir, String file) {
		Path path = Paths.get(dir + file);
		Charset charset = StandardCharsets.UTF_8;

		String content;
		try {
			content = new String(Files.readAllBytes(path), charset);
			content = content.replaceAll("<Visibility.*?>[\\d\\D]*?</Visibility>", "");
			Files.write(path, content.getBytes(charset));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
