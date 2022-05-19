//// See https://aka.ms/new-console-template for more information

////Exercise 1 Write a C# Sharp program to print Hello and your name in a separate line.
//Console.WriteLine("Sajag");
//Console.WriteLine("Karki");

////Exercise 2 Write a C# Sharp program to print the sum of two numbers.
//int x = 10;
//int y = 5;
//int sum = x + y;
//Console.WriteLine("Sum of the numbers " + x + " and "+ y+ " is "+ sum);

////Exercise 3 Wrete a C# program to print the result of dividing two numers

//int division = x / y;
//Console.WriteLine("Division of the numbers " + x + " by " + y + " is " + division);

////Exercise 4 Write a C# Sharp program to print the result of the specified operations.

////-1 + 4 * 6 BODMAS(Bracket, Of, Division,Multiplication,Addition,Substraction)
//Console.WriteLine(-1 + 4 * 6);
////( 35+ 5 ) % 7
//Console.WriteLine((35 + 5) % 7);
////14 + -4 * 6 / 11
//Console.WriteLine(14 + -4 * 6 / 11);
////2 + 15 / 6 * 1 - 7 % 2
//Console.WriteLine(2 + 15 / 6 * 1 - 7 % 2);

////Exericse 5 Write a C# Sharp program to swap two numbers.
////Input first number
//int firstNumber = 2;
//int secondNumber = 7;
//int iamTheSwapper;

//iamTheSwapper = firstNumber;
//firstNumber = secondNumber;
//secondNumber = iamTheSwapper;

//Console.WriteLine("I am first number after swapping "+ firstNumber); 
//Console.WriteLine("I am second number after swapping " + secondNumber);

//// Exercise 6 Write a C# Sharp program to print the output of multiplication of three numbers which will be entered by the user



//int firstNumbertoMultiply;
//int secondNumbertoMultiply;
//int thirdNumbertoMuliply;

//Console.WriteLine("Enter first number: ");
//firstNumbertoMultiply= int.Parse(Console.ReadLine());

//Console.WriteLine("Enter second number: ");
//secondNumbertoMultiply= int.Parse(Console.ReadLine());

//Console.WriteLine("Enter third number: ");
//thirdNumbertoMuliply= int.Parse(Console.ReadLine());

//int multiply = firstNumbertoMultiply * secondNumbertoMultiply * thirdNumbertoMuliply;

//Console.WriteLine("Multiplication of " + firstNumbertoMultiply + ", "+ secondNumbertoMultiply + ", " + thirdNumbertoMuliply + " is " + multiply );

////Exercise 7 Write a C# Sharp program to print on screen the output of adding, subtracting, multiplying and dividing of two numbers which will be entered by the user.

//double userInputoOne;
//double userInputTwo;

//Console.WriteLine("Enter first number ");
//userInputoOne= int.Parse(Console.ReadLine());

//Console.WriteLine("Enter second number");
//userInputTwo= int.Parse(Console.ReadLine());

//double addition = userInputoOne + userInputTwo; 
//double subtract = userInputoOne - userInputTwo;
//double multiplication = userInputoOne * userInputTwo;
//double div = userInputoOne / userInputTwo;

//Console.WriteLine("Addition is " + addition + " Subtractin is "+ subtract + " Multiplication is "+ multiplication + " Division is "+ div );

//Exercise 8 Write a C# Sharp program that takes a number as input and print its multiplication table.

//int number = 14;
////manually
////Console.WriteLine(number*1);
////Console.WriteLine(number*2);
////Console.WriteLine(number*3);
////Console.WriteLine(number*4);

//Console.WriteLine("Multiplicatin table for " + number+ "is ");
//for (int i = 1; i <=12; i++)
//{
//    Console.WriteLine(number*i);
//}

//Exercise 9 Write a C# Sharp program that takes four numbers as input to calculate and print the average.

//int input1;
//int input2;
//int input3;
//int input4;
//int average; 

//Console.WriteLine("Enter first number");
//input1 = int.Parse(Console.ReadLine());

//Console.WriteLine("Enter second number");
//input2 = int.Parse(Console.ReadLine());

//Console.WriteLine("Enter third number");
//input3 = int.Parse(Console.ReadLine());

//Console.WriteLine("Enter fourth number");
//input4 = int.Parse(Console.ReadLine());

//average = (input1 + input2 + input3 + input4) / 2; 

//Console.WriteLine("Average of the numbuers inputed is " + average); 


// Exercise 10 Write a C# Sharp program to that takes three numbers(x,y,z) as input and print the output of (x+y).z and x.y + y.z.

//int x = 1;
//int y = 2;
//int z = 5;

//int Output1 = (x + y)*z;
//int Output2 = (x * y) + (y*z);
//Console.WriteLine(Output1);
//Console.WriteLine(Output2);    

// Exercise 11 Write a C# Sharp program that takes an age (for example 20) as input and prints something as "You look older than 20".

//Console.WriteLine("Enter your age ");
//int age = int.Parse(Console.ReadLine());

//Console.WriteLine("You look older than "+ age);

//Exercise 12  Write a C# program that takes a number as input and display it four times in a row (separated by blank spaces),
//and then four times in the next row, with no separation.
//You should do it two times: Use Console.Write and then use {0}.


//int exercise12=2; 

//for (int i = 1; i <=4; i++)
//{
//    Console.Write(exercise12 + " ");
//}

//Console.WriteLine();    

//for (int i = 0; i <= 4; i++)
//{
//    Console.Write(exercise12);
//}

//Exercise 13 Write a C# program that takes a number as input and then displays a rectangle of 3 columns wide and 5 rows tall using that digit.

int exercise13;
Console.WriteLine("Enter a number");

exercise13 = int.Parse(Console.ReadLine());
Console.WriteLine();

for (int i = 1; i <= 3; i++)
{
    Console.Write(exercise13 + " ");
}
for (int i = 1; i <= 4; i++)
{
    Console.WriteLine(exercise13);
}
for (int i = 1; i <= 3; i++)
{
    Console.Write(exercise13 + " ");
}

//int x;

//Console.Write("Enter a number: ");
//x = Convert.ToInt32(Console.ReadLine());

//Console.WriteLine("{0}{0}{0}", x);
//Console.WriteLine("{0} {0}", x);
//Console.WriteLine("{0} {0}", x);
//Console.WriteLine("{0} {0}", x);
//Console.WriteLine("{0}{0}{0}", x);