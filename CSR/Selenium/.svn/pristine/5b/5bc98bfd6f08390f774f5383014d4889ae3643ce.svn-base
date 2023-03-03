package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.CSREnums.DentsMarkAsRepairedType;
import com.tdw.csr.entity.CSREnums.ReportType;
import com.tdw.csr.entity.CSREnums.ReportingRoundType;
import com.tdw.csr.entity.CSREnums.Standard;
import com.tdw.csr.entity.casings.Casings;
import com.tdw.csr.entity.CSREnums;
import com.tdw.csr.dao.DentsDAO;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.deformations.Deformations;
import com.tdw.csr.entity.deformations.dents.*;

import chromedriver.CompaireDB.tables;
import chromedriver.UIElements.*;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.DoubleToIntFunction;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DentsCDTest extends BaseCDTest {


	ElementValidationInterface diamRefVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] mapping = {"APS", "NPS"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).pipeDiameterReference;
				
				return (ele.expectedValue.equals(typedList.get(0).pipeDiameterReference));
			};
	ElementValidationInterface dentOvalVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= Double.toString(typedList.get(0).dentDepthOvalityAdjustment);
				
				return (Double.parseDouble(ele.txtValue) == (typedList.get(0).dentDepthOvalityAdjustment));
			};
	ElementValidationInterface repDecVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] mapping = {"0", "1", "2", "3"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= Double.toString(typedList.get(0).reportingDepthPrecision);
				
				return (Double.parseDouble(ele.expectedValue) == (typedList.get(0).reportingDepthPrecision));
			};
	ElementValidationInterface roundVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] mapping = {"ROUND", "TRUNCATE"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).reportingDepthRoundType.toString();
				
				return (ReportingRoundType.valueOf(ele.expectedValue).equals(typedList.get(0).reportingDepthRoundType));
			};
	ElementValidationInterface dentIntVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).includeFailedSensorInDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).includeFailedSensorInDescription.value;
				
				return (typedList.get(0).includeFailedSensorInDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).includeFailedSensorInDescription.value));
			};
	ElementValidationInterface appendGougeVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).appendLabelToDescriptionWhenDentClassifiedAsGouge.include ? "True" : "False")
						+ ", " + typedList.get(0).appendLabelToDescriptionWhenDentClassifiedAsGouge.value;
				
				return (typedList.get(0).appendLabelToDescriptionWhenDentClassifiedAsGouge.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).appendLabelToDescriptionWhenDentClassifiedAsGouge.value));
			};
	ElementValidationInterface capFirstVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).captializeFirstOnly ? "True" : "False");
				
				return (typedList.get(0).captializeFirstOnly == ele.bool);
			};
			
			
	ElementValidationInterface incClassVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsClassification.includeClassification ? "True" : "False");
				
				return (typedList.get(0).dentsClassification.includeClassification == ele.bool);
			};
	ElementValidationInterface labelDEFVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsClassification.addLabelToDescriptionDEF.include ? "True" : "False")
						+ ", " + typedList.get(0).dentsClassification.addLabelToDescriptionDEF.value;
				
				return (typedList.get(0).dentsClassification.addLabelToDescriptionDEF.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).dentsClassification.addLabelToDescriptionDEF.value));
			};
	ElementValidationInterface labelComboVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsClassification.addLabelToDescriptionCombo.include ? "True" : "False")
						+ ", " + typedList.get(0).dentsClassification.addLabelToDescriptionCombo.value;
				
				return (typedList.get(0).dentsClassification.addLabelToDescriptionCombo.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).dentsClassification.addLabelToDescriptionCombo.value));
			};
	ElementValidationInterface labelMDSVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsClassification.addLabelToDescriptionMDS.include ? "True" : "False")
						+ ", " + typedList.get(0).dentsClassification.addLabelToDescriptionMDS.value;
				
				return (typedList.get(0).dentsClassification.addLabelToDescriptionMDS.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).dentsClassification.addLabelToDescriptionMDS.value));
			};
	ElementValidationInterface underSpecGEQVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsClassification.setUnderSpecPropertyGreaterThanLessThan.include ? "True" : "False") 
						+ ", " + Double.toString(typedList.get(0).dentsClassification.setUnderSpecPropertyGreaterThanLessThan.value1);
				
				return (typedList.get(0).dentsClassification.setUnderSpecPropertyGreaterThanLessThan.include == ele.bool) && 
						(Double.parseDouble(ele.txtValue) == (typedList.get(0).dentsClassification.setUnderSpecPropertyGreaterThanLessThan.value1));
			};
	ElementValidationInterface depthRulesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] toolSizeMap = {"ANY", "FOUR", "SIX", "EIGHT", "TEN", "TWELVE", "FOURTEEN", "SIXTEEN", "TWENTY", "TWENTYTWO", "TWENTYFOUR", "TWENTYSIX", "TWENTYEIGHT", "THIRTY", "THIRTYSIX", "FOURTYTWO", "FOURTYEIGHT"};
				String[] toolSizeAndMap = {"BLANK", "AND_ABOVE", "AND_BELOW"};
				String[] toolSizeUnitMap = {"in.", "mm", "%"};
				
				ele.expectedValue = toolSizeMap[ele.controlIndices[0]] + ", " + toolSizeAndMap[ele.controlIndices[1]] + ", " + ele.txtValue + ", " + toolSizeUnitMap[ele.controlIndices[2]];
				
				ele.returnedValues = typedList.get(0).dentsReporting.reportingFilters.rules.get(0).pipeSizeSelection.toString()
						+ ", " + typedList.get(0).dentsReporting.reportingFilters.rules.get(0).conditional.toString()
						+ ", " + typedList.get(0).dentsReporting.reportingFilters.rules.get(0).value
						+ ", " + typedList.get(0).dentsReporting.reportingFilters.rules.get(0).units;
				
				//Comparison
				boolean pass = true;
				
				if(!CSREnums.DentReportingPipeSize.valueOf(toolSizeMap[ele.controlIndices[0]]).equals(typedList.get(0).dentsReporting.reportingFilters.rules.get(0).pipeSizeSelection)
				  || !CSREnums.DentReportingConditional.valueOf(toolSizeAndMap[ele.controlIndices[1]]).equals(typedList.get(0).dentsReporting.reportingFilters.rules.get(0).conditional)
				  || Double.parseDouble(ele.txtValue) != (typedList.get(0).dentsReporting.reportingFilters.rules.get(0).value)
				  || !toolSizeUnitMap[ele.controlIndices[2]].equals(typedList.get(0).dentsReporting.reportingFilters.rules.get(0).units))
				{
					pass = false;					
				}
				
				
				return pass;
			};
	ElementValidationInterface underSpecLessVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= Double.toString(typedList.get(0).dentsClassification.setUnderSpecPropertyGreaterThanLessThan.value2);
				
				return (Double.parseDouble(ele.txtValue) == (typedList.get(0).dentsClassification.setUnderSpecPropertyGreaterThanLessThan.value2));
			};
	ElementValidationInterface notClassVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsClassification.includeDoNotClassifyUnderSpecInAssociationWithMFL ? "True" : "False");
				
				return (typedList.get(0).dentsClassification.includeDoNotClassifyUnderSpecInAssociationWithMFL == ele.bool);
			};
	ElementValidationInterface appendUnderspecVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsClassification.appendLabelToDescriptionOnUnderSpecDents.include ? "True" : "False")
						+ ", " + typedList.get(0).dentsClassification.appendLabelToDescriptionOnUnderSpecDents.value;
				
				return (typedList.get(0).dentsClassification.appendLabelToDescriptionOnUnderSpecDents.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).dentsClassification.appendLabelToDescriptionOnUnderSpecDents.value));
			};
	ElementValidationInterface topPipeBotVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsClassification.setOnTopofPipePropertyWhenOrientationIsBetween.include ? "True" : "False")
						+ ", " + Double.toString(typedList.get(0).dentsClassification.setOnTopofPipePropertyWhenOrientationIsBetween.value1);
				
				return (typedList.get(0).dentsClassification.setOnTopofPipePropertyWhenOrientationIsBetween.include == ele.bool) 
						&& (Double.parseDouble(ele.txtValue) == (typedList.get(0).dentsClassification.setOnTopofPipePropertyWhenOrientationIsBetween.value1));
			};
	ElementValidationInterface topPipeTopVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= Double.toString(typedList.get(0).dentsClassification.setOnTopofPipePropertyWhenOrientationIsBetween.value2);
				
				return (Double.parseDouble(ele.txtValue) == (typedList.get(0).dentsClassification.setOnTopofPipePropertyWhenOrientationIsBetween.value2));
			};
	ElementValidationInterface appendPMDVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsClassification.appendLabelToDescriptionOnPMDDents.include ? "True" : "False")
						+ ", " + typedList.get(0).dentsClassification.appendLabelToDescriptionOnPMDDents.value;
				
				return (typedList.get(0).dentsClassification.appendLabelToDescriptionOnPMDDents.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).dentsClassification.appendLabelToDescriptionOnPMDDents.value));
			};
	ElementValidationInterface appendReroundedVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsClassification.appendLabelToDescriptionOnReroundedDents.include ? "True" : "False")
						+ ", " + typedList.get(0).dentsClassification.appendLabelToDescriptionOnReroundedDents.value;
				
				return (typedList.get(0).dentsClassification.appendLabelToDescriptionOnReroundedDents.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).dentsClassification.appendLabelToDescriptionOnReroundedDents.value));
			};
	ElementValidationInterface appendStrainVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsClassification.includeDentStrain ? "True" : "False");
				
				return (typedList.get(0).dentsClassification.includeDentStrain == ele.bool);
			};
			
			
	ElementValidationInterface repUnderSpecVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsReporting.includeReportUnderSpecDents ? "True" : "False");
				
				return (typedList.get(0).dentsReporting.includeReportUnderSpecDents == ele.bool);
			};
	ElementValidationInterface repAllMLVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsReporting.alwaysReportDentsWithML ? "True" : "False");
				
				return (typedList.get(0).dentsReporting.alwaysReportDentsWithML == ele.bool);
			};
	ElementValidationInterface repAllTopVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsReporting.includeReportAllDentsOnTopOfPipe ? "True" : "False");
				
				return (typedList.get(0).dentsReporting.includeReportAllDentsOnTopOfPipe == ele.bool);
			};
	ElementValidationInterface appTopLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsReporting.appendLabelToDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).dentsReporting.appendLabelToDescription.value;
				
				return (typedList.get(0).dentsReporting.appendLabelToDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).dentsReporting.appendLabelToDescription.value));
			};
	ElementValidationInterface notRepUnderVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsReporting.includeDoNotReportDentsUnderCasings ? "True" : "False");
				
				return (typedList.get(0).dentsReporting.includeDoNotReportDentsUnderCasings == ele.bool);
			};
	ElementValidationInterface onlyRepRepairedVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsReporting.includeOnlyRepairedDescriptionShouldBeAdded ? "True" : "False");
				
				return (typedList.get(0).dentsReporting.includeOnlyRepairedDescriptionShouldBeAdded == ele.bool);
			};
	ElementValidationInterface repairDigVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsReporting.addRepairDigInfoToDesc ? "True" : "False");
				
				return (typedList.get(0).dentsReporting.addRepairDigInfoToDesc == ele.bool);
			};
	ElementValidationInterface addRepairDigVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.txtValue + ", " + ele.validationStrings;
				
				ele.returnedValues = (typedList.get(0).dentsReporting.addRepairDigInfoToDesc ? "True" : "False") + 
						", " + typedList.get(0).dentsReporting.formattingInfo.digRepairNumberFormat;
				
				//Hashtable size is dynamic
				for(int i = 0; i < ele.secondaryList.size(); i++) {
					ele.returnedValues += ", " + typedList.get(0).dentsReporting.formattingInfo.componentsOrder.hashtable.get(i);
				}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).dentsReporting.addRepairDigInfoToDesc == ele.tertiaryFlag
						&& typedList.get(0).dentsReporting.formattingInfo.digRepairNumberFormat.equals(ele.txtValue);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(i).equals(typedList.get(0).dentsReporting.formattingInfo.componentsOrder.hashtable.get(i));
				}
				
				return pass;
			};

			
			
	ElementValidationInterface appendLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsDetailedClassificationCriteria.includeAppendLabelsToDescription ? "True" : "False");
				
				return (typedList.get(0).dentsDetailedClassificationCriteria.includeAppendLabelsToDescription == ele.bool);
			};		
	ElementValidationInterface directMLVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= typedList.get(0).dentsDetailedClassificationCriteria.dentsWithDirectMLAssociation;
				
				return (ele.txtValue.equals(typedList.get(0).dentsDetailedClassificationCriteria.dentsWithDirectMLAssociation));
			};
	ElementValidationInterface coincidentalMLVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= typedList.get(0).dentsDetailedClassificationCriteria.dentsWithCoincidentalMLAssociation;
				
				return (ele.txtValue.equals(typedList.get(0).dentsDetailedClassificationCriteria.dentsWithCoincidentalMLAssociation));
			};
	ElementValidationInterface processMLVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsDetailedClassificationCriteria.includeProcessClassificationOfMLCustomArea ? "True" : "False");
				
				return (typedList.get(0).dentsDetailedClassificationCriteria.includeProcessClassificationOfMLCustomArea == ele.bool);
			};		
	ElementValidationInterface MLtxtVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= Double.toString(typedList.get(0).dentsDetailedClassificationCriteria.areaWithinOfDentBoundaries.value);
				
				return Double.parseDouble(ele.txtValue) == (typedList.get(0).dentsDetailedClassificationCriteria.areaWithinOfDentBoundaries.value);
			};
	ElementValidationInterface MLSelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] mapping = {"inch"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).dentsDetailedClassificationCriteria.areaWithinOfDentBoundaries.units;
				
				return (ele.expectedValue.equals(typedList.get(0).dentsDetailedClassificationCriteria.areaWithinOfDentBoundaries.units));
			};
	ElementValidationInterface MLLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] mapping = {"ML corrosion within +/- [area]"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).dentsDetailedClassificationCriteria.appendClassificationToDescription;
				
				return (ele.expectedValue.equals(typedList.get(0).dentsDetailedClassificationCriteria.appendClassificationToDescription));
			};
	ElementValidationInterface appMLDepthVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsDetailedClassificationCriteria.includeAppendMLDepthToDescription ? "True" : "False");
				
				return (typedList.get(0).dentsDetailedClassificationCriteria.includeAppendMLDepthToDescription == ele.bool);
			};	
		
			
	ElementValidationInterface procGWVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsDetailedClassificationCriteria.includeProcessGWIntegration ? "True" : "False");
				
				return (typedList.get(0).dentsDetailedClassificationCriteria.includeProcessGWIntegration == ele.bool);
			};		
	ElementValidationInterface radioGroupval = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] mapping = {"STANDARD_INTERACTION", "CUSTOM_INTERACTION"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).dentsDetailedClassificationCriteria.gwInteraction.toString();
				
				return CSREnums.GirthWeldInteration.valueOf(ele.expectedValue).equals(typedList.get(0).dentsDetailedClassificationCriteria.gwInteraction);
	};
	ElementValidationInterface MarkStdGWVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsDetailedClassificationCriteria.appendGWSILabelToDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).dentsDetailedClassificationCriteria.appendGWSILabelToDescription.value;
				
				return typedList.get(0).dentsDetailedClassificationCriteria.appendGWSILabelToDescription.include == ele.bool
						&& (ele.expectedValue.equals(typedList.get(0).dentsDetailedClassificationCriteria.appendGWSILabelToDescription.value));
			};
	ElementValidationInterface customNumVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= Double.toString(typedList.get(0).dentsDetailedClassificationCriteria.markGWCIBox.value);
				
				return Double.parseDouble(ele.expectedValue) == (typedList.get(0).dentsDetailedClassificationCriteria.markGWCIBox.value);
			};
	ElementValidationInterface customUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] mapping = {"inch"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).dentsDetailedClassificationCriteria.markGWCIBox.units;
				
				return (ele.expectedValue.equals(typedList.get(0).dentsDetailedClassificationCriteria.markGWCIBox.units));
			};
	ElementValidationInterface customLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsDetailedClassificationCriteria.appendGWCILabelToDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).dentsDetailedClassificationCriteria.appendGWCILabelToDescription.value;
				
				return typedList.get(0).dentsDetailedClassificationCriteria.appendGWCILabelToDescription.include == ele.bool
						&& (ele.txtValue.equals(typedList.get(0).dentsDetailedClassificationCriteria.appendGWCILabelToDescription.value));
			};
	ElementValidationInterface changeDentVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] mapping = {"Girth"};
				
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
				= (typedList.get(0).dentsDetailedClassificationCriteria.changeGWDentAssociation.include ? "True" : "False")
					+ ", " + typedList.get(0).dentsDetailedClassificationCriteria.changeGWDentAssociation.value;
		
				return typedList.get(0).dentsDetailedClassificationCriteria.changeGWDentAssociation.include == ele.bool
						&& (mapping[ele.dropDownIndex].equals(typedList.get(0).dentsDetailedClassificationCriteria.changeGWDentAssociation.value));
			};
	ElementValidationInterface appendGWLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
					= (typedList.get(0).dentsDetailedClassificationCriteria.appendManualGWILabelToDescription.include ? "True" : "False")
					+ ", " + typedList.get(0).dentsDetailedClassificationCriteria.appendManualGWILabelToDescription.value;
		
				return typedList.get(0).dentsDetailedClassificationCriteria.appendManualGWILabelToDescription.include == ele.bool
						&& (ele.txtValue.equals(typedList.get(0).dentsDetailedClassificationCriteria.appendManualGWILabelToDescription.value));
			};
	ElementValidationInterface appendSeamLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsDetailedClassificationCriteria.appendManualSWILabelToDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).dentsDetailedClassificationCriteria.appendManualSWILabelToDescription.value;
				
				return (typedList.get(0).dentsDetailedClassificationCriteria.appendManualSWILabelToDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).dentsDetailedClassificationCriteria.appendManualSWILabelToDescription.value));
			};
			
	ElementValidationInterface addLeftStoppleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsDetailedClassificationCriteria.addInteractionWithLeftEdgeStoppleToDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).dentsDetailedClassificationCriteria.addInteractionWithLeftEdgeStoppleToDescription.value;
				
				return (typedList.get(0).dentsDetailedClassificationCriteria.addInteractionWithLeftEdgeStoppleToDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).dentsDetailedClassificationCriteria.addInteractionWithLeftEdgeStoppleToDescription.value));
			};
	ElementValidationInterface addRightStoppleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsDetailedClassificationCriteria.addInteractionWithRightEdgeStoppleToDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).dentsDetailedClassificationCriteria.addInteractionWithRightEdgeStoppleToDescription.value;
				
				return (typedList.get(0).dentsDetailedClassificationCriteria.addInteractionWithRightEdgeStoppleToDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).dentsDetailedClassificationCriteria.addInteractionWithRightEdgeStoppleToDescription.value));
			};
			
	ElementValidationInterface OneDimIntVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsDetailedClassificationCriteria.includeAppendMultiApex ? "True" : "False");
				
				return (typedList.get(0).dentsDetailedClassificationCriteria.includeAppendMultiApex == ele.bool);
			};		
	ElementValidationInterface OneDimDentsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= typedList.get(0).dentsDetailedClassificationCriteria.dentsWithin1D;
				
				return (ele.expectedValue.equals(typedList.get(0).dentsDetailedClassificationCriteria.dentsWithin1D));
			};
	ElementValidationInterface OneDimUnderspecVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= typedList.get(0).dentsDetailedClassificationCriteria.underSpecDentsWithin1D;
				
				return (ele.expectedValue.equals(typedList.get(0).dentsDetailedClassificationCriteria.underSpecDentsWithin1D));
			};
	ElementValidationInterface MACheckedVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
				= typedList.get(0).dentsDetailedClassificationCriteria.dentsWithMultiApexUser;
				
				return (ele.expectedValue.equals(typedList.get(0).dentsDetailedClassificationCriteria.dentsWithMultiApexUser));
			};
	ElementValidationInterface prependMAVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).dentsDetailedClassificationCriteria.prependDentCount ? "True" : "False");
				
				return (typedList.get(0).dentsDetailedClassificationCriteria.prependDentCount == ele.bool);
			};		
			
			
	ElementValidationInterface dentAutoClassifyVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;

				//As the db hashtable is not necessarily in the same order as the checklist, a map is used.
				DentsMarkAsRepairedType[] mapping = {
						DentsMarkAsRepairedType.SLEEVES,
						DentsMarkAsRepairedType.COMPOSITE_REPAIRS,
						DentsMarkAsRepairedType.STOPPLES,
						DentsMarkAsRepairedType.PATCHES,
						DentsMarkAsRepairedType.HALF_SOLES,
						DentsMarkAsRepairedType.WELD_PLUS_END,
						DentsMarkAsRepairedType.RECOATS,
						DentsMarkAsRepairedType.GENERIC_REPAIRS
				};
				
				boolean allMatching = true;
				
				for(int i = 0; i < ele.controlIndices.length; i++)
				{
					DentsMarkAsRepairedType tkey = mapping[i];
					
					if(i != 0)
						ele.returnedValues += ", ";
					
					ele.returnedValues += (typedList.get(0).dentsUnderRepairs.markAsRepaired.hashtable.get(tkey) ? "True" : "False");
					
					if(typedList.get(0).dentsUnderRepairs.markAsRepaired.hashtable.get(tkey) != (ele.controlIndices[i] == 1 ? true : false))
						allMatching = false;
				}
				
				return allMatching;
			};	
			
	ElementValidationInterface repSleevesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).dentsUnderRepairs.sleeves.reportType.toString();
				
				return ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).dentsUnderRepairs.sleeves.reportType);
			};
	ElementValidationInterface labelSleevesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
				= (typedList.get(0).dentsUnderRepairs.sleeves.addLabelToDescription.include ? "True" : "False")
				+ ", " + typedList.get(0).dentsUnderRepairs.sleeves.addLabelToDescription.value;
				
				return (typedList.get(0).dentsUnderRepairs.sleeves.addLabelToDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).dentsUnderRepairs.sleeves.addLabelToDescription.value));
			};
	ElementValidationInterface addRepSleevesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.txtValue + ", " + ele.validationStrings;
				
				ele.returnedValues = (typedList.get(0).dentsUnderRepairs.sleeves.addRepairDigInfo ? "True" : "False") 
						+ ", " + typedList.get(0).dentsUnderRepairs.sleeves.formattingInfo.digRepairNumberFormat;
				
				//Hashtable size is dynamic
				for(int i = 0; i < ele.secondaryList.size(); i++) {
					ele.returnedValues += ", " + typedList.get(0).dentsUnderRepairs.sleeves.formattingInfo.componentsOrder.hashtable.get(i);
				}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).dentsUnderRepairs.sleeves.addRepairDigInfo == ele.tertiaryFlag
						&& typedList.get(0).dentsUnderRepairs.sleeves.formattingInfo.digRepairNumberFormat.equals(ele.txtValue);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(i).equals(typedList.get(0).dentsUnderRepairs.sleeves.formattingInfo.componentsOrder.hashtable.get(i));
				}
				
				return pass;
			};
			
	ElementValidationInterface repCompRVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).dentsUnderRepairs.compositeRepairs.reportType.toString();
				
				return ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).dentsUnderRepairs.compositeRepairs.reportType);
			};
	ElementValidationInterface labelCompRVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
				= (typedList.get(0).dentsUnderRepairs.compositeRepairs.addLabelToDescription.include ? "True" : "False")
				+ ", " + typedList.get(0).dentsUnderRepairs.compositeRepairs.addLabelToDescription.value;
				
				return (typedList.get(0).dentsUnderRepairs.compositeRepairs.addLabelToDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).dentsUnderRepairs.compositeRepairs.addLabelToDescription.value));
			};
	ElementValidationInterface addRepCompRVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.txtValue + ", " + ele.validationStrings;
				
				ele.returnedValues = (typedList.get(0).dentsUnderRepairs.compositeRepairs.addRepairDigInfo ? "True" : "False") 
						+ ", " + typedList.get(0).dentsUnderRepairs.compositeRepairs.formattingInfo.digRepairNumberFormat;
				
				//Hashtable size is dynamic
				for(int i = 0; i < ele.secondaryList.size(); i++) {
					ele.returnedValues += ", " + typedList.get(0).dentsUnderRepairs.compositeRepairs.formattingInfo.componentsOrder.hashtable.get(i);
				}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).dentsUnderRepairs.compositeRepairs.addRepairDigInfo == ele.tertiaryFlag
						&& typedList.get(0).dentsUnderRepairs.compositeRepairs.formattingInfo.digRepairNumberFormat.equals(ele.txtValue);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(i).equals(typedList.get(0).dentsUnderRepairs.compositeRepairs.formattingInfo.componentsOrder.hashtable.get(i));
				}
				
				return pass;
			};
			
	ElementValidationInterface repStopplesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).dentsUnderRepairs.stopples.reportType.toString();
				
				return ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).dentsUnderRepairs.stopples.reportType);
			};
	ElementValidationInterface labelStopplesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
				= (typedList.get(0).dentsUnderRepairs.stopples.addLabelToDescription.include ? "True" : "False")
				+ ", " + typedList.get(0).dentsUnderRepairs.stopples.addLabelToDescription.value;
				
				return (typedList.get(0).dentsUnderRepairs.stopples.addLabelToDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).dentsUnderRepairs.stopples.addLabelToDescription.value));
			};
	ElementValidationInterface addRepStopplesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.txtValue + ", " + ele.validationStrings;
				
				ele.returnedValues = (typedList.get(0).dentsUnderRepairs.stopples.addRepairDigInfo ? "True" : "False")
						+ ", " + typedList.get(0).dentsUnderRepairs.stopples.formattingInfo.digRepairNumberFormat;
				
				//Hashtable size is dynamic
				for(int i = 0; i < ele.secondaryList.size(); i++) {
					ele.returnedValues += ", " + typedList.get(0).dentsUnderRepairs.stopples.formattingInfo.componentsOrder.hashtable.get(i);
				}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).dentsUnderRepairs.stopples.addRepairDigInfo == ele.tertiaryFlag
						&& typedList.get(0).dentsUnderRepairs.stopples.formattingInfo.digRepairNumberFormat.equals(ele.txtValue);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(i).equals(typedList.get(0).dentsUnderRepairs.stopples.formattingInfo.componentsOrder.hashtable.get(i));
				}
				
				return pass;
			};
					
	ElementValidationInterface repPatchesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).dentsUnderRepairs.patches.reportType.toString();
				
				return ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).dentsUnderRepairs.patches.reportType);
			};
	ElementValidationInterface labelPatchesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
				= (typedList.get(0).dentsUnderRepairs.patches.addLabelToDescription.include ? "True" : "False")
				+ ", " + typedList.get(0).dentsUnderRepairs.patches.addLabelToDescription.value;
				
				return (typedList.get(0).dentsUnderRepairs.patches.addLabelToDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).dentsUnderRepairs.patches.addLabelToDescription.value));
			};
	ElementValidationInterface addRepPatchesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.txtValue + ", " + ele.validationStrings;
				
				ele.returnedValues = (typedList.get(0).dentsUnderRepairs.patches.addRepairDigInfo ? "True" : "False")
						+ ", " + typedList.get(0).dentsUnderRepairs.patches.formattingInfo.digRepairNumberFormat;
				
				//Hashtable size is dynamic
				for(int i = 0; i < ele.secondaryList.size(); i++) {
					ele.returnedValues += ", " + typedList.get(0).dentsUnderRepairs.patches.formattingInfo.componentsOrder.hashtable.get(i);
				}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).dentsUnderRepairs.patches.addRepairDigInfo == ele.tertiaryFlag
						&& typedList.get(0).dentsUnderRepairs.patches.formattingInfo.digRepairNumberFormat.equals(ele.txtValue);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(i).equals(typedList.get(0).dentsUnderRepairs.patches.formattingInfo.componentsOrder.hashtable.get(i));
				}
				
				return pass;
			};
							
	ElementValidationInterface repHalfSolesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).dentsUnderRepairs.halfSoles.reportType.toString();
				
				return ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).dentsUnderRepairs.halfSoles.reportType);
			};
	ElementValidationInterface labelHalfSolesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
				= (typedList.get(0).dentsUnderRepairs.halfSoles.addLabelToDescription.include ? "True" : "False")
				+ ", " + typedList.get(0).dentsUnderRepairs.halfSoles.addLabelToDescription.value;
				
				return (typedList.get(0).dentsUnderRepairs.halfSoles.addLabelToDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).dentsUnderRepairs.halfSoles.addLabelToDescription.value));
			};
	ElementValidationInterface addRepHalfSolesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.txtValue + ", " + ele.validationStrings;
				
				ele.returnedValues = (typedList.get(0).dentsUnderRepairs.halfSoles.addRepairDigInfo ? "True" : "False")
						 + ", " + typedList.get(0).dentsUnderRepairs.halfSoles.formattingInfo.digRepairNumberFormat;
				
				//Hashtable size is dynamic
				for(int i = 0; i < ele.secondaryList.size(); i++) {
					ele.returnedValues += ", " + typedList.get(0).dentsUnderRepairs.halfSoles.formattingInfo.componentsOrder.hashtable.get(i);
				}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).dentsUnderRepairs.halfSoles.addRepairDigInfo == ele.tertiaryFlag
						&& typedList.get(0).dentsUnderRepairs.halfSoles.formattingInfo.digRepairNumberFormat.equals(ele.txtValue);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(i).equals(typedList.get(0).dentsUnderRepairs.halfSoles.formattingInfo.componentsOrder.hashtable.get(i));
				}
				
				return pass;
			};
									
	ElementValidationInterface repWeldEndVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).dentsUnderRepairs.weldPlusEnd.reportType.toString();
				
				return ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).dentsUnderRepairs.weldPlusEnd.reportType);
			};
	ElementValidationInterface labelWeldEndVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
				= (typedList.get(0).dentsUnderRepairs.weldPlusEnd.addLabelToDescription.include ? "True" : "False")
				+ ", " + typedList.get(0).dentsUnderRepairs.weldPlusEnd.addLabelToDescription.value;
				
				return (typedList.get(0).dentsUnderRepairs.weldPlusEnd.addLabelToDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).dentsUnderRepairs.weldPlusEnd.addLabelToDescription.value));
			};
	ElementValidationInterface addRepWeldEndVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.txtValue + ", " + ele.validationStrings;
				
				ele.returnedValues = (typedList.get(0).dentsUnderRepairs.weldPlusEnd.addRepairDigInfo ? "True" : "False") + typedList.get(0).dentsUnderRepairs.weldPlusEnd.formattingInfo.digRepairNumberFormat;
				
				//Hashtable size is dynamic
				for(int i = 0; i < ele.secondaryList.size(); i++) {
					ele.returnedValues += ", " + typedList.get(0).dentsUnderRepairs.weldPlusEnd.formattingInfo.componentsOrder.hashtable.get(i);
				}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).dentsUnderRepairs.weldPlusEnd.addRepairDigInfo == ele.tertiaryFlag
						&& typedList.get(0).dentsUnderRepairs.weldPlusEnd.formattingInfo.digRepairNumberFormat.equals(ele.txtValue);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(i).equals(typedList.get(0).dentsUnderRepairs.weldPlusEnd.formattingInfo.componentsOrder.hashtable.get(i));
				}
				
				return pass;
			};
											
	ElementValidationInterface repRecoatsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).dentsUnderRepairs.recoats.reportType.toString();
				
				return ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).dentsUnderRepairs.recoats.reportType);
			};
	ElementValidationInterface labelRecoatsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
				= (typedList.get(0).dentsUnderRepairs.recoats.addLabelToDescription.include ? "True" : "False")
				+ ", " + typedList.get(0).dentsUnderRepairs.recoats.addLabelToDescription.value;
				
				return (typedList.get(0).dentsUnderRepairs.recoats.addLabelToDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).dentsUnderRepairs.recoats.addLabelToDescription.value));
			};
	ElementValidationInterface addRepRecoatsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.txtValue + ", " + ele.validationStrings;
				
				ele.returnedValues = (typedList.get(0).dentsUnderRepairs.recoats.addRepairDigInfo ? "True" : "False")
						+ typedList.get(0).dentsUnderRepairs.recoats.formattingInfo.digRepairNumberFormat;
				
				//Hashtable size is dynamic
				for(int i = 0; i < ele.secondaryList.size(); i++) {
					ele.returnedValues += ", " + typedList.get(0).dentsUnderRepairs.recoats.formattingInfo.componentsOrder.hashtable.get(i);
				}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).dentsUnderRepairs.recoats.addRepairDigInfo == ele.tertiaryFlag
						&& typedList.get(0).dentsUnderRepairs.recoats.formattingInfo.digRepairNumberFormat.equals(ele.txtValue);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(i).equals(typedList.get(0).dentsUnderRepairs.recoats.formattingInfo.componentsOrder.hashtable.get(i));
				}
				
				return pass;
			};
													
	ElementValidationInterface repGenRepVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).dentsUnderRepairs.genericRepairs.reportType.toString();
				
				return ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).dentsUnderRepairs.genericRepairs.reportType);
			};
	ElementValidationInterface labelGenRepVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
				= (typedList.get(0).dentsUnderRepairs.genericRepairs.addLabelToDescription.include ? "True" : "False")
				+ ", " + typedList.get(0).dentsUnderRepairs.genericRepairs.addLabelToDescription.value;
				
				return (typedList.get(0).dentsUnderRepairs.genericRepairs.addLabelToDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).dentsUnderRepairs.genericRepairs.addLabelToDescription.value));
			};
	ElementValidationInterface incOverspeedDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
				= (typedList.get(0).degradedConditionsDescription.overspeed.include ? "True" : "False")
				+ ", " + typedList.get(0).degradedConditionsDescription.overspeed.value;
				
				return (typedList.get(0).degradedConditionsDescription.overspeed.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).degradedConditionsDescription.overspeed.value));
			};
	ElementValidationInterface incDegradedDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
				= (typedList.get(0).degradedConditionsDescription.degradedSensors.include ? "True" : "False")
				+ ", " + typedList.get(0).degradedConditionsDescription.degradedSensors.value;
				
				return (typedList.get(0).degradedConditionsDescription.degradedSensors.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).degradedConditionsDescription.degradedSensors.value));
			};
	ElementValidationInterface incDegOverDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
				= (typedList.get(0).degradedConditionsDescription.degradedSensorsAndOverspeed.include ? "True" : "False")
				+ ", " + typedList.get(0).degradedConditionsDescription.degradedSensorsAndOverspeed.value;
				
				return (typedList.get(0).degradedConditionsDescription.degradedSensorsAndOverspeed.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).degradedConditionsDescription.degradedSensorsAndOverspeed.value));
			};
	ElementValidationInterface incBeyondDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
				= (typedList.get(0).degradedConditionsDescription.degradedSensorsBeyondSpec.include ? "True" : "False")
				+ ", " + typedList.get(0).degradedConditionsDescription.degradedSensorsBeyondSpec.value;
				
				return (typedList.get(0).degradedConditionsDescription.degradedSensorsBeyondSpec.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).degradedConditionsDescription.degradedSensorsBeyondSpec.value));
			};
	ElementValidationInterface inOverBeyondDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
				= (typedList.get(0).degradedConditionsDescription.overspeedBeyondSpec.include ? "True" : "False")
				+ ", " + typedList.get(0).degradedConditionsDescription.overspeedBeyondSpec.value;
				
				return (typedList.get(0).degradedConditionsDescription.overspeedBeyondSpec.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).degradedConditionsDescription.overspeedBeyondSpec.value));
			};
	ElementValidationInterface incOverSensorBeyondDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
				= (typedList.get(0).degradedConditionsDescription.degradedSensorsAndOverspeedBeyondSpec.include ? "True" : "False")
				+ ", " + typedList.get(0).degradedConditionsDescription.degradedSensorsAndOverspeedBeyondSpec.value;
				
				return (typedList.get(0).degradedConditionsDescription.degradedSensorsAndOverspeedBeyondSpec.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).degradedConditionsDescription.degradedSensorsAndOverspeedBeyondSpec.value));
			};
	ElementValidationInterface addRepGenRepVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.txtValue + ", " + ele.validationStrings;
				
				ele.returnedValues = (typedList.get(0).dentsUnderRepairs.genericRepairs.addRepairDigInfo ? "True" : "False")
						+ typedList.get(0).dentsUnderRepairs.genericRepairs.formattingInfo.digRepairNumberFormat;
				
				//Hashtable size is dynamic
				for(int i = 0; i < ele.secondaryList.size(); i++) {
					ele.returnedValues += ", " + typedList.get(0).dentsUnderRepairs.genericRepairs.formattingInfo.componentsOrder.hashtable.get(i);
				}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).dentsUnderRepairs.genericRepairs.addRepairDigInfo == ele.tertiaryFlag
						&& typedList.get(0).dentsUnderRepairs.genericRepairs.formattingInfo.digRepairNumberFormat.equals(ele.txtValue);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(i).equals(typedList.get(0).dentsUnderRepairs.genericRepairs.formattingInfo.componentsOrder.hashtable.get(i));
				}
				
				return pass;
			};
			
	ElementValidationInterface componentListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
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
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(6).separatorSpacing
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(7).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(7).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(7).separatorSpacing
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(8).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(8).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(8).separatorSpacing
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(9).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(9).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(9).separatorSpacing
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(10).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(10).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(10).separatorSpacing
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(11).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(11).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(11).separatorSpacing
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(12).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(12).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(12).separatorSpacing
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(13).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(13).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(13).separatorSpacing
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(14).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(14).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(14).separatorSpacing
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(15).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(15).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(15).separatorSpacing
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(16).component
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(16).separator
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(16).separatorSpacing;
				
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
				&& (ele.validationStrings.get(20) == null || ele.validationStrings.get(20).equals(typedList.get(0).componentsOrder.hashtable.get(6).separatorSpacing.toString()))
				&& (ele.validationStrings.get(21).equals(typedList.get(0).componentsOrder.hashtable.get(7).component))
				&& (ele.validationStrings.get(22) == null || ele.validationStrings.get(22).equals(typedList.get(0).componentsOrder.hashtable.get(7).separator.toString()))
				&& (ele.validationStrings.get(23) == null || ele.validationStrings.get(23).equals(typedList.get(0).componentsOrder.hashtable.get(7).separatorSpacing.toString()))
				&& (ele.validationStrings.get(24).equals(typedList.get(0).componentsOrder.hashtable.get(8).component))
				&& (ele.validationStrings.get(25) == null || ele.validationStrings.get(25).equals(typedList.get(0).componentsOrder.hashtable.get(8).separator.toString()))
				&& (ele.validationStrings.get(26) == null || ele.validationStrings.get(26).equals(typedList.get(0).componentsOrder.hashtable.get(8).separatorSpacing.toString()))
				&& (ele.validationStrings.get(27).equals(typedList.get(0).componentsOrder.hashtable.get(9).component))
				&& (ele.validationStrings.get(28) == null || ele.validationStrings.get(28).equals(typedList.get(0).componentsOrder.hashtable.get(9).separator.toString()))
				&& (ele.validationStrings.get(29) == null || ele.validationStrings.get(29).equals(typedList.get(0).componentsOrder.hashtable.get(9).separatorSpacing.toString()))
				&& (ele.validationStrings.get(30).equals(typedList.get(0).componentsOrder.hashtable.get(10).component))
				&& (ele.validationStrings.get(31) == null || ele.validationStrings.get(31).equals(typedList.get(0).componentsOrder.hashtable.get(10).separator.toString()))
				&& (ele.validationStrings.get(32) == null || ele.validationStrings.get(32).equals(typedList.get(0).componentsOrder.hashtable.get(10).separatorSpacing.toString()))
				&& (ele.validationStrings.get(33).equals(typedList.get(0).componentsOrder.hashtable.get(11).component))
				&& (ele.validationStrings.get(34) == null || ele.validationStrings.get(34).equals(typedList.get(0).componentsOrder.hashtable.get(11).separator.toString()))
				&& (ele.validationStrings.get(35) == null || ele.validationStrings.get(35).equals(typedList.get(0).componentsOrder.hashtable.get(11).separatorSpacing.toString()))
				&& (ele.validationStrings.get(36).equals(typedList.get(0).componentsOrder.hashtable.get(12).component))
				&& (ele.validationStrings.get(37) == null || ele.validationStrings.get(37).equals(typedList.get(0).componentsOrder.hashtable.get(12).separator.toString()))
				&& (ele.validationStrings.get(38) == null || ele.validationStrings.get(38).equals(typedList.get(0).componentsOrder.hashtable.get(12).separatorSpacing.toString()))
				&& (ele.validationStrings.get(39).equals(typedList.get(0).componentsOrder.hashtable.get(13).component))
				&& (ele.validationStrings.get(40) == null || ele.validationStrings.get(40).equals(typedList.get(0).componentsOrder.hashtable.get(13).separator.toString()))
				&& (ele.validationStrings.get(41) == null || ele.validationStrings.get(41).equals(typedList.get(0).componentsOrder.hashtable.get(13).separatorSpacing.toString()))
				&& (ele.validationStrings.get(42).equals(typedList.get(0).componentsOrder.hashtable.get(14).component))
				&& (ele.validationStrings.get(43) == null || ele.validationStrings.get(43).equals(typedList.get(0).componentsOrder.hashtable.get(14).separator.toString()))
				&& (ele.validationStrings.get(44) == null || ele.validationStrings.get(44).equals(typedList.get(0).componentsOrder.hashtable.get(14).separatorSpacing.toString()))
				&& (ele.validationStrings.get(45).equals(typedList.get(0).componentsOrder.hashtable.get(15).component))
				&& (ele.validationStrings.get(46) == null || ele.validationStrings.get(46).equals(typedList.get(0).componentsOrder.hashtable.get(15).separator.toString()))
				&& (ele.validationStrings.get(47) == null || ele.validationStrings.get(47).equals(typedList.get(0).componentsOrder.hashtable.get(15).separatorSpacing.toString()))
				&& (ele.validationStrings.get(48).equals(typedList.get(0).componentsOrder.hashtable.get(16).component))
				&& (ele.validationStrings.get(49) == null || ele.validationStrings.get(49).equals(typedList.get(0).componentsOrder.hashtable.get(16).separator.toString()))
				&& (ele.validationStrings.get(50) == null || ele.validationStrings.get(50).equals(typedList.get(0).componentsOrder.hashtable.get(16).separatorSpacing.toString()));
			};
			
	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= typedList.get(0).ai.additionalNotes;
				
				return (ele.txtValue.equals(typedList.get(0).ai.additionalNotes));
			};
	ElementValidationInterface examplesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= typedList.get(0).ai.examples;
				
				return (ele.txtValue.equals(typedList.get(0).ai.examples));
			};
			
			
	ElementValidationInterface standAloneRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).ai.dentsMarkingCriteria.reportType.toString();
				
				return ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).ai.dentsMarkingCriteria.reportType);
			};
	ElementValidationInterface correlateVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
				= (typedList.get(0).ai.dentsMarkingCriteria.correlateWithPreviousRunsNoOlderThan.include ? "True" : "False")
				+ ", " + typedList.get(0).ai.dentsMarkingCriteria.correlateWithPreviousRunsNoOlderThan.value;
				
				return (typedList.get(0).ai.dentsMarkingCriteria.correlateWithPreviousRunsNoOlderThan.include == ele.bool)
						&& (Integer.parseInt(ele.txtValue) == (typedList.get(0).ai.dentsMarkingCriteria.correlateWithPreviousRunsNoOlderThan.value));
			};
	ElementValidationInterface autoCorrVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] mapping = {"Previous Run Correlated Deformation", "TDW Correlated Deformation", "Possible Dent"};
				
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
				= (typedList.get(0).ai.dentsMarkingCriteria.addCorrelatedLabelToDescription.include ? "True" : "False")
					+ ", " + typedList.get(0).ai.dentsMarkingCriteria.addCorrelatedLabelToDescription.value;
		
				return typedList.get(0).ai.dentsMarkingCriteria.addCorrelatedLabelToDescription.include == ele.bool
						&& (mapping[ele.dropDownIndex].equals(typedList.get(0).ai.dentsMarkingCriteria.addCorrelatedLabelToDescription.value));
			};
	ElementValidationInterface dentPrevVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).ai.dentsMarkingCriteria.includeAppendDescriptionOneOfTheFollowing ? "True" : "False");
				
				return (ele.bool == typedList.get(0).ai.dentsMarkingCriteria.includeAppendDescriptionOneOfTheFollowing);
			};
	ElementValidationInterface dentPrevtxtVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= typedList.get(0).ai.dentsMarkingCriteria.ifDentMarkedInPriorRun;
				
				return (ele.txtValue.equals(typedList.get(0).ai.dentsMarkingCriteria.ifDentMarkedInPriorRun));
			};
	ElementValidationInterface dentNotVisVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] mapping = {"Not visible in prior run"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
				= typedList.get(0).ai.dentsMarkingCriteria.ifDentNotVisibleInPriorRun;
		
				return (mapping[ele.dropDownIndex].equals(typedList.get(0).ai.dentsMarkingCriteria.ifDentNotVisibleInPriorRun));
			};
	ElementValidationInterface dentNotMarkedVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= typedList.get(0).ai.dentsMarkingCriteria.ifDentVisibleButNotMarkedInPreviousRun;
				
				return (ele.txtValue.equals(typedList.get(0).ai.dentsMarkingCriteria.ifDentVisibleButNotMarkedInPreviousRun));
			};
	ElementValidationInterface markMFLVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				ele.returnedValues 
						= (typedList.get(0).ai.dentsMarkingCriteria.includeMarkDentsInMFL ? "True" : "False");
				
				return (typedList.get(0).ai.dentsMarkingCriteria.includeMarkDentsInMFL);
			};
	ElementValidationInterface labelDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] mapping = {"Possible Dent"};
				
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
				= (typedList.get(0).ai.dentsMarkingCriteria.addMFLLabelToDescription.include ? "True" : "False")
					+ ", " + typedList.get(0).ai.dentsMarkingCriteria.addMFLLabelToDescription.value;
		
				return typedList.get(0).ai.dentsMarkingCriteria.addMFLLabelToDescription.include == ele.bool
						&& (mapping[ele.dropDownIndex].equals(typedList.get(0).ai.dentsMarkingCriteria.addMFLLabelToDescription.value));
			};
	ElementValidationInterface metalLossAssociationVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Dents> typedList = (List<Dents>) list;
				
				String[] mapping = {"DO_NOT_MARK", "MARK_ONLY_DENTS_AT_OR_ABOVE_SPEC", "MARK_ML_ASSOCIATION_ON_ALL_DENTS"};
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).ai.dentsDetailedClassificationCriteria.metalLossAssociation.toString();
				
				return CSREnums.MetalLossAssociationType.valueOf(ele.expectedValue).equals(typedList.get(0).ai.dentsDetailedClassificationCriteria.metalLossAssociation);
	};
					
					
			
	
	public List<String> componentPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Default Label");
		cPL.add("Classification");
		cPL.add("Dig/Repair Info");
		cPL.add("Underspec Label");
		cPL.add("Interaction Info");
		cPL.add("Weld Interaction");
		cPL.add("Repair Label");
		cPL.add("Rerounded Dent Label");
		cPL.add("Correlation Notes");
		cPL.add("PMD Label");
		cPL.add("Top of Pipe Label");
		cPL.add("Interaction with Stopples");
		cPL.add("Metal Loss Association");
		cPL.add("MultiApex Label");
		cPL.add("Dent Strain");
		cPL.add("Failed Sensor Interaction");
		cPL.add("Dent Classified As Gouge");
		
		return cPL;
	}
	
	public List<String> sleeveRepairAList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig/Repair Number");
		cPL.add("Dig Depth");
		
		return cPL;
	}
	
	public List<String> sleeveRepairSList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig Length");
		cPL.add("Dig Width");
		cPL.add("Dig Orientation");
		
		return cPL;
	}
	
	public List<String> compRepairAList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig/Repair Number");
		cPL.add("Dig Depth");
		
		return cPL;
	}
	
	public List<String> compRepairSList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig Length");
		cPL.add("Dig Width");
		cPL.add("Dig Orientation");
		
		return cPL;
	}
	
	public List<String> stoppleRepairAList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig/Repair Number");
		cPL.add("Dig Depth");
		
		return cPL;
	}
	
	public List<String> stoppleRepairSList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig Length");
		cPL.add("Dig Width");
		cPL.add("Dig Orientation");
		
		return cPL;
	}
	
	public List<String> patchesRepairAList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig/Repair Number");
		cPL.add("Dig Depth");
		
		return cPL;
	}
	
	public List<String> patchesRepairSList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig Length");
		cPL.add("Dig Width");
		cPL.add("Dig Orientation");
		
		return cPL;
	}
	
	public List<String> soleRepairAList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig/Repair Number");
		cPL.add("Dig Depth");
		
		return cPL;
	}
	
	public List<String> soleRepairSList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig Length");
		cPL.add("Dig Width");
		cPL.add("Dig Orientation");
		
		return cPL;
	}
	
	public List<String> weldRepairAList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig/Repair Number");
		cPL.add("Dig Depth");
		
		return cPL;
	}
	
	public List<String> weldRepairSList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig Length");
		cPL.add("Dig Width");
		cPL.add("Dig Orientation");
		
		return cPL;
	}
	
	public List<String> recoatsRepairAList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig/Repair Number");
		cPL.add("Dig Depth");
		
		return cPL;
	}
	
	public List<String> recoatsRepairSList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig Length");
		cPL.add("Dig Width");
		cPL.add("Dig Orientation");
		
		return cPL;
	}
	
	public List<String> genericRepairAList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig/Repair Number");
		cPL.add("Dig Depth");
		
		return cPL;
	}
	
	public List<String> genericRepairSList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig Length");
		cPL.add("Dig Width");
		cPL.add("Dig Orientation");
		
		return cPL;
	}
	
	public List<String> selectedPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig/Repair Number");
		cPL.add("Dig Depth");
		cPL.add("Dig Orientation");
		
		return cPL;
	}
	
	
	public List<String> availablePriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig Length");
		cPL.add("Dig Width");
		
		return cPL;
	}
	
	@SuppressWarnings("unchecked")
	@ParameterizedTest
	@ValueSource(strings = {"Dents_1.json", "Dents_2.json", "Dents_3.json"})
	public void testDentsPage(String argument) throws Exception {
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
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-deformations-dents&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
			
		//Casings report label and classification
		//Due to the object types used on this page, the specific names cannot be used here, so instancing is used.
		elements.add(new SelectElement(driver, diamRefVal, "propertyWithUpdates_s", argumentFile.defaultValues.defaultSelectValue));
		elements.add(new TextElement(driver, dentOvalVal, "dentDepthOvality_tf", Integer.toString(argumentFile.defaultValues.defaultSelectValue)));
		elements.add(new SelectElement(driver, repDecVal, "propertyWithUpdates_s", argumentFile.defaultValues.defaultSelectValue));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new SelectElement(driver, roundVal, "propertyWithUpdates_s", argumentFile.defaultValues.defaultSelectValue));
		elements.get(elements.size() - 1).setDesiredInstance(2);
		
		elements.add(new IWVElement(driver, dentIntVal, "includeFailedSensor_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, appendGougeVal, "appendLabelToDescriptionWhenDentClassifiedAsGouge_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new CBElement(driver, capFirstVal, "capitalizeFirstOnly_cb", argumentFile.defaultValues.includeCB));
		
		elements.add(new CBElement(driver, incClassVal, "includeClassification_cb", argumentFile.defaultValues.includeCB));
		elements.add(new IWVElement(driver, labelDEFVal, "addDentLabelDEF_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeCB));
		elements.add(new IWVElement(driver, labelComboVal, "addDentLabelCombo_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeCB));
		elements.add(new IWVElement(driver, labelMDSVal, "addDentLabelMDS_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeCB));
		
		boolean setUnderSpec = argumentFile.defaultValues.includeIWVorIWVS;
		elements.add(new CBElement(driver, null, "setUnderSpecProperty_iwv", setUnderSpec)); //Ensure next line is valid
		if(setUnderSpec)
		{
			elements.add(new TextElement(driver, underSpecLessVal, "value2_tf", Integer.toString(argumentFile.defaultValues.defaultIWVSValue)));
			elements.add(new IWVElement(driver, underSpecGEQVal, "setUnderSpecProperty_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
		}
		elements.add(new CBElement(driver, notClassVal, "doNotclassify_cb", argumentFile.defaultValues.includeCB));
		elements.add(new IWVElement(driver, appendUnderspecVal, "appendUnderSpec_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		boolean setOnTop = argumentFile.defaultValues.includeIWVorIWVS;
		elements.add(new CBElement(driver, null, "topPipeOrientation_iwv", setOnTop)); //Ensure next line is valid
		if(setOnTop)
		{
			elements.add(new TextElement(driver, topPipeTopVal, "value2_tf", Integer.toString(argumentFile.defaultValues.defaultIWVSValue)));
			elements.get(elements.size() - 1).setDesiredInstance(1);
			elements.add(new IWVElement(driver, topPipeBotVal, "topPipeOrientation_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
		}
		elements.add(new IWVElement(driver, appendPMDVal, "appendPMDDent_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, appendReroundedVal, "reroundedDents_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new CBElement(driver, appendStrainVal, "includeDentStrain_cb", argumentFile.defaultValues.includeCB));
		
		elements.add(new CBElement(driver, repUnderSpecVal, "includeReportUnderSpec_cb", argumentFile.defaultValues.includeCB));
		//Add Rules
		elements.add(new clearRuleListElement(driver, null, "reportingFilters_dcrf"));
		elements.add(new addDentRuleListElement(driver, depthRulesVal, "reportingFilters_dcrf", 
				((List<Double>) argumentFile.uniqueValues.get("reportingFilters_dcrf")).stream().mapToInt(i->i.intValue()).toArray(), 
				Integer.toString(argumentFile.defaultValues.defaultIWVSValue)));
		
		elements.add(new CBElement(driver, repAllMLVal, "reportAllDentsWithML_cb", argumentFile.defaultValues.includeCB));
		boolean reportRegardless = (Boolean) argumentFile.uniqueValues.get("reportAllDentsOnTop_cb");
		elements.add(new CBElement(driver, repAllTopVal, "reportAllDentsOnTop_cb", reportRegardless));
		if(reportRegardless)
		{
			elements.add(new IWVElement(driver, appTopLabelVal, "appendLabel_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));			
		}
		elements.add(new CBElement(driver, notRepUnderVal, "doNotReportDentsUnderCasings_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, onlyRepRepairedVal, "includeOnlyRepairedDescriptionShouldBeAdded_cb", argumentFile.defaultValues.includeCB));
		
		boolean incRepDig = argumentFile.defaultValues.includeSimpleDataSource;
		elements.add(new CBElement(driver, null, "addDigInfo_cb", true));
		elements.add(new SimpleDataSourceElement(driver, addRepairDigVal, "digFormat_fi",  
				(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), argumentFile.defaultValues.simpleDataSourceTextVal, true, true, incRepDig));
		elements.add(new CBElement(driver, null, "addDigInfo_cb", incRepDig)); //Match with above data source elements final variable, or validation will fail (include)
		
		boolean appendLabels = (Boolean) argumentFile.uniqueValues.get("appendLabels_cb");
		elements.add(new CBElement(driver, appendLabelVal, "appendLabels_cb", appendLabels));
		if(appendLabels)
		{
			elements.add(new TextElement(driver, directMLVal, "directMLAssociation_tf", argumentFile.defaultValues.defaultTextValue));
			elements.add(new TextElement(driver, coincidentalMLVal, "coincidentalMLAssociation_tf", argumentFile.defaultValues.defaultTextValue));
		}
		
		boolean processClass = (Boolean) argumentFile.uniqueValues.get("processMLClassification_cb");
		elements.add(new CBElement(driver, processMLVal, "processMLClassification_cb", processClass));
		if(processClass)
		{
			elements.add(new TextElement(driver, MLtxtVal, "withinDentBoundaries_va", Integer.toString(argumentFile.defaultValues.defaultIWVSValue)));
			elements.add(new SelectElement(driver, MLSelVal, "units_s", 0));
			elements.add(new SelectElement(driver, MLLabelVal, "appendClassification__ts", 0));
			elements.add(new CBElement(driver, appMLDepthVal, "appendMLDepth_cb", argumentFile.defaultValues.includeCB));
		}
		
		boolean processGW = (Boolean) argumentFile.uniqueValues.get("processGWInteraction_cb");;
		elements.add(new CBElement(driver, procGWVal, "processGWInteraction_cb", processGW));
		if(processGW)
		{
			boolean customInteraction = argumentFile.defaultValues.defaultRGValues == 1 ? true : false;
			elements.add(new RGElement(driver, radioGroupval, "gwInteraction_rg", customInteraction ? 1 : 0));
			if(customInteraction)
			{
				elements.add(new TextElement(driver, customNumVal, "markGWCIBox_va", Integer.toString(argumentFile.defaultValues.defaultIWVSValue)));
				elements.add(new SelectElement(driver, customUnitVal, "units_s", 0));
				elements.get(elements.size() - 1).setDesiredInstance(1);
				elements.add(new IWVElement(driver, customLabelVal, "appendGWCILabel_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			}
			else
			{
				elements.add(new IWVElement(driver, MarkStdGWVal, "appendGWSILabel_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			}
			elements.add(new IWVSElement(driver, changeDentVal, "changeGWDentAssociation_iwvs", 0, argumentFile.defaultValues.includeIWVorIWVS));
		}
		
		elements.add(new IWVElement(driver, appendGWLabelVal, "appendManualGWILabelToDescription_iwv", argumentFile.defaultValues.defaultTextValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, appendSeamLabelVal, "appendManualSWILabelToDescription_iwv", argumentFile.defaultValues.defaultTextValue, argumentFile.defaultValues.includeIWVorIWVS));
		
		elements.add(new IWVElement(driver, addLeftStoppleVal, "addInteractionLES_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, addRightStoppleVal, "addInteractionRES_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		
		boolean processMulti = (Boolean) argumentFile.uniqueValues.get("includeAppendMultiApex_cb");
		elements.add(new CBElement(driver, OneDimIntVal, "includeAppendMultiApex_cb", processMulti));
		if(processMulti)
		{
			elements.add(new TextElement(driver, OneDimDentsVal, "dentsWithin1D_tf", argumentFile.defaultValues.defaultTextValue));
			elements.add(new TextElement(driver, OneDimUnderspecVal, "underSpecDentsWithin1D_tf", argumentFile.defaultValues.defaultTextValue));
			elements.add(new TextElement(driver, MACheckedVal, "dentsWithMultiApexUser_tf", argumentFile.defaultValues.defaultTextValue));
		}
		elements.add(new CBElement(driver, prependMAVal, "prependDentCount_cb", argumentFile.defaultValues.includeCB));
		
		elements.add(new OpenExpansionPanels(driver, null, "underRepairs_ep", new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8}));
		elements.add(new CBListElement(driver, dentAutoClassifyVal, "markRepaired_ms", argumentFile.defaultValues.CBLVal));
		
		//Each panel has the same contents, so instancing is used. Note that to maintain easily maintainable instancing, all panels are selected as "report".
		int instance = 0;
		boolean reportSleeves = argumentFile.defaultValues.defaultRGValues == 1 ? true : false;
		elements.add(new RGElement(driver, null, "reportRepaired_rg", argumentFile.defaultValues.defaultRGValues)); //Maintain instancing
		elements.get(elements.size() - 1).setDesiredInstance(instance);
		elements.add(new RGElement(driver, repSleevesVal, "reportRepaired_rg", reportSleeves ? 1 : 0));
		elements.get(elements.size() - 1).setDesiredInstance(instance);
		if(reportSleeves)
		{
			elements.add(new IWVElement(driver, labelSleevesVal, "reportLabelDent_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new CBElement(driver, null, "addRepairDigInfoDent_cb", true));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new SimpleDataSourceElement(driver, addRepSleevesVal, "formattingInfo_fi", 
					(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), 
					argumentFile.defaultValues.simpleDataSourceTextVal, true, true, argumentFile.defaultValues.includeSimpleDataSource));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new CBElement(driver, null, "addRepairDigInfoDent_cb", argumentFile.defaultValues.includeCB)); //Match with above data source elements final variable, or validation will fail (include)
			elements.get(elements.size() - 1).setDesiredInstance(instance);
		}
		instance++;
		
		boolean reportComposite = argumentFile.defaultValues.defaultRGValues == 1 ? true : false;
		elements.add(new RGElement(driver, null, "reportRepaired_rg", 1)); //Maintain Instancing
		elements.get(elements.size() - 1).setDesiredInstance(instance);
		elements.add(new RGElement(driver, repCompRVal, "reportRepaired_rg", reportComposite ? 1 : 0));
		elements.get(elements.size() - 1).setDesiredInstance(instance);
		if(reportComposite)
		{
			elements.add(new IWVElement(driver, labelCompRVal, "reportLabelDent_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new CBElement(driver, null, "addRepairDigInfoDent_cb", true));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new SimpleDataSourceElement(driver, addRepCompRVal, "formattingInfo_fi", 
					(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), 
					argumentFile.defaultValues.simpleDataSourceTextVal, true, true, argumentFile.defaultValues.includeSimpleDataSource));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new CBElement(driver, null, "addRepairDigInfoDent_cb", argumentFile.defaultValues.includeCB)); //Match with above data source elements final variable, or validation will fail (include)
			elements.get(elements.size() - 1).setDesiredInstance(instance);
		}
		instance++;
		
		boolean reportStopples = argumentFile.defaultValues.defaultRGValues == 1 ? true : false;
		elements.add(new RGElement(driver, null, "reportRepaired_rg", 1)); //Maintain Instancing
		elements.get(elements.size() - 1).setDesiredInstance(instance);
		elements.add(new RGElement(driver, repStopplesVal, "reportRepaired_rg", reportStopples ? 1 : 0));
		elements.get(elements.size() - 1).setDesiredInstance(instance);
		if(reportStopples)
		{
			elements.add(new IWVElement(driver, labelStopplesVal, "reportLabelDent_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new CBElement(driver, null, "addRepairDigInfoDent_cb", true));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new SimpleDataSourceElement(driver, addRepStopplesVal, "formattingInfo_fi", 
					(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), 
					argumentFile.defaultValues.simpleDataSourceTextVal, true, true, argumentFile.defaultValues.includeSimpleDataSource));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new CBElement(driver, null, "addRepairDigInfoDent_cb", argumentFile.defaultValues.includeCB)); //Match with above data source elements final variable, or validation will fail (include)
			elements.get(elements.size() - 1).setDesiredInstance(instance);
		}
		instance++;
		
		boolean reportPatches = argumentFile.defaultValues.defaultRGValues == 1 ? true : false;
		elements.add(new RGElement(driver, null, "reportRepaired_rg", 1)); //Maintain Instancing
		elements.get(elements.size() - 1).setDesiredInstance(instance);
		elements.add(new RGElement(driver, repPatchesVal, "reportRepaired_rg", reportPatches ? 1 : 0));
		elements.get(elements.size() - 1).setDesiredInstance(instance);
		if(reportPatches)
		{
			elements.add(new IWVElement(driver, labelPatchesVal, "reportLabelDent_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new CBElement(driver, null, "addRepairDigInfoDent_cb", true));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new SimpleDataSourceElement(driver, addRepPatchesVal, "formattingInfo_fi", 
					(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), 
					argumentFile.defaultValues.simpleDataSourceTextVal, true, true, argumentFile.defaultValues.includeSimpleDataSource));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new CBElement(driver, null, "addRepairDigInfoDent_cb", argumentFile.defaultValues.includeCB)); //Match with above data source elements final variable, or validation will fail (include)
			elements.get(elements.size() - 1).setDesiredInstance(instance);
		}
		instance++;
		
		boolean reportSoles = argumentFile.defaultValues.defaultRGValues == 1 ? true : false;
		elements.add(new RGElement(driver, null, "reportRepaired_rg", 1)); //Maintain Instancing
		elements.get(elements.size() - 1).setDesiredInstance(instance);
		elements.add(new RGElement(driver, repHalfSolesVal, "reportRepaired_rg", reportSoles ? 1 : 0));
		elements.get(elements.size() - 1).setDesiredInstance(instance);
		if(reportSoles)
		{
			elements.add(new IWVElement(driver, labelHalfSolesVal, "reportLabelDent_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new CBElement(driver, null, "addRepairDigInfoDent_cb", true));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new SimpleDataSourceElement(driver, addRepHalfSolesVal, "formattingInfo_fi", 
					(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), 
					argumentFile.defaultValues.simpleDataSourceTextVal, true, true, argumentFile.defaultValues.includeSimpleDataSource));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new CBElement(driver, null, "addRepairDigInfoDent_cb", argumentFile.defaultValues.includeCB)); //Match with above data source elements final variable, or validation will fail (include)
			elements.get(elements.size() - 1).setDesiredInstance(instance);
		}
		instance++;
		
		boolean reportWeld = argumentFile.defaultValues.defaultRGValues == 1 ? true : false;
		elements.add(new RGElement(driver, null, "reportRepaired_rg", 1)); //Maintain Instancing
		elements.get(elements.size() - 1).setDesiredInstance(instance);
		elements.add(new RGElement(driver, repWeldEndVal, "reportRepaired_rg", reportWeld ? 1 : 0));
		elements.get(elements.size() - 1).setDesiredInstance(instance);
		if(reportWeld)
		{
			elements.add(new IWVElement(driver, labelWeldEndVal, "reportLabelDent_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new CBElement(driver, null, "addRepairDigInfoDent_cb", true));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new SimpleDataSourceElement(driver, addRepWeldEndVal, "formattingInfo_fi", 
					(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), 
					argumentFile.defaultValues.simpleDataSourceTextVal, true, true, argumentFile.defaultValues.includeSimpleDataSource));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new CBElement(driver, null, "addRepairDigInfoDent_cb", argumentFile.defaultValues.includeCB)); //Match with above data source elements final variable, or validation will fail (include)
			elements.get(elements.size() - 1).setDesiredInstance(instance);
		}
		instance++;
		
		boolean reportRecoats = argumentFile.defaultValues.defaultRGValues == 1 ? true : false;
		elements.add(new RGElement(driver, null, "reportRepaired_rg", 1)); //Maintain Instancing
		elements.get(elements.size() - 1).setDesiredInstance(instance);
		elements.add(new RGElement(driver, repRecoatsVal, "reportRepaired_rg", reportRecoats ? 1 : 0));
		elements.get(elements.size() - 1).setDesiredInstance(instance);
		if(reportRecoats)
		{
			elements.add(new IWVElement(driver, labelRecoatsVal, "reportLabelDent_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new CBElement(driver, null, "addRepairDigInfoDent_cb", true));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new SimpleDataSourceElement(driver, addRepRecoatsVal, "formattingInfo_fi", 
					(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), 
					argumentFile.defaultValues.simpleDataSourceTextVal, true, true, argumentFile.defaultValues.includeSimpleDataSource));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new CBElement(driver, null, "addRepairDigInfoDent_cb", argumentFile.defaultValues.includeCB)); //Match with above data source elements final variable, or validation will fail (include)
			elements.get(elements.size() - 1).setDesiredInstance(instance);
		}
		instance++;
		
		boolean reportGeneric = argumentFile.defaultValues.defaultRGValues == 1 ? true : false;
		elements.add(new RGElement(driver, null, "reportRepaired_rg", 1)); //Maintain Instancing
		elements.get(elements.size() - 1).setDesiredInstance(instance);
		elements.add(new RGElement(driver, repGenRepVal, "reportRepaired_rg", reportGeneric ? 1 : 0));
		elements.get(elements.size() - 1).setDesiredInstance(instance);
		if(reportGeneric)
		{
			elements.add(new IWVElement(driver, labelGenRepVal, "reportLabelDent_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new CBElement(driver, null, "addRepairDigInfoDent_cb", true));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new SimpleDataSourceElement(driver, addRepGenRepVal, "formattingInfo_fi", 
					(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), 
					argumentFile.defaultValues.simpleDataSourceTextVal, true, true, argumentFile.defaultValues.includeSimpleDataSource));
			elements.get(elements.size() - 1).setDesiredInstance(instance);
			elements.add(new CBElement(driver, null, "addRepairDigInfoDent_cb", argumentFile.defaultValues.includeCB)); //Match with above data source elements final variable, or validation will fail (include)
			elements.get(elements.size() - 1).setDesiredInstance(instance);
		}
		instance++;
		
		elements.add(new IWVElement(driver, incOverspeedDescVal, "overspeed_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, incDegradedDescVal, "degradedSensors_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, incDegOverDescVal, "degradedSensorsAndOverspeed_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, incBeyondDescVal, "degradedSensorsBeyondSpec_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, inOverBeyondDescVal, "overspeedBeyondSpec_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, incOverSensorBeyondDescVal, "degradedSensorsAndOverspeedBeyondSpec_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		
		elements.add(new DragBoggleElement(driver, componentListVal, "dents_cl", argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
		elements.add(new TextElement(driver, deviationsVal, "additionalNotes_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, examplesVal, "examples_ta", argumentFile.defaultValues.defaultTextValue));
		
		
		boolean markDents = argumentFile.defaultValues.defaultRGValues == 1 ? true : false;
		elements.add(new RGElement(driver, standAloneRGVal, "reportTypeMFLStandAlone_rg", markDents ? 1 : 0));
		if(markDents)
		{
			elements.add(new IWVElement(driver, correlateVal, "correlatePrevious_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.add(new IWVSElement(driver, autoCorrVal, "addCorrelatedLabel_iwvs", argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.includeIWVorIWVS));
			
			boolean appendDesc = (Boolean) argumentFile.uniqueValues.get("appendDescriptionCase_cb");
			elements.add(new CBElement(driver, dentPrevVal, "appendDescriptionCase_cb", appendDesc));
			if(appendDesc)
			{
				elements.add(new TextElement(driver, dentPrevtxtVal, "ifDentMarkedPrior_tf", argumentFile.defaultValues.defaultTextValue));
				elements.add(new SelectElement(driver, dentNotVisVal, "ifDentNotVisiblePrior_ts", 0));
				elements.add(new TextElement(driver, dentNotMarkedVal, "ifDentVisibleNotMarkedPrior_tf", argumentFile.defaultValues.defaultTextValue));
			}
			
			boolean MFLstandAlone = (Boolean) argumentFile.uniqueValues.get("includeMarkDentsInMFL_cb");
			elements.add(new CBElement(driver, markMFLVal, "includeMarkDentsInMFL_cb", MFLstandAlone));
			if(MFLstandAlone)
			{
				elements.add(new IWVSElement(driver, labelDescVal, "addLabel_iwvs", 0, argumentFile.defaultValues.includeIWVorIWVS));
			}
		}
		
		elements.add(new RGElement(driver, metalLossAssociationVal, "metalLossAssociation_rg", argumentFile.defaultValues.defaultRGValues));
		
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
		compTest.compaireDB(elements, "Dents", tables.DENTS, "DentsResults", argumentFile.FileCounter);
	}
}