using NUnit.Framework;

namespace SpecFlowDemo.StepDefinitions
{
    [Binding]
    public sealed class CalculatorStepDefinitions
    {
        // For additional details on SpecFlow step definitions see https://go.specflow.org/doc-stepdef
        int yourNumber;
        int secondNumber;
        int sum; 
        [Given("the first number is (.*)")]
        public void GivenTheFirstNumberIs(int number)
        {
           yourNumber = number;
            //throw new PendingStepException();
        }

        [Given("the second number is (.*)")]
        public void GivenTheSecondNumberIs(int number)
        {
            secondNumber = number;
            //TODO: implement arrange (precondition) logic

            //throw new PendingStepException();
        }

        [When("the two numbers are added")]
        public void WhenTheTwoNumbersAreAdded()
        {
            sum = yourNumber + secondNumber; 
            //TODO: implement act (action) logic

            //throw new PendingStepException();
        }

        [Then("the result should be (.*)")]
        public void ThenTheResultShouldBe(int result)
        {
            Assert.AreEqual(sum, result);
            if (sum==result)
            {
                Console.WriteLine("Numbers are equal");
                Console.WriteLine(sum);
            }
            //TODO: implement assert (verification) logic

            //throw new PendingStepException();
        }
    }
}