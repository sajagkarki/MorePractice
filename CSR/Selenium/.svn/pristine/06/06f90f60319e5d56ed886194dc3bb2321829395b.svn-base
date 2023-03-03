package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import runner.*;
import userFunctions.ToolInformation_UF;
import helperFunctions.*;

public class ToolInformation extends Setup {
	ElementTools elementTool = new ElementTools();
	ToolInformation_UF userFunction = new ToolInformation_UF();

	public void openExpander() {
		String expander = AppSession.findElementByAccessibilityId("Tool Information_Expander")
				.getAttribute("ItemStatus");
		if (expander.equals("False"))
			AppSession.findElementByAccessibilityId("Tool Information_Expander").click();
	}

	public void selectTool() {
		if (!AppSession.findElementByAccessibilityId("ToolID_txt").isDisplayed()) {

			WebElement ToolList_DD = AppSession.findElementByAccessibilityId("ToolList_DD");
			elementTool.setDropDownValue(ToolList_DD, "120640");
			AppSession.findElementByAccessibilityId("SelectTool_Btn").click();

			try {
				int timerCount = 0;
				while (AppSession.findElementByAccessibilityId("SetupCaption").isDisplayed()) {
					Thread.sleep(100);
					timerCount++;
					System.out.println(timerCount);
					if (timerCount == 100)
						break;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void addComponent() {
		
		ToolComponent drive = new ToolComponent();
		drive.setPartType("Drive Assy");
		drive.setSerialNum("1010ADRV02");
		
		ToolComponent smag = new ToolComponent();
		smag.setPartType("SMAG Assy.");
		smag.setSerialNum("TA002384");
		smag.addSensor("B43851");
		smag.addSensor("B44383");
		smag.setGauss("32.768");
		smag.setGaussOffset("1280");
		// TODO addImages is not working. it opens the dialog but isn't able to send
		// text
		// smag.addImages("IMU CPU.jpg");

		ToolComponent DAA = new ToolComponent();
		DAA.setPartType("DAA Assy.");
		DAA.setSerialNum("1010ADAA03");
		DAA.addSensor("B42854");
		DAA.addSensor("B40204");
		DAA.addSensor("B26345");
		DAA.addSensor("B42365");
		DAA.addSensor("B25561");
		DAA.addSensor("B41221");
		DAA.addSensor("B41219");
		DAA.addSensor("B27252");
		DAA.addSensor("B42851");
		DAA.addSensor("B27937");
		DAA.addWyes("B38340");
		DAA.addWyes("B38341");
		DAA.addImages("IMU CPU.jpg");

		
		ToolComponent cpu = new ToolComponent();
		cpu.setPartType("CPU Assy.");
		cpu.setSerialNum("108307SN001");
		cpu.setMemoryRunTime("27.64");
		cpu.setMomorySize("123");
		cpu.setUCLocation("D:\\CI_Automation\\Support_Files\\"+Setup.run+"\\INSCAL\\config.xml");
		
		
		ToolComponent IMU = new ToolComponent();
		IMU.setPartType("IMU");
		IMU.setSerialNum("430518");
		
		
		
		userFunction.addToolComponent(cpu);
		userFunction.addToolComponent(IMU);
		userFunction.addToolComponent(smag);
		

	}
	
	public void addOdometers() {
		
		ToolOdometers odometers = new ToolOdometers();
		odometers.setOdoConfiguration("3.000 inch, 0.250 foot,  40 tooth,  80 click (.250)");
		odometers.setTireType("Saw blades");
		
		userFunction.setOdometers(odometers);
	}

	public void addMeasurements() {
		// TODO Auto-generated method stub
		ToolMeasurements toolMeasurements = new ToolMeasurements();
		toolMeasurements.setToolLengthValue("148");
		toolMeasurements.setToolLengthUnit("Inches");
		
		toolMeasurements.setMeasuredDriveCupDiameterValue("8.70");
		toolMeasurements.setMeasuredDriveCupDiameterUnit("Inches");
		
		toolMeasurements.setMeasuredSupportDiskDiameterValue("8.70");
		toolMeasurements.setMeasuredSupportDiskDiameterUnit("Inches");
		
		toolMeasurements.setMeasuredDEFSupportCupDiameterValue("8.60");
		toolMeasurements.setMeasuredDEFSupportCupDiameterUnit("Inches");
		
		toolMeasurements.setMeasuredXYZSupportCupDiameterValue("8.33");
		toolMeasurements.setMeasuredXYZSupportCupDiameterUnit("Inches");
		
		toolMeasurements.setMeasuredODofMFLBrushValue("8.55");
		toolMeasurements.setMeasuredODofMFLBrushUnit("Inches");
		
		toolMeasurements.setMeasuredODofSpirALLBrushValue("8.66");
		toolMeasurements.setMeasuredODofSpirALLBrushUnit("Inches");
		
		userFunction.setMeasurements(toolMeasurements);
	}
	
	public void addIMUMeasurements() {
		IMUMeasurements iMUMeasurements = new IMUMeasurements();
		
		iMUMeasurements.setMFLSensorsToCenterOfIMUValue("148.00");
		iMUMeasurements.setMFLSensorsToCenterOfIMUUnit("Inches");
		iMUMeasurements.setMFLSensorsToCenterOfIMUDirection("US");
		
		iMUMeasurements.setDEFSensorsToCenterOfIMUValue("8.55");
		iMUMeasurements.setDEFSensorsToCenterOfIMUUnit("Inches");
		iMUMeasurements.setDEFSensorsToCenterOfIMUDirection("US");
		
		iMUMeasurements.setDEFSensorsToCenterOfTransmitterValue("8.55");
		iMUMeasurements.setDEFSensorsToCenterOfTransmitterUnit("Inches");
		iMUMeasurements.setDEFSensorsToCenterOfTransmitterDirection("DS");
		
		iMUMeasurements.setCenterOfTransmiterToCenterOfIMUValue("8.70");
		iMUMeasurements.setCenterOfTransmiterToCenterOfIMUUnit("Inches");
		
		iMUMeasurements.setPushSurfaceToCenterOfIMUValue("8.70");
		iMUMeasurements.setPushSurfaceToCenterOfIMUUnit("Inches");
		
		iMUMeasurements.setFrontOfILIToolToCenterOfIMUValue("8.60");
		iMUMeasurements.setFrontOfILIToolToCenterOfIMUUnit("Inches");
		
		iMUMeasurements.setRearOfILIToolToCenterOfIMUValue("8.55");
		iMUMeasurements.setRearOfILIToolToCenterOfIMUUnit("Inches");
		iMUMeasurements.setRearOfILIToolToCenterOfIMUDirection("DS");
		
		userFunction.setIMUMeasurements(iMUMeasurements);
	}
	

}
