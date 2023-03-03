package chromedriver;

import org.openqa.selenium.*;
import chromedriver.ElementValidationInterface;
import chromedriver.UIElements.ClickExpansionPanel;
import chromedriver.UIElements.SelectElement;
import chromedriver.UIElements.TextElement;

import com.nimbusds.jose.util.ArrayUtils;
import com.tdw.csr.dao.*;

import java.util.List;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;


public class UIElements extends BaseCDTest {
	
public String txtValue = null;
public String elm =null;
public String secondaryElm = null;
public boolean bool = false;
public boolean secondaryFlag = false;
public boolean tertiaryFlag = false;
public String checked;
public int dropDownIndex = -1;
public int generalIndex = -1;
public int[] controlIndices;
public int[] secondaryControlIndices;
public List<String> list = null;
public List<String> secondaryList = null;
public WebDriver driverRef = null;
public int useNameInstance = 0;

public boolean failedExecution = false; // Marked true if an exception was found while modifying the page
public boolean failedValidation = false; // Marked true if an exception was found while validating
public boolean failedLogging = false; //Marked true if an exception is found while filling out the JSON log.
public String exceptionMessage = null;

//Validation Variables
public ElementValidationInterface validator; //The Lambda Expression which will validate agianst the database.
public List<String> validationStrings; //Optional: Filled out by UIElement Constructor
public String expectedValue = "NO EXPECTED VALUE SET"; //Filled out by UIElement Constructor
public String returnedValues = ""; //Filled out by Validator inside CompaireDB.java


	/*
	 * UIElement objects are used for the purpose of being read off by the test engine to have their status changed.
	 * 
	 * Each UIElement is constructed as a subclass of UIElement. Each subclass has a unique parameter set for its constructor,
	 * which allows it to be properly read off by the engine.
	 * 
	 * Due to an engine limitation, strings are passed in instead of WebElement objects and all test types
	 * require a reference to the driver from the test.
	 */
	
	/**
	 * Runs the designated test on a type of WebElement. Each UIElement subclass contains its own test method.
	 * Is overriden by each child class.
	 * 
	 * 
	 * @throws InterruptedException
	 */
	public void runTestConfiguration() throws Exception {} 

	/**
	 * In the event that a page contains multiple objects which will be found by the search function,
	 * this method will change which instance of that name will be used.
	 * 
	 * NOTE: The overhead of this function means that all methods must use findElements(foo).get(useNameInstance)
	 * when finding the element in question.
	 * 
	 * @param desiredInstance which instance of the named object should be used during this test. Defaults to 0.
	 * 
	 * @throws InterruptedException
	 */
	public void setDesiredInstance(int desiredInstance)
	{
		this.useNameInstance = desiredInstance;
	}
	
	//Constructor for Checkbox Elements
	public static class CBElement extends UIElements {

		/**
		 * Checkbox Element Constructor
		 * 
		 * @param thisDriver is the driver
		 * @param validator the validator for this UIElement. Enter null to avoid database comparison.
		 * @param cbName is the name of the cb Element
		 * @param setTo Whether the checkbox will be set to true or false 
		 */
		public CBElement(WebDriver thisDriver, ElementValidationInterface validator, String cbName, boolean setTo) {
			if (setTo==true) {
				this.checked = "checked";
			} else if (setTo==false) {
				this.checked = "unChecked";
			}
			
			this.driverRef = thisDriver;
			this.bool = setTo;
			this.elm = cbName;
			this.validator = validator;
			this.expectedValue = setTo ? "True" : "False";
		}
		
		/*
		 * Checkboxes are tested simply by having their value set to true or false.
		 */
		public void runTestConfiguration() throws Exception {
			System.out.println("Working on CBElement "+ this.elm);
			WebElement ele = driverRef.findElements(By.name(this.elm)).get(this.useNameInstance);
			
			if(this.bool)
			{
				if (!findCheckboxSelectedElement(ele).isSelected()) {
					findCheckboxClickElement(ele).click();
				}
			}
			else
			{
				if (findCheckboxSelectedElement(ele).isSelected()) {
					findCheckboxClickElement(ele).click();
				}
			}
			
			Thread.sleep(200);
		}


	}
	
	
	//Constructor for CBList Elements
	public static class CBListElement extends UIElements {

		/**
		 * Checkbox List Element
		 * 
		 * Some objects will be a list of multiple checkboxes, with the list having an ms_ prefix.
		 * 
		 * @param thisDriver is the driver
		 * @param validator the validator for this UIElement. Enter null to avoid database comparison.
		 * @param listName is the name of the CBList Element
		 * @param setTo An integer array of 0s and 1s, indicating true or false accordingly.
		 */
		public CBListElement(WebDriver thisDriver, ElementValidationInterface validator, String listName, int[] setTo) {
			this.driverRef = thisDriver;
			this.controlIndices = setTo;
			this.elm = listName;
			this.validator = validator;
						
			this.expectedValue = "";
			for (int i = 0; i < this.controlIndices.length; i++)
			{
				if(i != 0)
					this.expectedValue += ", ";
				this.expectedValue += this.controlIndices[i] == 1 ? "True" : "False";
			}
		}
		
		/*
		 * Checkboxes are tested simply by having their value set to true or false.
		 */
		public void runTestConfiguration() throws Exception {
			System.out.println("Working on CBListElement "+ this.elm);
			WebElement ele = driverRef.findElements(By.name(this.elm)).get(this.useNameInstance);
			
			List<WebElement> CBElements = ele.findElements(By.className("v-input__control"));
			
			for(int i = 0; i < CBElements.size(); i++)
			{
				ele = CBElements.get(i);
				//The CBList checkboxes have different naming conventions, so they need a unique way to find the select element.
				if(this.controlIndices[i] == 1)
				{
					if (!ele.findElement(By.name("selectedItems_cb")).isSelected()) {
						findCheckboxClickElement(ele).click();
					}
				}
				else
				{
					if (ele.findElement(By.name("selectedItems_cb")).isSelected()) {
						findCheckboxClickElement(ele).click();
					}
				}
			}
			
			
			Thread.sleep(200);
		}


	}
	
	
	//Constructor for RuleList Elements
	public static class addDentRuleListElement extends UIElements {

		/**
		 * Rule List Elements
		 * 
		 * Adds a rule to a reporting rule list. This one is used for Dents specifically.
		 * 
		 * IMPORTANT NOTE: In the event that a duplicate is attempted to be added the test will fail,
		 * as duplicates cannot be added but Selenium does not allow us to check if the window was
		 * left open without throwing an exception.
		 * 
		 * 
		 * @param thisDriver is the driver
		 * @param validator the validator for this UIElement. Enter null to avoid database comparison.
		 * @param listName is the name of the Rule List Element
		 * @param type This designates which type of rule it will be. 0 for 'filter out of reports', 1 for 'Round'.
		 * @param setTo Control Settings. 
		 * If type = 0: settings[0] = 'Pits with depth' selection - settings[1] = 'Pits with depth' % value
		 * If type = 1: settings[0] = 'Round Up/Down' selection - settings[1] = 'Pits with depth' selection -
		 * settings[2] = 'Pits with depth' % value - settings[3-4] = second instance of 'Pits with depth' -
		 * settings[5] = 'To:' % value
		 * @param textBox The value to place in the text box
		 */
		public addDentRuleListElement(WebDriver thisDriver, ElementValidationInterface validator, String listName, int[] settings, String textBox) {
			this.driverRef = thisDriver;
			this.controlIndices = settings;
			this.elm = listName;
			this.validator = validator;
			this.txtValue = textBox;
		}
		
		/*
		 * Checkboxes are tested simply by having their value set to true or false.
		 */
		public void runTestConfiguration() throws Exception {
			System.out.println("Working on DentRuleListElement "+ this.elm);
			WebElement ele = driverRef.findElements(By.name(this.elm)).get(this.useNameInstance);
			WebElement addRule = ele.findElement(By.name("addRule_bt")); //Find the Add Rule Button
			
			//Open Add Rule Window
			addRule.click();
			Thread.sleep(800);
			
			WebElement window = this.driverRef.findElement(By.className("v-dialog--active"));
			
			//Begin modifying fields
			Thread.sleep(500); // Let the user actually see something!
			WebElement tempEle = window.findElement(By.name("toolSize_s"));
			tempEle.click();
			Thread.sleep(200); // Let the user actually see something!
			List<WebElement> selectElements = findSelectElements(this.driverRef);
			int i = this.controlIndices[0];
			selectElements.get(i).click();
			
			Thread.sleep(500); // Let the user actually see something!
			WebElement tempEle1 = window.findElement(By.name("conditional_owv"));
			tempEle1.click();
			Thread.sleep(200); // Let the user actually see something!
			List<WebElement> selectElements1 = findSelectElements(this.driverRef);
			i = this.controlIndices[1];
			selectElements1.get(i).click();
			
			Thread.sleep(500); // Let the user actually see something!
			String entry = this.txtValue;
			tempEle = window.findElement(By.name("numValue_tf"));
			findTextFieldElement(tempEle).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(500); // Let the user actually see something!
			findTextFieldElement(tempEle).sendKeys(entry);
			Thread.sleep(500); // Let the user actually see something!
			
			Thread.sleep(500); // Let the user actually see something!
			WebElement tempEle2 = window.findElement(By.name("numUnits_s"));
			tempEle2.click();
			Thread.sleep(200); // Let the user actually see something!
			List<WebElement> selectElements2 = findSelectElements(this.driverRef);
			i = this.controlIndices[2];
			selectElements2.get(i).click();

		    //Close the window
		    WebElement okBtn = window.findElement(By.className("v-btn"));
		    okBtn.click();
			Thread.sleep(250);
		    
			Thread.sleep(250);
		}


	}
	
	
	//Constructor for RuleList Elements
	public static class addRuleListElement extends UIElements {

		/**
		 * Rule List Elements
		 * 
		 * Adds a rule to a reporting rule list.
		 * 
		 * IMPORTANT NOTE: In the event that a duplicate is attempted to be added the test will fail,
		 * as duplicates cannot be added but Selenium does not allow us to check if the window was
		 * left open without throwing an exception.
		 * 
		 * 
		 * @param thisDriver is the driver
		 * @param validator the validator for this UIElement. Enter null to avoid database comparison.
		 * @param listName is the name of the Rule List Element
		 * @param type This designates which type of rule it will be. 0 for 'filter out of reports', 1 for 'Round'.
		 * @param setTo Control Settings. 
		 * If type = 0: settings[0] = 'Pits with depth' selection - settings[1] = 'Pits with depth' % value
		 * If type = 1: settings[0] = 'Round Up/Down' selection - settings[1] = 'Pits with depth' selection -
		 * settings[2] = 'Pits with depth' % value - settings[3-4] = second instance of 'Pits with depth' -
		 * settings[5] = 'To:' % value
		 */
		public addRuleListElement(WebDriver thisDriver, ElementValidationInterface validator, String listName, int type, int[] settings) {
			this.driverRef = thisDriver;
			this.generalIndex = type;
			this.controlIndices = settings;
			this.elm = listName;
			this.validator = validator;
		}
		
