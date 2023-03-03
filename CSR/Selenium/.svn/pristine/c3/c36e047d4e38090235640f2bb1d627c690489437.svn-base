package runner;

public class Main {

	public static void main(String[] args) {
		
		//String server ="192.168.222.115"; - Josh's
		//String server ="192.168.223.76";
		String server ="127.0.0.1";
		String port ="4723";
		//String server ="127.0.0.1";
		Setup s = new Setup();
		s.StartDriver(server,port);
		
		//TestCaseRunner TCR = new TestCaseRunner();
		ExampleCaseRunner TCR = new ExampleCaseRunner();
		
		
		//Setup Validation Portion
		s = new Setup();
		s.StartDriver(server,port);
		
		
		//This validates that the above data was changed correctly,
		//This is done by opening the run agian and checking that the fields load the data we put in.
		ExampleCaseValidator Validator = new ExampleCaseValidator();
	}

}
