package userFunctions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.sun.glass.events.KeyEvent;

import helperFunctions.ElementTools;
import helperFunctions.IMUMeasurements;
import helperFunctions.ToolComponent;
import helperFunctions.ToolMeasurements;
import helperFunctions.ToolOdometers;
import runner.Setup;

public class ToolInformation_UF extends Setup {
	ElementTools elementTool = new ElementTools();

	public void addToolComponent(ToolComponent c) {
		System.out.println("Working on Component :" + c.getPart());
		WebElement toolComponentList = AppSession.findElementByAccessibilityId("Components_list");
		List<WebElement> children = toolComponentList.findElements(By.xpath("//ComboBox"));
		List<WebElement> listItems = toolComponentList
				.findElements(By.xpath("//*[@Name='Logic.ViewModels.ToolInfo.FTComponent']"));
		WebElement targetListItem = null;
		boolean topMostVisibleListItemFound = false;
		boolean bottomMostVisibleListItemFound = false;
		boolean targetListItemFound = false;
		int topMostVisibleListItemID = 0;
		int bottomMostVisibleListItemID = 0;
		int targetListItemID = 0;
		int iterator = 0;
		for (WebElement child : children) {

			String IsOffscreen = listItems.get(iterator).getAttribute("IsOffscreen");
			System.out.print(IsOffscreen + " ");
			System.out.println(child.getAttribute("AutomationId"));

			if (topMostVisibleListItemFound == false && IsOffscreen.equals("False")) {
				topMostVisibleListItemFound = true;
				topMostVisibleListItemID = iterator;
			}

			if (bottomMostVisibleListItemFound == false && IsOffscreen.equals("True")
					&& topMostVisibleListItemFound == true) {
				bottomMostVisibleListItemFound = true;
				bottomMostVisibleListItemID = iterator - 1;
			} else if (bottomMostVisibleListItemFound == false) {
				bottomMostVisibleListItemID = iterator;
			}

			// List<WebElement> part = child.findElements(By.xpath("//ComboBox"));
			if (child.getAttribute("AutomationId").equals(c.getPart() + "_DD") && targetListItemFound == false) {
				targetListItem = listItems.get(iterator);
				targetListItemID = iterator;
				targetListItemFound = true;
			}
			iterator++;

			// if(targetListItem!=null)
			// System.out.println(targetListItem.getAttribute("IsOffscreen"));
			System.out.println("test");
		}

		Actions builder = new Actions(AppSession);
		System.out.println(targetListItem.getAttribute("IsOffscreen"));
		while (targetListItem.getAttribute("IsOffscreen").equals("True")) {

			if (targetListItemID > bottomMostVisibleListItemID) {
				System.out.println(targetListItem.getAttribute("IsOffscreen"));
				Action action = builder.moveToElement(toolComponentList, toolComponentList.getSize().width - 10,
						toolComponentList.getSize().height - 10).click().build();
				action.perform();
			}
			if (targetListItemID < topMostVisibleListItemID) {
				System.out.println(targetListItem.getAttribute("IsOffscreen"));
				Action action = builder.moveToElement(toolComponentList, toolComponentList.getSize().width - 10, 10)
						.click().build();
				action.perform();
			}

		}

		setComponent(c.getPart(), c.getSerialNum());

		if (c.getSensors().size() != 0) {
			for (int i = 0; i < c.getSensors().size(); i++) {
				addSensor(c.getSensors().get(i), i);
			}
		}

		if (c.getWyes().size() != 0) {
			for (int i = 0; i < c.getWyes().size(); i++) {
				addWyes(c.getWyes().get(i), i);
			}
		}

		if (c.getGauss() != null) {
			setGauss(c.getGauss());
		}

		if (c.getGaussOffset() != null) {
			setGaussOffset(c.getGaussOffset());
		}

		if (c.getMemoryRunTime() != null) {
			setMemoryRunTime(c.getMemoryRunTime());
		}

		if (c.getUCLocation() != null) {
			setUCLocation(c.getUCLocation());
		}

		if (c.getImages().size() != 0) {
			for (int i = 0; i < c.getImages().size(); i++) {
				addComponentImage(c.getImages().get(i));
			}
		}
	}

	
	public void setOdometers(ToolOdometers to) {
		
		displayFullSection("OdometersSection");
		elementTool.setDropDownValue(AppSession.findElementByAccessibilityId("ODOConfiguration_DD"), to.getOdoConfiguration());
		elementTool.setDropDownValue(AppSession.findElementByAccessibilityId("TireType_DD"), to.getTireType());
		
	}
	