		/*
		 * Checkboxes are tested simply by having their value set to true or false.
		 */
		public void runTestConfiguration() throws Exception {
			WebElement ele = driverRef.findElements(By.name(this.elm)).get(this.useNameInstance);
			WebElement addRule = ele.findElement(By.name("addRule_bt")); //Find the Add Rule Button
			
			//Open Add Rule Window
			addRule.click();
			Thread.sleep(250);
			WebElement window = this.driverRef.findElement(By.className("v-dialog--active"));
			
			//Begin Modifying Parameters
		    List<WebElement> radio = findRadioGroupClickElements(window.findElement(By.name("thresholdAndReportingType_rg"))); //Select Filter Out Reports

		    if(this.generalIndex == 0) //Filter Out of Reports
			{
				radio.get(0).click();
				
				Thread.sleep(500); // Let the user actually see something!
				WebElement tempEle = window.findElement(By.name("operatorEnum_s")); //Get XYZ Vertical
				tempEle.click();
				Thread.sleep(200); // Let the user actually see something!
				List<WebElement> selectElements = findSelectElements(this.driverRef);
				int i = this.controlIndices[0];
				selectElements.get(i).click();

				
				Thread.sleep(500); // Let the user actually see something!
				String entry = Integer.toString(this.controlIndices[1]);
				tempEle = window.findElement(By.name("textField_tf"));
				findTextFieldElement(tempEle).sendKeys(Keys.chord(Keys.CONTROL, "a"));
				Thread.sleep(500); // Let the user actually see something!
				findTextFieldElement(tempEle).sendKeys(entry);
				Thread.sleep(500); // Let the user actually see something!
			}
			else
			{
			    radio.get(1).click();
			    Thread.sleep(200);
				
			    //Round Up/Down selection
			    WebElement tempEle = window.findElement(By.name("roundUpDown_s"));
				tempEle.click();
				Thread.sleep(200); // Let the user actually see something!
				List<WebElement> selectElements = findSelectElements(this.driverRef);
				int i = this.controlIndices[0];
				selectElements.get(i).click();
			    
				//First Pits with Depth
				WebElement subEle = window.findElement(By.name("markersNearValves_owv"));
				
				tempEle = subEle.findElement(By.name("operatorEnum_s"));
				tempEle.click();
				Thread.sleep(200); // Let the user actually see something!
				selectElements = findSelectElements(this.driverRef);
				i = this.controlIndices[1];
				selectElements.get(i).click();
				
				tempEle = subEle.findElement(By.name("textField_tf"));
				String entry = Integer.toString(this.controlIndices[2]);
				findTextFieldElement(tempEle).sendKeys(Keys.chord(Keys.CONTROL, "a"));
				Thread.sleep(500); // Let the user actually see something!
				findTextFieldElement(tempEle).sendKeys(entry);
				Thread.sleep(500); // Let the user actually see something!
				
				
				//Second Pits with Depth
				subEle = window.findElement(By.name("roundTo_owv"));
				
				tempEle = subEle.findElement(By.name("operatorEnum_s"));
				tempEle.click();
				Thread.sleep(350); // Let the user actually see something!
				selectElements = findSelectElements(this.driverRef);
				i = this.controlIndices[3];
				selectElements.get(i).click();
				
				tempEle = subEle.findElement(By.name("textField_tf"));
				entry = Integer.toString(this.controlIndices[4]);
				findTextFieldElement(tempEle).sendKeys(Keys.chord(Keys.CONTROL, "a"));
				Thread.sleep(250); // Let the user actually see something!
				findTextFieldElement(tempEle).sendKeys(entry);
				Thread.sleep(250); // Let the user actually see something!
				
				//To Field
				entry = Integer.toString(this.controlIndices[5]);
				tempEle = window.findElement(By.name("roundAllTo_tf"));
				findTextFieldElement(tempEle).sendKeys(Keys.chord(Keys.CONTROL, "a"));
				Thread.sleep(250); // Let the user actually see something!
				findTextFieldElement(tempEle).sendKeys(entry);
				Thread.sleep(250); // Let the user actually see something!
			}
			
		    //Close the window
		    WebElement okBtn = window.findElement(By.className("v-btn"));
		    okBtn.click();
			Thread.sleep(250);
		    
			Thread.sleep(250);
		}


	}
	
	
	//Constructor for clearing RuleList Elements
	public static class clearRuleListElement extends UIElements {

		/**
		 * Clear Rule List Elements
		 * 
		 * Deletes all rules from a rule list.
		 * Recommended to be used prior to adding rules, to prevent an exception.
		 * 
		 * 
		 * @param thisDriver is the driver
		 * @param validator the validator for this UIElement. Enter null to avoid database comparison.
		 * @param listName is the name of the Rule List Element
		 */
		public clearRuleListElement(WebDriver thisDriver, ElementValidationInterface validator, String listName) {
			this.driverRef = thisDriver;
			this.elm = listName;
			this.validator = validator;
		}
		
		/*
		 * Checkboxes are tested simply by having their value set to true or false.
		 */
		public void runTestConfiguration() throws Exception {
			WebElement ele = driverRef.findElements(By.name(this.elm)).get(this.useNameInstance);

			List<WebElement> availableElements = ele.findElements(By.name("remove_bt"));
			
			//Empty the Rules List
			Thread.sleep(500); 
			while(availableElements.size() > 0)
			{
					availableElements.get(0).click();
					availableElements = ele.findElements(By.name("remove_bt"));
					Thread.sleep(500);
			}	
		}


	}
	
	
	//Constructor for removing 1 RuleList Element
	public static class removeRuleListElement extends UIElements {

		/**
		 * Clear Rule List Elements
		 * 
		 * Deletes one rule from a rule list.
		 * 
		 * @param thisDriver is the driver
		 * @param validator the validator for this UIElement. Enter null to avoid database comparison.
		 * @param listName is the name of the Rule List Element
		 * @param index The position in the rule list of the element you want to remove.
		 */
		public removeRuleListElement(WebDriver thisDriver, ElementValidationInterface validator, String listName, int index) {
			this.driverRef = thisDriver;
			this.elm = listName;
			this.generalIndex = index;
			this.validator = validator;
		}
		
		/*
		 * Checkboxes are tested simply by having their value set to true or false.
		 */
		public void runTestConfiguration() throws Exception {
			WebElement ele = driverRef.findElements(By.name(this.elm)).get(this.useNameInstance);

			List<WebElement> availableElements = ele.findElements(By.name("remove_bt"));
			
			availableElements.get(this.generalIndex).click();
			availableElements = ele.findElements(By.name("remove_bt"));
			Thread.sleep(500);
		}


	}
	
	
	//Constructor for OpenExpansionPanels Objects
	public static class OpenExpansionPanels extends UIElements {

		/**
		 * OpenListPanels Constructor
		 * 
		 * Opens each panel related to an element.
		 * 
		 * @param thisDriver is the driver
		 * @param validator the validator for this UIElement. Enter null to avoid database comparison.
		 * @param oName is the name of the Element
		 * @param usageIndex values in this array will be clicked, as expansion elements are often grouped or nested.
		 */
		public OpenExpansionPanels(WebDriver thisDriver, ElementValidationInterface validator, String oName, int[] usageIndex) {
			this.driverRef = thisDriver;
			this.elm = oName;
			this.controlIndices = usageIndex;
			this.validator = validator;
		}
		
		public void runTestConfiguration() throws Exception {
			System.out.println("Working on OpenExpansionPanels "+ this.elm);
			WebElement ele = driverRef.findElements(By.name(this.elm)).get(this.useNameInstance);
		
			List<WebElement> elementList = ele.findElements(By.className("v-expansion-panel"));
			
			
			//Click each element, not in the control index, in order
			for(int i = 0; i < elementList.size(); i ++)
			{
				Thread.sleep(200); //A significant delay is required for this element type.
				int k = i;
				if(Arrays.stream(this.controlIndices).anyMatch(j -> j == k)) //Array contains i
					elementList.get(i).click();
			}
				
			Thread.sleep(500);
		}


	}
	
	
	//Constructor for ClickExpansionPanel Objects
	public static class ClickExpansionPanel extends UIElements {

		/**
		 * Open Expansion Panel Constructor
		 * 
		 * Opens the given expansion panel. Same function as OpenExpansionPanels,
		 * but takes one expansion panel rather than a container of multiple.
		 * 
		 * Primarily for use with lone expansion panels.
		 * 
		 * @param thisDriver is the driver
		 * @param validator the validator for this UIElement. Enter null to avoid database comparison.
		 * @param oName is the name of the Expansion Panel
		 */
		public ClickExpansionPanel(WebDriver thisDriver, String oName) {
			this.driverRef = thisDriver;
			this.elm = oName;
			this.validator = null;
		}
		
		public void runTestConfiguration() throws Exception {
			System.out.println("Working on ClickExpansionPanel "+ this.elm);
			WebElement ele = driverRef.findElements(By.name(this.elm)).get(this.useNameInstance);
			
			ele.click();
				
			Thread.sleep(500);
		}


	}
	
	//Constructor for ClickExpansionPanel Objects
	public static class clickElement extends UIElements {

		/**
		 * Clicks the designated element
		 * 
		 * @param thisDriver is the driver
		 * @param oName is the name of the object
		 */
		public clickElement(WebDriver thisDriver, String oName) {
			this.driverRef = thisDriver;
			this.elm = oName;
		}
		
		public void runTestConfiguration() throws Exception {
			System.out.println("Working on ClickExpansionPanel "+ this.elm);
			WebElement ele = driverRef.findElements(By.name(this.elm)).get(this.useNameInstance);
			
			ele.click();
				
			Thread.sleep(500);
		}


	}
	
	//Constructor for ClickExpansionPanel Objects
	public static class clickClassElement extends UIElements {

		/**
		 * Clicks the designated element corresponding to a class
		 * 
		 * @param thisDriver is the driver
		 * @param cName is the name of the class
		 */
		public clickClassElement(WebDriver thisDriver, String cName) {
			this.driverRef = thisDriver;
			this.elm = cName;
		}
		
