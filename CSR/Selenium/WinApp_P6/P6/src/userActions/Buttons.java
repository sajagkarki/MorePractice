package userActions;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import runner.*;

public class Buttons extends Setup {

	public Buttons() {
		// TODO Auto-generated constructor stub
	}
	public void jumpToDistance(String d) {
		AppSession.findElementByName("JumpToDistance_Btn").click();
		AppSession.findElementByName("Distance: Alt+D").sendKeys(d);
		AppSession.findElementByName("OK Enter").click();
	}
	public void setViewWidth (double w) {
		WebElement e = AppSession.findElementByName("ViewWidth_tb");
		Actions actions = new Actions(AppSession);
		actions.moveToElement(e,2,2).click();
		actions.perform();
		for(int i =0;i<10;i++) {
			actions.sendKeys(Keys.DELETE);
			actions.perform();
		}
		actions.sendKeys(w+"");
		actions.sendKeys(Keys.ENTER);
		actions.perform();
		
		//AppSession.findElementByName("ViewWidth_tb").sendKeys(w+"");
	}
	

	
}
