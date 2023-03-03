package testCases;

import org.openqa.selenium.WebElement;

import helperFunctions.ElementTools;
import runner.*;


public class CloseRun extends Setup {

	ElementTools et = new ElementTools();
	
	public CloseRun(){
		CloseCurrentRun();
	}
		
	private void CloseCurrentRun(){
		AppSession.closeApp();
		
		try {
			Thread.sleep(8000);
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
