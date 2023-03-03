package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.CSREnums;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.repairs.Repairs;

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

public class SleevesCDTest extends BaseCDTest {
	
	ElementValidationInterface begEndVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= (typedList.get(0).sleeve.includeReportBeginEnd ? "True" : "False");
				
				return (typedList.get(0).sleeve.includeReportBeginEnd == ele.bool);
			};
	ElementValidationInterface repairLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= (typedList.get(0).sleeve.nameToDescRepair.include ? "True" : "False")
						+ ", " + typedList.get(0).sleeve.nameToDescRepair.value;
				
				return (typedList.get(0).sleeve.nameToDescRepair.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).sleeve.nameToDescRepair.value));
			};
	ElementValidationInterface reinforcementLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= (typedList.get(0).sleeve.nameToDescReinforcement.include ? "True" : "False")
						+ ", " + typedList.get(0).sleeve.nameToDescReinforcement.value;
				
				return (typedList.get(0).sleeve.nameToDescReinforcement.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).sleeve.nameToDescReinforcement.value));
			};
	ElementValidationInterface weldWrapLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= (typedList.get(0).sleeve.nameToDescWeldWrap.include ? "True" : "False")
						+ ", " + typedList.get(0).sleeve.nameToDescWeldWrap.value;
				
				return (typedList.get(0).sleeve.nameToDescWeldWrap.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).sleeve.nameToDescWeldWrap.value));
			};
	ElementValidationInterface reinforcedFittingLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= (typedList.get(0).sleeve.nameToReinforcedFittingSleeves.include ? "True" : "False")
						+ ", " + typedList.get(0).sleeve.nameToReinforcedFittingSleeves.value;
				
				return (typedList.get(0).sleeve.nameToReinforcedFittingSleeves.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).sleeve.nameToReinforcedFittingSleeves.value));
			};
	ElementValidationInterface sleeveLengthVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				String[] mapping = {"ft", "in", "m", "mm", "\"", "'"};
				
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).sleeve.includeSleeveLengthToDesc.include ? "True" : "False")
						+ ", " + typedList.get(0).sleeve.includeSleeveLengthToDesc.value;
				
				return (typedList.get(0).sleeve.includeSleeveLengthToDesc.include == ele.bool)
						&& (mapping[ele.dropDownIndex].equals(typedList.get(0).sleeve.includeSleeveLengthToDesc.value));
			};
	ElementValidationInterface roundLengthVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= (typedList.get(0).sleeve.includeRoundLengthToX.include ? "True" : "False")
						+ ", " + typedList.get(0).sleeve.includeRoundLengthToX.value;
				
				return (typedList.get(0).sleeve.includeRoundLengthToX.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).sleeve.includeRoundLengthToX.value));
			};
			
	ElementValidationInterface maxAdjoinNumVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
				= (typedList.get(0).sleeve.maximumDistanceForAdjoinSleeves.include ? "True" : "False")
				+ ", " + typedList.get(0).sleeve.maximumDistanceForAdjoinSleeves.value;
				
				return (typedList.get(0).sleeve.maximumDistanceForAdjoinSleeves.include == ele.bool)
						&& (Double.parseDouble(ele.txtValue) == (typedList.get(0).sleeve.maximumDistanceForAdjoinSleeves.value));
			};
	ElementValidationInterface adjoinVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
				= (typedList.get(0).sleeve.maximumDistanceForAdjoinSleeves.include ? "True" : "False");
				
				return (typedList.get(0).sleeve.maximumDistanceForAdjoinSleeves.include == ele.bool);
			};
	ElementValidationInterface maxAdjoinUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				String[] mapping = {"in", "mm"};
				
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).sleeve.maximumDistanceForAdjoinSleeves.include ? "True" : "False")
								+ ", " + typedList.get(0).sleeve.maximumDistanceForAdjoinSleeves.units;
				
				return (typedList.get(0).sleeve.maximumDistanceForAdjoinSleeves.include == ele.bool)
						&& (mapping[ele.dropDownIndex].equals(typedList.get(0).sleeve.maximumDistanceForAdjoinSleeves.units));
			};
			
			
	ElementValidationInterface maxSeriesNumVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
				= typedList.get(0).sleeve.maximumDistanceForSeries.value + "";
				
				return (Double.parseDouble(ele.txtValue) == (typedList.get(0).sleeve.maximumDistanceForSeries.value));
			};
	ElementValidationInterface maxSeriesUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				String[] mapping = {"ft", "m"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).sleeve.maximumDistanceForSeries.units;
				
				return (mapping[ele.dropDownIndex].equals(typedList.get(0).sleeve.maximumDistanceForSeries.units));
			};
			
	ElementValidationInterface RGUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				String[] mapping = {"FIRST_AND_LAST", "ALL_INDIVIDUALLY", "ALL_IN_SERIES"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
				= typedList.get(0).sleeve.reportingType + "";
				
				return (CSREnums.ReportingType.valueOf(mapping[ele.generalIndex]).equals(typedList.get(0).sleeve.reportingType));
			};
	ElementValidationInterface firstLastLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				
				String[] mapping = {"[X] of [Y]", "Weld wraps Begin / Weld wraps End", "Begin Weld wraps / End Weld wraps"};
				
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
				= (typedList.get(0).sleeve.multipleReinforcementFirstLastNaming.include ? "True" : "False")
				+ ", " + typedList.get(0).sleeve.multipleReinforcementFirstLastNaming.value;
				
				return (typedList.get(0).sleeve.multipleReinforcementFirstLastNaming.include == ele.bool)
						&& (mapping[ele.dropDownIndex].equals(typedList.get(0).sleeve.multipleReinforcementFirstLastNaming.value));
			};
	ElementValidationInterface allFLLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				
				String[] mapping = {"Begin / End", "[X] of [Y]"};
				
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
				= (typedList.get(0).sleeve.multipleReinforcementFirstLastSpecialNaming.include ? "True" : "False")
				+ ", " + typedList.get(0).sleeve.multipleReinforcementFirstLastSpecialNaming.value;
				
				return (typedList.get(0).sleeve.multipleReinforcementFirstLastSpecialNaming.include == ele.bool)
						&& (mapping[ele.dropDownIndex].equals(typedList.get(0).sleeve.multipleReinforcementFirstLastSpecialNaming.value));
			};
	ElementValidationInterface othersLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				
				String[] mapping = {"Weld wrap [X] of [Y]", "Weld wrap [X] to [Y]", "Weld wrap - [X] of [Y]", "Weld wrap - [X] to [Y]"};
				
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
				= (typedList.get(0).sleeve.multipleReinforcementFirstLastSeriesNaming.include ? "True" : "False")
				+ ", " + typedList.get(0).sleeve.multipleReinforcementFirstLastSeriesNaming.value;
				
				return (typedList.get(0).sleeve.multipleReinforcementFirstLastSeriesNaming.include == ele.bool)
						&& (mapping[ele.dropDownIndex].equals(typedList.get(0).sleeve.multipleReinforcementFirstLastSeriesNaming.value));
			};
			
			
			
	ElementValidationInterface componentListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues
						= typedList.get(0).sleeve.componentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).sleeve.componentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).sleeve.componentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).sleeve.componentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).sleeve.componentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).sleeve.componentsOrder.hashtable.get(1).separatorSpacing
						+ ", " + typedList.get(0).sleeve.componentsOrder.hashtable.get(2).component
						+ ", " + typedList.get(0).sleeve.componentsOrder.hashtable.get(2).separator
						+ ", " + typedList.get(0).sleeve.componentsOrder.hashtable.get(2).separatorSpacing
						+ ", " + typedList.get(0).sleeve.componentsOrder.hashtable.get(3).component
						+ ", " + typedList.get(0).sleeve.componentsOrder.hashtable.get(3).separator
						+ ", " + typedList.get(0).sleeve.componentsOrder.hashtable.get(3).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).sleeve.componentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).sleeve.componentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).sleeve.componentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).sleeve.componentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).sleeve.componentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).sleeve.componentsOrder.hashtable.get(1).separatorSpacing.toString()))
				&& (ele.validationStrings.get(6).equals(typedList.get(0).sleeve.componentsOrder.hashtable.get(2).component))
				&& (ele.validationStrings.get(7) == null || ele.validationStrings.get(7).equals(typedList.get(0).sleeve.componentsOrder.hashtable.get(2).separator.toString()))
				&& (ele.validationStrings.get(8) == null || ele.validationStrings.get(8).equals(typedList.get(0).sleeve.componentsOrder.hashtable.get(2).separatorSpacing.toString()))
				&& (ele.validationStrings.get(9).equals(typedList.get(0).sleeve.componentsOrder.hashtable.get(3).component))
				&& (ele.validationStrings.get(10) == null || ele.validationStrings.get(10).equals(typedList.get(0).sleeve.componentsOrder.hashtable.get(3).separator.toString()))
				&& (ele.validationStrings.get(11) == null || ele.validationStrings.get(11).equals(typedList.get(0).sleeve.componentsOrder.hashtable.get(3).separatorSpacing.toString()));
			};
			
			
			
	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= typedList.get(0).sleeve.ai.additionalNotes;
				
				return ele.txtValue.equals(typedList.get(0).sleeve.ai.additionalNotes);
			};
	ElementValidationInterface markingVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= typedList.get(0).sleeve.ai.examples;
				
				return ele.txtValue.equals(typedList.get(0).sleeve.ai.examples);
			};
			
	ElementValidationInterface addRepDigInfoVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.txtValue + ", " + ele.secondaryList;
				
				ele.returnedValues 
				= (typedList.get(0).sleeve.ai.addRepairDigInfoToDesc ? "True" : "False")
				+ ", " + typedList.get(0).sleeve.ai.formattingInfo.digRepairNumberFormat;
				
				//Hashtable size is dynamic
				for(int i = 0; i < ele.secondaryList.size(); i++) {
					ele.returnedValues += ", " + typedList.get(0).sleeve.ai.formattingInfo.componentsOrder.hashtable.get(i);
				}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).sleeve.ai.addRepairDigInfoToDesc == ele.tertiaryFlag
						&& typedList.get(0).sleeve.ai.formattingInfo.digRepairNumberFormat.equals(ele.txtValue);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(0 + i).equals(typedList.get(0).sleeve.ai.formattingInfo.componentsOrder.hashtable.get(i));
				}
				
				return pass;
			};	
	
	
	public List<String> componentPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Sleeve Length");
		cPL.add("Series Label");
		cPL.add("Name");
		cPL.add("Repair/Dig");
		
		return cPL;
	}
	
	
	public List<String> availablePriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig/Repair Number");
		cPL.add("Dig Length");
		cPL.add("Dig Depth");
		
		return cPL;
	}
	
	public List<String> selectedPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig Orientation");
		cPL.add("Dig Width");
		
		return cPL;
	}
	
	
	@SuppressWarnings("unchecked")
	@ParameterizedTest
	@ValueSource(strings = {"Sleeves_1.json", "Sleeves_2.json", "Sleeves_3.json", "Sleeves_4.json"})
	public void testStopplesPage(String argument) throws Exception {
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
		
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-repairs-sleeve&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {

		elements.add(new CBElement(driver, begEndVal, "includeReport_cb", argumentFile.defaultValues.includeCB));
		elements.add(new IWVElement(driver, repairLabelVal, "nameToDescRepair_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, reinforcementLabelVal, "nameToDescReinforcement_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, weldWrapLabelVal, "nameToDescWeldWrap_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, reinforcedFittingLabelVal, "nameToReinforcedFittingSleeves_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		
		boolean addSleeve = (Boolean) argumentFile.uniqueValues.get("includeSleeveLengthToDesc_ivs");
		elements.add(new IWVSElement(driver, sleeveLengthVal, "includeSleeveLengthToDesc_ivs", argumentFile.defaultValues.defaultIWVSValue, addSleeve));
		if(addSleeve) {
			elements.add(new IWVElement(driver, roundLengthVal, "includeRoundLengthToX_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
		}

		boolean adjoin = argumentFile.defaultValues.includeIWVorIWVS;
		elements.add(new IWVElement(driver, maxAdjoinNumVal, "maxDistance_vu", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), adjoin));
		elements.add(new IWVSElement(driver, maxAdjoinUnitVal, "maxDistance_vu", argumentFile.defaultValues.defaultIWVSValue, adjoin));

		elements.add(new TextElement(driver, maxSeriesNumVal, "maxDistance_vu", Integer.toString(argumentFile.defaultValues.defaultIWVSValue)));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new SelectElement(driver, maxSeriesUnitVal, "maxDistance_vu", argumentFile.defaultValues.defaultSelectValue));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		
		
		//The radio group has different sub-elements depending upon selection
		int selection = argumentFile.defaultValues.defaultRGValues;
		elements.add(new RGElement(driver, RGUnitVal, "reportingType_rg", selection));
		switch(selection)
		{
			case 0:
				elements.add(new IWVSElement(driver, firstLastLabelVal, "displayBeginEnd_iwvs", argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.includeIWVorIWVS));
				break;
			case 1:
				//No Addition Options
				break;
			case 2:
				elements.add(new IWVSElement(driver, allFLLabelVal, "firstLastNaming_iwvs", argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.includeIWVorIWVS));
				elements.add(new IWVSElement(driver, othersLabelVal, "descrNaming_iwvs", argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.includeIWVorIWVS));
				break;
		}
		
		elements.add(new DragListElement(driver, componentListVal, "componentsOrder_cl", (List<String>) argumentFile.uniqueValues.get("componentsOrder_cl"), 
				argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
		
		
		elements.add(new TextElement(driver, deviationsVal, "additionalNotes_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, markingVal, "examples_ta", argumentFile.defaultValues.defaultTextValue));
		
		boolean addRep = argumentFile.defaultValues.includeSimpleDataSource;
		elements.add(new CBElement(driver, null, "addRepairDigInfoSleeve_cb", true)); //Next line is dependent on this being true;
		elements.add(new SimpleDataSourceElement(driver, addRepDigInfoVal, "formattingInfo_fi",  
				(List<String>) argumentFile.uniqueValues.get("availableList"),  (List<String>) argumentFile.uniqueValues.get("selectedList"), 
				argumentFile.defaultValues.simpleDataSourceTextVal, true, true, addRep));
		elements.add(new CBElement(driver, null, "addRepairDigInfoSleeve_cb", addRep)); 
		
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
		compTest.compaireDB(elements, "Sleeves Repairs", tables.REPAIRS, "SleevesResults", argumentFile.FileCounter);
	}
}