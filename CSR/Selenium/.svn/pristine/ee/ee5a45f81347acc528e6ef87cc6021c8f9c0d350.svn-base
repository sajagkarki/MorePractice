package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.miscellaneous.Miscellaneous;
import com.tdw.csr.entity.wall_thickness.WallThickness;
import com.tdw.csr.entity.welds.Welds;

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

public class WallThicknessCDTest extends BaseCDTest {
	
	ElementValidationInterface SMYSVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<WallThickness> typedList = (List<WallThickness>) list;
				
				ele.returnedValues 
						= typedList.get(0).defaultSMYSValue + "";
				
				return Double.parseDouble(ele.txtValue) == (typedList.get(0).defaultSMYSValue);
			};
	ElementValidationInterface safetyVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<WallThickness> typedList = (List<WallThickness>) list;
				
				ele.returnedValues 
						= typedList.get(0).defaultSafetyFactor + "";
				
				return Double.parseDouble(ele.txtValue) == (typedList.get(0).defaultSafetyFactor);
			};
			
	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<WallThickness> typedList = (List<WallThickness>) list;
				
				ele.returnedValues 
						= typedList.get(0).ai.additionalNotes;
				
				return ele.txtValue.equals(typedList.get(0).ai.additionalNotes);
			};
	ElementValidationInterface markingVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<WallThickness> typedList = (List<WallThickness>) list;
				
				ele.returnedValues 
						= typedList.get(0).ai.examples;
				
				return ele.txtValue.equals(typedList.get(0).ai.examples);
			};
			
	ElementValidationInterface markForgedVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<WallThickness> typedList = (List<WallThickness>) list;
				
				ele.returnedValues 
						= (typedList.get(0).ai.includeWTInForgeBends ? "True" : "False");
				
				return (typedList.get(0).ai.includeWTInForgeBends == ele.bool);
			};
	ElementValidationInterface markNumVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<WallThickness> typedList = (List<WallThickness>) list;
				
				ele.returnedValues 
						= (typedList.get(0).ai.includeWTNearValvesWithin.include ? "True" : "False")
						+ ", " + typedList.get(0).ai.includeWTNearValvesWithin.value;
				
				return (typedList.get(0).ai.includeWTNearValvesWithin.include == ele.bool)
						&& (Double.parseDouble(ele.txtValue) == (typedList.get(0).ai.includeWTNearValvesWithin.value));
			};
	ElementValidationInterface markUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<WallThickness> typedList = (List<WallThickness>) list;
				
				String[] mapping = {"feet"};
				
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).ai.includeWTNearValvesWithin.include ? "True" : "False")
						+ ", " + typedList.get(0).ai.includeWTNearValvesWithin.units;
				
				return (typedList.get(0).ai.includeWTNearValvesWithin.include == ele.bool)
						&& (mapping[ele.dropDownIndex].equals(typedList.get(0).ai.includeWTNearValvesWithin.units));
			};
	
	@ParameterizedTest
	@ValueSource(strings = {"WallThickness_1.json", "WallThickness_2.json"})
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
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-wallthickness&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
			
		elements.add(new TextElement(driver, SMYSVal, "defaultSMYS_tf", Integer.toString(argumentFile.defaultValues.defaultIWVSValue)));
		elements.add(new TextElement(driver, safetyVal, "defaultSafety_tf", Integer.toString(argumentFile.defaultValues.defaultIWVSValue)));
		
		elements.add(new TextElement(driver, deviationsVal, "additionalNotes_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, markingVal, "examples_ta", argumentFile.defaultValues.defaultTextValue));
		
		elements.add(new CBElement(driver, markForgedVal, "includeWRInForgeBends_cb", argumentFile.defaultValues.includeCB));
		boolean markNearValves = argumentFile.defaultValues.includeIWVorIWVS;
		elements.add(new IWVElement(driver, markNumVal, "includeWTNearValves_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), markNearValves));
		elements.add(new IWVSElement(driver, markUnitVal, "includeWTNearValves_iwv", 0, markNearValves));
		
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
		compTest.compaireDB(elements, "Wall Thickness", tables.WALL_THICKNESS, "WallThicknessResults", argumentFile.FileCounter);
	}
}