		public void runTestConfiguration() throws Exception {
			System.out.println("Working on ClickExpansionPanel "+ this.elm);
			WebElement ele = driverRef.findElements(By.className(this.elm)).get(this.useNameInstance);
			
			ele.click();
				
			Thread.sleep(500);
		}


	}
	
	//Tries to close any windows that may be open. This is to prevent an exception from leaving its popup open.
	public static class tryCloseDialogElement extends UIElements {

		/**
		 * Close Dialog Constructor
		 * 
		 * Searches for and tries to close any Dialogs which are left behind by other elements.
		 * 
		 * Used when running other elements to ensure that nothing leaves a Dialog open after an exception, which would cause the entire process to halt.
		 * 
		 * @param thisDriver is the driver
		 */
		public tryCloseDialogElement(WebDriver thisDriver) {
			this.driverRef = thisDriver;
			this.validator = null;
		}
		
		public void runTestConfiguration() throws Exception {
			System.out.println("Exception Detected, Closing Any Leftover Dialogs");
			WebElement ele = this.driverRef.findElement(By.className("v-dialog--active")).findElement(By.name("cancel_btn"));
			
			ele.click();
				
			Thread.sleep(500);
		}


	}
	
	
	//Constructor for Select Elements
	public static class SelectElement extends UIElements {
		
		/**
		 * Select List Element Constructor
		 * 
		 * @param sEle is the name of the Select Element
		 * @param validator the validator for this UIElement. Enter null to avoid database comparison.
		 * @param selection The resultant selection will be Element[selection], base 0.
		 * @param driver This particular type of element requires a reference to the WebDriver
		 */
		public SelectElement(WebDriver thisDriver, ElementValidationInterface validator, String sEle, int selection) {
			this.dropDownIndex = selection;
			this.driverRef = thisDriver;
			this.elm = sEle;
			this.validator = validator;
		}
		
		/*
		 * Select Lists are tested by having a specific element (by position) selected.
		 */
		public void runTestConfiguration() throws Exception {
			System.out.println("Working on SelectElement "+ this.elm);
			
			WebElement select = driverRef.findElements(By.name(this.elm)).get(this.useNameInstance).findElement(By.className("v-select"));
			select.click();
			List<WebElement> selectElements = findSelectElements(this.driverRef);
			int i = this.dropDownIndex;
			
			Thread.sleep(200);
			
			selectElements.get(i).click();
			
			Thread.sleep(200);
		}
	}
	
	
	//Constructor for Orientation Description Elements
	public static class OrientationDescElement extends UIElements {
		
		/**
		 * Orientation Description Element Constructor
		 * 
		 * @param driver is the driver
		 * @param validator the validator for this UIElement. Enter null to avoid database comparison.
		 * @param orEle is the name of the element
		 * @param buttonName is the name of the button used to open the Orientation Desc overlay
		 * @param selection An 8 length array of Integers to be picked from the lists in pairs order of Top, Left, Right, Bottom
		 */
		public OrientationDescElement(WebDriver driver, ElementValidationInterface validator, String orEle, String buttonName, int[] selections) {
			this.elm = orEle;
			this.secondaryElm = buttonName;
			this.driverRef = driver;
			this.controlIndices = selections;
			this.validator = validator;
			
			mapValidationStrings();
			this.expectedValue = this.validationStrings.toString().replace("[", "").replace("]", ""); //Removes the Array Brackets
		}
		
		/**
		 * Validation Mapping: Fills the validation Strings array with the corresponding selections.
		 * From the controlIndices provided.
		 * 
		 * Validation Mapping is done in the constructor for Orientations, unlike most, as the
		 * Orientation Description Element is not modified between CSR pages.
		 * 
		 * If the options change, this map needs to be updated.
		 */
		
		private void mapValidationStrings() {
			this.validationStrings = new ArrayList<String>();
			
			String[] topBottomPrefixList = {"On", "At", "@", "Of", "on", "at", "of", ""};
			String[] topBottomDescriptionList = {"Top", "Bottom", "12:00", "6:00", "0", "180", "top", "bottom"};
			String[] leftRigthPrefixList = {"At", "@", "at", ""};
			String[] leftDescriptionList = {"9:00", "270"};
			String[] rightDescriptionList = {"3:00", "90"};
			
			//Add the corresponding option to the validationStrings
			this.validationStrings.add(topBottomPrefixList[this.controlIndices[0]]);
			this.validationStrings.add(topBottomDescriptionList[this.controlIndices[1]]);
			
			this.validationStrings.add(leftRigthPrefixList[this.controlIndices[2]]);
			this.validationStrings.add(leftDescriptionList[this.controlIndices[3]]);
			
			this.validationStrings.add(leftRigthPrefixList[this.controlIndices[4]]);
			this.validationStrings.add(rightDescriptionList[this.controlIndices[5]]);
			
			this.validationStrings.add(topBottomPrefixList[this.controlIndices[6]]);
			this.validationStrings.add(topBottomDescriptionList[this.controlIndices[7]]);
		}
		
		/*
		 * Goes through every option in the Orientation Description pop-up window.
		 */
		public void runTestConfiguration() throws Exception {
			System.out.println("Working on OrientationDescElement "+ this.elm);
			WebElement ele = driverRef.findElement(By.name("includeOrientation_cb")); // Find the includeOrientation Checkbox

			if (ele.isEnabled()) // if it is enabled (which it should be because we clicked the edit button)
			{
				if (!findCheckboxSelectedElement(ele).isSelected()) {
					findCheckboxClickElement(ele).click();
					Thread.sleep(200); // Let the user actually see something!
				}

				ele = driverRef.findElement(By.name("od_btn")); // Find the Orientation Description button
				ele.click();

				Thread.sleep(200); // Let the user actually see something!
				WebElement select = driverRef.findElement(By.name("topPrefix_dp")).findElement(By.name("prefixItems_s"));
				select.click();
				Thread.sleep(200); // Let the user actually see something!
				List<WebElement> selectElements = findSelectElements(driverRef);
				
				int i = this.controlIndices[0];
				selectElements.get(i).click();

				Thread.sleep(200); // Let the user actually see something!
				select = driverRef.findElement(By.name("topPrefix_dp")).findElement(By.name("descriptionItems_s"));
				select.click();
				Thread.sleep(200); // Let the user actually see something!
				selectElements = findSelectElements(driverRef);
				i = this.controlIndices[1];
				selectElements.get(i).click();

				Thread.sleep(200); // Let the user actually see something!
				select = driverRef.findElement(By.name("twoSeventyPrefix_dp")).findElement(By.name("prefixItems_s"));
				select.click();
				Thread.sleep(200); // Let the user actually see something!
				selectElements = findSelectElements(driverRef);
				i = this.controlIndices[2];
				selectElements.get(i).click();

				Thread.sleep(200); // Let the user actually see something!
				select = driverRef.findElement(By.name("twoSeventyPrefix_dp")).findElement(By.name("descriptionItems_s"));
				select.click();
				Thread.sleep(200); // Let the user actually see something!
				selectElements = findSelectElements(driverRef);
				i = this.controlIndices[3];
				selectElements.get(i).click();

				Thread.sleep(200); // Let the user actually see something!
				select = driverRef.findElement(By.name("ninetyDegreesDescr_dp")).findElement(By.name("prefixItems_s"));
				select.click();
				Thread.sleep(200); // Let the user actually see something!
				selectElements = findSelectElements(driverRef);
				i = this.controlIndices[4];
				selectElements.get(i).click();

				Thread.sleep(200); // Let the user actually see something!
				select = driverRef.findElement(By.name("ninetyDegreesDescr_dp")).findElement(By.name("descriptionItems_s"));
				select.click();
				Thread.sleep(200); // Let the user actually see something!
				selectElements = findSelectElements(driverRef);
				i = this.controlIndices[5];
				selectElements.get(i).click();

				Thread.sleep(200); // Let the user actually see something!
				select = driverRef.findElement(By.name("bottomPrefix_dp")).findElement(By.name("prefixItems_s"));
				select.click();
				Thread.sleep(200); // Let the user actually see something!
				selectElements = findSelectElements(driverRef);
				i = this.controlIndices[6];
				selectElements.get(i).click();

				Thread.sleep(200); // Let the user actually see something!
				select = driverRef.findElement(By.name("bottomPrefix_dp")).findElement(By.name("descriptionItems_s"));
				select.click();
				Thread.sleep(200); // Let the user actually see something!
				selectElements = findSelectElements(driverRef);
				i = this.controlIndices[7];
				selectElements.get(i).click();

				Thread.sleep(1000);
				ele = driverRef.findElement(By.name("ok_btn")); // Find the Orientation Description button
				if(ele.isEnabled()) //Prevent failure if options are already selected.
				{
					ele.click();
				}
				else
				{
					ele = driverRef.findElements(By.name("cancel_btn")).get(1); //Get second instance, as the page has it's own cancel button.
					ele.click();
				}
			}
		}
	}
	
	
	//Constructor for IWV Type
	public static class IWVElement extends UIElements {
		
		/**
		 * IWV Element Constructor
		 * 
		 * @param drive is the Driver
		 * @param validator the validator for this UIElement. Enter null to avoid database comparison.
		 * @param textName name of the IWV element
		 * @param inputText The desired text that should be input into the text field.
		 * @param includeIWV Whether or not the checkbox should me marked true or false afterwards
		 */
		public IWVElement(WebDriver drive, ElementValidationInterface validator, String textName, String inputText, boolean includeIWV) {
			this.driverRef = drive;
			this.elm = textName;
			this.txtValue = inputText;
			this.validator = validator;
			this.bool = includeIWV;
			this.expectedValue = (this.bool ? "True" : "False") + ", " + inputText;
		}
		
		/*
		 * Marks the box as true and enters the value into the text field.
		 * If more values are under the IWV, run the respective IWV function for each element.
		 */
		public void runTestConfiguration() throws Exception {
			System.out.println("Working on IWVElement "+ this.elm);
			if(findCheckboxSelectedElement(driverRef.findElements(By.name(this.elm)).get(this.useNameInstance)) != null)
				if (!findCheckboxSelectedElement(driverRef.findElements(By.name(this.elm)).get(this.useNameInstance)).isSelected()) {
					findCheckboxClickElement(driverRef.findElements(By.name(this.elm)).get(this.useNameInstance)).click();
				}
			findTextFieldElement(driverRef.findElements(By.name(this.elm)).get(this.useNameInstance)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(100); // Let the user actually see something!
			findTextFieldElement(driverRef.findElements(By.name(this.elm)).get(this.useNameInstance)).sendKeys(this.txtValue);
			Thread.sleep(200);
			
			//includeIWV
			if(findCheckboxSelectedElement(driverRef.findElements(By.name(this.elm)).get(this.useNameInstance)) != null)
				if (!this.bool) {
					findCheckboxClickElement(driverRef.findElements(By.name(this.elm)).get(this.useNameInstance)).click();
				}
			
			Thread.sleep(200);
		}
	}
	
	
	//Constructor for include with value with selector element
	public static class IWVSElement extends UIElements {
		
