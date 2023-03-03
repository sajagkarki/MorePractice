package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.CSRDoc;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.appurtenances_attachments.AppurtenancesAndAttachments;

import chromedriver.UIElements.CBElement;
import chromedriver.UIElements.ConfigurationErrorElement;
import chromedriver.UIElements.DragListElement;
import chromedriver.UIElements.IWVElement;
import chromedriver.UIElements.IWVSElement;
import chromedriver.UIElements.OrientationDescElement;
import chromedriver.UIElements.StationingSelectElement;
import chromedriver.UIElements.TextElement;
import chromedriver.UIElements.tryCloseDialogElement;
import chromedriver.BaseCDTest;
import chromedriver.CompaireDB.tables;

import org.openqa.selenium.chrome.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.tdw.csr.dao.AppurtenancesAndAttachmentsDAO;
import com.tdw.csr.dao.CSRFilter;
import com.tdw.csr.dao.EntityFilter;
import com.tdw.csr.entity.CSRDoc;
import com.tdw.csr.entity.appurtenances_attachments.AppurtenancesAndAttachments;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AttachmentsCDTest extends BaseCDTest {
	
	//Define Validators
	ElementValidationInterface descAllCapsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).attachments.descriptionAllCaps ? "True" : "False";
				
				return ele.bool == typedList.get(0).attachments.descriptionAllCaps;
			};
	ElementValidationInterface roundLocVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).attachments.roundOrientation ? "True" : "False";
				
				return ele.bool == typedList.get(0).attachments.roundOrientation;
			};
	ElementValidationInterface addDimToDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).attachments.includeOpeningDimensions ? "True" : "False";
				
				return ele.bool == typedList.get(0).attachments.includeOpeningDimensions;
			};
	ElementValidationInterface begLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).attachments.customDesc.include ? "True" : "False") 
						+ ", " + typedList.get(0).attachments.customDesc.value;
				
				return typedList.get(0).attachments.customDesc.include == ele.bool
				&& ele.txtValue.equals(typedList.get(0).attachments.customDesc.value);
			};
	ElementValidationInterface roundToNearestBoolVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).attachments.roundOpeningDimensions.include ? "True" : "False";
				
				return typedList.get(0).attachments.roundOpeningDimensions.include;
			};
	ElementValidationInterface roundToNearestTextVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).attachments.roundOpeningDimensions.include ? "True" : "False")
						+ ", " + typedList.get(0).attachments.roundOpeningDimensions.value;
				
				return typedList.get(0).attachments.roundOpeningDimensions.include == ele.bool
				&& Double.parseDouble(ele.txtValue) == typedList.get(0).attachments.roundOpeningDimensions.value;
			};
	ElementValidationInterface roundToNearestSelectVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).attachments.roundOpeningDimensions.include ? "True" : "False")
						+ ", " + typedList.get(0).attachments.roundOpeningDimensions.units;
				
				List<String> mapping = Arrays.asList(
						"in",
						"\"",
						"mm",
						"ft",
						"'",
						"m"
						);
				
				String expectedVal = mapping.get(ele.dropDownIndex);
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + expectedVal;
				
				return typedList.get(0).attachments.roundOpeningDimensions.include == ele.bool
				&& expectedVal.equals(typedList.get(0).attachments.roundOpeningDimensions.units);
				
			};
	ElementValidationInterface orientDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).attachments.orientationDescription.topOfPipe.prefix
						+ ", " + typedList.get(0).attachments.orientationDescription.topOfPipe.description
						+ ", " + typedList.get(0).attachments.orientationDescription.twoSeventyDegreesOfPipe.prefix
						+ ", " + typedList.get(0).attachments.orientationDescription.twoSeventyDegreesOfPipe.description
						+ ", " + typedList.get(0).attachments.orientationDescription.ninetyDegreesOfPipe.prefix
						+ ", " + typedList.get(0).attachments.orientationDescription.ninetyDegreesOfPipe.description
						+ ", " + typedList.get(0).attachments.orientationDescription.bottomOfPipe.prefix
						+ ", " + typedList.get(0).attachments.orientationDescription.bottomOfPipe.description;
				
				return ele.validationStrings.get(0).equals(typedList.get(0).attachments.orientationDescription.topOfPipe.prefix) 
				&& ele.validationStrings.get(1).equals(typedList.get(0).attachments.orientationDescription.topOfPipe.description)
				&& ele.validationStrings.get(2).equals(typedList.get(0).attachments.orientationDescription.twoSeventyDegreesOfPipe.prefix)
				&& ele.validationStrings.get(3).equals(typedList.get(0).attachments.orientationDescription.twoSeventyDegreesOfPipe.description)
				&& ele.validationStrings.get(4).equals(typedList.get(0).attachments.orientationDescription.ninetyDegreesOfPipe.prefix)
				&& ele.validationStrings.get(5).equals(typedList.get(0).attachments.orientationDescription.ninetyDegreesOfPipe.description)
				&& ele.validationStrings.get(6).equals(typedList.get(0).attachments.orientationDescription.bottomOfPipe.prefix)
				&& ele.validationStrings.get(7).equals(typedList.get(0).attachments.orientationDescription.bottomOfPipe.description);
			};
	ElementValidationInterface dragListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues
						= typedList.get(0).attachments.componentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).attachments.componentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).attachments.componentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).attachments.componentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).attachments.componentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).attachments.componentsOrder.hashtable.get(1).separatorSpacing
						+ ", " + typedList.get(0).attachments.componentsOrder.hashtable.get(2).component
						+ ", " + typedList.get(0).attachments.componentsOrder.hashtable.get(2).separator
						+ ", " + typedList.get(0).attachments.componentsOrder.hashtable.get(2).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).attachments.componentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).attachments.componentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).attachments.componentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).attachments.componentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).attachments.componentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).attachments.componentsOrder.hashtable.get(1).separatorSpacing.toString()))
				&& (ele.validationStrings.get(6).equals(typedList.get(0).attachments.componentsOrder.hashtable.get(2).component))
				&& (ele.validationStrings.get(7) == null || ele.validationStrings.get(7).equals(typedList.get(0).attachments.componentsOrder.hashtable.get(2).separator.toString()))
				&& (ele.validationStrings.get(8) == null || ele.validationStrings.get(8).equals(typedList.get(0).attachments.componentsOrder.hashtable.get(2).separatorSpacing.toString()));
			};
	ElementValidationInterface notesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues
						= typedList.get(0).attachments.ai.additionalNotes;
				
				return ele.txtValue.equals(typedList.get(0).attachments.ai.additionalNotes);
			};
	ElementValidationInterface markingExVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues
						= typedList.get(0).attachments.ai.examples;
				
				return ele.txtValue.equals(typedList.get(0).attachments.ai.examples);
			};
	
	private AppurtenancesAndAttachmentsDAO createAADAO() {
		try {
			AppurtenancesAndAttachmentsDAO dao = new AppurtenancesAndAttachmentsDAO(mc);
			return dao;
		} catch (IOException e) {
			throw new RuntimeException("Couldn't create AppurtenancesAndAttachmentsDAO");
		}
	}
	
	public List<String> componentPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Description");
		cPL.add("Orientation");
		cPL.add("Dimensions");
		
		return cPL;
	}
	
	@SuppressWarnings("unchecked")
	@ParameterizedTest
	@ValueSource(strings = {"Attachments_1.json", "Attachments_2.json", "Attachments_3.json"})
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
		chromeOptions.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-aa-attachments&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {

			elements.add(new CBElement(driver, descAllCapsVal, "descriptionAllCaps_cb", argumentFile.defaultValues.includeCB));
			elements.add(new CBElement(driver, roundLocVal, "general_cb", argumentFile.defaultValues.includeCB));
			elements.add(new IWVElement(driver, begLabelVal, "beginLabel_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.add(new TextElement(driver, notesVal, "additionalNotes_ta", argumentFile.defaultValues.defaultTextValue));
			elements.add(new TextElement(driver, markingExVal, "examples_ta", argumentFile.defaultValues.defaultTextValue));
			elements.add(new DragListElement(driver, dragListVal, "roundOrientation_cl", (List<String>) argumentFile.uniqueValues.get("roundOrientation_cl"), argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
			elements.add(new OrientationDescElement(driver, orientDescVal, "orientationDesc_od", "od_btn", argumentFile.defaultValues.orientationDescriptionVals));
			boolean addDimToDesc = (Boolean) argumentFile.uniqueValues.get("includeOpeningDimensions_cb");
			elements.add(new CBElement(driver, addDimToDescVal, "includeOpeningDimensions_cb", addDimToDesc));
			if(addDimToDesc)
			{
				elements.add(new IWVElement(driver, roundToNearestTextVal, "roundOrientation_iwv", "0.75", argumentFile.defaultValues.includeIWVorIWVS));
				elements.add(new IWVSElement(driver, roundToNearestSelectVal, "roundOrientation_iwv", 3, argumentFile.defaultValues.includeIWVorIWVS));
			}
		
		}
		catch(Exception ex) { //Configuration Error
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
		compTest.compaireDB(elements, "Attachments", tables.APPURTENANCES_AND_ATTACHMENTS, "AttachmentsResults", argumentFile.FileCounter);
	}
}