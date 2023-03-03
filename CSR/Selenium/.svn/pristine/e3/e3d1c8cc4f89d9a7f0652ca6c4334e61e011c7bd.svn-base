package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.CSREnums.ReportingType;
import com.tdw.csr.entity.CSREnums.Standard;
import com.tdw.csr.entity.appurtenances_attachments.AppurtenancesAndAttachments;
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

public class CasingsCDTest extends BaseCDTest {
	
	ElementValidationInterface addLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				ele.returnedValues 
						= (typedList.get(0).casing.descBeginCasing.include ? "True" : "False")
						+ ", " + typedList.get(0).casing.descBeginCasing.value;
				
				return (typedList.get(0).casing.descBeginCasing.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).casing.descBeginCasing.value));
			};
	ElementValidationInterface addStaPrefixVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				ele.returnedValues 
						= (typedList.get(0).casing.stationingPrefixBegin.include ? "True" : "False")
						+ ", " + typedList.get(0).casing.stationingPrefixBegin.value;
				
				return (typedList.get(0).casing.stationingPrefixBegin.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).casing.stationingPrefixBegin.value));
			};
	ElementValidationInterface encloseStaVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				ele.returnedValues 
						= (typedList.get(0).casing.encloseStationingInBracesBegin ? "True" : "False");
				
				return (typedList.get(0).casing.encloseStationingInBracesBegin == ele.bool);
			};
	ElementValidationInterface notIncludeBeginVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				ele.returnedValues 
						= (typedList.get(0).casing.omitLocalizationSeparatorBegin ? "True" : "False");
				
				return (typedList.get(0).casing.omitLocalizationSeparatorBegin == ele.bool);
			};
	ElementValidationInterface beginListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				ele.returnedValues
						= typedList.get(0).casing.componentsOrderBegin.hashtable.get(0).component
						+ ", " + typedList.get(0).casing.componentsOrderBegin.hashtable.get(0).separator
						+ ", " + typedList.get(0).casing.componentsOrderBegin.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).casing.componentsOrderBegin.hashtable.get(1).component
						+ ", " + typedList.get(0).casing.componentsOrderBegin.hashtable.get(1).separator
						+ ", " + typedList.get(0).casing.componentsOrderBegin.hashtable.get(1).separatorSpacing
						+ ", " + typedList.get(0).casing.componentsOrderBegin.hashtable.get(2).component
						+ ", " + typedList.get(0).casing.componentsOrderBegin.hashtable.get(2).separator
						+ ", " + typedList.get(0).casing.componentsOrderBegin.hashtable.get(2).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).casing.componentsOrderBegin.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).casing.componentsOrderBegin.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).casing.componentsOrderBegin.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).casing.componentsOrderBegin.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).casing.componentsOrderBegin.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).casing.componentsOrderBegin.hashtable.get(1).separatorSpacing.toString()))
				&& (ele.validationStrings.get(6).equals(typedList.get(0).casing.componentsOrderBegin.hashtable.get(2).component))
				&& (ele.validationStrings.get(7) == null || ele.validationStrings.get(7).equals(typedList.get(0).casing.componentsOrderBegin.hashtable.get(2).separator.toString()))
				&& (ele.validationStrings.get(8) == null || ele.validationStrings.get(8).equals(typedList.get(0).casing.componentsOrderBegin.hashtable.get(2).separatorSpacing.toString()));
			};	
			
	ElementValidationInterface addLabelEndVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				ele.returnedValues 
						= (typedList.get(0).casing.descEndCasing.include ? "True" : "False")
						+ ", " + typedList.get(0).casing.descEndCasing.value;
				
				return (typedList.get(0).casing.descEndCasing.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).casing.descEndCasing.value));
			};
	ElementValidationInterface addStaPrefixEndVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				ele.returnedValues 
						= (typedList.get(0).casing.stationingPrefixEnd.include ? "True" : "False")
						+ ", " + typedList.get(0).casing.stationingPrefixEnd.value;
				
				return (typedList.get(0).casing.stationingPrefixEnd.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).casing.stationingPrefixEnd.value));
			};
	ElementValidationInterface encloseStaEndVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				ele.returnedValues 
						= (typedList.get(0).casing.encloseStationingInBracesEnd ? "True" : "False");
				
				return (typedList.get(0).casing.encloseStationingInBracesEnd == ele.bool);
			};
	ElementValidationInterface notIncludeEndVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				ele.returnedValues 
						= (typedList.get(0).casing.omitLocalizationSeparatorEnd ? "True" : "False");
				
				return (typedList.get(0).casing.omitLocalizationSeparatorEnd == ele.bool);
			};
	ElementValidationInterface endListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				ele.returnedValues
						= typedList.get(0).casing.componentsOrderEnd.hashtable.get(0).component
						+ ", " + typedList.get(0).casing.componentsOrderEnd.hashtable.get(0).separator
						+ ", " + typedList.get(0).casing.componentsOrderEnd.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).casing.componentsOrderEnd.hashtable.get(1).component
						+ ", " + typedList.get(0).casing.componentsOrderEnd.hashtable.get(1).separator
						+ ", " + typedList.get(0).casing.componentsOrderEnd.hashtable.get(1).separatorSpacing
						+ ", " + typedList.get(0).casing.componentsOrderEnd.hashtable.get(2).component
						+ ", " + typedList.get(0).casing.componentsOrderEnd.hashtable.get(2).separator
						+ ", " + typedList.get(0).casing.componentsOrderEnd.hashtable.get(2).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).casing.componentsOrderEnd.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).casing.componentsOrderEnd.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).casing.componentsOrderEnd.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).casing.componentsOrderEnd.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).casing.componentsOrderEnd.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).casing.componentsOrderEnd.hashtable.get(1).separatorSpacing.toString()))
				&& (ele.validationStrings.get(6).equals(typedList.get(0).casing.componentsOrderEnd.hashtable.get(2).component))
				&& (ele.validationStrings.get(7) == null || ele.validationStrings.get(7).equals(typedList.get(0).casing.componentsOrderEnd.hashtable.get(2).separator.toString()))
				&& (ele.validationStrings.get(8) == null || ele.validationStrings.get(8).equals(typedList.get(0).casing.componentsOrderEnd.hashtable.get(2).separatorSpacing.toString()));
			};
			
	ElementValidationInterface spacerClassificaionVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				ele.returnedValues 
						= (typedList.get(0).casing.spacers.includeClassification ? "True" : "False");
				
				return (typedList.get(0).casing.spacers.includeClassification == ele.bool);
			};
	ElementValidationInterface spacerLocalizationVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				ele.returnedValues 
						= (typedList.get(0).casing.spacers.omitLocalizationSeparator ? "True" : "False");
				
				return (typedList.get(0).casing.spacers.omitLocalizationSeparator == ele.bool);
			};
	ElementValidationInterface radioGroupval = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Casings> typedList = (List<Casings>) list;
				
				String[] mapping = {"FIRST_AND_LAST", "ALL_INDIVIDUALLY", "ALL_IN_SERIES"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= String.valueOf(typedList.get(0).casing.spacers.reportingType);
				
				return ReportingType.valueOf(ele.expectedValue).equals(typedList.get(0).casing.spacers.reportingType);
			};	
	ElementValidationInterface spacerFLSelectVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				String[] map = {"Begin Spacer / End Spacer", "Begin Spacers / End Spacers", "Spacer Begin / Spacer End", "Spacers Begin / Spacers End", "spacers begin / spacers end", "Spacer [X] of [Y]", "Spacer - [X] of [Y]"};
				
				ele.expectedValue = map[ele.dropDownIndex];
				
				ele.returnedValues = typedList.get(0).casing.spacers.firstAndLastLabelDesc;
				
				return (ele.expectedValue.equals(typedList.get(0).casing.spacers.firstAndLastLabelDesc));
			};
	ElementValidationInterface spacerRepONLYVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				ele.returnedValues 
				= (typedList.get(0).casing.spacers.reportOnlyFirstAndLast ? "True" : "False");
				
				return (typedList.get(0).casing.spacers.reportOnlyFirstAndLast == ele.bool);
			};
	ElementValidationInterface spacerAllSelectVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				String[] map = {"[X] of [Y]", "Spacer [X] of [Y]", "Spacer - [X] of [Y]"};
				
				ele.expectedValue = map[ele.dropDownIndex];
				
				ele.returnedValues = typedList.get(0).casing.spacers.allInSeriesLabelDesc;
				
				return (ele.expectedValue.equals(typedList.get(0).casing.spacers.allInSeriesLabelDesc));
			};
	ElementValidationInterface spacerListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				ele.returnedValues
						= typedList.get(0).casing.spacers.componentOrderSpacers.hashtable.get(0).component
						+ ", " + typedList.get(0).casing.spacers.componentOrderSpacers.hashtable.get(0).separator
						+ ", " + typedList.get(0).casing.spacers.componentOrderSpacers.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).casing.spacers.componentOrderSpacers.hashtable.get(1).component
						+ ", " + typedList.get(0).casing.spacers.componentOrderSpacers.hashtable.get(1).separator
						+ ", " + typedList.get(0).casing.spacers.componentOrderSpacers.hashtable.get(1).separatorSpacing
						+ ", " + typedList.get(0).casing.spacers.componentOrderSpacers.hashtable.get(2).component
						+ ", " + typedList.get(0).casing.spacers.componentOrderSpacers.hashtable.get(2).separator
						+ ", " + typedList.get(0).casing.spacers.componentOrderSpacers.hashtable.get(2).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).casing.spacers.componentOrderSpacers.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).casing.spacers.componentOrderSpacers.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).casing.spacers.componentOrderSpacers.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).casing.spacers.componentOrderSpacers.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).casing.spacers.componentOrderSpacers.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).casing.spacers.componentOrderSpacers.hashtable.get(1).separatorSpacing.toString()))
				&& (ele.validationStrings.get(6).equals(typedList.get(0).casing.spacers.componentOrderSpacers.hashtable.get(2).component))
				&& (ele.validationStrings.get(7) == null || ele.validationStrings.get(7).equals(typedList.get(0).casing.spacers.componentOrderSpacers.hashtable.get(2).separator.toString()))
				&& (ele.validationStrings.get(8) == null || ele.validationStrings.get(8).equals(typedList.get(0).casing.spacers.componentOrderSpacers.hashtable.get(2).separatorSpacing.toString()));
			};
			
	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				ele.returnedValues 
						= typedList.get(0).casing.ai.additionalNotes;
				
				return (ele.txtValue.equals(typedList.get(0).casing.ai.additionalNotes));
			};
	ElementValidationInterface examplesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				ele.returnedValues 
						= typedList.get(0).casing.ai.examples;
				
				return (ele.txtValue.equals(typedList.get(0).casing.ai.examples));
			};
	ElementValidationInterface addLocalizationVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				String[] map = {"On Both, begin and end casings", "On Begin Casing", "On End Casing"};
				
				ele.expectedValue = ele.bool + ", " + map[ele.dropDownIndex];
				
				ele.returnedValues = (typedList.get(0).casing.ai.addToDescription.include ? "True, " : "False, ") 
						+  typedList.get(0).casing.ai.addToDescription.value;
				
				return typedList.get(0).casing.ai.addToDescription.include == ele.bool
						&& (map[ele.dropDownIndex].equals(typedList.get(0).casing.ai.addToDescription.value));
			};
	ElementValidationInterface stationingVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Casings> typedList = (List<Casings>) list;
				
				ele.returnedValues 
						= (typedList.get(0).casing.ai.stationing.include ? "True" : "False")
						+ ", " + typedList.get(0).casing.ai.stationing.formatStandard
						+ ", " + typedList.get(0).casing.ai.stationing.customFormat;
						
						//Hashtable size is dynamic
						for(int i = 0; i < ele.secondaryList.size(); i++) {
							ele.returnedValues += ", " + typedList.get(0).casing.ai.stationing.dataSource.hashtable.get(i);
						}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).casing.ai.stationing.include == ele.bool
						&& Standard.valueOf(ele.validationStrings.get(1)) == (typedList.get(0).casing.ai.stationing.formatStandard)
						&& (ele.generalIndex != 2 || ele.validationStrings.get(2).equals(typedList.get(0).casing.ai.stationing.customFormat) || ele.txtValue == null);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(3 + i).equals(typedList.get(0).casing.ai.stationing.dataSource.hashtable.get(i));
				}
				
				return pass;
			};	
			
			
	public List<String> componentPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Stationing");
		cPL.add("Name");
		cPL.add("Localization");	
		return cPL;
	}
	
	public List<String> componentEndPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Localization");	
		cPL.add("Stationing");
		cPL.add("Name");
		return cPL;
	}
	
	public List<String> componentSpacerList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Classification");
		cPL.add("Series Description");
		cPL.add("Localization");	
		return cPL;
	}
	
	public List<String> spacerSpacerList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Classification");
		cPL.add("Series Description");
		cPL.add("Localization");	
		return cPL;
	}
	
	public List<String> staAvailList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Client Questionnaire");	
		cPL.add("Odometer Data");
		cPL.add("Alignment Maps");
		return cPL;
	}
	
	public List<String> staSelectList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Previous Runs");	
		cPL.add("Tracking Sheet");
		cPL.add("Pipe Listing");
		return cPL;
	}

	@SuppressWarnings("unchecked")
	@ParameterizedTest
	@ValueSource(strings = {"Casings_1.json", "Casings_2.json", "Casings_3.json"})
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
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-casings-regular&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
		
		//Casings report label and classification
		elements.add(new IWVElement(driver, addLabelVal, "beginCasing_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, addStaPrefixVal, "staPrefix_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new CBElement(driver, encloseStaVal, "encloseSta_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, notIncludeBeginVal, "omitLocalizationSeparatorBegin_cb", argumentFile.defaultValues.includeCB));
		elements.add(new DragListElement(driver, beginListVal, "componentsOrderBegin_cl", (List<String>) argumentFile.uniqueValues.get("componentsOrderBegin_cl"), 
				argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
		elements.add(new IWVElement(driver, addLabelEndVal, "endCasing_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, addStaPrefixEndVal, "staPrefixEnd_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new CBElement(driver, encloseStaEndVal, "encloseStaEnd_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, notIncludeEndVal, "omitLocalizationSeparatorEnd_cb", argumentFile.defaultValues.includeCB));
		elements.add(new DragListElement(driver, endListVal, "componentsOrderEnd_cl", (List<String>) argumentFile.uniqueValues.get("componentsOrderBegin_cl"), 
				argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
		
		
		elements.add(new CBElement(driver, spacerClassificaionVal, "includeClassification_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, spacerLocalizationVal, "omitLocalizationSeparator_cb", argumentFile.defaultValues.includeCB));
		//The spacers has different elements based on the radio option selected.
		//Change OPTION to swap between sets : modify parameters accordingly
		int OPTION = argumentFile.defaultValues.defaultRGValues;
		elements.add(new RGElement(driver, radioGroupval, "reportingType_rg", OPTION));
		switch(OPTION) {
			case 0: //First and last require special naming
				elements.add(new SelectElement(driver, spacerFLSelectVal, "labelDisc_s", argumentFile.defaultValues.defaultSelectValue));
				elements.add(new CBElement(driver, spacerRepONLYVal, "reportOnlyFirstAndLast_cb", argumentFile.defaultValues.includeCB));
				break;
			case 1: //Report all spacers individually
				//No Options
				break;
			case 2: //Report all spacers in series
				elements.add(new SelectElement(driver, spacerAllSelectVal, "allInSeriesLabelDesc_s", argumentFile.defaultValues.defaultSelectValue));
				break;
		}
		elements.add(new DragListElement(driver, spacerListVal, "componentOrderSpacers_cl", (List<String>) argumentFile.uniqueValues.get("componentOrderSpacers_cl"), 
				argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
		
		elements.add(new TextElement(driver, deviationsVal, "additionalNotes_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, examplesVal, "examples_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new IWVSElement(driver, addLocalizationVal, "addLocalizations_iwvs", argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new StationingSelectElement(driver, stationingVal, "stationing_sta", (List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), 
				argumentFile.defaultValues.stationingSelection, argumentFile.defaultValues.customStationingValue, argumentFile.defaultValues.includeStationing));
		
		
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
		compTest.compaireDB(elements, "Casings", tables.CASINGS, "CasingsResults", argumentFile.FileCounter);
	}
}