		/**
		 * IWVS Element Constructor
		 * 
		 * @param drive is the Driver
		 * @param validator the validator for this UIElement. Enter null to avoid database comparison.
		 * @param textName name of the IWVS element
		 * @param selection The desired selection Option
		 */
		public IWVSElement(WebDriver drive, ElementValidationInterface validator, String textName, int selection, boolean includeIWV) {
			this.driverRef = drive;
			this.elm = textName;
			this.dropDownIndex = selection;
			this.validator = validator;
			this.bool = includeIWV;
			
			//Validation Mapping must be done within the validator in the case of Selections.
		}
		
		
		
		/*
		 * Select Lists are tested by having a specific element (by position) selected.
		 */
		public void runTestConfiguration() throws Exception {
			System.out.println("Working on IWVSElement "+ this.elm);
			if(findCheckboxSelectedElement(driverRef.findElements(By.name(this.elm)).get(this.useNameInstance)) != null)
				if (!findCheckboxSelectedElement(driverRef.findElements(By.name(this.elm)).get(this.useNameInstance)).isSelected()) {
					findCheckboxClickElement(driverRef.findElements(By.name(this.elm)).get(this.useNameInstance)).click();
				}
			
			WebElement select = driverRef.findElements(By.name(this.elm)).get(this.useNameInstance).findElement(By.className("v-select"));
			select.click();
			List<WebElement> selectElements = findSelectElements(this.driverRef);
			int i = this.dropDownIndex;
			
			Thread.sleep(200);
			
			selectElements.get(i).click();
			
			Thread.sleep(200);
			
			//includeIWV
			if(findCheckboxSelectedElement(driverRef.findElements(By.name(this.elm)).get(this.useNameInstance)) != null)
				if (!this.bool) {
					findCheckboxClickElement(driverRef.findElements(By.name(this.elm)).get(this.useNameInstance)).click();
				}
			
			Thread.sleep(200);
		}
	}
	
	
	//Constructor for Radio Group Type
	public static class RGElement extends UIElements {
		
		/**
		 * RGE Element Constructor
		 * 
		 * @param drive is the Driver
		 * @param validator the validator for this UIElement. Enter null to avoid database comparison.
		 * @param textName name of the RG element
		 * @param selection The desired selection Option
		 */
		public RGElement(WebDriver drive, ElementValidationInterface validator, String textName, int selection) {
			this.driverRef = drive;
			this.elm = textName;
			this.generalIndex = selection;
			this.validator = validator;
		}
		
		/*
		 * Selects the appropriate radio group item.
		 */
		public void runTestConfiguration() throws Exception {
			System.out.println("Working on RGElement "+ this.elm);
		   WebElement ele = this.driverRef.findElements(By.name(this.elm)).get(this.useNameInstance); // Find the reportingType RadioGroup
		   
		   if (ele.isEnabled()) // if it is enabled (which it should be because we clicked the edit button)
		   {
			   List<WebElement> radio = findRadioGroupClickElements(ele);
			   
			   Thread.sleep(100);
			   radio.get(this.generalIndex).click();
			   Thread.sleep(400);
		   }
		}
	}
	
	
	//Constructor for Text Type
	public static class TextElement extends UIElements {
		
		/**
		 * Text Field Element Constructor
		 * 
		 * @param drive is the Driver
		 * @param validator the validator for this UIElement. Enter null to avoid database comparison.
		 * @param textName name of the Text element
		 * @param inputText The desired text that should be input into the text field.
		 */
		public TextElement(WebDriver drive, ElementValidationInterface validator, String textName, String inputText) {
			this.driverRef = drive;
			this.elm = textName;
			this.txtValue = inputText;
			
			this.validator = validator;
			this.expectedValue = inputText;
		}
		
		/*
		 * Simply Enters the Text value
		 */
		public void runTestConfiguration() throws Exception {
			System.out.println("Working on TextElement "+ this.elm);
			findTextFieldElement(driverRef.findElements(By.name(this.elm)).get(this.useNameInstance)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(100); // Let the user actually see something!
			findTextFieldElement(driverRef.findElements(By.name(this.elm)).get(this.useNameInstance)).sendKeys(this.txtValue);
			Thread.sleep(200);
			//driverRef.findElements(By.name("")).get(this.useNameInstance).click(); - Click Off, avoids other bug
		}
	}
	
	
	//Constructor for Drag and Drop List Elements
	public static class DragListElement extends UIElements {
		
		/**
		 * Drag and Drop List Element Constructor
		 * 
		 * @param driver is the driver
		 * @param validator the validator for this UIElement. Enter null to avoid database comparison.
		 * @param listName The drag and drop list itself.
		 * @param list A list consisting of the drag-drop elements.
		 * @param separators An array of which selection the separators should be set to.
		 * @param spacingOptions An array of which selection the spacing Options should be set to.
		 * 
		 * If you would like to leave the separators and spacing options alone, set them to null.
		 * If the length of separators or spacingOptions exceeds the length of the drag-drop list, the extra values will be ignored.
		 * If the drag-drop list is longer than separators or spacingOptions, the extra drag-drop elements will not be affected.
		 */
		public DragListElement(WebDriver driver, ElementValidationInterface validator, String listName, List <String> list, int[] separators, int[] spacingOptions) {
			this.elm = listName;
			this.list = list;
			this.driverRef = driver;
			this.controlIndices = separators;
			this.secondaryControlIndices = spacingOptions;
			this.validator = validator;
			
			mapValidationStrings();
			this.expectedValue = this.validationStrings.toString().replace("[", "").replace("]", ""); //Removes the Array Brackets
		}
		
		/**
		 * Validation Mapping: Fills the validation Strings array with the corresponding selections.
		 * From the controlIndices provided.
		 * 
		 * If the options change, this map needs to be updated.
		 */
		
		private void mapValidationStrings() {
			this.validationStrings = new ArrayList<String>();
			
			List<String> listOrder = this.list;
			//These values need to be equal to the values from the database, as the descriptions in CSR do not match the database Values.
			String[] Separators = {"AT", "COLON", "COMMA", "DASH", "HASH", "SEMICOLON", "FORWARD_SLASH", "SPACE"};
			String[] SpacingOptions = {"BEFORE", "AFTER", "BEFORE_AND_AFTER", "NONE"};
			
			
			
			//Add the corresponding option to the validationStrings.
			//Adds in sets of three (Description, Separator, Spacing)
			for(int i = 0; i < list.size(); i++)
			{
				this.validationStrings.add(listOrder.get(i));
				//Leave null if no change was made
				if(this.controlIndices != null && i < this.controlIndices.length)
					this.validationStrings.add(Separators[this.controlIndices[i]]);
				else
					this.validationStrings.add(null);
				
				if(this.secondaryControlIndices != null && i <  this.secondaryControlIndices.length)
					this.validationStrings.add(SpacingOptions[this.secondaryControlIndices[i]]);
				else
					this.validationStrings.add(null);

			}
		}
		
		/*
		 * Drag and Drop Objects are tested by moving the screen to contain the entire drag-drop list.
		 * The positions are elements are then swapped accordingly.
		 */
		@Override
		public void runTestConfiguration() throws Exception {
			System.out.println("Working on DragListElement "+ this.elm);
			WebElement ele = driverRef.findElements(By.name(this.elm)).get(this.useNameInstance);
			
			JavascriptExecutor js = (JavascriptExecutor) this.driverRef;
			int innerHeight = Integer.parseInt(js.executeScript("return (window.innerHeight)").toString());
			int windowHeight = this.driverRef.manage().window().getSize().getHeight();
			int adjustedHeight = windowHeight - innerHeight - 25;
			
			Thread.sleep(50);
			
			List<WebElement> dragElements = ele.findElements(By.name("draggable_btn"));
			Boolean inOrder = false;
			List <String> compListTxt = getComponentsTxt(dragElements);
			jumpToElement(this.driverRef, dragElements.get(dragElements.size() - 1).findElement(By.name("draggable_icon"))); //Ensure that all are visible.
			
			Thread.sleep(100);
			
			Thread.sleep(200);
			
			
			//Order the List
			int loopCounter = 0; //If this exceeds 100, declare a loop.
			while (inOrder ==false) {
				
				int inOrderCount =0;
				int listSize =compListTxt.size();
				Thread.sleep(100);
				for (int i =0; i < listSize;i++) {
					//Loop Detection
					loopCounter++;
					if(loopCounter > 100)
					{
						throw new Exception("Loop Counter Excceded, Infinite Loop Detected. Try using a DragBoggleElement instead?");
					}
					
					String webItem = this.list.get(i);
					
					if (!compListTxt.get(i).equals(webItem)) {
						//inOrderCount =0;
						int compPosition = compListTxt.indexOf(webItem);
						dragAndDropElement(dragElements.get(compPosition).findElement(By.name("draggable_icon")),
								dragElements.get(i).findElement(By.name("draggable_icon")), 0, adjustedHeight);
						compListTxt = getComponentsTxt(dragElements);
					}else {
						compListTxt = getComponentsTxt(dragElements);
						inOrderCount++;
					}
				}
				if (inOrderCount== compListTxt.size())
					inOrder=true;	
			}
			
			//Update the list order
			dragElements = ele.findElements(By.name("draggable_btn"));
			
			//Set the Separators
			if(this.controlIndices != null)
			{
				for(int i = 0; i < dragElements.size() && i < this.controlIndices.length; i++)
				{
					WebElement select = dragElements.get(i).findElement(By.name("separator_s"));
					select.click();
					List<WebElement> selectElements = findSelectElements(this.driverRef);
					selectElements.get(this.controlIndices[i]).click();
					Thread.sleep(200);
				}
			}
			
			//Set the Spacing Options
			if(this.secondaryControlIndices != null)
			{
				for(int i = 0; i < dragElements.size() && i < this.secondaryControlIndices.length; i++)
				{
					WebElement select = dragElements.get(i).findElement(By.name("separatorSpacing_s"));
					select.click();
					List<WebElement> selectElements = findSelectElements(this.driverRef);
					selectElements.get(this.secondaryControlIndices[i]).click();
					Thread.sleep(200);
				}
			}
			
			Thread.sleep(200);
			
			
		}
		
	}
	
	
	//Constructor for Drag and Drop List Elements
	public static class DragBoggleElement extends UIElements {
		
