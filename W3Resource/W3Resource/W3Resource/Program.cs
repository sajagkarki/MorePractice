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

//Console.WriteLine("Enter your number ");
//int exercise13 = int.Parse(Console.ReadLine());

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
//int farenheit = celcius * 9 / 5 + 32;


////Celcius to Kelvin
//double kelvin = celcius + 273.15; 

//Console.WriteLine(celcius + " degrees celcius is = "+ farenheit + " Degrees farenheit");
//Console.WriteLine(celcius + " degrees celcius is = " + kelvin + " kelvin");

//Exercise 15 Write a C# program to remove specified a character from a non-empty string using index of a character.//Question not clear
// Create one string, remove any one character from the string. For example in "Utah" remove "a"
//Index will always be integer.
//Two methods of removing . 1.Only with index 2. Other is index with count
//string characterManipulation = "Moab";
//string removeCharacter = "a";
////Remove a from utah

//int index = characterManipulation.IndexOf(removeCharacter);
//Console.WriteLine(index);
//string result = characterManipulation.Remove(index, 1);
//Console.WriteLine(result);


//Exercise 16 Write a C# program to create a new string from a given string where the first and last characters will change their positions.
//What happens when there is only one character. How do you handle the exception? 
//Check for boundry condition(one character)
//string firstString = "palindrome";


//char firstCharacter = firstString[0];
//char lastCharacter = firstString[firstString.Length - 1];

////firstString[0] = lastCharacter;

//string result = $"{lastCharacter}{firstString.Substring(1, firstString.Length - 2)}{firstCharacter}";
//Console.WriteLine(result);

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

//20.Write a C# program to get the absolute value of the difference between two given numbers.
// Return double the absolute value of the difference if the first number is greater than second number.
//Multiply by -1 for absolute

//int exerciseTwentyFirstNumber = 20;
//int exerciseTwentySecondNumber = 5;

//int differenceAbsolute;

//if (exerciseTwentyFirstNumber > exerciseTwentySecondNumber)
//{
//    differenceAbsolute = (exerciseTwentyFirstNumber - exerciseTwentySecondNumber) * 2;
//    Console.WriteLine(differenceAbsolute);
//}
//else
//{
//    Console.WriteLine(exerciseTwentySecondNumber - exerciseTwentyFirstNumber);
//}

//21. Write a C# program to check the sum of the two given integers and return true if one of the integer is 20 or if their sum is 20. 

//int exerciseTwentyOneFirstNumber = 10;
//int exercisetwentyOneSecondumber = 0;

//int sumExerciseTwentyOne = exerciseTwentyOneFirstNumber + exercisetwentyOneSecondumber;

//if (exerciseTwentyOneFirstNumber == 20 || exercisetwentyOneSecondumber == 20 || sumExerciseTwentyOne == 20)
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

//if (exerciseTwentytwo >= 80 && exerciseTwentytwo <= 120 || exerciseTwentytwo >= 180 && exerciseTwentytwo <= 220)
//{
//    Console.WriteLine(exerciseTwentytwo + " is within 20 of 100 or 200");
//}
//else
//{
//    Console.WriteLine(exerciseTwentytwo + " is not within 20 of 100 or 200");
//}

//23.Write a C# program to convert a given string into lowercase.

//Step 1 Create string variable

//string exerciseTwentythree = "SINGlE MALT LIVES PODCAST";

//Console.WriteLine(exerciseTwentythree.ToLower());

//How to find largest number 1,31,2,10,14


//int[] array = new int[] { 1, 590, 200, 10, 1000 }; 

//int maxVariable = 0;

//for (int i = 0; i <array.Length; i++)
//{
//    if (array[i] > maxVariable) 
//    {
//        maxVariable = array[i]; 
//    }
//}
//string longestWord = "Which is the longest word";
//string[] arrayString = longestWord.Split(' ');
////string[] arrayString = { "Rabbit", "Mouse", "Dog", "Hippapotomus", "Elephant" };
//int[] array = new int[arrayString.Length];


//for (int i = 0; i < array.Length; i++)
//{

//    array[i] = arrayString[i].Length;
//}

//////array[0] = arrayString[0].Length;
//////array[1] = arrayString[1].Length;
//////array[2] = arrayString[2].Length;
//////array[3] = arrayString[3].Length;
//////array[4] = arrayString[4].Length;
//int maxVariable = 0;
////int maxIndex = 0;

