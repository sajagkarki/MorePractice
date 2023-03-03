package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.CSREnums.MilePostingPrefixType;
import com.tdw.csr.entity.CSREnums.ProcessType;
import com.tdw.csr.entity.CSREnums.Standard;
import com.tdw.csr.entity.markers.*;

import chromedriver.CompaireDB.tables;
import chromedriver.UIElements.*;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MarkersCDTest extends BaseCDTest {

	ElementValidationInterface xyzHoriVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				String[] mapping = {"WGS 84", "NAD 83", "GRS 80", "WGS 72", "Australian 1965", "Krasovsky 1940", "North American 1927", "International 1924", "Hayford 1909", "Clarke 1880", "Clarke 1866",
						"Airy 1830", "Bessel 1841", "Everest 1830", "SAD-69", "SIRGAS 2000", "OSGB36", "ETRS89"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).xyzHorizontalDatum;
				
				return ele.expectedValue.equals(typedList.get(0).xyzHorizontalDatum);
	};
	ElementValidationInterface xyzVertiVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				String[] mapping = {"Ellipsoidal", "Orthometric"};
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).xyzVerticalDatum;
				
				return ele.expectedValue.equals(typedList.get(0).xyzVerticalDatum);
	};
	ElementValidationInterface excludeValNumVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				ele.returnedValues 
						= (typedList.get(0).markersNearValvesExclusionSettings.include ? "True" : "False")
						+ ", " + typedList.get(0).markersNearValvesExclusionSettings.value;
				
				return (typedList.get(0).markersNearValvesExclusionSettings.include == ele.bool)
						&& (Double.parseDouble(ele.txtValue) == (typedList.get(0).markersNearValvesExclusionSettings.value));
			};
	ElementValidationInterface excludeValUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				String[] mapping = {"feet", "meters"};
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).markersNearValvesExclusionSettings.include ? "True" : "False")
								+ ", " + typedList.get(0).markersNearValvesExclusionSettings.units;
				
				return (typedList.get(0).markersNearValvesExclusionSettings.include == ele.bool)
						&& mapping[ele.dropDownIndex].equals(typedList.get(0).markersNearValvesExclusionSettings.units);
	};
	ElementValidationInterface excludeLaunchNumVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				ele.returnedValues 
						= (typedList.get(0).markersNearLaunchReceiveValvesExclusionSettings.include ? "True" : "False")
						+ ", " + typedList.get(0).markersNearLaunchReceiveValvesExclusionSettings.value;
				
				return (typedList.get(0).markersNearLaunchReceiveValvesExclusionSettings.include == ele.bool)
						&& (Double.parseDouble(ele.txtValue) == (typedList.get(0).markersNearLaunchReceiveValvesExclusionSettings.value));
			};
	ElementValidationInterface excludeLaunchUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				String[] mapping = {"feet", "meters"};
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).markersNearLaunchReceiveValvesExclusionSettings.include ? "True" : "False")
								+ ", " + typedList.get(0).markersNearLaunchReceiveValvesExclusionSettings.units;
				
				return (typedList.get(0).markersNearLaunchReceiveValvesExclusionSettings.include == ele.bool)
						&& mapping[ele.dropDownIndex].equals(typedList.get(0).markersNearLaunchReceiveValvesExclusionSettings.units);
	};
	ElementValidationInterface incClassVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				ele.returnedValues 
				= (typedList.get(0).includeClassification ? "True" : "False");
				
				return (typedList.get(0).includeClassification == ele.bool);
			};
	ElementValidationInterface staPrefVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				ele.returnedValues 
						= (typedList.get(0).stationingPrefix.include ? "True" : "False")
						+ ", " + typedList.get(0).stationingPrefix.value;
				
				return (typedList.get(0).stationingPrefix.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).stationingPrefix.value));
			};
	ElementValidationInterface encStaVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				ele.returnedValues 
				= (typedList.get(0).encloseStationingInBraces ? "True" : "False");
				
				return (typedList.get(0).encloseStationingInBraces == ele.bool);
			};
	ElementValidationInterface ifLocVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				ele.returnedValues 
				= (typedList.get(0).omitLocalizationSeparator ? "True" : "False");
				
				return (typedList.get(0).omitLocalizationSeparator == ele.bool);
			};
	ElementValidationInterface milePostVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				String[] mapping = {"MP", "KP", "KMP"};
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						=  (typedList.get(0).milePostingPrefix.include ? "True" : "False") + ", " + typedList.get(0).milePostingPrefix.value;
				
				return typedList.get(0).milePostingPrefix.include == ele.bool && MilePostingPrefixType.valueOf(mapping[ele.dropDownIndex]).equals(typedList.get(0).milePostingPrefix.value);
	};
	ElementValidationInterface markerBoxRef = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				ele.returnedValues 
				= (typedList.get(0).showMarkerBoxReference ? "True" : "False");
				
				return (typedList.get(0).showMarkerBoxReference == ele.bool);
			};
	ElementValidationInterface componentListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				ele.returnedValues
						= typedList.get(0).componentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(1).separatorSpacing
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(2).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(2).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(2).separatorSpacing
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(3).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(3).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(3).separatorSpacing
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(4).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(4).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(4).separatorSpacing
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(5).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(5).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(5).separatorSpacing
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(6).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(6).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(6).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).componentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).componentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).componentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).componentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).componentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).componentsOrder.hashtable.get(1).separatorSpacing.toString()))
				&& (ele.validationStrings.get(6).equals(typedList.get(0).componentsOrder.hashtable.get(2).component))
				&& (ele.validationStrings.get(7) == null || ele.validationStrings.get(7).equals(typedList.get(0).componentsOrder.hashtable.get(2).separator.toString()))
				&& (ele.validationStrings.get(8) == null || ele.validationStrings.get(8).equals(typedList.get(0).componentsOrder.hashtable.get(2).separatorSpacing.toString()))
				&& (ele.validationStrings.get(9).equals(typedList.get(0).componentsOrder.hashtable.get(3).component))
				&& (ele.validationStrings.get(10) == null || ele.validationStrings.get(10).equals(typedList.get(0).componentsOrder.hashtable.get(3).separator.toString()))
				&& (ele.validationStrings.get(11) == null || ele.validationStrings.get(11).equals(typedList.get(0).componentsOrder.hashtable.get(3).separatorSpacing.toString()))
				&& (ele.validationStrings.get(12).equals(typedList.get(0).componentsOrder.hashtable.get(4).component))
				&& (ele.validationStrings.get(13) == null || ele.validationStrings.get(13).equals(typedList.get(0).componentsOrder.hashtable.get(4).separator.toString()))
				&& (ele.validationStrings.get(14) == null || ele.validationStrings.get(14).equals(typedList.get(0).componentsOrder.hashtable.get(4).separatorSpacing.toString()))
				&& (ele.validationStrings.get(15).equals(typedList.get(0).componentsOrder.hashtable.get(5).component))
				&& (ele.validationStrings.get(16) == null || ele.validationStrings.get(16).equals(typedList.get(0).componentsOrder.hashtable.get(5).separator.toString()))
				&& (ele.validationStrings.get(17) == null || ele.validationStrings.get(17).equals(typedList.get(0).componentsOrder.hashtable.get(5).separatorSpacing.toString()))
				&& (ele.validationStrings.get(18).equals(typedList.get(0).componentsOrder.hashtable.get(6).component))
				&& (ele.validationStrings.get(19) == null || ele.validationStrings.get(19).equals(typedList.get(0).componentsOrder.hashtable.get(6).separator.toString()))
				&& (ele.validationStrings.get(20) == null || ele.validationStrings.get(20).equals(typedList.get(0).componentsOrder.hashtable.get(6).separatorSpacing.toString()));
			};
			
			
	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				ele.returnedValues 
						= typedList.get(0).ai.additionalNotes;
				
				return (ele.txtValue.equals(typedList.get(0).ai.additionalNotes));
			};
	ElementValidationInterface examplesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				ele.returnedValues 
						= typedList.get(0).ai.examples;
				
				return (ele.txtValue.equals(typedList.get(0).ai.examples));
			};
	ElementValidationInterface noSurvVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				ele.returnedValues 
				= (typedList.get(0).ai.generalMarking.manuallyMarkSurveyPoints ? "True" : "False");
				
				return (typedList.get(0).ai.generalMarking.manuallyMarkSurveyPoints == ele.bool);
			};
	ElementValidationInterface xyzRunsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				String[] mapping = {"STANDARD", "CUSTOM"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).ai.generalMarking.xyz.processType.toString();
				
				return ProcessType.valueOf(ele.expectedValue).equals(typedList.get(0).ai.generalMarking.xyz.processType);
	};
	ElementValidationInterface xyzRunsCommentVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				ele.returnedValues 
					= typedList.get(0).ai.generalMarking.xyz.customDescription;
		
				return (ele.txtValue.equals(typedList.get(0).ai.generalMarking.xyz.customDescription));
			};
	ElementValidationInterface noxyzRunsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				String[] mapping = {"STANDARD", "CUSTOM"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).ai.generalMarking.nonXyz.processType.toString();
				
				return ProcessType.valueOf(ele.expectedValue).equals(typedList.get(0).ai.generalMarking.nonXyz.processType);
	};
	ElementValidationInterface noxyzRunsCommentVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				ele.returnedValues 
						= typedList.get(0).ai.generalMarking.nonXyz.customDescription;
				
				return (ele.txtValue.equals(typedList.get(0).ai.generalMarking.nonXyz.customDescription));
			};
			
			
	ElementValidationInterface markerNumFormatVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				String[] mapping = {"##", "###", "No. ###", "Line # - Section ###"};
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).ai.markerNumberingFormat.include ? "True" : "False") + ", " + typedList.get(0).ai.markerNumberingFormat.value;
				
				return typedList.get(0).ai.markerNumberingFormat.include == ele.bool && mapping[ele.dropDownIndex].equals(typedList.get(0).ai.markerNumberingFormat.value);
			};
			
	ElementValidationInterface stationingVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				ele.returnedValues 
						= (typedList.get(0).ai.stationing.include ? "True" : "False")
						+ ", " + typedList.get(0).ai.stationing.formatStandard
						+ ", " + typedList.get(0).ai.stationing.customFormat;
						
						//Hashtable size is dynamic
						for(int i = 0; i < ele.secondaryList.size(); i++) {
							ele.returnedValues += ", " + typedList.get(0).ai.stationing.dataSource.hashtable.get(i);
						}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).ai.stationing.include == ele.bool
						&& (typedList.get(0).ai.stationing.formatStandard) == Standard.valueOf(ele.validationStrings.get(1))
						&& (ele.txtValue == null || ele.validationStrings.get(2).equals(typedList.get(0).ai.stationing.customFormat));
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(3 + i).equals(typedList.get(0).ai.stationing.dataSource.hashtable.get(i));
				}
						
				
				return pass;
			};	
	ElementValidationInterface addMPVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.txtValue + ", " + ele.validationStrings;
				
				ele.returnedValues 
						= (typedList.get(0).ai.milePosting.include ? "True" : "False")
						+ ", " + typedList.get(0).ai.milePosting.customFormat;
						
						//Hashtable size is dynamic
						for(int i = 0; i < ele.secondaryList.size(); i++) {
							ele.returnedValues += ", " + typedList.get(0).ai.milePosting.dataSource.hashtable.get(i);
						}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).ai.milePosting.include == ele.tertiaryFlag
						&& (ele.generalIndex != 2 || ele.txtValue == null || ele.txtValue.equals(typedList.get(0).ai.milePosting.customFormat));
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(i).equals(typedList.get(0).ai.milePosting.dataSource.hashtable.get(i));
				}
						
				
				return pass;
			};	
	ElementValidationInterface markerDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.validationStrings;
				
				ele.returnedValues 
						= (typedList.get(0).ai.markerDescriptionDataSource.include ? "True" : "False");
						
						//Hashtable size is dynamic
						for(int i = 0; i < ele.secondaryList.size(); i++) {
							ele.returnedValues += ", " + typedList.get(0).ai.markerDescriptionDataSource.value.hashtable.get(i);
						}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).ai.markerDescriptionDataSource.include == ele.tertiaryFlag;
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(i).equals(typedList.get(0).ai.markerDescriptionDataSource.value.hashtable.get(i));
				}
						
				
				return pass;
			};	
	ElementValidationInterface markersNearVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				String[] mapping = {"Add description to Valve", "Add descriptions to Valve and include Stationing and Valve Name", "Add description to Launch and Receiver valves", 
						"If marker is in survey data leave as is, otherwise use valve description", "Add AGM# and GPS to Valve"};
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).ai.markersNearValvesHandling;
				
				return ele.expectedValue.equals(typedList.get(0).ai.markersNearValvesHandling);
	};
	ElementValidationInterface manualMarkVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				ele.returnedValues 
				= (typedList.get(0).ai.manuallyMarkMissingMarkersFromPreviousRun ? "True" : "False");
				
				return (typedList.get(0).ai.manuallyMarkMissingMarkersFromPreviousRun == ele.bool);
			};
	ElementValidationInterface addCorrelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				ele.returnedValues 
						= (typedList.get(0).ai.includeMissingMarkersCorrelationNotes.include ? "True" : "False")
						+ ", " + typedList.get(0).ai.includeMissingMarkersCorrelationNotes.value;
				
				return (typedList.get(0).ai.includeMissingMarkersCorrelationNotes.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).ai.includeMissingMarkersCorrelationNotes.value));
			};
			
			
	ElementValidationInterface addGPSVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				ele.returnedValues 
				= (typedList.get(0).ai.addGPSForLatLongAlt ? "True" : "False");
				
				return (typedList.get(0).ai.addGPSForLatLongAlt == ele.bool);
			};
	ElementValidationInterface GPSFormatVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				String[] mapping = {"Decimal"};
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).ai.gpsFormat;
				
				return ele.expectedValue.equals(typedList.get(0).ai.gpsFormat);
	};
	ElementValidationInterface GPSCheckListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
					
				//Note that the DB and website ordering doens't match.
				ele.returnedValues = (typedList.get(0).ai.gpsSource.hashtable.get("Client Documentation") ? "True" : "False")
						+ ", " + (typedList.get(0).ai.gpsSource.hashtable.get("Hans Marker Boxes") ? "True" : "False")
						+ ", "+ (typedList.get(0).ai.gpsSource.hashtable.get("Previous Runs") ? "True" : "False");
				
				if(typedList.get(0).ai.gpsSource.hashtable.get("Client Documentation") == (ele.controlIndices[0] == 1 ? true : false)
						&& typedList.get(0).ai.gpsSource.hashtable.get("Hans Marker Boxes") == (ele.controlIndices[1] == 1 ? true : false)
						&& typedList.get(0).ai.gpsSource.hashtable.get("Previous Runs") == (ele.controlIndices[2] == 1 ? true : false)
						)
					return true;
				else
					return false;
			};	
	ElementValidationInterface genKMLVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Markers> typedList = (List<Markers>) list;
				
				ele.returnedValues 
				= (typedList.get(0).ai.generateKMLFile ? "True" : "False");
				
				return (typedList.get(0).ai.generateKMLFile == ele.bool);
			};
					
	
	public List<String> dragPrioritylist() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Numbering");
		cPL.add("Localization");
		cPL.add("Correlation Notes");
		cPL.add("Marker Type");
		cPL.add("Stationing");
		cPL.add("Mile Posting");
		cPL.add("Marker Box");
		
		return cPL;
	}
	
	public List<String> stationingAvailableList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Odometer Data");
		cPL.add("Previous Runs");
		cPL.add("Tracking Sheet");
		
		return cPL;
	}
	
	public List<String> stationingSelectedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listings");
		cPL.add("Client Questionnaire");
		cPL.add("Alignment Maps");
		
		return cPL;
	}
	
	public List<String> mpAvailableList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Previous Runs");
		cPL.add("Pipe Listings");
		
		return cPL;
	}
	
	public List<String> mpSelectedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Alignment Maps");
		cPL.add("Tracking Sheet");
		
		return cPL;
	}
	
	public List<String> markerAvailableList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listing");
		cPL.add("Tracking Sheet");
		
		return cPL;
	}
	
	public List<String> markerSelectedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Previous Runs");
		cPL.add("Alignment Maps");
		
		return cPL;
	}
	
	
	@SuppressWarnings("unchecked")
	@ParameterizedTest
	@ValueSource(strings = {"Markers_1.json", "Markers_2.json", "Markers_3.json"})
	public void testFittingsPage(String argument) throws Exception {
	  	//Load Arguments
	  	String JSONname = argument;
	  	
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader("..\\Chromedriver\\JSONTestConfigFiles\\" + JSONname));
		GenerateJSONInputFiles.testInputFile argumentFile = gson.fromJson(reader, GenerateJSONInputFiles.testInputFile.class);
		
		
		// Optional. If not specified, WebDriver searches the PATH for chromedriver.
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDriver\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// "d:/ChromeDriver/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.setExperimentalOption("useAutomationExtension", false);
		chromeOptions.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-markers&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
			
		//Casings report label and classification
		elements.add(new SelectElement(driver, xyzHoriVal, "xyzHorizontal_s", argumentFile.defaultValues.defaultSelectValue));
		elements.add(new SelectElement(driver, xyzVertiVal, "xyzVertical_s", argumentFile.defaultValues.defaultSelectValue));
		
		boolean excNearValve = argumentFile.defaultValues.includeIWVorIWVS;
		elements.add(new IWVElement(driver, excludeValNumVal, "markersNearValves_vu", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), excNearValve));
		elements.add(new IWVSElement(driver, excludeValUnitVal, "markersNearValves_vu", argumentFile.defaultValues.defaultIWVSValue, excNearValve));	
		
		boolean excWithin = argumentFile.defaultValues.includeIWVorIWVS;
		elements.add(new IWVElement(driver, excludeLaunchNumVal, "markersNearLaunch_vu", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), excWithin));
		elements.add(new IWVSElement(driver, excludeLaunchUnitVal, "markersNearLaunch_vu", argumentFile.defaultValues.defaultIWVSValue, excWithin));	
		
		elements.add(new CBElement(driver, incClassVal, "includeClassification_cb", argumentFile.defaultValues.includeCB));
		elements.add(new IWVElement(driver, staPrefVal, "stationingPrefix_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new CBElement(driver, encStaVal, "encloseStationing_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, ifLocVal, "omitLocalizationSeparator_cb", argumentFile.defaultValues.includeCB));
		elements.add(new IWVSElement(driver, milePostVal, "milePosting_iwvs", argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.includeIWVorIWVS));	
		elements.add(new CBElement(driver, markerBoxRef, "showMarkerBox_cb", argumentFile.defaultValues.includeCB));
		elements.add(new DragListElement(driver, componentListVal, "componentsOrder_cl", (List<String>) argumentFile.uniqueValues.get("componentsOrder_cl"), 
				argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));	
		
		
		//Marker Analysis Intervention
		elements.add(new CBElement(driver, noSurvVal, "manuallyMarkSurvey_cb", argumentFile.defaultValues.includeCB));
		
		boolean CustomMappingMarking = argumentFile.defaultValues.defaultRGValues == 1 ? true : false;
		elements.add(new RGElement(driver, xyzRunsVal, "processType_rg", CustomMappingMarking ? 1 : 0));
		if(CustomMappingMarking)
		{
			elements.add(new TextElement(driver, xyzRunsCommentVal, "displayCustomDescription_ta", argumentFile.defaultValues.defaultTextValue));	
		}
		
		//As these are both _mp objects, instance specification is needed in the second case.
		boolean CustomMarking = argumentFile.defaultValues.defaultRGValues == 1 ? true : false;
		elements.add(new RGElement(driver, noxyzRunsVal, "processType_rg", CustomMarking ? 1 : 0));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		if(CustomMarking)
		{
			elements.add(new TextElement(driver, noxyzRunsCommentVal, "displayCustomDescription_ta", argumentFile.defaultValues.defaultTextValue));	
			if(CustomMappingMarking)
			{
				elements.get(elements.size() - 1).setDesiredInstance(1);
			}
		}
		
		
		//Marker Labeling
		elements.add(new IWVSElement(driver, markerNumFormatVal, "markerNumberingFormat_iwvs", argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new StationingSelectElement(driver, stationingVal, "stationing_sta", 
				(List<String>) argumentFile.uniqueValues.get("sta_availableList"), (List<String>) argumentFile.uniqueValues.get("sta_selectedList"), 
				argumentFile.defaultValues.stationingSelection, argumentFile.defaultValues.customStationingValue, argumentFile.defaultValues.includeStationing));
		elements.add(new SimpleDataSourceElement(driver, addMPVal, "milePosting_mp", 
				(List<String>) argumentFile.uniqueValues.get("mark_availableList"), (List<String>) argumentFile.uniqueValues.get("mark_selectedList"), 
				"Message", false, false, argumentFile.defaultValues.includeSimpleDataSource));
		elements.add(new SimpleDataSourceElement(driver, markerDescVal, "markerDescriptionDataSource_ds", 
				(List<String>) argumentFile.uniqueValues.get("mark2_availableList"), (List<String>) argumentFile.uniqueValues.get("mark2_selectedList"), 
				null, false, false, argumentFile.defaultValues.includeSimpleDataSource));
		elements.add(new SelectElement(driver, markersNearVal, "propertyWithUpdates_s", 2));	
		
		elements.add(new CBElement(driver, manualMarkVal, "manuallyMarkMissing_cb", argumentFile.defaultValues.includeCB));
		elements.add(new IWVElement(driver, addCorrelVal, "includeMissingMarkersCorrelation_tf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		
		boolean addGPS = (Boolean) argumentFile.uniqueValues.get("GPSCoordinates_cb");
		elements.add(new CBElement(driver, addGPSVal, "GPSCoordinates_cb", addGPS));
		//Add GPS Toggles several other boxes.
		if(addGPS)
		{
			elements.add(new SelectElement(driver, GPSFormatVal, "gpsFormat_ts", 0));
			//The three checkboxes are all part of one object, so instance specification is required.
			elements.add(new CBListElement(driver, GPSCheckListVal, "gpsSource_ms", argumentFile.defaultValues.CBLVal));
		}
		
		elements.add(new CBElement(driver, genKMLVal, "generateKML_cb", argumentFile.defaultValues.includeCB));
		elements.add(new TextElement(driver, deviationsVal, "additionalNotes_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, examplesVal, "examples_ta", argumentFile.defaultValues.defaultTextValue));
		
		} catch(Exception ex) { //Configuration Error
			elements.clear();
			elements.add(new ConfigurationErrorElement(ex.getMessage()));
		}
		
		Thread.sleep(3000);
		

		WebElement editButton = driver.findElement(By.name("edit-icon_btn"));
		editButton.click();
		
		Thread.sleep(200);

		for (UIElements e : elements) {
			try {
				e.runTestConfiguration();
			}
			catch(Exception ex) {
				e.failedExecution = true;
				e.exceptionMessage = ex.getMessage();
				
				//Ensure that no dialog remains open after a failure
				try {
					UIElements closeEle = new tryCloseDialogElement(driver);
					closeEle.runTestConfiguration();
				}
				catch(Exception ignoreEx) { } //Ignore this, as not all elements will have a dialog
			}
		}
		
		
		
		WebElement applyButton = driver.findElement(By.name("apply_btn"));
		if (applyButton.isEnabled())
			applyButton.click();
		Thread.sleep(3000); // Let the user actually see something.
		driver.close();
		driver.quit();
		
		//Run database comparison
		CompaireDB compTest = new CompaireDB();
		compTest.compaireDB(elements, "Markers", tables.MARKERS, "MarkersResults", argumentFile.FileCounter);
	}
}