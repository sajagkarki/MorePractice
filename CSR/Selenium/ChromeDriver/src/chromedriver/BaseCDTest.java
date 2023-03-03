package chromedriver;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.google.gson.stream.JsonReader;
import com.tdw.csr.dao.BaseDAOTest;
import com.tdw.utils.MongoConfig;

import chromedriver.BaseCDTest.BrowserLaunchMode;
import chromedriver.GenerateJSONInputFiles.testInputFile;



public class BaseCDTest extends BaseDAOTest {

	public static final String sysproperty_webdriver_chrome_driver = "webdriver.chrome.driver";
	
	/** Kept private so the key-value methods are more discoverable.
	 * @see getSessionAuthToken*
	 **/
	private static final String SESSION_KEY_AUTH_TOKEN = "auth.currentUserSession";
	
	public enum BrowserLaunchMode { ChromeHeadless, ChromeStandardDev, ChromeStandard, WhyEeExplorer, Edge, Firefox}

	//TODO move to a config file. is CsrMongoConfig.java a good example? - SR
	protected MongoConfig mc = new MongoConfig("testcsr.pie.tdwilliamson.com:27018", "devcsr");
	protected static final String chromeUserDataDir = "C:\\SeleniumWebDriver\\UserData";
	protected static final String JSONTestConfigFilesDir = "..\\Chromedriver\\JSONTestConfigFiles\\";
	protected static final BrowserLaunchMode launchMode = BrowserLaunchMode.ChromeStandardDev;
	public static final String CSR_FRONTEND_BASE_URL = "https://testcsr.pie.tdwilliamson.com:8443";
	// TODO SR temporary token for testing
	@Deprecated
	protected static final String JWT_QA = new String("eyJ0eXAiOiJqd3MiLCJhbGciOiJSUzI1NiJ9.eyJVc2VyUHJvZmlsZSI6eyJ1c2VySUQiOiI1ZWNlYTJjOGMwYmRlN2ZkZWJkODg2ODAiLCJ1c2VyUHJpbmNpcGFsTmFtZSI6bnVsbCwiYWNvZGUiOiJhNzM2OCIsInJvbGVzIjpudWxsLCJjbGllbnRSZXBDb21wYW55Q29kZXMiOltdLCJjYW5Mb2dJbiI6ZmFsc2UsInJvbGVMZXZlbCI6IlBST0ZJTEVfQURNSU4iLCJtb2RpZmllZE5hbm9zVVRDIjo5MjIzMzcyMDM2ODU0Nzc1ODA3LCJtb25nb0lEIjoiNWVjZWEyYzhjMGJkZTdmZGViZDg4NjgwIn0sIm9sZCI6MTYyNDUxNjE2NywiaXNzIjoiQ1NSUmVzdDpSU0FYLjUwOTcxODczOTI0NzExNTkxNTEwNzIyNTYxMjQ2Iiwic3ViIjoiYTczNjgiLCJhdWQiOiJURFdJTExJQU1TT04uQ09NIiwibmJmIjoxNjI0Mzg2NTY3LCJpYXQiOjE2MjQzODY1NjcsImV4cCI6MTYzMDYwNzM2NywianRpIjoiMGI4MzRkOWUtNTk5MC00N2NjLWJjNzMtNzg2NWU3YzJkNTg2In0.nWFBgi98Gz1DBFOvhuVTu_TwXZhSN3c90HltFVc-cy-TREtlOR27SxilCUDQnsFNsmqBdwmqgbtWyFfY598Tgoknm8Zg0Bag72KD3MFCN9IgwPBtY8ki2XReoW7_MyRs_ZNa1tCD0_ztxZxRtV1cktO8KJo1Eqvz51sCsp4EwsgEMWV6CrLqh_fbdo0UdrmWSbsQOxvCDIlJ16LSIZw2rBFPiE6p_VOjKW70UIXOdOIUhir2IoYYp21DTK2SU6FBd16RUFkkVsmd7mhXH6cYOSeDb_Z4kgUBOB0D093gm06Iela0YZ1B-1ZgO80CzwHLqyxVmBtpRkGkzMNchF_iEvhv1VdF0SjJgzSRBzXSXqnv_0O8W_jZ5jTUB-DxlSbH5kCNwMAZYF47FnUWx4Sy9worc1M0TSfzew24KYwrUBSF-2-nDYKXGONrQuJuVHsm8Ga7l_hXaR8qPJwnonDEJ8V5Fj-95y1jvtem-r4fu3nH8fQ7dIGeLugX8iDprzaHLTUfU34GkUpTGatxsWcPoxEOO_2SGHGBMRmqoIKp_JcQ-aUOZaTaVnPRL4eXjBWN6YuNnhX14hSAHaZ--5rqc_k6VvfrnnoaoDe2G9NsxsEKzPmtCEVevLMrilKT2mZAsWApq6jO_GypC-zq25NHFRsQKo93ikAm6VHNnpe9Om0");

	
	