//for (int i = 0; i < array.Length; i++)
//{
//    if (array[i] > maxVariable)
//    {
//        maxVariable = array[i];
//        //maxIndex = i;
//    }
//}
//Console.WriteLine(maxVariable);

//Console.WriteLine("The longest word in this array is " + arrayString[maxIndex]);
//if (array[0]>maxVariable) //(1>0)
//{
//    maxVariable = array[0]; //maxvalue is 1
//}
//if (array[1]>maxVariable) //590>1
//{
//    maxVariable = array[1]; //maxvalue is 590
//}
//if (array[2] > maxVariable) //200>590
//{
//    maxVariable = array[2];//maxvalue will remain 590
//}
//if (array[3] > maxVariable)//10>590
//{
//    maxVariable = array[3];//maxvalue is 590
//}
//if (array[4]>maxVariable)//1000>590
//{
//    maxVariable = array[4];//maxvalue is 1000
//}


//24. Write a C# program to find the longest word in a string.
//Step 1 create string 
//string longsentenseword = "wow! coding is such a pain in the universe"; 
////step 2 create array to split words in sentence
//string [] sentensesplit= longsentenseword.Split(' ');
////step 3 create integer array to get count of word
//int[] arraytocount = new int[sentensesplit.Length];

////step 5 loop integer array with splited words array
//for (int i = 0; i < arraytocount.Length; i++)
//{
//    arraytocount[i]=sentensesplit[i].Length;
//}
////step 6 create maximum count integer
//int maxwordcount = 0;
// //step 7 create index of longest word
//int maxindexword = 0; 

////step 8 loop arraytocount and condition with maxwordcount
//for (int i = 0; i < arraytocount.Length; i++)
//{
//    if (arraytocount[i]>maxwordcount)
//    {
//        maxwordcount = arraytocount[i];
//        maxindexword = i; 
//    }
//}

//Console.WriteLine(maxwordcount);
//Console.WriteLine("The longest word in  "+ longsentenseword+ " is "+ sentensesplit[maxindexword]);

//25. Write a C# program to print the odd numbers from 1 to 99. Prints one number per line.

//for (int i = 0; i < 100; i++)
//{
//    if (i%2!=0)
//    {
//        Console.WriteLine(i);
//    }
//}

//26. Write a C# program to compute the sum of the first 500 prime numbers.(Ask Abhay)

//1 2 3 5 7 11 13 17 23 Start with 4 



//27.Write a C# program and compute the sum of the digits of an integer.

//Console.WriteLine("Enter your number");
//int exercisetwentySeven = int.Parse(Console.ReadLine());
//int sumTwentyseven = 0;

//while (exercisetwentySeven > 0)
//{
//    sumTwentyseven = sumTwentyseven + (exercisetwentySeven % 10);
//    exercisetwentySeven /= 10;
//}
//Console.WriteLine("Sum of the integer is: " + sumTwentyseven);

//28. Write a C# program to reverse the words of a sentence.

//string exerciseTwentyEight = "Reverse me";
//string[] wordsList = exerciseTwentyEight.Split(' ');
//Array.Reverse(wordsList);
//string reverseSentence = string.Join(" ", wordsList);
//Console.WriteLine(reverseSentence);

//29.Write a C# program to find the size of a specified file in bytes. (Done)
//Two types of files 1. text 2. string
// */
//FileInfo exerciserTwentynine = new FileInfo(@"C:\SharpernCSharp\Dummy.docx");
//int i29 = 0;
//Console.WriteLine(exerciserTwentynine.Length); //in kb divide by 1024

//FileInfo exerciseTwentyninenew = new FileInfo(@"C:\SharpernCSharp\MorePractice\TestingGit.docx");
//int i291 = 0;
//Console.WriteLine(exerciseTwentyninenew.Length);

//30.Write a C# program to convert a hexadecimal number to decimal number.(Done)
//int exerciserThirty = 400;
//Console.WriteLine(exerciserThirty.ToString("X"));

//string exerciserThirtystring = "190";
//Console.WriteLine(Convert.ToInt32(exerciserThirtystring, 16));

//Step 1 what is hexadecimal? In mathematics and computing,
//the hexadecimal numeral system is a positional numeral system that represents numbers using a radix of 16
//what is decimal? relating to or denoting a system of numbers and arithmetic based on the number ten, tenth parts, and powers of ten.