	public void setMeasurements(ToolMeasurements tm) {
		displayFullSection("ToolMeasurementsSection");

		// set Tool Length
		if (tm.getToolLength().get("value") != null) {
			elementTool.setValueAndUnit("Tool Length", tm.getToolLength().get("value"), tm.getToolLength().get("unit"));

		}

		if(tm.getMeasuredDriveCupDiameter().get("value")!=null) {
			elementTool.setValueAndUnit("Measured Drive Cup Diameter", tm.getMeasuredDriveCupDiameter().get("value"), tm.getMeasuredDriveCupDiameter().get("unit"));
		}
		
		if(tm.getMeasuredSupportDiskDiameter().get("value")!=null) {
			elementTool.setValueAndUnit("Measured Support Disc Diameter", tm.getMeasuredSupportDiskDiameter().get("value"), tm.getMeasuredSupportDiskDiameter().get("unit"));
		}

		if(tm.getMeasuredDEFSupportCupDiameter().get("value")!=null) {
			elementTool.setValueAndUnit("Measured DEF Support Cup Diameter of OD or WSC (opposing wheels)", tm.getMeasuredDEFSupportCupDiameter().get("value"), tm.getMeasuredDEFSupportCupDiameter().get("unit"));
		}
		
		if(tm.getMeasuredXYZSupportCupDiameter().get("value")!=null) {
			elementTool.setValueAndUnit("Measured XYZ Support Cup Diameter of OD or WSC (opposing wheels)", tm.getMeasuredXYZSupportCupDiameter().get("value"), tm.getMeasuredXYZSupportCupDiameter().get("unit"));
		}

		if(tm.getMeasuredODofMFLBrush().get("value")!=null) {
			elementTool.setValueAndUnit("Measured OD of MFL brush", tm.getMeasuredODofMFLBrush().get("value"), tm.getMeasuredODofMFLBrush().get("unit"));
		}

		if(tm.getMeasuredODofSpirALLBrush().get("value")!=null) {
			elementTool.setValueAndUnit("Measured OD of SpirALL® MFL brush", tm.getMeasuredODofSpirALLBrush().get("value"), tm.getMeasuredODofSpirALLBrush().get("unit"));
		}
		
	}
	
	public void setIMUMeasurements(IMUMeasurements imu) {
		displayFullSection("IMUMeasurementsSection");

		if (imu.getMFLSensorsToCenterOfIMU().get("value") != null) {
			elementTool.setValueAndUnit("MFL Sensors to Center of IMU_Length", imu.getMFLSensorsToCenterOfIMU().get("value"), imu.getMFLSensorsToCenterOfIMU().get("unit"));
			elementTool.setDirection("MFL Sensors to Center of IMU", imu.getMFLSensorsToCenterOfIMU().get("direction"));
		}

		if (imu.getDEFSensorsToCenterOfIMU().get("value") != null) {
			elementTool.setValueAndUnit("DEF Sensors to Center of IMU_Length", imu.getDEFSensorsToCenterOfIMU().get("value"), imu.getDEFSensorsToCenterOfIMU().get("unit"));
			elementTool.setDirection("DEF Sensors to Center of IMU", imu.getDEFSensorsToCenterOfIMU().get("direction"));
		}
		
		if (imu.getDEFSensorsToCenterOfTransmitter().get("value") != null) {
			elementTool.setValueAndUnit("DEF Sensors to Center of Transmitter_Length", imu.getDEFSensorsToCenterOfTransmitter().get("value"), imu.getDEFSensorsToCenterOfTransmitter().get("unit"));
			elementTool.setDirection("DEF Sensors to Center of Transmitter", imu.getDEFSensorsToCenterOfTransmitter().get("direction"));
		}

		if (imu.getCenterOfTransmiterToCenterOfIMU().get("value") != null) {
			elementTool.setValueAndUnit("Center of Transmitter to Center of IMU_Length", imu.getCenterOfTransmiterToCenterOfIMU().get("value"), imu.getCenterOfTransmiterToCenterOfIMU().get("unit"));
			//elementTool.setDirection("DEF Sensors to Center of Transmitter", imu.getDEFSensorsToCenterOfTransmitter().get("direction"));
		}
		
		if (imu.getPushSurfaceToCenterOfIMU().get("value") != null) {
			elementTool.setValueAndUnit("Push Surface to Center of IMU_Length", imu.getPushSurfaceToCenterOfIMU().get("value"), imu.getPushSurfaceToCenterOfIMU().get("unit"));
			//elementTool.setDirection("DEF Sensors to Center of Transmitter", imu.getDEFSensorsToCenterOfTransmitter().get("direction"));
		}

		if (imu.getFrontOfILIToolToCenterOfIMU().get("value") != null) {
			elementTool.setValueAndUnit("Front of ILI Tool to Center of IMU_Length", imu.getFrontOfILIToolToCenterOfIMU().get("value"), imu.getFrontOfILIToolToCenterOfIMU().get("unit"));
			//elementTool.setDirection("DEF Sensors to Center of Transmitter", imu.getDEFSensorsToCenterOfTransmitter().get("direction"));
		}

		if (imu.getRearOfILIToolToCenterOfIMU().get("value") != null) {
			elementTool.setValueAndUnit("Rear of ILI Tool to Center of IMU_Length", imu.getRearOfILIToolToCenterOfIMU().get("value"), imu.getRearOfILIToolToCenterOfIMU().get("unit"));
			elementTool.setDirection("Rear of ILI Tool to Center of IMU", imu.getRearOfILIToolToCenterOfIMU().get("direction"));
		}
	
	}

