package helperFunctions;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.io.FileUtils;


import runner.Setup;

public class ElementTools extends Setup {

	public void dropDownListSelect(WebElement e, String selectItem) {

		e.click();
		List<WebElement> children = e.findElements(By.xpath("//ListItem"));
		// System.out.println("Size " + children.size());
		for (WebElement child : children) {
			// System.out.println(child.getAttribute("Name"));
			if (child.getAttribute("Name").toString().equals(selectItem)) {
				child.click();
			}
		}

	}

	public void selectFormSection(String section) {
		AppSession.findElementByName(section).click();

	}

	public void setValueAndUnit(String sec, String len, String unit) {
		//System.out.println("test");
		WebElement section = AppSession.findElementByAccessibilityId(sec);
		WebElement lengthUnit = section.findElement(By.xpath("//*[@AutomationId='Unit_DD']"));
		setDropDownValue(lengthUnit, unit);

		section.findElement(By.xpath("//*[@AutomationId='AutoSelectTextBox']")).click();
		section.findElement(By.xpath("//*[@AutomationId='AutoSelectTextBox']")).sendKeys(len);
	}
	
	public void setDoubleUpDownValue(String s, String v) {
		WebElement section = AppSession.findElementByAccessibilityId(s);
		section.findElement(By.xpath("//*[@AutomationId='AutoSelectTextBox']")).click();
		section.findElement(By.xpath("//*[@AutomationId='AutoSelectTextBox']")).sendKeys(v);
	}
	
	

	public void setDropDownValue(WebElement e, String value) {
		Actions builder = new Actions(AppSession);
		Action action = builder.moveToElement(e, e.getSize().width - 10, e.getSize().height / 2).click().build();
		action.perform();
		
		e.sendKeys(value);		
		e.findElement(By.xpath("//*[@Name='" + value + "']")).click();
		System.out.print("test");
		
	}

	public void sendText(WebElement e, String text) {
		Actions builder = new Actions(AppSession);
		Action action = builder.moveToElement(e).doubleClick().sendKeys(text).build();
		action.perform();
	}

	public String convertToMeters(String baseUnit, String baseValue) {
		String convertedValue = null;
		// divide baseValue by 39.37 to get inches to meters
		if (baseUnit.equals("Inches")) {
			convertedValue = (Integer.parseInt(baseValue) / 39.37) + "";
			convertedValue = convertedValue.substring(0, 6);
			convertedValue = StringUtils.stripEnd(convertedValue, "0");
		} else if (baseUnit.equals("Millimeters")) {
			convertedValue = ((double) Integer.parseInt(baseValue) / 1000) + "";
		}

		// divide baseValue by 39.37 to get inches to meters

		// TODO Auto-generated method stub
		return convertedValue;
	}
	
	public void setDirection (String element, String direction) {
		if(direction.toUpperCase().equals("US")) {
			AppSession.findElementByAccessibilityId(element+"_Up").click();
		}
		if(direction.toUpperCase().equals("DS")) {
			AppSession.findElementByAccessibilityId(element+"_Down").click();
		}
	}

	public void takeScreenShot() {
		TakesScreenshot ts = (TakesScreenshot) AppSession;
		File source = ts.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File("c://temp//test.png");

		try {
			FileUtils.copyFile(source, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