		/**
		 * Drag and Drop List Element Constructor
		 * 
		 * @param driver is the driver
		 * @param validator the validator for this UIElement. Enter null to avoid database comparison.
		 * @param listName The drag and drop list itself.
		 * @param list A list consisting of the drag-drop elements.
		 * @param separators An array of which selection the separators should be set to.
		 * @param spacingOptions An array of which selection the spacing Options should be set to.
		 * 
		 * If you would like to leave the separators and spacing options alone, set them to null.
		 * If the length of separators or spacingOptions exceeds the length of the drag-drop list, the extra values will be ignored.
		 * If the drag-drop list is longer than separators or spacingOptions, the extra drag-drop elements will not be affected.
		 */
		public DragBoggleElement(WebDriver driver, ElementValidationInterface validator, String listName, int[] separators, int[] spacingOptions) {
			this.elm = listName;
			this.driverRef = driver;
			this.controlIndices = separators;
			this.secondaryControlIndices = spacingOptions;
			this.validator = validator;
			
			//Mapping is done in the process
		}
		
		/**
		 * Validation Mapping: Fills the validation Strings array with the corresponding selections.
		 * From the controlIndices provided.
		 * 
		 * If the options change, this map needs to be updated.
		 */
		
		private void mapValidationStrings() {
			this.validationStrings = new ArrayList<String>();
			
			List<String> listOrder = this.list;
			//These values need to be equal to the values from the database, as the descriptions in CSR do not match the database Values.
			String[] Separators = {"AT", "COLON", "COMMA", "DASH", "HASH", "SEMICOLON", "FORWARD_SLASH", "SPACE"};
			String[] SpacingOptions = {"BEFORE", "AFTER", "BEFORE_AND_AFTER", "NONE"};
			
			
			
			//Add the corresponding option to the validationStrings.
			//Adds in sets of three (Description, Separator, Spacing)
			for(int i = 0; i < list.size(); i++)
			{
				this.validationStrings.add(listOrder.get(i));
				//Leave null if no change was made
				if(this.controlIndices != null && i < this.controlIndices.length)
					this.validationStrings.add(Separators[this.controlIndices[i]]);
				else
					this.validationStrings.add(null);
				
				if(this.secondaryControlIndices != null && i <  this.secondaryControlIndices.length)
					this.validationStrings.add(SpacingOptions[this.secondaryControlIndices[i]]);
				else
					this.validationStrings.add(null);

			}
		}
		
		/*
		 * Drag and Drop Objects are tested by moving the screen to contain the entire drag-drop list.
		 * The positions are elements are then swapped accordingly.
		 */
		@Override
		public void runTestConfiguration() throws Exception {
			System.out.println("Working on DragListElement "+ this.elm);
			WebElement ele = driverRef.findElements(By.name(this.elm)).get(this.useNameInstance);
			
			JavascriptExecutor js = (JavascriptExecutor) this.driverRef;
			int innerHeight = Integer.parseInt(js.executeScript("return (window.innerHeight)").toString());
			int windowHeight = this.driverRef.manage().window().getSize().getHeight();
			int adjustedHeight = windowHeight - innerHeight - 25;
			
			Thread.sleep(50);
			
			List<WebElement> dragElements = ele.findElements(By.name("draggable_btn"));
			Boolean inOrder = false;
			List <String> compListTxt = getComponentsTxt(dragElements);
			
			//Determine what the expected results should become
			this.list = compListTxt;
			String temp = null;
			
			//indicate the mixture
			temp = this.list.get(3);
			this.list.set(3, this.list.get(0));
			this.list.set(0, temp);
			
			temp = this.list.get(2);
			this.list.set(2, this.list.get(0));
			this.list.set(0, temp);
			
			temp = this.list.get(1);
			this.list.set(1, this.list.get(0));
			this.list.set(0, temp);
			
			//Setup the mapping
			mapValidationStrings();
			this.expectedValue = this.validationStrings.toString().replace("[", "").replace("]", ""); //Removes the Array Brackets
			
			jumpToElement(this.driverRef, dragElements.get(dragElements.size() - 8).findElement(By.name("draggable_icon"))); //Ensure that all are visible.
			
			Thread.sleep(100);
			
			Thread.sleep(200);
			
			int loopCounter = 0;
			//Order the List
			while (inOrder ==false) {
				int inOrderCount =0;
				int listSize =compListTxt.size();
				Thread.sleep(100);
				for (int i =0; i < listSize;i++) {
					//Safety valve/Loop Detector
					loopCounter++;
					if(loopCounter > 100)
					{
						throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
					}
					
					
					String webItem = this.list.get(i);
					
					if (!compListTxt.get(i).equals(webItem)) {
						//inOrderCount =0;
						int compPosition = compListTxt.indexOf(webItem);
						dragAndDropElement(dragElements.get(compPosition).findElement(By.name("draggable_icon")),
								dragElements.get(i).findElement(By.name("draggable_icon")), 0, adjustedHeight);
						compListTxt = getComponentsTxt(dragElements);
					}else {
						compListTxt = getComponentsTxt(dragElements);
						inOrderCount++;
					}
				}
				if (inOrderCount== compListTxt.size())
					inOrder=true;	
			}
			
			//Update the list order
			dragElements = ele.findElements(By.name("draggable_btn"));
			
			//Set the Separators
			if(this.controlIndices != null)
			{
				for(int i = 0; i < dragElements.size() && i < this.controlIndices.length; i++)
				{
					WebElement select = dragElements.get(i).findElement(By.name("separator_s"));
					select.click();
					List<WebElement> selectElements = findSelectElements(this.driverRef);
					selectElements.get(this.controlIndices[i]).click();
					Thread.sleep(200);
					
					select = dragElements.get(i).findElement(By.name("separatorSpacing_s"));
					select.click();
					selectElements = findSelectElements(this.driverRef);
					selectElements.get(this.secondaryControlIndices[i]).click();
					Thread.sleep(200);
				}
			}
			
			Thread.sleep(200);
			
			
		}
		
	}
	

	//Constructor for Stationing Elements with a Text Field
	public static class StationingSelectElement extends UIElements {
		
		/**
		 * Stationing Elements with a Text Field Constructor
		 * 
		 * Inputting an invalid entry into the lists will usually result in an infinite loop.
		 * 
		 * @param driver is the driver
		 * @param validator the validator for this UIElement. Enter null to avoid database comparison.
		 * @param staName The Stationing Element Container
		 * @param availableList A list of what the available group should contain, in order.
		 * @param selectedList A list of what the available group should contain, in order.
		 * @param unitSel This unit type Metric/Imperial/Custom. Custom (2) Uses the Text Input Field.
		 * @param customInput The string input into the custom unit field. Only used if unitSel = 2.
		 * @param include Whether or not to leave the checkbox marked
		 */
		public StationingSelectElement(WebDriver driver, ElementValidationInterface validator, String staName,  List <String> availableList,  List <String> selectedList, int unitSel, String customInput, boolean include) {
			this.elm = staName;
			this.txtValue = customInput;
			this.driverRef = driver;
			this.generalIndex = unitSel;
			this.list = availableList;
			this.secondaryList = selectedList;
			this.validator = validator;
			this.bool = include;
			
			mapValidationStrings();
		}
		
		/**
		 * Validation Mapping: Fills the validation Strings array with the corresponding selections.
		 * From the controlIndices provided.
		 * 
		 * Maps in the Order of: include, Format, Custom Format Label, Selected Table
		 * 
		 * Validators must be adaptive to the selected Table size.
		 * 
		 * If the options change, this map needs to be updated.
		 */
		
		private void mapValidationStrings() {
			this.validationStrings = new ArrayList<String>();
			
			List<String> listOrder = this.list;
			//These values need to be equal to the values from the database, as the descriptions in CSR do not match the database Values.
			String[] formatStandards = {"METRIC", "IMPERIAL", "CUSTOM"};
			
			validationStrings.add(this.bool ? "True" : "False");
			validationStrings.add(formatStandards[this.generalIndex]);
			validationStrings.add(this.txtValue);
			validationStrings.addAll(this.secondaryList);
			
			this.expectedValue = validationStrings.get(0) + ", " + validationStrings.get(1) 
									+ ", " + validationStrings.get(2);
			for(int i = 0; i < this.secondaryList.size(); i ++)
				this.expectedValue += ", " + validationStrings.get(3 + i);
		}
		
