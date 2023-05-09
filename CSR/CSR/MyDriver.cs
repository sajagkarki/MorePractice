using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Edge;
using OpenQA.Selenium.Firefox;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Text;
namespace SeleniumAutomation

{
    public class MyDriver
    {
        public WebDriver Driver;
        
        //See changes in git after adding this comment. 
        public IWebElement GetWebElement(TestCases testCases,int count=0)
        {
            try 
            {
                if ("id".Equals(testCases.LocatorType, StringComparison.OrdinalIgnoreCase))
                {
                    IWebElement webElement = Driver.FindElement(By.Id(testCases.LocatorTypeValue));
                    
                    return webElement;
                    

                }

                if ("xpath".Equals(testCases.LocatorType, StringComparison.OrdinalIgnoreCase))
                {
                    IWebElement webElement = Driver.FindElement(By.XPath(testCases.LocatorTypeValue));
                    return webElement;
                }

                if ("name".Equals(testCases.LocatorType, StringComparison.OrdinalIgnoreCase))
                {
                    IWebElement webElement = Driver.FindElement(By.Name(testCases.LocatorTypeValue));
                    return webElement;
                }

                if ("ClassName".Equals(testCases.LocatorType, StringComparison.OrdinalIgnoreCase))
                {
                    IWebElement webElement = Driver.FindElement(By.ClassName(testCases.LocatorTypeValue));
                    return webElement;
                }

                if ("CssSelector".Equals(testCases.LocatorType, StringComparison.OrdinalIgnoreCase))
                {
                    IWebElement webElement = Driver.FindElement(By.CssSelector(testCases.LocatorTypeValue));
                    return webElement;
                }
            }
            catch(Exception ex)
            {
                Console.WriteLine(ex.Message);
                Console.WriteLine(ex.StackTrace);
                if (count<5)
                
                {
                    Thread.Sleep(2000);
                   return GetWebElement(testCases, count + 1); 
                    
                }
            }
           
            return null;
        }

        public void Exceute(TestCases testCases)
        {
            string mainWindow = ""; 
            try
            {
                testCases.IsPassed = true;
                if ("openbrowser".Equals(testCases.Action, StringComparison.OrdinalIgnoreCase))
                {
                   Driver = new ChromeDriver();
                    mainWindow = Driver.CurrentWindowHandle; 
                }
                else if ("openbrowserEdge".Equals(testCases.Action, StringComparison.OrdinalIgnoreCase))
                {
                    Driver = new EdgeDriver();

                }
                else if ("openbrowserFirefox".Equals(testCases.Action, StringComparison.OrdinalIgnoreCase))
                {
                    Driver = new FirefoxDriver();

                }
                else if ("enterurl".Equals(testCases.Action, StringComparison.OrdinalIgnoreCase))
                {
                    Driver.Navigate().GoToUrl(testCases.Value);
                    Thread.Sleep(2000);
                    var windows=Driver.WindowHandles;
                    Console.WriteLine(windows.Count);
                    

                    Process.Start(@"c:\driver\login.exe");
                   // Driver.FindElement(By.)
                   // Action action = new Action(Driver);
                   // action.s
                  //  Driver.SwitchTo().Window()
                    //Driver.Manage().Window;
                }
                else if ("sendkeys".Equals(testCases.Action, StringComparison.OrdinalIgnoreCase))
                {
                    IWebElement webElement = GetWebElement(testCases);
                    if (webElement != null)
                    {
                        webElement.Clear();
                        webElement.SendKeys(testCases.Value);
                    }
                }
                else if ("click".Equals(testCases.Action, StringComparison.OrdinalIgnoreCase))
                {
                    IWebElement webElement = GetWebElement(testCases);
                    if (webElement != null)
                    {

                        webElement.Click();
                    }
                }
                else if ("selectdropdown".Equals(testCases.Action, StringComparison.OrdinalIgnoreCase))
                {
                    IWebElement webElement = GetWebElement(testCases);
                    if (webElement != null)
                    {

                        webElement.Click();
                    }
                }

                else if ("maximize".Equals(testCases.Action, StringComparison.OrdinalIgnoreCase))
                {
                    Driver.Manage().Window.Maximize();
                }

                else if ("takingscreenshotpng".Equals(testCases.Action, StringComparison.OrdinalIgnoreCase))
                {
                    ITakesScreenshot screenshot = Driver as ITakesScreenshot;
                    Screenshot screenshot1 = screenshot.GetScreenshot();
                    screenshot1.SaveAsFile(testCases.Value, ScreenshotImageFormat.Png);

                }
                else if ("checkequalstitle".Equals(testCases.Action, StringComparison.OrdinalIgnoreCase))
                {
                    var title = Driver.Title;
                    if (title != testCases.Value)
                    {
                        testCases.ActualValue = title;
                        testCases.IsPassed = false;
                    }
                }
                else if ("checktext".Equals(testCases.Action, StringComparison.OrdinalIgnoreCase))
                {
                    IWebElement webElement = GetWebElement(testCases);
                    if (webElement != null)
                    {
                        var title = webElement.Text;
                        if (title != testCases.Value)
                        {
                            testCases.ActualValue = title;
                            testCases.IsPassed = false;
                        }
                    }
                    else
                    {
                        testCases.ActualValue = " Webelement is not found";
                        testCases.IsPassed = false;
                    }
                }
                else if ("javascriptexecutor".Equals(testCases.Action, StringComparison.OrdinalIgnoreCase))
                {
                    IJavaScriptExecutor js = (IJavaScriptExecutor)Driver;
                    js.ExecuteScript(testCases.Value);
                }
                else if ("isenabled".Equals(testCases.Action, StringComparison.OrdinalIgnoreCase))
                {
                    IWebElement webElement = GetWebElement(testCases);
                    if (!webElement.Enabled)
                    {
                        testCases.IsPassed = false;
                        testCases.ActualValue = "Element is disabled";
                    }

                }
                else if ("isdisabled".Equals(testCases.Action, StringComparison.OrdinalIgnoreCase))
                {
                    IWebElement webElement = GetWebElement(testCases);
                    if (webElement.Enabled)
                    {
                        testCases.IsPassed = false;
                        testCases.ActualValue = "Element is enabled";
                    }

                }
                else if ("sleep".Equals(testCases.Action, StringComparison.OrdinalIgnoreCase))
                {
                    Thread.Sleep(2000);

                }
                else if ("switchWindow".Equals(testCases.Action, StringComparison.OrdinalIgnoreCase))
                {
                    foreach (string handle in Driver.WindowHandles)
                    {
                        if (handle != mainWindow)
                        {
                            Driver.SwitchTo().Window(handle);
                            break;
                        }
                    }

                }

            }
            catch (Exception ex)
            {

                testCases.IsPassed = false;
            }


        }
    }
}