	//TODO move to a config file (end)

	/** 
	 * This method returns a static key for a session key-value pair.
	 * */
	protected static final String getSessionAuthTokenKey() {
		return SESSION_KEY_AUTH_TOKEN;
	}
	
	/**
	 * Wraps a jwt in json as a "token" element as expected by the CSR vue front-end.
	 * */
	protected String getSessionAuthTokenValueWrapped(String jwt) {
		return "{\"token\": \"" + jwt + "\"}";
	}
	
	@Deprecated
	protected static final void setChromeDriverExePath() {
		String chromeDriverExePath = System.getProperty(sysproperty_webdriver_chrome_driver);

//TODO  Remove this hard-coded path stuff.
//		Should optionally load from a config file, if configured.
//		Hard-coding paths and having tools in multiple places is getting our applications blocked by M$ Defender ATP,
//		Currently only inflicted on volunteers but soon to rollout to everyone. 
		String chromeDriverExe = "C:\\SeleniumWebDriver\\chromedriver.exe";
		String chromeDriverExe2 = "D:/ChromeDriver/chromedriver.exe";
//		Optional. If not specified, WebDriver searches the PATH for chromedriver.
		if (null != chromeDriverExe && new File(chromeDriverExe).isFile()) {
			System.setProperty(sysproperty_webdriver_chrome_driver, chromeDriverExe);
		} else if (null != chromeDriverExe2 && new File(chromeDriverExe2).isFile()) {
			System.setProperty(sysproperty_webdriver_chrome_driver, chromeDriverExe2);
		}
//TODO  Remove this hard-coded path stuff. (end)

	//	Check chromedriver.exe path config
		chromeDriverExePath = System.getProperty(sysproperty_webdriver_chrome_driver);
		if (null==chromeDriverExePath) {
			System.err.println("[WARN] CONFIG: chromedriver.exe will be discovered via PATH upon use.");
			return;
		}

		if (! new File(chromeDriverExePath).isFile()) {
			throw new RuntimeException("[ERROR] CONFIG: "+sysproperty_webdriver_chrome_driver+" defined but chromedriver.exe not found:" + chromeDriverExePath);
		} else {
			System.err.println("[WARN] CONFIG: ChromeDriverExePath manually set: " + chromeDriverExePath);
		}
	}

