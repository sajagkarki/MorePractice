package testCases;
import userActions.*;

public class RunWeldScanner_TC {

	public RunWeldScanner_TC() throws InterruptedException {
		
		Workflows wf = new Workflows();
		wf.setView("Legacy");
		
		MenuActions menu = new MenuActions();
		menu.runWeldScanner();
		System.out.println("WeldScanner TC Pass");
	}
	
}
