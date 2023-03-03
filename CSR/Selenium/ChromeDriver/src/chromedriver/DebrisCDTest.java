package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.CSREnums;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.deformations.dents.Dents;
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

public class DebrisCDTest extends BaseCDTest {

	
	ElementValidationInterface reportVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).debris.reportType.toString();
				
				return CSREnums.ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).debris.reportType);
			};
	ElementValidationInterface incClassVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.returnedValues 
						= (typedList.get(0).debris.includeDebrisClassification ? "True" : "False");
				
				return (typedList.get(0).debris.includeDebrisClassification == ele.bool);
			};
	ElementValidationInterface addClockVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.returnedValues 
						= (typedList.get(0).debris.orientationReportedInOClock ? "True" : "False");
				
				return (typedList.get(0).debris.orientationReportedInOClock == ele.bool);
			};
	ElementValidationInterface begEndVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.returnedValues 
						= (typedList.get(0).debris.includeLength ? "True" : "False");
				
				return (typedList.get(0).debris.includeLength == ele.bool);
			};
	
	ElementValidationInterface repDebNumVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.returnedValues 
						= (typedList.get(0).debris.reportSingleDebris.include ? "True" : "False")
						+ ", " + typedList.get(0).debris.reportSingleDebris.value;
				
				return (typedList.get(0).debris.reportSingleDebris.include == ele.bool)
						&& (Double.parseDouble(ele.txtValue) == (typedList.get(0).debris.reportSingleDebris.value));
			};
	ElementValidationInterface repDebSelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				String[] mapping = {"in", "\"", "mm", "ft", "'", "m"};
				
				ele.expectedValue = ele.bool + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).debris.reportSingleDebris.include ? "True" : "False")
						+ ", " + typedList.get(0).debris.reportSingleDebris.units;
				
				return (typedList.get(0).debris.reportSingleDebris.include == ele.bool)
						&& (mapping[ele.dropDownIndex].equals(typedList.get(0).debris.reportSingleDebris.units));
			};
			
	ElementValidationInterface componentListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.returnedValues
						= typedList.get(0).debris.componentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).debris.componentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).debris.componentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).debris.componentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).debris.componentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).debris.componentsOrder.hashtable.get(1).separatorSpacing
						+ ", " + typedList.get(0).debris.componentsOrder.hashtable.get(2).component
						+ ", " + typedList.get(0).debris.componentsOrder.hashtable.get(2).separator
						+ ", " + typedList.get(0).debris.componentsOrder.hashtable.get(2).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).debris.componentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).debris.componentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).debris.componentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).debris.componentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).debris.componentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).debris.componentsOrder.hashtable.get(1).separatorSpacing.toString()))
				&& (ele.validationStrings.get(6).equals(typedList.get(0).debris.componentsOrder.hashtable.get(2).component))
				&& (ele.validationStrings.get(7) == null || ele.validationStrings.get(7).equals(typedList.get(0).debris.componentsOrder.hashtable.get(2).separator.toString()))
				&& (ele.validationStrings.get(8) == null || ele.validationStrings.get(8).equals(typedList.get(0).debris.componentsOrder.hashtable.get(2).separatorSpacing.toString()));
			};
			
			
	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.returnedValues 
						= typedList.get(0).debris.ai.additionalNotes;
				
				return ele.txtValue.equals(typedList.get(0).debris.ai.additionalNotes);
			};
	ElementValidationInterface markingVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.returnedValues 
						= typedList.get(0).debris.ai.examples;
				
				return ele.txtValue.equals(typedList.get(0).debris.ai.examples);
			};
			
			
	
	public List<String> componentPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("O'clock");
		cPL.add("Debris length");
		cPL.add("Debris classification");
		
		return cPL;
	}
	
	@SuppressWarnings("unchecked")
	@ParameterizedTest
	@ValueSource(strings = {"Debris_1.json", "Debris_2.json"})
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
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-miscellaneous-debris&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		
		elements.add(new RGElement(driver, reportVal, "reportType_rg", argumentFile.defaultValues.defaultRGValues));
		try {
			
		elements.add(new CBElement(driver, incClassVal, "includeDebrisClassification_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, addClockVal, "reportInOClock_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, begEndVal, "includeBeginEndLength_cb", argumentFile.defaultValues.includeCB));
		boolean repDebris = argumentFile.defaultValues.includeIWVorIWVS;
		elements.add(new IWVElement(driver, repDebNumVal, "reportSingleDebris_iwvu", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), repDebris));
		elements.add(new IWVSElement(driver, repDebSelVal, "reportSingleDebris_iwvu", argumentFile.defaultValues.defaultIWVSValue, repDebris));
		elements.add(new DragListElement(driver, componentListVal, "debris_cl", 
				(List<String>) argumentFile.uniqueValues.get("debris_cl"), argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
		
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
		compTest.compaireDB(elements, "Debris", tables.MISCELLANEOUS, "DebrisResults", argumentFile.FileCounter);
	}
}