	public static final ChromeOptions getChromeOptions(BrowserLaunchMode BrowserLaunchMode) {
	
		BaseCDTest.setChromeDriverExePath();
		System.out.println("If you see an error like this next, set "+sysproperty_webdriver_chrome_driver+" or put chromedriver.exe on path: The path to the driver executable must be set by the webdriver.");
		
		ChromeOptions chromeOptions = new ChromeOptions();
	
		switch (launchMode) {
			case ChromeHeadless:
				chromeOptions.addArguments("--headless");
				chromeOptions.addArguments("--disable-gpu");
				chromeOptions.addArguments("--window-size=1280,800");
				break;
			case ChromeStandardDev:
				// Save 5 seconds of our lives each time we troubleshoot this.
				chromeOptions.addArguments("--auto-open-devtools-for-tabs");
			case ChromeStandard:
	//			chromeOptions.addArguments("--start-maximized");
				// Clearly we'd prefer testing multiple combinations of explicit window sizes; common ones, rotated, small, some random ones sure. But be explicit and log it. 
				chromeOptions.addArguments("--window-size=1200,1000");
				chromeOptions.addArguments("--user-data-dir="+chromeUserDataDir);
				chromeOptions.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
				
				// Save driver the trouble
				System.err.println("[WARNING]: Deprecated chrome option is ignored: useAutomationExtension");
				// chromeOptions.setExperimentalOption("useAutomationExtension", false);
				break;
	//TODO add support for testing other browsers?
	//		case WhyEeExplorer:
	//			//TODO Chrome and IE both use Internet Options, so be aware there may be common ground.
	//			break;
	//		case Edge:
	//			// Because why would Edge stick to standards, bucking the trend has worked so well for M$ in the past.
	//			break;
	//		case Firefox:
	//			// Best "common" browser that almost nobody uses. Sad.
			default:
				throw new RuntimeException("Clearly nobody cares about your browser. You can do better.");
		}
		return chromeOptions;
	}

	protected WebElement findCheckboxClickElement(WebElement parent) throws InterruptedException {

		WebElement isci = parent.findElement(By.className("v-input--selection-controls__input"));

		return isci;
	}

	protected WebElement findCheckboxSelectedElement(WebElement parent) throws InterruptedException {

		WebElement cb = parent.findElement(By.name("propertyWithUpdates_cb"));

		return cb;
	}

	protected WebElement findTextFieldElement(WebElement parent) throws InterruptedException {

		WebElement tf = parent.findElement(By.name("v-text-field"));

		return tf;
	}

	protected WebElement findTextButtonClickElement(WebElement parent) throws InterruptedException {

		WebElement bce = parent.findElement(By.className("v-btn--text"));

		return bce;
	}

	protected List<WebElement> findRadioGroupClickElements(WebElement parent) throws InterruptedException {

		List<WebElement> rgc = parent.findElements(By.className("v-input--selection-controls__input"));

		return rgc;
	}
	
	protected List<WebElement> findCBGroupClickElements(WebElement parent) throws InterruptedException {

		List<WebElement> rgc = parent.findElements(By.className("v-input--selection-controls__input"));

		return rgc;
	}

	protected List<WebElement> findSelectElements(WebDriver driver) throws InterruptedException {

		WebElement parent = findSelectParent(driver);

		List<WebElement> se = parent.findElements(By.className("v-list-item"));

		return se;
	}

	protected WebElement findSelectParent(WebDriver driver) throws InterruptedException {

		List<WebElement> sp = driver.findElements(By.className("v-menu__content"));

		return sp.get(sp.size() - 1);
	}

	protected String findSelectedText(WebElement parent) throws InterruptedException {

		String str = parent.findElement(By.className("v-select__selection")).getText();

		return str;
	}

