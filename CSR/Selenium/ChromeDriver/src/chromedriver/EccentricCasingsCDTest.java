package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.CSREnums.ReportingType;
import com.tdw.csr.entity.casings.Casings;

import chromedriver.CompaireDB.tables;
import chromedriver.UIElements.*;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EccentricCasingsCDTest extends BaseCDTest {

	ElementValidationInterface radioGroupval = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Casings> typedList = (List<Casings>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= String.valueOf(typedList.get(0).eccentricCasing.reportType);
				
				return ele.expectedValue.equals(String.valueOf(typedList.get(0).eccentricCasing.reportType));
			};	
	ElementValidationInterface addBegLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				ele.returnedValues 
						= (typedList.get(0).eccentricCasing.descBeginCasing.include ? "True" : "False")
						+ ", " + typedList.get(0).eccentricCasing.descBeginCasing.value;
				
				return (typedList.get(0).eccentricCasing.descBeginCasing.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).eccentricCasing.descBeginCasing.value));
			};
	ElementValidationInterface addEndLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				ele.returnedValues 
						= (typedList.get(0).eccentricCasing.descEndCasing.include ? "True" : "False")
						+ ", " + typedList.get(0).eccentricCasing.descEndCasing.value;
				
				return (typedList.get(0).eccentricCasing.descEndCasing.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).eccentricCasing.descEndCasing.value));
			};
	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				ele.returnedValues 
						= typedList.get(0).eccentricCasing.ai.additionalNotes;
				
				return (ele.txtValue.equals(typedList.get(0).eccentricCasing.ai.additionalNotes));
			};
	ElementValidationInterface examplesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				ele.returnedValues 
						= typedList.get(0).eccentricCasing.ai.examples;
				
				return (ele.txtValue.equals(typedList.get(0).eccentricCasing.ai.examples));
			};

	@ParameterizedTest
	@ValueSource(strings = {"EccentricCasings_1.json", "EccentricCasings_2.json"})
	public void testFittingsPage(String argument) throws Exception {
	  	//Load Arguments
	  	String JSONname = argument;
	  	
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader("..\\Chromedriver\\JSONTestConfigFiles\\" + JSONname));
		GenerateJSONInputFiles.testInputFile argumentFile = gson.fromJson(reader, GenerateJSONInputFiles.testInputFile.class);
		
		
		// Optional. If not specified, WebDriver searches the PATH for chromedriver.
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDriver\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// "d:/ChromeDriver/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.setExperimentalOption("useAutomationExtension", false);
		chromeOptions.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-casings-eccentric&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
			
		//Casings report label and classification
		elements.add(new RGElement(driver, radioGroupval, "reportType_rg", argumentFile.defaultValues.defaultRGValues));
		elements.add(new IWVElement(driver, addBegLabelVal, "descBeginCasing_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, addEndLabelVal, "descEndCasing_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new TextElement(driver, deviationsVal, "additionalNotes_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, examplesVal, "examples_ta", argumentFile.defaultValues.defaultTextValue));
		
		} catch(Exception ex) { //Configuration Error
			elements.clear();
			elements.add(new ConfigurationErrorElement(ex.getMessage()));
		}
		
		Thread.sleep(3000);
		

		WebElement editButton = driver.findElement(By.name("edit-icon_btn"));
		editButton.click();
		
		Thread.sleep(200);

		for (UIElements e : elements) {
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
		compTest.compaireDB(elements, "EccentricCasings", tables.CASINGS, "EccentricCasingsResults", argumentFile.FileCounter);
	}
}