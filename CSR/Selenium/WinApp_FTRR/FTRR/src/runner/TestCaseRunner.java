package runner;

import testCases.*;

public class TestCaseRunner extends ProjectInformation {

	
	public TestCaseRunner() {
		//NewRun();
		//openRun is complete
		OpenRun();
		
		//new run is complete
		//project Info is complete
		//projectInfo();
		//toolInfo();
	}

	public void OpenRun() {
		OpenRun openRun = new OpenRun();
	}
	
	public void NewRun() {
		NewRun newRun = new NewRun();
		newRun.createNewRun();
	}
	
	public void projectInfo() {

		ProjectInformation projectInfo = new ProjectInformation();
		projectInfo.openExpander();
		projectInfo.JobInformation();
		projectInfo.TDWContacts();
		projectInfo.Contacts();
		projectInfo.LaunchSiteInformation();
		projectInfo.ReceiveSiteInformation();
		projectInfo.PipeSectionDetails();
		projectInfo.PipelineProduct();
	}
	private void toolInfo() {
		// TODO Auto-generated method stub
		ToolInformation toolInfo = new ToolInformation();
		toolInfo.openExpander();
		
		//good
		toolInfo.selectTool();
		//good
		toolInfo.addComponent();
		//good
		toolInfo.addOdometers();
		//good
		toolInfo.addMeasurements();
		//good
		toolInfo.addIMUMeasurements();
	}
}
