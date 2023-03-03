package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.CSREnums;
import com.tdw.csr.entity.CSREnums.ReportType;
import com.tdw.csr.entity.CSREnums.ReportingType;
import com.tdw.csr.entity.casings.Casings;
import com.tdw.csr.entity.deformations.Deformations;

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


public class BoreRestrictionsCDTest extends BaseCDTest {

	ElementValidationInterface radioGroupval = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Deformations> typedList = (List<Deformations>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).boreRestrictions.reportType.toString();
				
				return ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).boreRestrictions.reportType);
	};
	ElementValidationInterface addLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Deformations> typedList = (List<Deformations>) list;
				
				ele.returnedValues 
						= (typedList.get(0).boreRestrictions.addLabelToDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).boreRestrictions.addLabelToDescription.value;
				
				return (typedList.get(0).boreRestrictions.addLabelToDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).boreRestrictions.addLabelToDescription.value));
			};
	ElementValidationInterface reportMinVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Deformations> typedList = (List<Deformations>) list;
				
				ele.returnedValues 
				= (typedList.get(0).boreRestrictions.includeReportMinBoreDiameter.include ? "True" : "False")
				+ ", " + typedList.get(0).boreRestrictions.includeReportMinBoreDiameter.value;
				
				return (typedList.get(0).boreRestrictions.includeReportMinBoreDiameter.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == typedList.get(0).boreRestrictions.includeReportMinBoreDiameter.value;
			};
	ElementValidationInterface reportSecVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Deformations> typedList = (List<Deformations>) list;
				
				ele.returnedValues 
				= (typedList.get(0).boreRestrictions.includeReportMinSecantBoreDiameter.include ? "True" : "False")
						+ ", " + typedList.get(0).boreRestrictions.includeReportMinSecantBoreDiameter.value;
				
				return (typedList.get(0).boreRestrictions.includeReportMinSecantBoreDiameter.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == typedList.get(0).boreRestrictions.includeReportMinSecantBoreDiameter.value;
			};
	ElementValidationInterface reportSecLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Deformations> typedList = (List<Deformations>) list;
				
				ele.returnedValues 
				= (typedList.get(0).boreRestrictions.includeLabelToSecantBoreDiameter.include ? "True" : "False")
						+ ", " + typedList.get(0).boreRestrictions.includeLabelToSecantBoreDiameter.value;
				
				return (typedList.get(0).boreRestrictions.includeLabelToSecantBoreDiameter.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).boreRestrictions.includeLabelToSecantBoreDiameter.value);
			};
	ElementValidationInterface componentListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Deformations> typedList = (List<Deformations>) list;
				
				ele.returnedValues
						= typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(1).separatorSpacing
						+ ", " + typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(2).component
						+ ", " + typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(2).separator
						+ ", " + typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(2).separatorSpacing
						+ ", " + typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(3).component
						+ ", " + typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(3).separator
						+ ", " + typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(3).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(1).separatorSpacing.toString()))
				&& (ele.validationStrings.get(6).equals(typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(2).component))
				&& (ele.validationStrings.get(7) == null || ele.validationStrings.get(7).equals(typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(2).separator.toString()))
				&& (ele.validationStrings.get(8) == null || ele.validationStrings.get(8).equals(typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(2).separatorSpacing.toString()))
				&& (ele.validationStrings.get(9).equals(typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(3).component))
				&& (ele.validationStrings.get(10) == null || ele.validationStrings.get(10).equals(typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(3).separator.toString()))
				&& (ele.validationStrings.get(11) == null || ele.validationStrings.get(11).equals(typedList.get(0).boreRestrictions.componentsOrder.hashtable.get(3).separatorSpacing.toString()));
			};
	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Deformations> typedList = (List<Deformations>) list;
				
				ele.returnedValues 
						= typedList.get(0).boreRestrictions.ai.additionalNotes;
				
				return (ele.txtValue.equals(typedList.get(0).boreRestrictions.ai.additionalNotes));
			};
	ElementValidationInterface examplesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Deformations> typedList = (List<Deformations>) list;
				
				ele.returnedValues 
						= typedList.get(0).boreRestrictions.ai.examples;
				
				return (ele.txtValue.equals(typedList.get(0).boreRestrictions.ai.examples));
			};
			
	public List<String> componentPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Reference");
		cPL.add("Minimum Bore");
		cPL.add("Minimum Secant");	
		cPL.add("Default Label");
		return cPL;
	}
	
	@SuppressWarnings("unchecked")
	@ParameterizedTest
	@ValueSource(strings = {"BoreRestrictions_1.json", "BoreRestrictions_2.json", "BoreRestrictions_3.json"})
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
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-deformations-borerestrictions&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
			
		//Deformations report label and classification
		boolean report = argumentFile.defaultValues.defaultRGValues == 1 ? true : false;
		elements.add(new RGElement(driver, radioGroupval, "reportType_rg", report ? 1 : 0));
		
		//Available options change with radio group selection
		if(report)
		{
			elements.add(new IWVElement(driver, addLabelVal, "addLabel_iwvs", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.add(new IWVElement(driver, reportMinVal, "includeReportMinBoreDiameter_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			
			boolean minDiam = (Boolean) argumentFile.uniqueValues.get("includeReportMinSecantBoreDiameter_iwv");
			elements.add(new IWVElement(driver, reportSecVal, "includeReportMinSecantBoreDiameter_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), minDiam));
			if(minDiam)
			{
				elements.add(new IWVElement(driver, reportSecLabelVal, "includeLabelToSecantBoreDiameter_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			}
			elements.add(new DragListElement(driver, componentListVal, "bore_cl", 
					(List<String>) argumentFile.uniqueValues.get("bore_cl"), argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
		}
		
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
		compTest.compaireDB(elements, "BoreRestrictions", tables.DEFORMATIONS, "BoreRestrictionsResults", argumentFile.FileCounter);
	}
}