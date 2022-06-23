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
//string firstString = "palindrome";


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
string longSentenseWord = "Wow! coding is such a pain in the universe"; 
//Step 2 create array to split words in sentence
string [] sentenseSplit= longSentenseWord.Split(' ');
//Step 3 create integer array to get count of word
int[] arrayToCount = new int[sentenseSplit.Length];

//step 5 loop integer array with splited words array
for (int i = 0; i < arrayToCount.Length; i++)
{
    arrayToCount[i]=sentenseSplit[i].Length;
}
//step 6 create maximum count integer
int maxWordCount = 0;
// step 7 create index of longest word
int maxIndexWord = 0; 

//step 8 loop arraytocount and condition with maxwordcount
for (int i = 0; i < arrayToCount.Length; i++)
{
    if (arrayToCount[i]>maxWordCount)
    {
        maxWordCount = arrayToCount[i];
        maxIndexWord = i; 
    }
}

Console.WriteLine(maxWordCount);
Console.WriteLine("The longest word in  "+ longSentenseWord+ " is "+ sentenseSplit[maxIndexWord]);

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

//while (exercisetwentySeven>0)
//{
//    sumTwentyseven = sumTwentyseven + (exercisetwentySeven % 10);
//    exercisetwentySeven /= 10; 
//}
//Console.WriteLine("Sum of the integer is: "+ sumTwentyseven);

//28. Write a C# program to reverse the words of a sentence.

//string exerciseTwentyEight = "Reverse me";
//string[] wordsList = exerciseTwentyEight.Split(' ');
//Array.Reverse(wordsList);
//string reverseSentence = string.Join(" ", wordsList);
//Console.WriteLine(reverseSentence);

//29.Write a C# program to find the size of a specified file in bytes. (Ask Abhay)

//30. Write a C# program to convert a hexadecimal number to decimal number.(Ask Abhay)

//Step 1 what is hexadecimal? In mathematics and computing,
//the hexadecimal numeral system is a positional numeral system that represents numbers using a radix of 16
//what is decimal? relating to or denoting a system of numbers and arithmetic based on the number ten, tenth parts, and powers of ten.

//31.Write a C# program to multiply corresponding elements of two arrays of integers.
//Step 1- Create two integer arrays.

//int[] exerciseThirtyoneFirstArray =  { 5, 2, 6, 1 }; 
//int[] exerciseThirtyoneSecondArray= { 3, 4, 5, 6 };
////int[] exerciseThirtyoneMultiplied = { exerciseThirtyoneFirstArray[0] * exerciseThirtyoneSecondArray[0], exerciseThirtyoneFirstArray[1]*exerciseThirtyoneSecondArray[2], exerciseThirtyoneFirstArray[2]*exerciseThirtyoneSecondArray[2], exerciseThirtyoneFirstArray[3]*exerciseThirtyoneSecondArray[3] };

//// Step 2 Think about how to manually as a human multiply first index of first array with first index of second array

////Step 3 What are the steps repeating? Automate it. 
//for (int i = 0; i < exerciseThirtyoneFirstArray.Length; i++)
//{
//    Console.Write(exerciseThirtyoneFirstArray[i]* exerciseThirtyoneSecondArray[i]+ " ");
//}

//32. Write a C# program to create a new string of four copies, taking last four characters from a given string.
//If the length of the given string is less than 4 return the original one(Ask Abhay)

//Step 1 Create string

//Console.WriteLine("Enter a sentence");
//string exerciseThirtytwo = Console.ReadLine();
//string exerciseThirtytwoLastfour; 

//for (int i = 0; i < 4; i++)
//{
//    if (exerciseThirtytwo.Length<4)
//    {
//        Console.WriteLine(exerciseThirtytwo);
//        break; 
//    }
//    else
//    {
//        Console.Write(exerciseThirtytwoLastfour = exerciseThirtytwo.Substring(exerciseThirtytwo.Length - 4));
//    }

//}

//33.Write a C# program to check if a given positive number is a multiple of 3 or a multiple of 7.
//Step 1 create variable with positive number

//Console.WriteLine("Enter a number :");
//int exerciseThirtyThree = int.Parse(Console.ReadLine());
////Step 2 Identify logic numbers that multiply with 3 or 7
//// 3*3*3 || 7*7*7

//if (exerciseThirtyThree%3==0 || exerciseThirtyThree%7==0)
//{
//    Console.WriteLine(exerciseThirtyThree+ " is a multiple of 3 or 7" );
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
//Console.WriteLine("Enter a word:");
//string enterWord= Console.ReadLine();
//string exerciseThirtyfour = "Happy Tuesday"; 
//string [] sentenceSplittingone = exerciseThirtyfour.Split(' ');

////for (int i = 0; i < sentenceSplittingone.Length; i++)
////{
////    Console.WriteLine(sentenceSplittingone[i]);
////}


//    if (sentenceSplittingone[0]==enterWord)
//    {
//        Console.WriteLine("True");
//    }
//    else
//    {
//        Console.WriteLine("False");
//    }

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
//if ((exerciserThirtysixInt1>=-10 && exerciserThirtysixInt1<=10) || exerciserThirtysixint2>=-10 && exerciserThirtysixint2<=10 )
//{
//    Console.WriteLine("True");
//}
//else
//{
//    Console.WriteLine("False");
//}

