package testCases;
import helperClasses.View;
import userActions.*;

public class OpenRun_TC {

	public OpenRun_TC() {
		String run = "ENT2934.rsf";
		String dir = "D:\\car\\test\\20210422DM LID 133 Segment 1 Rocky Mountain West Loop_AID 1517_10in_ENT2934_256051\\ILI\\";
		
		OpenRun or = new OpenRun();
		or.openRun(run, dir);
		System.out.println("OpenRun TC Pass");
	}
	
}