		@Override
		public void runTestConfiguration() throws Exception {
			System.out.println("Working on StationingSelectElement "+ this.elm);
			WebElement ele = this.driverRef.findElements(By.name(this.elm)).get(this.useNameInstance); // Find Mile Posting
			if (ele.isEnabled()) // if it is enabled (which it should be because we clicked the edit button)
			{
				if (!findCheckboxSelectedElement(ele).isSelected()) {
					findCheckboxClickElement(ele).click();
				}
				
				Thread.sleep(200); // Let the user actually see something!
				WebElement select = this.driverRef.findElements(By.name("formatStandard_s")).get(this.useNameInstance); //Get Markers Near Valves
				select.click();
				Thread.sleep(200); // Let the user actually see something!
				List<WebElement> selectElements = findSelectElements(this.driverRef);
				int i = this.generalIndex;
				selectElements.get(i).click();
				
				if(this.generalIndex == 2)
				{
					select = ele.findElement(By.name("propertyWithUpdates_tf"));  
					Thread.sleep(200);
					select = select.findElement(By.name("v-text-field"));
					select.sendKeys(Keys.chord(Keys.CONTROL, "a"));
					Thread.sleep(200); // Let the user actually see something!
					select.sendKeys(this.txtValue);
					Thread.sleep(200); // Let the user actually see something!
				}
				
				//Data Source
				//Open the data Source Field
		        ele.findElement(By.className("v-btn")).click();
				
				//find the main component separator container - v-dialog--active ensures that it grabs the active pane
		        ele = this.driverRef.findElement(By.className("v-dialog--active")).findElement(By.name("propertyWithUpdates_ol"));
		        
				Thread.sleep(200); // Let the user actually see something!
				
				//Get Elements
				WebElement available = ele.findElement(By.name("excluded_dl"));
				WebElement selected = ele.findElement(By.name("include_ol"));
				List<WebElement> availableElements = available.findElements(By.name("draggable_btn"));
				List<WebElement> selectedElements = selected.findElements(By.name("draggable_btn"));
				
				//focus moves to the component separator 
				if(availableElements.isEmpty())
				{
					jumpToElement(this.driverRef, ele.findElements(By.name("include_ol")).get(0)); //Ensure it is visible
				}
				else
				{
					jumpToElement(this.driverRef, ele.findElements(By.name("excluded_dl")).get(0)); //Ensure it is visible
				}
				
				//adjust for screen scrolling and resolution
				JavascriptExecutor js = (JavascriptExecutor) this.driverRef;
				int innerHeight = Integer.parseInt(js.executeScript("return (window.innerHeight)").toString());
				int windowHeight = this.driverRef.manage().window().getSize().getHeight();
				int adjustedHeight = windowHeight - innerHeight - 5;
				
				Thread.sleep(200);
				
				
				int loopCounter = 0;
				//Move all the items into the available Items list
				while(selectedElements.size() > 0)
				{
					//Safety Valve, Loop Detector
					loopCounter++;
					if(loopCounter > 100)
					{
						throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
					}
					
					dragAndDropElement(selectedElements.get(0).findElement(By.className("v-icon")),
							availableElements.get(0).findElement(By.className("v-icon")), 0, adjustedHeight);
					
					Thread.sleep(200);
					availableElements = available.findElements(By.name("draggable_btn"));
					selectedElements = selected.findElements(By.name("draggable_btn"));
				}
				
				
				//Filter out the Available and Selected Lists
				int sortCounter = 0;
				while(sortCounter < availableElements.size())
				{
					//Safety Valve, Loop Detector
					loopCounter++;
					if(loopCounter > 100)
					{
						throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
					}
					
					Thread.sleep(200);
					
					//If the current object is not meant to be in this list, move it.
					List <String> listTxt = getDragIconTxt(availableElements);
					
					if(this.list.contains((listTxt.get(sortCounter))))
					{
						sortCounter++;
					}
					else
					{
						//Safety Valve, Loop Detector
						loopCounter++;
						if(loopCounter > 100)
						{
							throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
						}
						//Move to Selected List if it doesn't belong here.
						if(selectedElements.size() == 0) //Note that dropping an item into a different list requires a different method.
							dragAndDropElement(availableElements.get(sortCounter).findElement(By.className("v-icon")),
									selected.findElement(By.className("subtitle-1")), 0, adjustedHeight);
						else
							dragAndDropElement(availableElements.get(sortCounter).findElement(By.className("v-icon")),
									selectedElements.get(0).findElement(By.className("v-icon")), 0, adjustedHeight);
					}
					
					
					//Needs to be updated when lists are re-arranged.
					availableElements = available.findElements(By.name("draggable_btn"));
					selectedElements = selected.findElements(By.name("draggable_btn"));
				}
				
				
				//Order Available List
				sortCounter = 0;
				while(sortCounter < availableElements.size())
				{
					//Safety Valve, Loop Detector
					loopCounter++;
					if(loopCounter > 100)
					{
						throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
					}
					Thread.sleep(200);
					
					//If the current object is not meant to be in this list, move it.
					List <String> listTxt = getDragIconTxt(availableElements);
					
					if(this.list.get(sortCounter).equals((listTxt.get(sortCounter))))
					{
						sortCounter++;
					}
					
					else
					{
						//Safety Valve, Loop Detector
						loopCounter++;
						if(loopCounter > 100)
						{
							throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
						}
						
						dragAndDropElement(availableElements.get(sortCounter).findElement(By.className("v-icon")),
								availableElements.get(availableElements.size() - 1).findElement(By.className("v-icon")), 0, adjustedHeight);
					}
					
					//Needs to be updated when lists are re-arranged.
					availableElements = available.findElements(By.name("draggable_btn"));
					selectedElements = selected.findElements(By.name("draggable_btn"));
				}
				
				
				//Order selected List
				sortCounter = 0;
				while(sortCounter < selectedElements.size())
				{
					//Safety Valve, Loop Detector
					loopCounter++;
					if(loopCounter > 100)
					{
						throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
					}
					
					Thread.sleep(200);
					
					//If the current object is not meant to be in this list, move it.
					List <String> listTxt = getDragIconTxt(selectedElements);
					
					if(this.secondaryList.get(sortCounter).equals((listTxt.get(sortCounter))))
					{
						sortCounter++;
					}
					
					else
					{
						//Safety Valve, Loop Detector
						loopCounter++;
						if(loopCounter > 100)
						{
							throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
						}
						
						dragAndDropElement(selectedElements.get(sortCounter).findElement(By.className("v-icon")),
								selectedElements.get(selectedElements.size() - 1).findElement(By.className("v-icon")), 0, adjustedHeight);
					}
					
					//Needs to be updated when lists are re-arranged.
					availableElements = available.findElements(By.name("draggable_btn"));
					selectedElements = selected.findElements(By.name("draggable_btn"));
				}
				
				Thread.sleep(500);
				
				//close
				WebElement applyButton = this.driverRef.findElement(By.className("v-dialog--active")).findElement(By.name("applyChanges_bt"));
				if (applyButton.isEnabled())
					applyButton.click();
				
				Thread.sleep(200);
				
				
				
				if (!this.bool) {
					ele = this.driverRef.findElements(By.name(this.elm)).get(this.useNameInstance); // Find Mile Posting
					findCheckboxClickElement(ele).click();
				}
				
			}
		}
		
	}
	
	
	//Constructor for Data Source Elements and Mile Posting Elements
	public static class SimpleDataSourceElement extends UIElements {
		
		/**
		 * Data Source Elements, optionally with text fields
		 * 
		 * @param driver is the driver
		 * @param validator the validator for this UIElement. Enter null to avoid database comparison.
		 * @param staName The Data Source Element Container
		 * @param availableList A list of what the available group should contain, in order.
		 * @param selectedList A list of what the available group should contain, in order.
		 * @param textInput The text to be entered. Leave blank if no such text field exists.
		 * @param textInsideConfigure Whether or not the textbox is inside of the Formatting Information section. Note that if true
		 * it will also change the searched for name of the dialog window.
		 * @param noCB Unnamed containers may need to have the checkbox activated by another CBElement. If so, mark true.
		 * @param include Whether or not to leave the checkbox validated, if it has one. The validator should handle this, whether or not the element actually toggled its own enabler.
		 */
		public SimpleDataSourceElement(WebDriver driver, ElementValidationInterface validator, String staName,  List <String> availableList,  List <String> selectedList, String textInput, boolean textInsideConfigure, boolean noCB, boolean include) {
			this.elm = staName;
			this.driverRef = driver;
			this.list = availableList;
			this.secondaryList = selectedList;
			this.txtValue = textInput;
			this.bool = textInsideConfigure;
			this.secondaryFlag = noCB;
			this.validator = validator;
			this.tertiaryFlag = include;
			
			
			this.expectedValue = (this.tertiaryFlag ? "True" : "False") + ", " + this.txtValue + ", " + this.validationStrings;
			
			
			this.validationStrings = new ArrayList<String>();
			for(int i = 0; i < this.secondaryList.size(); i++)
			{
				this.validationStrings.add(this.secondaryList.get(i));
			}
			
		}
		
