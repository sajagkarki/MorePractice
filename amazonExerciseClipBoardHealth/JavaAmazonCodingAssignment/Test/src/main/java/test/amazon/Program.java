package test.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");  
	      
	       // Instantiate a ChromeDriver class.       
	    WebDriver driver=new ChromeDriver();  
 openUrl(driver); 
 openHamBurgerMenu(driver); 
 scrollToElementAndClick(driver); 
 clickOnTelevisions(driver);
 Thread.sleep(3000);
 scrollAndFilterByBrand(driver); 
 Thread.sleep(1000);
 sortResultsHightoLow(driver); 
 clickSecondHighest(driver); 
 Thread.sleep(2000);
 switchWindow(driver); 
 assertAboutThisItem(driver); 
 Thread.sleep(20000);
}
	public static void openUrl(WebDriver driver) 
	{	
		driver.get(" https://www.amazon.in/");
		driver.manage().window().maximize(); 
	}
    public static void openHamBurgerMenu(WebDriver driver ) 
    {
    	WebElement webElement=driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]/i")); 
    	webElement.click();
    }
    public static void scrollToElementAndClick(WebDriver driver) 
    {
    	WebElement webElement=driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul")); 
    	((JavascriptExecutor)driver).executeScript("arguments[0].scrollTo(0,200);", webElement); 
    	 webElement=driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul//li/a/div[contains(text(),\"TV, Appliances, Electronics\")]/..")); 
    	 webElement.click(); 
    	
    }
    public static void clickOnTelevisions(WebDriver driver) 
    {
    	WebElement webElement=driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul//li/a[contains(text(),\"Televisions\")]")); 
        webElement.click(); 
    }
    public static void scrollAndFilterByBrand(WebDriver driver)
    {
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("window.scrollBy(0,3200)");
    	WebElement webElement=driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[24]/ul/li[3]/span/a/div/label")); 
    	webElement.click(); 
    	
    }
    
    public static void sortResultsHightoLow(WebDriver driver) 
    {
    	WebElement webElement=driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]/span[2]")); 
        webElement.click(); 
        webElement=driver.findElement(By.xpath("//*[@id=\"a-popover-2\"]//*[contains(text(),\"High to Low\")]")); 
        webElement.click(); 
    }
    public static void clickSecondHighest(WebDriver driver)
    {
    	WebElement webElement=driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]//a/span")); 
        webElement.click(); 
    }
    public static void switchWindow(WebDriver driver)
    {
    	String winHandleBefore = driver.getWindowHandle();

    	
    	for(String winHandle : driver.getWindowHandles()){
    		if(winHandle!=winHandleBefore){
    	    driver.switchTo().window(winHandle);
    	}
    	}
    }
    
    public static void assertAboutThisItem(WebDriver driver)
    {
    	WebElement webElement=driver.findElement(By.xpath("//*[@id=\"feature-bullets\"]/h1")); 
    	if (webElement==null)
    	{
    		System.out.println("Element is not present");
    		return; 
    	}
    	else
    	{
    		System.out.println("Element is present");
    	}
    	String text=webElement.getText();
    	System.out.println(text);
    	if (text.contains("About this item"))
    	{
    		System.out.println("The text is present");
    	}
    	else
    	{
    		System.out.println("The text is not present");
    	}
    }
    
}
