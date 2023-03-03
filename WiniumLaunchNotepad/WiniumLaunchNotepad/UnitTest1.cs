using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium.Winium;
using System;

namespace WiniumLaunchNotepad
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void LaunchNotepad()
        {
            //Notepad
            
            DesktopOptions options = new DesktopOptions();
            options.ApplicationPath = @"C:\Windows\System32\notepad.exe";//Placeholder-Path to appp
            
            WiniumDriver Driver = new WiniumDriver(@"C:\Users\A7726\Downloads\Winium.Desktop.Driver", options);
            Driver.FindElementByClassName("Edit").SendKeys("This is a demo for Winium desktop application ");
            

            //P6 
            /*
            DesktopOptions options = new DesktopOptions();
            options.ApplicationPath = @"C:\Winium Test\P6.exe";
            WiniumDriver Driver = new WiniumDriver(@"C:\Users\A7726\Downloads\Winium.Desktop.Driver", options);
            var element = Driver.FindElementByClassName("winElem_LeftDblClickEditName_133_13");//Inspector is not pointing to correct elements
            element.Click();
            */
            
            
        }


    }

}
