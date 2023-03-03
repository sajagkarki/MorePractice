package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.miscellaneous.Miscellaneous;
import com.tdw.csr.entity.reporting_data_sheet.*;

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

public class ReportingDataSheetCDTest extends BaseCDTest {
			
	ElementValidationInterface customerNameVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).customerInfo.customerName;
				
				return ele.txtValue.equals(typedList.get(0).customerInfo.customerName);
			};
	ElementValidationInterface englishCustomerVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).customerInfo.englishCustomerName;
				
				return ele.txtValue.equals(typedList.get(0).customerInfo.englishCustomerName);
			};
	ElementValidationInterface custCodeVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).customerInfo.customerCode;
				
				return ele.txtValue.equals(typedList.get(0).customerInfo.customerCode);
			};
	ElementValidationInterface custContactVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).customerInfo.customerContact;
				
				return ele.txtValue.equals(typedList.get(0).customerInfo.customerContact);
			};
	ElementValidationInterface custContactEmailVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).customerInfo.customerContactEmail;
				
				return ele.txtValue.equals(typedList.get(0).customerInfo.customerContactEmail);
			};
	ElementValidationInterface custContactOfficeVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).customerInfo.customerContactOfficePhone;
				
				return ele.txtValue.equals(typedList.get(0).customerInfo.customerContactOfficePhone);
			};
	ElementValidationInterface custContactMobileVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).customerInfo.customerContactMobile;
				
				return ele.txtValue.equals(typedList.get(0).customerInfo.customerContactMobile);
			};
	ElementValidationInterface alternateCustVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).customerInfo.alternateCustomerContact;
				
				return ele.txtValue.equals(typedList.get(0).customerInfo.alternateCustomerContact);
			};
	ElementValidationInterface TDWCustRepVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).customerInfo.tdwCustomerRep;
				
				return ele.txtValue.equals(typedList.get(0).customerInfo.tdwCustomerRep);
			};
	ElementValidationInterface TDWProjVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).customerInfo.tdwProjectManager;
				
				return ele.txtValue.equals(typedList.get(0).customerInfo.tdwProjectManager);
			};
	ElementValidationInterface TDWProjContactVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).customerInfo.tdwProjectManagerContact;
				
				return ele.txtValue.equals(typedList.get(0).customerInfo.tdwProjectManagerContact);
			};
	ElementValidationInterface turnaroundVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).customerInfo.contractualTurnAroundTimes;
				
				return ele.txtValue.equals(typedList.get(0).customerInfo.contractualTurnAroundTimes);
			};
	ElementValidationInterface generalNotesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).customerInfo.generalNotes;
				
				return ele.txtValue.equals(typedList.get(0).customerInfo.generalNotes);
			};
			
			
	ElementValidationInterface nameOnRepVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.nameOnReport;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.nameOnReport);
			};
	ElementValidationInterface languageVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.language;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.language);
			};
			
			
	ElementValidationInterface deliveryMethodVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.prelimReport.deliveryMethod;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.prelimReport.deliveryMethod);
			};
	ElementValidationInterface DEFRepVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.prelimReport.defRportableContent;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.prelimReport.defRportableContent);
			};
	ElementValidationInterface MFLRepVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.prelimReport.mflReportableContent;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.prelimReport.mflReportableContent);
			};
	ElementValidationInterface SMFLRepVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.prelimReport.smflReportableContent;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.prelimReport.smflReportableContent);
			};
	ElementValidationInterface XYZDetailsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.prelimReport.xyzDetails;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.prelimReport.xyzDetails);
			};
			
			
	ElementValidationInterface deliveryMethod2Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.finalReport.deliveryMethod;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.finalReport.deliveryMethod);
			};
	ElementValidationInterface DEFRep2Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.finalReport.defRportableContent;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.finalReport.defRportableContent);
			};
	ElementValidationInterface MFLRep2Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.finalReport.mflReportableContent;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.finalReport.mflReportableContent);
			};
	ElementValidationInterface SMFLRep2Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.finalReport.smflReportableContent;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.finalReport.smflReportableContent);
			};
	ElementValidationInterface XYZDetails2Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.finalReport.xyzDetails;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.finalReport.xyzDetails);
			};
			
			
	ElementValidationInterface dentPrioritizationVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.additionalReports.dentPrioritization;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.additionalReports.dentPrioritization);
			};
	ElementValidationInterface hardspotsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.additionalReports.hardSpots;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.additionalReports.hardSpots);
			};
	ElementValidationInterface PJCVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.additionalReports.pjc;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.additionalReports.pjc);
			};
	ElementValidationInterface SSWCVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.additionalReports.sswc;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.additionalReports.sswc);
			};
	ElementValidationInterface dentStrainVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.additionalReports.dentStrain;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.additionalReports.dentStrain);
			};
	ElementValidationInterface bendStrainVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.additionalReports.bendStrain;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.additionalReports.bendStrain);
			};
	ElementValidationInterface wrinkleBendVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.additionalReports.wrinkleBend;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.additionalReports.wrinkleBend);
			};
	ElementValidationInterface runCompVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.additionalReports.runComparison;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.additionalReports.runComparison);
			};
			
			
	ElementValidationInterface bindersVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.firstContact.numberOfBinders;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.firstContact.numberOfBinders);
			};
	ElementValidationInterface digitalVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.firstContact.numberOfDigital;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.firstContact.numberOfDigital);
			};
	ElementValidationInterface contactVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.firstContact.customerContact;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.firstContact.customerContact);
			};
	ElementValidationInterface addressVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.firstContact.deliveryAddress;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.firstContact.deliveryAddress);
			};
	ElementValidationInterface emailVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.firstContact.emailAddress;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.firstContact.emailAddress);
			};
	ElementValidationInterface phoneVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.firstContact.phoneNumber;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.firstContact.phoneNumber);
			};
	ElementValidationInterface phoneTypeVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				String[] mapping = {"Office", "Mobile", "Personal"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.firstContact.numberType;
				
				return ele.expectedValue.equals(typedList.get(0).reportingInfo.firstContact.numberType);
			};
			
			
	ElementValidationInterface binders2Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.secondContact.numberOfBinders;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.secondContact.numberOfBinders);
			};
	ElementValidationInterface digital2Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.secondContact.numberOfDigital;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.secondContact.numberOfDigital);
			};
	ElementValidationInterface contact2Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.secondContact.customerContact;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.secondContact.customerContact);
			};
	ElementValidationInterface address2Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.secondContact.deliveryAddress;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.secondContact.deliveryAddress);
			};
	ElementValidationInterface email2Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.secondContact.emailAddress;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.secondContact.emailAddress);
			};
	ElementValidationInterface phone2Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.secondContact.phoneNumber;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.secondContact.phoneNumber);
			};
	ElementValidationInterface phoneType2Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				String[] mapping = {"Office", "Mobile", "Personal"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.secondContact.numberType;
				
				return ele.expectedValue.equals(typedList.get(0).reportingInfo.secondContact.numberType);
			};
			
			
	ElementValidationInterface binders3Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.thirdContact.numberOfBinders;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.thirdContact.numberOfBinders);
			};
	ElementValidationInterface digital3Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.thirdContact.numberOfDigital;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.thirdContact.numberOfDigital);
			};
	ElementValidationInterface contact3Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.thirdContact.customerContact;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.thirdContact.customerContact);
			};
	ElementValidationInterface address3Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.thirdContact.deliveryAddress;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.thirdContact.deliveryAddress);
			};
	ElementValidationInterface email3Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.thirdContact.emailAddress;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.thirdContact.emailAddress);
			};
	ElementValidationInterface phone3Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.thirdContact.phoneNumber;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.thirdContact.phoneNumber);
			};
	ElementValidationInterface phoneType3Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				String[] mapping = {"Office", "Mobile", "Personal"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.thirdContact.numberType;
				
				return ele.expectedValue.equals(typedList.get(0).reportingInfo.thirdContact.numberType);
			};
			
			
	ElementValidationInterface specialVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<ReportingDataSheet> typedList = (List<ReportingDataSheet>) list;
				
				ele.returnedValues 
						= typedList.get(0).reportingInfo.specialConsiderations;
				
				return ele.txtValue.equals(typedList.get(0).reportingInfo.specialConsiderations);
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
	
	
	@ParameterizedTest
	@ValueSource(strings = {"ReportingDataSheet_1.json", "ReportingDataSheet_2.json"})
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
		
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-rds&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
			
		
		//Open all panels
		elements.add(new ClickExpansionPanel(driver, "customerInfo_gr"));
		elements.add(new ClickExpansionPanel(driver, "reportingInfo_gr"));
		elements.add(new ClickExpansionPanel(driver, "prelimReport_rrc"));
		elements.add(new ClickExpansionPanel(driver, "finalReport_rrc"));
		elements.add(new ClickExpansionPanel(driver, "additionalReports_aac"));
		elements.add(new ClickExpansionPanel(driver, "firstContact_rerc"));
		elements.add(new ClickExpansionPanel(driver, "secondContact_rerc"));
		elements.add(new ClickExpansionPanel(driver, "thirdContact_rerc"));
		
		
		elements.add(new TextElement(driver, customerNameVal, "customerName_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, englishCustomerVal, "endCustomerName_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, custCodeVal, "customerCode_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, custContactVal, "customerContact_tf", argumentFile.defaultValues.defaultTextValue));
		elements.get(elements.size() - 1).setDesiredInstance(0);
		elements.add(new TextElement(driver, custContactEmailVal, "customerContactEmail_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, custContactOfficeVal, "customerContactOfficePhone_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, custContactMobileVal, "customerContactMobile_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, alternateCustVal, "alternateCustomerContact_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, TDWCustRepVal, "tdwCustomerRep_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, TDWProjVal, "tdwProjectManager_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, TDWProjContactVal, "tdwProjectManagerContact_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, turnaroundVal, "contractualTurnAroundTimes_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, generalNotesVal, "generalNotes_ta", argumentFile.defaultValues.defaultTextValue));
		
		
		elements.add(new TextElement(driver, nameOnRepVal, "nameOnReport_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, languageVal, "language_tf", argumentFile.defaultValues.defaultTextValue));
		
		elements.add(new TextElement(driver, deliveryMethodVal, "deliveryMethod_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, DEFRepVal, "defRportableContent_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, MFLRepVal, "mflReportableContent_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, SMFLRepVal, "smflReportableContent_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, XYZDetailsVal, "xyzDetails_tf", argumentFile.defaultValues.defaultTextValue));
		
		elements.add(new TextElement(driver, deliveryMethod2Val, "deliveryMethod_tf", argumentFile.defaultValues.defaultTextValue));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new TextElement(driver, DEFRep2Val, "defRportableContent_tf", argumentFile.defaultValues.defaultTextValue));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new TextElement(driver, MFLRep2Val, "mflReportableContent_tf", argumentFile.defaultValues.defaultTextValue));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new TextElement(driver, SMFLRep2Val, "smflReportableContent_tf", argumentFile.defaultValues.defaultTextValue));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new TextElement(driver, XYZDetails2Val, "xyzDetails_tf", argumentFile.defaultValues.defaultTextValue));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		
		elements.add(new TextElement(driver, dentPrioritizationVal, "dentPrioritization_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, hardspotsVal, "hardSpots_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, PJCVal, "pjc_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, SSWCVal, "sswc_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, dentStrainVal, "dentStrain_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, bendStrainVal, "bendStrain_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, wrinkleBendVal, "wrinkleBend_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, runCompVal, "runComparison_tf", argumentFile.defaultValues.defaultTextValue));
		
		elements.add(new TextElement(driver, bindersVal, "numberOfBinders_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, digitalVal, "numberOfDigital_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, contactVal, "customerContact_tf", argumentFile.defaultValues.defaultTextValue));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new TextElement(driver, addressVal, "deliveryAddress_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, emailVal, "emailAddress_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, phoneVal, "phoneNumber_tf", argumentFile.defaultValues.defaultTextValue));
		elements.add(new SelectElement(driver, phoneTypeVal, "numberType_s", argumentFile.defaultValues.defaultSelectValue));
		
		elements.add(new TextElement(driver, binders2Val, "numberOfBinders_tf", argumentFile.defaultValues.defaultTextValue));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new TextElement(driver, digital2Val, "numberOfDigital_tf", argumentFile.defaultValues.defaultTextValue));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new TextElement(driver, contact2Val, "customerContact_tf", argumentFile.defaultValues.defaultTextValue));
		elements.get(elements.size() - 1).setDesiredInstance(2);
		elements.add(new TextElement(driver, address2Val, "deliveryAddress_tf", argumentFile.defaultValues.defaultTextValue));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new TextElement(driver, email2Val, "emailAddress_tf", argumentFile.defaultValues.defaultTextValue));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new TextElement(driver, phone2Val, "phoneNumber_tf", argumentFile.defaultValues.defaultTextValue));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new SelectElement(driver, phoneType2Val, "numberType_s", argumentFile.defaultValues.defaultSelectValue));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		
		elements.add(new TextElement(driver, binders3Val, "numberOfBinders_tf", argumentFile.defaultValues.defaultTextValue));
		elements.get(elements.size() - 1).setDesiredInstance(2);
		elements.add(new TextElement(driver, digital3Val, "numberOfDigital_tf", argumentFile.defaultValues.defaultTextValue));
		elements.get(elements.size() - 1).setDesiredInstance(2);
		elements.add(new TextElement(driver, contact3Val, "customerContact_tf", argumentFile.defaultValues.defaultTextValue));
		elements.get(elements.size() - 1).setDesiredInstance(3);
		elements.add(new TextElement(driver, address3Val, "deliveryAddress_tf", argumentFile.defaultValues.defaultTextValue));
		elements.get(elements.size() - 1).setDesiredInstance(2);
		elements.add(new TextElement(driver, email3Val, "emailAddress_tf", argumentFile.defaultValues.defaultTextValue));
		elements.get(elements.size() - 1).setDesiredInstance(2);
		elements.add(new TextElement(driver, phone3Val, "phoneNumber_tf", argumentFile.defaultValues.defaultTextValue));
		elements.get(elements.size() - 1).setDesiredInstance(2);
		elements.add(new SelectElement(driver, phoneType3Val, "numberType_s", argumentFile.defaultValues.defaultSelectValue));
		elements.get(elements.size() - 1).setDesiredInstance(2);
		
		elements.add(new TextElement(driver, specialVal, "specialConsiderations_ta", argumentFile.defaultValues.defaultTextValue));
		
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
		compTest.compaireDB(elements, "Reporting Data Sheet", tables.REPORTING_DATA_SHEET, "ReportingDataSheetResults", argumentFile.FileCounter);
	}
}