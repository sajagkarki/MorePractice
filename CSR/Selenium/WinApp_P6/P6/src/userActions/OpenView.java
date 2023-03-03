package userActions;
import helperClasses.View;
import runner.*;

public class OpenView extends Setup {

	public OpenView() {
		// TODO Auto-generated constructor stub
	}
	
	public OpenView(View targetView, String splitter, View openView) {

		String v_target = "Split " + splitter+ " " +targetView.getUnit()+ "-based "+ targetView.getTechnology() + " View";
		String v_open = ""; 
		AppSession.findElementByName(v_target).click();
		AppSession.findElementByName(openView.getUnit()+ " Based").click();
		AppSession.findElementByName("Create "+openView.getTechnology()+ " View").click();
		AppSession.findElementByName("Pipeline View").click();
	}

}
