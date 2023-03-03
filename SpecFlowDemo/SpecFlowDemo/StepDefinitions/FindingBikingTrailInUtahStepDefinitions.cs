using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using System;
using TechTalk.SpecFlow;

namespace SpecFlowDemo.StepDefinitions
{
    [Binding]
    public class FindingBikingTrailInUtahStepDefinitions
    {
        IWebDriver driver; 
         [Given(@"A search engine ""([^""]*)"" is accesible")]
        public void GivenASearchEngineIsAccesible(string p0)
        {
            driver = new ChromeDriver();
            driver.Navigate().GoToUrl("http://www.google.com");

            
           // Console.WriteLine(p0);
        }

        [When(@"I enter a search criteria ""([^""]*)""")]
        public void WhenIEnterASearchCriteria(string p0)
        {
            driver.FindElement(By.Name("q")).SendKeys(p0);
            //Console.WriteLine(p0);
        }

     
        [Then(@"Output should display the options")]
        public void ThenOutputShouldDisplayTheOptions()
        {
            driver.FindElement(By.Name("q")).SendKeys(Keys.Enter);
            Thread.Sleep(5000);
            
            //Console.WriteLine("End");
        }

        [Then(@"I enter another search criteria ""([^""]*)""")]
        public void ThenIEnterAnotherSearchCriteria(string p0)
        {
            driver.Navigate().GoToUrl("http://www.google.com");
            driver.FindElement(By.Name("q")).SendKeys(p0);
        }

        [Then(@"Output should display the lunch options")]
        public void ThenOutputShouldDisplayTheLunchOptions()
        {
            driver.FindElement(By.Name("q")).SendKeys(Keys.Enter);
            Thread.Sleep(5000);
        }



    }
}
