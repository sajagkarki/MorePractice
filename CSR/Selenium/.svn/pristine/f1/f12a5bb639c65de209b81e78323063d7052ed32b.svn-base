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

public class WeldPlusEndCDTest extends BaseCDTest {
	
	ElementValidationInterface RGUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
				= typedList.get(0).weldPlusEnd.reportType + "";
				
				return (CSREnums.ReportType.valueOf(mapping[ele.generalIndex]).equals(typedList.get(0).weldPlusEnd.reportType));
			};
			
	ElementValidationInterface roundNearestVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= (typedList.get(0).weldPlusEnd.includeCustomDesc.include ? "True" : "False")
						+ ", " + typedList.get(0).weldPlusEnd.includeCustomDesc.value;
				
				return (typedList.get(0).weldPlusEnd.includeCustomDesc.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).weldPlusEnd.includeCustomDesc.value));
			};
			
	ElementValidationInterface encStaVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= (typedList.get(0).weldPlusEnd.includeReportBeginAndEndOfEach ? "True" : "False");
				
				return (typedList.get(0).weldPlusEnd.includeReportBeginAndEndOfEach == ele.bool);
			};
	
	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= typedList.get(0).weldPlusEnd.ai.additionalNotes;
				
				return ele.txtValue.equals(typedList.get(0).weldPlusEnd.ai.additionalNotes);
			};
	ElementValidationInterface markingVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Repairs> typedList = (List<Repairs>) list;
				
				ele.returnedValues 
						= typedList.get(0).weldPlusEnd.ai.examples;
				
				return ele.txtValue.equals(typedList.get(0).weldPlusEnd.ai.examples);
			};
			
			
			
	
	public List<String> componentPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("O'clock");
		cPL.add("Dimensions");
		cPL.add("Label");
		
		return cPL;
	}
	
	
	
	@ParameterizedTest
	@ValueSource(strings = {"WeldPlusEnd_1.json", "WeldPlusEnd_2.json", "WeldPlusEnd_3.json"})
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
		
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-repairs-weldplusend&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
			
		elements.add(new RGElement(driver, null, "reportType_rg", 0)); //Prevent Apply from being blocked out due to separate bug.
		
		int radioSelection = argumentFile.defaultValues.defaultRGValues;
		elements.add(new RGElement(driver, RGUnitVal, "reportType_rg", radioSelection));
		if(radioSelection == 1)
		{
			elements.add(new IWVElement(driver, roundNearestVal, "includeCustomDesc_tf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.add(new CBElement(driver, encStaVal, "includeReport_cb", argumentFile.defaultValues.includeCB));
		}

		elements.add(new TextElement(driver, deviationsVal, "additionalNotes_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, markingVal, "examples_ta", argumentFile.defaultValues.defaultTextValue));
		
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
		compTest.compaireDB(elements, "Weld Plus End Repairs", tables.REPAIRS, "WeldPlusEndResults", argumentFile.FileCounter);
	}
}