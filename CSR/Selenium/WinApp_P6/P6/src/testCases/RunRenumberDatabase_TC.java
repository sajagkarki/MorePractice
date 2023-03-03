package testCases;

import userActions.MenuActions;
import userActions.Workflows;

public class RunRenumberDatabase_TC {
	
	public RunRenumberDatabase_TC () throws InterruptedException {
		
		Workflows wf = new Workflows();
		wf.setView("Legacy");
		
		MenuActions menu = new MenuActions();
		menu.runRenumberDatabase();
		
		System.out.println("Renumber Database TC Pass");
	}

}
