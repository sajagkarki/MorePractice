package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.repairs.Repairs;
import com.tdw.csr.entity.standard_report_manifests.StandardReportManifests;

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

public class GasReportsCDTest extends BaseCDTest {
	
	ElementValidationInterface measurementVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<StandardReportManifests> typedList = (List<StandardReportManifests>) list;
				
				String[] mapping = {"Imperial", "Metric"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).gas.reportingMeasurementUnits;
				
				return (ele.expectedValue.equals(typedList.get(0).gas.reportingMeasurementUnits));
			};
	ElementValidationInterface pressureVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<StandardReportManifests> typedList = (List<StandardReportManifests>) list;
				
				String[] mapping = {"PSI", "KSI", "BAR", "Kilopascal", "Megapascal", "Pascal", "Kg/cm^2"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).gas.reportingPressureUnits;
				
				return (ele.expectedValue.equals(typedList.get(0).gas.reportingPressureUnits));
			};
	ElementValidationInterface temperatureVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<StandardReportManifests> typedList = (List<StandardReportManifests>) list;
				
				String[] mapping = {"Fahrenheit", "Celsius"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).gas.reportingTemperatureUnits;
				
				return (ele.expectedValue.equals(typedList.get(0).gas.reportingTemperatureUnits));
			};
	
	ElementValidationInterface encStaVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<StandardReportManifests> typedList = (List<StandardReportManifests>) list;
				
				ele.returnedValues 
						= (typedList.get(0).gas.includeGPSInfo ? "True" : "False");
				
				return (typedList.get(0).gas.includeGPSInfo == ele.bool);
			};
	ElementValidationInterface addDimVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<StandardReportManifests> typedList = (List<StandardReportManifests>) list;
				
				ele.returnedValues 
						= (typedList.get(0).gas.includeMappingInfo ? "True" : "False");
				
				return (typedList.get(0).gas.includeMappingInfo == ele.bool);
			};
	
	@ParameterizedTest
	@ValueSource(strings = {"GasReports_1.json", "GasReports_2.json"})
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
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-standardreportmanifests-gas&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
			
		elements.add(new SelectElement(driver, measurementVal, "measurementsUnits_ts", argumentFile.defaultValues.defaultSelectValue));
		elements.add(new SelectElement(driver, pressureVal, "pressureUnits_ts", argumentFile.defaultValues.defaultSelectValue));
		elements.add(new SelectElement(driver, temperatureVal, "temperatureUnits_ts", argumentFile.defaultValues.defaultSelectValue));
		elements.add(new CBElement(driver, encStaVal, "includeGPS_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, addDimVal, "includeMapping_cb", argumentFile.defaultValues.includeCB));
		
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
		compTest.compaireDB(elements, "Gas Reports Repairs", tables.STANDARD_REPORT_MANIFESTS, "GasReportsResults", argumentFile.FileCounter);
	}
}