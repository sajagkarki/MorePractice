Feature: Calculator
As an idiot in maths, I would like the computer to take two numbers add two numbers and display it for me.
So that I don't make silly mistakes.

@ToDoApp
Scenario: Add two numbers
	Given the first number is 500
	And the second number is 70
	When the two numbers are added
	Then the result should be 570
	