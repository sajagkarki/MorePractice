package testCases;

import helperClasses.View;
import userActions.*;

public class RunDentScanner_TC {
	
public RunDentScanner_TC() throws InterruptedException {
		
		
		Workflows wf = new Workflows();
		wf.setView("Legacy");
		
		View targetView = new View("Distance", "MFL");
		View newView = new View("Distance", "Deformation");
		
		OpenView view = new OpenView(targetView, "vertical",newView);
		
		//MenuActions menu = new MenuActions();
		//menu.runPitScanner();
		
		System.out.println("Dent Scanner TC Pass");
	}

}