		/*
		 * Drag and Drop Objects are tested by moving the screen to contain the entire drag-drop list.
		 * The positions are elements are then swapped accordingly.
		 */
		@Override
		public void runTestConfiguration() throws Exception {
			System.out.println("Working on SimpleDataSourceElement "+ this.elm);
			WebElement ele = this.driverRef.findElements(By.name(this.elm)).get(this.useNameInstance); // Find Mile Posting
			if (ele.isEnabled()) // if it is enabled (which it should be because we clicked the edit button)
			{
				if (!this.secondaryFlag && !findCheckboxSelectedElement(ele).isSelected()) {
					findCheckboxClickElement(ele).click();
				}

				
				if(this.txtValue != null && this.bool == false)
				{
					WebElement select = ele.findElement(By.name("customFormat_tf"));
					Thread.sleep(200);
					select = select.findElement(By.name("v-text-field"));
					select.sendKeys(Keys.chord(Keys.CONTROL, "a"));
					Thread.sleep(200); // Let the user actually see something!
					select.sendKeys(this.txtValue);
					Thread.sleep(200); // Let the user actually see something!
				}
				
				
				//Data Source
				//Open the data Source Field
				if(this.secondaryFlag)
				{
					ele.findElement(By.xpath("./..")).findElement(By.className("v-btn")).click();					
				}
				else
				{
					ele.findElement(By.className("v-btn")).click();	
				}
				
				//find the main component separator container - v-dialog--active ensures that it grabs the active pane
		        //this.bool will hold which type of window it is.
		        ele = this.driverRef.findElement(By.className("v-dialog--active")).findElement(By.name(this.bool ?  "componentsOrder_ol" : "propertyWithUpdates_ol"));
				
				//find the main component separator container 
				Thread.sleep(200); // Let the user actually see something!
				
				//Get Elements
				WebElement available = ele.findElement(By.name("excluded_dl"));
				WebElement selected = ele.findElement(By.name("include_ol"));
				List<WebElement> availableElements = available.findElements(By.name("draggable_btn"));
				List<WebElement> selectedElements = selected.findElements(By.name("draggable_btn"));
				
				//focus moves to the component separator 
				if(availableElements.isEmpty())
				{
					jumpToElement(this.driverRef, ele.findElements(By.name("include_ol")).get(0)); //Ensure it is visible
				}
				else
				{
					jumpToElement(this.driverRef, ele.findElements(By.name("excluded_dl")).get(0)); //Ensure it is visible
				}
				
				//adjust for screen scrolling and resolution
				JavascriptExecutor js = (JavascriptExecutor) this.driverRef;
				int innerHeight = Integer.parseInt(js.executeScript("return (window.innerHeight)").toString());
				int windowHeight = this.driverRef.manage().window().getSize().getHeight();
				int adjustedHeight = windowHeight - innerHeight - 5;
				
				Thread.sleep(200);
								
				int loopCounter = 0;
				//Move all the items into the available Items list
				while(selectedElements.size() > 0)
				{
					//Safety Valve, Loop Detector
					loopCounter++;
					if(loopCounter > 100)
					{
						throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
					}
					
					dragAndDropElement(selectedElements.get(0).findElement(By.className("v-icon")),
							availableElements.get(0).findElement(By.className("v-icon")), 0, adjustedHeight);
					
					Thread.sleep(200);
					availableElements = available.findElements(By.name("draggable_btn"));
					selectedElements = selected.findElements(By.name("draggable_btn"));
				}
				
				
				//Filter out the Available and Selected Lists
				int sortCounter = 0;
				while(sortCounter < availableElements.size())
				{
					//Safety Valve, Loop Detector
					loopCounter++;
					if(loopCounter > 100)
					{
						throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
					}
					Thread.sleep(200);
					
					//If the current object is not meant to be in this list, move it.
					List <String> listTxt = getDragIconTxt(availableElements);
					
					if(this.list.contains((listTxt.get(sortCounter))))
					{
						sortCounter++;
					}
					else
					{
						//Safety Valve, Loop Detector
						loopCounter++;
						if(loopCounter > 100)
						{
							throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
						}
						
						//Move to Selected List if it doesn't belong here.
						if(selectedElements.size() == 0) //Note that dropping an item into a different list requires a different method.
							dragAndDropElement(availableElements.get(sortCounter).findElement(By.className("v-icon")),
									selected.findElement(By.className("subtitle-1")), 0, adjustedHeight);
						else
							dragAndDropElement(availableElements.get(sortCounter).findElement(By.className("v-icon")),
									selectedElements.get(0).findElement(By.className("v-icon")), 0, adjustedHeight);
					}
					
					
					//Needs to be updated when lists are re-arranged.
					availableElements = available.findElements(By.name("draggable_btn"));
					selectedElements = selected.findElements(By.name("draggable_btn"));
				}
				
				
				//Order Available List
				sortCounter = 0;
				while(sortCounter < availableElements.size())
				{
					//Safety Valve, Loop Detector
					loopCounter++;
					if(loopCounter > 100)
					{
						throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
					}
					Thread.sleep(200);
					
					//If the current object is not meant to be in this list, move it.
					List <String> listTxt = getDragIconTxt(availableElements);
					
					if(this.list.get(sortCounter).equals((listTxt.get(sortCounter))))
					{
						sortCounter++;
					}
					
					else
					{
						//Safety Valve, Loop Detector
						loopCounter++;
						if(loopCounter > 100)
						{
							throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
						}
						
						dragAndDropElement(availableElements.get(sortCounter).findElement(By.className("v-icon")),
								availableElements.get(availableElements.size() - 1).findElement(By.className("v-icon")), 0, adjustedHeight);
					}
					
					//Needs to be updated when lists are re-arranged.
					availableElements = available.findElements(By.name("draggable_btn"));
					selectedElements = selected.findElements(By.name("draggable_btn"));
				}
				
				
				//Order selected List
				sortCounter = 0;
				while(sortCounter < selectedElements.size())
				{
					//Safety Valve, Loop Detector
					loopCounter++;
					if(loopCounter > 100)
					{
						throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
					}
					
					Thread.sleep(200);
					
					//If the current object is not meant to be in this list, move it.
					List <String> listTxt = getDragIconTxt(selectedElements);
					
					if(this.secondaryList.get(sortCounter).equals((listTxt.get(sortCounter))))
					{
						sortCounter++;
					}
					
					else
					{
						//Safety Valve, Loop Detector
						loopCounter++;
						if(loopCounter > 100)
						{
							throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
						}
						
						dragAndDropElement(selectedElements.get(sortCounter).findElement(By.className("v-icon")),
								selectedElements.get(selectedElements.size() - 1).findElement(By.className("v-icon")), 0, adjustedHeight);
					}
					
					//Needs to be updated when lists are re-arranged.
					availableElements = available.findElements(By.name("draggable_btn"));
					selectedElements = selected.findElements(By.name("draggable_btn"));
				}
				
				Thread.sleep(500);
				
				if(this.txtValue != null && this.bool == true)
				{
					WebElement select = this.driverRef.findElement(By.className("v-dialog--active")).findElement(By.name("digRepairFormat_tf"));
					Thread.sleep(200);
					select = select.findElement(By.name("v-text-field"));
					select.sendKeys(Keys.chord(Keys.CONTROL, "a"));
					Thread.sleep(200); // Let the user actually see something!
					select.sendKeys(this.txtValue);
					Thread.sleep(200); // Let the user actually see something!
				}
				
				//close
				WebElement applyButton;
				if(this.bool)
					applyButton = this.driverRef.findElement(By.className("v-dialog--active")).findElement(By.className("v-card__actions")).findElement(By.className("v-btn"));
				else
					applyButton = this.driverRef.findElement(By.className("v-dialog--active")).findElement(By.name("applyChanges_bt"));
				
				if (applyButton.isEnabled())
					applyButton.click();
				
				Thread.sleep(200);
				
				ele = this.driverRef.findElements(By.name(this.elm)).get(this.useNameInstance);
				
				if (!this.secondaryFlag && !this.tertiaryFlag) {
					findCheckboxClickElement(ele).click();
				}
			}
		}
		
	}
	
	
	//Constructor for Data Source Elements and Mile Posting Elements
	public static class DataSourceElement extends UIElements {
			
			/**
			 * Data Source Elements in which there is no checkbox or text field.
			 * 
			 * @param driver is the driver
			 * @param validator the validator for this UIElement. Enter null to avoid database comparison.
			 * @param buttonName The DataSource Button
			 * @param availableList A list of what the available group should contain, in order.
			 * @param selectedList A list of what the available group should contain, in order.
			 */
			public DataSourceElement(WebDriver driver, ElementValidationInterface validator, String buttonName,  List <String> availableList,  List <String> selectedList) {
				this.elm = buttonName;
				this.driverRef = driver;
				this.list = availableList;
				this.secondaryList = selectedList;
				this.validator = validator;
			}
			
			/*
			 * Drag and Drop Objects are tested by moving the screen to contain the entire drag-drop list.
			 * The positions are elements are then swapped accordingly.
			 */
			@Override
			public void runTestConfiguration() throws Exception {
				System.out.println("Working on SimpleDataSourceElement "+ this.elm);
				WebElement ele = this.driverRef.findElements(By.name(this.elm)).get(this.useNameInstance); // Find Mile Posting
				if (ele.isEnabled()) // if it is enabled (which it should be because we clicked the edit button)
				{
					
					//Data Source
					//Open the data Source Field
					//Find parent element of cb then click the button inside, as the button is not a child of the named portion of the element.
					ele = this.driverRef.findElements(By.name(this.elm)).get(this.useNameInstance).findElement(By.xpath("./..")).findElement(By.xpath("./.."));
					
			        ele.findElement(By.className("v-btn")).click();
					
					//find the main component separator container - v-dialog--active ensures that it grabs the active pane
			        //this.bool will hold which type of window it is.
			        ele = this.driverRef.findElement(By.className("v-dialog--active")).findElement(By.name(this.bool ?  "componentsOrder_ol" : "propertyWithUpdates_ol"));
					
					//find the main component separator container 
					Thread.sleep(200); // Let the user actually see something!
					
					//Get Elements
					WebElement available = ele.findElement(By.name("excluded_dl"));
					WebElement selected = ele.findElement(By.name("include_ol"));
					List<WebElement> availableElements = available.findElements(By.name("draggable_btn"));
					List<WebElement> selectedElements = selected.findElements(By.name("draggable_btn"));
					
					//focus moves to the component separator 
					if(availableElements.isEmpty())
					{
						jumpToElement(this.driverRef, ele.findElements(By.name("include_ol")).get(0)); //Ensure it is visible
					}
					else
					{
						jumpToElement(this.driverRef, ele.findElements(By.name("excluded_dl")).get(0)); //Ensure it is visible
					}
					
					//adjust for screen scrolling and resolution
					JavascriptExecutor js = (JavascriptExecutor) this.driverRef;
					int innerHeight = Integer.parseInt(js.executeScript("return (window.innerHeight)").toString());
					int windowHeight = this.driverRef.manage().window().getSize().getHeight();
					int adjustedHeight = windowHeight - innerHeight - 5;
					
					Thread.sleep(200);
					
					int loopCounter = 0;
					//Move all the items into the available Items list
					while(selectedElements.size() > 0)
					{
						//Safety Valve, Loop Detector
						loopCounter++;
						if(loopCounter > 100)
						{
							throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
						}
						
						dragAndDropElement(selectedElements.get(0).findElement(By.className("v-icon")),
								availableElements.get(0).findElement(By.className("v-icon")), 0, adjustedHeight);
						
						Thread.sleep(200);
						availableElements = available.findElements(By.name("draggable_btn"));
						selectedElements = selected.findElements(By.name("draggable_btn"));
					}
					
					
					//Filter out the Available and Selected Lists
					int sortCounter = 0;
					while(sortCounter < availableElements.size())
					{
						//Safety Valve, Loop Detector
						loopCounter++;
						if(loopCounter > 100)
						{
							throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
						}
						
						Thread.sleep(200);
						
						//If the current object is not meant to be in this list, move it.
						List <String> listTxt = getDragIconTxt(availableElements);
						
						if(this.list.contains((listTxt.get(sortCounter))))
						{
							sortCounter++;
						}
						else
						{
							//Safety Valve, Loop Detector
							loopCounter++;
							if(loopCounter > 100)
							{
								throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
							}
							
							//Move to Selected List if it doesn't belong here.
							if(selectedElements.size() == 0) //Note that dropping an item into a different list requires a different method.
								dragAndDropElement(availableElements.get(sortCounter).findElement(By.className("v-icon")),
										selected.findElement(By.className("subtitle-1")), 0, adjustedHeight);
							else
								dragAndDropElement(availableElements.get(sortCounter).findElement(By.className("v-icon")),
										selectedElements.get(0).findElement(By.className("v-icon")), 0, adjustedHeight);
						}
						
						
						//Needs to be updated when lists are re-arranged.
						availableElements = available.findElements(By.name("draggable_btn"));
						selectedElements = selected.findElements(By.name("draggable_btn"));
					}
					
					
					//Order Available List
					sortCounter = 0;
					while(sortCounter < availableElements.size())
					{
						//Safety Valve, Loop Detector
						loopCounter++;
						if(loopCounter > 100)
						{
							throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
						}
						
						Thread.sleep(200);
						
						//If the current object is not meant to be in this list, move it.
						List <String> listTxt = getDragIconTxt(availableElements);
						
						if(this.list.get(sortCounter).equals((listTxt.get(sortCounter))))
						{
							sortCounter++;
						}
						
						else
						{
							//Safety Valve, Loop Detector
							loopCounter++;
							if(loopCounter > 100)
							{
								throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
							}
							
							dragAndDropElement(availableElements.get(sortCounter).findElement(By.className("v-icon")),
									availableElements.get(availableElements.size() - 1).findElement(By.className("v-icon")), 0, adjustedHeight);
						}
						
						//Needs to be updated when lists are re-arranged.
						availableElements = available.findElements(By.name("draggable_btn"));
						selectedElements = selected.findElements(By.name("draggable_btn"));
					}
					
					
					//Order selected List
					sortCounter = 0;
					while(sortCounter < selectedElements.size())
					{
						//Safety Valve, Loop Detector
						loopCounter++;
						if(loopCounter > 100)
						{
							throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
						}
						
						Thread.sleep(200);
						
						//If the current object is not meant to be in this list, move it.
						List <String> listTxt = getDragIconTxt(selectedElements);
						
						if(this.secondaryList.get(sortCounter).equals((listTxt.get(sortCounter))))
						{
							sortCounter++;
						}
						
						else
						{
							//Safety Valve, Loop Detector
							loopCounter++;
							if(loopCounter > 100)
							{
								throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
							}
							
							dragAndDropElement(selectedElements.get(sortCounter).findElement(By.className("v-icon")),
									selectedElements.get(selectedElements.size() - 1).findElement(By.className("v-icon")), 0, adjustedHeight);
						}
						
						//Needs to be updated when lists are re-arranged.
						availableElements = available.findElements(By.name("draggable_btn"));
						selectedElements = selected.findElements(By.name("draggable_btn"));
					}
					
					Thread.sleep(500);
					
					if(this.txtValue != null && this.bool == true)
					{
						WebElement select = this.driverRef.findElement(By.className("v-dialog--active")).findElement(By.name("propertyWithUpdates_tf"));
						Thread.sleep(200);
						select = select.findElement(By.name("v-text-field"));
						select.sendKeys(Keys.chord(Keys.CONTROL, "a"));
						Thread.sleep(200); // Let the user actually see something!
						select.sendKeys(this.txtValue);
						Thread.sleep(200); // Let the user actually see something!
					}
					
					//close
					WebElement applyButton;
					if(this.bool)
						applyButton = this.driverRef.findElement(By.className("v-dialog--active")).findElement(By.className("v-card__actions")).findElement(By.className("v-btn"));
					else
						applyButton = this.driverRef.findElement(By.className("v-dialog--active")).findElement(By.name("applyChanges_bt"));
					
					if (applyButton.isEnabled())
						applyButton.click();
				}
			}
			
		}
	

