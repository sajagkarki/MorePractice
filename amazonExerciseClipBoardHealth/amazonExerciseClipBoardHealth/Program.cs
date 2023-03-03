//Step 1 
//Open https://www.amazon.in/.
//Note: Clicking on above URL may redirect you to amazon.com. Change it to amazon.in

using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

IWebDriver driver;
driver = new ChromeDriver();
driver.Navigate().GoToUrl("https://www.amazon.in/"); //Test passed, browser open


//Step 2 Click on the hamburger menu in the top left corner. Done
driver.FindElement(By.ClassName("hm-icon-label")).Click();//Test passed, hamburger menu open

//Step 3 Scroll down and then Click on the TV,
//Appliances and Electronics link under Shop by Department section.

driver.FindElement(By.XPath("/html/body/div[3]/div[2]/div/ul[1]/li[16]/a/div")).Click(); //Test Passed clicked on TV

//Step 4 Then click on Televisions under Tv, Audio & Cameras sub section.

driver.FindElement(By.XPath("/html/body/div[3]/div[2]/div/ul[9]/li[3]/a")).Click(); //Test passed opens Televnions

//Step 5 oll down and filter the results by Brand ‘Samsung’.



