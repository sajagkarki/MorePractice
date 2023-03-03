using OpenQA.Selenium;
using OpenQA.Selenium.Appium;
using OpenQA.Selenium.Appium.Windows;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Edge;
using OpenQA.Selenium.Firefox;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Text;
using WinappP6Automatoin;

namespace SeleniumAutomation

{
    public class MyDriver
    {
        WindowsDriver<WindowsElement> Driver;
        //See changes in git after adding this comment. 
        public WindowsElement GetWebElement(TestCases testCases,int count=0)
        {
            try 
            {
                if ("id".Equals(testCases.LocatorType, StringComparison.OrdinalIgnoreCase))
                {
                    WindowsElement webElement = Driver.FindElement(By.Id(testCases.LocatorTypeValue));
                    
                    return webElement;
                    
                }
                if ("accssibilityId".Equals(testCases.LocatorType, StringComparison.OrdinalIgnoreCase))
                {
                    WindowsElement webElement = Driver.FindElementByAccessibilityId((testCases.LocatorTypeValue));

                    return webElement;

                }

                if ("xpath".Equals(testCases.LocatorType, StringComparison.OrdinalIgnoreCase))
                {
                    WindowsElement webElement = Driver.FindElement(By.XPath(testCases.LocatorTypeValue));
                    return webElement;
                }

                if ("name".Equals(testCases.LocatorType, StringComparison.OrdinalIgnoreCase))
                {
                    WindowsElement webElement = Driver.FindElement(By.Name(testCases.LocatorTypeValue));
                    return webElement;
                }

                if ("ClassName".Equals(testCases.LocatorType, StringComparison.OrdinalIgnoreCase))
                {
                    WindowsElement webElement = Driver.FindElement(By.ClassName(testCases.LocatorTypeValue));
                    return webElement;
                }

                if ("CssSelector".Equals(testCases.LocatorType, StringComparison.OrdinalIgnoreCase))
                {
                    WindowsElement webElement = Driver.FindElement(By.CssSelector(testCases.LocatorTypeValue));
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
            try
            {
                testCases.IsPassed = true;
                if ("openwinapp".Equals(testCases.Action, StringComparison.OrdinalIgnoreCase))
                {
                    AppiumOptions ao = new AppiumOptions();
                    //ao.AddAdditionalCapability("app", "c:\\windows\\System32\\notepad.exe");
                    ao.AddAdditionalCapability("app", "C:\\Winium Test\\P6.exe");
                    ao.AddAdditionalCapability("deviceName", "WindowsPC");
                    Driver = new WindowsDriver<WindowsElement>(new Uri("http://127.0.0.1:4723"), ao);

                }
                
                
                else if ("sendkeys".Equals(testCases.Action, StringComparison.OrdinalIgnoreCase))
                {
                    WindowsElement webElement = GetWebElement(testCases);
                    if (webElement != null)
                    {
                        webElement.Clear();
                        webElement.SendKeys(testCases.Value);
                    }
                }
                else if ("click".Equals(testCases.Action, StringComparison.OrdinalIgnoreCase))
                {
                    WindowsElement webElement = GetWebElement(testCases);
                    if (webElement != null)
                    {

                        webElement.Click();
                    }
                }
     
                else if ("sleep".Equals(testCases.Action, StringComparison.OrdinalIgnoreCase))
                {
                    Thread.Sleep(2000);

                }
            }
            catch (Exception ex)
            {

                testCases.IsPassed = false;
            }


        }
    }
}