//31.Write a C# program to multiply corresponding elements of two arrays of integers.
//Step 1- Create two integer arrays.

//int[] exerciseThirtyoneFirstArray =  { 5, 2, 6, 1 };
//int[] exerciseThirtyoneSecondArray = { 3, 4, 5, 6 };
////int[] exerciseThirtyoneMultiplied = { exerciseThirtyoneFirstArray[0] * exerciseThirtyoneSecondArray[0], exerciseThirtyoneFirstArray[1]*exerciseThirtyoneSecondArray[2], exerciseThirtyoneFirstArray[2]*exerciseThirtyoneSecondArray[2], exerciseThirtyoneFirstArray[3]*exerciseThirtyoneSecondArray[3] };

//// Step 2 Think about how to manually as a human multiply first index of first array with first index of second array

////Step 3 What are the steps repeating? Automate it. 
//for (int i = 0; i < exerciseThirtyoneFirstArray.Length; i++)
//{
//    Console.Write(exerciseThirtyoneFirstArray[i] * exerciseThirtyoneSecondArray[i] + " ");
//}

//32. Write a C# program to create a new string of four copies, taking last four characters from a given string.
//If the length of the given string is less than 4 return the original one(Done)

//Step 1 Create string

//Console.WriteLine("Enter a sentence");
//string exerciseThirtytwo = Console.ReadLine();


//if (exerciseThirtytwo.Length < 4)
//{
//    Console.WriteLine(exerciseThirtytwo);

//}
//else
//{
//    for (int i = 0; i <4 ; i++)
//    {
//        Console.WriteLine(exerciseThirtytwo.Substring(exerciseThirtytwo.Length - 4));
//    }
//}

//Step 1 Create string

//Console.WriteLine("Enter a sentence");
//string exerciseThirtytwo = Console.ReadLine();


//if (exerciseThirtytwo.Length < 4)
//{
//    Console.WriteLine(exerciseThirtytwo);

//}
//else
//{
//    for (int i = 0; i < 4; i++)
//    {
//        Console.Write(exerciseThirtytwo.Substring(exerciseThirtytwo.Length - 4));
//    }
//}


//33.Write a C# program to check if a given positive number is a multiple of 3 or a multiple of 7.
//Step 1 create variable with positive number

//Console.WriteLine("Enter a number :");
//int exerciseThirtyThree = int.Parse(Console.ReadLine());
////Step 2 Identify logic numbers that multiply with 3 or 7
//// 3*3*3 || 7*7*7

//if (exerciseThirtyThree % 3 == 0 || exerciseThirtyThree % 7 == 0)
//{
//    Console.WriteLine(exerciseThirtyThree + " is a multiple of 3 or 7");
//}
//else
//{
//    Console.WriteLine(exerciseThirtyThree + " is not a multiple of 3 or 7");
//}

//34. Write a C# program to check if a string starts with a specified word. 
/*Note: Suppose the sentence starts with "Hello"
Sample Data: string1 = "Hello how are you?"
Result: Hello.
Sample Output:
Input a string : Hello how are you?
True */

//Console.WriteLine("Type a sentence:");
//string exerciseThirtyfour = Console.ReadLine(); 
//Console.WriteLine("Type a word:");
//string enterWord = Console.ReadLine();

//string[] sentenceSplittingone = exerciseThirtyfour.Split(' ');

//for (int i = 0; i < sentenceSplittingone.Length; i++)
//{
//    Console.WriteLine(sentenceSplittingone[i]);
//}


//if (sentenceSplittingone[0] == enterWord)
//{
//    Console.WriteLine($"{exerciseThirtyfour} starts with {enterWord}");
//}
//else
//{
//    Console.WriteLine($"{exerciseThirtyfour} does not start with {enterWord}");
//}

//35. Write a C# program to check two given numbers where one is less than 100 and other is greater than 200.

//Step 1 Crete two integers 
//int exerciseThirtyfiveint1 = 35;
//int exerciseThirtyfiveint2 = 300;


////Step 2 Write condition if one is less than 100 and other is greater than 200
//if (exerciseThirtyfiveint1<100 && exerciseThirtyfiveint2 > 200)
//{
//    Console.WriteLine("True");
//}

//36. Write a C# program to check if an integer (from the two given integers) is in the range -10 to 10. 

//Step 1 create two integers
//int exerciserThirtysixInt1 = -20;
//int exerciserThirtysixint2 = 10;

