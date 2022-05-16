// See https://aka.ms/new-console-template for more information

//Exercise 1 Write a C# Sharp program to print Hello and your name in a separate line.
Console.WriteLine("Sajag");
Console.WriteLine("Karki");

//Exercise 2 Write a C# Sharp program to print the sum of two numbers.
int x = 10;
int y = 5;
int sum = x + y;
Console.WriteLine("Sum of the numbers " + x + " and "+ y+ " is "+ sum);

//Exercise 3 Wrete a C# program to print the result of dividing two numers

int division = x / y;
Console.WriteLine("Division of the numbers " + x + " by " + y + " is " + division);

//Exercise 4 Write a C# Sharp program to print the result of the specified operations.

//-1 + 4 * 6 BODMAS(Bracket, Of, Division,Multiplication,Addition,Substraction)
Console.WriteLine(-1 + 4 * 6);
//( 35+ 5 ) % 7
Console.WriteLine((35 + 5) % 7);
//14 + -4 * 6 / 11
Console.WriteLine(14 + -4 * 6 / 11);
//2 + 15 / 6 * 1 - 7 % 2
Console.WriteLine(2 + 15 / 6 * 1 - 7 % 2);

//Exericse 5 Write a C# Sharp program to swap two numbers.
//Input first number
int firstNumber = 2;
int secondNumber = 7;
int iamTheSwapper;

iamTheSwapper = firstNumber;
firstNumber = secondNumber;
secondNumber = iamTheSwapper;

Console.WriteLine("I am first number after swapping "+ firstNumber); 
Console.WriteLine("I am second number after swapping " + secondNumber);



