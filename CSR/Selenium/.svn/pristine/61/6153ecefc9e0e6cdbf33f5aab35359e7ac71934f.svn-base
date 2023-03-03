package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.CSREnums;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.metal_loss.MetalLoss;
import com.tdw.csr.entity.metal_loss.pits.Pits;
import com.tdw.csr.entity.metal_loss.pits.PitsEnums;

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

public class PitAnalysisCDTest extends BaseCDTest {

	ElementValidationInterface notRepVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitAnalysis.excludePitsReportedUnderCasings ? "True" : "False");
				
				return (typedList.get(0).pitAnalysis.excludePitsReportedUnderCasings == ele.bool);
			};
			
	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= typedList.get(0).pitAnalysis.ai.additionalNotes;
				
				return ele.txtValue.equals(typedList.get(0).pitAnalysis.ai.additionalNotes);
			};
	
			
	ElementValidationInterface prelimRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"STANDARD", "SPECIAL"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).pitAnalysis.ai.primaryAnalysisEnum.toString();
				
				return PitsEnums.AnalysisType.valueOf(ele.expectedValue).equals(typedList.get(0).pitAnalysis.ai.primaryAnalysisEnum);
			};	
			
	ElementValidationInterface prelimDeepestRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"ALL_PITS", "DEEPEST"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).pitAnalysis.ai.pitCleanUpEnum.toString();
				
				return PitsEnums.PitsCleanUpType.valueOf(ele.expectedValue).equals(typedList.get(0).pitAnalysis.ai.pitCleanUpEnum);
			};	
	ElementValidationInterface prelimDeepestDepthVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitAnalysis.ai.depthGreaterThanEqualToPercent.include ? "True" : "False")
						+ ", " + typedList.get(0).pitAnalysis.ai.depthGreaterThanEqualToPercent.value;
				
				return (typedList.get(0).pitAnalysis.ai.depthGreaterThanEqualToPercent.include == ele.bool)
						&& (Integer.parseInt(ele.txtValue) == (typedList.get(0).pitAnalysis.ai.depthGreaterThanEqualToPercent.value));
			};
	ElementValidationInterface prelimDeepestTopVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitAnalysis.ai.topDeepest.include ? "True" : "False")
						+ ", " + typedList.get(0).pitAnalysis.ai.topDeepest.value;
				
				return (typedList.get(0).pitAnalysis.ai.topDeepest.include == ele.bool)
						&& (Integer.parseInt(ele.txtValue) == (typedList.get(0).pitAnalysis.ai.topDeepest.value));
			};
	ElementValidationInterface prelimDeepestCleanUpVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitAnalysis.ai.cleanUpJoints.include ? "True" : "False")
						+ ", " + typedList.get(0).pitAnalysis.ai.cleanUpJoints.value;
				
				return (typedList.get(0).pitAnalysis.ai.cleanUpJoints.include == ele.bool)
						&& (Integer.parseInt(ele.txtValue) == (typedList.get(0).pitAnalysis.ai.cleanUpJoints.value));
			};
			
	ElementValidationInterface prelimCleanedRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"TOP_CLEANED_UP", "TOP_DEEPEST"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).pitAnalysis.ai.reviewHandSizeEnum.toString();
				
				return PitsEnums.ReviewHandSizeType.valueOf(ele.expectedValue).equals(typedList.get(0).pitAnalysis.ai.reviewHandSizeEnum);
			};	
	ElementValidationInterface prelimCleanedDepthVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitAnalysis.ai.handSizeDepthGreaterThanEqualToPercent.include ? "True" : "False")
						+ ", " + typedList.get(0).pitAnalysis.ai.handSizeDepthGreaterThanEqualToPercent.value;
				
				return (typedList.get(0).pitAnalysis.ai.handSizeDepthGreaterThanEqualToPercent.include == ele.bool)
						&& (Integer.parseInt(ele.txtValue) == (typedList.get(0).pitAnalysis.ai.handSizeDepthGreaterThanEqualToPercent.value));
			};
	ElementValidationInterface prelimCleanedTopVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitAnalysis.ai.handSizeTopDeepest.include ? "True" : "False")
						+ ", " + typedList.get(0).pitAnalysis.ai.handSizeTopDeepest.value;
				
				return (typedList.get(0).pitAnalysis.ai.handSizeTopDeepest.include == ele.bool)
						&& (Integer.parseInt(ele.txtValue) == (typedList.get(0).pitAnalysis.ai.handSizeTopDeepest.value));
			};
					
	ElementValidationInterface prelimSizingVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitAnalysis.ai.preliminaryAdditionalSizingConsiderations.includeSizingByAttributes ? "True" : "False");
				
				return (typedList.get(0).pitAnalysis.ai.preliminaryAdditionalSizingConsiderations.includeSizingByAttributes == ele.bool);
			};
	ElementValidationInterface prelimTopWidestVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitAnalysis.ai.preliminaryAdditionalSizingConsiderations.sizingAttributeTopWidestInches.include ? "True" : "False")
						+ ", " + typedList.get(0).pitAnalysis.ai.preliminaryAdditionalSizingConsiderations.sizingAttributeTopWidestInches.value;
				
				return (typedList.get(0).pitAnalysis.ai.preliminaryAdditionalSizingConsiderations.sizingAttributeTopWidestInches.include == ele.bool)
						&& (Double.parseDouble(ele.txtValue) == (typedList.get(0).pitAnalysis.ai.preliminaryAdditionalSizingConsiderations.sizingAttributeTopWidestInches.value));
			};
	ElementValidationInterface prelimTopLongestVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitAnalysis.ai.preliminaryAdditionalSizingConsiderations.sizingAttributeTopLargestInches.include ? "True" : "False")
						+ ", " + typedList.get(0).pitAnalysis.ai.preliminaryAdditionalSizingConsiderations.sizingAttributeTopLargestInches.value;
				
				return (typedList.get(0).pitAnalysis.ai.preliminaryAdditionalSizingConsiderations.sizingAttributeTopLargestInches.include == ele.bool)
						&& (Double.parseDouble(ele.txtValue) == (typedList.get(0).pitAnalysis.ai.preliminaryAdditionalSizingConsiderations.sizingAttributeTopLargestInches.value));
			};
	ElementValidationInterface prelimTopNarrowestVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitAnalysis.ai.preliminaryAdditionalSizingConsiderations.sizingAttributeTopNarrowestInches.include ? "True" : "False")
						+ ", " + typedList.get(0).pitAnalysis.ai.preliminaryAdditionalSizingConsiderations.sizingAttributeTopNarrowestInches.value;
				
				return (typedList.get(0).pitAnalysis.ai.preliminaryAdditionalSizingConsiderations.sizingAttributeTopNarrowestInches.include == ele.bool)
						&& (Double.parseDouble(ele.txtValue) == (typedList.get(0).pitAnalysis.ai.preliminaryAdditionalSizingConsiderations.sizingAttributeTopNarrowestInches.value));
			};
	ElementValidationInterface prelimTopShortestVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitAnalysis.ai.preliminaryAdditionalSizingConsiderations.sizingAttributeTopShortestInches.include ? "True" : "False")
						+ ", " + typedList.get(0).pitAnalysis.ai.preliminaryAdditionalSizingConsiderations.sizingAttributeTopShortestInches.value;
				
				return (typedList.get(0).pitAnalysis.ai.preliminaryAdditionalSizingConsiderations.sizingAttributeTopShortestInches.include == ele.bool)
						&& (Double.parseDouble(ele.txtValue) == (typedList.get(0).pitAnalysis.ai.preliminaryAdditionalSizingConsiderations.sizingAttributeTopShortestInches.value));
			};
			
	ElementValidationInterface prelimMDSRunsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitAnalysis.ai.preliminaryAdditionalSizingConsiderations.includeMDSRunsToCheckSizingofTopPits ? "True" : "False");
				
				return (typedList.get(0).pitAnalysis.ai.preliminaryAdditionalSizingConsiderations.includeMDSRunsToCheckSizingofTopPits == ele.bool);
			};
					
			
	ElementValidationInterface finalRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"STANDARD", "SPECIAL"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).pitAnalysis.ai.finalAnalysisEnum.toString();
				
				return PitsEnums.AnalysisType.valueOf(ele.expectedValue).equals(typedList.get(0).pitAnalysis.ai.finalAnalysisEnum);
			};	
	ElementValidationInterface finalTotalTopNumVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitAnalysis.ai.whenTotalPits.include ? "True" : "False")
						+ ", " + typedList.get(0).pitAnalysis.ai.whenTotalPits.value;
				
				return (typedList.get(0).pitAnalysis.ai.whenTotalPits.include == ele.bool)
						&& (Integer.parseInt(ele.txtValue) == (typedList.get(0).pitAnalysis.ai.whenTotalPits.value));
			};
	ElementValidationInterface finalTotalTopSelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"EQUAL_TO", "NOT_EQUAL_TO", "LESS_THAN", "LESS_THAN_OR_EQUAL_TO", "GREATER_THAN", "GREATER_THAN_OR_EQUAL_TO"};
				
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).pitAnalysis.ai.whenTotalPits.include ? "True" : "False")
								+ ", " + typedList.get(0).pitAnalysis.ai.whenTotalPits.operatorEnum;
				
				return (typedList.get(0).pitAnalysis.ai.whenTotalPits.include == ele.bool)
						&& (CSREnums.OperatorType.valueOf(mapping[ele.dropDownIndex]).equals(typedList.get(0).pitAnalysis.ai.whenTotalPits.operatorEnum));
			};
	ElementValidationInterface finalTotalTopPercentVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
				= "" + typedList.get(0).pitAnalysis.ai.manualSizeTopDeepest;
				
				return (Integer.parseInt(ele.expectedValue) == (typedList.get(0).pitAnalysis.ai.manualSizeTopDeepest));
			};
		
	ElementValidationInterface finalTotalPitsNumVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitAnalysis.ai.whenTotesPits.include ? "True" : "False")
						+ ", " + typedList.get(0).pitAnalysis.ai.whenTotesPits.value;
				
				return (typedList.get(0).pitAnalysis.ai.whenTotesPits.include == ele.bool)
						&& (Integer.parseInt(ele.txtValue) == (typedList.get(0).pitAnalysis.ai.whenTotesPits.value));
			};
	ElementValidationInterface finalTotalPitsSelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"EQUAL_TO", "NOT_EQUAL_TO", "LESS_THAN", "LESS_THAN_OR_EQUAL_TO", "GREATER_THAN", "GREATER_THAN_OR_EQUAL_TO"};
				
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).pitAnalysis.ai.whenTotesPits.include ? "True" : "False")
								+ ", " + typedList.get(0).pitAnalysis.ai.whenTotesPits.operatorEnum.toString();
				
				return (typedList.get(0).pitAnalysis.ai.whenTotesPits.include == ele.bool)
						&& (CSREnums.OperatorType.valueOf(mapping[ele.dropDownIndex]).equals(typedList.get(0).pitAnalysis.ai.whenTotesPits.operatorEnum));
			};
	ElementValidationInterface finalTotalManualSelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"EQUAL_TO", "NOT_EQUAL_TO", "LESS_THAN", "LESS_THAN_OR_EQUAL_TO", "GREATER_THAN", "GREATER_THAN_OR_EQUAL_TO"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
				= typedList.get(0).pitAnalysis.ai.manualSizePits.operatorEnum.toString();
				
				return (CSREnums.OperatorType.valueOf(mapping[ele.dropDownIndex]).equals(typedList.get(0).pitAnalysis.ai.manualSizePits.operatorEnum));
			};	
	ElementValidationInterface finalTotalManualNumVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
				= "" + typedList.get(0).pitAnalysis.ai.manualSizePits.value;
				
				return (Integer.parseInt(ele.expectedValue) == (typedList.get(0).pitAnalysis.ai.manualSizePits.value));
			};	
			
			
	ElementValidationInterface finalPitAttrVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
				= (typedList.get(0).pitAnalysis.ai.finalAdditionalSizingConsiderations.includeSizingByAttributes ? "True" : "False");
				
				return (typedList.get(0).pitAnalysis.ai.finalAdditionalSizingConsiderations.includeSizingByAttributes == ele.bool);
			};
	ElementValidationInterface finalTopWidestVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitAnalysis.ai.finalAdditionalSizingConsiderations.sizingAttributeTopWidestInches.include ? "True" : "False")
						+ ", " + typedList.get(0).pitAnalysis.ai.finalAdditionalSizingConsiderations.sizingAttributeTopWidestInches.value;
				
				return (typedList.get(0).pitAnalysis.ai.finalAdditionalSizingConsiderations.sizingAttributeTopWidestInches.include == ele.bool)
						&& (Double.parseDouble(ele.txtValue) == (typedList.get(0).pitAnalysis.ai.finalAdditionalSizingConsiderations.sizingAttributeTopWidestInches.value));
			};
	ElementValidationInterface finalTopLongestVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitAnalysis.ai.finalAdditionalSizingConsiderations.sizingAttributeTopLargestInches.include ? "True" : "False")
						+ ", " + typedList.get(0).pitAnalysis.ai.finalAdditionalSizingConsiderations.sizingAttributeTopLargestInches.value;
				
				return (typedList.get(0).pitAnalysis.ai.finalAdditionalSizingConsiderations.sizingAttributeTopLargestInches.include == ele.bool)
						&& (Double.parseDouble(ele.txtValue) == (typedList.get(0).pitAnalysis.ai.finalAdditionalSizingConsiderations.sizingAttributeTopLargestInches.value));
			};
	ElementValidationInterface finalTopNarrowestVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitAnalysis.ai.finalAdditionalSizingConsiderations.sizingAttributeTopNarrowestInches.include ? "True" : "False")
						+ ", " + typedList.get(0).pitAnalysis.ai.finalAdditionalSizingConsiderations.sizingAttributeTopNarrowestInches.value;
				
				return (typedList.get(0).pitAnalysis.ai.finalAdditionalSizingConsiderations.sizingAttributeTopNarrowestInches.include == ele.bool)
						&& (Double.parseDouble(ele.txtValue) == (typedList.get(0).pitAnalysis.ai.finalAdditionalSizingConsiderations.sizingAttributeTopNarrowestInches.value));
			};
	ElementValidationInterface finalTopShortestVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitAnalysis.ai.finalAdditionalSizingConsiderations.sizingAttributeTopShortestInches.include ? "True" : "False")
						+ ", " + typedList.get(0).pitAnalysis.ai.finalAdditionalSizingConsiderations.sizingAttributeTopShortestInches.value;
				
				return (typedList.get(0).pitAnalysis.ai.finalAdditionalSizingConsiderations.sizingAttributeTopShortestInches.include == ele.bool)
						&& (Double.parseDouble(ele.txtValue) == (typedList.get(0).pitAnalysis.ai.finalAdditionalSizingConsiderations.sizingAttributeTopShortestInches.value));
			};
			
			
			
	ElementValidationInterface finalMDSVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitAnalysis.ai.finalAdditionalSizingConsiderations.includeMDSRunsToCheckSizingofTopPits ? "True" : "False");
				
				return (typedList.get(0).pitAnalysis.ai.finalAdditionalSizingConsiderations.includeMDSRunsToCheckSizingofTopPits == ele.bool);
			};
					
					
	@ParameterizedTest
	@ValueSource(strings = {"PitAnalysis_1.json", "PitAnalysis_2.json", "PitAnalysis_3.json", "PitAnalysis_4.json"})
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
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-metal_loss-pitanalysis&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
			
		elements.add(new CBElement(driver, notRepVal, "pitAnalysis_cb", argumentFile.defaultValues.includeCB));
		elements.add(new TextElement(driver, deviationsVal, "additionalNotes_ta", argumentFile.defaultValues.defaultTextValue));

		
		//This particular page contains two drop downs with nested elements.
		//To compensate for this, control flags are used with if statements.
		
		//Preliminary Analysis
		elements.add(new ClickExpansionPanel(driver, "preliminary_pa"));
		boolean prelimSpecialRequirements = ((Double) argumentFile.uniqueValues.get("primaryAnalysis_rg")).intValue() == 1 ? true : false;
		if(prelimSpecialRequirements)
		{
			elements.add(new RGElement(driver, prelimRGVal, "primaryAnalysis_rg", ((Double) argumentFile.uniqueValues.get("primaryAnalysis_rg")).intValue()));
			
			boolean pitCleanUp = argumentFile.defaultValues.defaultRGValues == 1 ? true : false;
			elements.add(new RGElement(driver, prelimDeepestRGVal, "displayAnalysis_rg", pitCleanUp ? 1 : 0));
			if(pitCleanUp)
			{
				elements.add(new IWVElement(driver, prelimDeepestDepthVal, "depthGreater_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
				elements.add(new IWVElement(driver, prelimDeepestTopVal, "topDeepest_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
				elements.add(new IWVElement(driver, prelimDeepestCleanUpVal, "cleanJoints_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			}
			
			
			boolean reviewHandSized = argumentFile.defaultValues.defaultRGValues == 1 ? true : false;
			elements.add(new RGElement(driver, prelimCleanedRGVal, "reviewHandSize_rg", reviewHandSized ? 1 : 0));
			if(reviewHandSized)
			{
				elements.add(new IWVElement(driver, prelimCleanedDepthVal, "handSizeGeq_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
				elements.add(new IWVElement(driver, prelimCleanedTopVal, "handSizeTopDeepest_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			}
			
			
			boolean sizingByPitAttributes = (Boolean) argumentFile.uniqueValues.get("includeAttributeSizing_cb");
			elements.add(new CBElement(driver, null, "includeAttributeSizing_cb", true)); //Protect Instancing in next segment
			elements.add(new CBElement(driver, prelimSizingVal, "includeAttributeSizing_cb", sizingByPitAttributes));
			if(sizingByPitAttributes)
			{
				elements.add(new IWVElement(driver, prelimTopWidestVal, "attributeSizingTopW_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
				elements.add(new IWVElement(driver, prelimTopLongestVal, "attributeSizingTopL_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
				elements.add(new IWVElement(driver, prelimTopNarrowestVal, "attributeSizingTopN_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
				elements.add(new IWVElement(driver, prelimTopShortestVal, "attributeSizingTopS_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			}
			
			elements.add(new CBElement(driver, prelimMDSRunsVal, "includeMDSRuns_cb", argumentFile.defaultValues.includeCB));
		}
		else
		{
			elements.add(new RGElement(driver, null, "primaryAnalysis_rg", 1)); //Protect instancing counters in next segment
			elements.add(new CBElement(driver, null, "includeAttributeSizing_cb", true)); //Protect Instancing in next segment
			elements.add(new CBElement(driver, null, "includeAttributeSizing_cb", false));
			
			elements.add(new RGElement(driver, prelimRGVal, "primaryAnalysis_rg", 0)); //Set to desired value
		}

		
		//Final Analysis
		elements.add(new ClickExpansionPanel(driver, "final_pa"));
		boolean finalSpecialRequirements = ((Double) argumentFile.uniqueValues.get("finalAnalysis_rg")).intValue() == 1 ? true : false;
		if(finalSpecialRequirements)
		{
			elements.add(new RGElement(driver, finalRGVal, "finalAnalysis_rg", finalSpecialRequirements ? 1 : 0));
			
			boolean manualSizeTop = argumentFile.defaultValues.includeIWVorIWVS;
			if(manualSizeTop)
			{
				elements.add(new IWVElement(driver, finalTotalTopNumVal, "displayFinalAnalysis_iwc", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
				elements.add(new TextElement(driver, finalTotalTopPercentVal, "displayFinalAnalysis_tf", Integer.toString(argumentFile.defaultValues.defaultIWVSValue)));
				elements.add(new IWVSElement(driver, finalTotalTopSelVal, "displayFinalAnalysis_iwc", argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.includeIWVorIWVS));
			}
			else
			{
				elements.add(new IWVElement(driver, finalTotalTopNumVal, "displayFinalAnalysis_iwc", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			}
			
			
			//Pieces of this need instancing
			boolean manualSizePits = argumentFile.defaultValues.includeIWVorIWVS;
			if(manualSizePits)
			{
				elements.add(new CBElement(driver, null, "displayFinalAnalysis_iwc", argumentFile.defaultValues.includeCB));
				elements.get(elements.size() - 1).setDesiredInstance(1);
				elements.add(new IWVSElement(driver, finalTotalPitsSelVal, "displayFinalAnalysis_iwc", argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.includeIWVorIWVS));
				elements.get(elements.size() - 1).setDesiredInstance(1);
				
				elements.add(new TextElement(driver, finalTotalManualNumVal, "displayFinalAnalysis_cv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue)));
				elements.add(new SelectElement(driver, finalTotalManualSelVal, "displayFinalAnalysis_cv", argumentFile.defaultValues.defaultSelectValue));
				
				elements.add(new IWVElement(driver, finalTotalPitsNumVal, "displayFinalAnalysis_iwc", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
				elements.get(elements.size() - 1).setDesiredInstance(1);
				
			}
			
			
			boolean sizingByPitAttributes = (Boolean) argumentFile.uniqueValues.get("displayFinalAnalysis_iwc");
			elements.add(new CBElement(driver, finalPitAttrVal, "includeAttributeSizing_cb", sizingByPitAttributes));
			elements.get(elements.size() - 1).setDesiredInstance(1);
			if(sizingByPitAttributes)
			{
				elements.add(new IWVElement(driver, finalTopWidestVal, "attributeSizingTopW_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
				elements.get(elements.size() - 1).setDesiredInstance(1);
				elements.add(new IWVElement(driver, finalTopLongestVal, "attributeSizingTopL_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
				elements.get(elements.size() - 1).setDesiredInstance(1);
				elements.add(new IWVElement(driver, finalTopNarrowestVal, "attributeSizingTopN_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
				elements.get(elements.size() - 1).setDesiredInstance(1);
				elements.add(new IWVElement(driver, finalTopShortestVal, "attributeSizingTopS_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
				elements.get(elements.size() - 1).setDesiredInstance(1);
			}
			
			elements.add(new CBElement(driver, finalMDSVal, "includeMDSRuns_cb", argumentFile.defaultValues.includeCB));
			elements.get(elements.size() - 1).setDesiredInstance(1);
		}
		else
		{
			elements.add(new RGElement(driver, finalRGVal, "finalAnalysis_rg", 0));
		}
		
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
		compTest.compaireDB(elements, "Pit Analysis", tables.METAL_LOSS, "PitAnalysisResults", argumentFile.FileCounter);
	}
}