////Step 2 write condition if it is within range of -10 to 10
//if ((exerciserThirtysixInt1 >= -10 && exerciserThirtysixInt1 <= 10) || exerciserThirtysixint2 >= -10 && exerciserThirtysixint2 <= 10)
//{
//    Console.WriteLine("True");
//}
//else
//{
//    Console.WriteLine("False");
//}

//37.Write a C# program to check if "HP" appears at second position in a string and returns the string without "HP".(Done)
//Step 1- Create string with HP 

//Console.WriteLine("Enter a sentence ");
//string exerciseThirtyseven = Console.ReadLine();


//Step 2 - Condition if "HP" appears at second position in string, return string without "HP"
//Check it first as a human
//Sajag's method

//if (exerciseThirtyseven.Substring(1, 2) == ("HP")) //1 is second position (index) 2 is two characters
//{
//    Console.WriteLine(exerciseThirtyseven.Remove(1, 2));
//}
////Abhay's method
//if (exerciseThirtyseven.IndexOf("HP") == 1)
//{

//    {
//        Console.WriteLine(exerciseThirtyseven.Remove(1, 2));
//    }
//}
//else
//{
//    Console.WriteLine(exerciseThirtyseven);
//}


//38. Write a C# program to get a new string of two characters from a given string.(Tip- Use method you understand better like substring
//Try using indexof then substring)
//The first and second character of the given string must be "P" and "H", so PHP will be "PH".

//Step 1 Read the question
//Step 2 Arrange manually
//string exerciseThirtyeightstring = "PHR";  // Return 
//string exerciseThirtyeightnewstring = "";

//Method 1
////New string should return "PH"
//if (exerciseThirtyeightstring.Length > 1 && exerciseThirtyeightstring[0] == 'P')
//{
//    exerciseThirtyeightnewstring = exerciseThirtyeightnewstring + exerciseThirtyeightstring[0];

//}
//if (exerciseThirtyeightstring.Length > 2 && exerciseThirtyeightstring[1] == 'H')
//{
//    exerciseThirtyeightnewstring = exerciseThirtyeightnewstring + exerciseThirtyeightstring[1];

//}
//Console.WriteLine(exerciseThirtyeightnewstring);
//Method 2
//if (exerciseThirtyeightstring.Length<3)
//{
//    Console.WriteLine(exerciseThirtyeightstring);
//}
//else
//{
//    if (exerciseThirtyeightstring.Substring(0,1)=="P" && exerciseThirtyeightstring.Substring(1,1)=="H")
//    {
//        Console.WriteLine(exerciseThirtyeightstring.Substring(0,2));
//    }
//}
//40. Write a C# program to check the nearest value of 20 of two given integers and return 0 if two numbers are same. 

//Step 1 Read & understand question
//Step 2 Nearest value of 20 (19,18  21 22) 
////Create two integers
//int exerciseFourtyInt1 = 12;
//int exerciseFourtyInt2 = 30;
////Condition 

////Methond 1
////if (exerciseFourtyInt1 == exerciseFourtyInt2)
////{
////    Console.WriteLine("0");
////}
////else if (exerciseFourtyInt1 <= 20 && (exerciseFourtyInt1 > exerciseFourtyInt2))
////{
////    Console.WriteLine(exerciseFourtyInt1);
////}
////else if (exerciseFourtyInt2 <= 20 && exerciseFourtyInt2 > exerciseFourtyInt1)
////{
////    Console.WriteLine(exerciseFourtyInt2);
////}
////Method 2 
//if (exerciseFourtyInt1==exerciseFourtyInt2)
//{
//    Console.WriteLine("0");
//}
//else if(Math.Abs(20-exerciseFourtyInt1) > Math.Abs(20-exerciseFourtyInt2))
//{
//    Console.WriteLine(exerciseFourtyInt2);
//}
//else
//{
//    Console.WriteLine( exerciseFourtyInt1);
//}
//41.Write a C# program to check if a given string contains ‘w’ character between 1 and 3 times.
//Step 1 create string
//string exerciserFourtyone = "uwhwotewl";
//string[] splitExerciserFourtyone = exerciserFourtyone.Split('w');
////int countletter = 0;
////Step 2 condidion 
//if (splitExerciserFourtyone.Length > 1 && splitExerciserFourtyone.Length < 5)
//{
//    Console.WriteLine("True");
//}
//else
//{
//    Console.WriteLine("False");
//}

