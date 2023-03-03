package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.Entity;
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

public class FlangesCDTest extends BaseCDTest {

	ElementValidationInterface descAllCapsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).flanges.descriptionAllCaps ? "True" : "False";
				
				return ele.bool == typedList.get(0).flanges.descriptionAllCaps;
			};
	ElementValidationInterface defaultDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).flanges.defaultFlangeDescription;
				
				return (ele.txtValue.equals(typedList.get(0).flanges.defaultFlangeDescription));
			};		
	ElementValidationInterface isolFlangeDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).flanges.isolatedFlangeDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).flanges.isolatedFlangeDescription.value;
				
				return (typedList.get(0).flanges.isolatedFlangeDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).flanges.isolatedFlangeDescription.value));
			};
	ElementValidationInterface specFlangeDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).flanges.spectacleFlangeDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).flanges.spectacleFlangeDescription.value;
				
				return (typedList.get(0).flanges.spectacleFlangeDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).flanges.spectacleFlangeDescription.value));
			};
	ElementValidationInterface staFlangeDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).flanges.stationingPrefix.include ? "True" : "False")
						+ ", " + typedList.get(0).flanges.stationingPrefix.value;
				
				return (typedList.get(0).flanges.stationingPrefix.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).flanges.stationingPrefix.value));
			};
	ElementValidationInterface encloseStaVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).flanges.encloseStationingInBraces ? "True" : "False";
				
				return ele.bool == typedList.get(0).flanges.encloseStationingInBraces;
			};				
	ElementValidationInterface dragListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues
						= typedList.get(0).flanges.componentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).flanges.componentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).flanges.componentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).flanges.componentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).flanges.componentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).flanges.componentsOrder.hashtable.get(1).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).flanges.componentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).flanges.componentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).flanges.componentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).flanges.componentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).flanges.componentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).flanges.componentsOrder.hashtable.get(1).separatorSpacing.toString()));
			};					
	ElementValidationInterface notesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).flanges.ai.additionalNotes;
				
				return (ele.txtValue.equals(typedList.get(0).flanges.ai.additionalNotes));
			};	
	ElementValidationInterface marksVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).flanges.ai.examples;
				
				return (ele.txtValue.equals(typedList.get(0).flanges.ai.examples));
			};	
	ElementValidationInterface stationingVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).flanges.ai.stationing.include ? "True" : "False")
						+ ", " + typedList.get(0).flanges.ai.stationing.formatStandard
						+ ", " + typedList.get(0).flanges.ai.stationing.customFormat;
						
						//Hashtable size is dynamic
						for(int i = 0; i < ele.secondaryList.size(); i++) {
							ele.returnedValues += ", " + typedList.get(0).flanges.ai.stationing.dataSource.hashtable.get(i);
						}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).flanges.ai.stationing.include == ele.bool
						&& Standard.valueOf(ele.validationStrings.get(1)) == (typedList.get(0).flanges.ai.stationing.formatStandard)
						&& (ele.generalIndex != 2 || ele.validationStrings.get(2).equals(typedList.get(0).flanges.ai.stationing.customFormat) || ele.txtValue == null);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(3 + i).equals(typedList.get(0).flanges.ai.stationing.dataSource.hashtable.get(i));
				}
				
				return pass;
			};	
					
	public List<String> componentPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Classification");
		cPL.add("Stationing");	
		
		return cPL;
	}
	
	public List<String> availablePriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Client Questionnaire");	
		cPL.add("Alignment Maps");	
		cPL.add("Odometer Data");	
		
		return cPL;
	}
	
	public List<String> selectedPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listings");	
		cPL.add("Previous Runs");	
		cPL.add("Tracking Sheet");	
		
		return cPL;
	}
	
	
	@SuppressWarnings("unchecked")
	@ParameterizedTest
	@ValueSource(strings = {"Flanges_1.json", "Flanges_2.json"})
	public void testFlangesPage(String argument) throws Exception {
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
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-aa-flanges&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
			
		elements.add(new CBElement(driver, descAllCapsVal, "descriptionAllCaps_cb", argumentFile.defaultValues.includeCB));
		elements.add(new TextElement(driver, defaultDescVal, "defaultDescription_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new IWVElement(driver, isolFlangeDescVal, "isolatedDescription_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, specFlangeDescVal, "spectacleDescription_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, staFlangeDescVal, "stationingPrefix_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new CBElement(driver, encloseStaVal, "encloseStationing_cb", argumentFile.defaultValues.includeCB));
		elements.add(new DragListElement(driver, dragListVal, "componentsOrder_cl", 
				(List<String>) argumentFile.uniqueValues.get("componentsOrder_cl"), argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
		elements.add(new TextElement(driver, notesVal, "additionalNotes_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, marksVal, "examples_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new StationingSelectElement(driver, stationingVal, "stationing_sta", (List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), 
				argumentFile.defaultValues.stationingSelection, argumentFile.defaultValues.customStationingValue, argumentFile.defaultValues.includeStationing));
		
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
		compTest.compaireDB(elements, "Flanges", tables.APPURTENANCES_AND_ATTACHMENTS, "FlangesResults", argumentFile.FileCounter);
	}
}