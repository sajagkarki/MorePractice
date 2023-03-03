package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.CSREnums;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.CSREnums.RepairsUnderType;
import com.tdw.csr.entity.metal_loss.MetalLoss;

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

public class MillAnomaliesCDTest extends BaseCDTest {
	
	ElementValidationInterface includeClassVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).millAnomalies.includeClassification ? "True" : "False");
				
				return (typedList.get(0).millAnomalies.includeClassification == ele.bool);
			};
			
	ElementValidationInterface RGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).millAnomalies.reportType.toString();
				
				return CSREnums.ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).millAnomalies.reportType);
			};	
	ElementValidationInterface depthRelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).millAnomalies.includeReportDepth ? "True" : "False");
				
				return (typedList.get(0).millAnomalies.includeReportDepth == ele.bool);
			};
	ElementValidationInterface depthVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).millAnomalies.includeDepth ? "True" : "False");
				
				return (typedList.get(0).millAnomalies.includeDepth == ele.bool);
			};
	ElementValidationInterface repDigVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).millAnomalies.addRepairDigInfoToDesc ? "True" : "False");
				
				return (typedList.get(0).millAnomalies.addRepairDigInfoToDesc == ele.bool);
			};
			
	
	ElementValidationInterface componentListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues
						= typedList.get(0).millAnomalies.componentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).millAnomalies.componentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).millAnomalies.componentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).millAnomalies.componentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).millAnomalies.componentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).millAnomalies.componentsOrder.hashtable.get(1).separatorSpacing
						+ ", " + typedList.get(0).millAnomalies.componentsOrder.hashtable.get(2).component
						+ ", " + typedList.get(0).millAnomalies.componentsOrder.hashtable.get(2).separator
						+ ", " + typedList.get(0).millAnomalies.componentsOrder.hashtable.get(2).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).millAnomalies.componentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).millAnomalies.componentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).millAnomalies.componentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).millAnomalies.componentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).millAnomalies.componentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).millAnomalies.componentsOrder.hashtable.get(1).separatorSpacing.toString()))
				&& (ele.validationStrings.get(6).equals(typedList.get(0).millAnomalies.componentsOrder.hashtable.get(2).component))
				&& (ele.validationStrings.get(7) == null || ele.validationStrings.get(7).equals(typedList.get(0).millAnomalies.componentsOrder.hashtable.get(2).separator.toString()))
				&& (ele.validationStrings.get(8) == null || ele.validationStrings.get(8).equals(typedList.get(0).millAnomalies.componentsOrder.hashtable.get(2).separatorSpacing.toString()));
			};
			
			
	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= typedList.get(0).millAnomalies.ai.additionalNotes;
				
				return ele.txtValue.equals(typedList.get(0).millAnomalies.ai.additionalNotes);
			};
	ElementValidationInterface examplesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= typedList.get(0).millAnomalies.ai.examples;
				
				return ele.txtValue.equals(typedList.get(0).millAnomalies.ai.examples);
			};

	public List<String> componentPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Classification");
		cPL.add("Dig/Repair Info");
		cPL.add("Depth");
		
		return cPL;
	}
	
	@SuppressWarnings("unchecked")
	@ParameterizedTest
	@ValueSource(strings = {"MillAnomalies_1.json", "MillAnomalies_2.json", "MillAnomalies_3.json"})
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
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-metal_loss-millanomalies&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
			
		elements.add(new CBElement(driver, includeClassVal, "includeClassification_cb", argumentFile.defaultValues.includeCB));
		
		boolean reportMillAnomalies = argumentFile.defaultValues.defaultRGValues == 1 ? true : false;
		elements.add(new RGElement(driver, RGVal, "reportType_rg", reportMillAnomalies ? 1 : 0));
		if(reportMillAnomalies) {
			elements.add(new CBElement(driver, depthRelVal, "includeReportDepth_cb", argumentFile.defaultValues.includeCB));
			elements.add(new CBElement(driver, depthVal, "includeDepth_cb", argumentFile.defaultValues.includeCB));
			elements.add(new CBElement(driver, repDigVal, "addRepairDigInfoToDesc_cb", argumentFile.defaultValues.includeCB));
		}
		

		elements.add(new DragListElement(driver, componentListVal, "componentsOrder_cl", (List<String>) argumentFile.uniqueValues.get("componentsOrder_cl"), 
				argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
		elements.add(new TextElement(driver, deviationsVal, "additionalNotes_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, examplesVal, "examples_ta", argumentFile.defaultValues.defaultTextValue));
		
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
		compTest.compaireDB(elements, "Mill Anomalies", tables.METAL_LOSS, "MillAnomaliesResults", argumentFile.FileCounter);
	}
}