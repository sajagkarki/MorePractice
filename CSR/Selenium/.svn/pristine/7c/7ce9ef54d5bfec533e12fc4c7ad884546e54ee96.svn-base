package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.CSREnums;
import com.tdw.csr.entity.CSREnums.DentsMarkAsRepairedType;
import com.tdw.csr.entity.CSREnums.Standard;
import com.tdw.csr.entity.casings.Casings;
import com.tdw.csr.entity.deformations.dents.Dents;
import com.tdw.csr.entity.miscellaneous.Miscellaneous;
import com.tdw.csr.entity.valves.Valves;
import com.tdw.csr.entity.welds.Welds;

import chromedriver.CompaireDB.tables;
//This wildcard import is meant to import all subclasses of UIElements
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

public class ValvesCDTest extends BaseCDTest {

	ElementValidationInterface launchVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.returnedValues 
						= (typedList.get(0).launchReceive.launcherType.include ? "True" : "False")
						+ ", " + typedList.get(0).launchReceive.launcherType.value;
				
				return (typedList.get(0).launchReceive.launcherType.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).launchReceive.launcherType.value));
			};
	ElementValidationInterface receiveVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.returnedValues 
						= (typedList.get(0).launchReceive.receiverType.include ? "True" : "False")
						+ ", " + typedList.get(0).launchReceive.receiverType.value;
				
				return (typedList.get(0).launchReceive.receiverType.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).launchReceive.receiverType.value));
			};
	ElementValidationInterface incStaVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.returnedValues 
						= (typedList.get(0).launchReceive.includeStationing ? "True" : "False");
				
				return (typedList.get(0).launchReceive.includeStationing == ele.bool);
			};
	
	ElementValidationInterface staPrefixVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.returnedValues 
						= (typedList.get(0).launchReceive.commonAttributes.stationingPrefix.include ? "True" : "False")
						+ ", " + typedList.get(0).launchReceive.commonAttributes.stationingPrefix.value;
				
				return (typedList.get(0).launchReceive.commonAttributes.stationingPrefix.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).launchReceive.commonAttributes.stationingPrefix.value));
			};
	ElementValidationInterface encStaVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.returnedValues 
						= (typedList.get(0).launchReceive.commonAttributes.encloseStationingInBraces ? "True" : "False");
				
				return (typedList.get(0).launchReceive.commonAttributes.encloseStationingInBraces == ele.bool);
			};
	ElementValidationInterface notIncVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.returnedValues 
						= (typedList.get(0).launchReceive.commonAttributes.omitLocalizationSeparator ? "True" : "False");
				
				return (typedList.get(0).launchReceive.commonAttributes.omitLocalizationSeparator == ele.bool);
			};
	ElementValidationInterface milePostingVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				String[] mapping = {"MP", "KP", "KMP"};
				
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).launchReceive.commonAttributes.milePostingPrefix.include ? "True" : "False")
						+ ", " + typedList.get(0).launchReceive.commonAttributes.milePostingPrefix.value;
				
				return (typedList.get(0).launchReceive.commonAttributes.milePostingPrefix.include == ele.bool)
						&& (CSREnums.MilePostingPrefixType.valueOf(mapping[ele.dropDownIndex]).equals(typedList.get(0).launchReceive.commonAttributes.milePostingPrefix.value));
			};
			
	
	ElementValidationInterface componentList1Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.returnedValues
						= typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(1).separatorSpacing
						+ ", " + typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(2).component
						+ ", " + typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(2).separator
						+ ", " + typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(2).separatorSpacing
						+ ", " + typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(3).component
						+ ", " + typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(3).separator
						+ ", " + typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(3).separatorSpacing
						+ ", " + typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(4).component
						+ ", " + typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(4).separator
						+ ", " + typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(4).separatorSpacing;;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(1).separatorSpacing.toString()))
				&& (ele.validationStrings.get(6).equals(typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(2).component))
				&& (ele.validationStrings.get(7) == null || ele.validationStrings.get(7).equals(typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(2).separator.toString()))
				&& (ele.validationStrings.get(8) == null || ele.validationStrings.get(8).equals(typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(2).separatorSpacing.toString()))
				&& (ele.validationStrings.get(9).equals(typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(3).component))
				&& (ele.validationStrings.get(10) == null || ele.validationStrings.get(10).equals(typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(3).separator.toString()))
				&& (ele.validationStrings.get(11)) == null || ele.validationStrings.get(11).equals(typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(3).separatorSpacing.toString())
				&& (ele.validationStrings.get(12).equals(typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(4).component))
				&& (ele.validationStrings.get(13) == null || ele.validationStrings.get(13).equals(typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(4).separator.toString()))
				&& (ele.validationStrings.get(14)) == null || ele.validationStrings.get(14).equals(typedList.get(0).launchReceive.commonAttributes.componentsOrder.hashtable.get(4).separatorSpacing.toString());
			};
			
			
	ElementValidationInterface incTypeVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.returnedValues 
						= (typedList.get(0).intermediate.includeValveType ? "True" : "False");
				
				return (typedList.get(0).intermediate.includeValveType == ele.bool);
			};
	ElementValidationInterface encSta2Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.returnedValues 
				= (typedList.get(0).intermediate.commonAttributes.stationingPrefix.include ? "True" : "False")
				+ ", " + typedList.get(0).intermediate.commonAttributes.stationingPrefix.value;
				
				return (typedList.get(0).intermediate.commonAttributes.stationingPrefix.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).intermediate.commonAttributes.stationingPrefix.value));
			};
	ElementValidationInterface encSta3Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.returnedValues 
						= (typedList.get(0).intermediate.commonAttributes.encloseStationingInBraces ? "True" : "False");
				
				return (typedList.get(0).intermediate.commonAttributes.encloseStationingInBraces == ele.bool);
			};
	ElementValidationInterface locNotProvidedVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.returnedValues 
						= (typedList.get(0).intermediate.commonAttributes.omitLocalizationSeparator ? "True" : "False");
				
				return (typedList.get(0).intermediate.commonAttributes.omitLocalizationSeparator == ele.bool);
			};
	ElementValidationInterface milePosting2Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				String[] mapping = {"MP", "KP", "KMP"};
				
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				
				ele.returnedValues 
				= (typedList.get(0).intermediate.commonAttributes.milePostingPrefix.include ? "True" : "False")
				+ ", " + typedList.get(0).intermediate.commonAttributes.milePostingPrefix.value;
				
				return (typedList.get(0).intermediate.commonAttributes.milePostingPrefix.include == ele.bool)
						&& (CSREnums.MilePostingPrefixType.valueOf(mapping[ele.dropDownIndex]).equals(typedList.get(0).intermediate.commonAttributes.milePostingPrefix.value));
			};
			
			
	ElementValidationInterface componentList2Val = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.returnedValues
						= typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(1).separatorSpacing
						+ ", " + typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(2).component
						+ ", " + typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(2).separator
						+ ", " + typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(2).separatorSpacing
						+ ", " + typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(3).component
						+ ", " + typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(3).separator
						+ ", " + typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(3).separatorSpacing
						+ ", " + typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(4).component
						+ ", " + typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(4).separator
						+ ", " + typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(4).separatorSpacing;;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(1).separatorSpacing.toString()))
				&& (ele.validationStrings.get(6).equals(typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(2).component))
				&& (ele.validationStrings.get(7) == null || ele.validationStrings.get(7).equals(typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(2).separator.toString()))
				&& (ele.validationStrings.get(8) == null || ele.validationStrings.get(8).equals(typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(2).separatorSpacing.toString()))
				&& (ele.validationStrings.get(9).equals(typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(3).component))
				&& (ele.validationStrings.get(10) == null || ele.validationStrings.get(10).equals(typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(3).separator.toString()))
				&& (ele.validationStrings.get(11)) == null || ele.validationStrings.get(11).equals(typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(3).separatorSpacing.toString())
				&& (ele.validationStrings.get(12).equals(typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(4).component))
				&& (ele.validationStrings.get(13) == null || ele.validationStrings.get(13).equals(typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(4).separator.toString()))
				&& (ele.validationStrings.get(14)) == null || ele.validationStrings.get(14).equals(typedList.get(0).intermediate.commonAttributes.componentsOrder.hashtable.get(4).separatorSpacing.toString());
			};
			
			
	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Valves> typedList = (List<Valves>) list;
				
				ele.returnedValues 
						= typedList.get(0).ai.additionalNotes;
				
				return ele.txtValue.equals(typedList.get(0).ai.additionalNotes);
			};
	ElementValidationInterface markingVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Valves> typedList = (List<Valves>) list;
				
				ele.returnedValues 
						= typedList.get(0).ai.examples;
				
				return ele.txtValue.equals(typedList.get(0).ai.examples);
			};
			
	ElementValidationInterface abscenceVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				String[] mapping = {"Reducer"};
				
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
				= (typedList.get(0).ai.launchReceive.substituteReferenceWhenNoPhysicalLaunchReceive.include ? "True" : "False")
				+ ", " + typedList.get(0).ai.launchReceive.substituteReferenceWhenNoPhysicalLaunchReceive.value;
				
				return (typedList.get(0).ai.launchReceive.substituteReferenceWhenNoPhysicalLaunchReceive.include == ele.bool)
						&& (mapping[ele.dropDownIndex].equals(typedList.get(0).ai.launchReceive.substituteReferenceWhenNoPhysicalLaunchReceive.value));
			};
	ElementValidationInterface artificialVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				String[] mapping = {"Reducer"};
				
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
				= (typedList.get(0).ai.launchReceive.artificialReferenceWhenPitsRequired.include ? "True" : "False")
				+ ", " + typedList.get(0).ai.launchReceive.artificialReferenceWhenPitsRequired.value;
				
				return (typedList.get(0).ai.launchReceive.artificialReferenceWhenPitsRequired.include == ele.bool)
						&& (mapping[ele.dropDownIndex].equals(typedList.get(0).ai.launchReceive.artificialReferenceWhenPitsRequired.value));
			};
			
	ElementValidationInterface valveTypeVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.secondaryList;
				
				ele.returnedValues 
						= (typedList.get(0).ai.launchReceive.commonAttributes.valveNameDataSource.include ? "True" : "False");
						
						//Hashtable size is dynamic
						for(int i = 0; i < ele.secondaryList.size(); i++) {
							ele.returnedValues += ", " + typedList.get(0).ai.launchReceive.commonAttributes.valveNameDataSource.value.hashtable.get(i);
						}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).ai.launchReceive.commonAttributes.valveNameDataSource.include == ele.tertiaryFlag;
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(0 + i).equals(typedList.get(0).ai.launchReceive.commonAttributes.valveNameDataSource.value.hashtable.get(i));
				}
				
				return pass;
			};	
	ElementValidationInterface addStaVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.returnedValues 
						= (typedList.get(0).ai.launchReceive.commonAttributes.stationing.include ? "True" : "False")
						+ ", " + typedList.get(0).ai.launchReceive.commonAttributes.stationing.formatStandard
						+ ", " + typedList.get(0).ai.launchReceive.commonAttributes.stationing.customFormat;
						
						//Hashtable size is dynamic
						for(int i = 0; i < ele.secondaryList.size(); i++) {
							ele.returnedValues += ", " + typedList.get(0).ai.launchReceive.commonAttributes.stationing.dataSource.hashtable.get(i);
						}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).ai.launchReceive.commonAttributes.stationing.include == ele.bool
						&& Standard.valueOf(ele.validationStrings.get(1)) == (typedList.get(0).ai.launchReceive.commonAttributes.stationing.formatStandard)
						&& (ele.txtValue == null || ele.validationStrings.get(2).equals(typedList.get(0).ai.launchReceive.commonAttributes.stationing.customFormat));
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(3 + i).equals(typedList.get(0).ai.launchReceive.commonAttributes.stationing.dataSource.hashtable.get(i));
				}
				
				return pass;
			};	
	ElementValidationInterface addMileVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.txtValue + ", " + ele.secondaryList;
				
				ele.returnedValues 
						= (typedList.get(0).ai.launchReceive.commonAttributes.milePosting.include ? "True" : "False")
						+ ", " + typedList.get(0).ai.launchReceive.commonAttributes.milePosting.customFormat;
						
						//Hashtable size is dynamic
						for(int i = 0; i < ele.secondaryList.size(); i++) {
							ele.returnedValues += ", " + typedList.get(0).ai.launchReceive.commonAttributes.milePosting.dataSource.hashtable.get(i);
						}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).ai.launchReceive.commonAttributes.milePosting.include == ele.tertiaryFlag
						&& (ele.txtValue.equals(typedList.get(0).ai.launchReceive.commonAttributes.milePosting.customFormat) || ele.txtValue == null);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(0 + i).equals(typedList.get(0).ai.launchReceive.commonAttributes.milePosting.dataSource.hashtable.get(i));
				}
				
				return pass;
			};	
	ElementValidationInterface localizationVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.secondaryList;
				
				ele.returnedValues 
						= (typedList.get(0).ai.launchReceive.commonAttributes.descriptionDataSource.include ? "True" : "False");
						
						//Hashtable size is dynamic
						for(int i = 0; i < ele.secondaryList.size(); i++) {
							ele.returnedValues += ", " + typedList.get(0).ai.launchReceive.commonAttributes.descriptionDataSource.value.hashtable.get(i);
						}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).ai.launchReceive.commonAttributes.descriptionDataSource.include == ele.tertiaryFlag;
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(0 + i).equals(typedList.get(0).ai.launchReceive.commonAttributes.descriptionDataSource.value.hashtable.get(i));
				}
				
				return pass;
			};	
	ElementValidationInterface commentsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.secondaryList;
				
				ele.returnedValues 
						= (typedList.get(0).ai.launchReceive.commonAttributes.commentsDataSource.include ? "True" : "False");
						
						//Hashtable size is dynamic
						for(int i = 0; i < ele.secondaryList.size(); i++) {
							ele.returnedValues += ", " + typedList.get(0).ai.launchReceive.commonAttributes.commentsDataSource.value.hashtable.get(i);
						}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).ai.launchReceive.commonAttributes.commentsDataSource.include == ele.tertiaryFlag;
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(0 + i).equals(typedList.get(0).ai.launchReceive.commonAttributes.commentsDataSource.value.hashtable.get(i));
				}
				
				return pass;
			};	
			
			
	ElementValidationInterface CBListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;

				//As the db hashtable is not necessarily in the same order as the checklist, a map is used.
				String[] mapping = {
						"Check Valve",
						"Ball Valve",
						"Valve (Main Line Valve)"
				};
				
				boolean allMatching = true;
				
				for(int i = 0; i < ele.controlIndices.length; i++)
				{
					String tkey = mapping[i];
					
					if(i != 0)
						ele.returnedValues += ", ";
					
					ele.returnedValues += (typedList.get(0).ai.intermediate.valveTypes.hashtable.get(tkey) ? "True" : "False");
					
					if(typedList.get(0).ai.intermediate.valveTypes.hashtable.get(tkey) != (ele.controlIndices[i] == 1 ? true : false))
						allMatching = false;
				}
				
				return allMatching;
			};	
	ElementValidationInterface DSVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.expectedValue = ele.secondaryList.toString();
				
				ele.returnedValues 
						= "";
				
				//Hashtable size is dynamic
				for(int i = 0; i < ele.secondaryList.size(); i++) {
					if(i != 0)
						ele.returnedValues += ", ";
					ele.returnedValues += typedList.get(0).ai.intermediate.valveTypesDataSource.hashtable.get(i);
				}
		
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = true;
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(0 + i).equals(typedList.get(0).ai.intermediate.valveTypesDataSource.hashtable.get(i));
				}
				
				return pass;
			};	
					
	ElementValidationInterface markAGMVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.returnedValues 
						= (typedList.get(0).ai.intermediate.markAgmsAndValvesSeparately ? "True" : "False");
				
				return (typedList.get(0).ai.intermediate.markAgmsAndValvesSeparately == ele.bool);
			};	
	ElementValidationInterface interValveTypeVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.secondaryList;
				
				ele.returnedValues 
						= (typedList.get(0).ai.intermediate.commonAttributes.valveNameDataSource.include ? "True" : "False");
						
						//Hashtable size is dynamic
						for(int i = 0; i < ele.secondaryList.size(); i++) {
							ele.returnedValues += ", " + typedList.get(0).ai.intermediate.commonAttributes.valveNameDataSource.value.hashtable.get(i);
						}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).ai.intermediate.commonAttributes.valveNameDataSource.include == ele.tertiaryFlag;
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(0 + i).equals(typedList.get(0).ai.intermediate.commonAttributes.valveNameDataSource.value.hashtable.get(i));
				}
				
				return pass;
			};	
	ElementValidationInterface addStationingVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.returnedValues 
						= (typedList.get(0).ai.intermediate.commonAttributes.stationing.include ? "True" : "False")
						+ ", " + typedList.get(0).ai.intermediate.commonAttributes.stationing.formatStandard
						+ ", " + typedList.get(0).ai.intermediate.commonAttributes.stationing.customFormat;
						
						//Hashtable size is dynamic
						for(int i = 0; i < ele.secondaryList.size(); i++) {
							ele.returnedValues += ", " + typedList.get(0).ai.intermediate.commonAttributes.stationing.dataSource.hashtable.get(i);
						}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).ai.intermediate.commonAttributes.stationing.include == ele.bool
						&& Standard.valueOf(ele.validationStrings.get(1)) == (typedList.get(0).ai.intermediate.commonAttributes.stationing.formatStandard)
						&& (ele.validationStrings.get(2).equals(typedList.get(0).ai.intermediate.commonAttributes.stationing.customFormat) || ele.txtValue == null);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(3 + i).equals(typedList.get(0).ai.intermediate.commonAttributes.stationing.dataSource.hashtable.get(i));
				}
				
				return pass;
			};	
	ElementValidationInterface addMPVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.txtValue + ", " + ele.secondaryList;
				
				ele.returnedValues 
						= (typedList.get(0).ai.intermediate.commonAttributes.milePosting.include ? "True" : "False")
						+ ", " + typedList.get(0).ai.intermediate.commonAttributes.milePosting.customFormat;
						
						//Hashtable size is dynamic
						for(int i = 0; i < ele.secondaryList.size(); i++) {
							ele.returnedValues += ", " + typedList.get(0).ai.intermediate.commonAttributes.milePosting.dataSource.hashtable.get(i);
						}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).ai.intermediate.commonAttributes.milePosting.include == ele.tertiaryFlag
						&& (ele.txtValue.equals(typedList.get(0).ai.intermediate.commonAttributes.milePosting.customFormat) || ele.txtValue == null);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(0 + i).equals(typedList.get(0).ai.intermediate.commonAttributes.milePosting.dataSource.hashtable.get(i));
				}
				
				return pass;
			};	
	ElementValidationInterface interLocalizationVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.secondaryList;
				
				ele.returnedValues 
						= (typedList.get(0).ai.intermediate.commonAttributes.descriptionDataSource.include ? "True" : "False");
						
						//Hashtable size is dynamic
						for(int i = 0; i < ele.secondaryList.size(); i++) {
							ele.returnedValues += ", " + typedList.get(0).ai.intermediate.commonAttributes.descriptionDataSource.value.hashtable.get(i);
						}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).ai.intermediate.commonAttributes.descriptionDataSource.include == ele.tertiaryFlag;
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(0 + i).equals(typedList.get(0).ai.intermediate.commonAttributes.descriptionDataSource.value.hashtable.get(i));
				}
				
				return pass;
			};	
	ElementValidationInterface interCommentsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.secondaryList;
				
				ele.returnedValues 
						= (typedList.get(0).ai.intermediate.commonAttributes.commentsDataSource.include ? "True" : "False");
						
						//Hashtable size is dynamic
						for(int i = 0; i < ele.secondaryList.size(); i++) {
							ele.returnedValues += ", " + typedList.get(0).ai.intermediate.commonAttributes.commentsDataSource.value.hashtable.get(i);
						}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).ai.intermediate.commonAttributes.commentsDataSource.include == ele.tertiaryFlag;
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(0 + i).equals(typedList.get(0).ai.intermediate.commonAttributes.commentsDataSource.value.hashtable.get(i));
				}
				
				return pass;
			};	
			
	ElementValidationInterface nonXYZVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Valves> typedList = (List<Valves>) list;
				
				ele.expectedValue = (ele.tertiaryFlag ? "True" : "False") + ", " + ele.secondaryList;
				
				ele.returnedValues 
						= (typedList.get(0).ai.useClientLatLongsDataSource.include ? "True" : "False");
						
						//Hashtable size is dynamic
						for(int i = 0; i < ele.secondaryList.size(); i++) {
							ele.returnedValues += ", " + typedList.get(0).ai.useClientLatLongsDataSource.value.hashtable.get(i);
						}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).ai.useClientLatLongsDataSource.include == ele.tertiaryFlag;
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(0 + i).equals(typedList.get(0).ai.useClientLatLongsDataSource.value.hashtable.get(i));
				}
				
				return pass;
			};	
			
			
	public List<String> componentPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Valve Type");
		cPL.add("Valve Name");
		cPL.add("Mile Posting");
		cPL.add("Localization");
		cPL.add("Stationing");
		
		return cPL;
	}
	
	public List<String> intermediatePriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Valve Type");
		cPL.add("Localization");
		cPL.add("Valve Name");
		cPL.add("Mile Posting");
		cPL.add("Stationing");
		
		return cPL;
	}
	
	public List<String> valveAcceptedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Client Questionnaire");
		cPL.add("Alignment Maps");
		
		return cPL;
	}
	
	public List<String> valveSelectedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listings");
		cPL.add("Tracking Sheet");
		cPL.add("Odometer Data");
		cPL.add("Previous Runs");
		
		return cPL;
	}
	
	public List<String> staAcceptedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Alignment Maps");
		cPL.add("Client Questionnaire");
		cPL.add("Odometer Data");
		
		return cPL;
	}
	
	public List<String> staSelectedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listings");
		cPL.add("Tracking Sheet");
		cPL.add("Previous Runs");
		
		return cPL;
	}
	
	public List<String> mileAcceptedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Client Questionnaire");
		cPL.add("Alignment Maps");
		
		return cPL;
	}
	
	public List<String> mileSelectedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listings");
		cPL.add("Tracking Sheet");
		cPL.add("Odometer Data");
		cPL.add("Previous Runs");
		
		return cPL;
	}
	
	public List<String> localizationAcceptedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Alignment Maps");
		
		return cPL;
	}
	
	public List<String> localizationSelectedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listing");
		cPL.add("Tracking Sheet");
		cPL.add("Previous Runs");
		
		return cPL;
	}
	
	public List<String> commentsAcceptedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Alignment Maps");
		cPL.add("Pipe Listing");
		cPL.add("Tracking Sheet");
		
		return cPL;
	}
	
	public List<String> commentsSelectedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Previous Runs");
		
		return cPL;
	}
	
	
	public List<String> intermediateValvesAcceptedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Alignment Maps");
		cPL.add("Pipe Listing");
		cPL.add("Tracking Sheet");
		
		return cPL;
	}
	
	public List<String> intermediateValvesSelectedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Previous Runs");
		
		return cPL;
	}
	
	public List<String> intermediateValveTypeAcceptedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Odometer Data");
		cPL.add("Alignment Maps");
		cPL.add("Client Questionnaire");
		
		return cPL;
	}
	
	public List<String> intermediateValveTypeSelectedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listings");
		cPL.add("Previous Runs");
		cPL.add("Tracking Sheet");
		
		return cPL;
	}
	
	public List<String> intermediateStaAcceptedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Odometer Data");
		cPL.add("Client Questionnaire");
		
		return cPL;
	}
	
	public List<String> intermediateStaSelectedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listings");
		cPL.add("Alignment Maps");
		cPL.add("Previous Runs");
		cPL.add("Tracking Sheet");
		
		return cPL;
	}
	
	public List<String> intermediateMileAcceptedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Odometer Data");
		cPL.add("Client Questionnaire");
		cPL.add("Previous Runs");
		cPL.add("Tracking Sheet");
		
		return cPL;
	}
	
	public List<String> intermediateMileSelectedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listings");
		cPL.add("Alignment Maps");
		
		return cPL;
	}
	
	public List<String> intermediateLocalizationAcceptedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Alignment Maps");
		cPL.add("Tracking Sheet");
		
		return cPL;
	}
	
	public List<String> intermediateLocalizationSelectedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listing");
		cPL.add("Previous Runs");
		
		return cPL;
	}
	
	public List<String> intermediateCommentsAcceptedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listing");
		cPL.add("Tracking Sheet");
		cPL.add("Previous Runs");
		
		return cPL;
	}
	
	public List<String> intermediateCommentsSelectedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Alignment Maps");
		
		return cPL;
	}
	
	public List<String> valveAcceptedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Client Questionnaire");
		cPL.add("Alignment Maps");
		
		return cPL;
	}
	
	public List<String> valveSelectedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listings");
		cPL.add("Tracking Sheet");
		cPL.add("Odometer Data");
		cPL.add("Previous Runs");
		
		return cPL;
	}
	
	public List<String> staAcceptedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Alignment Maps");
		cPL.add("Client Questionnaire");
		cPL.add("Odometer Data");
		
		return cPL;
	}
	
	public List<String> staSelectedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listings");
		cPL.add("Tracking Sheet");
		cPL.add("Previous Runs");
		
		return cPL;
	}
	
	public List<String> mileAcceptedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Client Questionnaire");
		cPL.add("Alignment Maps");
		
		return cPL;
	}
	
	public List<String> mileSelectedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listings");
		cPL.add("Tracking Sheet");
		cPL.add("Odometer Data");
		cPL.add("Previous Runs");
		
		return cPL;
	}
	
	public List<String> localizationAcceptedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Alignment Maps");
		
		return cPL;
	}
	
	public List<String> localizationSelectedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listing");
		cPL.add("Tracking Sheet");
		cPL.add("Previous Runs");
		
		return cPL;
	}
	
	public List<String> commentsAcceptedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Alignment Maps");
		cPL.add("Pipe Listing");
		cPL.add("Tracking Sheet");
		
		return cPL;
	}
	
	public List<String> commentsSelectedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Previous Runs");
		
		return cPL;
	}
	
	
	public List<String> intermediateValvesAcceptedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Alignment Maps");
		cPL.add("Pipe Listing");
		cPL.add("Tracking Sheet");
		
		return cPL;
	}
	
	public List<String> intermediateValvesSelectedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Previous Runs");
		
		return cPL;
	}
	
	public List<String> intermediateValveTypeAcceptedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Odometer Data");
		cPL.add("Alignment Maps");
		cPL.add("Client Questionnaire");
		
		return cPL;
	}
	
	public List<String> intermediateValveTypeSelectedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listings");
		cPL.add("Previous Runs");
		cPL.add("Tracking Sheet");
		
		return cPL;
	}
	
	public List<String> intermediateStaAcceptedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Odometer Data");
		cPL.add("Client Questionnaire");
		
		return cPL;
	}
	
	public List<String> intermediateStaSelectedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listings");
		cPL.add("Alignment Maps");
		cPL.add("Previous Runs");
		cPL.add("Tracking Sheet");
		
		return cPL;
	}
	
	public List<String> intermediateMileAcceptedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Odometer Data");
		cPL.add("Client Questionnaire");
		cPL.add("Previous Runs");
		cPL.add("Tracking Sheet");
		
		return cPL;
	}
	
	public List<String> intermediateMileSelectedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listings");
		cPL.add("Alignment Maps");
		
		return cPL;
	}
	
	public List<String> intermediateLocalizationAcceptedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Alignment Maps");
		cPL.add("Tracking Sheet");
		
		return cPL;
	}
	
	public List<String> intermediateLocalizationSelectedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listing");
		cPL.add("Previous Runs");
		
		return cPL;
	}
	
	public List<String> intermediateCommentsAcceptedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listing");
		cPL.add("Tracking Sheet");
		cPL.add("Previous Runs");
		
		return cPL;
	}
	
	public List<String> intermediateCommentsSelectedList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Alignment Maps");
		
		return cPL;
	}
	
	public List<String> GPSAcceptedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Pipe Listing");
		cPL.add("Tracking Sheet");
		cPL.add("Previous Runs");
		
		return cPL;
	}
	
	public List<String> GPSSelectedList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Alignment Maps");
		
		return cPL;
	}
	
	@SuppressWarnings("unchecked")
	@ParameterizedTest
	@ValueSource(strings = {"Valves_1.json", "Valves_2.json"})
	public void testStopplesPage(String argument) throws Exception {
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
		
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-valves&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {
			
		elements.add(new IWVElement(driver, launchVal, "launcherType_iwv", argumentFile.defaultValues.defaultTextValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, receiveVal, "receiverType_iwv", argumentFile.defaultValues.defaultTextValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new CBElement(driver, incStaVal, "includeStationing_cb", argumentFile.defaultValues.includeCB));
		elements.add(new IWVElement(driver, staPrefixVal, "staPrefix_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new CBElement(driver, encStaVal, "encloseStationing_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, notIncVal, "omitLocalizationSeparator_cb", argumentFile.defaultValues.includeCB));
		elements.add(new IWVSElement(driver, milePostingVal, "addMilePrefix_iwvs", argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.includeCB));
		elements.add(new DragListElement(driver, componentList1Val, "order_cl", (List<String>) argumentFile.uniqueValues.get("order_cl"), 
				argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));

		elements.add(new CBElement(driver, incTypeVal, "attributeSizingTopL_cb", argumentFile.defaultValues.includeCB));
		//Next 4 are second instances
		elements.add(new IWVElement(driver, encSta2Val, "staPrefix_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new CBElement(driver, encSta3Val, "encloseStationing_cb", argumentFile.defaultValues.includeCB));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new CBElement(driver, locNotProvidedVal, "omitLocalizationSeparator_cb", argumentFile.defaultValues.includeCB));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new IWVSElement(driver, milePosting2Val, "addMilePrefix_iwvs", argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.includeIWVorIWVS)); 
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new DragListElement(driver, componentList2Val, "order_cl", (List<String>) argumentFile.uniqueValues.get("order_cl"), 
				argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		
		elements.add(new TextElement(driver, deviationsVal, "additionalNotes_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, markingVal, "examples_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new IWVSElement(driver, abscenceVal, "substituteReference_iwvs", 0, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVSElement(driver, artificialVal, "artificialReference_iwvs", 0, argumentFile.defaultValues.includeIWVorIWVS));
		
		elements.add(new SimpleDataSourceElement(driver, valveTypeVal, "maxDistance_iwd",  
				(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), 
				null, false, false, argumentFile.defaultValues.includeSimpleDataSource));
		elements.add(new StationingSelectElement(driver, addStaVal, "stationing_sta",  
				(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), 
				argumentFile.defaultValues.stationingSelection, argumentFile.defaultValues.customStationingValue, argumentFile.defaultValues.includeStationing));
		elements.add(new SimpleDataSourceElement(driver, addMileVal, "milePosting_mp",  
				(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), 
				argumentFile.defaultValues.simpleDataSourceTextVal, false, false, argumentFile.defaultValues.includeSimpleDataSource));
		elements.add(new SimpleDataSourceElement(driver, localizationVal, "description_iwd",  
				(List<String>) argumentFile.uniqueValues.get("smallAvailableList"), (List<String>) argumentFile.uniqueValues.get("smallSelectedList"), 
				null, false, false, argumentFile.defaultValues.includeSimpleDataSource));
		elements.add(new SimpleDataSourceElement(driver, commentsVal, "comments_iwd",  
				(List<String>) argumentFile.uniqueValues.get("smallAvailableList"), (List<String>) argumentFile.uniqueValues.get("smallSelectedList"), 
				null, false, false, argumentFile.defaultValues.includeSimpleDataSource));

		elements.add(new CBListElement(driver, CBListVal, "valveTypes_ms", argumentFile.defaultValues.CBLVal));
		elements.add(new SimpleDataSourceElement(driver, DSVal, "valveTypes_ds",  
				(List<String>) argumentFile.uniqueValues.get("smallAvailableList"), (List<String>) argumentFile.uniqueValues.get("smallSelectedList"), 
				null, false, true, argumentFile.defaultValues.includeSimpleDataSource));
		elements.add(new CBElement(driver, markAGMVal, "seperateAGMValves_cb", argumentFile.defaultValues.includeCB));
		//Second Instance of DataSourceElements
		elements.add(new SimpleDataSourceElement(driver, interValveTypeVal, "maxDistance_iwd",  
				(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), 
				null, false, false, argumentFile.defaultValues.includeSimpleDataSource));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new StationingSelectElement(driver, addStationingVal, "stationing_sta",  
				(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), 
				argumentFile.defaultValues.stationingSelection, argumentFile.defaultValues.customStationingValue, argumentFile.defaultValues.includeStationing));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new SimpleDataSourceElement(driver, addMPVal, "milePosting_mp",  
				(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), 
				argumentFile.defaultValues.simpleDataSourceTextVal, false, false, argumentFile.defaultValues.includeSimpleDataSource));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new SimpleDataSourceElement(driver, interLocalizationVal, "description_iwd",  
				(List<String>) argumentFile.uniqueValues.get("smallAvailableList"), (List<String>) argumentFile.uniqueValues.get("smallSelectedList"), 
				null, false, false, argumentFile.defaultValues.includeSimpleDataSource));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		elements.add(new SimpleDataSourceElement(driver, interCommentsVal, "comments_iwd",  
				(List<String>) argumentFile.uniqueValues.get("smallAvailableList"), (List<String>) argumentFile.uniqueValues.get("smallSelectedList"), 
				null, false, false, argumentFile.defaultValues.includeSimpleDataSource));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		
		elements.add(new SimpleDataSourceElement(driver, nonXYZVal, "useClients_iwd",  
				(List<String>) argumentFile.uniqueValues.get("smallAvailableList"), (List<String>) argumentFile.uniqueValues.get("smallSelectedList"), 
				null, false, false, argumentFile.defaultValues.includeSimpleDataSource));

		} catch(Exception ex) { //Configuration Error
			elements.clear();
			elements.add(new ConfigurationErrorElement(ex.getMessage()));
		}

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
		compTest.compaireDB(elements, "Valves", tables.VALVES, "ValvesResults", argumentFile.FileCounter);
	}
}