//42. Write a C# program to create a new string where the first 4 characters will be in lower case.
//If the string is less than 4 characters then make the whole string in upper case.

//Step 1 create string
//Console.WriteLine("Enter your text");
//string exerciseFourtyTwo = Console.ReadLine();

//string exerciserFourtyTwonewstring = exerciseFourtyTwo.Substring(0, 4);

//if (exerciserFourtyTwonewstring == exerciserFourtyTwonewstring.ToLower())
//{
//    Console.WriteLine(exerciserFourtyTwonewstring);
//}
//else
//{
//    Console.WriteLine(exerciseFourtyTwo.ToUpper());
//}

//43 Write a C# program to check if a given string starts with "w" and immediately followed by two "ww"
//Step 1 Arrange 
//string exerciserFourtyThree = "ww world";
//If it starts with "w" then first three chacters is ww. Check 
////Step 2 Act 

//Ctrl k+f to format syntax
//if (exerciserFourtyThree.StartsWith('w') && exerciserFourtyThree.Substring(1, 2).Equals("ww"))
//{
//    Console.WriteLine("True");
//}

//else
//{
//    Console.WriteLine("False");
//}


//44 Write a C# program to create a new string of every other character (odd position)
//from the first position of a given string. 
//nput a string : w3resource
//Sample Output
//wrsuc

//Step 1 create string
//Console.WriteLine("Enter your sentence");
//string exerciseFourtyFour = Console.ReadLine();
//string exerciserFourtyFourResult=""; 
//for (int i = 0; i < exerciseFourtyFour.Length; i++)
//{
//    if (i%2==0)
//    {
//      exerciserFourtyFourResult= exerciserFourtyFourResult+  exerciseFourtyFour[i];
//    }

//}
//Console.WriteLine(exerciserFourtyFourResult);

//45 Write a C# program to count a specified number in a given array of integers.
//Step 1 create integer array

//int[] exerciseFourtyfive = { 2, 30, 20, 3, 5, 9,8 };

////Step 2 count numbers in array
//int countExerciserFourtyfive = 0;

//for (int i = 0; i < exerciseFourtyfive.Length; i++)
//{
//    countExerciserFourtyfive = countExerciserFourtyfive + 1;
//}

//Console.WriteLine("There are " + countExerciserFourtyfive + " in this array");

// 46. Write a C# program to check if a number appears as either the first
// or last element of an array of integers and the length is 1 or more.

//Step 1 create integer
//Console.WriteLine("Enter a number");
//int exerciseFourtysix = int.Parse(Console.ReadLine());
////Step 2 create array
//int[] exerciseFourtysixarray = { 3, 4, 5, 6, 7, 8, 2 };
////Step 3 condition- Check if integer exerciserFourtysix is either First exerciseFourtysixarray[0] || exerciserFourtysixarray[exerciseFourtysixarray.Length]

//for (int i = 0; i < exerciseFourtysixarray.Length; i++)
//{
//    if (exerciseFourtysix==exerciseFourtysixarray[0] || exerciseFourtysix == exerciseFourtysixarray[exerciseFourtysixarray.Length-1])
//    {
//        Console.WriteLine("Yes");
//        break; 
//    }
//    else
//    {
//        Console.WriteLine("No");
//        break; 
//    }
//}

//47.Write a C# program to compute the sum of all the elements of an array of integers.

//Step 1 create array
//int[] exerciserFourtyseven = {7,2,1,4,2,4 };
//// Step 2 Sum of elements in array
//int sumExerciseFourtyseven = 0;

//for (int i = 0; i <exerciserFourtyseven.Length; i++)
//{
//    sumExerciseFourtyseven = sumExerciseFourtyseven + exerciserFourtyseven[i];
//}

//Console.WriteLine(sumExerciseFourtyseven);

// 48. Write a C# program to check if the first element
// and the last element are equal of an array of integers and the length is 1 or more.

//Step 1 create array
//int[] exerciseFouryeight = { 2, 3, 4, 5 };

//for (int i = 0; i < exerciseFouryeight.Length; i++)
//{
//    if (exerciseFouryeight[0] == exerciseFouryeight[exerciseFouryeight.Length - 1])
//    {
//        Console.WriteLine("Yes");
//        break;
//    }
//    else
//    {
//        Console.WriteLine("No");
//        break;
//    }
//}

