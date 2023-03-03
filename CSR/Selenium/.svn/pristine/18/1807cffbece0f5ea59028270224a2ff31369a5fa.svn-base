package userFunctions;

import org.openqa.selenium.WebElement;

import runner.*;


public class OpenRun_UF extends Setup {


	
	public OpenRun_UF(){
		OpenRecentRun();
	}
	
	private void OpenRecentRun(){
		WebElement openDD = AppSession.findElementByAccessibilityId("OpenFile_DD");
		openDD.click();
		AppSession.findElementByName("H10PUL01.fdb").click();
	}
	
	private void OpenExistingRun() {
		WebElement openDD = AppSession.findElementByAccessibilityId("OpenFile_Btn");
		openDD.click();
		AppSession.findElementByName("H10PUL01.fdb").click();
	}
}
