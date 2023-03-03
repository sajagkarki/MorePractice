package chromedriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;

import com.tdw.csr.dao.AppurtenancesAndAttachmentsDAO;
import com.tdw.csr.dao.BendsDAO;
import com.tdw.csr.dao.CSRFilter;
import com.tdw.csr.dao.EntityFilter;
import com.tdw.csr.entity.CSRDoc;
import com.tdw.csr.entity.appurtenances_attachments.AppurtenancesAndAttachments;
import com.tdw.csr.entity.bends.Bends;

import static org.junit.Assert.assertEquals;

import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class playground extends BaseCDTest {

	@Test
	public void testFittingsPage() throws Exception {

		// This is an example of getting a value from the DB
		// String blah = list.get(0).flanges.ai.stationing.dataSource.hashtable.get(0);

		// Optional. If not specified, WebDriver searches the PATH for chromedriver.
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDriver\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// "d:/ChromeDriver/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("useAutomationExtension", false);
		//chromeOptions.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));    
		chromeOptions.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://testcsr.pie.tdwilliamson.com:8443/csr/CICD/csr-aa-fittings");
		// driver.get("http://localhost:8082/csr/MGL/csr-aa-fittings");

		// Fullscreen page so selenium coordinates work
		Robot robot = new Robot();
		//robot.keyPress(KeyEvent.VK_F11);
		//Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		int innerHeight = Integer.parseInt(js.executeScript("return (window.innerHeight)").toString());
	    int windowHeight = driver.manage().window().getSize().getHeight();
		int adjustedHeight = windowHeight - innerHeight-10;
		
		//java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// the screen height
		//double screenHeight = screenSize.getHeight();
		//double screenWidth = screenSize.getWidth();
		
		WebElement editButton = driver.findElement(By.name("edit-icon_btn"));
		editButton.click();

		WebElement ele = driver.findElement(By.name("roundOrientation_cl"));
		Thread.sleep(1000); // Let the user actually see something!
		
		List<WebElement> dragElements = ele.findElements(By.name("draggable_btn"));
		
		

		Actions actions = new Actions(driver);
		actions.moveToElement(ele);
		actions.perform();
		Thread.sleep(3000);
		
		
		robot.mouseMove(0, 0);
		
		
		List <String> compListTxt = getComponentsTxt(dragElements);
		
		
		
		dragAndDropElement(dragElements.get(3).findElement(By.name("draggable_icon")),
				dragElements.get(0).findElement(By.name("draggable_icon")), 0,adjustedHeight);

		Thread.sleep(3000); // Let the user actually see something!
		// WebElement applyButton = driver.findElement(By.name("apply_btn"));
		// if (applyButton.isEnabled())
		// applyButton.click();
		// Thread.sleep(3000); // Let the user actually see something.
		// driver.close();
		// driver.quit();
	}
	
}