//49. Write a C# program to check if the first element or the last element of the two arrays ( length 1 or more) are equal.
//Step 1 Create two arrays
//int[] exerciseFourtyninearr1 = { 1, 2, 3, 4, 5, 6, };
//int[] exerciseFourtyninearr2 = { 5, 2, 2, 4, 6};

//Step 2 condition if first element or last element of two arrays are equal



//if (exerciseFourtyninearr1[0] == exerciseFourtyninearr2[0] || exerciseFourtyninearr1[exerciseFourtyninearr1.Length - 1] == exerciseFourtyninearr2[exerciseFourtyninearr2.Length - 1])
//{
//    Console.WriteLine("Either first or last numbers match");

//}
//else
//{
//    Console.WriteLine("No match");

//}


//**50. Write a C# program to rotate an array (length 3) of integers in left direction.(Ask Abhya next week 7/11)
//Step 1 create arrray of length 3
//int[] arrFifty = { 3, 2, 5 };
////Step 2 Condition, write code to rotate array left 
////arr[1]= 3 arr[]0, 5 arr.Length= 2 arr[1], 

//for (int i = 0; i < arrFifty.Length; i++)
//{
//    //arrFifty[1] = arrFifty[0];
//    arrFifty[1] = arrFifty[2];
//    //arrFifty[0]=arrFifty[1];
//}
//for (int i = 0; i < arrFifty.Length; i++)
//{
//    Console.WriteLine(arrFifty[i]);
//}

// 51. Write a C# program to get the larger value between first and last element of an array (length 3) of integers.
//Step 1 understand question
//Get larger value between first & last element of an array length 3
//Step 2 create int array of 3 

//int[] exerciserFittyone = { 1, 2, 5 };
//Step 3 Condition - Get the larger value between first and last element
//int largestValue = 0;

//for (int i = 0; i < exerciserFittyone.Length; i++)
//{
//    if (exerciserFittyone[i] > largestValue)
//    {
//        largestValue = exerciserFittyone[i];
//    }
//}

//Console.WriteLine("Largest value is "+ largestValue);

//52. Write a C# program to create a new array of length containing the middle elements of three arrays (each length 3) of integers.
//Step 1 read question
//Step 2 create three arrays (length 3)

//int[] exerciseFiftytwo= { 9, 2, 0 };
//int[] exerciserFiftytwo1={ 0, 9, 1 }; 
//int[] exerciseFiftytwo2= { 2, 1, 1 };

////Step 3 condition create new array containing middle elements of the arrays 


//for (int i = 0; i < exerciseFiftytwo.Length; i++)
//{
//    int[] middleArray = { exerciseFiftytwo[1], exerciserFiftytwo1[1], exerciseFiftytwo2[1] };
//    Console.WriteLine(middleArray[i]);

//}

//53. Write a C# program to check if an array contains an odd number.
//Step 1 Understand
//Step 2 Initiate create array

//int[] exerciseFiftythree = { 7, 4, 9, 14 };
////Step 3 Condition , if any numbers in array is an odd number

//Console.WriteLine("Odd numbers are: ");
//for (int i = 0; i < exerciseFiftythree.Length; i++)
//{
//    if (exerciseFiftythree[i]%2 !=0)
//    {
//        Console.WriteLine(exerciseFiftythree[i]);
//    }
//}

//54.Write a C# program to get the century from a year.
//Step 1 understand. How do you know which cetury? Startin 2000 is 21st century . 1999 is 20 th centuray 1899 is 19th centuray
//1799 is 17th century. 1800-1899 is 19th century 1900- 1999 20th  2000- 2099 21st 2100- 2199 22nd century 2200-2299 23rd centruy
//Console.WriteLine("Enter a year");
//int year = int.Parse(Console.ReadLine());

//int century = 1 + (year / 100);
////Console.WriteLine(year + " is "+ century);
//Console.WriteLine($"{year} is {century}st Century");





//**55. Write a C# program to find the pair of adjacent elements that (Ask Abhay)
//has the largest product of an given array which is equal to a given value.

//56. Write a C# program to check if a given string is a palindrome or not.

//Console.WriteLine("Enter a word");
//string exerciseFiftysix = Console.ReadLine();

//for (int i = 0; i < exerciseFiftysix.Length; i++)
//{
//    if (exerciseFiftysix[i] != (exerciseFiftysix[exerciseFiftysix.Length - 1 - i]))
//    {
//        Console.WriteLine("False");
//        break;
//    }
//    else
//    {
//        Console.WriteLine("True");
//        break; 

