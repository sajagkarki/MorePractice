package chromedriver;

import java.util.HashMap;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;

public class GenerateJSONInputFiles extends BaseCDTest{
	
	/**
	 * A struct for default values for testing.
	 * 
	 * Default values are set primarily for reference on more complex defaults (such as orientation description values)
	 * 
	 * @author a7368
	 *
	 */
	class defaultValueInput {
		//Checkbox
		boolean includeCB = false;
		
		// IWV/IWVS
		boolean includeIWVorIWVS = false;
		String defaultIWVValue = "Hello World";
		int defaultIWVSValue = 0;
		
		//Selection List
		int defaultSelectValue = 0;
		
		//Orientation Description
		boolean includeOrientationDescription = false;
		int[] orientationDescriptionVals = new int[] {2, 1, 0, 0, 0, 1, 0, 1};
		
		//Text Box
		String defaultTextValue = "Hello World";
		
		//Drag List
		int[] dragListSeparatorValues = new int[] {2, 1, 0, 0, 0, 1, 0, 1}; //Note, if multiple separators have different length you will need to use the uniqueValues array for them.
		int[] dragListSeparatorOptions = new int[] {2, 1, 0, 0, 0, 1, 0, 1}; //Note, if multiple separators have different length you will need to use the uniqueValues array for them.
		//Drag-drop list ordering must be done through unique values
		//Boggle Lists don't need any inputs
		
		//Radio Groups
		int defaultRGValues = 0; //Note, if multiple radio groups have different length you will need to use the uniqueValues array for them.
		
		//Stationing
		boolean includeStationing = false;
		int stationingSelection = 0;
		String customStationingValue = "Tralse";
		//Available and Selected lists must be done through unique values
		
		//DataSource
		boolean includeSimpleDataSource = false;
		String simpleDataSourceTextVal = "June";
		//Available and Selected lists must be done through unique values
		
		//CheckboxList
		int[] CBLVal = new int[] {0, 1, 0};
		
		/**
		 * Initializer
		 * 
		 * Parameters are named after their respective variable with the "par" suffix.
		 * 
		 */
		public defaultValueInput(boolean includeCBpar, boolean includeIWVorIWVSpar, String defaultIWVValuepar, int defaultIWVSValuepar, int defaultSelectValuepar,
				boolean includeOrientationDescriptionpar, int[] orientationDescriptionValspar, String defaultTextValuepar, int[] dragListSeparatorValuespar, 
				int[] dragListSeparatorOptionspar, int defaultRGValuespar, boolean includeStationingpar, int stationingSelectionpar, String customStationingValuepar, 
				boolean includeSimpleDataSourcepar, String simpleDataSourceTextValpar, int[] CBLValpar)
		{
			includeCB = includeCBpar;
			
			// IWV/IWVS
			includeIWVorIWVS = includeIWVorIWVSpar;
			defaultIWVValue = defaultIWVValuepar;
			defaultIWVSValue = defaultIWVSValuepar;
			
			//Selection List
			defaultSelectValue = defaultSelectValuepar;
			
			//Orientation Description
			includeOrientationDescription = includeOrientationDescriptionpar;
			orientationDescriptionVals = orientationDescriptionValspar;
			
			//Text Box
			defaultTextValue = defaultTextValuepar;
			
			//Drag List
			dragListSeparatorValues = dragListSeparatorValuespar; //Note, if multiple separators have different length you will need to use the uniqueValues array for them.
			dragListSeparatorOptions = dragListSeparatorOptionspar; //Note, if multiple separators have different length you will need to use the uniqueValues array for them.
			//Drag-drop list ordering must be done through unique values
			//Boggle Lists don't need any inputs
			
			//Radio Groups
			defaultRGValues = defaultRGValuespar; //Note, if multiple radio groups have different length you will need to use the uniqueValues array for them.
			
			//Stationing
			includeStationing = includeStationingpar;
			stationingSelection = stationingSelectionpar;
			customStationingValue = customStationingValuepar;
			//Available and Selected lists must be done through unique values
			
			//DataSource
			includeSimpleDataSource = includeSimpleDataSourcepar;
			simpleDataSourceTextVal = simpleDataSourceTextValpar;
			//Available and Selected lists must be done through unique values
			
			//CheckboxList
			CBLVal = CBLValpar;
		}
		
	}
	
	/**
	 * A test input file, which may be read off by CDTest classes to configure different tests.
	 * @author a7368
	 *
	 */
	class testInputFile {
		String InputName = "No Name Provided"; //The page this test is designed for
		int FileCounter = 0; //The counter for this particular page. Needed to prevent tests overwriting eachother.
		defaultValueInput defaultValues; // A list of global settings, which most objects will pull from for easy configuration.
		HashMap<String, Object> uniqueValues = null; //A map of unique settings. used for nested objects, or objects/configurations which otherwise could not be accessed with only the default array.
		
		public testInputFile(String Name, int counter, defaultValueInput defValues, HashMap<String, Object> inputValues)
		{
			InputName = Name;
			FileCounter = counter;
			defaultValues = defValues;
			uniqueValues = inputValues;
		}
	}
	
	/**
	 * Validates the inputs with the database result.
	 * This will print out a JSON file, showing all the test results in detail.
	 * 
	 * @param elements A List of the element which are being validated
	 * @param page The name of the CSR page being tested
	 * @throws IOException 
	 */
	@Test
	public void compaireDB() throws IOException {
		
		//Declare the test inputs
		List<testInputFile> inputFiles = new ArrayList<testInputFile>();
		
		HashMap<String, Object> exampleHash = new HashMap<String, Object>();
		exampleHash.put("ExampleKey", "ExampleValue");
		exampleHash.put("ExampleArrKey", new ArrayList<String>(Arrays.asList("Hello", "World")));
		
		//Example
		inputFiles.add(new testInputFile("exampleFormat", 1, new defaultValueInput(
						true, true, "Hello", 0, 0, true, new int[] {1, 2, 0, 0, 1, 0, 1, 0}, "World", 
						new int[] {1, 0}, new int[] {0, 1}, 0, true, 0, "Furlongs", true, "Wingdings", new int[] {1, 1, 1})
				, exampleHash));
		
		
		//Convert Test input files into JSON Files
		for (testInputFile file : inputFiles) {
		
			//NOTE: There is no additional tag lines as this needs to be unpacked back into an object in testing.
			Gson gson = new Gson(); 
			String json = "";
			
			json += gson.toJson(file);
			
			System.out.println(json);
			
			//Write to File
			Files.write(Paths.get("./JSONTestConfigFiles/" + file.InputName + "_" + file.FileCounter + ".json"), json.getBytes());                              
		}
		 
	}

}
