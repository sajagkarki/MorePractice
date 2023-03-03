package helperFunctions;

public class ToolOdometers {

	private String odoConfiguration = null;
	private String tireType = null; 
	
	public void setOdoConfiguration (String o) {
		odoConfiguration = o;
	}
	
	public void setTireType (String t) {
		tireType = t;
	}
	
	public String getOdoConfiguration() {
		return odoConfiguration;
	}
	
	public String getTireType() {
		return tireType;
	}
	
}