//    }
//}
//To do: Revise all 15 that I practiced last week. 

//**57.Write a C# program to find the pair of adjacent elements that has the highest product of an given array of integers.(Ask Abhay next week)

//58.Write a C# program which will accept a list of integers and checks how many integers are needed to complete the range.

//int[] exerciserFiftyeight = { 2,5,7 };

//int maxVariable = 0;

//for (int i = 0; i < exerciserFiftyeight.Length; i++)
//{
//    if (exerciserFiftyeight[i] > maxVariable)
//    {
//        maxVariable = exerciserFiftyeight[i];
//    }
//}

//int minVariable = int.MaxValue;

//for (int i = 0; i < exerciserFiftyeight.Length; i++)
//{
//    if (exerciserFiftyeight[i] < minVariable)
//    {
//        minVariable = exerciserFiftyeight[i];
//    }
//}

//Console.WriteLine((maxVariable-minVariable)-exerciserFiftyeight.Length+1);
//Revise 
//Postman 

//59.  Write a C# program to check whether it is possible to create a strictly increasing sequence(Ask Abhay)
//from a given sequence of integers as an array.

//Step 1 Understand question
//Yes no 

/*60.Write a C# program to calculate the sum of all the integers of a rectangular matrix(Ask Abhay)
//except those integers which are located below an intger of value 0.


 * 61. Write a C# program to sort the integers in ascending order without moving the number -5. Go to the editor


62. Write a C# program to reverse the strings contained in each pair of matching parentheses in a given string and also remove the parentheses within the given string. Go to the editor

*/

//63. Write a C# program to check if a given number present in an array of numbers.

//Step 1 Create integer
//Console.WriteLine("Enter a number");
//int exerciseSixtyThreeint= int.Parse(Console.ReadLine());

//Step 2 Create Array
//int[] exerciseSixtythreeArray = { 5, 2, 9, 0 };

////Step 3 condition
//for (int i = 0; i < exerciseSixtythreeArray.Length; i++)
//{
//    if (exerciseSixtyThreeint == exerciseSixtythreeArray[i])
//    {
//        Console.WriteLine("Yes");
//        break; 
//    }
//    else
//    {
//        Console.WriteLine("No");
//        break; 
//    }
//}

//64. Write a C# Sharp program to get the file name (including extension) from a given path.

//65. Write a function to multiply all of elements of a given array of numbers by the array length.

//Step 1 understand question
//1,4,2 * 3 = 3,12,6

//Step 2 create array 
//int[] exerciseSixtyfiveArraymain = { 1, 2, 1 };

//static int[] MultiplyElements(int[] exerciseSixtyFiveArray)
//{
//    int[] arrayResult = new int[exerciseSixtyFiveArray.Length];

//    for (int i = 0; i < exerciseSixtyFiveArray.Length; i++)
//    {
//        arrayResult[i] = exerciseSixtyFiveArray.Length * exerciseSixtyFiveArray[i];
//        Console.WriteLine(arrayResult[i]);

//    }
//    return arrayResult;
//}
//var arrayResult = MultiplyElements(exerciseSixtyfiveArraymain);

//static void Print(int[] printArray)
//{
//    for (int i = 0; i < printArray.Length; i++)
//    {
//        Console.WriteLine(printArray[i]);
//        break;
//    }
//}
//Print(arrayResult);



//66.Write a C# Sharp program to find the minimum value from two given numbers, represented as string.

//Console.WriteLine("Enter first number");
//string exerciseSixtysixOne = Console.ReadLine();
//Console.WriteLine("Enger second number");
//string exerciseSixtysixTwo = Console.ReadLine();

//int toInt1 = int.Parse(exerciseSixtysixOne);
//int toInt2 = int.Parse(exerciseSixtysixTwo);

//if (toInt1 > toInt2)
//{
//    Console.WriteLine($"{toInt1} is greater than {toInt1} ");
//}
//else
//{
//    Console.WriteLine($"{toInt2} is greater than {toInt1} ");
//}

//67. Write a C# Sharp program to create a coded string from a given string, using specified formula. 
//Replace all 'P' with '9', 'T' with '0', 'S' with '1', 'H' with '6' and 'A' with '8'.
//Sample Output:
//969
//J8V81CRI90

//68.Write a C# Sharp program to count a specified character (both cases) in a given string.


