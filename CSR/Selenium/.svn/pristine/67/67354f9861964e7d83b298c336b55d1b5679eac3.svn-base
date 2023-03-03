package runner;

import testCases.*;

public class ExampleCaseValidator extends ProjectInformation {

	
	public ExampleCaseValidator() {
		//Generate a new run to work with
		NewRun();
		
		//Change one field, as specified by example info
		//Note that you can (and should) modify more than one, we are simply using one for example purposes.
		try {
			validateExampleInfo();
		} catch (Exception e) {
			// PUT FAILURE HANDLE HERE, WE DONT HAVE ONE RIGHT NOW
		}
		
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
	
	//Check that the data is valid, throwing an exception if something is wrong.
	public void validateExampleInfo() throws Exception {

		ProjectInformation projectInfo = new ProjectInformation();
		projectInfo.openExpander();
		if(!projectInfo.validateJobInformation())
			throw new Exception("Job Informaiton Failed to Validate");
	}
}
