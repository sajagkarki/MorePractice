package helperFunctions;

import java.util.ArrayList;
import java.util.List;

public class ToolComponent {
	private String part;
	private String serialNum;
	private String gauss;
	private String gaussOffset;
	private String memoryRunTime;
	private String UCLocation;
	private String memorySize;
	private List<String> sensors = new ArrayList<String>();
	private List<String> wyes = new ArrayList<String>();
	private List<String> images = new ArrayList<String>();

	
	//get 
	public String getPart() {
		return part;
	}
	public String getSerialNum() {
		return serialNum;
	}
	public List<String> getSensors() {
		return sensors;
	}
	
	public List<String> getWyes() {
		return wyes;
	}
	
	public List<String> getImages() {
		return images;
	}
	public String getGauss() {
		return gauss;
	}
	public String getGaussOffset() {
		return gaussOffset;
	}
	public String getMemoryRunTime() {
		return memoryRunTime;
	}
	public String getUCLocation() {
		return UCLocation;	
	}
	public String getMemorySize() {
		return memorySize;	
	}
	
	
	//set
	public void setPartType (String p) {
		part = p;
	}
	
	public void setSerialNum (String id) {
		serialNum = id;
	}
	public void setGauss(String g) {
		gauss =g;
	}
	public void setGaussOffset(String go) {
		gaussOffset =go ;
	}
	public void setMemoryRunTime(String mrt) {
		memoryRunTime = mrt;	
	}
	public void setUCLocation(String l) {
		UCLocation = l;	
	}
	public void setMomorySize(String m) {
		memorySize = m;
	}
	
	//add
	public void addSensor(String s) {
		sensors.add(s);
	}
	
	public void addWyes(String w) {
		wyes.add(w);
	}
	
	public void addImages(String i) {
		images.add(i);
	}

	
	
	
	
	
}
