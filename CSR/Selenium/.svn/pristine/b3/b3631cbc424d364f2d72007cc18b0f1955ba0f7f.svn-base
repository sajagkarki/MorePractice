package runner;

import testCases.*;

public class ExampleCaseRunner extends ProjectInformation {

	
	public ExampleCaseRunner() {
		//Generate a new run to work with
		NewRun();
		
		//Change one field, as specified by example info
		//Note that you can (and should) modify more than one, we are simply using one for example purposes.
		exampleInfo();
		
		CloseRun(); //Due to the nature of FTRR, this will save the app as well as close it
	}

	public void OpenRun() {
		OpenRun openRun = new OpenRun();
	}
	
	public void CloseRun() {
		CloseRun closeRun = new CloseRun();
	}
	
	public void NewRun() {
		NewRun newRun = new NewRun();
		newRun.createNewRun();
	}
	
	public void exampleInfo() {

		ProjectInformation projectInfo = new ProjectInformation();
		projectInfo.openExpander();
		projectInfo.JobInformation();
	}
}