	protected void dragAndDropElement(WebElement dragFrom, WebElement dragTo, int xOffset, int yOffset)
			throws Exception {

		// Setup robot
		Robot robot = new Robot();
		robot.setAutoDelay(50);

		robot.mouseMove(0, 0);

		// Fullscreen page so selenium coordinates work
		// robot.keyPress(KeyEvent.VK_F11);
		// Thread.sleep(2000);

		// Get size of elements
		Dimension fromSize = dragFrom.getSize();
		Dimension toSize = dragTo.getSize();

		// Get centre distance
		int xCentreFrom = fromSize.width / 2;
		int yCentreFrom = fromSize.height / 2;
		int xCentreTo = toSize.width / 2;
		int yCentreTo = toSize.height / 2;

		// Get x and y of WebElement to drag to
		Point toLocation = dragTo.getLocation();
		Point fromLocation = dragFrom.getLocation();

		// Make Mouse coordinate centre of element
		toLocation.x += xOffset + xCentreTo;
		toLocation.y += yCentreTo;
		fromLocation.x += xCentreFrom;
		fromLocation.y += yCentreFrom;

		// Move mouse to drag from location
		robot.mouseMove(fromLocation.x, fromLocation.y + yOffset);

		// Click and drag
		robot.mousePress(InputEvent.BUTTON1_MASK);
		Thread.sleep(1000);

		// Drag events require more than one movement to register
		// Just appearing at destination doesn't work so move halfway first
		// robot.mouseMove(((toLocation.x - fromLocation.x) / 2) + fromLocation.x,
		// ((toLocation.y
		// - fromLocation.y) / 2) + fromLocation.y);

		// Move to final position
		robot.mouseMove(0, 0);
		robot.mouseMove(toLocation.x, toLocation.y + yOffset);
		Thread.sleep(1000);

		// Drop
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}

	protected List<String> getComponentsTxt(List<WebElement> dragElements) {
		int i = 0;
		List<String> components = new ArrayList<String>();
		for (WebElement e : dragElements) {
			WebElement ele = dragElements.get(i).findElement(By.className("csrComponentLabel"));
			components.add(ele.findElement(By.tagName("span")).getText());
			i++;
		}

		return components;
	}
	
	
	protected List<String> getDragIconTxt(List<WebElement> dragElements) {
		int i = 0;
		List<String> components = new ArrayList<String>();
		for (WebElement e : dragElements) {
			WebElement ele = dragElements.get(i).findElement(By.className("v-btn__content"));
			components.add(ele.getText());
			i++;
		}

		return components;
	}
	

	private String getWebCSSSelector(WebElement element, WebDriver driver) {
		final String JS_BUILD_CSS_SELECTOR = "for(var e=arguments[0],n=[],i=function(e,n){if(!e||!n)return 0;f"
				+ "or(var i=0,a=e.length;a>i;i++)if(-1==n.indexOf(e[i]))return 0;re"
				+ "turn 1};e&&1==e.nodeType&&'HTML'!=e.nodeName;e=e.parentNode){if("
				+ "e.id){n.unshift('#'+e.id);break}for(var a=1,r=1,o=e.localName,l="
				+ "e.className&&e.className.trim().split(/[\\s,]+/g),t=e.previousSi"
				+ "bling;t;t=t.previousSibling)10!=t.nodeType&&t.nodeName==e.nodeNa"
				+ "me&&(i(l,t.className)&&(l=null),r=0,++a);for(var t=e.nextSibling"
				+ ";t;t=t.nextSibling)t.nodeName==e.nodeName&&(i(l,t.className)&&(l"
				+ "=null),r=0);n.unshift(r?o:o+(l?'.'+l.join('.'):':nth-child('+a+'" + ")'))}return n.join(' > ');";

		return (String) ((JavascriptExecutor) driver).executeScript(JS_BUILD_CSS_SELECTOR, element);
	}

	protected void jumpToElement(WebDriver driver, WebElement ele) {
		Actions actions = new Actions(driver);
		actions.moveToElement(ele);
		actions.perform();
	}

	public GenerateJSONInputFiles.testInputFile readTestInputFile(String JSONname) throws FileNotFoundException, IOException {
		
		String configFilePath = JSONTestConfigFilesDir + JSONname;

		// Load input data
		GenerateJSONInputFiles.testInputFile argumentFile = null;
		// Use try-with-resources to prevent resource leak, but don't guard against
		// FileNotFound exception or catch json parsing exceptions - they provide
		// valuable info as-is.
		try (JsonReader reader = new JsonReader(new FileReader(configFilePath))) {
			argumentFile = gson.fromJson(reader, GenerateJSONInputFiles.testInputFile.class);
		}
		return argumentFile;
	}
}
