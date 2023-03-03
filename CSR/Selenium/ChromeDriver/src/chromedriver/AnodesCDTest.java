package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.appurtenances_attachments.AppurtenancesAndAttachments;

import chromedriver.CompaireDB.tables;
import chromedriver.UIElements.*;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;

public class AnodesCDTest extends BaseCDTest {
	
	ElementValidationInterface allCapsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).anodes.descriptionAllCaps ? "True" : "False";
				
				return ele.bool == typedList.get(0).anodes.descriptionAllCaps;
			};
	ElementValidationInterface defaultDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).anodes.customDesc.include ? "True" : "False")
						+ ", " + typedList.get(0).anodes.customDesc.value;
				
				return (typedList.get(0).anodes.customDesc.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).anodes.customDesc.value);
			};
	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).anodes.ai.additionalNotes;
				
				return ele.txtValue.equals(typedList.get(0).anodes.ai.additionalNotes);
			};
	ElementValidationInterface markingVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).anodes.ai.examples;
				
				return ele.txtValue.equals(typedList.get(0).anodes.ai.examples);
			};

	@ParameterizedTest
	@ValueSource(strings = { "Anodes_1.json", "Anodes_2.json" })
	public void testAnodesPage(String JSONname) throws Exception {
		GenerateJSONInputFiles.testInputFile argumentFile = super.readTestInputFile(JSONname);

		ChromeOptions chromeOptions = getChromeOptions(BrowserLaunchMode.ChromeStandardDev);
		WebDriver driver = new ChromeDriver(chromeOptions);
//		JavascriptExecutor jsexec = ((JavascriptExecutor) driver);

		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-aa-anodes&auth_token=" + JWT_QA);

//		Thread.sleep(20000); // uncomment this to allow humans to catch up in the UI.

		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
			
			elements.add(new CBElement(driver, null, "descriptionAllCaps_cb", argumentFile.defaultValues.includeCB)); //Ensures that the apply button is functional - workaround for separate bug
			elements.add(new CBElement(driver, allCapsVal, "descriptionAllCaps_cb", argumentFile.defaultValues.includeCB));
			elements.add(new IWVElement(driver, defaultDescVal, "prefixLabel_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.add(new TextElement(driver, deviationsVal, "additionalNotes_ta", argumentFile.defaultValues.defaultTextValue));
			elements.add(new TextElement(driver, markingVal, "examples_ta", argumentFile.defaultValues.defaultTextValue));
			
		}
		catch(Exception ex) { //Configuration Error
			elements.clear();
			elements.add(new ConfigurationErrorElement(ex.getMessage()));
		}
		
		
		WebElement editButton = driver.findElement(By.name("edit-icon_btn"));
		editButton.click();
		
		Thread.sleep(200);

		for (UIElements e : elements) {
			if(e.getClass().equals(ConfigurationErrorElement.class));
			
			
			try {
				e.runTestConfiguration();
			}
			catch(Exception ex) {
				e.failedExecution = true;
				e.exceptionMessage = ex.getMessage();
				
				//Ensure that no dialog remains open after a failure
				try {
					UIElements closeEle = new tryCloseDialogElement(driver);
					closeEle.runTestConfiguration();
				}
				catch(Exception ignoreEx) { } //Ignore this, as not all elements will have a dialog
			}
		}
		
		WebElement applyButton = driver.findElement(By.name("apply_btn"));
		if (applyButton.isEnabled())
			applyButton.click();
		Thread.sleep(3000); // Let the user actually see something.
		driver.close();
		driver.quit();
		
		//Run database comparison
		CompaireDB compTest = new CompaireDB();
		compTest.compaireDB(elements, "Anodes", tables.APPURTENANCES_AND_ATTACHMENTS, "AnodesResults", argumentFile.FileCounter);
  }
}