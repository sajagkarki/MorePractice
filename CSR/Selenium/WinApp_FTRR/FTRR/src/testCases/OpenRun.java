package testCases;

import org.openqa.selenium.WebElement;

import helperFunctions.ElementTools;
import runner.*;


public class OpenRun extends Setup {

	ElementTools et = new ElementTools();
	
	public OpenRun(){
		OpenRecentRun();
	}
		
	private void OpenRecentRun(){
		WebElement openDD = AppSession.findElementByAccessibilityId("Open_DD");
		openDD.click();
		AppSession.findElementByName("H10PUL01.fdb").click();
		try {
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
	
	private void OpenExistingRun() {
		WebElement openDD = AppSession.findElementByAccessibilityId("Open_Btn");
		openDD.click();
		AppSession.findElementByName("H10PUL01.fdb").click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
