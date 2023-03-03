package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.miscellaneous.Miscellaneous;
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

public class RecoatsCDTest extends BaseCDTest {


	ElementValidationInterface addLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.returnedValues 
						= (typedList.get(0).recoats.beginCustomDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).recoats.beginCustomDescription.value;
				
				return (typedList.get(0).recoats.beginCustomDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).recoats.beginCustomDescription.value));
			};

			
	ElementValidationInterface componentListBeginVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.returnedValues
						= typedList.get(0).recoats.beginComponentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).recoats.beginComponentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).recoats.beginComponentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).recoats.beginComponentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).recoats.beginComponentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).recoats.beginComponentsOrder.hashtable.get(1).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).recoats.beginComponentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).recoats.beginComponentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).recoats.beginComponentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).recoats.beginComponentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).recoats.beginComponentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).recoats.beginComponentsOrder.hashtable.get(1).separatorSpacing.toString()));
			};
			
	ElementValidationInterface endLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.returnedValues 
						= (typedList.get(0).recoats.endCustomDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).recoats.endCustomDescription.value;
				
				return (typedList.get(0).recoats.endCustomDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).recoats.endCustomDescription.value));
			};

			
	ElementValidationInterface componentListEndVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.returnedValues
						= typedList.get(0).recoats.endComponentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).recoats.endComponentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).recoats.endComponentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).recoats.endComponentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).recoats.endComponentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).recoats.endComponentsOrder.hashtable.get(1).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).recoats.endComponentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).recoats.endComponentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).recoats.endComponentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).recoats.endComponentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).recoats.endComponentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).recoats.endComponentsOrder.hashtable.get(1).separatorSpacing.toString()));
			};
			
			
	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.returnedValues 
						= typedList.get(0).recoats.ai.additionalNotes;
				
				return ele.txtValue.equals(typedList.get(0).recoats.ai.additionalNotes);
			};
	ElementValidationInterface markingVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.returnedValues 
						= typedList.get(0).recoats.ai.examples;
				
				return ele.txtValue.equals(typedList.get(0).recoats.ai.examples);
			};
			
	ElementValidationInterface addRepDigInfoVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Miscellaneous> typedList = (List<Miscellaneous>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.txtValue + ", " + ele.secondaryList;
				
				ele.returnedValues 
				= (typedList.get(0).recoats.ai.addRepairDigInfoToDesc ? "True" : "False")
				+ ", " + typedList.get(0).recoats.ai.formattingInfo.digRepairNumberFormat;
				
				//Hashtable size is dynamic
				for(int i = 0; i < ele.secondaryList.size(); i++) {
					ele.returnedValues += ", " + typedList.get(0).recoats.ai.formattingInfo.componentsOrder.hashtable.get(i);
				}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).recoats.ai.addRepairDigInfoToDesc == ele.tertiaryFlag
						&& typedList.get(0).recoats.ai.formattingInfo.digRepairNumberFormat.equals(ele.txtValue);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(0 + i).equals(typedList.get(0).recoats.ai.formattingInfo.componentsOrder.hashtable.get(i));
				}
				
				return pass;
			};	

	public List<String> beginPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Repair/Dig Info");
		cPL.add("Name");
		
		return cPL;
	}
	
	public List<String> endPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Name");
		cPL.add("Repair/Dig Info");
		
		return cPL;
	}
	
	public List<String> availablePriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig/Repair Number");
		cPL.add("Dig Length");
		cPL.add("Dig Orientation");
		
		return cPL;
	}
	
	public List<String> selectedPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig Width");
		cPL.add("Dig Depth");
		
		return cPL;
	}
	
	
	@SuppressWarnings("unchecked")
	@ParameterizedTest
	@ValueSource(strings = {"Recoats_1.json", "Recoats_2.json"})
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
		
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-miscellaneous-recoats&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
			
		elements.add(new IWVElement(driver, addLabelVal, "begCustomDesc_iwv", "Recoat", argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new DragListElement(driver, componentListBeginVal, "beginComponents_cl", (List<String>) argumentFile.uniqueValues.get("beginComponents_cl"), 
				argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
		elements.add(new IWVElement(driver, endLabelVal, "endCustomDesc_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new DragListElement(driver, componentListEndVal, "endComponents_cl", (List<String>) argumentFile.uniqueValues.get("endComponents_cl"), 
				argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
		
		elements.add(new TextElement(driver, deviationsVal, "additionalNotes_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, markingVal, "examples_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new SimpleDataSourceElement(driver, addRepDigInfoVal, "recoats_fi",  
				(List<String>) argumentFile.uniqueValues.get("acceptedList"),  (List<String>) argumentFile.uniqueValues.get("selectedList"), 
				argumentFile.defaultValues.simpleDataSourceTextVal, true, false, argumentFile.defaultValues.includeSimpleDataSource));
		
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
		compTest.compaireDB(elements, "Recoats", tables.MISCELLANEOUS, "RecoatsResults", argumentFile.FileCounter);
	}
}