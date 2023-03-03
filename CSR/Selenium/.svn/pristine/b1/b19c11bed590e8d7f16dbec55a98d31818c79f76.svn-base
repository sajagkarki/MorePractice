package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.deformations.Deformations;
import com.tdw.csr.entity.gains.Gains;

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

public class GainsCDTest extends BaseCDTest {

	ElementValidationInterface addLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Gains> typedList = (List<Gains>) list;
				
				ele.returnedValues 
						= (typedList.get(0).customDesc.include ? "True" : "False")
						+ ", " + typedList.get(0).customDesc.value;
				
				return (typedList.get(0).customDesc.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).customDesc.value));
			};
	ElementValidationInterface filterGaussVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Gains> typedList = (List<Gains>) list;
				
				ele.returnedValues 
						= (typedList.get(0).filterOnGaussLevel.include ? "True" : "False")
						+ ", " + typedList.get(0).filterOnGaussLevel.value;
				
				return (typedList.get(0).filterOnGaussLevel.include == ele.bool)
						&& (Double.parseDouble(ele.txtValue) == (typedList.get(0).filterOnGaussLevel.value));
			};
	ElementValidationInterface depthGainVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Gains> typedList = (List<Gains>) list;
				
				ele.returnedValues 
				= (typedList.get(0).showDepth ? "True" : "False");
				
				return (typedList.get(0).showDepth == ele.bool);
			};
	ElementValidationInterface circumfLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Gains> typedList = (List<Gains>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fullCircDesc.include ? "True" : "False")
						+ ", " + typedList.get(0).fullCircDesc.value;
				
				return (typedList.get(0).fullCircDesc.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).fullCircDesc.value));
			};
	ElementValidationInterface incMetalVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Gains> typedList = (List<Gains>) list;
				
				ele.returnedValues 
				= (typedList.get(0).includeMetalObjectType ? "True" : "False");
				
				return (typedList.get(0).includeMetalObjectType == ele.bool);
			};
	ElementValidationInterface addDimVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Gains> typedList = (List<Gains>) list;
				
				ele.returnedValues 
				= (typedList.get(0).includeOpeningDimensions ? "True" : "False");
				
				return (typedList.get(0).includeOpeningDimensions == ele.bool);
			};
	ElementValidationInterface roundNumVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Gains> typedList = (List<Gains>) list;
				
				ele.returnedValues 
						= (typedList.get(0).roundOpeningDimensions.include ? "True" : "False")
						+ ", " + typedList.get(0).roundOpeningDimensions.value;
				
				return (typedList.get(0).roundOpeningDimensions.include == ele.bool)
						&& (Double.parseDouble(ele.txtValue) == (typedList.get(0).roundOpeningDimensions.value));
			};
	ElementValidationInterface roundSelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Gains> typedList = (List<Gains>) list;
				
				String[] mapping = {"in", "\"", "mm", "ft", "'", "m"};
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).roundOpeningDimensions.units;
				
				return ele.expectedValue.equals(typedList.get(0).roundOpeningDimensions.units);
	};
	ElementValidationInterface componentListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Gains> typedList = (List<Gains>) list;
				
				ele.returnedValues
						= typedList.get(0).componentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(1).separatorSpacing
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(2).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(2).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(2).separatorSpacing
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(3).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(3).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(3).separatorSpacing
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(4).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(4).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(4).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).componentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).componentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).componentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).componentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).componentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).componentsOrder.hashtable.get(1).separatorSpacing.toString()))
				&& (ele.validationStrings.get(6).equals(typedList.get(0).componentsOrder.hashtable.get(2).component))
				&& (ele.validationStrings.get(7) == null || ele.validationStrings.get(7).equals(typedList.get(0).componentsOrder.hashtable.get(2).separator.toString()))
				&& (ele.validationStrings.get(8) == null || ele.validationStrings.get(8).equals(typedList.get(0).componentsOrder.hashtable.get(2).separatorSpacing.toString()))
				&& (ele.validationStrings.get(9).equals(typedList.get(0).componentsOrder.hashtable.get(3).component))
				&& (ele.validationStrings.get(10) == null || ele.validationStrings.get(10).equals(typedList.get(0).componentsOrder.hashtable.get(3).separator.toString()))
				&& (ele.validationStrings.get(11) == null || ele.validationStrings.get(11).equals(typedList.get(0).componentsOrder.hashtable.get(3).separatorSpacing.toString()))
				&& (ele.validationStrings.get(12).equals(typedList.get(0).componentsOrder.hashtable.get(4).component))
				&& (ele.validationStrings.get(13) == null || ele.validationStrings.get(13).equals(typedList.get(0).componentsOrder.hashtable.get(4).separator.toString()))
				&& (ele.validationStrings.get(14) == null || ele.validationStrings.get(14).equals(typedList.get(0).componentsOrder.hashtable.get(4).separatorSpacing.toString()));
			};
			
	ElementValidationInterface pwLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Gains> typedList = (List<Gains>) list;
				
				ele.returnedValues 
						= (typedList.get(0).puddleWelds.customDesc.include ? "True" : "False")
						+ ", " + typedList.get(0).puddleWelds.customDesc.value;
				
				return (typedList.get(0).puddleWelds.customDesc.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).puddleWelds.customDesc.value));
			};
	ElementValidationInterface oClockVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Gains> typedList = (List<Gains>) list;
				
				ele.returnedValues 
				= (typedList.get(0).puddleWelds.orientationReportedInOClock ? "True" : "False");
				
				return (typedList.get(0).puddleWelds.orientationReportedInOClock == ele.bool);
			};
	ElementValidationInterface pwRepVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Gains> typedList = (List<Gains>) list;
				
				ele.returnedValues 
				= (typedList.get(0).puddleWelds.includeGaussInformation ? "True" : "False");
				
				return (typedList.get(0).puddleWelds.includeGaussInformation == ele.bool);
			};
	ElementValidationInterface componentList2Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Gains> typedList = (List<Gains>) list;
				
				ele.returnedValues
						= typedList.get(0).puddleWelds.componentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).puddleWelds.componentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).puddleWelds.componentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).puddleWelds.componentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).puddleWelds.componentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).puddleWelds.componentsOrder.hashtable.get(1).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).puddleWelds.componentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).puddleWelds.componentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).puddleWelds.componentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).puddleWelds.componentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).puddleWelds.componentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).puddleWelds.componentsOrder.hashtable.get(1).separatorSpacing.toString()));
			};
			
	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Gains> typedList = (List<Gains>) list;
				
				ele.returnedValues 
						= typedList.get(0).ai.additionalNotes;
				
				return (ele.txtValue.equals(typedList.get(0).ai.additionalNotes));
			};
	ElementValidationInterface examplesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Gains> typedList = (List<Gains>) list;
				
				ele.returnedValues 
						= typedList.get(0).ai.examples;
				
				return (ele.txtValue.equals(typedList.get(0).ai.examples));
			};
					
					
	public List<String> dragPrioritylist() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Full Circumferential");
		cPL.add("Metal Object Type");
		cPL.add("Dimensions");
		cPL.add("Depth");
		cPL.add("Description");
		
		return cPL;
	}
	
	public List<String> puddlePrioritylist() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Orientation");
		cPL.add("Description");
		
		return cPL;
	}
	
	@SuppressWarnings("unchecked")
	@ParameterizedTest
	@ValueSource(strings = {"Gains_1.json", "Gains_2.json", "Gains_3.json"})
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
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-gains&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
			
		//Casings report label and classification
		elements.add(new IWVElement(driver, addLabelVal, "prefixGainLabel_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, filterGaussVal, "filterGauss_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new CBElement(driver, depthGainVal, "showDepth_cb", argumentFile.defaultValues.includeCB));
		elements.add(new IWVElement(driver, circumfLabelVal, "fullCircLabel_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new CBElement(driver, incMetalVal, "includeMetalObjectType_cb", argumentFile.defaultValues.includeCB));
		
		boolean inc = (Boolean) argumentFile.uniqueValues.get("includeOpeningDimensions_cb");
		elements.add(new CBElement(driver, addDimVal, "includeOpeningDimensions_cb", inc));
		if(inc)
		{
			elements.add(new IWVElement(driver, roundNumVal, "roundOrientation_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.add(new IWVSElement(driver, roundSelVal, "roundOrientation_iwv", argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.includeIWVorIWVS));
		}
		
		elements.add(new DragListElement(driver, componentListVal, "componentsOrder_cl", (List<String>) argumentFile.uniqueValues.get("componentsOrder_cl"), 
				argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
		
		//Puddle
		elements.add(new IWVElement(driver, pwLabelVal, "prefixLabel_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new CBElement(driver, oClockVal, "orientationInOClock_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, pwRepVal, "showPuddleDepth_cb", argumentFile.defaultValues.includeCB));
		elements.add(new DragListElement(driver, componentList2Val, "puddleWeldsComponentsOrder_cl", (List<String>) argumentFile.uniqueValues.get("puddleWeldsComponentsOrder_cl"), 
				argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
		
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
		compTest.compaireDB(elements, "Gains", tables.GAINS, "GainsResults", argumentFile.FileCounter);
	}
}