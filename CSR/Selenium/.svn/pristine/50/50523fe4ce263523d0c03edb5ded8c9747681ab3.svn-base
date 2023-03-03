package chromedriver;

import org.openqa.selenium.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.*;
import com.tdw.csr.entity.Entity;
import com.tdw.csr.entity.CSREnums.Standard;
import com.tdw.csr.entity.appurtenances_attachments.AppurtenancesAndAttachments;
import com.tdw.csr.entity.bends.Bends;

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

public class BendsCDTest extends BaseCDTest {

	ElementValidationInterface allCapsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= typedList.get(0).descriptionAllCaps ? "True" : "False";
				
				return ele.bool == typedList.get(0).descriptionAllCaps;
			};
	ElementValidationInterface labelDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).customName.include ? "True" : "False")
						+ ", " + typedList.get(0).customName.value;
				
				return (typedList.get(0).customName.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).customName.value);
			};
	ElementValidationInterface staDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).stationingPrefix.include ? "True" : "False")
						+ ", " + typedList.get(0).stationingPrefix.value;
				
				return (typedList.get(0).stationingPrefix.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).stationingPrefix.value);
			};
	ElementValidationInterface encloseVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= typedList.get(0).encloseStationingInBraces ? "True" : "False";
				
				return ele.bool == typedList.get(0).encloseStationingInBraces;
			};
	ElementValidationInterface FBLabelDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.customName.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.customName.value;
				
				return (typedList.get(0).forgedBends.customName.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).forgedBends.customName.value);
			};
	ElementValidationInterface FBClassificationVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= typedList.get(0).forgedBends.includeClassification ? "True" : "False";
				
				return ele.bool == typedList.get(0).forgedBends.includeClassification;
			};
	ElementValidationInterface FBBendAngleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.includeAngle ? "True" : "False");
				
				return (typedList.get(0).forgedBends.includeAngle == ele.bool);
			};
	ElementValidationInterface FBBendSymbolVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"deg.", "deg", "°"};
				
				String expectedVal = mapping[ele.dropDownIndex];
				ele.expectedValue = expectedVal;
				
				ele.returnedValues 
						= typedList.get(0).forgedBends.degreeSymbol;
				
				return expectedVal.equals(typedList.get(0).forgedBends.degreeSymbol);
			};
	ElementValidationInterface FBIntAngleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= typedList.get(0).forgedBends.includeIntegerAngle ? "True" : "False";
				
				return ele.bool == typedList.get(0).forgedBends.includeIntegerAngle;
			};
	ElementValidationInterface FBBendRadVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= typedList.get(0).forgedBends.includeBendRadius ? "True" : "False";
				
				return ele.bool == typedList.get(0).forgedBends.includeBendRadius;
			};
	ElementValidationInterface FBRoundAngVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.roundOrientation.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.roundOrientation.value;
				
				return (typedList.get(0).forgedBends.roundOrientation.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.roundOrientation.value);
			};
	ElementValidationInterface FBDownDirVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.customName.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.customName.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.customName.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.customName.value);
			};
	ElementValidationInterface FBDownAngVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.angle.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.angle.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.angle.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.angle.value);
			};
	ElementValidationInterface FBDownRadVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.radius.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.radius.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.radius.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.radius.value);
			};
	ElementValidationInterface FBDownProxDoubleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.includeNearValve.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.includeNearValve.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.includeNearValve.value);
			};
	ElementValidationInterface FBDownProxUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"inch", "millimeters"};
				
				String exVal = mapping[ele.dropDownIndex];
				ele.expectedValue += ", " + exVal;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.includeNearValve.units;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.includeNearValve.include == ele.bool)
						&& exVal.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.includeNearValve.units);
			};
	ElementValidationInterface FBDownRadioVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.reportType.toString();
				
				return ele.expectedValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterDown.reportType.toString());
			};
			
	ElementValidationInterface FBLeftDirVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.customName.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.customName.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.customName.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.customName.value);
			};
	ElementValidationInterface FBLeftAngVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.angle.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.angle.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.angle.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.angle.value);
			};
	ElementValidationInterface FBLeftRadVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.radius.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.radius.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.radius.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.radius.value);
			};
	ElementValidationInterface FBLeftProxDoubleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.includeNearValve.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.includeNearValve.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.includeNearValve.value);
			};
	ElementValidationInterface FBLeftProxUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"inch", "millimeters"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.includeNearValve.units;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.includeNearValve.include == ele.bool)
						&& ele.expectedValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.includeNearValve.units);
			};
	ElementValidationInterface FBLeftRadioVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.reportType.toString();
				
				return ele.expectedValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeft.reportType.toString());
			};
	
	ElementValidationInterface FBLeftUpDirVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.customName.include ? "True" : "False")
					+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.customName.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.customName.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.customName.value);
			};
	ElementValidationInterface FBLeftUpAngVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.angle.include ? "True" : "False")
					+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.angle.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.angle.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.angle.value);
			};
	ElementValidationInterface FBLeftUpRadVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.radius.include ? "True" : "False")
					+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.radius.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.radius.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.radius.value);
			};
	ElementValidationInterface FBLeftUpProxDoubleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.includeNearValve.include ? "True" : "False")
					+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.includeNearValve.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.includeNearValve.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.includeNearValve.value);
			};
	ElementValidationInterface FBLeftUpProxUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"inch", "millimeters"};
			
			ele.expectedValue = mapping[ele.dropDownIndex];
			
			ele.returnedValues 
					= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.includeNearValve.include ? "True" : "False")
					+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.includeNearValve.units;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.includeNearValve.include == ele.bool)
						&& ele.expectedValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.includeNearValve.units);
			};
	ElementValidationInterface FBLeftUpRadioVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"DO_NOT_REPORT", "REPORT"};
			
			ele.expectedValue = mapping[ele.generalIndex];
			
			ele.returnedValues 
					= typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.reportType.toString();
			
			return ele.expectedValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftUp.reportType.toString());
		};
									
	ElementValidationInterface FBLeftDownDirVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.customName.include ? "True" : "False")
					+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.customName.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.customName.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.customName.value);
			};
	ElementValidationInterface FBLeftDownAngVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.angle.include ? "True" : "False")
					+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.angle.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.angle.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.angle.value);
			};
	ElementValidationInterface FBLeftDownRadVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.radius.include ? "True" : "False")
					+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.radius.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.radius.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.radius.value);
			};
	ElementValidationInterface FBLeftDownProxDoubleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.includeNearValve.include ? "True" : "False")
					+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.includeNearValve.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.includeNearValve.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.includeNearValve.value);
			};
	ElementValidationInterface FBLeftDownProxUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"inch", "millimeters"};
			
			ele.expectedValue = mapping[ele.dropDownIndex];
			
			ele.returnedValues 
					= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.includeNearValve.include ? "True" : "False")
					+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.includeNearValve.units;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.includeNearValve.include == ele.bool)
						&& ele.expectedValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.includeNearValve.units);
			};
	ElementValidationInterface FBLeftDownRadioVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"DO_NOT_REPORT", "REPORT"};
			
			ele.expectedValue = mapping[ele.generalIndex];
			
			ele.returnedValues 
					= typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.reportType.toString();
			
			return ele.expectedValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterLeftDown.reportType.toString());
		};
		
	ElementValidationInterface FBRightDirVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.customName.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.customName.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.customName.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.customName.value);
			};
	ElementValidationInterface FBRightAngVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.angle.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.angle.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.angle.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.angle.value);
			};
	ElementValidationInterface FBRightRadVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.radius.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.radius.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.radius.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.radius.value);
			};
	ElementValidationInterface FBRightProxDoubleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.includeNearValve.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.includeNearValve.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.includeNearValve.value);
			};
	ElementValidationInterface FBRightProxUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"inch", "millimeters"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.includeNearValve.units;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.includeNearValve.include == ele.bool)
						&& ele.expectedValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.includeNearValve.units);
			};
	ElementValidationInterface FBRightRadioVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.reportType.toString();
				
				return ele.expectedValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterRight.reportType.toString());
			};
													
	ElementValidationInterface FBRightDownDirVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.customName.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.customName.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.customName.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.customName.value);
			};
	ElementValidationInterface FBRightDownAngVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.angle.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.angle.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.angle.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.angle.value);
			};
	ElementValidationInterface FBRightDownRadVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.radius.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.radius.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.radius.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.radius.value);
			};
	ElementValidationInterface FBRightDownProxDoubleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.includeNearValve.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.includeNearValve.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.includeNearValve.value);
			};
	ElementValidationInterface FBRightDownProxUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"inch", "millimeters"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.includeNearValve.units;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.includeNearValve.include == ele.bool)
						&& ele.expectedValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.includeNearValve.units);
			};
	ElementValidationInterface FBRightDownRadioVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.reportType.toString();
				
				return ele.expectedValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightDown.reportType.toString());
			};
			
	ElementValidationInterface FBRightUpDirVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.customName.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.customName.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.customName.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.customName.value);
			};
	ElementValidationInterface FBRightUpAngVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.angle.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.angle.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.angle.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.angle.value);
			};
	ElementValidationInterface FBRightUpRadVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.radius.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.radius.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.radius.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.radius.value);
			};
	ElementValidationInterface FBRightUpProxDoubleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.includeNearValve.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.includeNearValve.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.includeNearValve.value);
			};
	ElementValidationInterface FBRightUpProxUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"inch", "millimeters"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.includeNearValve.units;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.includeNearValve.include == ele.bool)
						&& ele.expectedValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.includeNearValve.units);
			};
	ElementValidationInterface FBRightUpRadioVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.reportType.toString();
				
				return ele.expectedValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterRightUp.reportType.toString());
			};
					
	ElementValidationInterface FBUpDirVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.customName.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.customName.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.customName.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.customName.value);
			};
	ElementValidationInterface FBUpAngVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.angle.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.angle.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.angle.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.angle.value);
			};
	ElementValidationInterface FBUpRadVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.radius.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.radius.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.radius.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.radius.value);
			};
	ElementValidationInterface FBUpProxDoubleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.includeNearValve.value;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.includeNearValve.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.includeNearValve.value);
			};
	ElementValidationInterface FBUpProxUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"inch", "millimeters"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.includeNearValve.units;
				
				return (typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.includeNearValve.include == ele.bool)
						&& ele.expectedValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.includeNearValve.units);
			};
	ElementValidationInterface FBUpRadioVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.reportType.toString();
				
				return ele.expectedValue.equals(typedList.get(0).forgedBends.directionWithAngleRadiusFilterUp.reportType.toString());
			};
	ElementValidationInterface forgedDragVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues
						= typedList.get(0).forgedBends.componentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).forgedBends.componentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).forgedBends.componentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).forgedBends.componentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).forgedBends.componentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).forgedBends.componentsOrder.hashtable.get(1).separatorSpacing
						+ ", " + typedList.get(0).forgedBends.componentsOrder.hashtable.get(2).component
						+ ", " + typedList.get(0).forgedBends.componentsOrder.hashtable.get(2).separator
						+ ", " + typedList.get(0).forgedBends.componentsOrder.hashtable.get(2).separatorSpacing
						+ ", " + typedList.get(0).forgedBends.componentsOrder.hashtable.get(3).component
						+ ", " + typedList.get(0).forgedBends.componentsOrder.hashtable.get(3).separator
						+ ", " + typedList.get(0).forgedBends.componentsOrder.hashtable.get(3).separatorSpacing
						+ ", " + typedList.get(0).forgedBends.componentsOrder.hashtable.get(4).component
						+ ", " + typedList.get(0).forgedBends.componentsOrder.hashtable.get(4).separator
						+ ", " + typedList.get(0).forgedBends.componentsOrder.hashtable.get(4).separatorSpacing
						+ ", " + typedList.get(0).forgedBends.componentsOrder.hashtable.get(5).component
						+ ", " + typedList.get(0).forgedBends.componentsOrder.hashtable.get(5).separator
						+ ", " + typedList.get(0).forgedBends.componentsOrder.hashtable.get(5).separatorSpacing
						+ ", " + typedList.get(0).forgedBends.componentsOrder.hashtable.get(6).component
						+ ", " + typedList.get(0).forgedBends.componentsOrder.hashtable.get(6).separator
						+ ", " + typedList.get(0).forgedBends.componentsOrder.hashtable.get(6).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).forgedBends.componentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).forgedBends.componentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).forgedBends.componentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).forgedBends.componentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).forgedBends.componentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).forgedBends.componentsOrder.hashtable.get(1).separatorSpacing.toString()))
				&& (ele.validationStrings.get(6).equals(typedList.get(0).forgedBends.componentsOrder.hashtable.get(2).component))
				&& (ele.validationStrings.get(7) == null || ele.validationStrings.get(7).equals(typedList.get(0).forgedBends.componentsOrder.hashtable.get(2).separator.toString()))
				&& (ele.validationStrings.get(8) == null || ele.validationStrings.get(8).equals(typedList.get(0).forgedBends.componentsOrder.hashtable.get(2).separatorSpacing.toString()))
				&& (ele.validationStrings.get(9).equals(typedList.get(0).forgedBends.componentsOrder.hashtable.get(3).component))
				&& (ele.validationStrings.get(10) == null || ele.validationStrings.get(10).equals(typedList.get(0).forgedBends.componentsOrder.hashtable.get(3).separator.toString()))
				&& (ele.validationStrings.get(11) == null || ele.validationStrings.get(11).equals(typedList.get(0).forgedBends.componentsOrder.hashtable.get(3).separatorSpacing.toString()))
				&& (ele.validationStrings.get(12).equals(typedList.get(0).forgedBends.componentsOrder.hashtable.get(4).component))
				&& (ele.validationStrings.get(13) == null || ele.validationStrings.get(13).equals(typedList.get(0).forgedBends.componentsOrder.hashtable.get(4).separator.toString()))
				&& (ele.validationStrings.get(14) == null || ele.validationStrings.get(14).equals(typedList.get(0).forgedBends.componentsOrder.hashtable.get(4).separatorSpacing.toString()))
				&& (ele.validationStrings.get(15).equals(typedList.get(0).forgedBends.componentsOrder.hashtable.get(5).component))
				&& (ele.validationStrings.get(16) == null || ele.validationStrings.get(16).equals(typedList.get(0).forgedBends.componentsOrder.hashtable.get(5).separator.toString()))
				&& (ele.validationStrings.get(17) == null || ele.validationStrings.get(17).equals(typedList.get(0).forgedBends.componentsOrder.hashtable.get(5).separatorSpacing.toString()))
				&& (ele.validationStrings.get(18).equals(typedList.get(0).forgedBends.componentsOrder.hashtable.get(6).component))
				&& (ele.validationStrings.get(19) == null || ele.validationStrings.get(19).equals(typedList.get(0).forgedBends.componentsOrder.hashtable.get(6).separator.toString()))
				&& (ele.validationStrings.get(20) == null || ele.validationStrings.get(20).equals(typedList.get(0).forgedBends.componentsOrder.hashtable.get(6).separatorSpacing.toString()));
			};			
	
	
	
	
	
	ElementValidationInterface FieldLabelDescVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.customName.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.customName.value;
				
				return (typedList.get(0).fieldBends.customName.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).fieldBends.customName.value);
			};
	ElementValidationInterface FieldClassificationVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= typedList.get(0).fieldBends.includeClassification ? "True" : "False";
				
				return ele.bool == typedList.get(0).fieldBends.includeClassification;
			};
	ElementValidationInterface FieldBendAngleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.includeAngle ? "True" : "False");
				
				return (typedList.get(0).fieldBends.includeAngle == ele.bool);
			};
	ElementValidationInterface FieldBendSymbolVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"deg.", "deg", "°"};
				
				String expectedVal = mapping[ele.dropDownIndex];
				ele.expectedValue = expectedVal;
				
				ele.returnedValues 
						= typedList.get(0).fieldBends.degreeSymbol;
				
				return expectedVal.equals(typedList.get(0).fieldBends.degreeSymbol);
			};
	ElementValidationInterface FieldIntAngleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= typedList.get(0).fieldBends.includeIntegerAngle ? "True" : "False";
				
				return ele.bool == typedList.get(0).fieldBends.includeIntegerAngle;
			};
	ElementValidationInterface FieldBendRadVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= typedList.get(0).fieldBends.includeBendRadius ? "True" : "False";
				
				return ele.bool == typedList.get(0).fieldBends.includeBendRadius;
			};
	ElementValidationInterface FieldRoundAngVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.roundOrientation.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.roundOrientation.value;
				
				return (typedList.get(0).fieldBends.roundOrientation.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.roundOrientation.value);
			};
	ElementValidationInterface FieldDownDirVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.customName.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.customName.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.customName.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.customName.value);
			};
	ElementValidationInterface FieldDownAngVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.angle.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.angle.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.angle.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.angle.value);
			};
	ElementValidationInterface FieldDownRadVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.radius.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.radius.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.radius.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.radius.value);
			};
	ElementValidationInterface FieldDownProxDoubleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.includeNearValve.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.includeNearValve.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.includeNearValve.value);
			};
	ElementValidationInterface FieldDownProxUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"inch", "millimeters"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.includeNearValve.units;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.includeNearValve.include == ele.bool)
						&& ele.expectedValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.includeNearValve.units);
			};
	ElementValidationInterface FieldDownRadioVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.reportType.toString();
				
				return ele.expectedValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterDown.reportType.toString());
			};
			
	ElementValidationInterface FieldLeftDirVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.customName.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.customName.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.customName.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.customName.value);
			};
	ElementValidationInterface FieldLeftAngVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.angle.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.angle.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.angle.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.angle.value);
			};
	ElementValidationInterface FieldLeftRadVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.radius.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.radius.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.radius.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.radius.value);
			};
	ElementValidationInterface FieldLeftProxDoubleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.includeNearValve.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.includeNearValve.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.includeNearValve.value);
			};
	ElementValidationInterface FieldLeftProxUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"inch", "millimeters"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.includeNearValve.units;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.includeNearValve.include == ele.bool)
						&& ele.expectedValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.includeNearValve.units);
			};
	ElementValidationInterface FieldLeftRadioVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.reportType.toString();
				
				return ele.expectedValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeft.reportType.toString());
			};
	
	ElementValidationInterface FieldLeftUpDirVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.customName.include ? "True" : "False")
					+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.customName.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.customName.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.customName.value);
			};
	ElementValidationInterface FieldLeftUpAngVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.angle.include ? "True" : "False")
					+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.angle.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.angle.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.angle.value);
			};
	ElementValidationInterface FieldLeftUpRadVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.radius.include ? "True" : "False")
					+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.radius.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.radius.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.radius.value);
			};
	ElementValidationInterface FieldLeftUpProxDoubleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.includeNearValve.include ? "True" : "False")
					+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.includeNearValve.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.includeNearValve.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.includeNearValve.value);
			};
	ElementValidationInterface FieldLeftUpProxUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"inch", "millimeters"};
			
			ele.expectedValue = mapping[ele.dropDownIndex];
			
			ele.returnedValues 
					= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.includeNearValve.include ? "True" : "False")
					+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.includeNearValve.units;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.includeNearValve.include == ele.bool)
						&& ele.expectedValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.includeNearValve.units);
			};
	ElementValidationInterface FieldLeftUpRadioVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"DO_NOT_REPORT", "REPORT"};
			
			ele.expectedValue = mapping[ele.generalIndex];
			
			ele.returnedValues 
					= typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.reportType.toString();
			
			return ele.expectedValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftUp.reportType.toString());
		};
									
	ElementValidationInterface FieldLeftDownDirVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.customName.include ? "True" : "False")
					+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.customName.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.customName.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.customName.value);
			};
	ElementValidationInterface FieldLeftDownAngVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.angle.include ? "True" : "False")
					+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.angle.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.angle.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.angle.value);
			};
	ElementValidationInterface FieldLeftDownRadVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.radius.include ? "True" : "False")
					+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.radius.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.radius.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.radius.value);
			};
	ElementValidationInterface FieldLeftDownProxDoubleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.includeNearValve.include ? "True" : "False")
					+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.includeNearValve.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.includeNearValve.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.includeNearValve.value);
			};
	ElementValidationInterface FieldLeftDownProxUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"inch", "millimeters"};
			
			ele.expectedValue = mapping[ele.dropDownIndex];
			
			ele.returnedValues 
					= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.includeNearValve.include ? "True" : "False")
					+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.includeNearValve.units;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.includeNearValve.include == ele.bool)
						&& ele.expectedValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.includeNearValve.units);
			};
	ElementValidationInterface FieldLeftDownRadioVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"DO_NOT_REPORT", "REPORT"};
			
			ele.expectedValue = mapping[ele.generalIndex];
			
			ele.returnedValues 
					= typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.reportType.toString();
			
			return ele.expectedValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterLeftDown.reportType.toString());
		};
		
	ElementValidationInterface FieldRightDirVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.customName.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.customName.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.customName.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.customName.value);
			};
	ElementValidationInterface FieldRightAngVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.angle.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.angle.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.angle.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.angle.value);
			};
	ElementValidationInterface FieldRightRadVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.radius.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.radius.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.radius.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.radius.value);
			};
	ElementValidationInterface FieldRightProxDoubleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.includeNearValve.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.includeNearValve.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.includeNearValve.value);
			};
	ElementValidationInterface FieldRightProxUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"inch", "millimeters"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.includeNearValve.units;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.includeNearValve.include == ele.bool)
						&& ele.expectedValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.includeNearValve.units);
			};
	ElementValidationInterface FieldRightRadioVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.reportType.toString();
				
				return ele.expectedValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterRight.reportType.toString());
			};
													
	ElementValidationInterface FieldRightDownDirVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.customName.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.customName.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.customName.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.customName.value);
			};
	ElementValidationInterface FieldRightDownAngVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.angle.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.angle.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.angle.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.angle.value);
			};
	ElementValidationInterface FieldRightDownRadVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.radius.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.radius.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.radius.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.radius.value);
			};
	ElementValidationInterface FieldRightDownProxDoubleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.includeNearValve.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.includeNearValve.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.includeNearValve.value);
			};
	ElementValidationInterface FieldRightDownProxUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"inch", "millimeters"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.includeNearValve.units;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.includeNearValve.include == ele.bool)
						&& ele.expectedValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.includeNearValve.units);
			};
	ElementValidationInterface FieldRightDownRadioVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.reportType.toString();
				
				return ele.expectedValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightDown.reportType.toString());
			};
			
	ElementValidationInterface FieldRightUpDirVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.customName.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.customName.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.customName.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.customName.value);
			};
	ElementValidationInterface FieldRightUpAngVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.angle.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.angle.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.angle.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.angle.value);
			};
	ElementValidationInterface FieldRightUpRadVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.radius.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.radius.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.radius.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.radius.value);
			};
	ElementValidationInterface FieldRightUpProxDoubleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.includeNearValve.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.includeNearValve.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.includeNearValve.value);
			};
	ElementValidationInterface FieldRightUpProxUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"inch", "millimeters"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.includeNearValve.units;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.includeNearValve.include == ele.bool)
						&& ele.expectedValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.includeNearValve.units);
			};
	ElementValidationInterface FieldRightUpRadioVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.reportType.toString();
				
				return ele.expectedValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterRightUp.reportType.toString());
			};
					
	ElementValidationInterface FieldUpDirVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.customName.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.customName.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.customName.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.customName.value);
			};
	ElementValidationInterface FieldUpAngVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.angle.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.angle.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.angle.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.angle.value);
			};
	ElementValidationInterface FieldUpRadVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.radius.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.radius.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.radius.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.radius.value);
			};
	ElementValidationInterface FieldUpProxDoubleVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.includeNearValve.value;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.includeNearValve.include == ele.bool)
						&& Double.parseDouble(ele.txtValue) == (typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.includeNearValve.value);
			};
	ElementValidationInterface FieldUpProxUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"inch", "millimeters"};
				
				ele.expectedValue = mapping[ele.dropDownIndex];
				
				ele.returnedValues 
						= (typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.includeNearValve.include ? "True" : "False")
						+ ", " + typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.includeNearValve.units;
				
				return (typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.includeNearValve.include == ele.bool)
						&& ele.expectedValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.includeNearValve.units);
			};
	ElementValidationInterface FieldUpRadioVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				String[] mapping = new String[] {"DO_NOT_REPORT", "REPORT"};
				
				ele.expectedValue = mapping[ele.generalIndex];
				
				ele.returnedValues 
						= typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.reportType.toString();
				
				return ele.expectedValue.equals(typedList.get(0).fieldBends.directionWithAngleRadiusFilterUp.reportType.toString());
			};
	ElementValidationInterface fieldDragVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues
						= typedList.get(0).fieldBends.componentsOrder.hashtable.get(0).component
						+ ", " + typedList.get(0).fieldBends.componentsOrder.hashtable.get(0).separator
						+ ", " + typedList.get(0).fieldBends.componentsOrder.hashtable.get(0).separatorSpacing
						+ ", " + typedList.get(0).fieldBends.componentsOrder.hashtable.get(1).component
						+ ", " + typedList.get(0).fieldBends.componentsOrder.hashtable.get(1).separator
						+ ", " + typedList.get(0).fieldBends.componentsOrder.hashtable.get(1).separatorSpacing
						+ ", " + typedList.get(0).fieldBends.componentsOrder.hashtable.get(2).component
						+ ", " + typedList.get(0).fieldBends.componentsOrder.hashtable.get(2).separator
						+ ", " + typedList.get(0).fieldBends.componentsOrder.hashtable.get(2).separatorSpacing
						+ ", " + typedList.get(0).fieldBends.componentsOrder.hashtable.get(3).component
						+ ", " + typedList.get(0).fieldBends.componentsOrder.hashtable.get(3).separator
						+ ", " + typedList.get(0).fieldBends.componentsOrder.hashtable.get(3).separatorSpacing
						+ ", " + typedList.get(0).fieldBends.componentsOrder.hashtable.get(4).component
						+ ", " + typedList.get(0).fieldBends.componentsOrder.hashtable.get(4).separator
						+ ", " + typedList.get(0).fieldBends.componentsOrder.hashtable.get(4).separatorSpacing
						+ ", " + typedList.get(0).fieldBends.componentsOrder.hashtable.get(5).component
						+ ", " + typedList.get(0).fieldBends.componentsOrder.hashtable.get(5).separator
						+ ", " + typedList.get(0).fieldBends.componentsOrder.hashtable.get(5).separatorSpacing
						+ ", " + typedList.get(0).fieldBends.componentsOrder.hashtable.get(6).component
						+ ", " + typedList.get(0).fieldBends.componentsOrder.hashtable.get(6).separator
						+ ", " + typedList.get(0).fieldBends.componentsOrder.hashtable.get(6).separatorSpacing;
				
				return (ele.validationStrings.get(0).equals(typedList.get(0).fieldBends.componentsOrder.hashtable.get(0).component))
 				&& (ele.validationStrings.get(1) == null || ele.validationStrings.get(1).equals(typedList.get(0).fieldBends.componentsOrder.hashtable.get(0).separator.toString()))
				&& (ele.validationStrings.get(2) == null || ele.validationStrings.get(2).equals(typedList.get(0).fieldBends.componentsOrder.hashtable.get(0).separatorSpacing.toString()))
				&& (ele.validationStrings.get(3).equals(typedList.get(0).fieldBends.componentsOrder.hashtable.get(1).component))
				&& (ele.validationStrings.get(4) == null || ele.validationStrings.get(4).equals(typedList.get(0).fieldBends.componentsOrder.hashtable.get(1).separator.toString()))
				&& (ele.validationStrings.get(5) == null || ele.validationStrings.get(5).equals(typedList.get(0).fieldBends.componentsOrder.hashtable.get(1).separatorSpacing.toString()))
				&& (ele.validationStrings.get(6).equals(typedList.get(0).fieldBends.componentsOrder.hashtable.get(2).component))
				&& (ele.validationStrings.get(7) == null || ele.validationStrings.get(7).equals(typedList.get(0).fieldBends.componentsOrder.hashtable.get(2).separator.toString()))
				&& (ele.validationStrings.get(8) == null || ele.validationStrings.get(8).equals(typedList.get(0).fieldBends.componentsOrder.hashtable.get(2).separatorSpacing.toString()))
				&& (ele.validationStrings.get(9).equals(typedList.get(0).fieldBends.componentsOrder.hashtable.get(3).component))
				&& (ele.validationStrings.get(10) == null || ele.validationStrings.get(10).equals(typedList.get(0).fieldBends.componentsOrder.hashtable.get(3).separator.toString()))
				&& (ele.validationStrings.get(11) == null || ele.validationStrings.get(11).equals(typedList.get(0).fieldBends.componentsOrder.hashtable.get(3).separatorSpacing.toString()))
				&& (ele.validationStrings.get(12).equals(typedList.get(0).fieldBends.componentsOrder.hashtable.get(4).component))
				&& (ele.validationStrings.get(13) == null || ele.validationStrings.get(13).equals(typedList.get(0).fieldBends.componentsOrder.hashtable.get(4).separator.toString()))
				&& (ele.validationStrings.get(14) == null || ele.validationStrings.get(14).equals(typedList.get(0).fieldBends.componentsOrder.hashtable.get(4).separatorSpacing.toString()))
				&& (ele.validationStrings.get(15).equals(typedList.get(0).fieldBends.componentsOrder.hashtable.get(5).component))
				&& (ele.validationStrings.get(16) == null || ele.validationStrings.get(16).equals(typedList.get(0).fieldBends.componentsOrder.hashtable.get(5).separator.toString()))
				&& (ele.validationStrings.get(17) == null || ele.validationStrings.get(17).equals(typedList.get(0).fieldBends.componentsOrder.hashtable.get(5).separatorSpacing.toString()))
				&& (ele.validationStrings.get(18).equals(typedList.get(0).fieldBends.componentsOrder.hashtable.get(6).component))
				&& (ele.validationStrings.get(19) == null || ele.validationStrings.get(19).equals(typedList.get(0).fieldBends.componentsOrder.hashtable.get(6).separator.toString()))
				&& (ele.validationStrings.get(20) == null || ele.validationStrings.get(20).equals(typedList.get(0).fieldBends.componentsOrder.hashtable.get(6).separatorSpacing.toString()));
			};	
			
	ElementValidationInterface WrinkleLabelVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).wrinkleBends.includeWrinkleDescription.include ? "True" : "False")
						+ ", " + typedList.get(0).wrinkleBends.includeWrinkleDescription.value;
				
				return (typedList.get(0).wrinkleBends.includeWrinkleDescription.include == ele.bool)
						&& ele.txtValue.equals(typedList.get(0).wrinkleBends.includeWrinkleDescription.value);
			};
	ElementValidationInterface WrinkleCountVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).wrinkleBends.includeWrinkleCountinLabel ? "True" : "False");
				
				return (ele.bool == typedList.get(0).wrinkleBends.includeWrinkleCountinLabel);
			};
	ElementValidationInterface WrinkleBendCustomVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= typedList.get(0).wrinkleBends.includeBelowBendDegree.description;
				
				return ele.txtValue.equals(typedList.get(0).wrinkleBends.includeBelowBendDegree.description);
			};
	ElementValidationInterface WrinkleBendForLesThanVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= (typedList.get(0).wrinkleBends.includeBelowBendDegree.iwvu.include ? "True" : "False");
				
				return (typedList.get(0).wrinkleBends.includeBelowBendDegree.iwvu.include == ele.bool);
			};
	ElementValidationInterface WrinkleBendNumVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= typedList.get(0).wrinkleBends.includeBelowBendDegree.iwvu.value + "";
				
				return Double.parseDouble(ele.txtValue) == (typedList.get(0).wrinkleBends.includeBelowBendDegree.iwvu.value);
			};
	ElementValidationInterface WrinkleBendUnitVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.expectedValue = "deg";
				
				ele.returnedValues 
						= typedList.get(0).wrinkleBends.includeBelowBendDegree.iwvu.value + "";
				
				return ele.expectedValue.equals(typedList.get(0).wrinkleBends.includeBelowBendDegree.iwvu.units);
			};
	ElementValidationInterface WrinkleBookmarkVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
					= (typedList.get(0).wrinkleBends.bookmarkWrinkleCount ? "True" : "False");
		
				return (ele.bool == typedList.get(0).wrinkleBends.bookmarkWrinkleCount);
			};
			
	ElementValidationInterface deviationsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= typedList.get(0).ai.additionalNotes;
				
				return (ele.txtValue.equals(typedList.get(0).ai.additionalNotes));
			};	
	ElementValidationInterface markingsVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Bends> typedList = (List<Bends>) list;
				
				ele.returnedValues 
						= typedList.get(0).ai.examples;
				
				return (ele.txtValue.equals(typedList.get(0).ai.examples));
			};	
					
			
	ElementValidationInterface stationingVal = 
			(UIElements ele, List<? extends Entity> list) -> {
				@SuppressWarnings("unchecked")
				List<Bends> typedList = (List<Bends>) list;
						
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
						&& Standard.valueOf(ele.validationStrings.get(1)) == (typedList.get(0).ai.stationing.formatStandard)
						&& (ele.validationStrings.get(2).equals(typedList.get(0).ai.stationing.customFormat) || ele.txtValue == null);
				
				//Iterate through the hashtable
				for(int i = 0; i < ele.secondaryList.size(); i++)
				{
					if(!pass)
						break;
					
					pass = ele.validationStrings.get(3 + i).equals(typedList.get(0).ai.stationing.dataSource.hashtable.get(i));
				}
				
				return pass;
			};
						
			
			
	public List<String> acceptedPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Alignment Maps");
		cPL.add("Pipe Listing");
		cPL.add("Client Questionnaire");
		
		return cPL;
	}
	
	public List<String> selectedPriorityList() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Tracking Sheet");
		cPL.add("Odometer Data");
		cPL.add("Previous Runs");
		
		return cPL;
	}
	
	public List<String> dragPriorityList2() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Classification");
		cPL.add("Integer Angle");
		cPL.add("Angle");
		cPL.add("Label");
		cPL.add("Direction");
		cPL.add("Stationing");
		cPL.add("Bend Radius");
		
		return cPL;
	}
	
	public List<String> dragPriorityList1() {
		List <String> cPL = new ArrayList<String>();
		cPL.add("Integer Angle");
		cPL.add("Stationing");
		cPL.add("Classification");
		cPL.add("Label");
		cPL.add("Direction");
		cPL.add("Angle");
		cPL.add("Bend Radius");
		
		return cPL;
	}
	
	
	@ParameterizedTest
	@ValueSource(strings = {"Bends_1.json","Bends_2.json","Bends_3.json"})
	public void testBendsPage(String argument) throws Exception {
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
		driver.get(CSR_FRONTEND_BASE_URL + "/loginCallback?redirectFrom=/csr/CSR-DB-TEST/csr-bends&auth_token=" + JWT_QA);
		Thread.sleep(1000);
		
		List<UIElements> elements = new ArrayList<UIElements>();
		try {

		elements.add(new CBElement(driver, allCapsVal, "descriptionAllCaps_cb", argumentFile.defaultValues.includeCB));
		
		elements.add(new IWVElement(driver, labelDescVal, "propertyWithUpdates_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new IWVElement(driver, staDescVal, "propertyWithUpdates_tf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new CBElement(driver, encloseVal, "encloseStationing_cb", argumentFile.defaultValues.includeCB));
		
		elements.add(new OpenExpansionPanels(driver, null, "forgedBends_st", new int[] {0}));
		elements.add(new IWVElement(driver, FBLabelDescVal, "customName_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new CBElement(driver, FBClassificationVal, "includeClassification_cb", argumentFile.defaultValues.includeCB));
		boolean includeBendAngle = argumentFile.defaultValues.includeIWVorIWVS;
		elements.add(new CBElement(driver, FBBendAngleVal, "includeAngle_cb", includeBendAngle));
		if(includeBendAngle)
		{
			elements.add(new SelectElement(driver, FBBendSymbolVal, "degreeSymbol_ts", argumentFile.defaultValues.defaultSelectValue));
		}
		elements.add(new CBElement(driver, FBIntAngleVal, "includeIntegerAngle_cb", argumentFile.defaultValues.includeCB));
		elements.add(new CBElement(driver, FBBendRadVal, "includeBendRadius_cb", argumentFile.defaultValues.includeCB));
		elements.add(new IWVElement(driver, FBRoundAngVal, "roundOrientation_iwvtf", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
		
		
		//Open All sub-tabs
		elements.add(new OpenExpansionPanels(driver, null, "forgedBends_st", new int[] {1, 2, 3, 4, 5, 6, 7, 8}));
		
		int current = 0; //recommended usage, so that a frame-shift is more easily adapted to.
		boolean LabelBool;
		boolean ProximityBool;
		
		
		//Down
		LabelBool = (Boolean) argumentFile.uniqueValues.get("AddDirectionWithLabel");
		ProximityBool = (Boolean) argumentFile.uniqueValues.get("AddProximity");
		elements.add(new IWVElement(driver, FBDownDirVal, "customName_iwv", "Deep Down", LabelBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(LabelBool) {
			elements.add(new IWVElement(driver, FBDownAngVal, "angle_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeCB));
			elements.get(elements.size() - 1).setDesiredInstance(current);
			elements.add(new IWVElement(driver, FBDownRadVal, "radius_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeCB));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		elements.add(new IWVElement(driver, FBDownProxDoubleVal, "includeNearValve_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		elements.add(new IWVSElement(driver, FBDownProxUnitVal, "includeNearValve_iwv", argumentFile.defaultValues.defaultIWVSValue, ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(ProximityBool) {
			elements.add(new RGElement(driver, FBDownRadioVal, "reportType_rg", argumentFile.defaultValues.defaultRGValues));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		current = 1;
		
		//Left
		elements.add(new IWVElement(driver, FBLeftDirVal, "customName_iwv", argumentFile.defaultValues.defaultIWVValue, LabelBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(LabelBool) {
			elements.add(new IWVElement(driver, FBLeftAngVal, "angle_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
			elements.add(new IWVElement(driver, FBLeftRadVal, "radius_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		elements.add(new IWVElement(driver, FBLeftProxDoubleVal, "includeNearValve_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		elements.add(new IWVSElement(driver, FBLeftProxUnitVal, "includeNearValve_iwv", argumentFile.defaultValues.defaultIWVSValue, ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(ProximityBool) {
			elements.add(new RGElement(driver, FBLeftRadioVal, "reportType_rg", argumentFile.defaultValues.defaultRGValues));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		
		current = 2;
		
		//Left Up
		elements.add(new IWVElement(driver, FBLeftUpDirVal, "customName_iwv", argumentFile.defaultValues.defaultIWVValue, LabelBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(LabelBool) {
			elements.add(new IWVElement(driver, FBLeftUpAngVal, "angle_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
			elements.add(new IWVElement(driver, FBLeftUpRadVal, "radius_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		elements.add(new IWVElement(driver, FBLeftUpProxDoubleVal, "includeNearValve_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		elements.add(new IWVSElement(driver, FBLeftUpProxUnitVal, "includeNearValve_iwv", argumentFile.defaultValues.defaultIWVSValue, ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(ProximityBool) {
			elements.add(new RGElement(driver, FBLeftUpRadioVal, "reportType_rg", argumentFile.defaultValues.defaultRGValues));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		
		current = 3;
		
		//Left Down
		elements.add(new IWVElement(driver, FBLeftDownDirVal, "customName_iwv", argumentFile.defaultValues.defaultIWVValue, LabelBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(LabelBool) {
			elements.add(new IWVElement(driver, FBLeftDownAngVal, "angle_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
			elements.add(new IWVElement(driver, FBLeftDownRadVal, "radius_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		elements.add(new IWVElement(driver, FBLeftDownProxDoubleVal, "includeNearValve_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		elements.add(new IWVSElement(driver, FBLeftDownProxUnitVal, "includeNearValve_iwv", argumentFile.defaultValues.defaultIWVSValue, ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(ProximityBool) {
			elements.add(new RGElement(driver, FBLeftDownRadioVal, "reportType_rg", argumentFile.defaultValues.defaultRGValues));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		
		current = 4;
		
		//Right
		elements.add(new IWVElement(driver, FBRightDirVal, "customName_iwv", argumentFile.defaultValues.defaultIWVValue, LabelBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(LabelBool) {
			elements.add(new IWVElement(driver, FBRightAngVal, "angle_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
			elements.add(new IWVElement(driver, FBRightRadVal, "radius_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		elements.add(new IWVElement(driver, FBRightProxDoubleVal, "includeNearValve_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		elements.add(new IWVSElement(driver, FBRightProxUnitVal, "includeNearValve_iwv", argumentFile.defaultValues.defaultIWVSValue, ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(ProximityBool) {
			elements.add(new RGElement(driver, FBRightRadioVal, "reportType_rg", argumentFile.defaultValues.defaultRGValues));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		
		current = 5;
		
		//Right Down
		elements.add(new IWVElement(driver, FBRightDownDirVal, "customName_iwv", argumentFile.defaultValues.defaultIWVValue, LabelBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(LabelBool) {
			elements.add(new IWVElement(driver, FBRightDownAngVal, "angle_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
			elements.add(new IWVElement(driver, FBRightDownRadVal, "radius_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		elements.add(new IWVElement(driver, FBRightDownProxDoubleVal, "includeNearValve_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		elements.add(new IWVSElement(driver, FBRightDownProxUnitVal, "includeNearValve_iwv", argumentFile.defaultValues.defaultIWVSValue, ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(ProximityBool) {
			elements.add(new RGElement(driver, FBRightDownRadioVal, "reportType_rg", argumentFile.defaultValues.defaultRGValues));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		
		current = 6;
		
		//Right Up
		elements.add(new IWVElement(driver, FBRightUpDirVal, "customName_iwv", argumentFile.defaultValues.defaultIWVValue, LabelBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(LabelBool) {
			elements.add(new IWVElement(driver, FBRightUpAngVal, "angle_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
			elements.add(new IWVElement(driver, FBRightUpRadVal, "radius_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		elements.add(new IWVElement(driver, FBRightUpProxDoubleVal, "includeNearValve_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		elements.add(new IWVSElement(driver, FBRightUpProxUnitVal, "includeNearValve_iwv", argumentFile.defaultValues.defaultIWVSValue, ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(ProximityBool) {
			elements.add(new RGElement(driver, FBRightUpRadioVal, "reportType_rg", argumentFile.defaultValues.defaultRGValues));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		
		current = 7;
		
		//Up
		elements.add(new IWVElement(driver, FBUpDirVal, "customName_iwv", argumentFile.defaultValues.defaultIWVValue, LabelBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(LabelBool) {
			elements.add(new IWVElement(driver, FBUpAngVal, "angle_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
			elements.add(new IWVElement(driver, FBUpRadVal, "radius_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		elements.add(new IWVElement(driver, FBUpProxDoubleVal, "includeNearValve_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		elements.add(new IWVSElement(driver, FBUpProxUnitVal, "includeNearValve_iwv", argumentFile.defaultValues.defaultIWVSValue, ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(ProximityBool) {
			elements.add(new RGElement(driver, FBUpRadioVal, "reportType_rg", argumentFile.defaultValues.defaultRGValues));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		
		//Drag Drop List
		elements.add(new DragListElement(driver, forgedDragVal, "bends_cl", 
				(List<String>) argumentFile.uniqueValues.get("bends_cl"), argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
		

		current = 1; //Field Bends direct sub-elements are second instances of such.
		elements.add(new OpenExpansionPanels(driver, null, "fieldBends_st", new int[] {0}));
		elements.add(new IWVElement(driver, FieldLabelDescVal, "customName_iwvtf", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeCB));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		elements.add(new CBElement(driver, FieldClassificationVal, "includeClassification_cb", argumentFile.defaultValues.includeCB));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		boolean includeFieldBend = argumentFile.defaultValues.includeIWVorIWVS;
		elements.add(new CBElement(driver, FieldBendAngleVal, "includeAngle_cb", includeFieldBend));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(includeFieldBend)
		{
			elements.add(new SelectElement(driver, FieldBendSymbolVal, "degreeSymbol_ts", argumentFile.defaultValues.defaultSelectValue)); //Requires previous to be true to modify.
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		elements.add(new CBElement(driver, FieldIntAngleVal, "includeIntegerAngle_cb", argumentFile.defaultValues.includeCB));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		elements.add(new CBElement(driver, FieldBendRadVal, "includeBendRadius_cb", argumentFile.defaultValues.includeCB));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		elements.add(new IWVElement(driver, FieldRoundAngVal, "roundOrientation_iwvtf", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		
		//Open All sub-tabs
		elements.add(new OpenExpansionPanels(driver, null, "fieldBends_st", new int[] {1, 2, 3, 4, 5, 6, 7, 8}));
		
		current = 8; 
		
		//Down
		elements.add(new IWVElement(driver, FieldDownDirVal, "customName_iwv", argumentFile.defaultValues.defaultIWVValue, LabelBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(LabelBool) {
			elements.add(new IWVElement(driver, FieldDownAngVal, "angle_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
			elements.add(new IWVElement(driver, FieldDownRadVal, "radius_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		elements.add(new IWVElement(driver, FieldDownProxDoubleVal, "includeNearValve_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		elements.add(new IWVSElement(driver, FieldDownProxUnitVal, "includeNearValve_iwv", argumentFile.defaultValues.defaultIWVSValue, ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(ProximityBool) {
			elements.add(new RGElement(driver, FieldDownRadioVal, "reportType_rg", argumentFile.defaultValues.defaultRGValues));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}

		current = 9; 
		
		//Left
		elements.add(new IWVElement(driver, FieldLeftDirVal, "customName_iwv", argumentFile.defaultValues.defaultIWVValue, LabelBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(LabelBool) {
			elements.add(new IWVElement(driver, FieldLeftAngVal, "angle_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
			elements.add(new IWVElement(driver, FieldLeftRadVal, "radius_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		elements.add(new IWVElement(driver, FieldLeftProxDoubleVal, "includeNearValve_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		elements.add(new IWVSElement(driver, FieldLeftProxUnitVal, "includeNearValve_iwv", argumentFile.defaultValues.defaultIWVSValue, ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(ProximityBool) {
			elements.add(new RGElement(driver, FieldLeftRadioVal, "reportType_rg", argumentFile.defaultValues.defaultRGValues));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		
		current = 10;
		
		//Left Up
		elements.add(new IWVElement(driver, FieldLeftUpDirVal, "customName_iwv", argumentFile.defaultValues.defaultIWVValue, LabelBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(LabelBool) {
			elements.add(new IWVElement(driver, FieldLeftUpAngVal, "angle_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
			elements.add(new IWVElement(driver, FieldLeftUpRadVal, "radius_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		elements.add(new IWVElement(driver, FieldLeftUpProxDoubleVal, "includeNearValve_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		elements.add(new IWVSElement(driver, FieldLeftUpProxUnitVal, "includeNearValve_iwv", argumentFile.defaultValues.defaultIWVSValue, ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(ProximityBool) {
			elements.add(new RGElement(driver, FieldLeftUpRadioVal, "reportType_rg", argumentFile.defaultValues.defaultRGValues));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		
		current = 11;
		
		//Left Down
		elements.add(new IWVElement(driver, FieldLeftDownDirVal, "customName_iwv", argumentFile.defaultValues.defaultIWVValue, LabelBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(LabelBool) {
			elements.add(new IWVElement(driver, FieldLeftDownAngVal, "angle_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
			elements.add(new IWVElement(driver, FieldLeftDownRadVal, "radius_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		elements.add(new IWVElement(driver, FieldLeftDownProxDoubleVal, "includeNearValve_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		elements.add(new IWVSElement(driver, FieldLeftDownProxUnitVal, "includeNearValve_iwv", argumentFile.defaultValues.defaultIWVSValue, ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(ProximityBool) {
			elements.add(new RGElement(driver, FieldLeftDownRadioVal, "reportType_rg", argumentFile.defaultValues.defaultRGValues));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		
		current = 12;
		
		//Right
		elements.add(new IWVElement(driver, FieldRightDirVal, "customName_iwv", argumentFile.defaultValues.defaultIWVValue, LabelBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(LabelBool) {
			elements.add(new IWVElement(driver, FieldRightAngVal, "angle_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
			elements.add(new IWVElement(driver, FieldRightRadVal, "radius_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		elements.add(new IWVElement(driver, FieldRightProxDoubleVal, "includeNearValve_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		elements.add(new IWVSElement(driver, FieldRightProxUnitVal, "includeNearValve_iwv", argumentFile.defaultValues.defaultIWVSValue, ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(ProximityBool) {
			elements.add(new RGElement(driver, FieldRightRadioVal, "reportType_rg", argumentFile.defaultValues.defaultRGValues));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		
		current = 13;
		
		//Right Down
		elements.add(new IWVElement(driver, FieldRightDownDirVal, "customName_iwv", argumentFile.defaultValues.defaultIWVValue, LabelBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(LabelBool) {
			elements.add(new IWVElement(driver, FieldRightDownAngVal, "angle_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
			elements.add(new IWVElement(driver, FieldRightDownRadVal, "radius_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		elements.add(new IWVElement(driver, FieldRightDownProxDoubleVal, "includeNearValve_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		elements.add(new IWVSElement(driver, FieldRightDownProxUnitVal, "includeNearValve_iwv", argumentFile.defaultValues.defaultIWVSValue, ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(ProximityBool) {
			elements.add(new RGElement(driver, FieldRightDownRadioVal, "reportType_rg", argumentFile.defaultValues.defaultRGValues));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		
		current = 14;
		
		//Right Up
		elements.add(new IWVElement(driver, FieldRightUpDirVal, "customName_iwv", argumentFile.defaultValues.defaultIWVValue, LabelBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(LabelBool) {
			elements.add(new IWVElement(driver, FieldRightUpAngVal, "angle_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
			elements.add(new IWVElement(driver, FieldRightUpRadVal, "radius_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), argumentFile.defaultValues.includeIWVorIWVS));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		elements.add(new IWVElement(driver, FieldRightUpProxDoubleVal, "includeNearValve_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		elements.add(new IWVSElement(driver, FieldRightUpProxUnitVal, "includeNearValve_iwv", argumentFile.defaultValues.defaultIWVSValue, ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(ProximityBool) {
			elements.add(new RGElement(driver, FieldRightUpRadioVal, "reportType_rg", argumentFile.defaultValues.defaultRGValues));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		
		current = 15;
		
		//Up
		elements.add(new IWVElement(driver, FieldUpDirVal, "customName_iwv", argumentFile.defaultValues.defaultIWVValue, LabelBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(LabelBool) {
			elements.add(new IWVElement(driver, FieldUpAngVal, "angle_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), true));
			elements.get(elements.size() - 1).setDesiredInstance(current);
			elements.add(new IWVElement(driver, FieldUpRadVal, "radius_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), true));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		elements.add(new IWVElement(driver, FieldUpProxDoubleVal, "includeNearValve_iwv", Integer.toString(argumentFile.defaultValues.defaultIWVSValue), ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		elements.add(new IWVSElement(driver, FieldUpProxUnitVal, "includeNearValve_iwv", argumentFile.defaultValues.defaultIWVSValue, ProximityBool));
		elements.get(elements.size() - 1).setDesiredInstance(current);
		if(ProximityBool) {
			elements.add(new RGElement(driver, FieldUpRadioVal, "reportType_rg", argumentFile.defaultValues.defaultRGValues));
			elements.get(elements.size() - 1).setDesiredInstance(current);
		}
		
		//Drag Drop List
		elements.add(new DragListElement(driver, fieldDragVal, "bends_cl", (List<String>) argumentFile.uniqueValues.get("bends_cl"), argumentFile.defaultValues.dragListSeparatorValues, argumentFile.defaultValues.dragListSeparatorOptions));
		elements.get(elements.size() - 1).setDesiredInstance(1);
		
		//Wrinkle bends
		elements.add(new IWVElement(driver, WrinkleLabelVal, "includeWrinkleDescription_iwv", argumentFile.defaultValues.defaultIWVValue, argumentFile.defaultValues.includeIWVorIWVS));
		elements.add(new CBElement(driver, WrinkleCountVal, "includeWrinkleCountinLabel_cb", argumentFile.defaultValues.includeCB));
		
		boolean lessThanBends = argumentFile.defaultValues.includeIWVorIWVS;
		elements.add(new CBElement(driver, WrinkleBendForLesThanVal, "includeBelowBendDegree_iwvtf", lessThanBends));
		if(lessThanBends) {
			elements.add(new TextElement(driver, WrinkleBendCustomVal, "value_tf", argumentFile.defaultValues.defaultTextValue));
			elements.get(elements.size() - 1).setDesiredInstance(55);
			elements.add(new TextElement(driver, WrinkleBendNumVal, "includeBelowBendDegree_iwvtf", Integer.toString(argumentFile.defaultValues.defaultIWVSValue)));
			elements.add(new SelectElement(driver, WrinkleBendUnitVal, "includeBelowBendDegree_iwvtf", 0));
		}
		elements.add(new CBElement(driver, WrinkleBookmarkVal, "bookmarkWrinkleCount_cb", argumentFile.defaultValues.includeCB));
		
		//Analysis
		elements.add(new TextElement(driver, deviationsVal, "additionalNotes_ta", argumentFile.defaultValues.defaultTextValue));
		elements.add(new TextElement(driver, markingsVal, "examples_ta", argumentFile.defaultValues.defaultTextValue));
		
		elements.add(new StationingSelectElement(driver, stationingVal, "stationing_sta", (List<String>) argumentFile.uniqueValues.get("availableList"), (List<String>) argumentFile.uniqueValues.get("selectedList"), 
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
		compTest.compaireDB(elements, "Bends", tables.BENDS, "BendsResults", argumentFile.FileCounter);
	}
}