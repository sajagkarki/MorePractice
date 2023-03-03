package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.CSREnums;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.miscellaneous.Miscellaneous;

import chromedriver.CompaireDB.tables;
//This wildcard import is meant to import all subclasses of UIElements
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

public class FailedSensorsCDTest extends BaseCDTest {
	
	ElementValidationInterface reportVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).failedSensors.reportType.toString();
				
				return CSREnums.ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).failedSensors.reportType);
			};
			
	ElementValidationInterface sensorVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.returnedValues 
						= (typedList.get(0).failedSensors.customDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).failedSensors.customDescription.value;
				
				return (typedList.get(0).failedSensors.customDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).failedSensors.customDescription.value));
			};
	ElementValidationInterface begSensorVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.returnedValues 
						= (typedList.get(0).failedSensors.beginFailedSensorDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).failedSensors.beginFailedSensorDescription.value;
				
				return (typedList.get(0).failedSensors.beginFailedSensorDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).failedSensors.beginFailedSensorDescription.value));
			};
	ElementValidationInterface endSensorVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.returnedValues 
						= (typedList.get(0).failedSensors.endFailedSensorDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).failedSensors.endFailedSensorDescription.value;
				
				return (typedList.get(0).failedSensors.endFailedSensorDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).failedSensors.endFailedSensorDescription.value));
			};
			
	ElementValidationInterface techVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.returnedValues 
						= (typedList.get(0).failedSensors.includeSensorNumber ? "True" : "False");
				
				return (typedList.get(0).failedSensors.includeSensorNumber == ele.bool);
			};
	ElementValidationInterface sensorNumVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.returnedValues 
						= (typedList.get(0).failedSensors.includeTechnology ? "True" : "False");
				
				return (typedList.get(0).failedSensors.includeTechnology == ele.bool);
			};
			
	ElementValidationInterface componentListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.returnedValues
						= typedList.get(0).failedSensors.componentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).failedSensors.componentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).failedSensors.componentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).failedSensors.componentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).failedSensors.componentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).failedSensors.componentsOrder.hashtable.get(1).separatorSpacing
						+ ", " + typedList.get(0).failedSensors.componentsOrder.hashtable.get(2).component
						+ ", " + typedList.get(0).failedSensors.componentsOrder.hashtable.get(2).separator
						+ ", " + typedList.get(0).failedSensors.componentsOrder.hashtable.get(2).separatorSpacing
						+ ", " + typedList.get(0).failedSensors.componentsOrder.hashtable.get(3).component
						+ ", " + typedList.get(0).failedSensors.componentsOrder.hashtable.get(3).separator
						+ ", " + typedList.get(0).failedSensors.componentsOrder.hashtable.get(3).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).failedSensors.componentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).failedSensors.componentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).failedSensors.componentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).failedSensors.componentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).failedSensors.componentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).failedSensors.componentsOrder.hashtable.get(1).separatorSpacing.toString()))
				&& (ele.validationStrings.get(6).equals(typedList.get(0).failedSensors.componentsOrder.hashtable.get(2).component))
				&& (ele.validationStrings.get(7) == null || ele.validationStrings.get(7).equals(typedList.get(0).failedSensors.componentsOrder.hashtable.get(2).separator.toString()))
				&& (ele.validationStrings.get(8) == null || ele.validationStrings.get(8).equals(typedList.get(0).failedSensors.componentsOrder.hashtable.get(2).separatorSpacing.toString()))
				&& (ele.validationStrings.get(9).equals(typedList.get(0).failedSensors.componentsOrder.hashtable.get(3).component))
				&& (ele.validationStrings.get(10) == null || ele.validationStrings.get(10).equals(typedList.get(0).failedSensors.componentsOrder.hashtable.get(3).separator.toString()))
				&& (ele.validationStrings.get(11)) == null || ele.validationStrings.get(11).equals(typedList.get(0).failedSensors.componentsOrder.hashtable.get(3).separatorSpacing.toString());
			};
			
	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.returnedValues 
						= typedList.get(0).failedSensors.ai.additionalNotes;
				
				return ele.txtValue.equals(typedList.get(0).failedSensors.ai.additionalNotes);
			};
	ElementValidationInterface markingVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.returnedValues 
						= typedList.get(0).failedSensors.ai.examples;
				
				return ele.txtValue.equals(typedList.get(0).failedSensors.ai.examples);
			};
	
	
	public List<String> componentPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Technology");
		cPL.add("Failed Sensor Object Type");
		cPL.add("Label");
		cPL.add("Sensor Number");
		
		return cPL;
	}

	@SuppressWarnings("unchecked")
	@ParameterizedTest
	@ValueSource(strings = {"FailedSensors_1.json", "FailedSensors_2.json"})
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
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-miscellaneous-failedsensors&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
			
		elements.add(new RGElement(driver, reportVal, "reportType_rg", argumentFile.defaultValues.defaultRGValues));
		
		elements.add(new IWVElement(driver, sensorVal, "customDescription_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, begSensorVal, "beginFailedSensorDescription_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, endSensorVal, "endFailedSensorDescription_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new CBElement(driver, techVal, "includeTechnology_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, sensorNumVal, "includeSensorNumber_cb", argumentFile.defaultValues.includeCB));
		
		elements.add(new DragListElement(driver, componentListVal, "failedSensor_cl", (List<String>) argumentFile.uniqueValues.get("failedSensor_cl"), 
				argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
		
		elements.add(new TextElement(driver, deviationsVal, "additionalNotes_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, markingVal, "examples_ta", argumentFile.defaultValues.defaultTextValue));
		
		} catch(Exception ex) { //Configuration Error
			elements.clear();
			elements.add(new ConfigurationErrorElement(ex.getMessage()));
		}
		
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
		compTest.compaireDB(elements, "Failed Sensors", tables.MISCELLANEOUS, "FailedSensorsResults", argumentFile.FileCounter);
	}
}