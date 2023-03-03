package helperFunctions;

import java.util.HashMap; // import the HashMap class
import java.util.Map;

public class ToolMeasurements {
	
	private String toolLengthValue;
	private String toolLengthUnit;
	 
	private String measuredDriveCupDiameterValue;
	private String measuredDriveCupDiameterUnit;
	
	private String measuredSupportDiskDiameterValue;
	private String measuredSupportDiskDiameterUnit;
	
	private String measuredDEFSupportCupDiameterValue;
	private String measuredDEFSupportCupDiameterUnit;
	
	private String measuredXYZSupportCupDiameterValue;
	private String measuredXYZSupportCupDiameterUnit;
	
	private String measuredODofMFLBrushValue;
	private String measuredODofMFLBrushUnit;

	private String measuredODofSpirALLBrushValue;
	private String measuredODofSpirALLBrushUnit;
	
	

	public Map<String, String> getToolLength() {
		Map<String, String> tl = new HashMap<>();
		tl.put("value", toolLengthValue);
		tl.put("unit", toolLengthUnit);
		return tl;
	}
	
	public Map<String, String> getMeasuredDriveCupDiameter() {
		Map<String, String> tl = new HashMap<>();
		tl.put("value", measuredDriveCupDiameterValue);
		tl.put("unit", measuredDriveCupDiameterUnit);
		return tl;
	}
	
	public Map<String, String> getMeasuredSupportDiskDiameter() {
		Map<String, String> tl = new HashMap<>();
		tl.put("value", measuredSupportDiskDiameterValue);
		tl.put("unit", measuredSupportDiskDiameterUnit);
		return tl;
	}
	
	public Map<String, String> getMeasuredDEFSupportCupDiameter() {
		Map<String, String> tl = new HashMap<>();
		tl.put("value", measuredDEFSupportCupDiameterValue);
		tl.put("unit", measuredDEFSupportCupDiameterUnit);
		return tl;
	}
	
	public Map<String, String> getMeasuredXYZSupportCupDiameter() {
		Map<String, String> tl = new HashMap<>();
		tl.put("value", measuredXYZSupportCupDiameterValue);
		tl.put("unit", measuredXYZSupportCupDiameterUnit);
		return tl;
	}
	
	public Map<String, String> getMeasuredODofMFLBrush() {
		Map<String, String> tl = new HashMap<>();
		tl.put("value", measuredODofMFLBrushValue);
		tl.put("unit", measuredODofMFLBrushUnit);
		return tl;
	}
	
	public Map<String, String> getMeasuredODofSpirALLBrush() {
		Map<String, String> tl = new HashMap<>();
		tl.put("value", measuredODofSpirALLBrushValue);
		tl.put("unit", measuredODofSpirALLBrushUnit);
		return tl;
	}
	

	
	public void setToolLengthValue	(String v){toolLengthValue=v;}
	public void	setToolLengthUnit	(String v){toolLengthUnit=v;}
	public void	setMeasuredDriveCupDiameterValue	(String v){measuredDriveCupDiameterValue=v;}
	public void	setMeasuredDriveCupDiameterUnit	(String v){measuredDriveCupDiameterUnit=v;}
	public void	setMeasuredSupportDiskDiameterValue	(String v){measuredSupportDiskDiameterValue=v;}
	public void	setMeasuredSupportDiskDiameterUnit	(String v){measuredSupportDiskDiameterUnit=v;}
	public void	setMeasuredDEFSupportCupDiameterValue	(String v){measuredDEFSupportCupDiameterValue=v;}
	public void	setMeasuredDEFSupportCupDiameterUnit	(String v){measuredDEFSupportCupDiameterUnit=v;}
	public void	setMeasuredXYZSupportCupDiameterValue	(String v){measuredXYZSupportCupDiameterValue=v;}
	public void	setMeasuredXYZSupportCupDiameterUnit	(String v){measuredXYZSupportCupDiameterUnit=v;}
	public void	setMeasuredODofMFLBrushValue	(String v){measuredODofMFLBrushValue=v;}
	public void	setMeasuredODofMFLBrushUnit	(String v){measuredODofMFLBrushUnit=v;}
	public void	setMeasuredODofSpirALLBrushValue	(String v){measuredODofSpirALLBrushValue=v;}
	public void	setMeasuredODofSpirALLBrushUnit	(String v){measuredODofSpirALLBrushUnit=v;}
	


	
	
}
