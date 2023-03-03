package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.deformations.dents.Dents;
import com.tdw.csr.entity.metal_loss.*;

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

public class AxialPlanarsCDTest extends BaseCDTest {

	ElementValidationInterface APDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).axialPlanars.includeAPDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).axialPlanars.includeAPDescription.value;
				
				return (typedList.get(0).axialPlanars.includeAPDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).axialPlanars.includeAPDescription.value));
			};
	ElementValidationInterface addSeamDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).axialPlanars.interactingSV.include ? "True" : "False")
						+ ", " + typedList.get(0).axialPlanars.interactingSV.value;
				
				return (typedList.get(0).axialPlanars.interactingSV.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).axialPlanars.interactingSV.value));
			};
	ElementValidationInterface inSeamVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).axialPlanars.interactingAxialPlanarInSeam.include ? "True" : "False")
						+ ", " + typedList.get(0).axialPlanars.interactingAxialPlanarInSeam.value;
				
				return (typedList.get(0).axialPlanars.interactingAxialPlanarInSeam.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).axialPlanars.interactingAxialPlanarInSeam.value));
			};
			
	
	ElementValidationInterface incOverspeedDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
				= (typedList.get(0).axialPlanars.degradedConditionsDescription.overspeed.include ? "True" : "False")
				+ ", " + typedList.get(0).axialPlanars.degradedConditionsDescription.overspeed.value;
				
				return (typedList.get(0).axialPlanars.degradedConditionsDescription.overspeed.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).axialPlanars.degradedConditionsDescription.overspeed.value));
			};
	ElementValidationInterface incDegradedDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
				= (typedList.get(0).axialPlanars.degradedConditionsDescription.degradedSensors.include ? "True" : "False")
				+ ", " + typedList.get(0).axialPlanars.degradedConditionsDescription.degradedSensors.value;
				
				return (typedList.get(0).axialPlanars.degradedConditionsDescription.degradedSensors.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).axialPlanars.degradedConditionsDescription.degradedSensors.value));
			};
	ElementValidationInterface incDegOverDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
				= (typedList.get(0).axialPlanars.degradedConditionsDescription.degradedSensorsAndOverspeed.include ? "True" : "False")
				+ ", " + typedList.get(0).axialPlanars.degradedConditionsDescription.degradedSensorsAndOverspeed.value;
				
				return (typedList.get(0).axialPlanars.degradedConditionsDescription.degradedSensorsAndOverspeed.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).axialPlanars.degradedConditionsDescription.degradedSensorsAndOverspeed.value));
			};
	ElementValidationInterface incBeyondDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
				= (typedList.get(0).axialPlanars.degradedConditionsDescription.degradedSensorsBeyondSpec.include ? "True" : "False")
				+ ", " + typedList.get(0).axialPlanars.degradedConditionsDescription.degradedSensorsBeyondSpec.value;
				
				return (typedList.get(0).axialPlanars.degradedConditionsDescription.degradedSensorsBeyondSpec.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).axialPlanars.degradedConditionsDescription.degradedSensorsBeyondSpec.value));
			};
	ElementValidationInterface inOverBeyondDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
				= (typedList.get(0).axialPlanars.degradedConditionsDescription.overspeedBeyondSpec.include ? "True" : "False")
				+ ", " + typedList.get(0).axialPlanars.degradedConditionsDescription.overspeedBeyondSpec.value;
				
				return (typedList.get(0).axialPlanars.degradedConditionsDescription.overspeedBeyondSpec.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).axialPlanars.degradedConditionsDescription.overspeedBeyondSpec.value));
			};
	ElementValidationInterface incOverSensorBeyondDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
				= (typedList.get(0).axialPlanars.degradedConditionsDescription.degradedSensorsAndOverspeedBeyondSpec.include ? "True" : "False")
				+ ", " + typedList.get(0).axialPlanars.degradedConditionsDescription.degradedSensorsAndOverspeedBeyondSpec.value;
				
				return (typedList.get(0).axialPlanars.degradedConditionsDescription.degradedSensorsAndOverspeedBeyondSpec.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).axialPlanars.degradedConditionsDescription.degradedSensorsAndOverspeedBeyondSpec.value));
			};
			
			
	ElementValidationInterface componentListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues
						= typedList.get(0).axialPlanars.componentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).axialPlanars.componentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).axialPlanars.componentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).axialPlanars.componentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).axialPlanars.componentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).axialPlanars.componentsOrder.hashtable.get(1).separatorSpacing
						+ ", " + typedList.get(0).axialPlanars.componentsOrder.hashtable.get(2).component
						+ ", " + typedList.get(0).axialPlanars.componentsOrder.hashtable.get(2).separator
						+ ", " + typedList.get(0).axialPlanars.componentsOrder.hashtable.get(2).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).axialPlanars.componentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).axialPlanars.componentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).axialPlanars.componentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).axialPlanars.componentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).axialPlanars.componentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).axialPlanars.componentsOrder.hashtable.get(1).separatorSpacing.toString()))
				&& (ele.validationStrings.get(6).equals(typedList.get(0).axialPlanars.componentsOrder.hashtable.get(2).component))
				&& (ele.validationStrings.get(7) == null || ele.validationStrings.get(7).equals(typedList.get(0).axialPlanars.componentsOrder.hashtable.get(2).separator.toString()))
				&& (ele.validationStrings.get(8) == null || ele.validationStrings.get(8).equals(typedList.get(0).axialPlanars.componentsOrder.hashtable.get(2).separatorSpacing.toString()));
			};
			
			
	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= typedList.get(0).axialPlanars.ai.additionalNotes;
				
				return (ele.txtValue.equals(typedList.get(0).axialPlanars.ai.additionalNotes));
			};
	ElementValidationInterface examplesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= typedList.get(0).axialPlanars.ai.examples;
				
				return (ele.txtValue.equals(typedList.get(0).axialPlanars.ai.examples));
			};
	
	public List<String> componentPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("SV Interaction");
		cPL.add("Description");
		cPL.add("Interaction Info");
		
		return cPL;
	}
	
	@SuppressWarnings("unchecked")
	@ParameterizedTest
	@ValueSource(strings = {"AxialPlanar_1.json", "AxialPlanar_2.json", "AxialPlanar_3.json"})
	public void testAxialPlanarsPage(String argument) throws Exception {
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
		
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-metal_loss-axialplanars&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
	
			elements.add(new IWVElement(driver, APDescVal, "includeDescriptionAP_iwf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.add(new IWVElement(driver, addSeamDescVal, "interactingSV_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.add(new IWVElement(driver, inSeamVal, "interactingAxialPlanarInSeam_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			
			elements.add(new IWVElement(driver, incOverspeedDescVal, "overspeed_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.add(new IWVElement(driver, incDegradedDescVal, "degradedSensors_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.add(new IWVElement(driver, incDegOverDescVal, "degradedSensorsAndOverspeed_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.add(new IWVElement(driver, incBeyondDescVal, "degradedSensorsBeyondSpec_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.add(new IWVElement(driver, inOverBeyondDescVal, "overspeedBeyondSpec_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.add(new IWVElement(driver, incOverSensorBeyondDescVal, "degradedSensorsAndOverspeedBeyondSpec_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			
			elements.add(new DragListElement(driver, componentListVal, "componentsOrder_cl", (List<String>) argumentFile.uniqueValues.get("componentsOrder_cl"), argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
			
			elements.add(new TextElement(driver, deviationsVal, "additionalNotes_ta", argumentFile.defaultValues.defaultTextValue));
			elements.add(new TextElement(driver, examplesVal, "examples_ta", argumentFile.defaultValues.defaultTextValue));
			
			Thread.sleep(3000);
			
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
		compTest.compaireDB(elements, "Axial Planars", tables.METAL_LOSS, "AxialPlanarsResults", argumentFile.FileCounter);
	}
}