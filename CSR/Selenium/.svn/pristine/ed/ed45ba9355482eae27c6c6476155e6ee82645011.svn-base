package testCases;

import org.openqa.selenium.WebElement;

import helperFunctions.ElementTools;
import runner.*;

public class NewRun extends Setup  {

	ElementTools elementTool = new ElementTools();
	
	public void createNewRun() {	
		AppSession.findElementByAccessibilityId("NewDB_Btn").click();
		AppSession.findElementByAccessibilityId("LocalDB_Btn").click();
		
		System.out.println("blah");
		
		try {
			Thread.sleep(2000);
			elementTool.setDropDownValue(AppSession.findElementByAccessibilityId("JobNumber_DD"), "180346");
			Thread.sleep(3000);
			AppSession.findElementByAccessibilityId("CreateDB_Btn").click();
			Thread.sleep(2000);
			if (AppSession.findElementByName("Overwrite existing folder?").isDisplayed()) {
				AppSession.findElementByAccessibilityId("Yes_Btn").click();
			}
			Thread.sleep(2000);
			int timerCount =0;
			while(AppSession.findElementByAccessibilityId("SetupCaption").isDisplayed()) {
				Thread.sleep(1000);
				timerCount++;
				if(timerCount ==20)
					break;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
