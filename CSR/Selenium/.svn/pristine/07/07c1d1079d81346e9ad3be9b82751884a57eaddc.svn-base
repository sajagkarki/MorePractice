package runner;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import helperClasses.*;
import testCases.*;

public class Main extends Setup {

	public static void main(String[] args) throws InterruptedException {
		
		
		Setup s = new Setup();
		s.StartDriver("127.0.0.1");

		//this will be used to pull test cases from Zephyr do not delete --- I don't think we use Zephyr anymore - Hunter
		/*try {
			s.openZephyrConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		OpenRun_TC OpenRun = new OpenRun_TC();
		ExamplePreferences_TC exampleTest = new ExamplePreferences_TC();
		
		//RunDentScanner_TC dentScanner = new RunDentScanner_TC();
		
		//good tc
		//RunWeldScanner_TC weldScanner = new RunWeldScanner_TC();
		//good tc
		//RunPitScanner_TC pitScanner = new RunPitScanner_TC();
		//good tc
		//RunRenumberDatabase_TC renumberDB = new RunRenumberDatabase_TC();
		//JumpToDistance_TC JTD = new JumpToDistance_TC();
		//these are all good
		//View targetView = new View("Distance", "MFL");
		//View newView = new View("Time", "Residual MFL");
		//View newView = new View("Distance", "Deformation");
		//OpenView_TC openView = new OpenView_TC(targetView,newView,"Vertical",33.6);
		
		
		
		//Validation
		s = new Setup();
		s.StartDriver("127.0.0.1");
		
		OpenRun_TC OpenRun2 = new OpenRun_TC();
		ExamplePreferences_Validator exampleTest2 = new ExamplePreferences_Validator();
		
	}
}
	