package chromedriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.CSREnums.Standard;
import com.tdw.csr.entity.appurtenances_attachments.AppurtenancesAndAttachments;

import chromedriver.CompaireDB.tables;
import chromedriver.UIElements.CBElement;
import chromedriver.UIElements.ConfigurationErrorElement;
import chromedriver.UIElements.DragListElement;
import chromedriver.UIElements.IWVElement;
import chromedriver.UIElements.IWVSElement;
import chromedriver.UIElements.OpenExpansionPanels;
import chromedriver.UIElements.RGElement;
import chromedriver.UIElements.StationingSelectElement;
import chromedriver.UIElements.TextElement;
import chromedriver.UIElements.tryCloseDialogElement;
import chromedriver.UIElements.SelectElement;
import chromedriver.UIElements.OrientationDescElement;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TeesCDTest extends BaseCDTest {

	ElementValidationInterface descAllCapsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).tees.descriptionAllCaps ? "True" : "False";
				
				return ele.bool == typedList.get(0).tees.descriptionAllCaps;
			};
	ElementValidationInterface roundLocVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).tees.roundLocationOrientations ? "True" : "False";
				
				return ele.bool == typedList.get(0).tees.roundLocationOrientations;
			};
	ElementValidationInterface incClassVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).tees.includeTeeClassification ? "True" : "False";
				
				return ele.bool == typedList.get(0).tees.includeTeeClassification;
			};
	ElementValidationInterface addLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).tees.defaultDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).tees.defaultDescription.value;
				
				return (typedList.get(0).tees.defaultDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).tees.defaultDescription.value));
			};
	ElementValidationInterface orientDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).tees.orientationDescription.topOfPipe.prefix
						+ ", " + typedList.get(0).tees.orientationDescription.topOfPipe.description
						+ ", " + typedList.get(0).tees.orientationDescription.twoSeventyDegreesOfPipe.prefix
						+ ", " + typedList.get(0).tees.orientationDescription.twoSeventyDegreesOfPipe.description
						+ ", " + typedList.get(0).tees.orientationDescription.ninetyDegreesOfPipe.prefix
						+ ", " + typedList.get(0).tees.orientationDescription.ninetyDegreesOfPipe.description
						+ ", " + typedList.get(0).tees.orientationDescription.bottomOfPipe.prefix
						+ ", " + typedList.get(0).tees.orientationDescription.bottomOfPipe.description;
				
				return ele.validationStrings.get(0).equals(typedList.get(0).tees.orientationDescription.topOfPipe.prefix) 
				&& ele.validationStrings.get(1).equals(typedList.get(0).tees.orientationDescription.topOfPipe.description)
				&& ele.validationStrings.get(2).equals(typedList.get(0).tees.orientationDescription.twoSeventyDegreesOfPipe.prefix)
				&& ele.validationStrings.get(3).equals(typedList.get(0).tees.orientationDescription.twoSeventyDegreesOfPipe.description)
				&& ele.validationStrings.get(4).equals(typedList.get(0).tees.orientationDescription.ninetyDegreesOfPipe.prefix)
				&& ele.validationStrings.get(5).equals(typedList.get(0).tees.orientationDescription.ninetyDegreesOfPipe.description)
				&& ele.validationStrings.get(6).equals(typedList.get(0).tees.orientationDescription.bottomOfPipe.prefix)
				&& ele.validationStrings.get(7).equals(typedList.get(0).tees.orientationDescription.bottomOfPipe.description);
			};
	ElementValidationInterface addStaPrefixVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).tees.stationingPrefix.include ? "True" : "False")
						+ ", " + typedList.get(0).tees.stationingPrefix.value;
				
				return (typedList.get(0).tees.stationingPrefix.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).tees.stationingPrefix.value));
			};
	ElementValidationInterface encloseStaVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).tees.encloseStationingInBraces ? "True" : "False";
				
				return ele.bool == typedList.get(0).tees.encloseStationingInBraces;
			};
	ElementValidationInterface addOpeningDimVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).tees.includeOpeningDimensions ? "True" : "False";
				
				return ele.bool == typedList.get(0).tees.includeOpeningDimensions;
			};
	ElementValidationInterface openingDimUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				String[] mapping = {"in", "''", "mm", "feet", "'", "meters"};
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).tees.openingUnits;
				
				return typedList.get(0).tees.openingUnits.equals(ele.expectedValue);
			};
	ElementValidationInterface openingDimVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).tees.openingRound.include ? "True" : "False")
						+ ", " + typedList.get(0).tees.openingRound.value;
				
				return (typedList.get(0).tees.openingRound.include == ele.bool)
						&& (Double.parseDouble(ele.txtValue) == (typedList.get(0).tees.openingRound.value));
			};	
	ElementValidationInterface addBarredDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).tees.addBarredToDescription ? "True" : "False";
				
				return ele.bool == typedList.get(0).tees.addBarredToDescription;
			};
	ElementValidationInterface dragListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues
						= typedList.get(0).tees.componentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).tees.componentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).tees.componentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).tees.componentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).tees.componentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).tees.componentsOrder.hashtable.get(1).separatorSpacing
						+ ", " + typedList.get(0).tees.componentsOrder.hashtable.get(2).component
						+ ", " + typedList.get(0).tees.componentsOrder.hashtable.get(2).separator
						+ ", " + typedList.get(0).tees.componentsOrder.hashtable.get(2).separatorSpacing
						+ ", " + typedList.get(0).tees.componentsOrder.hashtable.get(3).component
						+ ", " + typedList.get(0).tees.componentsOrder.hashtable.get(3).separator
						+ ", " + typedList.get(0).tees.componentsOrder.hashtable.get(3).separatorSpacing
						+ ", " + typedList.get(0).tees.componentsOrder.hashtable.get(4).component
						+ ", " + typedList.get(0).tees.componentsOrder.hashtable.get(4).separator
						+ ", " + typedList.get(0).tees.componentsOrder.hashtable.get(4).separatorSpacing
						+ ", " + typedList.get(0).tees.componentsOrder.hashtable.get(5).component
						+ ", " + typedList.get(0).tees.componentsOrder.hashtable.get(5).separator
						+ ", " + typedList.get(0).tees.componentsOrder.hashtable.get(5).separatorSpacing
						+ ", " + typedList.get(0).tees.componentsOrder.hashtable.get(6).component
						+ ", " + typedList.get(0).tees.componentsOrder.hashtable.get(6).separator
						+ ", " + typedList.get(0).tees.componentsOrder.hashtable.get(6).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).tees.componentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).tees.componentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).tees.componentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).tees.componentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).tees.componentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).tees.componentsOrder.hashtable.get(1).separatorSpacing.toString()))
				&& (ele.validationStrings.get(6).equals(typedList.get(0).tees.componentsOrder.hashtable.get(2).component))
				&& (ele.validationStrings.get(7) == null || ele.validationStrings.get(7).equals(typedList.get(0).tees.componentsOrder.hashtable.get(2).separator.toString()))
				&& (ele.validationStrings.get(8) == null || ele.validationStrings.get(8).equals(typedList.get(0).tees.componentsOrder.hashtable.get(2).separatorSpacing.toString()))
				&& (ele.validationStrings.get(9).equals(typedList.get(0).tees.componentsOrder.hashtable.get(3).component))
				&& (ele.validationStrings.get(10) == null || ele.validationStrings.get(10).equals(typedList.get(0).tees.componentsOrder.hashtable.get(3).separator.toString()))
				&& (ele.validationStrings.get(11) == null || ele.validationStrings.get(11).equals(typedList.get(0).tees.componentsOrder.hashtable.get(3).separatorSpacing.toString()))
				&& (ele.validationStrings.get(12).equals(typedList.get(0).tees.componentsOrder.hashtable.get(4).component))
				&& (ele.validationStrings.get(13) == null || ele.validationStrings.get(13).equals(typedList.get(0).tees.componentsOrder.hashtable.get(4).separator.toString()))
				&& (ele.validationStrings.get(14) == null || ele.validationStrings.get(14).equals(typedList.get(0).tees.componentsOrder.hashtable.get(4).separatorSpacing.toString()))
				&& (ele.validationStrings.get(15).equals(typedList.get(0).tees.componentsOrder.hashtable.get(5).component))
				&& (ele.validationStrings.get(16) == null || ele.validationStrings.get(16).equals(typedList.get(0).tees.componentsOrder.hashtable.get(5).separator.toString()))
				&& (ele.validationStrings.get(17) == null || ele.validationStrings.get(17).equals(typedList.get(0).tees.componentsOrder.hashtable.get(5).separatorSpacing.toString()))
				&& (ele.validationStrings.get(18).equals(typedList.get(0).tees.componentsOrder.hashtable.get(6).component))
				&& (ele.validationStrings.get(19) == null || ele.validationStrings.get(19).equals(typedList.get(0).tees.componentsOrder.hashtable.get(6).separator.toString()))
				&& (ele.validationStrings.get(20) == null || ele.validationStrings.get(20).equals(typedList.get(0).tees.componentsOrder.hashtable.get(6).separatorSpacing.toString()));
			};		
	ElementValidationInterface notesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).tees.ai.additionalNotes;
				
				return (ele.txtValue.equals(typedList.get(0).tees.ai.additionalNotes));
			};			
	ElementValidationInterface markingExVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues
						= typedList.get(0).tees.ai.examples;
				
				return ele.txtValue.equals(typedList.get(0).tees.ai.examples);
			};
	ElementValidationInterface stationingVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).tees.ai.stationing.include ? "True" : "False")
						+ ", " + typedList.get(0).tees.ai.stationing.formatStandard
						+ ", " + typedList.get(0).tees.ai.stationing.customFormat;
						
						//Hashtable size is dynamic
						for(int i = 0; i < ele.secondaryList.size(); i++) {
							ele.returnedValues += ", " + typedList.get(0).tees.ai.stationing.dataSource.hashtable.get(i);
						}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).tees.ai.stationing.include == ele.bool
						&& (typedList.get(0).tees.ai.stationing.formatStandard) == Standard.valueOf(ele.validationStrings.get(1))
						&& (ele.generalIndex != 2 || ele.txtValue == null || ele.validationStrings.get(2).equals(typedList.get(0).tees.ai.stationing.customFormat));
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(3 + i).equals(typedList.get(0).tees.ai.stationing.dataSource.hashtable.get(i));
				}
						
				
				return pass;
			};	
	ElementValidationInterface setClassificationVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).tees.ai.setClassification ? "True" : "False";
				
				return ele.bool == typedList.get(0).tees.ai.setClassification;
			};
	ElementValidationInterface localizationVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).tees.omitLocalizationSeparator ? "True" : "False";
				
				return ele.bool == typedList.get(0).tees.omitLocalizationSeparator;
			};
			
			
	public List<String> componentPriorityList() {
		List<String> cPL = new ArrayList<String>();
		cPL.add("Orientation");
		cPL.add("Label");
		cPL.add("Classification");
		cPL.add("Dimensions");
		cPL.add("Stationing");
		cPL.add("Localization");
		cPL.add("Barred");

		return cPL;
	}

	public List<String> availablePriorityList() {
		List<String> cPL = new ArrayList<String>();
		cPL.add("Alignment Maps");
		cPL.add("Tracking Sheet");
		cPL.add("Pipe Listings");

		return cPL;
	}

	public List<String> selectPriorityList() {
		List<String> cPL = new ArrayList<String>();
		cPL.add("Previous Runs");
		cPL.add("Odometer Data");
		cPL.add("Client Questionnaire");

		return cPL;
	}

	List<UIElements> elements = new ArrayList<UIElements>();

	@SuppressWarnings("unchecked")
	@ParameterizedTest
	@ValueSource(strings = {"Tees_1.json", "Tees_2.json", "Tees_3.json"})
	public void testTeesPage(String argument) throws Exception {
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
		chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-aa-tees&auth_token=" + JWT_QA);
		Thread.sleep(1000);

		List<UIElements> elements = new ArrayList<UIElements>();
		try {
			
		elements.add(new CBElement(driver, descAllCapsVal, "descriptionAllCaps_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, roundLocVal, "roundLocationOrientations_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, incClassVal, "includeTeeClassification_cb", argumentFile.defaultValues.includeCB));
		elements.add(new IWVElement(driver, addLabelVal, "prefixLabel_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new OrientationDescElement(driver, orientDescVal, "orientationDescription_od", "od_btn", argumentFile.defaultValues.orientationDescriptionVals));
		elements.add(new CBElement(driver, null, "orientationDescription_od", argumentFile.defaultValues.includeOrientationDescription));
		elements.add(new IWVElement(driver, addStaPrefixVal, "stationingPrefix_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new CBElement(driver, encloseStaVal, "encloseStationing_cb", argumentFile.defaultValues.includeCB));
		
		boolean addOpeningDimensions = (Boolean) argumentFile.uniqueValues.get("includeOpeningDimensions_cb");
		elements.add(new CBElement(driver, addOpeningDimVal, "includeOpeningDimensions_cb", addOpeningDimensions));
		if(addOpeningDimensions)
		{
			elements.add(new IWVElement(driver, openingDimVal, "roundOpeningDimensions_iwv", Integer.toString(argumentFile.defaultValues.defaultSelectValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.add(new SelectElement(driver, openingDimUnitVal, "openingUnits_ts", argumentFile.defaultValues.defaultSelectValue));
		}
		
		elements.add(new CBElement(driver, addBarredDescVal, "addBarred_cb", argumentFile.defaultValues.includeCB));

		elements.add(new DragListElement(driver, dragListVal, "componentsOrder_cl", (List<String>) argumentFile.uniqueValues.get("componentsOrder_cl"), 
				argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
		elements.add(new TextElement(driver, notesVal, "additionalNotes_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, markingExVal, "examples_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new StationingSelectElement(driver, stationingVal, "stationing_sta", (List<String>) argumentFile.uniqueValues.get("acceptedList"),
				(List<String>) argumentFile.uniqueValues.get("selectedList"), argumentFile.defaultValues.stationingSelection, 
				argumentFile.defaultValues.customStationingValue, argumentFile.defaultValues.includeStationing));
		elements.add(new CBElement(driver, setClassificationVal, "setClassification_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, localizationVal, "omitLocalizationSeparator_cb",argumentFile.defaultValues.includeCB));
		
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
		compTest.compaireDB(elements, "Tees", tables.APPURTENANCES_AND_ATTACHMENTS, "TeesResults", argumentFile.FileCounter);
	}

}