	private void displayFullSection(String s) {

		System.out.println("test");
		WebElement section = AppSession.findElementByClassName(s);
		int y = section.getLocation().y;
		int height = section.getSize().height;
		Dimension windowDimension = AppSession.manage().window().getSize();
		Actions builder = new Actions(AppSession);
		if (y < 100) {
			builder.moveToElement(AppSession.findElementByAccessibilityId("DecreaseRepeat")).clickAndHold().build()
					.perform();
			while (y < 100) {
				y = section.getLocation().y;
			}
			builder.release().build().perform();

		}

		System.out.println(y);

		if (y + height > windowDimension.height) {
			builder.moveToElement(AppSession.findElementByAccessibilityId("IncreaseRepeat")).clickAndHold().build()
					.perform();

			while (y + height > windowDimension.height) {
				y = section.getLocation().y;
				height = section.getSize().height;
			}
			builder.release().build().perform();
		}

		// r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

		//System.out.println("test");

	}
	
	private void setComponent(String c, String serialNum) {
		WebElement component = AppSession.findElementByAccessibilityId(c + "_DD");
		System.out.println();
		System.out.println(component.getAttribute("Class"));
		elementTool.setDropDownValue(component, serialNum);
		// System.out.println("Test");
	}

	private void addSensor(String s, int count) {
		// hit add button
		AppSession.findElementByAccessibilityId("AddSensor_Btn").click();
		WebElement sensorSection = AppSession.findElementByAccessibilityId("Sensors");
		WebElement sensor = sensorSection.findElement(By.xpath("//*[@AutomationId='Sensor_DD_" + count + "']"));
		// WebElement sensor = AppSession.switchTo().activeElement();
		elementTool.setDropDownValue(sensor, s);
	}

	private void addWyes(String s, int count) {
		// hit add button
		AppSession.findElementByAccessibilityId("AddWyes_Btn").click();
		WebElement wyesSection = AppSession.findElementByAccessibilityId("Wyes");
		WebElement wyes = wyesSection.findElement(By.xpath("//*[@AutomationId='Sensor_DD_" + count + "']"));
		elementTool.setDropDownValue(wyes, s);
		// System.out.print("test");
	}

	private void setGauss(String g) {
		WebElement gauss = AppSession.findElementByAccessibilityId("Gauss_DD");
		elementTool.setDropDownValue(gauss, g);
	}

	private void setGaussOffset(String go) {
		WebElement gaussOffset = AppSession.findElementByAccessibilityId("GaussOffset_DD");
		elementTool.setDropDownValue(gaussOffset, go);
	}

	private void setMemoryRunTime(String mrt) {
		elementTool.setDoubleUpDownValue("CPUSection", mrt);
	}

	private void setUCLocation(String transmitterConfigSampleRate) {
		AppSession.findElementByAccessibilityId("ImportFromUC_Btn").click();
		AppSession.switchTo().activeElement().sendKeys(transmitterConfigSampleRate + Keys.RETURN);
		AppSession.switchTo().activeElement().sendKeys("321" + Keys.RETURN);
		// WebElement memoryWindow =
		// AppSession.findElement(By.xpath("//*[@AutomationId='popup_window']"));
		// WebElement memoryTextbox =
		// memoryWindow.findElement(By.xpath("//*[@AutomationId='textInput_Txb']"));
		// elementTool.sendText(memoryTextbox, "123");
		System.out.print(false);
	}

	private void addComponentImage(String i) {
		WebElement image_section = AppSession.findElementByAccessibilityId("ComponentImage");
		image_section.findElement(By.xpath("//*[@AutomationId='AddImage_Btn']")).click();

		AppSession.switchTo().activeElement().sendKeys(imageLocation + i + Keys.RETURN);

	}

}