//37.Write a C# program to check if "HP" appears at second position in a string and returns the string without "HP".(Ask Abhay)
//Step 1- Create string with HP 

//Console.WriteLine("Enter a sentence ");
//string exerciseThirtyseven = Console.ReadLine();


////Step 2 - Condition if "HP" appears at second position in string, return string without "HP"
////Check it first as a human

//if (exerciseThirtyseven.Substring(1, 2) == ("HP"));
//{
//    Console.WriteLine(exerciseThirtyseven.Remove(1, 2));
//}
//38. Write a C# program to get a new string of two characters from a given string.
//The first and second character of the given string must be "P" and "H", so PHP will be "PH".

//Step 1 Read the question
//Step 2 Arrange manually
//string exerciseThirtyeightstring = "PHR";  // Return 
//string exerciseThirtyeightnewstring="";
////New string should return "PH"
//if (exerciseThirtyeightstring.Length>1 && exerciseThirtyeightstring[0]=='P')
//{
//    exerciseThirtyeightnewstring = exerciseThirtyeightnewstring + exerciseThirtyeightstring[0]; 

//}
//if (exerciseThirtyeightstring.Length > 2 && exerciseThirtyeightstring[1] == 'H')
//{
//    exerciseThirtyeightnewstring = exerciseThirtyeightnewstring + exerciseThirtyeightstring[1];

//}
//Console.WriteLine(exerciseThirtyeightnewstring);

//40. Write a C# program to check the nearest value of 20 of two given integers and return 0 if two numbers are same. 

//Step 1 Read & understand question
//Step 2 Nearest value of 20 (19,18  21 22) 
////Create two integers
//int exerciseFourtyInt1 = 12;
//int exerciseFourtyInt2 = 21;
////Condition (Ask Abhay)
//if (exerciseFourtyInt1==exerciseFourtyInt2)
//{
//    Console.WriteLine("0"); 
//}
//else if (exerciseFourtyInt1<=20 && (exerciseFourtyInt1>exerciseFourtyInt2))
//{
//    Console.WriteLine(exerciseFourtyInt1);
//}
//else if (exerciseFourtyInt2<=20 && exerciseFourtyInt2>exerciseFourtyInt1)
//{
//    Console.WriteLine(exerciseFourtyInt2);
//}

//41.Write a C# program to check if a given string contains ‘w’ character between 1 and 3 times.(Ask Abhay)
//Step 1 create string
//string exerciserFourtyone = "w hotel";
//int countletter = 0; 
////Step 2 condidion 
//if (exerciserFourtyone.Substring=='')
//{

//}

//42. Write a C# program to create a new string where the first 4 characters will be in lower case.(Ask Abhay)
//If the string is less than 4 characters then make the whole string in upper case.

//Step 1 create string
//Console.WriteLine("Enter your text");
//string exerciseFourtyTwo = Console.ReadLine();
//string [] exerciserFourtyTwoArray= exerciseFourtyTwo.Split(' ');
//string exerciseFourtyTwonew;
//if (exerciseFourtyTwo.Length<=4)
//{
//    exerciseFourtyTwonew = exerciseFourtyTwo.ToUpper();
//    Console.WriteLine(exerciseFourtyTwonew);
//}


//else if (exerciseFourtyTwo.Length>4)
//{
//    for (int i = 0; i < exerciserFourtyTwoArray.Length; i++)
//    {
//        Console.WriteLine(exerciseFourtyTwo[0], exerciseFourtyTwo[1]
//    }
//}   

//43 Write a C# program to check if a given string starts with "w" and immediately followed by two "ww"(Ask Abhay)
//Step 1 Arrange 
//string exerciserFourtyThree = "www world";
////Step 2 Act 
//int countWw = 0;

//for (int i = 0; i < exerciserFourtyThree.Length-1; i++)
//{
//    if (exerciserFourtyThree[i].Equals('w') && exerciserFourtyThree.Substring(i,2).Equals("ww"))
//    {
//        countWw = countWw + 1; 
//    }
//}
//if (countWw>2)
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

//45 Write a C# program to count a specified number in a given array of integers.(Ask Abhay)
//Step 1 create integer array

//int[] exerciseFourtyfive = { 2, 30, 20, 3, 5,9 };

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
Console.WriteLine("Enter a number");
int exerciseFourtysix = int.Parse(Console.ReadLine());
//Step 2 create array
int[] exerciseFourtysixarray = { 3, 4, 5, 6, 7, 8, 2 };
//Step 3 condition- Check if integer exerciserFourtysix is either First exerciseFourtysixarray[0] || exerciserFourtysixarray[exerciseFourtysixarray.Length]

for (int i = 0; i < exerciseFourtysixarray.Length; i++)
{
    if (exerciseFourtysix==exerciseFourtysixarray[0] || exerciseFourtysix == exerciseFourtysixarray[exerciseFourtysixarray.Length-1])
    {
        Console.WriteLine("Yes");
        break; 
    }
    else
    {
        Console.WriteLine("No");
        break; 
    }
}