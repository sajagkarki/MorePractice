package testCases;

import userActions.Buttons;

public class JumpToDistance_TC {

	public JumpToDistance_TC() {
		// TODO Auto-generated constructor stub
		Buttons jumpToDist_btn = new Buttons();
		jumpToDist_btn.jumpToDistance("40");
		System.out.println("JumpToDistance TC Pass");
	}

}
