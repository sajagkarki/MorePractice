using System;
using TechTalk.SpecFlow;

namespace SpecFlowDemo.StepDefinitions
{
    [Binding]
    public class Feature1StepDefinitions
    {
        [Given(@"A data search engine are https://www\.google(.*)\.com/ accesible")]
        public void GivenADataSearchEngineAreHttpsWww_Google_ComAccesible(int p0)
        {
            throw new PendingStepException();
        }

        [When(@"I data entered with criteria Biking trails near Salt Lake City xyz")]
        public void WhenIDataEnteredWithCriteriaBikingTrailsNearSaltLakeCityXyz()
        {
            throw new PendingStepException();
        }


    

        [Then(@"Output should display the optionss")]
        public void ThenOutputShouldDisplayTheOptionss()
        {
            throw new PendingStepException();
        }
    }
}