	//Constructor for Dig Formatting Elements
	public static class DigFormattingElement extends UIElements {
		
		/**
		 * Dig Formatting Elements with a Text Field Constructor
		 * As this class isn't always in a container with its checkbox, only the cb is used and the parent is grabbed.
		 * 
		 * @param driver is the driver
		 * @param validator the validator for this UIElement. Enter null to avoid database comparison.
		 * @param cbName The name of the Checkbox Element
		 * @param availableList A list of what the available group should contain, in order.
		 * @param selectedList A list of what the available group should contain, in order.
		 * @param digFormat The value input into the digFormat Field
		 */
		public DigFormattingElement(WebDriver driver, ElementValidationInterface validator, String cbName, List <String> availableList,  List <String> selectedList, String digFormat) {
			this.elm = cbName;
			this.txtValue = digFormat;
			this.driverRef = driver;
			this.list = availableList;
			this.secondaryList = selectedList;
			this.validator = validator;
		}
		
		/*
		 * Drag and Drop Objects are tested by moving the screen to contain the entire drag-drop list.
		 * The positions are elements are then swapped accordingly.
		 */
		@Override
		public void runTestConfiguration() throws Exception {
			System.out.println("Working on DigFormattingElement "+ this.elm);
			WebElement cbele = this.driverRef.findElements(By.name(this.elm)).get(this.useNameInstance);
			if (cbele.isEnabled()) // if it is enabled (which it should be because we clicked the edit button)
			{
				if (!findCheckboxSelectedElement(cbele).isSelected()) {
					findCheckboxClickElement(cbele).click();
				}
				
				Thread.sleep(200);
				
				//Data Source
				//Open the data Source Field
				//Find parent element of cb
				WebElement ele = this.driverRef.findElements(By.name(this.elm)).get(this.useNameInstance).findElement(By.xpath("./..")).findElement(By.xpath("./.."));
				ele = ele.findElement(By.className("v-btn")); //Find Configure Button
				ele.click();
				
				//find the main component separator container - v-dialog--active ensures that it grabs the active pane
		        ele = this.driverRef.findElement(By.className("v-dialog--active")).findElement(By.name("componentsOrder_ol"));
				
				//find the main component separator container 
				Thread.sleep(200); // Let the user actually see something!
				
				//Get Elements
				WebElement available = ele.findElement(By.name("excluded_dl"));
				WebElement selected = ele.findElement(By.name("include_ol"));
				List<WebElement> availableElements = available.findElements(By.name("draggable_btn"));
				List<WebElement> selectedElements = selected.findElements(By.name("draggable_btn"));
				
				//focus moves to the component separator 
				if(availableElements.isEmpty())
				{
					jumpToElement(this.driverRef, ele.findElements(By.name("include_ol")).get(0)); //Ensure it is visible
				}
				else
				{
					jumpToElement(this.driverRef, ele.findElements(By.name("excluded_dl")).get(0)); //Ensure it is visible
				}
				
				//adjust for screen scrolling and resolution
				JavascriptExecutor js = (JavascriptExecutor) this.driverRef;
				int innerHeight = Integer.parseInt(js.executeScript("return (window.innerHeight)").toString());
				int windowHeight = this.driverRef.manage().window().getSize().getHeight();
				int adjustedHeight = windowHeight - innerHeight - 5;
				
				Thread.sleep(200);
				
				int loopCounter = 0;
				//Move all the items into the available Items list
				while(selectedElements.size() > 0)
				{
					//Safety Valve, Loop Detector
					loopCounter++;
					if(loopCounter > 100)
					{
						throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
					}
					
					dragAndDropElement(selectedElements.get(0).findElement(By.className("v-icon")),
							availableElements.get(0).findElement(By.className("v-icon")), 0, adjustedHeight);
					
					Thread.sleep(200);
					availableElements = available.findElements(By.name("draggable_btn"));
					selectedElements = selected.findElements(By.name("draggable_btn"));
				}
				
				
				//Filter out the Available and Selected Lists
				int sortCounter = 0;
				while(sortCounter < availableElements.size())
				{
					//Safety Valve, Loop Detector
					loopCounter++;
					if(loopCounter > 100)
					{
						throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
					}
					
					Thread.sleep(200);
					
					//If the current object is not meant to be in this list, move it.
					List <String> listTxt = getDragIconTxt(availableElements);
					
					if(this.list.contains((listTxt.get(sortCounter))))
					{
						sortCounter++;
					}
					else
					{
						//Safety Valve, Loop Detector
						loopCounter++;
						if(loopCounter > 100)
						{
							throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
						}
						
						//Move to Selected List if it doesn't belong here.
						if(selectedElements.size() == 0) //Note that dropping an item into a different list requires a different method.
							dragAndDropElement(availableElements.get(sortCounter).findElement(By.className("v-icon")),
									selected.findElement(By.className("subtitle-1")), 0, adjustedHeight);
						else
							dragAndDropElement(availableElements.get(sortCounter).findElement(By.className("v-icon")),
									selectedElements.get(0).findElement(By.className("v-icon")), 0, adjustedHeight);
					}
					
					
					//Needs to be updated when lists are re-arranged.
					availableElements = available.findElements(By.name("draggable_btn"));
					selectedElements = selected.findElements(By.name("draggable_btn"));
				}
				
				
				//Order Available List
				sortCounter = 0;
				while(sortCounter < availableElements.size())
				{
					//Safety Valve, Loop Detector
					loopCounter++;
					if(loopCounter > 100)
					{
						throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
					}
					
					Thread.sleep(200);
					
					//If the current object is not meant to be in this list, move it.
					List <String> listTxt = getDragIconTxt(availableElements);
					
					if(this.list.get(sortCounter).equals((listTxt.get(sortCounter))))
					{
						sortCounter++;
					}
					
					else
					{
						//Safety Valve, Loop Detector
						loopCounter++;
						if(loopCounter > 100)
						{
							throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
						}
						
						dragAndDropElement(availableElements.get(sortCounter).findElement(By.className("v-icon")),
								availableElements.get(availableElements.size() - 1).findElement(By.className("v-icon")), 0, adjustedHeight);
					}
					
					//Needs to be updated when lists are re-arranged.
					availableElements = available.findElements(By.name("draggable_btn"));
					selectedElements = selected.findElements(By.name("draggable_btn"));
				}
				
				
				//Order selected List
				sortCounter = 0;
				while(sortCounter < selectedElements.size())
				{
					//Safety Valve, Loop Detector
					loopCounter++;
					if(loopCounter > 100)
					{
						throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
					}
					
					Thread.sleep(200);
					
					//If the current object is not meant to be in this list, move it.
					List <String> listTxt = getDragIconTxt(selectedElements);
					
					if(this.secondaryList.get(sortCounter).equals((listTxt.get(sortCounter))))
					{
						sortCounter++;
					}
					
					else
					{
						//Safety Valve, Loop Detector
						loopCounter++;
						if(loopCounter > 100)
						{
							throw new Exception("Loop Counter Excceded, Infinite Loop Detected.");
						}
						
						dragAndDropElement(selectedElements.get(sortCounter).findElement(By.className("v-icon")),
								selectedElements.get(selectedElements.size() - 1).findElement(By.className("v-icon")), 0, adjustedHeight);
					}
					
					//Needs to be updated when lists are re-arranged.
					availableElements = available.findElements(By.name("draggable_btn"));
					selectedElements = selected.findElements(By.name("draggable_btn"));
				}
				
				Thread.sleep(500);
				
				WebElement tempEle = this.driverRef.findElement(By.className("v-dialog--active")).findElement(By.name("propertyWithUpdates_tf"));

				if (tempEle.isEnabled()) // if it is enabled (which it should be because we clicked the edit button)
				{
					Thread.sleep(1000);
					findTextFieldElement(tempEle).sendKeys(Keys.chord(Keys.CONTROL, "a"));
					Thread.sleep(300); // Let the user actually see something!
					findTextFieldElement(tempEle).sendKeys(this.txtValue);
					Thread.sleep(300); // Let the user actually see something!
				}
				
				
				//close
				WebElement applyButton = this.driverRef.findElement(By.className("v-dialog--active")).findElement(By.className("v-card__actions")).findElement(By.className("v-btn"));
				if (applyButton.isEnabled())
					applyButton.click();
			}
		}
		
	}
	
	public static class ConfigurationErrorElement extends UIElements {

		/**
		 * ConfigurationErrorElement Element Constructor
		 * 
		 * This is used for errors which occur while creating the UIElements for the page.
		 * 
		 * @param exceptionDescription The error message from the exception
		 */
		public ConfigurationErrorElement(String exceptionDescription) {
			this.exceptionMessage = exceptionDescription;
		}



	}
}
