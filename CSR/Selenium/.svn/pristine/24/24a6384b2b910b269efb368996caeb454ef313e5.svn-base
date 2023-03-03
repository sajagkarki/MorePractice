package chromedriver;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.CSREnums.ReportingType;
import com.tdw.csr.entity.CSREnums.Standard;
import com.tdw.csr.entity.appurtenances_attachments.AppurtenancesAndAttachments;

import chromedriver.CompaireDB.tables;
import chromedriver.UIElements.CBElement;
import chromedriver.UIElements.ConfigurationErrorElement;
import chromedriver.UIElements.DragListElement;
import chromedriver.UIElements.IWVElement;
import chromedriver.UIElements.OrientationDescElement;
import chromedriver.UIElements.StationingSelectElement;
import chromedriver.UIElements.TextElement;
import chromedriver.UIElements.tryCloseDialogElement;
import chromedriver.UIElements.SelectElement;
import chromedriver.UIElements.RGElement;
import chromedriver.UIElements.IWVSElement;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.support.ui.*;

public class PipeSuportsCDTest extends BaseCDTest {

	ElementValidationInterface descAllCapsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).pipeSupports.descriptionAllCaps ? "True" : "False";
				
				return ele.bool == typedList.get(0).pipeSupports.descriptionAllCaps;
			};
	ElementValidationInterface addBegLabelVal = 
	(UIElements ele, List<? extends Entity> list) -> {
		List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
		
		ele.returnedValues 
				= (typedList.get(0).pipeSupports.customDesc.include ? "True" : "False")
				+ ", " + typedList.get(0).pipeSupports.customDesc.value;
		
		return (typedList.get(0).pipeSupports.customDesc.include == ele.bool)
				&& (ele.txtValue.equals(typedList.get(0).pipeSupports.customDesc.value));
	};
	ElementValidationInterface maxSeriesDistVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= String.valueOf(typedList.get(0).pipeSupports.multiplePipeSupports.maximumDistanceForSeries.value);
				
				return (Double.valueOf(ele.txtValue) == (typedList.get(0).pipeSupports.multiplePipeSupports.maximumDistanceForSeries.value));
			};
	ElementValidationInterface maxSeriesUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				String[] mapping = {"ft", "m"};
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= String.valueOf(typedList.get(0).pipeSupports.multiplePipeSupports.maximumDistanceForSeries.units);
				
				return typedList.get(0).pipeSupports.multiplePipeSupports.maximumDistanceForSeries.units.equals(ele.expectedValue);
			};
	ElementValidationInterface excludeWithinVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).pipeSupports.multiplePipeSupports.excludeFromSeriesIfNearValve.include ? "True" : "False";
				
				return ele.bool == typedList.get(0).pipeSupports.multiplePipeSupports.excludeFromSeriesIfNearValve.include;
			};
	ElementValidationInterface anchorVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).pipeSupports.includeReportBeginEndAnchors ? "True" : "False";
				
				return ele.bool == typedList.get(0).pipeSupports.includeReportBeginEndAnchors;
			};
	ElementValidationInterface excludeWithinDistVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
				= (typedList.get(0).pipeSupports.multiplePipeSupports.excludeFromSeriesIfNearValve.include ? "True" : "False")
				+ ", " + typedList.get(0).pipeSupports.multiplePipeSupports.excludeFromSeriesIfNearValve.value;
		
		return (typedList.get(0).pipeSupports.multiplePipeSupports.excludeFromSeriesIfNearValve.include == ele.bool)
				&& (Double.valueOf(ele.txtValue) == (typedList.get(0).pipeSupports.multiplePipeSupports.excludeFromSeriesIfNearValve.value));
			};
	ElementValidationInterface excludeWithinUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				String[] mapping = {"in", "mm", "ft", "m"};
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).pipeSupports.multiplePipeSupports.excludeFromSeriesIfNearValve.include ? "True" : "False")
								+ ", " + String.valueOf(typedList.get(0).pipeSupports.multiplePipeSupports.excludeFromSeriesIfNearValve.units);
				
				return (typedList.get(0).pipeSupports.multiplePipeSupports.excludeFromSeriesIfNearValve.include == ele.bool)
						&& typedList.get(0).pipeSupports.multiplePipeSupports.excludeFromSeriesIfNearValve.units.equals(mapping[ele.dropDownIndex]);
			};	
	ElementValidationInterface saddleDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pipeSupports.saddlesCustomDesc.include ? "True" : "False")
						+ ", " + typedList.get(0).pipeSupports.saddlesCustomDesc.value;
				
				return (typedList.get(0).pipeSupports.saddlesCustomDesc.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).pipeSupports.saddlesCustomDesc.value));
			};
	ElementValidationInterface notesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).pipeSupports.ai.additionalNotes;
				
				return ele.txtValue.equals(typedList.get(0).pipeSupports.ai.additionalNotes);
			};
	ElementValidationInterface markingVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).pipeSupports.ai.examples;
				
				return ele.txtValue.equals(typedList.get(0).pipeSupports.ai.examples);
			};
	ElementValidationInterface radioGroupval = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				String[] mapping = {"FIRST_AND_LAST", "ALL_INDIVIDUALLY", "ALL_IN_SERIES"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= String.valueOf(typedList.get(0).pipeSupports.multiplePipeSupports.reportingType);
				
				return ReportingType.valueOf(ele.expectedValue).equals(typedList.get(0).pipeSupports.multiplePipeSupports.reportingType);
			};	
	ElementValidationInterface classificationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				String[] mapping = {
						"Begin [Classification] / End [Classification]", 
						"[Classification] Begin / [Classification] End", 
						"[Classification] [X] of [Y]", 
						"[Classification] - [X] of [Y]",
						"Begin [Classification]s / End [Classification]s", 
						"[Classification]s Begin / [Classification]s End", 
						"[Classification]s [X] of [Y]",
						"[Classification]s - [X] of [Y]",
						"Start [Classification] / End [Classification]",
						"[Classification] Start / [Classification] End",
						"[Classification]s Start / [Classification]s End",
						"[Classification], Begin in Series / [Classification], End in Series"
						};
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= String.valueOf(typedList.get(0).pipeSupports.multiplePipeSupports.firstAndLastLabelDesc);
				
				return typedList.get(0).pipeSupports.multiplePipeSupports.firstAndLastLabelDesc.equals(ele.expectedValue);
			};	
	ElementValidationInterface reportOnlyFLVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).pipeSupports.multiplePipeSupports.reportOnlyFirstAndLast ? "True" : "False";
				
				return ele.bool == typedList.get(0).pipeSupports.multiplePipeSupports.reportOnlyFirstAndLast;
			};		
	ElementValidationInterface allPipeSupVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				String[] mapping = {
						"[Classification] [X] of [Y]", 
						"[Classification] - [X] of [Y]"
						};
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= String.valueOf(typedList.get(0).pipeSupports.multiplePipeSupports.allInSeriesCustomDesc);
				
				return typedList.get(0).pipeSupports.multiplePipeSupports.allInSeriesCustomDesc.equals(ele.expectedValue);
			};	
					
	@SuppressWarnings("unchecked")
	@ParameterizedTest
	@ValueSource(strings = {"PipeSupports_1.json", "PipeSupports_2.json", "PipeSupports_3.json"})
	public void testPipeSupportsPage(String argument) throws Exception {
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
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-aa-pipeSupports&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
		
		elements.add(new CBElement(driver, descAllCapsVal, "descriptionAllCaps_cb", argumentFile.defaultValues.includeCB));
		elements.add(new IWVElement(driver, addBegLabelVal, "addBegLabel_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new TextElement(driver, maxSeriesDistVal, "maximumDistance_va", Integer.toString(argumentFile.defaultValues.defaultSelectValue)));
		elements.add(new SelectElement(driver, maxSeriesUnitVal, "units_s", argumentFile.defaultValues.defaultSelectValue));
		
		boolean excludeWithin = argumentFile.defaultValues.includeIWVorIWVS;
		elements.add(new IWVElement(driver, excludeWithinDistVal, "excludeFromSeriesIfNearValve_iwv", Integer.toString(argumentFile.defaultValues.defaultSelectValue), excludeWithin));
		elements.add(new IWVSElement(driver, excludeWithinUnitVal, "excludeFromSeriesIfNearValve_iwv", argumentFile.defaultValues.defaultIWVSValue, excludeWithin));

		int selection = argumentFile.defaultValues.defaultRGValues;
		elements.add(new RGElement(driver, radioGroupval, "reportingType_rg", selection));
		switch(selection) {
		case 0:
			elements.add(new SelectElement(driver, classificationsVal, "firstAndLastLabel_s", argumentFile.defaultValues.defaultSelectValue));
			elements.add(new CBElement(driver, reportOnlyFLVal, "reportOnlyFirstAndLast_cb", argumentFile.defaultValues.includeCB));
			break;
		case 1:
			break; //No options
		case 2:
			elements.add(new SelectElement(driver, allPipeSupVal, "allInSeriesCustomDesc_s", argumentFile.defaultValues.defaultSelectValue));
			break;
		}

		elements.add(new IWVElement(driver, saddleDescVal, "addEndLabel_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new CBElement(driver, anchorVal, "includeReportAnchors_cb", argumentFile.defaultValues.includeCB));
		elements.add(new TextElement(driver, notesVal, "additionalNotes_ta", argumentFile.defaultValues.defaultTextValue));		
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
		compTest.compaireDB(elements, "PipeSupports", tables.APPURTENANCES_AND_ATTACHMENTS, "PipeSupportsResults", argumentFile.FileCounter);
	}
}