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




//Step 1- Make three columns manually

//Step 2- Repeat loop 5 times
//int exercise13;
//Console.WriteLine("Enter your number ");
//exercise13 = int.Parse(Console.ReadLine());

//for (int j = 0; j < 5; j++)
//{
//    for (int i = 0; i < 3; i++)
//    {
//        Console.Write(exercise13);
//        Console.Write(" ");
//    }
//    Console.WriteLine();
//}






//Console.WriteLine("Enter a number");

//exercise13 = int.Parse(Console.ReadLine());
//Console.WriteLine();

//for (int i = 1; i <= 3; i++)
//{
//    Console.Write(exercise13 + " ");
//}
//for (int i = 1; i <= 4; i++)
//{
//    Console.WriteLine(exercise13);
//}
//for (int i = 1; i <= 3; i++)
//{
//    Console.Write(exercise13 + " ");
//}

//int x;

//Console.Write("Enter a number: ");
//x = Convert.ToInt32(Console.ReadLine());

//Console.WriteLine("{0}{0}{0}", x);
//Console.WriteLine("{0} {0}", x);
//Console.WriteLine("{0} {0}", x);
//Console.WriteLine("{0} {0}", x);
//Console.WriteLine("{0}{0}{0}", x);

//Exercise 14 Write a C# program to convert from celsius degrees to Kelvin and Fahrenheit. 
//Celcius to Fahrenheight
//Console.WriteLine("Enter Degrees Celcius");
//int celcius = int.Parse(Console.ReadLine()); 
//int farenheit = celcius*9/5 + 32;


////Celcius to Kelvin
//double kelvin = celcius + 273.15; 

//Console.WriteLine(celcius + " degrees celcius is = "+ farenheit + " Degrees farenheit");
//Console.WriteLine(celcius + " degrees celcius is = " + kelvin + " kelvin");

//Exercise 15 Write a C# program to remove specified a character from a non-empty string using index of a character.//Question not clear
// Create one string, remove any one character from the string. For example in "Utah" remove "a"
//Index will always be integer.
//Two methods of removing . 1.Only with index 2. Other is index with count
//string characterManipulation = "Utah";
//string removeCharacter = "a";
////Remove a from utah

//int index= characterManipulation.IndexOf(removeCharacter);
//Console.WriteLine(index);
//string result = characterManipulation.Remove(index, 1); 
//Console.WriteLine(result);


//Exercise 16 Write a C# program to create a new string from a given string where the first and last characters will change their positions.
//What happens when there is only one character. How do you handle the exception? 
//Check for boundry condition(one character)
string firstString = "palindrome";


//char firstCharacter = firstString[0];
//char lastCharacter = firstString[firstString.Length - 1];

//firstString[0] = lastCharacter;

//string result = $"{lastCharacter}{firstString.Substring(1, firstString.Length - 2)}{firstCharacter}";

//If length of string is less than 2 then


//if (firstString.Length<2)
//{
//    Console.WriteLine(firstString);
//}
//else
//{
//    string result = $"{firstString[firstString.Length - 1]}{firstString.Substring(1, firstString.Length - 2)}{firstString[0]}";
//    Console.WriteLine(result);
//}

//17. Write a C# program to create a new string from a given string (length 1 or more ) with the first character added at
//the front and back

//I went on cancun vacation. 
//Output= II went on cancun vacation.I


//string exerciseSeventeen = "I went on cancun vacation";
//Console.Write(exerciseSeventeen[0]);
//Console.Write(exerciseSeventeen);
//Console.WriteLine(exerciseSeventeen[0]);

//Console.WriteLine(firstString.Substring(1,firstString.Length-2));
//Console.WriteLine(result);

//expected result new string is reverse "gajas"

//swop index 0 to index 4

//firststring[0]
//char temphold = firststring[0];
//temphold = firststring[4]

//string reverestring;

//18. Write a C# program to check two given integers and return true if one is negative and one is positive.

//int a = 1;
//int b = 2;

//if (a>=0 && b<0)
//{
//    Console.WriteLine("True");
//}
//else if (b >= 0 && a < 0)
//{
//    Console.WriteLine("True");
//}
//else
//{
//    Console.WriteLine("False");
//}

//19. Write a C# program to compute the sum of two given integers, if two values are equal then return the triple of their sum.

//int integerOne = 2;
//int integerTwo = 200;

//int sum = integerOne + integerTwo; 

//if (integerOne==integerTwo)
//{
//    Console.WriteLine(sum*3);
//}

//else
//{
//    Console.WriteLine(sum);
//}
//Practice One at least every day so you will have practice to Write something, practice to Read something, practice to think something
//Whatever issue can be resolved on Satruday/Sunday
//Revise all answers every day

// 20. Write a C# program to get the absolute value of the difference between two given numbers.
// Return double the absolute value of the difference if the first number is greater than second number.

//int exerciseTwentyFirstNumber = 20; 
//int exerciseTwentySecondNumber = 5;

//int differenceAbsolute; 

//if (exerciseTwentyFirstNumber>exerciseTwentySecondNumber)
//{
//    differenceAbsolute = (exerciseTwentyFirstNumber - exerciseTwentySecondNumber) * 2; 
//    Console.WriteLine( differenceAbsolute);
//}
//else
//{
//    Console.WriteLine(exerciseTwentySecondNumber-exerciseTwentyFirstNumber);
//}

//21. Write a C# program to check the sum of the two given integers and return true if one of the integer is 20 or if their sum is 20. 

//int exerciseTwentyOneFirstNumber = 10;
//int exercisetwentyOneSecondumber = 0;

//int sumExerciseTwentyOne = exerciseTwentyOneFirstNumber + exercisetwentyOneSecondumber;

//if (exerciseTwentyOneFirstNumber==20 ||exercisetwentyOneSecondumber==20 || sumExerciseTwentyOne==20)
//{
//    Console.WriteLine("True");
//}
//else
//{
//    Console.WriteLine("False");
//}

//22.Write a C# program to check if an given integer is within 20 of 100 or 200
//Step 1 create variable Done
//int exerciseTwentytwo = 900;
////Step 2 condition Within 20 of 100 (for the given integer) Is 90 within 20 of 100. 

//if (exerciseTwentytwo>=80 && exerciseTwentytwo<=120 || exerciseTwentytwo>=180 && exerciseTwentytwo<=220)
//{
//    Console.WriteLine(exerciseTwentytwo+ " is within 20 of 100 or 200");
//}
//else
//{
//    Console.WriteLine(exerciseTwentytwo+ " is not within 20 of 100 or 200");
//}

//23.Write a C# program to convert a given string into lowercase.

//Step 1 Create string variable

string exerciseTwentythree = "SINGlE MALT LIVES PODCAST";

Console.WriteLine(exerciseTwentythree.ToLower());

