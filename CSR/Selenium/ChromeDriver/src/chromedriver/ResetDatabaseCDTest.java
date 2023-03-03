package chromedriver;

import org.openqa.selenium.*;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.appurtenances_attachments.AppurtenancesAndAttachments;

import chromedriver.CompaireDB.tables;
import chromedriver.UIElements.*;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ResetDatabaseCDTest extends BaseCDTest {
	
  @Test
  public void ResetDatabasePage() throws Exception {
		// Optional. If not specified, WebDriver searches the PATH for chromedriver.
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDriver\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// "d:/ChromeDriver/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.setExperimentalOption("useAutomationExtension", false);
		chromeOptions.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		// Name: CSR Database Test (Deleted Regularly) (CSR-DB-TEST)
		
		//Select CSR
		WebElement CSRNameField = driver.findElement(By.name("CSRsearch_tf"));
		CSRNameField.click();
		
		CSRNameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(100); // Let the user actually see something!
		CSRNameField.sendKeys("CSR-DB-TEST");
		Thread.sleep(200);
		
		WebElement Selection = driver.findElement(By.className("v-list-item"));
		Selection.click();
		
		Thread.sleep(100);
		
		boolean exists = true;
		
		//Delete CSR - Note that if the CSR did not exist (already was deleted or not created in the first place) then it will skip over the rest of the functions
		try {
			WebElement MoreOptions = driver.findElement(By.name("moreOptions_btn"));
			MoreOptions.click();
		}
		catch (Exception ex){
			exists = false;
		}
		
		Thread.sleep(200);
		
		if(exists)
		{
			WebElement DeletionButton = driver.findElements(By.name("CSRselectOption_vbtn")).get(1); //Both button are named the same thing. Grab the later.
			DeletionButton.click();
			
			Thread.sleep(500);
			
			WebElement validationField = driver.findElements(By.name("companyCode_tf")).get(1); //A background element shares the same name
			validationField.click();
			
			validationField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(100); // Let the user actually see something!
			validationField.sendKeys("CSR-DB-TEST");
			Thread.sleep(200);
			
			
			WebElement deleteButton = driver.findElement(By.name("delete_btn"));
			deleteButton.click();
			
			Thread.sleep(1000);
			driver.get("https://testcsr.pie.tdwilliamson.com:8443/"); //Page must be reloaded before re-creating the CSR
		}
		
		
		//Re-create CSR
		Thread.sleep(4000);
		WebElement companyCodeField = driver.findElements(By.name("companyCode_tf")).get(0);
		companyCodeField.click();
		
		companyCodeField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(100); // Let the user actually see something!
		companyCodeField.sendKeys("CSR-DB-TEST");
		Thread.sleep(200);
		
		
		WebElement companyDisplayName = driver.findElements(By.name("displayName_tf")).get(0);
		companyDisplayName.click();
		
		companyDisplayName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(100); // Let the user actually see something!
		companyDisplayName.sendKeys("CSR Database Test (Deleted Regularly)");
		Thread.sleep(200);
		
		
		WebElement createButton = driver.findElement(By.name("create_btn"));
		createButton.click();
		
		
		
		Thread.sleep(3000); // Let the user actually see something.
		driver.close();
		driver.quit();
  }
}