//Step 1 Understand question
//Step 2 Create string variable
//static int CountOfExerciseSixityEight(string exerciseSixtyEight)
//{
//    char[] exerciseSixtyeightArray = exerciseSixtyEight.ToCharArray();
//    char character = 'B';
//    int countchar = 0;

//    for (int i = 0; i < exerciseSixtyeightArray.Length; i++)
//    {
//        if (character.ToString().ToUpper() == exerciseSixtyeightArray[i].ToString().ToUpper())
//        {
//            countchar = countchar + 1;
//        }

//    }
//    return countchar;
//}

//Console.WriteLine("Enter a word");
//string exerciseSixtyeight = Console.ReadLine();
//int result = CountOfExerciseSixityEight(exerciseSixtyeight);

////Step 3 Split to another array


//Console.WriteLine(result);

//69. Write a C# Sharp program to check if a given string contains only lowercase or uppercase characters.

//Step 1 Create string
//Console.WriteLine("Enter a word");
//string exerciseSixtynine = Console.ReadLine();

////Step 2 Condition Check if string contains only lower || uppercase

//if (exerciseSixtynine==exerciseSixtynine.ToUpper() || exerciseSixtynine==exerciseSixtynine.ToLower())
//{
//    Console.WriteLine($"{exerciseSixtynine} contains either uppercase or lowercase only");
//}
//else
//{
//    Console.WriteLine($"{exerciseSixtynine} does not contain either uppercase or lowercase only");
//}

//70. Write a C# Sharp program to remove the first and last elements from a given string.

//Step 1 create string
//string exerciseSeventy = "hello";
//Console.WriteLine(exerciseSeventy.Substring(1, exerciseSeventy.Length - 2));

//Step 2 condition remove first exerciseSeventy[0] &exerciserSeventy[exerciseSeventy.Length]



//71. Write a C# Sharp program to check if a given string contains two similar consecutive letters.
//Step 1 Create string and initialize
//string exerciseSeventyone = "bba";

//Condition if string contains two similar consecuive letters. Eg aa

//static bool newTesting(string exerciseSeventyone)
//bool isConsecutive = false;
//for (int i = 0; i < exerciseSeventyone.Length - 1; i++)
//{
//    if (exerciseSeventyone[i] == exerciseSeventyone[i + 1])
//    {

//        isConsecutive = true;
//        break;

//    }

//}
//if (isConsecutive == true)
//{
//    Console.WriteLine("Yes");
//}
//else
//{
//    Console.WriteLine("No");
//}

//Practice question bonus Write a program to find a specified string from a string array. 

//string[] drinks = { "whisky", "tequila", "rum", "gin", "brandy" };
////Find if gin is in this array
//for (int i = 0; i < drinks.Length; i++)
//{
//    Console.WriteLine(drinks[i]);
//}
//Console.WriteLine();
//Console.WriteLine("Enter a drink");
//string drinkName= Console.ReadLine();

//bool drink = false;

//for (int i = 0; i < drinks.Length; i++)
//{
//    if (drinkName==drinks[i])
//    {
//        drink = true;
//        break; 
//    }
//}

//if (drink==true)
//{
//    Console.WriteLine($"{drinkName} is found");
//}
//else
//{
//    Console.WriteLine($"{drinkName} is not found");
//}

//72. Write a C# Sharp program to check whether the average value of the elements of
//a given array of numbers is a whole number or not. (Ask Abhay)
//Step 1 Create array

//int[] exerciseSeventytwo = { 4, 2, 0 };

////Step 2 Average value of given elements 

//for (int i = 0; i < exerciseSeventytwo.Length; i++)
//{
//    Console.WriteLine(exerciseSeventytwo.Average() % 1 == 0);
//}

//Console.WriteLine(exerciseSeventytwo.Average() % 1 == 0);

//int ex1 = 2;
//int ex2 = 3;
//int ex3 = 4;

//int sumAll = ex1 + ex2 + ex3;
//Console.WriteLine(sumAll.Average());

//73. Write a C# Sharp program to convert the letters of a given string (same case-upper/lower) into alphabetical order.

//Step 1 create string
string[] exerciseSeventythree = { "s,c,d,o" };

//Step 2 Convert letters in string to alphabetical order
for (int i = 0; i < exerciseSeventythree.Length; i++)
{
    exerciseSeventythree.OrderBy(i => i).ToArray();
}



