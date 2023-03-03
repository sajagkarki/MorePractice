package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.CSREnums.Standard;
import com.tdw.csr.entity.appurtenances_attachments.AppurtenancesAndAttachments;
import com.tdw.csr.entity.Entity;

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

public class FittingsCDTest extends BaseCDTest {

	ElementValidationInterface descAllCapsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).fittings.descriptionAllCaps ? "True" : "False";
				
				return ele.bool == typedList.get(0).fittings.descriptionAllCaps;
			};
	ElementValidationInterface addLabelFalseVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).fittings.defaultDescription.include ? "True" : "False";
				
				return ele.bool == typedList.get(0).fittings.defaultDescription.include;
			};
	ElementValidationInterface roundLocationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).fittings.roundOrientation ? "True" : "False";
				
				return ele.bool == typedList.get(0).fittings.roundOrientation;
			};
	ElementValidationInterface includeClassificationVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).fittings.includeFittingClassification ? "True" : "False";
				
				return ele.bool == typedList.get(0).fittings.includeFittingClassification;
			};
	ElementValidationInterface addLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fittings.defaultDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).fittings.defaultDescription.value;
				
				return (typedList.get(0).fittings.defaultDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).fittings.defaultDescription.value));
			};
	ElementValidationInterface addLabelReinfSleeveVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fittings.reinforceFittingLabel.include ? "True" : "False")
						+ ", " + typedList.get(0).fittings.reinforceFittingLabel.value;
				
				return (typedList.get(0).fittings.reinforceFittingLabel.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).fittings.reinforceFittingLabel.value));
			};			
	ElementValidationInterface addLabelReinfPatchVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fittings.fittingPatchLabel.include ? "True" : "False")
						+ ", " + typedList.get(0).fittings.fittingPatchLabel.value;
				
				return (typedList.get(0).fittings.fittingPatchLabel.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).fittings.fittingPatchLabel.value));
			};
	ElementValidationInterface localizationVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).fittings.omitLocalizationSeparator ? "True" : "False";
				
				return ele.bool == typedList.get(0).fittings.omitLocalizationSeparator;
			};
	ElementValidationInterface markFittingVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).fittings.ai.markReinforcedFitting ? "True" : "False";
				
				return ele.bool == typedList.get(0).fittings.ai.markReinforcedFitting;
			};
	ElementValidationInterface markSleeveVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).fittings.ai.markReinforcedSleeve ? "True" : "False";
				
				return ele.bool == typedList.get(0).fittings.ai.markReinforcedSleeve;
			};
	ElementValidationInterface uncheckSleeveVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).fittings.ai.uncheckSleeveRepair ? "True" : "False";
				
				return ele.bool == typedList.get(0).fittings.ai.uncheckSleeveRepair;
			};
	ElementValidationInterface markFittingPatchVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).fittings.ai.markReinforcedFittingPatch ? "True" : "False";
				
				return ele.bool == typedList.get(0).fittings.ai.markReinforcedFittingPatch;
			};
	ElementValidationInterface markPatchVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).fittings.ai.markPatch ? "True" : "False";
				
				return ele.bool == typedList.get(0).fittings.ai.markPatch;
			};
	ElementValidationInterface addLabelWithinDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).fittings.fittingBetweenTwoWelds.description;
				
				return typedList.get(0).fittings.fittingBetweenTwoWelds.description.equals(ele.txtValue);
			};
	ElementValidationInterface addLabelWithinDistVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fittings.fittingBetweenTwoWelds.iwvu.include ? "True" : "False") + ", "
						+ String.valueOf(typedList.get(0).fittings.fittingBetweenTwoWelds.iwvu.value);
				
				return typedList.get(0).fittings.fittingBetweenTwoWelds.iwvu.include == ele.bool
						&& typedList.get(0).fittings.fittingBetweenTwoWelds.iwvu.value == Double.valueOf(ele.txtValue);
			};
	ElementValidationInterface addLabelWithinUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				String[] mapping = {"in", "mm", "ft", "m"};
				ele.expectedValue = (ele.bool ? "True" : "False") + ", " + mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).fittings.fittingBetweenTwoWelds.iwvu.include ? "True" : "False") + ", "
								+ String.valueOf(typedList.get(0).fittings.fittingBetweenTwoWelds.iwvu.units);
				
				return typedList.get(0).fittings.fittingBetweenTwoWelds.iwvu.include == ele.bool
						&& typedList.get(0).fittings.fittingBetweenTwoWelds.iwvu.units.equals(mapping[ele.dropDownIndex]);
			};
	ElementValidationInterface includeOrient = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).fittings.orientationDescription.include ? "True" : "False";
				
				return ele.bool == typedList.get(0).fittings.orientationDescription.include;
			};
	ElementValidationInterface orientDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).fittings.orientationDescription.topOfPipe.prefix
						+ ", " + typedList.get(0).fittings.orientationDescription.topOfPipe.description
						+ ", " + typedList.get(0).fittings.orientationDescription.twoSeventyDegreesOfPipe.prefix
						+ ", " + typedList.get(0).fittings.orientationDescription.twoSeventyDegreesOfPipe.description
						+ ", " + typedList.get(0).fittings.orientationDescription.ninetyDegreesOfPipe.prefix
						+ ", " + typedList.get(0).fittings.orientationDescription.ninetyDegreesOfPipe.description
						+ ", " + typedList.get(0).fittings.orientationDescription.bottomOfPipe.prefix
						+ ", " + typedList.get(0).fittings.orientationDescription.bottomOfPipe.description;
				
				return ele.validationStrings.get(0).equals(typedList.get(0).fittings.orientationDescription.topOfPipe.prefix) 
				&& ele.validationStrings.get(1).equals(typedList.get(0).fittings.orientationDescription.topOfPipe.description)
				&& ele.validationStrings.get(2).equals(typedList.get(0).fittings.orientationDescription.twoSeventyDegreesOfPipe.prefix)
				&& ele.validationStrings.get(3).equals(typedList.get(0).fittings.orientationDescription.twoSeventyDegreesOfPipe.description)
				&& ele.validationStrings.get(4).equals(typedList.get(0).fittings.orientationDescription.ninetyDegreesOfPipe.prefix)
				&& ele.validationStrings.get(5).equals(typedList.get(0).fittings.orientationDescription.ninetyDegreesOfPipe.description)
				&& ele.validationStrings.get(6).equals(typedList.get(0).fittings.orientationDescription.bottomOfPipe.prefix)
				&& ele.validationStrings.get(7).equals(typedList.get(0).fittings.orientationDescription.bottomOfPipe.description);
			};
	ElementValidationInterface staPrefixDesc = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fittings.stationingPrefix.include ? "True" : "False")
						+ ", " + typedList.get(0).fittings.stationingPrefix.value;
				
				return (typedList.get(0).fittings.stationingPrefix.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).fittings.stationingPrefix.value));
			};
	ElementValidationInterface staBracketsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).fittings.encloseStationingInBraces ? "True" : "False";
				
				return ele.bool == typedList.get(0).fittings.encloseStationingInBraces;
			};
	ElementValidationInterface includeOpeningDimensionsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= typedList.get(0).fittings.includeOpeningDimensions ? "True" : "False";
				
				return ele.bool == typedList.get(0).fittings.includeOpeningDimensions;
			};
	ElementValidationInterface addDimensionsNumVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fittings.roundOpeningDimensions.include ? "True" : "False")
						+ ", " + typedList.get(0).fittings.roundOpeningDimensions.value;
				
				return (typedList.get(0).fittings.roundOpeningDimensions.include == ele.bool)
						&& (Double.valueOf(ele.txtValue) == typedList.get(0).fittings.roundOpeningDimensions.value);
			};
	ElementValidationInterface addDimensionsUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				String[] mapping = {"in", "\"", "mm", "ft", "'", "m"};
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= String.valueOf(typedList.get(0).fittings.roundOpeningDimensions.units);
				
				return typedList.get(0).fittings.roundOpeningDimensions.units.equals(ele.expectedValue);
			};
	ElementValidationInterface addIsolVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fittings.isolatedDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).fittings.isolatedDescription.value;
				
				return (typedList.get(0).fittings.isolatedDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).fittings.isolatedDescription.value));
			};
	ElementValidationInterface addReinforcedVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fittings.reinforcedDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).fittings.reinforcedDescription.value;
				
				return (typedList.get(0).fittings.reinforcedDescription.include == ele.bool)
						&& (ele.txtValue.equals(typedList.get(0).fittings.reinforcedDescription.value));
			};
	ElementValidationInterface dragListVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues
						= typedList.get(0).fittings.componentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).fittings.componentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).fittings.componentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).fittings.componentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).fittings.componentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).fittings.componentsOrder.hashtable.get(1).separatorSpacing
						+ ", " + typedList.get(0).fittings.componentsOrder.hashtable.get(2).component
						+ ", " + typedList.get(0).fittings.componentsOrder.hashtable.get(2).separator
						+ ", " + typedList.get(0).fittings.componentsOrder.hashtable.get(2).separatorSpacing
						+ ", " + typedList.get(0).fittings.componentsOrder.hashtable.get(3).component
						+ ", " + typedList.get(0).fittings.componentsOrder.hashtable.get(3).separator
						+ ", " + typedList.get(0).fittings.componentsOrder.hashtable.get(3).separatorSpacing
						+ ", " + typedList.get(0).fittings.componentsOrder.hashtable.get(4).component
						+ ", " + typedList.get(0).fittings.componentsOrder.hashtable.get(4).separator
						+ ", " + typedList.get(0).fittings.componentsOrder.hashtable.get(4).separatorSpacing
						+ ", " + typedList.get(0).fittings.componentsOrder.hashtable.get(5).component
						+ ", " + typedList.get(0).fittings.componentsOrder.hashtable.get(5).separator
						+ ", " + typedList.get(0).fittings.componentsOrder.hashtable.get(5).separatorSpacing
						+ ", " + typedList.get(0).fittings.componentsOrder.hashtable.get(6).component
						+ ", " + typedList.get(0).fittings.componentsOrder.hashtable.get(6).separator
						+ ", " + typedList.get(0).fittings.componentsOrder.hashtable.get(6).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).fittings.componentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).fittings.componentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).fittings.componentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).fittings.componentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).fittings.componentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).fittings.componentsOrder.hashtable.get(1).separatorSpacing.toString()))
				&& (ele.validationStrings.get(6).equals(typedList.get(0).fittings.componentsOrder.hashtable.get(2).component))
				&& (ele.validationStrings.get(7) == null || ele.validationStrings.get(7).equals(typedList.get(0).fittings.componentsOrder.hashtable.get(2).separator.toString()))
				&& (ele.validationStrings.get(8) == null || ele.validationStrings.get(8).equals(typedList.get(0).fittings.componentsOrder.hashtable.get(2).separatorSpacing.toString()))
				&& (ele.validationStrings.get(9).equals(typedList.get(0).fittings.componentsOrder.hashtable.get(3).component))
				&& (ele.validationStrings.get(10) == null || ele.validationStrings.get(10).equals(typedList.get(0).fittings.componentsOrder.hashtable.get(3).separator.toString()))
				&& (ele.validationStrings.get(11) == null || ele.validationStrings.get(11).equals(typedList.get(0).fittings.componentsOrder.hashtable.get(3).separatorSpacing.toString()))
				&& (ele.validationStrings.get(12).equals(typedList.get(0).fittings.componentsOrder.hashtable.get(4).component))
				&& (ele.validationStrings.get(13) == null || ele.validationStrings.get(13).equals(typedList.get(0).fittings.componentsOrder.hashtable.get(4).separator.toString()))
				&& (ele.validationStrings.get(14) == null || ele.validationStrings.get(14).equals(typedList.get(0).fittings.componentsOrder.hashtable.get(4).separatorSpacing.toString()))
				&& (ele.validationStrings.get(15).equals(typedList.get(0).fittings.componentsOrder.hashtable.get(5).component))
				&& (ele.validationStrings.get(16) == null || ele.validationStrings.get(16).equals(typedList.get(0).fittings.componentsOrder.hashtable.get(5).separator.toString()))
				&& (ele.validationStrings.get(17) == null || ele.validationStrings.get(17).equals(typedList.get(0).fittings.componentsOrder.hashtable.get(5).separatorSpacing.toString()))
				&& (ele.validationStrings.get(18).equals(typedList.get(0).fittings.componentsOrder.hashtable.get(6).component))
				&& (ele.validationStrings.get(19) == null || ele.validationStrings.get(19).equals(typedList.get(0).fittings.componentsOrder.hashtable.get(6).separator.toString()))
				&& (ele.validationStrings.get(20) == null || ele.validationStrings.get(20).equals(typedList.get(0).fittings.componentsOrder.hashtable.get(6).separatorSpacing.toString()));
			};
	ElementValidationInterface notesVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues
						= typedList.get(0).fittings.ai.additionalNotes;
				
				return ele.txtValue.equals(typedList.get(0).fittings.ai.additionalNotes);
			};
	ElementValidationInterface markingExVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues
						= typedList.get(0).fittings.ai.examples;
				
				return ele.txtValue.equals(typedList.get(0).fittings.ai.examples);
			};	
	ElementValidationInterface stationingVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<AppurtenancesAndAttachments> typedList = (List<AppurtenancesAndAttachments>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fittings.ai.stationing.include ? "True" : "False")
						+ ", " + typedList.get(0).fittings.ai.stationing.formatStandard
						+ ", " + typedList.get(0).fittings.ai.stationing.customFormat;
						
						//Hashtable size is dynamic
						for(int i = 0; i < ele.secondaryList.size(); i++) {
							ele.returnedValues += ", " + typedList.get(0).fittings.ai.stationing.dataSource.hashtable.get(i);
						}
				
				//Validate. As the parameter count is dynamic, a loop is used.
				boolean pass = typedList.get(0).fittings.ai.stationing.include == ele.bool
						&& (typedList.get(0).fittings.ai.stationing.formatStandard) == Standard.valueOf(ele.validationStrings.get(1))
						&& (ele.generalIndex != 2 || (ele.txtValue == null || ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).fittings.ai.stationing.customFormat)));
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(3 + i).equals(typedList.get(0).fittings.ai.stationing.dataSource.hashtable.get(i));
				}
						
				
				return pass;
			};			
					
		public List<String> componentPriorityList() {
			List <String> cPL = new ArrayList<String>();
			cPL.add("Classification");
			cPL.add("Orientation");
			cPL.add("Dimensions");
			cPL.add("Localization");
			cPL.add("Reinforcement");
			cPL.add("Isolated Desc"); 
			cPL.add("Label");
			cPL.add("Stationing");

			return cPL;
		}
		
		public List<String> availablePriorityList() {
			List <String> cPL = new ArrayList<String>();
			cPL.add("Odometer Data");

			return cPL;
		}
		
		public List<String> selectedPriorityList() {
			List <String> cPL = new ArrayList<String>();
			cPL.add("Previous Runs");
			cPL.add("Client Questionnaire");
			cPL.add("Alignment Maps");
			cPL.add("Tracking Sheet");
			cPL.add("Pipe Listings");

			return cPL;
		}

		@SuppressWarnings("unchecked")
		@ParameterizedTest
		@ValueSource(strings = {"Fittings_1.json", "Fittings_2.json", "Fittings_3.json"})
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
			chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			WebDriver driver = new ChromeDriver(chromeOptions);
			driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-aa-fittings&auth_token=" + JWT_QA);
			Thread.sleep(1000);
			
			List<UIElements> elements = new ArrayList<UIElements>();
			try {
				
			elements.add(new CBElement(driver, descAllCapsVal, "descriptionAllCaps_cb", argumentFile.defaultValues.includeCB));
			elements.add(new CBElement(driver, roundLocationsVal, "roundOrientation_cb", argumentFile.defaultValues.includeCB));
			elements.add(new CBElement(driver, includeClassificationVal, "includeFittingClassification_cb", argumentFile.defaultValues.includeCB));
			elements.add(new IWVElement(driver, addLabelVal, "prependLabel_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			
			boolean addLabelToDescWithin = argumentFile.defaultValues.includeCB;
			elements.add(new CBElement(driver, null, "fittingBetweenTwoWelds_iwvtf", addLabelToDescWithin));
			if(addLabelToDescWithin)
			{
				elements.add(new TextElement(driver, addLabelWithinDescVal, "value_tf", argumentFile.defaultValues.defaultTextValue));
				elements.get(elements.size() - 1).setDesiredInstance(1);
				elements.add(new IWVElement(driver, addLabelWithinDistVal, "fittingBetweenTwoWelds_iwvtf", 
						Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
				elements.add(new IWVSElement(driver, addLabelWithinUnitVal, "fittingBetweenTwoWelds_iwvtf", argumentFile.defaultValues.defaultIWVSValue, argumentFile.defaultValues.includeIWVorIWVS));				
			}
			
			elements.add(new OrientationDescElement(driver, orientDescVal, "fitting_od", "od_btn", argumentFile.defaultValues.orientationDescriptionVals));
			elements.add(new CBElement(driver, includeOrient, "includeOrientation_cb", argumentFile.defaultValues.includeOrientationDescription));
			
			elements.add(new IWVElement(driver, staPrefixDesc, "stationingPrefix_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.add(new CBElement(driver, staBracketsVal, "encloseStationing_cb", argumentFile.defaultValues.includeIWVorIWVS));
			
			boolean addOpening = (Boolean) argumentFile.uniqueValues.get("includeOpeningDimensions_cb");
			elements.add(new CBElement(driver, includeOpeningDimensionsVal, "includeOpeningDimensions_cb", addOpening));
			if(addOpening)
			{
				boolean roundToNearest = argumentFile.defaultValues.includeIWVorIWVS;
				elements.add(new IWVElement(driver, addDimensionsNumVal, "roundOrientation_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), roundToNearest));
				elements.add(new IWVSElement(driver, addDimensionsUnitVal, "roundOrientation_iwv", argumentFile.defaultValues.defaultIWVSValue, roundToNearest));				
			}
			elements.add(new IWVElement(driver, addIsolVal, "isolatedFittingsDescription_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.add(new IWVElement(driver, addReinforcedVal, "isolatedFittingsReinforced_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.add(new IWVElement(driver, addLabelReinfSleeveVal, "fittingsReinforcedSleeve_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.add(new IWVElement(driver, addLabelReinfPatchVal, "fittingsReinforcedPAtch_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
			elements.add(new CBElement(driver, localizationVal, "omitLocalizationSeparator_cb", argumentFile.defaultValues.includeCB));
			elements.add(new DragListElement(driver, dragListVal, "roundOrientation_cl", 
					(List<String>) argumentFile.uniqueValues.get("roundOrientation_cl"), argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
			
			elements.add(new TextElement(driver, notesVal, "additionalNotes_ta", argumentFile.defaultValues.defaultTextValue));
			elements.add(new TextElement(driver, markingExVal, "examples_ta", argumentFile.defaultValues.defaultTextValue));
			boolean markAsFitting = false;
			
			elements.add(new CBElement(driver, markFittingVal, "markReinforcedFitting_cb", argumentFile.defaultValues.includeCB));
			elements.add(new CBElement(driver, markSleeveVal, "markReinforcedSleeve_cb", argumentFile.defaultValues.includeCB));
			elements.add(new CBElement(driver, uncheckSleeveVal, "uncheckSleeveRepair_cb", argumentFile.defaultValues.includeCB));
			elements.add(new CBElement(driver, markFittingPatchVal, "markReinforcedFittingPatch_cb", argumentFile.defaultValues.includeCB));
			elements.add(new CBElement(driver, markPatchVal, "markPatch_cb", argumentFile.defaultValues.includeCB));

			elements.add(new StationingSelectElement(driver, stationingVal, "stationing_sta", 
					(List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), 
					argumentFile.defaultValues.stationingSelection, argumentFile.defaultValues.customStationingValue, argumentFile.defaultValues.includeStationing));
			
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
			compTest.compaireDB(elements, "Fittings", tables.APPURTENANCES_AND_ATTACHMENTS, "FittingsResults", argumentFile.FileCounter);
		}
	}
