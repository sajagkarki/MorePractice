using OpenQA.Selenium.Appium;
using OpenQA.Selenium.Appium.Windows;
using OpenQA.Selenium.Remote;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WinappP6Automatoin
{
    public class DesktopSession
    {
        private const string WindowsApplicationDriverUrl = "http://127.0.0.1:4723/";
        WindowsDriver<WindowsElement> desktopSession;

        public DesktopSession()
        {
            AppiumOptions ao = new AppiumOptions();
            //ao.AddAdditionalCapability("app", "c:\\windows\\System32\\notepad.exe");
            ao.AddAdditionalCapability("app", "C:\\Winium Test\\P6.exe");
            ao.AddAdditionalCapability("deviceName", "WindowsPC");
            desktopSession = new WindowsDriver<WindowsElement>(new Uri("http://127.0.0.1:4723"), ao);
        }

        ~DesktopSession()
        {
            desktopSession.Quit();
        }

        public WindowsDriver<WindowsElement> DesktopSessionElement
        {
            get { return desktopSession; }
        }

        public WindowsElement FindElementByAbsoluteXPath(string xPath, int nTryCount = 10)
        {
            WindowsElement uiTarget = null;

            while (nTryCount-- > 0)
            {
                try
                {
                    uiTarget = desktopSession.FindElementByXPath(xPath);
                }
                catch
                {
                }

                if (uiTarget != null)
                {
                    break;
                }
                else
                {
                    System.Threading.Thread.Sleep(2000);
                }
            }

            return uiTarget;
        }
    }
}
