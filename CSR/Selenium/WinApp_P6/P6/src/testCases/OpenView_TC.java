package testCases;
import userActions.*;

import helperClasses.View;

public class OpenView_TC {

	public OpenView_TC() {
		// TODO Auto-generated constructor stub
	}
	public OpenView_TC(View targetView, View newView, String splitter, double viewWidth) {
		if(viewWidth != 0) {
			Buttons button = new Buttons();
			button.setViewWidth(viewWidth);
		}
		OpenView OpenView = new OpenView (targetView, splitter, newView);	
		System.out.println("OpenView TC Pass");
	}

	
}
