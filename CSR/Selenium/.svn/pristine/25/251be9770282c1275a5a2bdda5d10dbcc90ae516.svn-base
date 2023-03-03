package userFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helperFunctions.ElementTools;
import runner.Setup;

public class ProjectInformation_UF extends Setup {
	ElementTools elementTool = new ElementTools();
	
	public void setMobilizationDate(String MM, String DD, String YYYY) {
		WebElement mobizationDate_grp = AppSession.findElementByAccessibilityId("MobizationDate");
		WebElement month = mobizationDate_grp.findElement(By.name("Month_Tbx"));
		elementTool.sendText(month, MM);

		WebElement day = mobizationDate_grp.findElement(By.name("Day_Tbx"));
		elementTool.sendText(day, DD);

		WebElement year = mobizationDate_grp.findElement(By.name("Year_Tbx"));
		elementTool.sendText(year, YYYY);
	}
	
	public String getMobilizationDate() {
		WebElement mobizationDate_grp = AppSession.findElementByAccessibilityId("MobizationDate");
		WebElement month = mobizationDate_grp.findElement(By.name("Month_Tbx"));
		WebElement day = mobizationDate_grp.findElement(By.name("Day_Tbx"));
		WebElement year = mobizationDate_grp.findElement(By.name("Year_Tbx"));
		
		return month.getText() + day.getText() + year.getText();
	}
	
	public void setServiceCenter(String sc) {
		WebElement serviceCenter = AppSession.findElementByAccessibilityId("ServiceCenter");
		elementTool.setDropDownValue(serviceCenter, sc);
	}
	
	public void setClientContact(String cn, String cp) {
		WebElement ClientContactName_Txb = AppSession.findElementByAccessibilityId("Client_ContactName_Txb");
		elementTool.setDropDownValue(ClientContactName_Txb, cn);
		
		WebElement ClientPhone_Txb = AppSession.findElementByAccessibilityId("Client_Phone_Txb");
		elementTool.sendText(ClientPhone_Txb, cp);
	}
	public void setTrackingCompany(String tc, String tcn, String tp) {
		WebElement trackingCompany_Txb = AppSession.findElementByAccessibilityId("Tracking_Company_Txb");
		elementTool.setDropDownValue(trackingCompany_Txb, tc);
		
		WebElement trackingContactName_Txb = AppSession.findElementByAccessibilityId("Tracking_ContactName_Txb");
		elementTool.setDropDownValue(trackingContactName_Txb, tcn);
		
		WebElement trackingPhone_Txb = AppSession.findElementByAccessibilityId("Tracking_Phone_Txb");
		elementTool.sendText(trackingPhone_Txb, tp);
	}
	
	public void setTDWContact(String contact, String cn, String cp) {
		
		switch (contact) {
		  case "Project Manager":
			//Project Manager
				WebElement ProjectManager = AppSession.findElementByAccessibilityId("ProjectManager_DD");
				elementTool.setDropDownValue(ProjectManager, cn);
				WebElement ProjectManagerCell = AppSession.findElementByAccessibilityId("ProjectManagerCell_Tbx");
				elementTool.sendText(ProjectManagerCell, cp );
		    break;
		  case "INS Technician":
			//INS tech
				WebElement INS_Tech = AppSession.findElementByAccessibilityId("INSTechnician_DD");
				elementTool.setDropDownValue(INS_Tech, cn);
				WebElement INS_Tech_Cell = AppSession.findElementByAccessibilityId("INSTechnicianCell_Tbx");
				elementTool.sendText(INS_Tech_Cell, cp);
		    break;
		  case "Primary Tool Operator":
			//Primary Tool Operator
				WebElement PrimaryToolOperator = AppSession.findElementByAccessibilityId("PrimaryToolOperator_DD");
				elementTool.setDropDownValue(PrimaryToolOperator, cn);
				WebElement PrimaryToolOperatorCell = AppSession.findElementByAccessibilityId("PrimaryToolOperatorCell_Tbx");
				elementTool.sendText(PrimaryToolOperatorCell, cp);
		    break;
		  case "Builder":
			//Primary Tool Operator
				WebElement builder = AppSession.findElementByAccessibilityId("Builder_DD");
				elementTool.setDropDownValue(builder, cn);
				WebElement builderCell = AppSession.findElementByAccessibilityId("BuilderCell_Tbx");
				elementTool.sendText(builderCell, cp);
		    break;
		}
	}
	
	public void setSiteLocation(String location, String siteName, String city, String state, String country, String timeZone) {
		WebElement location_SiteName = AppSession.findElementByAccessibilityId(location+"_SiteName_Txb");
		elementTool.sendText(location_SiteName, siteName);
		
		WebElement location_City = AppSession.findElementByAccessibilityId(location+"_City_Txb");
		elementTool.sendText(location_City, city);
		
		WebElement location_State = AppSession.findElementByAccessibilityId(location+"_State_Txb");
		elementTool.sendText(location_State, state);
		
		WebElement location_Country = AppSession.findElementByAccessibilityId(location+"_Country_Txb");
		elementTool.sendText(location_Country, country);
		
		WebElement location_TimeZone = AppSession.findElementByAccessibilityId(location+"_TimeZone_Tbx");
		elementTool.sendText(location_TimeZone, timeZone);
	}
	
	public void setSiteAttributes(String location, String temp, String latitude, String longitude) {
		WebElement location_Temp = AppSession.findElementByAccessibilityId(location+"_Temperature_Tbx");
		elementTool.sendText(location_Temp, temp);
		
		//AutomationId	Launch_Latitude_Tbx

		WebElement location_Latitude = AppSession.findElementByAccessibilityId(location+"_Latitude_Tbx");
		elementTool.sendText(location_Latitude, latitude);
		
		//AutomationId	Launch_Longitude_Tbx

		WebElement location_Longitude = AppSession.findElementByAccessibilityId(location+"_Longitude_Tbx");
		elementTool.sendText(location_Longitude, longitude);
	}

}
