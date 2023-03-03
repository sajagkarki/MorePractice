package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.CSREnums;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.CSREnums.DentsMarkAsRepairedType;
import com.tdw.csr.entity.CSREnums.RepairsUnderType;
import com.tdw.csr.entity.CSREnums.ReportType;
import com.tdw.csr.entity.metal_loss.*;

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

public class GroupsCDTest extends BaseCDTest {
	
	ElementValidationInterface legacyPressureVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"ASME B31G Original", "ASME B31G Modified", "ASME B31G: Effective Area (RSTRENG)", "Shell - 92", "Saudi Aramco"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).groups.pressureCalculationAlgorithms;
				
				return (ele.expectedValue.equals(typedList.get(0).groups.pressureCalculationAlgorithms));
			};
	ElementValidationInterface legacyInteractionVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"1 inch between pits", "6X Wall (cir), 3x Wall (axial)", "6X Wall, 1 inch Axial", "6X Wall, 6X Wall",
						"Length of Shorter Pit", "POF interaction", "12X Wall, 12X Wall", "12X Wall, 6X Wall", "3X Wall, 3X Wall", "6X Wall (cir), 12X Wall (axial)",
						"1X Wall, 1X Wall", "Max 2 inch or 6X Wall", "6X Wall, 1X Wall", "2x Length of Shorter Pit", "DNV"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).groups.groupingInteractionRules;
				
				return (ele.expectedValue.equals(typedList.get(0).groups.groupingInteractionRules));
			};
	ElementValidationInterface legacyPitLengthVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"PIT_LENGTH_PREDICTED", "PIT_LENGTH_SIGNAL", "PIT_LENGTH_PITBOX"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).groups.pitLengthType.toString();
				
				return (ele.expectedValue.equals(typedList.get(0).groups.pitLengthType.toString()));
			};
			
	ElementValidationInterface legacyWeldsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.includeGroupingAcrossWelds ? "True" : "False");
				
				return (typedList.get(0).groups.includeGroupingAcrossWelds == ele.bool);
			};
	ElementValidationInterface legacyWTVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.includeGroupingAcrossWT ? "True" : "False");
				
				return (typedList.get(0).groups.includeGroupingAcrossWT == ele.bool);
			};
	ElementValidationInterface legacyIntExtVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.includeGroupInternalAndExternal ? "True" : "False");
				
				return (typedList.get(0).groups.includeGroupInternalAndExternal == ele.bool);
			};
	ElementValidationInterface legacyReturnVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.includeEffectiveArea ? "True" : "False");
				
				return (typedList.get(0).groups.includeEffectiveArea == ele.bool);
			};
	ElementValidationInterface legacyEAMVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.includeSmartEAM ? "True" : "False");
				
				return (typedList.get(0).groups.includeSmartEAM == ele.bool);
			};
	ElementValidationInterface legacyRepDigVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.addRepairDigInfoToDesc ? "True" : "False");
				
				return (typedList.get(0).groups.addRepairDigInfoToDesc == ele.bool);
			};
	ElementValidationInterface legacyCBLVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;

				//As the db hashtable is not necessarily in the same order as the checklist, a map is used.
				String[] mapping = {
						"Corrosion",
						"Girth Weld Anomalies",
						"MFG",
						"Metal Loss",
						"Possible Girth Weld Anomaly"
				};
				
				boolean allMatching = true;
				
				ele.returnedValues = "";
				
				for(int i = 0; i < ele.controlIndices.length; i++)
				{
					String tkey = mapping[i];
					
					if(i != 0)
						ele.returnedValues += ", ";
					System.out.println(i);
					ele.returnedValues += (typedList.get(0).groups.pitTypesToGroup.hashtable.get(tkey) ? "True" : "False");
					
					if(typedList.get(0).groups.pitTypesToGroup.hashtable.get(tkey) != (ele.controlIndices[i] == 1 ? true : false))
						allMatching = false;
				}
				
				return allMatching;
			};	
	
			
	ElementValidationInterface MDSPressureVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"ASME B31G Original", "ASME B31G Modified", "ASME B31G: Effective Area (RSTRENG)", "Shell - 92", "Saudi Aramco"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).groups.pressureCalculationAlgorithmsMDS;
				
				return (ele.expectedValue.equals(typedList.get(0).groups.pressureCalculationAlgorithmsMDS));
			};
	ElementValidationInterface MDSInteractionVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"1 inch between pits", "6X Wall (cir), 3x Wall (axial)", "6X Wall, 1 inch Axial", "6X Wall, 6X Wall",
						"Length of Shorter Pit", "POF interaction", "12X Wall, 12X Wall", "12X Wall, 6X Wall", "3X Wall, 3X Wall", "6X Wall (cir), 12X Wall (axial)",
						"1X Wall, 1X Wall", "Max 2 inch or 6X Wall", "6X Wall, 1X Wall", "2x Length of Shorter Pit", "DNV"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).groups.groupingInteractionRulesMDS;
				
				return (ele.expectedValue.equals(typedList.get(0).groups.groupingInteractionRulesMDS));
			};
	ElementValidationInterface MDSPitLengthVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"PIT_LENGTH_PREDICTED", "PIT_LENGTH_SIGNAL", "PIT_LENGTH_PITBOX"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).groups.pitLengthTypeMDS.toString();
				
				return (ele.expectedValue.equals(typedList.get(0).groups.pitLengthTypeMDS.toString()));
			};
			
	ElementValidationInterface MDSWeldsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.includeGroupingAcrossWeldsMDS ? "True" : "False");
				
				return (typedList.get(0).groups.includeGroupingAcrossWeldsMDS == ele.bool);
			};
	ElementValidationInterface MDSWTVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.includeGroupingAcrossWTMDS ? "True" : "False");
				
				return (typedList.get(0).groups.includeGroupingAcrossWTMDS == ele.bool);
			};
	ElementValidationInterface MDSIntExtVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.includeGroupInternalAndExternalMDS ? "True" : "False");
				
				return (typedList.get(0).groups.includeGroupInternalAndExternalMDS == ele.bool);
			};
	ElementValidationInterface MDSReturnVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.includeEffectiveAreaMDS ? "True" : "False");
				
				return (typedList.get(0).groups.includeEffectiveAreaMDS == ele.bool);
			};
	ElementValidationInterface MDSEAMVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.includeSmartEAMMDS ? "True" : "False");
				
				return (typedList.get(0).groups.includeSmartEAMMDS == ele.bool);
			};
	ElementValidationInterface MDSRepDigVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.addRepairDigInfoToDescMDS ? "True" : "False");
				
				return (typedList.get(0).groups.addRepairDigInfoToDescMDS == ele.bool);
			};
	ElementValidationInterface MDSCBLVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;

				//As the db hashtable is not necessarily in the same order as the checklist, a map is used.
				String[] mapping = {
						"Corrosion",
						"Girth Weld Anomalies",
						"MFG",
						"Metal Loss",
						"Possible Girth Weld Anomaly"
				};
				
				boolean allMatching = true;
				
				ele.returnedValues = "";
				
				for(int i = 0; i < ele.controlIndices.length; i++)
				{
					String tkey = mapping[i];
					
					if(i != 0)
						ele.returnedValues += ", ";
					
					ele.returnedValues += (typedList.get(0).groups.pitTypesToGroupMDS.hashtable.get(tkey) ? "True" : "False");
					
					if(typedList.get(0).groups.pitTypesToGroupMDS.hashtable.get(tkey) != (ele.controlIndices[i] == 1 ? true : false))
						allMatching = false;
				}
				
				return allMatching;
			};	
			
			
	ElementValidationInterface excludePitsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.excludePitsBelowPercent.include ? "True" : "False")
						+ ", " + typedList.get(0).groups.excludePitsBelowPercent.value;
				
				return (typedList.get(0).groups.excludePitsBelowPercent.include == ele.bool)
						&& (Integer.valueOf(ele.txtValue) == (typedList.get(0).groups.excludePitsBelowPercent.value));
			};
	ElementValidationInterface groupTogetherVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.includeGroupRepairedAndNonrepaired ? "True" : "False");
				
				return (typedList.get(0).groups.includeGroupRepairedAndNonrepaired == ele.bool);
			};
	ElementValidationInterface filterUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"LESS_THAN", "LESS_THAN_OR_EQUAL_TO"};
				
				ele.expectedValue = "True, " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
				= (typedList.get(0).groups.excludeGroupsBelowPercent.include ? "True" : "False")
				+ ", " + typedList.get(0).groups.excludeGroupsBelowPercent.operatorEnum;
				
				return typedList.get(0).groups.excludeGroupsBelowPercent.include == ele.bool
						&& (CSREnums.OperatorType.valueOf(mapping[ele.dropDownIndex]).equals(typedList.get(0).groups.excludeGroupsBelowPercent.operatorEnum));
			};
	ElementValidationInterface filterNumVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.excludeGroupsBelowPercent.include ? "True" : "False")
						+ ", " + typedList.get(0).groups.excludeGroupsBelowPercent.value;
				
				return (typedList.get(0).groups.excludeGroupsBelowPercent.include == ele.bool)
						&& (Integer.parseInt(ele.txtValue) == (typedList.get(0).groups.excludeGroupsBelowPercent.value));
			};
	ElementValidationInterface deleteSingleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.excludeSinglePitGroups ? "True" : "False");
				
				return (typedList.get(0).groups.excludeSinglePitGroups == ele.bool);
			};
	ElementValidationInterface failedInteractVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.includeFailedSensorInDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).groups.includeFailedSensorInDescription.value;
				
				return (typedList.get(0).groups.includeFailedSensorInDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).groups.includeFailedSensorInDescription.value));
			};
			
			
	ElementValidationInterface sleevesRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"DO_NOT_INCLUDE", "INHERIT_LABELS_PROPERTIES_FROM_DEEPEST", "CUSTOM_RULES"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).groups.groupsUnderRepairs.sleeves.repairsUnderType.toString();
				
				return RepairsUnderType.valueOf(ele.expectedValue).equals(typedList.get(0).groups.groupsUnderRepairs.sleeves.repairsUnderType);
			};
	ElementValidationInterface sleevesTextVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= typedList.get(0).groups.groupsUnderRepairs.sleeves.customFormat;
				
				return ele.txtValue.equals(typedList.get(0).groups.groupsUnderRepairs.sleeves.customFormat);
			};
	ElementValidationInterface compRRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"DO_NOT_INCLUDE", "INHERIT_LABELS_PROPERTIES_FROM_DEEPEST", "CUSTOM_RULES"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).groups.groupsUnderRepairs.compositeRepairs.repairsUnderType.toString();
				
				return RepairsUnderType.valueOf(ele.expectedValue).equals(typedList.get(0).groups.groupsUnderRepairs.compositeRepairs.repairsUnderType);
			};
	ElementValidationInterface compRTextVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= typedList.get(0).groups.groupsUnderRepairs.compositeRepairs.customFormat;
				
				return ele.txtValue.equals(typedList.get(0).groups.groupsUnderRepairs.compositeRepairs.customFormat);
			};
	ElementValidationInterface patchesRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"DO_NOT_INCLUDE", "INHERIT_LABELS_PROPERTIES_FROM_DEEPEST", "CUSTOM_RULES"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).groups.groupsUnderRepairs.patches.repairsUnderType.toString();
				
				return RepairsUnderType.valueOf(ele.expectedValue).equals(typedList.get(0).groups.groupsUnderRepairs.patches.repairsUnderType);
			};
	ElementValidationInterface patchesTextVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= typedList.get(0).groups.groupsUnderRepairs.patches.customFormat;
				
				return ele.txtValue.equals(typedList.get(0).groups.groupsUnderRepairs.patches.customFormat);
			};
	ElementValidationInterface halfSRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"DO_NOT_INCLUDE", "INHERIT_LABELS_PROPERTIES_FROM_DEEPEST", "CUSTOM_RULES"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).groups.groupsUnderRepairs.halfSoles.repairsUnderType.toString();
				
				return RepairsUnderType.valueOf(ele.expectedValue).equals(typedList.get(0).groups.groupsUnderRepairs.halfSoles.repairsUnderType);
			};
	ElementValidationInterface halfSTextVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= typedList.get(0).groups.groupsUnderRepairs.halfSoles.customFormat;
				
				return ele.txtValue.equals(typedList.get(0).groups.groupsUnderRepairs.halfSoles.customFormat);
			};
	ElementValidationInterface weldEndRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"DO_NOT_INCLUDE", "INHERIT_LABELS_PROPERTIES_FROM_DEEPEST", "CUSTOM_RULES"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).groups.groupsUnderRepairs.weldPlusEnd.repairsUnderType.toString();
				
				return RepairsUnderType.valueOf(ele.expectedValue).equals(typedList.get(0).groups.groupsUnderRepairs.weldPlusEnd.repairsUnderType);
			};
	ElementValidationInterface weldEndTextVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= typedList.get(0).groups.groupsUnderRepairs.weldPlusEnd.customFormat;
				
				return ele.txtValue.equals(typedList.get(0).groups.groupsUnderRepairs.weldPlusEnd.customFormat);
			};
	ElementValidationInterface clampsRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"DO_NOT_INCLUDE", "INHERIT_LABELS_PROPERTIES_FROM_DEEPEST", "CUSTOM_RULES"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).groups.groupsUnderRepairs.clamps.repairsUnderType.toString();
				
				return RepairsUnderType.valueOf(ele.expectedValue).equals(typedList.get(0).groups.groupsUnderRepairs.clamps.repairsUnderType);
			};
	ElementValidationInterface clampsTextVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= typedList.get(0).groups.groupsUnderRepairs.clamps.customFormat;
				
				return ele.txtValue.equals(typedList.get(0).groups.groupsUnderRepairs.clamps.customFormat);
			};
	ElementValidationInterface recoatsRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"DO_NOT_INCLUDE", "INHERIT_LABELS_PROPERTIES_FROM_DEEPEST", "CUSTOM_RULES"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).groups.groupsUnderRepairs.recoats.repairsUnderType.toString();
				
				return RepairsUnderType.valueOf(ele.expectedValue).equals(typedList.get(0).groups.groupsUnderRepairs.recoats.repairsUnderType);
			};
	ElementValidationInterface recoatsTextVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= typedList.get(0).groups.groupsUnderRepairs.recoats.customFormat;
				
				return ele.txtValue.equals(typedList.get(0).groups.groupsUnderRepairs.recoats.customFormat);
			};
	ElementValidationInterface genRRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"DO_NOT_INCLUDE", "INHERIT_LABELS_PROPERTIES_FROM_DEEPEST", "CUSTOM_RULES"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).groups.groupsUnderRepairs.genericRepairs.repairsUnderType.toString();
				
				return RepairsUnderType.valueOf(ele.expectedValue).equals(typedList.get(0).groups.groupsUnderRepairs.genericRepairs.repairsUnderType);
			};
	ElementValidationInterface genRTextVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= typedList.get(0).groups.groupsUnderRepairs.genericRepairs.customFormat;
				
				return ele.txtValue.equals(typedList.get(0).groups.groupsUnderRepairs.genericRepairs.customFormat);
			};
			
			
	ElementValidationInterface inheritPMDVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.groupsNotUnderRepairs.inheritPMDDescriptions ? "True" : "False");
				
				return (typedList.get(0).groups.groupsNotUnderRepairs.inheritPMDDescriptions == ele.bool);
			};
	ElementValidationInterface inheritRepairVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.groupsNotUnderRepairs.inheritRepairInfoDescriptions ? "True" : "False");
				
				return (typedList.get(0).groups.groupsNotUnderRepairs.inheritRepairInfoDescriptions == ele.bool);
					};
	ElementValidationInterface inheritIDODVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.groupsNotUnderRepairs.inheritIDODDescriptions ? "True" : "False");
				
				return (typedList.get(0).groups.groupsNotUnderRepairs.inheritIDODDescriptions == ele.bool);
			};
	ElementValidationInterface inheritPitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.groupsNotUnderRepairs.inheritPitDescriptions ? "True" : "False");
				
				return (typedList.get(0).groups.groupsNotUnderRepairs.inheritPitDescriptions == ele.bool);
			};
	ElementValidationInterface inheritWeldVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.groupsNotUnderRepairs.inheritWeldDescriptions ? "True" : "False");
				
				return (typedList.get(0).groups.groupsNotUnderRepairs.inheritWeldDescriptions == ele.bool);
			};
	ElementValidationInterface inheritPitsDentVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.groupsNotUnderRepairs.inheritPitDentDescriptions ? "True" : "False");
				
				return (typedList.get(0).groups.groupsNotUnderRepairs.inheritPitDentDescriptions == ele.bool);
			};
	ElementValidationInterface inheritInteractionVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.groupsNotUnderRepairs.inheritInteractionDescriptions ? "True" : "False");
				
				return (typedList.get(0).groups.groupsNotUnderRepairs.inheritInteractionDescriptions == ele.bool);
			};
	ElementValidationInterface inheritInSeamVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.groupsNotUnderRepairs.inheritInSeamDescriptions ? "True" : "False");
				
				return (typedList.get(0).groups.groupsNotUnderRepairs.inheritInSeamDescriptions == ele.bool);
			};
			
	ElementValidationInterface MFGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				String[] mapping = {"MFG Group", "Pipe Mill Anomaly Cluster (MiAC)"};
				
				ele.expectedValue = "True, " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
				= (typedList.get(0).groups.addLabelToMFGGroups.include ? "True" : "False")
					+ ", " + typedList.get(0).groups.addLabelToMFGGroups.value;
		
				return typedList.get(0).groups.addLabelToMFGGroups.include == ele.bool
						&& (mapping[ele.dropDownIndex].equals(typedList.get(0).groups.addLabelToMFGGroups.value));
			};
			
	ElementValidationInterface incOverspeedDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
				= (typedList.get(0).groups.degradedConditionsDescription.overspeed.include ? "True" : "False")
				+ ", " + typedList.get(0).groups.degradedConditionsDescription.overspeed.value;
				
				return (typedList.get(0).groups.degradedConditionsDescription.overspeed.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).groups.degradedConditionsDescription.overspeed.value));
			};
	ElementValidationInterface incDegradedDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
				= (typedList.get(0).groups.degradedConditionsDescription.degradedSensors.include ? "True" : "False")
				+ ", " + typedList.get(0).groups.degradedConditionsDescription.degradedSensors.value;
				
				return (typedList.get(0).groups.degradedConditionsDescription.degradedSensors.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).groups.degradedConditionsDescription.degradedSensors.value));
			};
	ElementValidationInterface incDegOverDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
				= (typedList.get(0).groups.degradedConditionsDescription.degradedSensorsAndOverspeed.include ? "True" : "False")
				+ ", " + typedList.get(0).groups.degradedConditionsDescription.degradedSensorsAndOverspeed.value;
				
				return (typedList.get(0).groups.degradedConditionsDescription.degradedSensorsAndOverspeed.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).groups.degradedConditionsDescription.degradedSensorsAndOverspeed.value));
			};
	ElementValidationInterface incBeyondDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
				= (typedList.get(0).groups.degradedConditionsDescription.degradedSensorsBeyondSpec.include ? "True" : "False")
				+ ", " + typedList.get(0).groups.degradedConditionsDescription.degradedSensorsBeyondSpec.value;
				
				return (typedList.get(0).groups.degradedConditionsDescription.degradedSensorsBeyondSpec.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).groups.degradedConditionsDescription.degradedSensorsBeyondSpec.value));
			};
	ElementValidationInterface inOverBeyondDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
				= (typedList.get(0).groups.degradedConditionsDescription.overspeedBeyondSpec.include ? "True" : "False")
				+ ", " + typedList.get(0).groups.degradedConditionsDescription.overspeedBeyondSpec.value;
				
				return (typedList.get(0).groups.degradedConditionsDescription.overspeedBeyondSpec.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).groups.degradedConditionsDescription.overspeedBeyondSpec.value));
			};
	ElementValidationInterface incOverSensorBeyondDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
				= (typedList.get(0).groups.degradedConditionsDescription.degradedSensorsAndOverspeedBeyondSpec.include ? "True" : "False")
				+ ", " + typedList.get(0).groups.degradedConditionsDescription.degradedSensorsAndOverspeedBeyondSpec.value;
				
				return (typedList.get(0).groups.degradedConditionsDescription.degradedSensorsAndOverspeedBeyondSpec.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).groups.degradedConditionsDescription.degradedSensorsAndOverspeedBeyondSpec.value));
			};
			
			
			
	ElementValidationInterface componentListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues
						= typedList.get(0).groups.componentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(1).separatorSpacing
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(2).component
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(2).separator
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(2).separatorSpacing
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(3).component
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(3).separator
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(3).separatorSpacing
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(4).component
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(4).separator
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(4).separatorSpacing
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(5).component
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(5).separator
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(5).separatorSpacing
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(6).component
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(6).separator
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(6).separatorSpacing
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(7).component
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(7).separator
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(7).separatorSpacing
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(8).component
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(8).separator
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(8).separatorSpacing
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(9).component
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(9).separator
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(9).separatorSpacing
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(10).component
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(10).separator
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(10).separatorSpacing
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(11).component
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(11).separator
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(11).separatorSpacing
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(12).component
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(12).separator
						+ ", " + typedList.get(0).groups.componentsOrder.hashtable.get(12).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).groups.componentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).groups.componentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).groups.componentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).groups.componentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).groups.componentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).groups.componentsOrder.hashtable.get(1).separatorSpacing.toString()))
				&& (ele.validationStrings.get(6).equals(typedList.get(0).groups.componentsOrder.hashtable.get(2).component))
				&& (ele.validationStrings.get(7) == null || ele.validationStrings.get(7).equals(typedList.get(0).groups.componentsOrder.hashtable.get(2).separator.toString()))
				&& (ele.validationStrings.get(8) == null || ele.validationStrings.get(8).equals(typedList.get(0).groups.componentsOrder.hashtable.get(2).separatorSpacing.toString()))
				&& (ele.validationStrings.get(9).equals(typedList.get(0).groups.componentsOrder.hashtable.get(3).component))
				&& (ele.validationStrings.get(10) == null || ele.validationStrings.get(10).equals(typedList.get(0).groups.componentsOrder.hashtable.get(3).separator.toString()))
				&& (ele.validationStrings.get(11) == null || ele.validationStrings.get(11).equals(typedList.get(0).groups.componentsOrder.hashtable.get(3).separatorSpacing.toString()))
				&& (ele.validationStrings.get(12).equals(typedList.get(0).groups.componentsOrder.hashtable.get(4).component))
				&& (ele.validationStrings.get(13) == null || ele.validationStrings.get(13).equals(typedList.get(0).groups.componentsOrder.hashtable.get(4).separator.toString()))
				&& (ele.validationStrings.get(14) == null || ele.validationStrings.get(14).equals(typedList.get(0).groups.componentsOrder.hashtable.get(4).separatorSpacing.toString()))
				&& (ele.validationStrings.get(15).equals(typedList.get(0).groups.componentsOrder.hashtable.get(5).component))
				&& (ele.validationStrings.get(16) == null || ele.validationStrings.get(16).equals(typedList.get(0).groups.componentsOrder.hashtable.get(5).separator.toString()))
				&& (ele.validationStrings.get(17) == null || ele.validationStrings.get(17).equals(typedList.get(0).groups.componentsOrder.hashtable.get(5).separatorSpacing.toString()))
				&& (ele.validationStrings.get(18).equals(typedList.get(0).groups.componentsOrder.hashtable.get(6).component))
				&& (ele.validationStrings.get(19) == null || ele.validationStrings.get(19).equals(typedList.get(0).groups.componentsOrder.hashtable.get(6).separator.toString()))
				&& (ele.validationStrings.get(20) == null || ele.validationStrings.get(20).equals(typedList.get(0).groups.componentsOrder.hashtable.get(6).separatorSpacing.toString()))
				&& (ele.validationStrings.get(21).equals(typedList.get(0).groups.componentsOrder.hashtable.get(7).component))
				&& (ele.validationStrings.get(22) == null || ele.validationStrings.get(22).equals(typedList.get(0).groups.componentsOrder.hashtable.get(7).separator.toString()))
				&& (ele.validationStrings.get(23) == null || ele.validationStrings.get(23).equals(typedList.get(0).groups.componentsOrder.hashtable.get(7).separatorSpacing.toString()))
				&& (ele.validationStrings.get(24).equals(typedList.get(0).groups.componentsOrder.hashtable.get(8).component))
				&& (ele.validationStrings.get(25) == null || ele.validationStrings.get(25).equals(typedList.get(0).groups.componentsOrder.hashtable.get(8).separator.toString()))
				&& (ele.validationStrings.get(26) == null || ele.validationStrings.get(26).equals(typedList.get(0).groups.componentsOrder.hashtable.get(8).separatorSpacing.toString()))
				&& (ele.validationStrings.get(27).equals(typedList.get(0).groups.componentsOrder.hashtable.get(9).component))
				&& (ele.validationStrings.get(28) == null || ele.validationStrings.get(28).equals(typedList.get(0).groups.componentsOrder.hashtable.get(9).separator.toString()))
				&& (ele.validationStrings.get(29) == null || ele.validationStrings.get(29).equals(typedList.get(0).groups.componentsOrder.hashtable.get(9).separatorSpacing.toString()))
				&& (ele.validationStrings.get(30).equals(typedList.get(0).groups.componentsOrder.hashtable.get(10).component))
				&& (ele.validationStrings.get(31) == null || ele.validationStrings.get(31).equals(typedList.get(0).groups.componentsOrder.hashtable.get(10).separator.toString()))
				&& (ele.validationStrings.get(32) == null || ele.validationStrings.get(32).equals(typedList.get(0).groups.componentsOrder.hashtable.get(10).separatorSpacing.toString()))
				&& (ele.validationStrings.get(33).equals(typedList.get(0).groups.componentsOrder.hashtable.get(11).component))
				&& (ele.validationStrings.get(34) == null || ele.validationStrings.get(34).equals(typedList.get(0).groups.componentsOrder.hashtable.get(11).separator.toString()))
				&& (ele.validationStrings.get(35) == null || ele.validationStrings.get(35).equals(typedList.get(0).groups.componentsOrder.hashtable.get(11).separatorSpacing.toString()))
				&& (ele.validationStrings.get(36).equals(typedList.get(0).groups.componentsOrder.hashtable.get(12).component))
				&& (ele.validationStrings.get(37) == null || ele.validationStrings.get(37).equals(typedList.get(0).groups.componentsOrder.hashtable.get(12).separator.toString()))
				&& (ele.validationStrings.get(38) == null || ele.validationStrings.get(38).equals(typedList.get(0).groups.componentsOrder.hashtable.get(12).separatorSpacing.toString()));
			};
			
			
	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= typedList.get(0).groups.ai.additionalNotes;
				
				return ele.txtValue.equals(typedList.get(0).groups.ai.additionalNotes);
			};
	ElementValidationInterface examplesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= typedList.get(0).groups.ai.examples;
				
				return ele.txtValue.equals(typedList.get(0).groups.ai.examples);
			};
	ElementValidationInterface processGroupVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<MetalLoss> typedList = (List<MetalLoss>) list;
				
				ele.returnedValues 
						= (typedList.get(0).groups.ai.includeProcessGroupInteraction ? "True" : "False");
				
				return (typedList.get(0).groups.ai.includeProcessGroupInteraction == ele.bool);
			};
	
			
			
	public List<String> componentPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Interaction Info");
		cPL.add("Mill Anomaly Discrimination");
		cPL.add("Failed Sensor Interaction");
		cPL.add("Repair Label");
		cPL.add("Dig/Repair Info");
		
		return cPL;
	}
	
	/**
	 * Used to handle and cleanup the instancing of the Groups Under Repairs list.
	 * Appends the Instruction to the elements list.
	 * Make sure you set elements = result or the change will be lost.
	 * 
	 * If selection == 2 and customDescription == null, no change will be made to the text field.
	 * 
	 * @param driver
	 * @param selection Which selection to use.
	 * @param customDescription If selection = 2, this is used to fill the text field. May be null otherwise.
	 * @param instance The instance of this particular radio group.
	 * @throws Exception
	 */
	private List<UIElements> addGroupUnderRepairs(WebDriver driver, List<UIElements> elements, int selection, String customDescription, int instance, 
			ElementValidationInterface radioVal, ElementValidationInterface textVal) throws Exception {
		//Set to desired selection
		elements.add(new RGElement(driver, radioVal, "repairsUnderType_rg", selection));
		elements.get(elements.size() - 1).setDesiredInstance(instance);
		
		//If 'Custom reporting for Groups:' is selected, add the text field element
		if(selection == 2 && customDescription != null)
		{
			elements.add(new TextElement(driver, textVal, "propertyWithUpdates_grw", customDescription));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
		}
		
		return elements;
	}
	

	@ParameterizedTest
	@ValueSource(strings = {"Groups_1.json", "Groups_2.json"})
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
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-metal_loss-groups&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
			
		//General Section
		elements.add(new ClickExpansionPanel(driver, "general_gr"));
		elements.add(new ClickExpansionPanel(driver, "legacy_gr"));
		elements.add(new ClickExpansionPanel(driver, "mds_gr"));
		elements.add(new SelectElement(driver, legacyPressureVal, "pressureAlgorithms_s", argumentFile.defaultValues.defaultSelectValue));
		elements.add(new SelectElement(driver, legacyInteractionVal, "groupingRules_s", argumentFile.defaultValues.defaultSelectValue));
		elements.add(new SelectElement(driver, legacyPitLengthVal, "pitLengthType_s", argumentFile.defaultValues.defaultSelectValue));
		elements.add(new CBElement(driver, legacyWeldsVal, "includingAcrossWelds_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, legacyWTVal, "includeAcrossWT_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, legacyIntExtVal, "groupInternalExternal_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, legacyReturnVal, "effectiveArea_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, legacyEAMVal, "smartEAM_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, legacyRepDigVal, "addRepairDigInfoToDesc_cb", true));
		elements.add(new CBListElement(driver, legacyCBLVal, "pitTypesToGroup_ms", argumentFile.defaultValues.CBLVal));
		
		elements.add(new SelectElement(driver, MDSPressureVal, "pressureAlgorithms_mds_s", argumentFile.defaultValues.defaultSelectValue));
		elements.add(new SelectElement(driver, MDSInteractionVal, "groupingRules_mds_s", argumentFile.defaultValues.defaultSelectValue));
		elements.add(new SelectElement(driver, MDSPitLengthVal, "pitLengthType_mds_s", argumentFile.defaultValues.defaultSelectValue));
		elements.add(new CBElement(driver, MDSWeldsVal, "includingAcrossWelds_mds_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, MDSWTVal, "includeAcrossWT_mds_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, MDSIntExtVal, "groupInternalExternal_mds_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, MDSReturnVal, "effectiveArea_mds_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, MDSEAMVal, "smartEAM_mds_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, MDSRepDigVal, "addRepairDigInfoToDesc_mds_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBListElement(driver, MDSCBLVal, "pitTypesToGroup_mds_ms", argumentFile.defaultValues.CBLVal));
		
		elements.add(new IWVElement(driver, excludePitsVal, "excludePitsBelowPercent_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new CBElement(driver, groupTogetherVal, "groupRepairedAndNon_cb", argumentFile.defaultValues.includeCB));
		boolean filterDepths = argumentFile.defaultValues.includeIWVorIWVS;
		elements.add(new IWVElement(driver, filterNumVal, "excludeGroupsBelowPercent_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), filterDepths));
		elements.add(new IWVSElement(driver, filterUnitVal, "excludeGroupsBelowPercent_iwv", argumentFile.defaultValues.defaultIWVSValue, filterDepths));
		elements.add(new CBElement(driver, deleteSingleVal, "excludeSinglePit_cb", argumentFile.defaultValues.includeCB));
		elements.add(new IWVElement(driver, failedInteractVal, "includeFailedSensor_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		
		//Groups Under Repairs
		elements.add(new OpenExpansionPanels(driver, null, "attributeSizingTopL_gr", new int[] {0, 1, 2, 3, 4, 5, 6, 7}));
		elements = addGroupUnderRepairs(driver, elements, argumentFile.defaultValues.defaultRGValues, argumentFile.defaultValues.defaultTextValue, 0, sleevesRGVal, sleevesTextVal);
		elements = addGroupUnderRepairs(driver, elements, argumentFile.defaultValues.defaultRGValues, argumentFile.defaultValues.defaultTextValue, 1, compRRGVal, compRTextVal);
		elements = addGroupUnderRepairs(driver, elements, argumentFile.defaultValues.defaultRGValues, argumentFile.defaultValues.defaultTextValue, 2, patchesRGVal, patchesTextVal);
		elements = addGroupUnderRepairs(driver, elements, argumentFile.defaultValues.defaultRGValues, argumentFile.defaultValues.defaultTextValue, 3, halfSRGVal, halfSTextVal);
		elements = addGroupUnderRepairs(driver, elements, argumentFile.defaultValues.defaultRGValues, argumentFile.defaultValues.defaultTextValue, 4, weldEndRGVal, weldEndTextVal);
		elements = addGroupUnderRepairs(driver, elements, argumentFile.defaultValues.defaultRGValues, argumentFile.defaultValues.defaultTextValue, 5, clampsRGVal, clampsTextVal);
		elements = addGroupUnderRepairs(driver, elements, argumentFile.defaultValues.defaultRGValues, argumentFile.defaultValues.defaultTextValue, 6, recoatsRGVal, recoatsTextVal);
		elements = addGroupUnderRepairs(driver, elements, argumentFile.defaultValues.defaultRGValues, argumentFile.defaultValues.defaultTextValue, 7, genRRGVal, genRTextVal);
		
		//Not Under Repairs
		elements.add(new CBElement(driver, inheritPMDVal, "inheritPMDDescriptions_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, inheritRepairVal, "inheritRepairInfoDescriptions_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, inheritIDODVal, "inheritIDODDescriptions_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, inheritPitVal, "inheritPitDescriptions_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, inheritWeldVal, "inheritWeldDescriptions_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, inheritPitsDentVal, "inheritPitDentDescriptions_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, inheritInteractionVal, "inheritInteractionDescriptions_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, inheritInSeamVal, "inheritInSeamDescriptions_cb", argumentFile.defaultValues.includeCB));
		
		elements.add(new IWVElement(driver, incOverspeedDescVal, "overspeed_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, incDegradedDescVal, "degradedSensors_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, incDegOverDescVal, "degradedSensorsAndOverspeed_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, incBeyondDescVal, "degradedSensorsBeyondSpec_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, inOverBeyondDescVal, "overspeedBeyondSpec_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, incOverSensorBeyondDescVal, "degradedSensorsAndOverspeedBeyondSpec_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		
		//Mill Anomalies/Groups Components
		elements.add(new IWVSElement(driver, MFGVal, "labelMFGGroups_iwvs", argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new DragBoggleElement(driver, componentListVal, "componentsOrder_cl", argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
		
		//General Groups Marking
		elements.add(new TextElement(driver, deviationsVal, "includingAdditional_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, examplesVal, "examples_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new CBElement(driver, processGroupVal, "processGroupInteraction_cb", argumentFile.defaultValues.includeCB));
		
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
		compTest.compaireDB(elements, "Groups", tables.METAL_LOSS, "GroupsResults", argumentFile.FileCounter);
	}
}