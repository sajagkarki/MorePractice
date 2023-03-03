package testCases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import runner.*;
import userFunctions.ProjectInformation_UF;
import helperFunctions.*;

public class ProjectInformation extends Setup {

	ElementTools elementTool = new ElementTools();
	ProjectInformation_UF userFunction = new ProjectInformation_UF();

	public void openExpander() {
		String expander = AppSession.findElementByAccessibilityId("Project Information_Expander").getAttribute("ItemStatus");
		if(expander.equals("False"))
			AppSession.findElementByAccessibilityId("Project Information_Expander").click();
	}
	
	public void setSectionVisible() {
		elementTool.selectFormSection("Project Information");
	}

	public void JobInformation() {
		userFunction.setMobilizationDate("06", "25", "2003");
		userFunction.setServiceCenter("Salt Lake City, UT");
	}
	
	public boolean validateJobInformation() {
		return userFunction.getMobilizationDate().equals("06" + "25" + "2003");
	}

	public void Contacts() {

		userFunction.setClientContact("Dave Floyd","918-640-3680");
		userFunction.setTrackingCompany("CHEROKEE PIPELINE SERVICES/ENTERPRISES","Dean Moody","123-456-7890");
		
	}

	public void TDWContacts() {
		userFunction.setTDWContact("Project Manager", "Waid Blanton", "801-555-1234");
		userFunction.setTDWContact("INS Technician", "Will Rath", "801-555-4321");
		userFunction.setTDWContact( "Primary Tool Operator","Angelica Sparano","801-555-9876");
		userFunction.setTDWContact( "Builder","Andy Lee Poy","801-555-6789");
		
	}

	public void LaunchSiteInformation() {
		userFunction.setSiteLocation("Launch", "Cushing", "Cushing", "OK", "USA", "-4");
		userFunction.setSiteAttributes("Launch", "100", "38", "-105");
		
	}
	
	public void ReceiveSiteInformation() {
		userFunction.setSiteLocation("Receive", "Payson", "Payson", "OK", "USA", "-4");
		userFunction.setSiteAttributes("Receive", "110", "39.742373", "-104.995519");
	
	}
	
	

	public void PipeSectionDetails() {
		//set client Length
		elementTool.setValueAndUnit("Client_Length", "5", "Kilometers");
		

		//mm test
		String pipeSizeUnit = "Millimeters";
		String pipeSize = "300";
		
		
		// AutomationId PipeSizeValue_DD
		// set the unit value First, so that the value drop down will change to the
		// correct values
		WebElement PipeSizeUnit_e = AppSession.findElementByAccessibilityId("PipeSizeUnit_DD");
		elementTool.setDropDownValue(PipeSizeUnit_e, pipeSizeUnit);

		
		WebElement PipeSizeValue=null;
		if(pipeSizeUnit.equals("Inches")) {
			PipeSizeValue = AppSession.findElementByAccessibilityId("IN_PipeSizeValue_DD");
		}else if(pipeSizeUnit.equals("Millimeters") ) {
			PipeSizeValue = AppSession.findElementByAccessibilityId("MM_PipeSizeValue_DD");
		}
		
		String meterValue = elementTool.convertToMeters(pipeSizeUnit, pipeSize);
		elementTool.setDropDownValue(PipeSizeValue, meterValue);
		
		//set Section Length
		elementTool.setValueAndUnit("SegmentLength", "5", "Kilometers");
		

		elementTool.setValueAndUnit("MinWall", ".5", "Inches");
		elementTool.setValueAndUnit("MaxWall", ".3", "Inches");
		
		
		WebElement minBend = AppSession.findElementByAccessibilityId("MinBend");
		elementTool.setDropDownValue(minBend, "1.5D");

	}

	public void PipelineProduct() {
		
		//Pipeline Product
		WebElement product = AppSession.findElementByAccessibilityId("PipelineProduct_DD");
		elementTool.setDropDownValue(product, "CO2");
		
		//Pipeline property
		WebElement property = AppSession.findElementByAccessibilityId("PipelineProperty_DD");
		elementTool.setDropDownValue(property, "Liquid");
		
		//Pipeline Line Pressure
		elementTool.setValueAndUnit("PipelinePressure", "5", "BAR");
		
		//Pipeline Liquid Flow rate
		elementTool.setValueAndUnit("PipelineLiquieFlowRate", "5", "cm_3");
		WebElement flowRate = AppSession.findElementByAccessibilityId("PipelineLiquieFlowRate");
		WebElement flowRate_DD = flowRate.findElement(By.xpath("//*[@AutomationId='Rate_DD']"));	
		elementTool.setDropDownValue(flowRate_DD, "per_minute");
		
		//Calculated Velocity
		WebElement calulatedVelocity = AppSession.findElementByAccessibilityId("CalulatedVelocity");
		WebElement lengthUnit_DD = calulatedVelocity.findElement(By.xpath("//*[@AutomationId='LengthUnit_DD']"));
		WebElement timeUnit_DD = calulatedVelocity.findElement(By.xpath("//*[@AutomationId='TimeUnit_DD']"));
		
		//Pipeline Temperature
		WebElement pipelineTemperature = AppSession.findElementByAccessibilityId("PipelineTemperature");
		elementTool.sendText(pipelineTemperature, "100");
		
		//Pipeline calculated Velocity
		elementTool.setDropDownValue(lengthUnit_DD, "Miles");
		elementTool.setDropDownValue(timeUnit_DD, "per_minute");
	}

}
