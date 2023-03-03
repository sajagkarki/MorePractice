package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.CSREnums.ReportType;
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

public class GMACDTest extends BaseCDTest {
	
	ElementValidationInterface radioGroupval = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Deformations> typedList = (List<Deformations>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).gma.reportType.toString();
				
				return ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).gma.reportType);
	};
	ElementValidationInterface underSpecVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Deformations> typedList = (List<Deformations>) list;
				
				ele.returnedValues 
				= (typedList.get(0).gma.includeReportUnderSpecGMA ? "True" : "False");
				
				return (typedList.get(0).gma.includeReportUnderSpecGMA == ele.bool);
			};
	ElementValidationInterface customLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Deformations> typedList = (List<Deformations>) list;
				
				ele.returnedValues 
						= (typedList.get(0).gma.customDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).gma.customDescription.value;
				
				return (typedList.get(0).gma.customDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).gma.customDescription.value.toString()));
			};
	ElementValidationInterface incIntDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Deformations> typedList = (List<Deformations>) list;
				
				ele.returnedValues 
				= (typedList.get(0).gma.showInteractionDesc ? "True" : "False");
				
				return (typedList.get(0).gma.showInteractionDesc == ele.bool);
			};
			
	ElementValidationInterface componentListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Deformations> typedList = (List<Deformations>) list;
				
				ele.returnedValues
						= typedList.get(0).gma.componentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).gma.componentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).gma.componentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).gma.componentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).gma.componentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).gma.componentsOrder.hashtable.get(1).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).gma.componentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).gma.componentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).gma.componentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).gma.componentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).gma.componentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).gma.componentsOrder.hashtable.get(1).separatorSpacing.toString()));
			};
	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Deformations> typedList = (List<Deformations>) list;
				
				ele.returnedValues 
						= typedList.get(0).gma.ai.additionalNotes;
				
				return (ele.txtValue.equals(typedList.get(0).gma.ai.additionalNotes));
			};
	ElementValidationInterface examplesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Deformations> typedList = (List<Deformations>) list;
				
				ele.returnedValues 
					= typedList.get(0).gma.ai.examples;
		
				return (ele.txtValue.equals(typedList.get(0).gma.ai.examples));
			};
			
	public List<String> dragPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Interaction Info");
		cPL.add("Label");
		
		return cPL;
	}

	@SuppressWarnings("unchecked")
	@ParameterizedTest
	@ValueSource(strings = {"GMA_1.json", "GMA_2.json", "GMA_3.json"})
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
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-deformations-gma&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
			
		//Casings report label and classification
		boolean report = argumentFile.defaultValues.defaultRGValues == 1 ? true : false;
		elements.add(new RGElement(driver, radioGroupval, "reportType_rg", report ? 1 : 0));
		
		//Available options change with radio group selection
		if(report)
		{
			elements.add(new CBElement(driver, underSpecVal, "includeReportUnderSpecDents_cb", argumentFile.defaultValues.includeCB));
			elements.add(new IWVElement(driver, customLabelVal, "customDescription_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.add(new CBElement(driver, incIntDescVal, "showInteractionDesc_cb", argumentFile.defaultValues.includeCB));
			elements.add(new DragListElement(driver, componentListVal, "gma_cl", (List<String>) argumentFile.uniqueValues.get("gma_cl"), 
					argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
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
		compTest.compaireDB(elements, "GMA", tables.DEFORMATIONS, "GMAResults", argumentFile.FileCounter);
	}
}