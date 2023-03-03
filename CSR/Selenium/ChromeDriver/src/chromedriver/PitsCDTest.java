package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.CSREnums;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.CSREnums.DentsMarkAsRepairedType;
import com.tdw.csr.entity.CSREnums.PitsMarkAsRepairedType;
import com.tdw.csr.entity.CSREnums.ReportingRoundType;
import com.tdw.csr.entity.metal_loss.MetalLoss;
import com.tdw.csr.entity.metal_loss.pits.Pits;
import com.tdw.csr.entity.metal_loss.pits.PitsEnums;

import chromedriver.CompaireDB.tables;
//This wildcard import is meant to import all subclasses of UIElements
import chromedriver.UIElements.*;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PitsCDTest extends BaseCDTest {
	
	ElementValidationInterface addClassVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).addClassificationToDescription ? "True" : "False");
				
				return (typedList.get(0).addClassificationToDescription == ele.bool);
			};
	ElementValidationInterface MLAbbVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).classificationAbbreviations.metalLossAbbreviation.include ? "True" : "False")
						+ ", " + typedList.get(0).classificationAbbreviations.metalLossAbbreviation.value;
				
				return (typedList.get(0).classificationAbbreviations.metalLossAbbreviation.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).classificationAbbreviations.metalLossAbbreviation.value));
			};
	ElementValidationInterface CorAbbVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).classificationAbbreviations.corrosionAbbreviation.include ? "True" : "False")
						+ ", " + typedList.get(0).classificationAbbreviations.corrosionAbbreviation.value;
				
				return (typedList.get(0).classificationAbbreviations.corrosionAbbreviation.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).classificationAbbreviations.corrosionAbbreviation.value));
			};
	ElementValidationInterface MFGAbbVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).classificationAbbreviations.mfgAbbreviation.include ? "True" : "False")
						+ ", " + typedList.get(0).classificationAbbreviations.mfgAbbreviation.value;
				
				return (typedList.get(0).classificationAbbreviations.mfgAbbreviation.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).classificationAbbreviations.mfgAbbreviation.value));
			};
	ElementValidationInterface GWAAbbVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).classificationAbbreviations.girthWeldAnomalyAbbreviation.include ? "True" : "False")
						+ ", " + typedList.get(0).classificationAbbreviations.girthWeldAnomalyAbbreviation.value;
				
				return (typedList.get(0).classificationAbbreviations.girthWeldAnomalyAbbreviation.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).classificationAbbreviations.girthWeldAnomalyAbbreviation.value));
			};
	ElementValidationInterface CirAbbVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).classificationAbbreviations.circumferentialPlanarAbbreviation.include ? "True" : "False")
						+ ", " + typedList.get(0).classificationAbbreviations.circumferentialPlanarAbbreviation.value;
				
				return (typedList.get(0).classificationAbbreviations.circumferentialPlanarAbbreviation.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).classificationAbbreviations.circumferentialPlanarAbbreviation.value));
			};
			
	ElementValidationInterface PMDDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).appendLabelToDescriptionOnPMDPits.include ? "True" : "False")
						+ ", " + typedList.get(0).appendLabelToDescriptionOnPMDPits.value;
				
				return (typedList.get(0).appendLabelToDescriptionOnPMDPits.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).appendLabelToDescriptionOnPMDPits.value));
			};
	ElementValidationInterface PitAsGougeVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).appendLabelToDescriptionWhenPitClassifiedAsGouge.include ? "True" : "False")
						+ ", " + typedList.get(0).appendLabelToDescriptionWhenPitClassifiedAsGouge.value;
				
				return (typedList.get(0).appendLabelToDescriptionWhenPitClassifiedAsGouge.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).appendLabelToDescriptionWhenPitClassifiedAsGouge.value));
			};
	ElementValidationInterface IDODDiscVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] mapping = {"Internal/External", "INT/EXT"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).includeIDODDiscriminationProximity.value;
				
				return (ele.expectedValue.equals(typedList.get(0).includeIDODDiscriminationProximity.value));
			};
	ElementValidationInterface onlyRepVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).includeOnlyRepairedDescriptionShouldBeAdded ? "True" : "False");
				
				return (typedList.get(0).includeOnlyRepairedDescriptionShouldBeAdded == ele.bool);
			};
	ElementValidationInterface repDigVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).addRepairDigInfoToDescForAllRepairedPits ? "True" : "False");
				
				return (typedList.get(0).addRepairDigInfoToDescForAllRepairedPits == ele.bool);
			};
	ElementValidationInterface ifIntVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).includeFailedSensorInDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).includeFailedSensorInDescription.value;
				
				return (typedList.get(0).includeFailedSensorInDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).includeFailedSensorInDescription.value));
			};
			
			
	ElementValidationInterface depthRules0Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] typeMap = {"FILTER", "ROUND"};
				String[] pitDepthCompMap = {"LESS_THAN", "LESS_THAN_OR_EQUAL_TO", "GREATER_THAN", "GREATER_THAN_OR_EQUAL_TO"};
				String[] roundDirectionMap = {"ROUND_UP", "ROUND_DOWN"};
				String[] GEQMap = {"GREATER_THAN", "GREATER_THAN_OR_EQUAL_TO"};
				String[] LEQMap = {"LESS_THAN", "LESS_THAN_OR_EQUAL_TO"};
				
				ele.expectedValue = typeMap[ele.generalIndex];
				
				if(ele.generalIndex == 0)
				{
					ele.expectedValue += ", " + pitDepthCompMap[ele.controlIndices[0]] + ", " + ele.controlIndices[1];				
				}
				else
				{
					ele.expectedValue += ", " + roundDirectionMap[ele.controlIndices[0]] + ", " + GEQMap[ele.controlIndices[1]] + ", " + ele.controlIndices[2] 
							+ ", " + LEQMap[ele.controlIndices[3]] + ", " + ele.controlIndices[4] + ", " + ele.controlIndices[5];					
				}
				
				ele.returnedValues = typedList.get(0).pitsDepthThresAndReportFilters.rules.get(0).thresholdAndReportingType.toString() + ", ";
				
				if(ele.generalIndex == 0)
				{
					ele.returnedValues += typedList.get(0).pitsDepthThresAndReportFilters.rules.get(0).filterPitWithDepth.filter.operatorEnum.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(0).filterPitWithDepth.filter.value;		
				}
				else
				{
					ele.returnedValues += typedList.get(0).pitsDepthThresAndReportFilters.rules.get(0).roundPitWithDepth.roundUpOrDownType.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(0).roundPitWithDepth.roundFrom.operatorEnum.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(0).roundPitWithDepth.roundFrom.value
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(0).roundPitWithDepth.roundTo.operatorEnum.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(0).roundPitWithDepth.roundTo.value
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(0).roundPitWithDepth.roundAllTo;
				}
				
				//Comparison
				boolean pass = typedList.get(0).pitsDepthThresAndReportFilters.rules.get(0).thresholdAndReportingType.toString().equals(typeMap[ele.generalIndex]);
				if(ele.generalIndex == 0)
				{
					if(!typedList.get(0).pitsDepthThresAndReportFilters.rules.get(0).filterPitWithDepth.filter.operatorEnum.toString().equals(pitDepthCompMap[ele.controlIndices[0]])
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(0).filterPitWithDepth.filter.value != ele.controlIndices[1])
					{
						pass = false;					
					}
				}
				else
				{
					if(!typedList.get(0).pitsDepthThresAndReportFilters.rules.get(0).roundPitWithDepth.roundUpOrDownType.toString().equals(roundDirectionMap[ele.controlIndices[0]])
							|| !typedList.get(0).pitsDepthThresAndReportFilters.rules.get(0).roundPitWithDepth.roundFrom.operatorEnum.toString().equals(GEQMap[ele.controlIndices[1]])
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(0).roundPitWithDepth.roundFrom.value != ele.controlIndices[2]
							|| !typedList.get(0).pitsDepthThresAndReportFilters.rules.get(0).roundPitWithDepth.roundTo.operatorEnum.toString().equals(LEQMap[ele.controlIndices[3]])
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(0).roundPitWithDepth.roundTo.value != ele.controlIndices[4]
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(0).roundPitWithDepth.roundAllTo != ele.controlIndices[5])
					{
						pass = false;					
					}
				}
				
				
				return pass;
			};
	ElementValidationInterface depthRules1Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] typeMap = {"FILTER", "ROUND"};
				String[] pitDepthCompMap = {"LESS_THAN", "LESS_THAN_OR_EQUAL_TO", "GREATER_THAN", "GREATER_THAN_OR_EQUAL_TO"};
				String[] roundDirectionMap = {"ROUND_UP", "ROUND_DOWN"};
				String[] GEQMap = {"GREATER_THAN", "GREATER_THAN_OR_EQUAL_TO"};
				String[] LEQMap = {"LESS_THAN", "LESS_THAN_OR_EQUAL_TO"};
				
				ele.expectedValue = typeMap[ele.generalIndex];
				
				if(ele.generalIndex == 0)
				{
					ele.expectedValue += ", " + pitDepthCompMap[ele.controlIndices[0]] + ", " + ele.controlIndices[1];				
				}
				else
				{
					ele.expectedValue += ", " + roundDirectionMap[ele.controlIndices[0]] + ", " + GEQMap[ele.controlIndices[1]] + ", " + ele.controlIndices[2] 
							+ ", " + LEQMap[ele.controlIndices[3]] + ", " + ele.controlIndices[4] + ", " + ele.controlIndices[5];					
				}
				
				ele.returnedValues = typedList.get(0).pitsDepthThresAndReportFilters.rules.get(1).thresholdAndReportingType.toString() + ", ";
				
				if(ele.generalIndex == 0)
				{
					ele.returnedValues += typedList.get(0).pitsDepthThresAndReportFilters.rules.get(1).filterPitWithDepth.filter.operatorEnum.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(1).filterPitWithDepth.filter.value;		
				}
				else
				{
					ele.returnedValues += typedList.get(0).pitsDepthThresAndReportFilters.rules.get(1).roundPitWithDepth.roundUpOrDownType.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(1).roundPitWithDepth.roundFrom.operatorEnum.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(1).roundPitWithDepth.roundFrom.value
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(1).roundPitWithDepth.roundTo.operatorEnum.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(1).roundPitWithDepth.roundTo.value
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(1).roundPitWithDepth.roundAllTo;
				}
				
				//Comparison
				boolean pass = typedList.get(0).pitsDepthThresAndReportFilters.rules.get(1).thresholdAndReportingType.toString().equals(typeMap[ele.generalIndex]);
				System.out.println(pass);
				if(ele.generalIndex == 0)
				{
					if(!typedList.get(0).pitsDepthThresAndReportFilters.rules.get(1).filterPitWithDepth.filter.operatorEnum.toString().equals(pitDepthCompMap[ele.controlIndices[0]])
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(1).filterPitWithDepth.filter.value != ele.controlIndices[1])
					{
						pass = false;					
					}
				}
				else
				{
					if(!typedList.get(0).pitsDepthThresAndReportFilters.rules.get(1).roundPitWithDepth.roundUpOrDownType.toString().equals(roundDirectionMap[ele.controlIndices[0]])
							|| !typedList.get(0).pitsDepthThresAndReportFilters.rules.get(1).roundPitWithDepth.roundFrom.operatorEnum.toString().equals(GEQMap[ele.controlIndices[1]])
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(1).roundPitWithDepth.roundFrom.value != ele.controlIndices[2]
							|| !typedList.get(0).pitsDepthThresAndReportFilters.rules.get(1).roundPitWithDepth.roundTo.operatorEnum.toString().equals(LEQMap[ele.controlIndices[3]])
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(1).roundPitWithDepth.roundTo.value != ele.controlIndices[4]
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(1).roundPitWithDepth.roundAllTo != ele.controlIndices[5])
					{
						pass = false;					
					}
				}
				
				
				return pass;
			};
	ElementValidationInterface depthRules2Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] typeMap = {"FILTER", "ROUND"};
				String[] pitDepthCompMap = {"LESS_THAN", "LESS_THAN_OR_EQUAL_TO", "GREATER_THAN", "GREATER_THAN_OR_EQUAL_TO"};
				String[] roundDirectionMap = {"ROUND_UP", "ROUND_DOWN"};
				String[] GEQMap = {"GREATER_THAN", "GREATER_THAN_OR_EQUAL_TO"};
				String[] LEQMap = {"LESS_THAN", "LESS_THAN_OR_EQUAL_TO"};
				
				ele.expectedValue = typeMap[ele.generalIndex];
				
				if(ele.generalIndex == 0)
				{
					ele.expectedValue += ", " + pitDepthCompMap[ele.controlIndices[0]] + ", " + ele.controlIndices[1];				
				}
				else
				{
					ele.expectedValue += ", " + roundDirectionMap[ele.controlIndices[0]] + ", " + GEQMap[ele.controlIndices[1]] + ", " + ele.controlIndices[2] 
							+ ", " + LEQMap[ele.controlIndices[3]] + ", " + ele.controlIndices[4] + ", " + ele.controlIndices[5];					
				}
				
				ele.returnedValues = typedList.get(0).pitsDepthThresAndReportFilters.rules.get(2).thresholdAndReportingType.toString() + ", ";
				
				if(ele.generalIndex == 0)
				{
					ele.returnedValues += typedList.get(0).pitsDepthThresAndReportFilters.rules.get(2).filterPitWithDepth.filter.operatorEnum.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(2).filterPitWithDepth.filter.value;		
				}
				else
				{
					ele.returnedValues += typedList.get(0).pitsDepthThresAndReportFilters.rules.get(2).roundPitWithDepth.roundUpOrDownType.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(2).roundPitWithDepth.roundFrom.operatorEnum.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(2).roundPitWithDepth.roundFrom.value
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(2).roundPitWithDepth.roundTo.operatorEnum.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(2).roundPitWithDepth.roundTo.value
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(2).roundPitWithDepth.roundAllTo;
				}
				
				//Comparison
				boolean pass = typedList.get(0).pitsDepthThresAndReportFilters.rules.get(2).thresholdAndReportingType.toString().equals(typeMap[ele.generalIndex]);
				if(ele.generalIndex == 0)
				{
					if(!typedList.get(0).pitsDepthThresAndReportFilters.rules.get(2).filterPitWithDepth.filter.operatorEnum.toString().equals(pitDepthCompMap[ele.controlIndices[0]])
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(2).filterPitWithDepth.filter.value != ele.controlIndices[1])
					{
						pass = false;					
					}
				}
				else
				{
					if(!typedList.get(0).pitsDepthThresAndReportFilters.rules.get(2).roundPitWithDepth.roundUpOrDownType.toString().equals(roundDirectionMap[ele.controlIndices[0]])
							|| !typedList.get(0).pitsDepthThresAndReportFilters.rules.get(2).roundPitWithDepth.roundFrom.operatorEnum.toString().equals(GEQMap[ele.controlIndices[1]])
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(2).roundPitWithDepth.roundFrom.value != ele.controlIndices[2]
							|| !typedList.get(0).pitsDepthThresAndReportFilters.rules.get(2).roundPitWithDepth.roundTo.operatorEnum.toString().equals(LEQMap[ele.controlIndices[3]])
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(2).roundPitWithDepth.roundTo.value != ele.controlIndices[4]
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(2).roundPitWithDepth.roundAllTo != ele.controlIndices[5])
					{
						pass = false;					
					}
				}
				
				
				return pass;
			};
	ElementValidationInterface depthRules3Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] typeMap = {"FILTER", "ROUND"};
				String[] pitDepthCompMap = {"LESS_THAN", "LESS_THAN_OR_EQUAL_TO", "GREATER_THAN", "GREATER_THAN_OR_EQUAL_TO"};
				String[] roundDirectionMap = {"ROUND_UP", "ROUND_DOWN"};
				String[] GEQMap = {"GREATER_THAN", "GREATER_THAN_OR_EQUAL_TO"};
				String[] LEQMap = {"LESS_THAN", "LESS_THAN_OR_EQUAL_TO"};
				
				ele.expectedValue = typeMap[ele.generalIndex];
				
				if(ele.generalIndex == 0)
				{
					ele.expectedValue += ", " + pitDepthCompMap[ele.controlIndices[0]] + ", " + ele.controlIndices[1];				
				}
				else
				{
					ele.expectedValue += ", " + roundDirectionMap[ele.controlIndices[0]] + ", " + GEQMap[ele.controlIndices[1]] + ", " + ele.controlIndices[2] 
							+ ", " + LEQMap[ele.controlIndices[3]] + ", " + ele.controlIndices[4] + ", " + ele.controlIndices[5];					
				}
				
				ele.returnedValues = typedList.get(0).pitsDepthThresAndReportFilters.rules.get(3).thresholdAndReportingType.toString() + ", ";
				
				if(ele.generalIndex == 0)
				{
					ele.returnedValues += typedList.get(0).pitsDepthThresAndReportFilters.rules.get(3).filterPitWithDepth.filter.operatorEnum.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(3).filterPitWithDepth.filter.value;		
				}
				else
				{
					ele.returnedValues += typedList.get(0).pitsDepthThresAndReportFilters.rules.get(3).roundPitWithDepth.roundUpOrDownType.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(3).roundPitWithDepth.roundFrom.operatorEnum.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(3).roundPitWithDepth.roundFrom.value
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(3).roundPitWithDepth.roundTo.operatorEnum.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(3).roundPitWithDepth.roundTo.value
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(3).roundPitWithDepth.roundAllTo;
				}
				
				//Comparison
				boolean pass = typedList.get(0).pitsDepthThresAndReportFilters.rules.get(3).thresholdAndReportingType.toString().equals(typeMap[ele.generalIndex]);
				if(ele.generalIndex == 0)
				{
					if(!typedList.get(0).pitsDepthThresAndReportFilters.rules.get(3).filterPitWithDepth.filter.operatorEnum.toString().equals(pitDepthCompMap[ele.controlIndices[0]])
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(3).filterPitWithDepth.filter.value != ele.controlIndices[1])
					{
						pass = false;					
					}
				}
				else
				{
					if(!typedList.get(0).pitsDepthThresAndReportFilters.rules.get(3).roundPitWithDepth.roundUpOrDownType.toString().equals(roundDirectionMap[ele.controlIndices[0]])
							|| !typedList.get(0).pitsDepthThresAndReportFilters.rules.get(3).roundPitWithDepth.roundFrom.operatorEnum.toString().equals(GEQMap[ele.controlIndices[1]])
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(3).roundPitWithDepth.roundFrom.value != ele.controlIndices[2]
							|| !typedList.get(0).pitsDepthThresAndReportFilters.rules.get(3).roundPitWithDepth.roundTo.operatorEnum.toString().equals(LEQMap[ele.controlIndices[3]])
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(3).roundPitWithDepth.roundTo.value != ele.controlIndices[4]
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(3).roundPitWithDepth.roundAllTo != ele.controlIndices[5])
					{
						pass = false;					
					}
				}
				
				
				return pass;
			};
	ElementValidationInterface depthRules4Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] typeMap = {"FILTER", "ROUND"};
				String[] pitDepthCompMap = {"LESS_THAN", "LESS_THAN_OR_EQUAL_TO", "GREATER_THAN", "GREATER_THAN_OR_EQUAL_TO"};
				String[] roundDirectionMap = {"ROUND_UP", "ROUND_DOWN"};
				String[] GEQMap = {"GREATER_THAN", "GREATER_THAN_OR_EQUAL_TO"};
				String[] LEQMap = {"LESS_THAN", "LESS_THAN_OR_EQUAL_TO"};
				
				ele.expectedValue = typeMap[ele.generalIndex];
				
				if(ele.generalIndex == 0)
				{
					ele.expectedValue += ", " + pitDepthCompMap[ele.controlIndices[0]] + ", " + ele.controlIndices[1];				
				}
				else
				{
					ele.expectedValue += ", " + roundDirectionMap[ele.controlIndices[0]] + ", " + GEQMap[ele.controlIndices[1]] + ", " + ele.controlIndices[2] 
							+ ", " + LEQMap[ele.controlIndices[3]] + ", " + ele.controlIndices[4] + ", " + ele.controlIndices[5];					
				}
				
				ele.returnedValues = typedList.get(0).pitsDepthThresAndReportFilters.rules.get(4).thresholdAndReportingType.toString() + ", ";
				
				if(ele.generalIndex == 0)
				{
					ele.returnedValues += typedList.get(0).pitsDepthThresAndReportFilters.rules.get(4).filterPitWithDepth.filter.operatorEnum.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(4).filterPitWithDepth.filter.value;		
				}
				else
				{
					ele.returnedValues += typedList.get(0).pitsDepthThresAndReportFilters.rules.get(4).roundPitWithDepth.roundUpOrDownType.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(4).roundPitWithDepth.roundFrom.operatorEnum.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(4).roundPitWithDepth.roundFrom.value
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(4).roundPitWithDepth.roundTo.operatorEnum.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(4).roundPitWithDepth.roundTo.value
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(4).roundPitWithDepth.roundAllTo;
				}
				
				//Comparison
				boolean pass = typedList.get(0).pitsDepthThresAndReportFilters.rules.get(4).thresholdAndReportingType.toString().equals(typeMap[ele.generalIndex]);
				if(ele.generalIndex == 0)
				{
					if(!typedList.get(0).pitsDepthThresAndReportFilters.rules.get(4).filterPitWithDepth.filter.operatorEnum.toString().equals(pitDepthCompMap[ele.controlIndices[0]])
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(4).filterPitWithDepth.filter.value != ele.controlIndices[1])
					{
						pass = false;					
					}
				}
				else
				{
					if(!typedList.get(0).pitsDepthThresAndReportFilters.rules.get(4).roundPitWithDepth.roundUpOrDownType.toString().equals(roundDirectionMap[ele.controlIndices[0]])
							|| !typedList.get(0).pitsDepthThresAndReportFilters.rules.get(4).roundPitWithDepth.roundFrom.operatorEnum.toString().equals(GEQMap[ele.controlIndices[1]])
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(4).roundPitWithDepth.roundFrom.value != ele.controlIndices[2]
							|| !typedList.get(0).pitsDepthThresAndReportFilters.rules.get(4).roundPitWithDepth.roundTo.operatorEnum.toString().equals(LEQMap[ele.controlIndices[3]])
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(4).roundPitWithDepth.roundTo.value != ele.controlIndices[4]
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(4).roundPitWithDepth.roundAllTo != ele.controlIndices[5])
					{
						pass = false;					
					}
				}
				
				
				return pass;
			};
	ElementValidationInterface depthRules5Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] typeMap = {"FILTER", "ROUND"};
				String[] pitDepthCompMap = {"LESS_THAN", "LESS_THAN_OR_EQUAL_TO", "GREATER_THAN", "GREATER_THAN_OR_EQUAL_TO"};
				String[] roundDirectionMap = {"ROUND_UP", "ROUND_DOWN"};
				String[] GEQMap = {"GREATER_THAN", "GREATER_THAN_OR_EQUAL_TO"};
				String[] LEQMap = {"LESS_THAN", "LESS_THAN_OR_EQUAL_TO"};
				
				ele.expectedValue = typeMap[ele.generalIndex];
				
				if(ele.generalIndex == 0)
				{
					ele.expectedValue += ", " + pitDepthCompMap[ele.controlIndices[0]] + ", " + ele.controlIndices[1];				
				}
				else
				{
					ele.expectedValue += ", " + roundDirectionMap[ele.controlIndices[0]] + ", " + GEQMap[ele.controlIndices[1]] + ", " + ele.controlIndices[2] 
							+ ", " + LEQMap[ele.controlIndices[3]] + ", " + ele.controlIndices[4] + ", " + ele.controlIndices[5];					
				}
				
				ele.returnedValues = typedList.get(0).pitsDepthThresAndReportFilters.rules.get(5).thresholdAndReportingType.toString() + ", ";
				
				if(ele.generalIndex == 0)
				{
					ele.returnedValues += typedList.get(0).pitsDepthThresAndReportFilters.rules.get(5).filterPitWithDepth.filter.operatorEnum.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(5).filterPitWithDepth.filter.value;		
				}
				else
				{
					ele.returnedValues += typedList.get(0).pitsDepthThresAndReportFilters.rules.get(5).roundPitWithDepth.roundUpOrDownType.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(5).roundPitWithDepth.roundFrom.operatorEnum.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(5).roundPitWithDepth.roundFrom.value
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(5).roundPitWithDepth.roundTo.operatorEnum.toString()
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(5).roundPitWithDepth.roundTo.value
							+ ", " + typedList.get(0).pitsDepthThresAndReportFilters.rules.get(5).roundPitWithDepth.roundAllTo;
				}
				
				//Comparison
				boolean pass = typedList.get(0).pitsDepthThresAndReportFilters.rules.get(5).thresholdAndReportingType.toString().equals(typeMap[ele.generalIndex]);
				if(ele.generalIndex == 0)
				{
					if(!typedList.get(0).pitsDepthThresAndReportFilters.rules.get(5).filterPitWithDepth.filter.operatorEnum.toString().equals(pitDepthCompMap[ele.controlIndices[0]])
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(5).filterPitWithDepth.filter.value != ele.controlIndices[1])
					{
						pass = false;					
					}
				}
				else
				{
					if(!typedList.get(0).pitsDepthThresAndReportFilters.rules.get(5).roundPitWithDepth.roundUpOrDownType.toString().equals(roundDirectionMap[ele.controlIndices[0]])
							|| !typedList.get(0).pitsDepthThresAndReportFilters.rules.get(5).roundPitWithDepth.roundFrom.operatorEnum.toString().equals(GEQMap[ele.controlIndices[1]])
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(5).roundPitWithDepth.roundFrom.value != ele.controlIndices[2]
							|| !typedList.get(0).pitsDepthThresAndReportFilters.rules.get(5).roundPitWithDepth.roundTo.operatorEnum.toString().equals(LEQMap[ele.controlIndices[3]])
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(5).roundPitWithDepth.roundTo.value != ele.controlIndices[4]
							|| typedList.get(0).pitsDepthThresAndReportFilters.rules.get(5).roundPitWithDepth.roundAllTo != ele.controlIndices[5])
					{
						pass = false;					
					}
				}
				
				
				return pass;
			};
											
	ElementValidationInterface pitIntVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).allPitsAssociatedWithDentAddLabelToDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).allPitsAssociatedWithDentAddLabelToDescription.value;
				
				return (typedList.get(0).allPitsAssociatedWithDentAddLabelToDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).allPitsAssociatedWithDentAddLabelToDescription.value));
			};
			
	ElementValidationInterface pitAutoClassifyVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;

				//As the db hashtable is not necessarily in the same order as the checklist, a map is used.
				PitsMarkAsRepairedType[] mapping = {
						PitsMarkAsRepairedType.SLEEVES,
						PitsMarkAsRepairedType.COMPOSITE_REPAIRS,
						PitsMarkAsRepairedType.PATCHES,
						PitsMarkAsRepairedType.HALF_SOLES,
						PitsMarkAsRepairedType.WELD_PLUS_END,
						PitsMarkAsRepairedType.CLAMPS,
						PitsMarkAsRepairedType.RECOATS,
						PitsMarkAsRepairedType.GENERIC_REPAIRS
				};
				
				boolean allMatching = true;
				
				for(int i = 0; i < ele.controlIndices.length; i++)
				{
					PitsMarkAsRepairedType tkey = mapping[i];
					
					if(i != 0)
						ele.returnedValues += ", ";
					
					ele.returnedValues += (typedList.get(0).pitsUnderRepairs.markAsRepaired.hashtable.get(tkey) ? "True" : "False");
					
					if(typedList.get(0).pitsUnderRepairs.markAsRepaired.hashtable.get(tkey) != (ele.controlIndices[i] == 1 ? true : false))
						allMatching = false;
				}
				
				return allMatching;
			};	
			
			
	ElementValidationInterface sleeveRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).pitsUnderRepairs.sleeves.reportType.toString();
				
				return (CSREnums.ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).pitsUnderRepairs.sleeves.reportType));
			};
	ElementValidationInterface sleeveDepthVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.sleeves.overridePitDepth.include ? "True" : "False")
						+ ", " + typedList.get(0).pitsUnderRepairs.sleeves.overridePitDepth.value;
				
				return (typedList.get(0).pitsUnderRepairs.sleeves.overridePitDepth.include == ele.bool)
						&& (Integer.parseInt(ele.txtValue) == (typedList.get(0).pitsUnderRepairs.sleeves.overridePitDepth.value));
			};
	ElementValidationInterface sleeveLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.sleeves.defaultDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).pitsUnderRepairs.sleeves.defaultDescription.value;
				
				return (typedList.get(0).pitsUnderRepairs.sleeves.defaultDescription.include == ele.bool)
						&& (typedList.get(0).pitsUnderRepairs.sleeves.defaultDescription.value.equals(ele.txtValue));
			};
	ElementValidationInterface sleeveRepDigVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.sleeves.addRepairDigInfo ? "True" : "False");
				
				return (typedList.get(0).pitsUnderRepairs.sleeves.addRepairDigInfo == ele.bool);
			};
			
	ElementValidationInterface compRRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).pitsUnderRepairs.compositeRepairs.reportType.toString();
				
				return (CSREnums.ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).pitsUnderRepairs.compositeRepairs.reportType));
			};
	ElementValidationInterface compRDepthVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.compositeRepairs.overridePitDepth.include ? "True" : "False")
						+ ", " + typedList.get(0).pitsUnderRepairs.compositeRepairs.overridePitDepth.value;
				
				return (typedList.get(0).pitsUnderRepairs.compositeRepairs.overridePitDepth.include == ele.bool)
						&& (Integer.parseInt(ele.txtValue) == (typedList.get(0).pitsUnderRepairs.compositeRepairs.overridePitDepth.value));
			};
	ElementValidationInterface compRLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.compositeRepairs.defaultDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).pitsUnderRepairs.compositeRepairs.defaultDescription.value;
				
				return (typedList.get(0).pitsUnderRepairs.compositeRepairs.defaultDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).pitsUnderRepairs.compositeRepairs.defaultDescription.value));
			};
	ElementValidationInterface compRRepDigVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.compositeRepairs.addRepairDigInfo ? "True" : "False");
				
				return (typedList.get(0).pitsUnderRepairs.compositeRepairs.addRepairDigInfo == ele.bool);
			};
			
	ElementValidationInterface patchesRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).pitsUnderRepairs.patches.reportType.toString();
				
				return (CSREnums.ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).pitsUnderRepairs.patches.reportType));
			};
	ElementValidationInterface patchesDepthVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.patches.overridePitDepth.include ? "True" : "False")
						+ ", " + typedList.get(0).pitsUnderRepairs.patches.overridePitDepth.value;
				
				return (typedList.get(0).pitsUnderRepairs.patches.overridePitDepth.include == ele.bool)
						&& (Integer.parseInt(ele.txtValue) == (typedList.get(0).pitsUnderRepairs.patches.overridePitDepth.value));
			};
	ElementValidationInterface patchesLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.patches.defaultDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).pitsUnderRepairs.patches.defaultDescription.value;
				
				return (typedList.get(0).pitsUnderRepairs.patches.defaultDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).pitsUnderRepairs.patches.defaultDescription.value));
			};
	ElementValidationInterface patchesRepDigVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.patches.addRepairDigInfo ? "True" : "False");
				
				return (typedList.get(0).pitsUnderRepairs.patches.addRepairDigInfo == ele.bool);
			};
			
	ElementValidationInterface halfSRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).pitsUnderRepairs.halfSoles.reportType.toString();
				
				return (CSREnums.ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).pitsUnderRepairs.halfSoles.reportType));
			};
	ElementValidationInterface halfSDepthVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.halfSoles.overridePitDepth.include ? "True" : "False")
						+ ", " + typedList.get(0).pitsUnderRepairs.halfSoles.overridePitDepth.value;
				
				return (typedList.get(0).pitsUnderRepairs.halfSoles.overridePitDepth.include == ele.bool)
						&& (Integer.parseInt(ele.txtValue) == (typedList.get(0).pitsUnderRepairs.halfSoles.overridePitDepth.value));
			};
	ElementValidationInterface halfSLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.halfSoles.defaultDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).pitsUnderRepairs.halfSoles.defaultDescription.value;
				
				return (typedList.get(0).pitsUnderRepairs.halfSoles.defaultDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).pitsUnderRepairs.halfSoles.defaultDescription.value));
			};
	ElementValidationInterface halfSRepDigVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.halfSoles.addRepairDigInfo ? "True" : "False");
				
				return (typedList.get(0).pitsUnderRepairs.halfSoles.addRepairDigInfo == ele.bool);
			};
			
	ElementValidationInterface weldEndRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).pitsUnderRepairs.weldPlusEnd.reportType.toString();
				
				return (CSREnums.ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).pitsUnderRepairs.weldPlusEnd.reportType));
			};
	ElementValidationInterface weldEndDepthVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.weldPlusEnd.overridePitDepth.include ? "True" : "False")
						+ ", " + typedList.get(0).pitsUnderRepairs.weldPlusEnd.overridePitDepth.value;
				
				return (typedList.get(0).pitsUnderRepairs.weldPlusEnd.overridePitDepth.include == ele.bool)
						&& (Integer.parseInt(ele.txtValue) == (typedList.get(0).pitsUnderRepairs.weldPlusEnd.overridePitDepth.value));
			};
	ElementValidationInterface weldEndLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.weldPlusEnd.defaultDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).pitsUnderRepairs.weldPlusEnd.defaultDescription.value;
				
				return (typedList.get(0).pitsUnderRepairs.weldPlusEnd.defaultDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).pitsUnderRepairs.weldPlusEnd.defaultDescription.value));
			};
	ElementValidationInterface weldEndRepDigVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.weldPlusEnd.addRepairDigInfo ? "True" : "False");
				
				return (typedList.get(0).pitsUnderRepairs.weldPlusEnd.addRepairDigInfo == ele.bool);
			};
			
	ElementValidationInterface clampsRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).pitsUnderRepairs.clamps.reportType.toString();
				
				return (CSREnums.ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).pitsUnderRepairs.clamps.reportType));
			};
	ElementValidationInterface clampsDepthVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.clamps.overridePitDepth.include ? "True" : "False")
						+ ", " + typedList.get(0).pitsUnderRepairs.clamps.overridePitDepth.value;
				
				return (typedList.get(0).pitsUnderRepairs.clamps.overridePitDepth.include == ele.bool)
						&& (Integer.parseInt(ele.txtValue) == (typedList.get(0).pitsUnderRepairs.clamps.overridePitDepth.value));
			};
	ElementValidationInterface clampsLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.clamps.defaultDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).pitsUnderRepairs.clamps.defaultDescription.value;
				
				return (typedList.get(0).pitsUnderRepairs.clamps.defaultDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).pitsUnderRepairs.clamps.defaultDescription.value));
			};
	ElementValidationInterface clampsRepDigVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.clamps.addRepairDigInfo ? "True" : "False");
				
				return (typedList.get(0).pitsUnderRepairs.clamps.addRepairDigInfo == ele.bool);
			};
			
	ElementValidationInterface recoatRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).pitsUnderRepairs.recoats.reportType.toString();
				
				return (CSREnums.ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).pitsUnderRepairs.recoats.reportType));
			};
	ElementValidationInterface recoatDepthVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.recoats.overridePitDepth.include ? "True" : "False")
						+ ", " + typedList.get(0).pitsUnderRepairs.recoats.overridePitDepth.value;
				
				return (typedList.get(0).pitsUnderRepairs.recoats.overridePitDepth.include == ele.bool)
						&& (Integer.parseInt(ele.txtValue) == (typedList.get(0).pitsUnderRepairs.recoats.overridePitDepth.value));
			};
	ElementValidationInterface recoatLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.recoats.defaultDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).pitsUnderRepairs.recoats.defaultDescription.value;
				
				return (typedList.get(0).pitsUnderRepairs.recoats.defaultDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).pitsUnderRepairs.recoats.defaultDescription.value));
			};
	ElementValidationInterface recoatRepDigVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.recoats.addRepairDigInfo ? "True" : "False");
				
				return (typedList.get(0).pitsUnderRepairs.recoats.addRepairDigInfo == ele.bool);
			};
			
	ElementValidationInterface genRepRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] mapping = {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).pitsUnderRepairs.genericRepairs.reportType.toString();
				
				return (CSREnums.ReportType.valueOf(ele.expectedValue).equals(typedList.get(0).pitsUnderRepairs.genericRepairs.reportType));
			};
	ElementValidationInterface genRepDepthVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.genericRepairs.overridePitDepth.include ? "True" : "False")
						+ ", " + typedList.get(0).pitsUnderRepairs.genericRepairs.overridePitDepth.value;
				
				return (typedList.get(0).pitsUnderRepairs.genericRepairs.overridePitDepth.include == ele.bool)
						&& (Integer.parseInt(ele.txtValue) == (typedList.get(0).pitsUnderRepairs.genericRepairs.overridePitDepth.value));
			};
	ElementValidationInterface genRepLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.genericRepairs.defaultDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).pitsUnderRepairs.genericRepairs.defaultDescription.value;
				
				return (typedList.get(0).pitsUnderRepairs.genericRepairs.defaultDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).pitsUnderRepairs.genericRepairs.defaultDescription.value));
			};
	ElementValidationInterface genRepRepDigVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsUnderRepairs.genericRepairs.addRepairDigInfo ? "True" : "False");
				
				return (typedList.get(0).pitsUnderRepairs.genericRepairs.addRepairDigInfo == ele.bool);
			};
			
			
	ElementValidationInterface MFGAmpVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsEasternHemisphereMillAnomalies.reportMillAnomaliesMFGsWithAmplitudes.include ? "True" : "False")
						+ ", " + typedList.get(0).pitsEasternHemisphereMillAnomalies.reportMillAnomaliesMFGsWithAmplitudes.value;
				
				return (typedList.get(0).pitsEasternHemisphereMillAnomalies.reportMillAnomaliesMFGsWithAmplitudes.include == ele.bool)
						&& (Double.parseDouble(ele.txtValue) == (typedList.get(0).pitsEasternHemisphereMillAnomalies.reportMillAnomaliesMFGsWithAmplitudes.value));
			};
	ElementValidationInterface MFGDepthVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsEasternHemisphereMillAnomalies.reportMillAnomaliesMFGsWithDepth.include ? "True" : "False")
						+ ", " + typedList.get(0).pitsEasternHemisphereMillAnomalies.reportMillAnomaliesMFGsWithDepth.value;
				
				return (typedList.get(0).pitsEasternHemisphereMillAnomalies.reportMillAnomaliesMFGsWithDepth.include == ele.bool)
						&& (Double.parseDouble(ele.txtValue) == (typedList.get(0).pitsEasternHemisphereMillAnomalies.reportMillAnomaliesMFGsWithDepth.value));
			};
	ElementValidationInterface MFGClassVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] mapping = {"MFG", "Manufacturing Defect", "MELO-MNFG", "Anomaly (ANOM)"};
				
				String mappedValue = mapping[ele.dropDownIndex];
				ele.expectedValue = "True, " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
					= (typedList.get(0).pitsEasternHemisphereMillAnomalies.addClassificationToDescription.include ? "True" : "False")
					+ ", " + typedList.get(0).pitsEasternHemisphereMillAnomalies.addClassificationToDescription.value;
		
				return (typedList.get(0).pitsEasternHemisphereMillAnomalies.addClassificationToDescription.include == ele.bool)
						&& (mappedValue.equals(typedList.get(0).pitsEasternHemisphereMillAnomalies.addClassificationToDescription.value));
			};
	ElementValidationInterface MDSMFGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] mapping = {"MFG", "Manufacturing Defect", "MELO-MNFG", "Anomaly (ANOM)"};
				
				String mappedValue = mapping[ele.dropDownIndex];
				ele.expectedValue = "True, " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
					= (typedList.get(0).pitsEasternHemisphereMillAnomalies.mdsRunsOverrideClassificationLabel.include ? "True" : "False")
					+ ", " + typedList.get(0).pitsEasternHemisphereMillAnomalies.mdsRunsOverrideClassificationLabel.value;
	
				return (typedList.get(0).pitsEasternHemisphereMillAnomalies.mdsRunsOverrideClassificationLabel.include == ele.bool)
					&& (mappedValue.equals(typedList.get(0).pitsEasternHemisphereMillAnomalies.mdsRunsOverrideClassificationLabel.value));
			};
	ElementValidationInterface discrLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] mapping = {"Internal / External", "INT / EXT"};
				
				String mappedValue = mapping[ele.dropDownIndex];
				ele.expectedValue = "True, " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
					= (typedList.get(0).pitsEasternHemisphereMillAnomalies.appendDiscriminationToDescriptionLabel.include ? "True" : "False")
					+ ", " + typedList.get(0).pitsEasternHemisphereMillAnomalies.appendDiscriminationToDescriptionLabel.value;
	
				return (typedList.get(0).pitsEasternHemisphereMillAnomalies.appendDiscriminationToDescriptionLabel.include == ele.bool)
					&& (mappedValue.equals(typedList.get(0).pitsEasternHemisphereMillAnomalies.appendDiscriminationToDescriptionLabel.value));
			};
	ElementValidationInterface orientLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] mapping = {"Deg.", "O'clock"};
				
				String mappedValue = mapping[ele.dropDownIndex];
				ele.expectedValue = "True, " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
					= (typedList.get(0).pitsEasternHemisphereMillAnomalies.appendOrientationToDescriptionLabel.include ? "True" : "False")
					+ ", " + typedList.get(0).pitsEasternHemisphereMillAnomalies.appendOrientationToDescriptionLabel.value;
	
				return (typedList.get(0).pitsEasternHemisphereMillAnomalies.appendOrientationToDescriptionLabel.include == ele.bool)
					&& (mappedValue.equals(typedList.get(0).pitsEasternHemisphereMillAnomalies.appendOrientationToDescriptionLabel.value));
			};

			
	ElementValidationInterface processGWVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsDetailedClassificationCriteria.includeProcessGWIntegration ? "True" : "False");
				
				return (typedList.get(0).pitsDetailedClassificationCriteria.includeProcessGWIntegration == ele.bool);
			};
	ElementValidationInterface RGIntVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] mapping = {"STANDARD_INTERACTION", "CUSTOM_INTERACTION"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).pitsDetailedClassificationCriteria.gwInteraction.toString();
				
				return (CSREnums.GirthWeldInteration.valueOf(ele.expectedValue).equals(typedList.get(0).pitsDetailedClassificationCriteria.gwInteraction));
			};
	ElementValidationInterface stdIntVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsDetailedClassificationCriteria.appendGWSILabelToDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).pitsDetailedClassificationCriteria.appendGWSILabelToDescription.value;
				
				return (typedList.get(0).pitsDetailedClassificationCriteria.appendGWSILabelToDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).pitsDetailedClassificationCriteria.appendGWSILabelToDescription.value));
			};
	ElementValidationInterface customNumVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= "" + typedList.get(0).pitsDetailedClassificationCriteria.markGWCIBox.value;
				
				return (Double.parseDouble(ele.txtValue) == (typedList.get(0).pitsDetailedClassificationCriteria.markGWCIBox.value));
			};
	ElementValidationInterface customUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] mapping = {"inch"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= typedList.get(0).pitsDetailedClassificationCriteria.markGWCIBox.units;
				
				return (ele.expectedValue.equals(typedList.get(0).pitsDetailedClassificationCriteria.markGWCIBox.units));
			};
			
			
	ElementValidationInterface customLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsDetailedClassificationCriteria.appendGWCILabelToDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).pitsDetailedClassificationCriteria.appendGWCILabelToDescription.value;
				
				return (typedList.get(0).pitsDetailedClassificationCriteria.appendGWCILabelToDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).pitsDetailedClassificationCriteria.appendGWCILabelToDescription.value));
			};
	ElementValidationInterface seamIntVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= (typedList.get(0).pitsDetailedClassificationCriteria.appendLabelWhenInSeam.include ? "True" : "False")
						+ ", " + typedList.get(0).pitsDetailedClassificationCriteria.appendLabelWhenInSeam.value;
				
				return (typedList.get(0).pitsDetailedClassificationCriteria.appendLabelWhenInSeam.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).pitsDetailedClassificationCriteria.appendLabelWhenInSeam.value));
			};
			
			
	ElementValidationInterface incOverspeedDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
				= (typedList.get(0).degradedConditionsDescription.overspeed.include ? "True" : "False")
				+ ", " + typedList.get(0).degradedConditionsDescription.overspeed.value;
				
				return (typedList.get(0).degradedConditionsDescription.overspeed.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).degradedConditionsDescription.overspeed.value));
			};
	ElementValidationInterface incDegradedDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
				= (typedList.get(0).degradedConditionsDescription.degradedSensors.include ? "True" : "False")
				+ ", " + typedList.get(0).degradedConditionsDescription.degradedSensors.value;
				
				return (typedList.get(0).degradedConditionsDescription.degradedSensors.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).degradedConditionsDescription.degradedSensors.value));
			};
	ElementValidationInterface incDegOverDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
				= (typedList.get(0).degradedConditionsDescription.degradedSensorsAndOverspeed.include ? "True" : "False")
				+ ", " + typedList.get(0).degradedConditionsDescription.degradedSensorsAndOverspeed.value;
				
				return (typedList.get(0).degradedConditionsDescription.degradedSensorsAndOverspeed.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).degradedConditionsDescription.degradedSensorsAndOverspeed.value));
			};
	ElementValidationInterface incBeyondDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
				= (typedList.get(0).degradedConditionsDescription.degradedSensorsBeyondSpec.include ? "True" : "False")
				+ ", " + typedList.get(0).degradedConditionsDescription.degradedSensorsBeyondSpec.value;
				
				return (typedList.get(0).degradedConditionsDescription.degradedSensorsBeyondSpec.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).degradedConditionsDescription.degradedSensorsBeyondSpec.value));
			};
	ElementValidationInterface inOverBeyondDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
				= (typedList.get(0).degradedConditionsDescription.overspeedBeyondSpec.include ? "True" : "False")
				+ ", " + typedList.get(0).degradedConditionsDescription.overspeedBeyondSpec.value;
				
				return (typedList.get(0).degradedConditionsDescription.overspeedBeyondSpec.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).degradedConditionsDescription.overspeedBeyondSpec.value));
			};
	ElementValidationInterface incOverSensorBeyondDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
				= (typedList.get(0).degradedConditionsDescription.degradedSensorsAndOverspeedBeyondSpec.include ? "True" : "False")
				+ ", " + typedList.get(0).degradedConditionsDescription.degradedSensorsAndOverspeedBeyondSpec.value;
				
				return (typedList.get(0).degradedConditionsDescription.degradedSensorsAndOverspeedBeyondSpec.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).degradedConditionsDescription.degradedSensorsAndOverspeedBeyondSpec.value));
			};
			
	
	ElementValidationInterface componentListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
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
						+ ", " + typedList.get(0).componentsOrder.hashtable.get(12).separatorSpacing;
				
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
				&& (ele.validationStrings.get(38) == null || ele.validationStrings.get(38).equals(typedList.get(0).componentsOrder.hashtable.get(12).separatorSpacing.toString()));
				
			};

	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
						= typedList.get(0).ai.additionalNotes;
				
				return (ele.txtValue.equals(typedList.get(0).ai.additionalNotes));
			};
	ElementValidationInterface examplesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.returnedValues 
					= typedList.get(0).ai.examples;
		
				return (ele.txtValue.equals(typedList.get(0).ai.examples));
			};
			
			
	ElementValidationInterface pitsClassRGVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				String[] mapping = {"DEFAULT", "CUSTOM"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).ai.classification.toString();
				
				return (CSREnums.ClassificationType.valueOf(ele.expectedValue).equals(typedList.get(0).ai.classification));
			};
	ElementValidationInterface pitsClassListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;

				//As the db hashtable is not necessarily in the same order as the checklist, a map is used.
				PitsEnums.ClassificationType[] mapping = {
						PitsEnums.ClassificationType.METAL_LOSS,
						PitsEnums.ClassificationType.CORROSION,
						PitsEnums.ClassificationType.MFG,
						PitsEnums.ClassificationType.GIRTH_WELD_ANOMALY,
						PitsEnums.ClassificationType.AXIAL_PLANAR,
						PitsEnums.ClassificationType.PERMEABILITY_FEATURE,
						PitsEnums.ClassificationType.CIRCUMFERENTIAL_PLANAR
				};
				
				boolean allMatching = true;
				
				for(int i = 0; i < ele.controlIndices.length && i < mapping.length; i++)
				{
					PitsEnums.ClassificationType tkey = mapping[i];
					
					if(i != 0)
						ele.returnedValues += ", ";
					
					ele.returnedValues += (typedList.get(0).ai.pitClassification.hashtable.get(tkey) ? "True" : "False");
					
					if(typedList.get(0).ai.pitClassification.hashtable.get(tkey) != (ele.controlIndices[i] == 1 ? true : false))
						allMatching = false;
				}
				
				return allMatching;
			};	
			
	ElementValidationInterface sleevesConfigVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.txtValue + ", " + ele.validationStrings;
				
				ele.returnedValues = (typedList.get(0).ai.pitsUnderRepairs.sleeves.addRepairDigInfoToDesc ? "True" : "False") + ", " + typedList.get(0).ai.pitsUnderRepairs.sleeves.formattingInfo.digRepairNumberFormat;
				
				//Hashtable size is dynamic
				for(int i = 0; i < ele.secondaryList.size(); i++) {
					ele.returnedValues += ", " + typedList.get(0).ai.pitsUnderRepairs.sleeves.formattingInfo.componentsOrder.hashtable.get(i);
				}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).ai.pitsUnderRepairs.sleeves.addRepairDigInfoToDesc == ele.tertiaryFlag
						&& typedList.get(0).ai.pitsUnderRepairs.sleeves.formattingInfo.digRepairNumberFormat.equals(ele.txtValue);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(i).equals(typedList.get(0).ai.pitsUnderRepairs.sleeves.formattingInfo.componentsOrder.hashtable.get(i));
				}
				
				return pass;
			};
	ElementValidationInterface compRepConfigVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
					
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.txtValue + ", " + ele.validationStrings;
				
				ele.returnedValues = (typedList.get(0).ai.pitsUnderRepairs.compositeRepairs.addRepairDigInfoToDesc ? "True" : "False") + ", " + typedList.get(0).ai.pitsUnderRepairs.compositeRepairs.formattingInfo.digRepairNumberFormat;
				
				//Hashtable size is dynamic
				for(int i = 0; i < ele.secondaryList.size(); i++) {
					ele.returnedValues += ", " + typedList.get(0).ai.pitsUnderRepairs.compositeRepairs.formattingInfo.componentsOrder.hashtable.get(i);
				}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).ai.pitsUnderRepairs.compositeRepairs.addRepairDigInfoToDesc == ele.tertiaryFlag
						&& typedList.get(0).ai.pitsUnderRepairs.compositeRepairs.formattingInfo.digRepairNumberFormat.equals(ele.txtValue);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(i).equals(typedList.get(0).ai.pitsUnderRepairs.compositeRepairs.formattingInfo.componentsOrder.hashtable.get(i));
				}
				
				return pass;
			};
	ElementValidationInterface patchesConfigVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", "  + ele.txtValue + ", " + ele.validationStrings;
				
				ele.returnedValues = (typedList.get(0).ai.pitsUnderRepairs.patches.addRepairDigInfoToDesc ? "True" : "False") + ", " + typedList.get(0).ai.pitsUnderRepairs.patches.formattingInfo.digRepairNumberFormat;
				
				//Hashtable size is dynamic
				for(int i = 0; i < ele.secondaryList.size(); i++) {
					ele.returnedValues += ", " + typedList.get(0).ai.pitsUnderRepairs.patches.formattingInfo.componentsOrder.hashtable.get(i);
				}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).ai.pitsUnderRepairs.patches.addRepairDigInfoToDesc == ele.tertiaryFlag
						&& typedList.get(0).ai.pitsUnderRepairs.patches.formattingInfo.digRepairNumberFormat.equals(ele.txtValue);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(i).equals(typedList.get(0).ai.pitsUnderRepairs.patches.formattingInfo.componentsOrder.hashtable.get(i));
				}
				
				return pass;
			};
	ElementValidationInterface halfSolesConfigVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", "  + ele.txtValue + ", " + ele.validationStrings;
				
				ele.returnedValues = (typedList.get(0).ai.pitsUnderRepairs.halfSoles.addRepairDigInfoToDesc ? "True" : "False") + ", " + typedList.get(0).ai.pitsUnderRepairs.halfSoles.formattingInfo.digRepairNumberFormat;
				
				//Hashtable size is dynamic
				for(int i = 0; i < ele.secondaryList.size(); i++) {
					ele.returnedValues += ", " + typedList.get(0).ai.pitsUnderRepairs.halfSoles.formattingInfo.componentsOrder.hashtable.get(i);
				}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).ai.pitsUnderRepairs.halfSoles.addRepairDigInfoToDesc == ele.tertiaryFlag
						&& typedList.get(0).ai.pitsUnderRepairs.halfSoles.formattingInfo.digRepairNumberFormat.equals(ele.txtValue);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(i).equals(typedList.get(0).ai.pitsUnderRepairs.halfSoles.formattingInfo.componentsOrder.hashtable.get(i));
				}
				
				return pass;
			};
	ElementValidationInterface WeldEndConfigVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", "  + ele.txtValue + ", " + ele.validationStrings;
				
				ele.returnedValues = (typedList.get(0).ai.pitsUnderRepairs.weldPlusEnd.addRepairDigInfoToDesc ? "True" : "False") + ", " + typedList.get(0).ai.pitsUnderRepairs.weldPlusEnd.formattingInfo.digRepairNumberFormat;
				
				//Hashtable size is dynamic
				for(int i = 0; i < ele.secondaryList.size(); i++) {
					ele.returnedValues += ", " + typedList.get(0).ai.pitsUnderRepairs.weldPlusEnd.formattingInfo.componentsOrder.hashtable.get(i);
				}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).ai.pitsUnderRepairs.weldPlusEnd.addRepairDigInfoToDesc == ele.tertiaryFlag
						&& typedList.get(0).ai.pitsUnderRepairs.weldPlusEnd.formattingInfo.digRepairNumberFormat.equals(ele.txtValue);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(i).equals(typedList.get(0).ai.pitsUnderRepairs.weldPlusEnd.formattingInfo.componentsOrder.hashtable.get(i));
				}
				
				return pass;
			};
	ElementValidationInterface clampsConfigVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Pits> typedList = (List<Pits>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", "  + ele.txtValue + ", " + ele.validationStrings;
				
				ele.returnedValues = (typedList.get(0).ai.pitsUnderRepairs.clamps.addRepairDigInfoToDesc ? "True" : "False") + ", " + typedList.get(0).ai.pitsUnderRepairs.clamps.formattingInfo.digRepairNumberFormat;
				
				//Hashtable size is dynamic
				for(int i = 0; i < ele.secondaryList.size(); i++) {
					ele.returnedValues += ", " + typedList.get(0).ai.pitsUnderRepairs.clamps.formattingInfo.componentsOrder.hashtable.get(i);
				}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).ai.pitsUnderRepairs.clamps.addRepairDigInfoToDesc == ele.tertiaryFlag
						&& typedList.get(0).ai.pitsUnderRepairs.clamps.formattingInfo.digRepairNumberFormat.equals(ele.txtValue);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(i).equals(typedList.get(0).ai.pitsUnderRepairs.clamps.formattingInfo.componentsOrder.hashtable.get(i));
				}
				
				return pass;
			};
			

			
	public List<String> componentPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pit/Dent Association Label");
		cPL.add("Interaction Info");
		cPL.add("Mill Anomaly Orientation");
		cPL.add("Classification");
		cPL.add("IDOD Discrimination");
		cPL.add("Mill Anomaly Discrimination");
		cPL.add("PMD Label");
		cPL.add("Weld Interaction");
		cPL.add("Pit Classified As Gouge");
		cPL.add("Failed Sensor Interaction");
		cPL.add("Dig/Repair Info");
		cPL.add("Repair Label");
		cPL.add("In Seam Label");
		
		return cPL;
	}
	
	
	//Lists for the Pits Repaired Configurations
	public List<String> sleevesAvailableList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig Depth");
		cPL.add("Dig Width");
		
		return cPL;
	}
	
	public List<String> sleevesSelectedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig/Repair Number");
		cPL.add("Dig Length");
		cPL.add("Dig Orientation");
		
		return cPL;
	}
	
	public List<String> compositeAvailableList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig Depth");
		cPL.add("Dig Width");
		
		return cPL;
	}
	
	public List<String> compositeSelectedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig/Repair Number");
		cPL.add("Dig Length");
		cPL.add("Dig Orientation");
		
		return cPL;
	}
	
	public List<String> patchesAvailableList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig Depth");
		cPL.add("Dig Width");
		
		return cPL;
	}
	
	public List<String> patchesSelectedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig/Repair Number");
		cPL.add("Dig Length");
		cPL.add("Dig Orientation");
		
		return cPL;
	}
	
	public List<String> solesAvailableList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig Depth");
		cPL.add("Dig Width");
		
		return cPL;
	}
	
	public List<String> solesSelectedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig/Repair Number");
		cPL.add("Dig Length");
		cPL.add("Dig Orientation");
		
		return cPL;
	}
	
	public List<String> weldAvailableList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig Depth");
		cPL.add("Dig Width");
		
		return cPL;
	}
	
	public List<String> weldSelectedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig/Repair Number");
		cPL.add("Dig Length");
		cPL.add("Dig Orientation");
		
		return cPL;
	}
	
	public List<String> clampsAvailableList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig Depth");
		cPL.add("Dig Width");
		
		return cPL;
	}
	
	public List<String> clampsSelectedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Dig/Repair Number");
		cPL.add("Dig Length");
		cPL.add("Dig Orientation");
		
		return cPL;
	}
	
	int openCounter = 0;
	/**
	 * Compacts down repeat code for dealing with the expanded lists in the Pits CSR page.
	 * 
	 * IMPORTANT: Make sure you set elements = return result, or the change will be lost.
	 * 
	 * @param elements The Elements Array
	 * @param validators The validator for the respective sub-object. Leave null for no test.
	 * @param instance Which Instance is being Used
	 * @param driver The Driver
	 * @param report Whether or not to report the results. If false, inputs are ignored.
	 * @param __Input Each input corresponds to (int) 'Override pit depth', (String) 'Add label', and (boolean) 'Add repair/dig' respectively.
	 * 
	 * @return elements with the new UIElements added.
	 * @throws InterruptedException 
	 */
	private List<UIElements> addRepairedWithElements(List<UIElements> elements, 
			ElementValidationInterface rgValidator, ElementValidationInterface overrideValidator, ElementValidationInterface addLabelValidator, ElementValidationInterface repairDigValidator,
			int instance, WebDriver driver, 
			boolean report, int IWV1Input, String IWV2Input, boolean CBInput, boolean includeOverride, boolean includeDescription) throws InterruptedException
	{
		//Pit Repaired With ___
		//Instancing is required. As such, each tab has an if statement to handle its parameters.
		
		//Sleeves
		elements.add(new RGElement(driver, null, "reportType_rg", 1)); //Ensures that the instance counters are correct.
		elements.get(elements.size() - 1).setDesiredInstance(instance);
		elements.add(new RGElement(driver, rgValidator, "reportType_rg", report ? 1 : 0));
		elements.get(elements.size() - 1).setDesiredInstance(instance);
		if(report) //If Report is selected, these elements need to be modified.
		{
			elements.add(new IWVElement(driver, overrideValidator, "overridePitDepth_iwv", Integer.toString(IWV1Input), includeOverride));
			elements.get(elements.size() - 1).setDesiredInstance(openCounter);
			elements.add(new IWVElement(driver, addLabelValidator, "defaultDescription_iwv", IWV2Input, includeDescription));
			elements.get(elements.size() - 1).setDesiredInstance(openCounter);
			elements.add(new CBElement(driver, repairDigValidator, "addRepairDigInfoPit_cb", CBInput));
			elements.get(elements.size() - 1).setDesiredInstance(openCounter);
			openCounter++;
		}
		
		return elements;
	}
	

	@SuppressWarnings("unchecked")
	@ParameterizedTest
	@ValueSource(strings = {"Pits_1.json", "Pits_2.json", "Pits_3.json", "Pits_4.json"})
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
		chromeOptions.addArguments("--start-maximized --force-device-scale-factor=1.0");
		chromeOptions.setExperimentalOption("useAutomationExtension", false);
		chromeOptions.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-metal_loss-pits&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
			
		//Casings report label and classification
		elements.add(new CBElement(driver, addClassVal, "addClassification_cb", argumentFile.defaultValues.includeCB));
		elements.add(new ClickExpansionPanel(driver, "classification_abbreviation_gr"));
		elements.add(new IWVElement(driver, MLAbbVal, "metalLossAbbreviation_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, CorAbbVal, "corrosionAbbreviation_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, MFGAbbVal, "mfgAbbreviation_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, GWAAbbVal, "girthWeldAnomalyAbbreviation_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, CirAbbVal, "circumferentialPlanarAbbreviation_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		
		elements.add(new IWVElement(driver, PMDDescVal, "appendLabelToDescriptionOnPMDPits_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, PitAsGougeVal, "appendLabelToDescriptionWhenPitClassifiedAsGouge_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVSElement(driver, IDODDiscVal, "includeIDODDiscriminationProximity_iwvs", argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new CBElement(driver, onlyRepVal, "includeOnlyRepairedDescriptionShouldBeAdded_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, repDigVal, "addRepairDigInfoToDescForAllRepairedPits_cb", argumentFile.defaultValues.includeCB));
		elements.add(new IWVElement(driver, ifIntVal, "includeFailedSensor_iwv", "Failed Intersect", argumentFile.defaultValues.includeIWVorIWVS));
		
		elements.add(new clearRuleListElement(driver, null, "pitsReportFilters_pt")); //Recommended to Prevent errors
		elements.add(new addRuleListElement(driver, depthRules0Val, "pitsReportFilters_pt", 0, ((List<Double>) argumentFile.uniqueValues.get("pitsReportFilters0_pt")).stream().mapToInt(x->x.intValue()).toArray()));//new int[] {1, 22}));
		elements.add(new addRuleListElement(driver, depthRules1Val, "pitsReportFilters_pt", 1, ((List<Double>) argumentFile.uniqueValues.get("pitsReportFilters1_pt")).stream().mapToInt(x->x.intValue()).toArray()));//new int[] {1, 1, 13, 0, 22, 15}));
		elements.add(new addRuleListElement(driver, depthRules2Val, "pitsReportFilters_pt", 0, ((List<Double>) argumentFile.uniqueValues.get("pitsReportFilters2_pt")).stream().mapToInt(x->x.intValue()).toArray()));//new int[] {0, 12}));
		elements.add(new addRuleListElement(driver, depthRules3Val, "pitsReportFilters_pt", 1, ((List<Double>) argumentFile.uniqueValues.get("pitsReportFilters3_pt")).stream().mapToInt(x->x.intValue()).toArray()));//new int[] {1, 0, 1, 1, 12, 13}));
		elements.add(new addRuleListElement(driver, null, "pitsReportFilters_pt", 0, ((List<Double>) argumentFile.uniqueValues.get("pitsReportFilters4_pt")).stream().mapToInt(x->x.intValue()).toArray()));//new int[] {1, 18}));
		elements.add(new addRuleListElement(driver, depthRules4Val, "pitsReportFilters_pt", 1,((List<Double>) argumentFile.uniqueValues.get("pitsReportFilters5_pt")).stream().mapToInt(x->x.intValue()).toArray()));// new int[] {1, 0, 14, 0, 2, 11}));
		//Test Removal - Note the importance of how these counter correlate with one another
		elements.add(new removeRuleListElement(driver, null, "pitsReportFilters_pt", 4));
		elements.add(new addRuleListElement(driver, depthRules5Val, "pitsReportFilters_pt", 0, ((List<Double>) argumentFile.uniqueValues.get("pitsReportFilters6_pt")).stream().mapToInt(x->x.intValue()).toArray()));//new int[] {1, 18}));
		
		elements.add(new IWVElement(driver, pitIntVal, "allPitsAssociated_iwv", "Hello World", argumentFile.defaultValues.includeIWVorIWVS));
		//Expand all of Pits Under Repairs
		elements.add(new OpenExpansionPanels(driver, null, "underRepairs_pt", new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}));
		elements.add(new CBListElement(driver, pitAutoClassifyVal, "markAsRepaired_ms", argumentFile.defaultValues.CBLVal));
		
		//Pit Repaired With ___
		//Instancing is required. As such, each tab has an if statement to handle its parameters.
		elements = addRepairedWithElements(elements, sleeveRGVal, sleeveDepthVal, sleeveLabelVal, sleeveRepDigVal,
				0, driver, 
				argumentFile.defaultValues.defaultRGValues == 1 ? true : false, argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.defaultIWVValue, 
				argumentFile.defaultValues.includeCB, argumentFile.defaultValues.includeIWVorIWVS, argumentFile.defaultValues.includeIWVorIWVS);
		elements = addRepairedWithElements(elements, compRRGVal, compRDepthVal, compRLabelVal, compRRepDigVal,
				1, driver, 
				argumentFile.defaultValues.defaultRGValues == 1 ? true : false, argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.defaultIWVValue, 
				argumentFile.defaultValues.includeCB, argumentFile.defaultValues.includeIWVorIWVS, argumentFile.defaultValues.includeIWVorIWVS);
		elements = addRepairedWithElements(elements, patchesRGVal, patchesDepthVal, patchesLabelVal, patchesRepDigVal,
				2, driver, 
				argumentFile.defaultValues.defaultRGValues == 1 ? true : false, argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.defaultIWVValue, 
				argumentFile.defaultValues.includeCB, argumentFile.defaultValues.includeIWVorIWVS, argumentFile.defaultValues.includeIWVorIWVS);
		elements = addRepairedWithElements(elements, halfSRGVal, halfSDepthVal, halfSLabelVal, halfSRepDigVal,
				3, driver, 
				argumentFile.defaultValues.defaultRGValues == 1 ? true : false, argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.defaultIWVValue, 
				argumentFile.defaultValues.includeCB, argumentFile.defaultValues.includeIWVorIWVS, argumentFile.defaultValues.includeIWVorIWVS);
		elements = addRepairedWithElements(elements, weldEndRGVal, weldEndDepthVal, weldEndLabelVal, weldEndRepDigVal,
				4, driver, 
				argumentFile.defaultValues.defaultRGValues == 1 ? true : false, argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.defaultIWVValue, 
				argumentFile.defaultValues.includeCB, argumentFile.defaultValues.includeIWVorIWVS, argumentFile.defaultValues.includeIWVorIWVS);
		elements = addRepairedWithElements(elements, clampsRGVal, clampsDepthVal, clampsLabelVal, clampsRepDigVal,
				5, driver, 
				argumentFile.defaultValues.defaultRGValues == 1 ? true : false, argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.defaultIWVValue, 
				argumentFile.defaultValues.includeCB, argumentFile.defaultValues.includeIWVorIWVS, argumentFile.defaultValues.includeIWVorIWVS);
		elements = addRepairedWithElements(elements, recoatRGVal, recoatDepthVal, recoatLabelVal, recoatRepDigVal,
				6, driver, 
				argumentFile.defaultValues.defaultRGValues == 1 ? true : false, argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.defaultIWVValue, 
				argumentFile.defaultValues.includeCB, argumentFile.defaultValues.includeIWVorIWVS, argumentFile.defaultValues.includeIWVorIWVS);
		elements = addRepairedWithElements(elements, genRepRGVal, genRepDepthVal, genRepLabelVal, genRepRepDigVal,
				7, driver, 
				argumentFile.defaultValues.defaultRGValues == 1 ? true : false, argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.defaultIWVValue, 
				argumentFile.defaultValues.includeCB, argumentFile.defaultValues.includeIWVorIWVS, argumentFile.defaultValues.includeIWVorIWVS);
		
		//End of Pits Under Repairs
		
		//MFGs
		elements.add(new IWVElement(driver, MFGAmpVal, "reportWithAmplitudes_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, MFGDepthVal, "reportWithDepth_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
		
		//Enabled Dependency. Adjust as needed. Currently set to enable and set both values.
		boolean overrideMFGClassificationLabel = (Boolean) argumentFile.uniqueValues.get("attributeSizingTopL_iwvs");
		elements.add(new IWVSElement(driver, MFGClassVal, "attributeSizingTopL_iwvs", argumentFile.defaultValues.defaultIWVSValue, overrideMFGClassificationLabel));
		if(overrideMFGClassificationLabel)
		{
			elements.add(new IWVSElement(driver, MDSMFGVal, "overrideClassificationLabel_iwvs", argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.includeIWVorIWVS));
		}
		
		elements.add(new IWVSElement(driver, discrLabelVal, "appendDiscrimination_iwvs", argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVSElement(driver, orientLabelVal, "appendOrientation_iwvs", argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.includeIWVorIWVS));
		
		
		//Weld interactions
		boolean processGWI = (Boolean) argumentFile.uniqueValues.get("processGWInteraction_cb");
		elements.add(new CBElement(driver, processGWVal, "processGWInteraction_cb", processGWI));
		if(processGWI)
		{
			boolean customInteraction = ((Double) argumentFile.uniqueValues.get("gwInteraction_rg")).intValue() == 1 ? true : false;
			elements.add(new RGElement(driver, RGIntVal, "gwInteraction_rg", customInteraction ? 1 : 0));
			if(customInteraction)
			{
				elements.add(new TextElement(driver, customNumVal, "markGWCIBox_va", Integer.toString(argumentFile.defaultValues.defaultIWVSValue)));
				elements.add(new SelectElement(driver, customUnitVal, "markGWCIBox_va", 0));
				elements.add(new IWVElement(driver, customLabelVal, "appendGWCILabel_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			}
			else
			{
				elements.add(new IWVElement(driver, stdIntVal, "appendGWSILabel_iwv", argumentFile.defaultValues.defaultIWVValue, false));
			}
		}
		
		elements.add(new IWVElement(driver, seamIntVal, "appendLabelWhenInSeam_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		
		elements.add(new IWVElement(driver, incOverspeedDescVal, "overspeed_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, incDegradedDescVal, "degradedSensors_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, incDegOverDescVal, "degradedSensorsAndOverspeed_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, incBeyondDescVal, "degradedSensorsBeyondSpec_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, inOverBeyondDescVal, "overspeedBeyondSpec_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, incOverSensorBeyondDescVal, "degradedSensorsAndOverspeedBeyondSpec_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		
		//Drag Listing
		elements.add(new DragBoggleElement(driver, componentListVal, "componentsOrder_cl", argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));;
		
		//Pits Analysis Intervention
		elements.add(new TextElement(driver, deviationsVal, "additionalNotes_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, examplesVal, "examples_ta", argumentFile.defaultValues.defaultTextValue));
		
		boolean changePitsClassification = ((Double) argumentFile.uniqueValues.get("classification_rg")).intValue() == 1 ? true : false;
		if(changePitsClassification)
		{
			elements.add(new RGElement(driver, pitsClassRGVal, "classification_rg", 1));
			elements.add(new CBListElement(driver, pitsClassListVal, "pitClassification_ms", argumentFile.defaultValues.CBLVal)); //Presence dependent on Radio Group selection
		}
		else
		{
			elements.add(new RGElement(driver, pitsClassRGVal, "classification_rg", 0));
		}
		
		//Pits Under Repairs - As a list, instancing is required.
		elements.add(new OpenExpansionPanels(driver, null, "underRepair_pt", new int[]{0, 1, 2, 3, 4, 5})); //Last 2 Tabs are Empty
		
		//Due to a particular issue with this page, enable these for interaction first.
		elements.add(new CBElement(driver, null, "updateComponent_c", true));
		elements.get(elements.size() - 1).setDesiredInstance(0);
		elements.add(new CBElement(driver, null, "updateComponent_c", true));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new CBElement(driver, null, "updateComponent_c", true));
		elements.get(elements.size() - 1).setDesiredInstance(2);
		elements.add(new CBElement(driver, null, "updateComponent_c", true));
		elements.get(elements.size() - 1).setDesiredInstance(3);
		elements.add(new CBElement(driver, null, "updateComponent_c", true));
		elements.get(elements.size() - 1).setDesiredInstance(4);
		elements.add(new CBElement(driver, null, "updateComponent_c", true));
		elements.get(elements.size() - 1).setDesiredInstance(5);
		
		elements.add(new SimpleDataSourceElement(driver, sleevesConfigVal, "updateComponent_c", 
				(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), argumentFile.defaultValues.simpleDataSourceTextVal, 
				true, true, argumentFile.defaultValues.includeSimpleDataSource));
		elements.get(elements.size() - 1).setDesiredInstance(0);
		elements.add(new SimpleDataSourceElement(driver, compRepConfigVal, "updateComponent_c", 
				(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), argumentFile.defaultValues.simpleDataSourceTextVal, 
				true, true, argumentFile.defaultValues.includeSimpleDataSource));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new SimpleDataSourceElement(driver, patchesConfigVal, "updateComponent_c", 
				(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), argumentFile.defaultValues.simpleDataSourceTextVal, 
				true, true, argumentFile.defaultValues.includeSimpleDataSource));
		elements.get(elements.size() - 1).setDesiredInstance(2);
		elements.add(new SimpleDataSourceElement(driver, halfSolesConfigVal, "updateComponent_c", 
				(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), argumentFile.defaultValues.simpleDataSourceTextVal, 
				true, true, argumentFile.defaultValues.includeSimpleDataSource));
		elements.get(elements.size() - 1).setDesiredInstance(3);
		elements.add(new SimpleDataSourceElement(driver, WeldEndConfigVal, "updateComponent_c", 
				(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), argumentFile.defaultValues.simpleDataSourceTextVal, 
				true, true, argumentFile.defaultValues.includeSimpleDataSource));
		elements.get(elements.size() - 1).setDesiredInstance(4);
		elements.add(new SimpleDataSourceElement(driver, clampsConfigVal, "updateComponent_c", 
				(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), argumentFile.defaultValues.simpleDataSourceTextVal, 
				true, true, argumentFile.defaultValues.includeSimpleDataSource));
		elements.get(elements.size() - 1).setDesiredInstance(5);
		
		elements.add(new CBElement(driver, null, "updateComponent_c", argumentFile.defaultValues.includeSimpleDataSource));
		elements.get(elements.size() - 1).setDesiredInstance(0);
		elements.add(new CBElement(driver, null, "updateComponent_c", argumentFile.defaultValues.includeSimpleDataSource));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new CBElement(driver, null, "updateComponent_c", argumentFile.defaultValues.includeSimpleDataSource));
		elements.get(elements.size() - 1).setDesiredInstance(2);
		elements.add(new CBElement(driver, null, "updateComponent_c", argumentFile.defaultValues.includeSimpleDataSource));
		elements.get(elements.size() - 1).setDesiredInstance(3);
		elements.add(new CBElement(driver, null, "updateComponent_c", argumentFile.defaultValues.includeSimpleDataSource));
		elements.get(elements.size() - 1).setDesiredInstance(4);
		elements.add(new CBElement(driver, null, "updateComponent_c", argumentFile.defaultValues.includeSimpleDataSource));
		elements.get(elements.size() - 1).setDesiredInstance(5);
		
		
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
		compTest.compaireDB(elements, "Pits", tables.PITS, "PitsResults", argumentFile.FileCounter);
	}
}