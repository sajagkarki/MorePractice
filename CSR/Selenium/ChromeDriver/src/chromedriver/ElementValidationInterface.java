package chromedriver;

import java.util.List;

import com.tdw.csr.entity.Entity;

/*
 * Database Validation Interface
 * 
 * This is a lambda expression which takes the UIElement being tested and a list from the database.
 * 
 * NOTE: It is important that this expression, in addition to returning whether or not the data is valid,
 * also construct the Elements returnedValues string. If not done then the log info will be incomplete.
 */
interface ElementValidationInterface {
	
	boolean validationTest(UIElements ele, List<? extends Entity> list);
	
	default boolean validation()
	{
		System.out.println("Error: Missing Validation Test");
		return false;
	}
}
