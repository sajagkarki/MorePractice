package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.CSREnums.Standard;
import com.tdw.csr.entity.appurtenances_attachments.AppurtenancesAndAttachments;
import com.tdw.csr.entity.repairs.Repairs;
import com.tdw.csr.entity.valves.Valves;

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

public class StopplesCDTest extends BaseCDTest {

	ElementValidationInterface allCapsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= (typedList.get(0).stopple.descriptionAllCaps ? "True" : "False");
				
				return (typedList.get(0).stopple.descriptionAllCaps == ele.bool);
			};
	ElementValidationInterface roundLocVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= (typedList.get(0).stopple.roundOrientation ? "True" : "False");
				
				return (typedList.get(0).stopple.roundOrientation == ele.bool);
			};
	ElementValidationInterface begLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= (typedList.get(0).stopple.defaultDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).stopple.defaultDescription.value;
				
				return (typedList.get(0).stopple.defaultDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).stopple.defaultDescription.value));
			};
	ElementValidationInterface orientDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= typedList.get(0).stopple.orientationDescription.topOfPipe.prefix
						+ ", " + typedList.get(0).stopple.orientationDescription.topOfPipe.description
						+ ", " + typedList.get(0).stopple.orientationDescription.twoSeventyDegreesOfPipe.prefix
						+ ", " + typedList.get(0).stopple.orientationDescription.twoSeventyDegreesOfPipe.description
						+ ", " + typedList.get(0).stopple.orientationDescription.ninetyDegreesOfPipe.prefix
						+ ", " + typedList.get(0).stopple.orientationDescription.ninetyDegreesOfPipe.description
						+ ", " + typedList.get(0).stopple.orientationDescription.bottomOfPipe.prefix
						+ ", " + typedList.get(0).stopple.orientationDescription.bottomOfPipe.description;
				
				return ele.validationStrings.get(0).equals(typedList.get(0).stopple.orientationDescription.topOfPipe.prefix) 
				&& ele.validationStrings.get(1).equals(typedList.get(0).stopple.orientationDescription.topOfPipe.description)
				&& ele.validationStrings.get(2).equals(typedList.get(0).stopple.orientationDescription.twoSeventyDegreesOfPipe.prefix)
				&& ele.validationStrings.get(3).equals(typedList.get(0).stopple.orientationDescription.twoSeventyDegreesOfPipe.description)
				&& ele.validationStrings.get(4).equals(typedList.get(0).stopple.orientationDescription.ninetyDegreesOfPipe.prefix)
				&& ele.validationStrings.get(5).equals(typedList.get(0).stopple.orientationDescription.ninetyDegreesOfPipe.description)
				&& ele.validationStrings.get(6).equals(typedList.get(0).stopple.orientationDescription.bottomOfPipe.prefix)
				&& ele.validationStrings.get(7).equals(typedList.get(0).stopple.orientationDescription.bottomOfPipe.description);
			};
	ElementValidationInterface staPrefixVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= (typedList.get(0).stopple.stationingPrefix.include ? "True" : "False")
						+ ", " + typedList.get(0).stopple.stationingPrefix.value;
				
				return (typedList.get(0).stopple.stationingPrefix.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).stopple.stationingPrefix.value));
			};
	ElementValidationInterface encStaVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= (typedList.get(0).stopple.stationingUsesBraces ? "True" : "False");
				
				return (typedList.get(0).stopple.stationingUsesBraces == ele.bool);
			};
	ElementValidationInterface addDimVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= (typedList.get(0).stopple.includeOpeningDimensions ? "True" : "False");
				
				return (typedList.get(0).stopple.includeOpeningDimensions == ele.bool);
			};
	ElementValidationInterface roundNearestVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= (typedList.get(0).stopple.roundOpeningDimensions.include ? "True" : "False")
						+ ", " + typedList.get(0).stopple.roundOpeningDimensions.value;
				
				return (typedList.get(0).stopple.roundOpeningDimensions.include == ele.bool)
						&& (Double.parseDouble(ele.txtValue) == (typedList.get(0).stopple.roundOpeningDimensions.value));
			};
	ElementValidationInterface roundNearestUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				String[] mapping = {"in", "''", "mm", "ft", "'", "m"};
				
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).stopple.roundOpeningDimensions.include ? "True" : "False")
								+ ", " + typedList.get(0).stopple.roundOpeningDimensions.units;
				
				return (typedList.get(0).stopple.roundOpeningDimensions.include == ele.bool)
						&& (mapping[ele.dropDownIndex].equals(typedList.get(0).stopple.roundOpeningDimensions.units));
			};
	ElementValidationInterface prevSeparatorVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= (typedList.get(0).stopple.omitLocalizationSeparator ? "True" : "False");
				
				return (typedList.get(0).stopple.omitLocalizationSeparator == ele.bool);
			};
			
			
	ElementValidationInterface componentListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues
						= typedList.get(0).stopple.componentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).stopple.componentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).stopple.componentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).stopple.componentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).stopple.componentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).stopple.componentsOrder.hashtable.get(1).separatorSpacing
						+ ", " + typedList.get(0).stopple.componentsOrder.hashtable.get(2).component
						+ ", " + typedList.get(0).stopple.componentsOrder.hashtable.get(2).separator
						+ ", " + typedList.get(0).stopple.componentsOrder.hashtable.get(2).separatorSpacing
						+ ", " + typedList.get(0).stopple.componentsOrder.hashtable.get(3).component
						+ ", " + typedList.get(0).stopple.componentsOrder.hashtable.get(3).separator
						+ ", " + typedList.get(0).stopple.componentsOrder.hashtable.get(3).separatorSpacing
						+ ", " + typedList.get(0).stopple.componentsOrder.hashtable.get(4).component
						+ ", " + typedList.get(0).stopple.componentsOrder.hashtable.get(4).separator
						+ ", " + typedList.get(0).stopple.componentsOrder.hashtable.get(4).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).stopple.componentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).stopple.componentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).stopple.componentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).stopple.componentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).stopple.componentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).stopple.componentsOrder.hashtable.get(1).separatorSpacing.toString()))
				&& (ele.validationStrings.get(6).equals(typedList.get(0).stopple.componentsOrder.hashtable.get(2).component))
				&& (ele.validationStrings.get(7) == null || ele.validationStrings.get(7).equals(typedList.get(0).stopple.componentsOrder.hashtable.get(2).separator.toString()))
				&& (ele.validationStrings.get(8) == null || ele.validationStrings.get(8).equals(typedList.get(0).stopple.componentsOrder.hashtable.get(2).separatorSpacing.toString()))
				&& (ele.validationStrings.get(9).equals(typedList.get(0).stopple.componentsOrder.hashtable.get(3).component))
				&& (ele.validationStrings.get(10) == null || ele.validationStrings.get(10).equals(typedList.get(0).stopple.componentsOrder.hashtable.get(3).separator.toString()))
				&& (ele.validationStrings.get(11) == null || ele.validationStrings.get(11).equals(typedList.get(0).stopple.componentsOrder.hashtable.get(3).separatorSpacing.toString()))
				&& (ele.validationStrings.get(12).equals(typedList.get(0).stopple.componentsOrder.hashtable.get(4).component))
				&& (ele.validationStrings.get(13) == null || ele.validationStrings.get(13).equals(typedList.get(0).stopple.componentsOrder.hashtable.get(4).separator.toString()))
				&& (ele.validationStrings.get(14) == null || ele.validationStrings.get(14).equals(typedList.get(0).stopple.componentsOrder.hashtable.get(4).separatorSpacing.toString()));
			};
			
			
			
	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= typedList.get(0).stopple.ai.additionalNotes;
				
				return ele.txtValue.equals(typedList.get(0).stopple.ai.additionalNotes);
			};
	ElementValidationInterface markingVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= typedList.get(0).stopple.ai.examples;
				
				return ele.txtValue.equals(typedList.get(0).stopple.ai.examples);
			};
			
	
	ElementValidationInterface addStationingVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= (typedList.get(0).stopple.ai.stationing.include ? "True" : "False")
						+ ", " + typedList.get(0).stopple.ai.stationing.formatStandard
						+ ", " + typedList.get(0).stopple.ai.stationing.customFormat;
						
						//Hashtable size is dynamic
						for(int i = 0; i < ele.secondaryList.size(); i++) {
							ele.returnedValues += ", " + typedList.get(0).stopple.ai.stationing.dataSource.hashtable.get(i);
						}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).stopple.ai.stationing.include == ele.bool
						&& Standard.valueOf(ele.validationStrings.get(1)) == (typedList.get(0).stopple.ai.stationing.formatStandard)
						&& (ele.generalIndex != 2 || ele.validationStrings.get(2).equals(typedList.get(0).stopple.ai.stationing.customFormat) || ele.txtValue == null);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(3 + i).equals(typedList.get(0).stopple.ai.stationing.dataSource.hashtable.get(i));
				}
				
				return pass;
			};	
	
	ElementValidationInterface addRepDigInfoVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.txtValue + ", " + ele.secondaryList;
				
				ele.returnedValues 
				= (typedList.get(0).stopple.ai.addRepairDigInfoToDesc ? "True" : "False")
				+ ", " + typedList.get(0).stopple.ai.formattingInfo.digRepairNumberFormat;
				
				//Hashtable size is dynamic
				for(int i = 0; i < ele.secondaryList.size(); i++) {
					ele.returnedValues += ", " + typedList.get(0).stopple.ai.formattingInfo.componentsOrder.hashtable.get(i);
				}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).stopple.ai.addRepairDigInfoToDesc == ele.tertiaryFlag
						&& typedList.get(0).stopple.ai.formattingInfo.digRepairNumberFormat.equals(ele.txtValue);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(0 + i).equals(typedList.get(0).stopple.ai.formattingInfo.componentsOrder.hashtable.get(i));
				}
				
				return pass;
			};	
			
			
			
			
	public List<String> componentPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dimensions");
		cPL.add("Repair/Dig");
		cPL.add("Localization");
		cPL.add("Stationing");
		cPL.add("Orientation");
		
		return cPL;
	}
	
	
	public List<String> availablePriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Odometer Data");
		cPL.add("Alignment Maps");
		cPL.add("Client Questionnaire");
		
		return cPL;
	}
	
	public List<String> selectedPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Previous Runs");
		cPL.add("Tracking Sheet");
		cPL.add("Pipe Listing");

		
		return cPL;
	}
	
	public List<String> availableStaList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig Orientation");
		cPL.add("Dig Width");
		
		return cPL;
	}
	
	public List<String> selectedStaList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig/Repair Number");
		cPL.add("Dig Length");
		cPL.add("Dig Depth");
		
		return cPL;
	}
	
	
	@SuppressWarnings("unchecked")
	@ParameterizedTest
	@ValueSource(strings = {"Stopples_1.json", "Stopples_2.json", "Stopples_3.json"})
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
		
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-repairs-stopple&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
			
		elements.add(new CBElement(driver, allCapsVal, "descriptionAllCaps_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, roundLocVal, "roundOrientation_cb", argumentFile.defaultValues.includeCB));
		elements.add(new IWVElement(driver, begLabelVal, "descPrefix_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new OrientationDescElement(driver, orientDescVal, "stopple_od", "includeOrientation_cb", argumentFile.defaultValues.orientationDescriptionVals));
		elements.add(new CBElement(driver, null, "includeOrientation_cb", argumentFile.defaultValues.includeOrientationDescription));
		elements.add(new IWVElement(driver, staPrefixVal, "staPrefix_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new CBElement(driver, encStaVal, "encloseSta_cb", argumentFile.defaultValues.includeCB));
		
		boolean addOpeningDimensionsDesc = (Boolean) argumentFile.uniqueValues.get("addDimensions_cb");
		elements.add(new CBElement(driver, addDimVal, "addDimensions_cb", addOpeningDimensionsDesc));
		if(addOpeningDimensionsDesc)
		{
			boolean roundToNearest = argumentFile.defaultValues.includeIWVorIWVS;
			elements.add(new IWVElement(driver, roundNearestVal, "round_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), roundToNearest));
			elements.add(new IWVSElement(driver, roundNearestUnitVal, "round_iwv", 1, roundToNearest));
		}
		else
			
		elements.add(new CBElement(driver, prevSeparatorVal, "omitLocalizationSeparator_cb", argumentFile.defaultValues.includeCB));
		
		elements.add(new DragListElement(driver, componentListVal, "componentsOrder_cl", (List<String>) argumentFile.uniqueValues.get("componentsOrder_cl"), 
				argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
		
		
		elements.add(new TextElement(driver, deviationsVal, "includeInstructions_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, markingVal, "examples_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new StationingSelectElement(driver, addStationingVal, "stationing_sta",  
				(List<String>) argumentFile.uniqueValues.get("availableList"),  (List<String>) argumentFile.uniqueValues.get("selectedList"), 
				argumentFile.defaultValues.stationingSelection, argumentFile.defaultValues.customStationingValue, argumentFile.defaultValues.includeStationing));
		
		boolean addRepDig = argumentFile.defaultValues.includeSimpleDataSource;
		elements.add(new CBElement(driver, null, "addDigInfo_cb", true)); //Next line is dependent on this being true;
		elements.add(new SimpleDataSourceElement(driver, addRepDigInfoVal, "digFormat_fi",  
				(List<String>) argumentFile.uniqueValues.get("data_availableList"),  (List<String>) argumentFile.uniqueValues.get("data_selectedList"), 
				argumentFile.defaultValues.simpleDataSourceTextVal, true, true, addRepDig));
		elements.add(new CBElement(driver, null, "addDigInfo_cb", addRepDig)); //Next line is dependent on this being true;
		
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
		compTest.compaireDB(elements, "Stopples Repairs", tables.REPAIRS, "StopplesResults", argumentFile.FileCounter);
	}
}