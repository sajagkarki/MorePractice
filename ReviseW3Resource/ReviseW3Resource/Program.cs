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

//6. Write a C# Sharp program to print the output of multiplication of three numbers which will be entered by the user.
//Step 1 Create three integers

//Console.WriteLine("Enter First Number");
//int ExerciseSixFirstNumber = int.Parse(Console.ReadLine());
//Console.WriteLine("Enter Second Number");
//int ExerciseSixSecondNumber = int.Parse(Console.ReadLine());
//Console.WriteLine("Enter Third Number");
//int ExerciseSixThirdNumber= int.Parse(Console.ReadLine());

//int MultiplyAll= ExerciseSixFirstNumber*ExerciseSixSecondNumber*ExerciseSixThirdNumber;
//Console.WriteLine(MultiplyAll);

//7. Write a C# Sharp program to print on screen the output of adding, subtracting, multiplying and
//dividing of two numbers which will be entered by the user.

//Step 1 Create two integers
//Console.WriteLine("Enter first number");
//int exerciseSevenUserinput1= int.Parse(Console.ReadLine());

//Console.WriteLine("Enter second number");
//int exerciseSevenuserinput2= int.Parse(Console.ReadLine());

////Add formulas

//int sumExerciseSeven = exerciseSevenUserinput1 + exerciseSevenuserinput2; 
//int subtractExerciseSeven= exerciseSevenUserinput1 - exerciseSevenuserinput2;
//int multiplyExerciseSeven= exerciseSevenUserinput1* exerciseSevenuserinput2;
//int divideExerciseSeven = exerciseSevenUserinput1 / exerciseSevenuserinput2;

//Console.WriteLine(sumExerciseSeven);
//Console.WriteLine(subtractExerciseSeven);
//Console.WriteLine(multiplyExerciseSeven);
//Console.WriteLine(divideExerciseSeven);

//8. Write a C# Sharp program that takes a number as input and print its multiplication table. 

//Console.WriteLine("Enter a number");
//int exerciseEightUserinput= int.Parse(Console.ReadLine());

////manually


////use loop
//for (int i = 1; i <= 12; i++)
//{
//    Console.WriteLine(exerciseEightUserinput*i); 
//}

//9. Write a C# Sharp program that takes four numbers as input to calculate and print the average.
//Create integers
//int a = 2;
//int b = 3;
//int c = 4;
//int d = 5;

//int average = (a + b + c + d) / 4; 
//Console.WriteLine(average);

//10. Write a C# Sharp program that takes three numbers(x,y,z) as input and print the output of (x+y).z and x.y + y.z.
//Create variables

//int x = 1;
//int y = 2;
//int z = 3;

//int outPut1 = (x + y)*z;
//int outPut2 = (x*y) + (y*z);

//Console.WriteLine(outPut1);
//Console.WriteLine(outPut2);

//11. Write a C# Sharp program that takes an age (for example 20) as input and prints something as "You look older than 20".
//Create interger 
//Console.WriteLine("What is you age?");
//int ageInput= int.Parse(Console.ReadLine());


//    Console.WriteLine("You look older than 20");

/*12.Write a C# program to that takes a number as input and display it four times in 
 * a row (separated by blank spaces), and then four times in the next row, with no separation. 
 * You should do it two times: Use Console. Write and then use {0}. Go to the editor
Test Data:
Enter a digit: 25
Expected Output:
25 25 25 25
25252525
25 25 25 25
25252525
*/
//Arrage
//Console.WriteLine= ("Enter a number")
//var exerciseTwelve = int.Parse(Console.ReadLine());
////Act
//for (int i = 1; i <4 ; i++)
//{
//    Console.WriteLine(exerciseTwelve);
//}
//for (int i = 1; int i <=4; int i++)
//{
//    Console.Write(exerciseTwelve)
//}

//Assert


//13. Write a C# program that takes a number as input and then displays a rectangle of 3 columns wide and 5 rows tall using that digit.
//333
//3 3
//3 3
//3 3
//333


//Console.WriteLine("Enter your number");
//int exerciseThirteen = int.Parse(Console.ReadLine());

//for (int j = 0; j < 5; j++)
//{
//    for (int i = 0; i < 3; i++)
//    {
//        Console.Write(exerciseThirteen);
//        Console.Write(" ");
//    }
//    Console.WriteLine();
//}

//14. Write a C# program to convert from celsius degrees to Kelvin and Fahrenheit. 



//Console.WriteLine("Enter your number in celsius");
//int userInputCelcius= int.Parse(Console.ReadLine());

//formula multiply by 1.8 & add 32  (userInput*1.8)+ 32
//int toFahrenheit = userInputCelcius * 9 / 5 + 32;
//int converttoKelvin= celciusDegrees+273
//Console.WriteLine($"{userInputCelcius} degrees celcius equals {toFahrenheit}");

//15. Write a C# program to remove specified a character from a non-empty
//string using index of a character. 

//Arrange
//string exerciseFifteen = "hello";
////Act
//Console.WriteLine(exerciseFifteen[1]);
////Assert















//Create string
//Console.WriteLine("Enter a word");
//string exerciseFifteen = Console.ReadLine();
//Console.WriteLine("Enter a letter you want to remove");
//string characterToRemove = Console.ReadLine();

//int indexOfCharacterToRemove= exerciseFifteen.IndexOf(characterToRemove);
////Console.WriteLine(indexOfCharacterToRemove);

//string result = exerciseFifteen.Remove(indexOfCharacterToRemove,1);
//Console.WriteLine(result);

//16.Write a C# program to create a new string from a given string where the first and last
//characters will change their positions.
//Test Data:
//w3resource
//Python
//Sample Output:
//e3resourcw
//nythoP

//Arrange
//string exerciseSixteen= "hello";
//var temp;

////Act
//exerciseSixteen[0] = temp; 
//exerciseSixteen[exerciseSixteen.Length - 1] = exerciseSixteen[0];
//temp= exerciseSixteen[exerciseSixteen.Length-1]

//Console.WriteLine(temp);

//Assert











//Step 1 crete string variable
//string exerciseSixteen = "malt";


////Solve manually
//char firstCharacter= exerciseSixteen[0];
//char lastCharacter = exerciseSixteen[exerciseSixteen.Length-1];

//string newString = $"{lastCharacter}{exerciseSixteen.Substring(1,exerciseSixteen.Length-2)}{firstCharacter}";
//Console.WriteLine(newString);

//17.Write a C# program to create a new string from a given string (length 1 or more ) with the
//first character added at the front and back.


//Step 1 read & understand question
//Step 2 Create string
//string exerciseSeventeen = "L"; 
//string resultString;
////Do it manually
//char firstCharacterExerciseSeventeen = exerciseSeventeen[0]; 
//char lastCharacterExerciseSeventeen= exerciseSeventeen[exerciseSeventeen.Length-1];
//if (exerciseSeventeen.Length>=1)
//{
//    resultString = $"{firstCharacterExerciseSeventeen}{exerciseSeventeen}{firstCharacterExerciseSeventeen}";
//    Console.WriteLine(resultString);
//}
//else
//{
//    Console.WriteLine("Enter stirng with at least one character ");
//}

//18. Write a C# program to check two given integers and return true if one is negative and one is positive.

//Arrange
var firstNumber = -2; 
var secondNumber = 3;

//Act
if ((firstNumber>0 && secondNumber<0) ||(firstNumber<0 && secondNumber>0))
{
    Console.WriteLine("True");
}
else
{
    Console.WriteLine("False");
}
//Assert














//Step 1 Read & understand question
//Step 2 Create two integers
//int exerciseEighteenOne = 4; 
//int exerciseEighteenTwo = 5;

////Step 3 condition Return true if one is negative && one is positive

//if (exerciseEighteenOne>0 && exerciseEighteenTwo<0)
//{
//    Console.WriteLine("True");
//}
//else
//{
//    Console.WriteLine("False");
//}

// 19. Write a C# program to compute the sum of two given integers, if two values are equal then return the triple of their sum.
//Step 1 create two integers
//int exerciseNineteenOne = 2; 
//int exerciseNineteenTwo = 2;

////Step 2 condition if two integers are equal , return tripple of their sum

//if (exerciseNineteenOne==exerciseNineteenTwo)
//{
//    Console.WriteLine((exerciseNineteenOne+exerciseNineteenTwo)*3);
//}
//else
//{
//    Console.WriteLine("Two numbers are not equal, enter another number");
//}

//20. Write a C# program to get the absolute value of the difference between two given numbers.
//Return double the absolute value of the difference if the first number is greater than second number.

//Step 1 Initiate integers
//int exerciseTwentyFirst = 5;
//int exerciseTwentySecond = 3;

//if (exerciseTwentyFirst>exerciseTwentySecond)
//{
//    Console.WriteLine((exerciseTwentyFirst-exerciseTwentySecond)*2*-1);
//}
//else
//{
//    Console.WriteLine((exerciseTwentyFirst - exerciseTwentySecond) * -1); 
//}

//21. Write a C# program to check the sum of the two given integers and return true if one of the integer is 20 or if their sum is 20.
//Step 1 Create two integers
//int exerciseTwentyoneFirst = 20;
//int exerciseTwentyoneSecond = 2;

////Step 2 sum of integers
//int sumOfIntegers = exerciseTwentyoneFirst + exerciseTwentyoneSecond;

////Step 3 condition Rtrun true if one of the integer is 20 || is their sum is 20

//if (exerciseTwentyoneFirst==20||exerciseTwentyoneSecond==20|| sumOfIntegers==20)
//{
//    Console.WriteLine("True");
//}

//22. Write a C# program to check if an given integer is within 20 of 100 or 200. 

//Step 1 create integer 
//int exerciseTwentytwo = 220;

//Step 2 condition if integer is within 20 of 100(80 to 129 )|| 200(180 to 220)

//if (exerciseTwentytwo>=80 && exerciseTwentytwo<=120 || exerciseTwentytwo>=180 && exerciseTwentytwo<=220)
//{
//    Console.WriteLine($"{exerciseTwentytwo} is within 20 of 100 or 200");
//}
//else
//{
//    Console.WriteLine($"{exerciseTwentytwo} is out of range, try another number");
//}

//23.Write a C# program to convert a given string into lowercase.
//Step 1 Read the question and understadn
//Step 2 initialize 
//string exerciseTwentyThree = "Hello Salt Lake City"; 
////Step 3 condition convert string to lowercase
//string lowerCaseString= exerciseTwentyThree.ToLower();
//Console.WriteLine(lowerCaseString);

//24.Write a C# program to find the longest word in a string.
//Step 1 understand question 
//Step 2 intialize 
//string exerciseTwentyFourWord = "Mirror mirror on the visual studio longest word of them all ";
////Step 3 Condition Find the longest word in a string.
////Step 4 do it manually-how I cound each word between spaces. 
////Step 5 Split the string 
//string[] splitString = exerciseTwentyFourWord.Split(' '); 

////Step 5 Create array to count
//int[] wordLength= new int[splitString.Length];

////Step 6 loop integer array with splited array

//for (int i = 0;i<wordLength.Length;i++)
//{
//    wordLength[i] = splitString[i].Length; 
//}
////Step 7 Create maximum counter interer
//int maxCount = 0;

////Step 7 Condition if wordlength is greater than max count, it is the longest word
////Step 8 create index of max length word
//int maxIndexword = 0;

//for (int i = 0; i < wordLength.Length; i++)
//{
//    if (wordLength[i] > maxCount)
//    {
//        maxCount = wordLength[i];
//        maxIndexword = i;
//    }

//}
//Console.WriteLine(maxCount);
//Console.WriteLine($"The longest word in {exerciseTwentyFourWord} is {splitString[maxIndexword]}");

//25. Write a C# program to print the odd numbers from 1 to 99. Prints one number per line.
//Step 1 Read and undersand question 
//Step 2 Condition print odd numbers from 1 to 99

//for (int i = 0; i < 100; i++)
//{
//    if (i%2!=0)
//    {
//        Console.WriteLine(i);
//    }
//}

//26. Write a C# program to compute the sum of the first 500 prime numbers.(Do next week, Abhay)
//Prime is divisible only by itself or 1
//int [] identifyPrime= { 1, 2, 3, 5, 7 }


//Step 1 Identify prime numbers manuall

//for (int i = 0; i < identifyPrime.Length; i++)    

//}

//27. Write a C# program and compute the sum of the digits of an integer.
//Step 1 - Read and understand question
//Step 2- Create integer 
//int exerciseTwentySix = 234;
//int sum = 0;

//for (int i = 0; i < exerciseTwentySix; i++)
//{
//    sum = sum + i;
//}
//Console.WriteLine(sum);

//Console.WriteLine("Enter your number");
//int exercisetwentySeven = int.Parse(Console.ReadLine());
//int sumTwentyseven = 0;

//while (exercisetwentySeven > 0)
//{
//    sumTwentyseven = sumTwentyseven + (exercisetwentySeven % 10);
//    exercisetwentySeven = exercisetwentySeven / 10;
//}
//Console.WriteLine("Sum of the integer is: " + sumTwentyseven);

////Step 3-Condition Compute sum of the digits of an integer

//28. Write a C# program to reverse the words of a sentence.
//Step 1 Read and understand question
//Step 2 create string variable 
//Console.WriteLine("Enter a sentence");
//string exerciseTwentyEightSentence = Console.ReadLine();
//Step 3 Condition Reverse words of the sentence Friday Relaxing
//string[] splitSentence = exerciseTwentyEightSentence.Split(' ');
//for (int i = 0; i < splitSentence.Length; i++)
//{
//    Console.WriteLine(splitSentence[i]);
//}
//Array.Reverse(splitSentence);
////Step 4 create reverse string
//string reverseSentence= string.Join(" ", splitSentence);
//Console.WriteLine(reverseSentence);

//29. Write a C# program to find the size of a specified file in bytes.
//Step 1 Understand question
//Step 2 Condition program to find the size of specified file in byte

//FileInfo exerciseTwentynine= new FileInfo(@"C:\SharpernCSharp\Dummy.docx");
//Console.WriteLine(exerciseTwentynine.Length);

//30. Write a C# program to convert a hexadecimal number to decimal number.
//int exerciserThirty = 400;
//Console.WriteLine(exerciserThirty.ToString("X"));

//string convertToDecimal = "1024";
//Console.WriteLine(Convert.ToInt32(convertToDecimal,16));

//31. Write a C# program to multiply corresponding elements of two arrays of integers.
//Step 1 Read and understand the question. multiply corresponding elements in two arrays

//Step 2 Condition multiply corresponding elements in two arrays
//Create two int arrays
//int[] exerciseThirtyOneFirstArray = { 2, 4,3};
//int[] exerciseThirtyTwoSecondArray ={ 1, 2,2};
//int[] multiplyCorrespondingElements = { (exerciseThirtyOneFirstArray[0] * exerciseThirtyTwoSecondArray[0]), (exerciseThirtyOneFirstArray[1]*exerciseThirtyTwoSecondArray[1])};

//for (int i = 0; i <exerciseThirtyOneFirstArray.Length; i++)
//{
//    Console.Write($"{exerciseThirtyOneFirstArray[i]*exerciseThirtyTwoSecondArray[i]} ");
//}


//Step 3 do it manually
//for (int i = 0; i < exerciseThirtyOneFirstArray.Length; i++)
//{
//    //multiplyCorrespondingElements = exerciseThirtyOneFirstArray[i] * exerciseThirtyTwoSecondArray[i]; 
//}
//2*3=6
//4*2=8

//32. Write a C# program to create a new string of four copies, taking last four characters
//from a given string. If the length of the given string is less than 4 return the original one.
//Step 1 Read and understand question
//Step 2 create string
//string exerciseThirtyTwo = "Power";
//Step 3 Condition Create new string of four copies taking last four characters
//Step 4 do it manully // owerowerowerowerower

//Console.Write(exerciseThirtyTwo[1]);
//Console.Write(exerciseThirtyTwo[2]);
//Console.Write(exerciseThirtyTwo[3]);
//Console.Write(exerciseThirtyTwo[4]);

//for (int i = 1; i < exerciseThirtyTwo.Length; i++)
//{
//    Console.Write(exerciseThirtyTwo[i]);
//}
//for (int i = 1; i < exerciseThirtyTwo.Length; i++)
//{
//    Console.Write(exerciseThirtyTwo[i]);
//}
//for (int i = 1; i < exerciseThirtyTwo.Length; i++)
//{
//    Console.Write(exerciseThirtyTwo[i]);
//}
//for (int i = 1; i < exerciseThirtyTwo.Length; i++)
//{
//    Console.Write(exerciseThirtyTwo[i]);
//}

//Step 5 Automate the manual code

//for (int j = 0; j < 4; j++)
//{
//    for (int i = 1; i < exerciseThirtyTwo.Length; i++)
//    {
//        Console.Write(exerciseThirtyTwo[i]);
//    }
//}

//Step 6 Condition If length of given string is less than 4 return the original one, 

//33. Write a C# program to check if a given positive number is a multiple of 3 or a multiple of 7.
//Step 1 Read and understand question
//Step 2 Create int variable
//Console.WriteLine("Enter a number");
//int exerciseThirtyThree = int.Parse(Console.ReadLine());

//Step 3 Condition if given integer is positive it is a multiple of 3 or 7


//if (exerciseThirtyThree % 3 == 0 || exerciseThirtyThree % 7 == 0)
//{
//    Console.WriteLine($"{exerciseThirtyThree} is a multiple of either 3 or 7");
//}

//else
//{
//    Console.WriteLine($"{exerciseThirtyThree} is not a multiple of either 3 or 7");
//}

//34. Write a C# program to check if a string starts with a specified word.
//Step 1 Read and understand question. 
//Check if string starts with a certain word. For example  lovely life string starts with l yes

//Step 2 Create string, create word variable string

//Console.WriteLine("Enter a sentence");
//string exerciseThirtyFour= Console.ReadLine();
//Console.WriteLine("Enter a word");
//string word = Console.ReadLine();

//string [] splitSentence= exerciseThirtyFour.Split(' ');

//for (int i = 0; i <splitSentence.Length; i++)
//{
//    Console.WriteLine(splitSentence[i]);
//}

//if (word==splitSentence[0])
//{
//    Console.WriteLine("Match");
//}
//else
//{
//    Console.WriteLine("Does not match");
//}

//35. Write a C# program to check two given numbers where one is less than 100 and other is greater than 200.
//Step 1 Read and understand question
//Step 2 Create two integers

//int exerciseThirtyFiveFirstNumber = 101;
//int exerciseThirtyFiveSecondNumber = 220;

//Step 3 Condition if one number is less than 100 and other is greater than 200

//if (exerciseThirtyFiveFirstNumber<100 && exerciseThirtyFiveSecondNumber>200)
//{
//    Console.WriteLine($"{exerciseThirtyFiveFirstNumber} is less than 100, {exerciseThirtyFiveSecondNumber} is greater than 200");
//}

//36. Write a C# program to check if an integer (from the two given integers) is in the range -10 to 10.(Ask Abhay)
//Step 1 Read and understand the question
//Step 2 Create two integers 
//int exerciseThirtySixFirst = -19;
//int exercisethirtySixSecond = 19;

//Step 3 condition
//Check if integers is in the range of -10 to 10

//if (exerciseThirtySixFirst>=-10 && exerciseThirtySixFirst<=10 || exercisethirtySixSecond>=-10 && exercisethirtySixSecond<=10 )
//{
//    Console.WriteLine($"{exerciseThirtySixFirst} and {exercisethirtySixSecond} is in the range of -10 to 10");
//}

//37. Write a C# program to check if "HP" appears at second position in a string and returns the string without "HP".
//Method 1 String 

//Step 1 and understand question
//Step 2 Create variable 
//Console.WriteLine("Enter a sentence");
//string exerciseThirtySevenString = Console.ReadLine();

////Step 3 Condition Check if HP appears at the second position. 
//if (exerciseThirtySevenString.Substring(1, 2) == "HP")
//{
//    Console.WriteLine(exerciseThirtySevenString.Remove(1,2));
//}

//Method 2 Index
//Console.WriteLine("Enter a sentence");
//string exerciseThirtySevenSecondMethod= Console.ReadLine();

//if (exerciseThirtySevenSecondMethod.IndexOf("HP") == 1)
//{
//    Console.WriteLine(exerciseThirtySevenSecondMethod.Remove(1,2)); 
//}
//else
//{
//    Console.WriteLine(exerciseThirtySevenSecondMethod);
//}

//38. Write a C# program to get a new string of two characters from a given string.
//The first and second character of the given string must be "P" and "H", so PHP will be "PH".

//Step 1 read and understand question
//Create string 

//string exerciseThirtyeightstring = "PHRAT";  // Return 
//string exerciseThirtyeightnewstring = "";

////Method 1
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

//39.Write a C# program to find the largest and lowest values from three integer values.(Ask Abhay if code
//can be shortened)
//Step 1  Read and understand question
//Step 2  Create three integers and initiate

//int a = 7;
//int b = 5; 
//int c = 9;

//Step 3 Condition find the largest and the lowest values from the three integers
//For lowest
//if (a<b && a<c)
//{
//    Console.WriteLine("Lowest is " + a);
//}

//if (b<c&& b < c)
//{
//    Console.WriteLine("Lowest is " + b);
//}

//if (c<a && c<b)
//{
//    Console.WriteLine("Lowest is " + c);
//}
////For largest
//if (a>b && a>c)
//{
//    Console.WriteLine($"Highest is {a}");
//}
//if (b>a && b > c)
//{
//    Console.WriteLine($"Highest is {b}");
//}
//if (c>a && c>b)
//{
//    Console.WriteLine($"Higest is {c}");
//}

//40 Write a C# program to check the nearest value of 20 of two given integers and return 0 if two numbers are same.
//Step 1- Read and understand question
//Step 2- Create integers
//int exerciseFourtyFirstInt = 5; 
//int exerciseFourtySecondInt = 5;
////Step 3- Condition check the nearest value of 20 , return 0 if numbers are same

//if (exerciseFourtyFirstInt==exerciseFourtySecondInt)
//{
//    Console.WriteLine(0);
//}
//else
//{
//    if (exerciseFourtyFirstInt<20 && exerciseFourtyFirstInt>exerciseFourtySecondInt)
//    {
//        Console.WriteLine(exerciseFourtyFirstInt);
//    }
//    if (exerciseFourtySecondInt<20 && exerciseFourtySecondInt>exerciseFourtyFirstInt)
//    {
//        Console.WriteLine(exerciseFourtySecondInt);
//    }

//}

// 41.Write a C# program to check if a given string contains
// ‘w’ character between 1 and 3 times.
//Step 1- Read and understand question
//Step 2- Create string
//string exerciseFourtyOne = "cwwwabow";
//string[] exerciseFourtyOneSplit=exerciseFourtyOne.Split('w');

////Step 3- Condition Check if string contains the letter w between 1 to 3 times
//if (exerciseFourtyOneSplit.Length>1 && exerciseFourtyOneSplit.Length<4)
//{
//    Console.WriteLine("True");
//}
//else
//{
//    Console.WriteLine("false");
//}

//42. Write a C# program to create a new string where the first 4 characters will be in lower case.(Ask Abhay)
//If the string is less than 4 characters then make the whole string in upper case.

//Step 1- Read and understand question
//Step 2-Create string
//string exerciseFourtyTwo = "Lovely";
//string exerciseFourtyNewString = exerciseFourtyTwo.Substring(0, 4);
////Step 3- Condition. If string is less thatn 4 characters then make whole string upper case
////else create new string where first 4 characters will be lower case

//if (exerciseFourtyTwo.Length < 4)
//{
//    Console.WriteLine(exerciseFourtyTwo.ToUpper());
//}
//else if (exerciseFourtyNewString == exerciseFourtyNewString.ToLower()) ;
//{
//    Console.WriteLine(exerciseFourtyNewString);
//}

//43. Write a C# program to check if a given string starts with "w" and immediately followed by two "ww".

//Arrange: Perform the setup and initialization required for the test.
//string exerciseFourtyThree = "wwwarm";
////Act: Take action(s) required for the test.
//if (exerciseFourtyThree.Substring(0,1)=="w" && exerciseFourtyThree.Substring(1,2)=="ww")
//{
//    Console.WriteLine("Yes");
//}
//else
//{
//    Console.WriteLine("No");
//}
//Assert: Verify the outcome(s) of the test.

//44. Write a C# program to create a new string of every other character (odd position)from the first position of a given string.
//Step 1 Arrrange: Perform the setup and initialization required for the test
//string exerciseThirtyfour = "Laxmi Pooja";
//string newExerciseThirtyfour="";

////Step 2 Act: Take action(s) required for the test(Take every other character from the first position of string)
////LxiPoa

//for (int i = 0; i < exerciseThirtyfour.Length; i++)
//{
//    if (i%2==0)
//    {
//        newExerciseThirtyfour = newExerciseThirtyfour + exerciseThirtyfour[i]; 
//    }
//}
//Step 3 Assert:Verify the outcome(s) of the test
//Console.WriteLine(newExerciseThirtyfour);

//45. Write a C# program to count a specified number in a given array of integers
//Step 1 Arrange: Perform the setup and initialization required for the test
//int[] exericseFourtyFive = { 7, 1, 2, 7, };
//int specificNumber = 4; 
//int countNumbers=0;

////Step 2 Act: Take action(s) required for the test(Write code to count a specific number in array from 0 to 9)

//for (int i = 0; i < exericseFourtyFive.Length; i++)
//{
//    if (exericseFourtyFive[i]==specificNumber)
//    {
//        countNumbers = countNumbers + 1; 
//    }
//}
////Step 3 Assert: Verify the outcome(s) of the test
//Console.WriteLine(countNumbers);

//46. Write a C# program to check if a number appears as either the first or last element of an array
//of integers and the length is 1 or more.
//Arrange
//int[] exerciseFourtySix = { 7,3 };
//int checkNumber = 2;

////Act 
//if (exerciseFourtySix.Length<=1)
//{
//    Console.WriteLine("Array does not have more than one number");
//}
//else
//{
//    for (int i = 0; i < exerciseFourtySix.Length; i++)
//    {
//        if (checkNumber == exerciseFourtySix[0] || checkNumber == exerciseFourtySix[exerciseFourtySix.Length - 1])
//        {
//            Console.WriteLine($"{checkNumber} is either first or last of the array");
//            break;
//        }
//        else
//        {
//            Console.WriteLine($"{checkNumber} is neither first or last of the array");
//            break;
//        }
//    }

//}

//47.Write a C# program to compute the sum of all the elements of an array of integers.
//Arrange 
//int[] exerciseFourtySeven = { 7, 1, 2 };
//int sumExerciseFourtySeven = 0; 
////Act
//for (int i = 0; i < exerciseFourtySeven.Length; i++)
//{
//    sumExerciseFourtySeven=sumExerciseFourtySeven+ exerciseFourtySeven[i];
//}
//Assert
//Console.WriteLine(sumExerciseFourtySeven);

//48.Write a C# program to check if the first element
//and the last element are equal of an array of integers and the length is 1 or more.

//Arrange
//int[] exerciseFourtyEight = { 2, 7, 0, 2 };

////Act
//for (int i = 0; i < exerciseFourtyEight.Length; i++)
//{
//    if (exerciseFourtyEight.Length>1 && exerciseFourtyEight[0]==exerciseFourtyEight[exerciseFourtyEight.Length-1])
//    {
//        Console.WriteLine($"First and last element matches");
//        break;
//    }
//    else
//    {
//        Console.WriteLine($"First and last element does not matches");
//        break; 
//    }
//}

//50.Write a C# program to rotate an array (length 3) of integers in left direction.(Ask Abhay)

//Swap left solution
//Arrange
//int[] exerciseFifty = { 2, 7, 1 };
//int data = exerciseFifty[0];// data= 2

////Act 
//exerciseFifty[0] = exerciseFifty[1];//2=7
//exerciseFifty[1] = exerciseFifty[2];//7=1
//exerciseFifty[2] = data;//7=2

////Assert
//for (int i = 0; i < exerciseFifty.Length; i++)
//{
//    Console.WriteLine(exerciseFifty[i]);
//}

//Swap right solution 

//int[] exerciseFiftySwopRight = { 2, 7, 1 };
//int data = exerciseFiftySwopRight[2];// data= 1

////Act
//exerciseFiftySwopRight[2] = exerciseFiftySwopRight[1];//1=7
//exerciseFiftySwopRight[1] = exerciseFiftySwopRight[0];//7=1
//exerciseFiftySwopRight[0] = data; //2=1

//for (int i = 0; i < exerciseFiftySwopRight.Length; i++)
//{
//    Console.WriteLine(exerciseFiftySwopRight[i]);
//}

//51. Write a C# program to get the larger value between first and last element of
//an array (length 3) of integers.

//Arrange 
//int[] exerciseFiftyOne = { 6, 3, 9 };

//Act 
//for (int i = 0; i < exerciseFiftyOne.Length; i++)
//{
//    if (exerciseFiftyOne[0]>exerciseFiftyOne[exerciseFiftyOne.Length-1])
//    {
//        Console.WriteLine($"First number in the array is larger than the last");
//        break; 
//    }
//    else
//    {
//        Console.WriteLine($"Last number in the array is larger than the first");
//        break; 
//    }
//}

//52.Write a C# program to create a new array of length containing
//the middle elements of three arrays (each length 3) of integers.

//Arrange 
//int[] exerciseFiftyTwoArray1 = { 9, 2, 4 }; 
//int[] exerciseFiftyTwoArray2= { 6, 7, 1 };
//int[] exerciseFiftyTwoArray3 = { 7, 4, 3 };


////Act
//for (int i = 0; i < exerciseFiftyTwoArray1.Length; i++)
//{
//    int[] exerciseFityTwoNewArray = { exerciseFiftyTwoArray1[1], exerciseFiftyTwoArray2[1], exerciseFiftyTwoArray3[1]};
//    //Assert
//    Console.Write($"{exerciseFityTwoNewArray[i]} ");
//}

//53. Write a C# program to check if an array contains an odd number.

//Arrange
//int[] exerciseFiftyThree = { 4, 6, 2 };

////Act
//for (int i = 0; i <exerciseFiftyThree.Length ; i++)
//{
//    if (exerciseFiftyThree[i]%2 !=0)
//    {
//        Console.WriteLine($"The array contains at least one odd number");
//        break; 
//    }
//    else
//    {
//        Console.WriteLine("The array does not contain any odd numbers");
//        break; 
//    }
//}

//54.Write a C# program to get the century from a year.
//Arrange
//int exerciseFiftyFourYear = 2022;

////Act
//if (exerciseFiftyFourYear<2000)
//{
//    Console.WriteLine($"{exerciseFiftyFourYear} is before 21st century");
//}
//else
//{
//    Console.WriteLine($"{exerciseFiftyFourYear} is the 21st century");
//}

//55. Write a C# program to find the pair of adjacent elements that has the largest product(Ask Abhay)
//My Code
//Arrange
//int[] exerciseFiftyFiveArrayPractice = { 3, 1, 4,2 };
//int maxAdjacent = exerciseFiftyFiveArrayPractice[0] * exerciseFiftyFiveArrayPractice[1];
//int maxAdjacent1;

////Act
//for (int i = 1; i < exerciseFiftyFiveArrayPractice.Length-1; i++)
//{
//    maxAdjacent1 = exerciseFiftyFiveArrayPractice[i] * exerciseFiftyFiveArrayPractice[i + 1]; 
//    maxAdjacent= Math.Max(maxAdjacent, maxAdjacent1);
//}
////Assert
//Console.WriteLine($"The maximum adjacent value is {maxAdjacent}");

//Abhay's code
//Arrange
//int[] exerciseFityFiveArray = { 2, 1, 4,0,6,10};
//int maxValue = exerciseFityFiveArray[0] * exerciseFityFiveArray[1];

//for (int i = 1; i < exerciseFityFiveArray.Length-1 ; i++)
//{
//    int maxValue2 = exerciseFityFiveArray[i] * exerciseFityFiveArray[i+1];
//    maxValue= Math.Max(maxValue, maxValue2); 
//}
//Console.WriteLine($"Maximum value is {maxValue}");


//56. Write a C# program to check if a given string is a palindrome or not.

//Arrange
//string exerciseFiftySixWord = "kana";

////Act 
//for (int i = 0; i <exerciseFiftySixWord.Length; i++)
//{
//    if (exerciseFiftySixWord[i]!=(exerciseFiftySixWord[exerciseFiftySixWord.Length-1-i]))
//    {
//        Console.WriteLine($"{exerciseFiftySixWord} is not a palnindrome");
//        break; 
//    }
//    else
//    {
//        Console.WriteLine($"{exerciseFiftySixWord} is a palnindrome");
//        break; 
//    }
//}




//Assert


//Write a method that accepts a string as a parameter and check that string to see if it is a palindrome.
//Return boolean true if it is a palindrome, false if it is not.

//Arrange 
//static void Main(string[] args)

//    bool wordResult;
//    wordResult = word("kayak");
//    Console.WriteLine(wordResult);
//    //Console.ReadLine();


//static bool word(string wrd)

//{
//    //int length = wrd.Length / 2;
//    for (int i = 0; i < wrd.Length; i++)
//    {
//        if (wrd[i] != (wrd[wrd.Length - 1 - i])) //standard practice to use equals in C#
//        {
//            return false;
//        }
//    }
//    return true;
//}

//57. Write a C# program to find the pair of adjacent elements that has the highest product
//of an given array of integers.

//int[] exerciseFiftyFiveArrayPractice = { 3, 1, 4,2 };
//int maxAdjacent = exerciseFiftyFiveArrayPractice[0] * exerciseFiftyFiveArrayPractice[1];
//int maxAdjacent1;

////Act
//for (int i = 1; i < exerciseFiftyFiveArrayPractice.Length-1; i++)
//{
//    maxAdjacent1 = exerciseFiftyFiveArrayPractice[i] * exerciseFiftyFiveArrayPractice[i + 1]; 
//    maxAdjacent= Math.Max(maxAdjacent, maxAdjacent1);
//}
////Assert
//Console.WriteLine($"The maximum adjacent value is {maxAdjacent}");

//58. Write a C# program which will accept a list of integers and checks how many integers
//are needed to complete the range. 

//Arrange

//int[] exerciseFiftyEight = { 4, 7, 9 };
//int maxExerciserFiftyEight = 0;
//int minExerciseFiftyEight = int.MaxValue; 

////Act
//for (int i = 0; i < exerciseFiftyEight.Length; i++)
//{
//    if ( exerciseFiftyEight[i]> maxExerciserFiftyEight)
//    {
//        maxExerciserFiftyEight =exerciseFiftyEight[i]; 
//    }
//}

//for (int i = 0; i < exerciseFiftyEight.Length; i++)
//{
//    if (exerciseFiftyEight[i]< minExerciseFiftyEight)
//    {
//        minExerciseFiftyEight = exerciseFiftyEight[i]; 
//    }
//}

////Assert
//Console.WriteLine((maxExerciserFiftyEight-minExerciseFiftyEight)-exerciseFiftyEight.Length+1); 

//59. Write a C# program to check whether it is possible to create a strictly increasing
//sequence from a given sequence of integers as an array.(Ask Abhay)

//Arrange

//60. Write a C# program to calculate the sum of all the integers of a rectangular matrix except those integers which are located below an intger of value 0.(Ask Abhay)
//61,62 Ask Abhay

//63. Write a C# program to check if a given number is present in an array of numbers. 

//Arrange 
//int[] exerciseSixtyThree = { 7, 2, 1 };
//int numberPresentOrNot = 3;

////Act
//for (int i = 0; i < exerciseSixtyThree.Length; i++)
//{
//    if (exerciseSixtyThree[i]==numberPresentOrNot)
//    {
//        Console.WriteLine($"{numberPresentOrNot} is present in the array");
//        break; 
//    }
//    else
//    {
//        Console.WriteLine($"{numberPresentOrNot} is not present in the array");
//        break; 
//    }
//}

//64. Write a C# Sharp program to get the file name (including extension) from a given path.(Ask Abhay)

//Arrange
//string filePath = "C:/SharpernCSharp";

//65.Write a C# Sharp program to multiply all of elements of a given array of numbers
//by the array length.

//Arrange
//int[] exerciseSixtyFive = { 4, 2, 1, 3 };

////Act
//for (int i = 0; i < exerciseSixtyFive.Length; i++)
//{
//    Console.WriteLine(exerciseSixtyFive.Length * exerciseSixtyFive[i]);
//}

//66. Write a C# Sharp program to find the minimum value from two given two numbers,
//represented as string.

////Arrange
//var firstNumber = "4"; 
//var secondNumber ="6";

////Act
//int toInt1= int.Parse(firstNumber);
//int toInt2= int.Parse(secondNumber);    

//if (toInt1<toInt2)
//{
//    Console.WriteLine($"{toInt1} is the minimum value among the two numbers");
//}
//else
//{
//    Console.WriteLine($"{toInt2} is the minimum value among the two numbers");
//}

//67. Write a C# Sharp program to create a coded string from a given string, using specified formula.(Ask Abhay)
//Go to the editor
//Replace all 'P' with '9', 'T' with '0', 'S' with '1', 'H' with '6' and 'A' with '8'.
//Sample Output:
//969
//J8V81CRI90

//Arrange 
//string exerciseSixtySeven = "PARROT";
////string newExerciseSixtySeven;
////Act

//exerciseSixtySeven.Replace("P", "9").Replace("T", "0").Replace("S", "1").Replace("H", "6").Replace("A", "8"); 
////Assert
////newExerciseSixtySeven=exerciseSixtySeven;

//Console.WriteLine(exerciseSixtySeven);

//68.Write a C# Sharp program to count a specified character (both cases) in a given string.

//Arrange
//string exerciseSixtyEight = "world cup fun";
//int countStringCharcter = 0;
//Console.WriteLine("Enter an alphabet");
//string alphabet= Console.ReadLine();

////Act 
//for (int i = 0; i < exerciseSixtyEight.Length; i++)
//{
//    if (alphabet.ToString().ToLower()== exerciseSixtyEight[i].ToString().ToLower())
//    {
//        countStringCharcter= countStringCharcter+1; 
//    }

//}


////Assert
//Console.WriteLine(countStringCharcter);

//Leet

//1.Two sum Ask Abhay

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

//You may assume that each input would have exactly one solution, and you may not use the same element twice.

//int[] nums = { 7, 1, 3, 2,4 };
//int target = 5;

//for (int j = 0; j < nums.Length; j++)
//{
//    for (int i = j+1; i < nums.Length; i++)
//    {
//        if (nums[j]+nums[i]==target)
//        {
//            Console.WriteLine($"{j},{i}");

//        }

//    }
//}




int[] nums = { 4, 2, 1, 9 };
int target = 3;

for (int j = 0; j < nums.Length; j++)
{
    for (int i = j + 1; i < nums.Length; i++)
    {
        if (nums[j] + nums[i] == target)
        {
            //Console.WriteLine($"{nums[j]} -{nums[i]}");
            Console.WriteLine($"{j} & {i}");
        }
    }
}

//int[] nums =[1, 2, 3, 6];
//int target = 7;

//for (int j = 0; i < nums.length; i++)
//{
//    for (int i = j + 1; i < nums.length; i++)
//    {
//        if (nums[j] + nums[i] == target)
//        {

//        }
//    }
//}

//for (int i = 2; i < nums.length; i++)
//{
//    if (nums[1] + nums[i] == target)
//    {
//        CW(nums[0] and nums[1]);
//    }
//}


//You can return the answer in any order.
//2. Palindrome number. Given and integer x, return true if x is a palindrome and false otherwise. Done

//Leet Solution
//Arrange
//int n;
//Console.WriteLine("Enter a number");
//n = int.Parse(Console.ReadLine());
//int r;
//int sum = 0;
//int temp;

//Act
//temp = n;
//while (n > 0)
//{
//    r = n % 10;
//    sum = (sum * 10) + r;
//    n = n / 10;
//}
////Assert
//if (temp == sum)
//{
//    Console.WriteLine($"Number is a palindrome ");
//}
//else
//{
//    Console.WriteLine($"Number is not a palindrome");
//}

////Abhay's solution

//int result = 0;
//int checknumber = 121;//Number we are checking for palindrome
//int n = checknumber; //Temporary variable to store the number

//while (n > 0)
//{

//    result = result * 10 + (n % 10);

//    n = n / 10;//We want to remove the last digit and keep the remaining digit
//}

//if (result == checknumber)
//{
//    Console.WriteLine($"{checknumber} is a palindrome");
//}
//else
//{
//    Console.WriteLine($"{checknumber} is not a palindrome");
//}

//69. Write a C# Sharp program to check if a given string
//contains only lowercase or uppercase characters.

//Arrange 
//string exerciseSixtyNine = "POKITO";

////Act
//for (int i = 0; i <exerciseSixtyNine.Length; i++)
//{
//    if (exerciseSixtyNine== exerciseSixtyNine.ToLower()||exerciseSixtyNine==exerciseSixtyNine.ToUpper())
//    {
//        Console.WriteLine($"{exerciseSixtyNine} contains either UC or LC only");
//        break;
//    }
//    else
//    {
//        Console.WriteLine($"{exerciseSixtyNine} does not contain either UC or LC only");
//        break; 
//    }
//}

//Assert

//70. Write a C# Sharp program to remove the first and last elements from a given string.

//Arrange
//string exerciseSeventy="Brazil";
////Act
//Console.WriteLine(exerciseSeventy.Substring(1,exerciseSeventy.Length-2));
////Assert

//71. Write a C# Sharp program to check if a given string contains
//two similar consecutive letters. 

//Arrange
//string exerciseSeventyOne = "ssml";
////Act
//for (int i = 0; i < exerciseSeventyOne.Length; i++)
//{
//    if (exerciseSeventyOne[i] == exerciseSeventyOne[i + 1]) 
//    {
//        Console.WriteLine($"{exerciseSeventyOne} has two consecutive letters");
//        break;
//    }
//    else
//    {
//        Console.WriteLine($"{exerciseSeventyOne} does not  have two consecutive letters");
//        break; 
//    }

//}

//Assert

//Interview Bread Financial whiteboard question

//public class HelloWorld
//{
//    public static void Main(string[] args)
//    {
//        Arrange
//        Write a program to convert this input to the output
//Input: "aaaabbbcca"
//Output:[("a", 4), ("b", 3), ("c", 2), ("a", 1)]

//string str = "anaaabccaz"; 

//var temp = "";//To know what the previous variable is. a is taken into this temp
//var count = 0;
//for (int i = 0; i < str.Length; i++)
//{
//    if (temp==(str[i].ToString()))//If a is = a coutn is increasing
//    {
//        count = count + 1;
//    }
//    else
//    {
//        if (count != 0)//So it does not print everything
//        {
//            Console.WriteLine($"({temp},{count})");
//        }
//        count = 1;
//        //Console.WriteLine(count);
//        temp = str[i].ToString();//temp is not matching with 
//    }
//}
//Console.WriteLine($"({temp},{count})");

//For distinct characters count only


//string str = "hellol";
////string strnew= new string(str.Distinct().ToArray());//for distinct without order
//string strnew = new string(str.Distinct().OrderBy(x => x).ToArray());//distinct in alphabetical order

//Console.WriteLine(strnew);

//for (int i = 0; i < strnew.Length; i++)
//{
//    var j = str.Count(x => x == strnew[i]);
//    Console.WriteLine($"({strnew[i]},{j})");
//}




//Console.WriteLine("Enter a string");
//string str = Console.ReadLine();
//var strnew = new String(str.Distinct().OrderBy(x => x).ToArray());

//Console.WriteLine(strnew);

//for (int i = 0; i < strnew.Length; i++)
//{
//	var j = str.Count(x => x == strnew[i]);
//	Console.WriteLine($"({strnew[i]},{j})");
//}

//Input: "aaaabbbcca"
//Output:[("a", 4), ("b", 3), ("c", 2), ("a", 1)]

//    Input: "aaaabbbccaaaadddd"
//Output:[("a", 4), ("b", 3), ("c", 2), ("a", 4), (“d”, 4)]

//    Input: "abcaaaa"
//Output:[("a", 1), ("b", 1), ("c", 1), ("a", 4)]
//        var input = "aaaabbbcca";
//        var countA = 0;
//        var countB = 0;
//        var countC = 0;
//        //var countD = 0;

//        //Act
//        for (int i = 0; i < input.Length; i++)
//        {
//            if (input[i] == 'a')
//                countA = countA + 1;
//            //if (input[i] != 'a')
//            //break;

//        }

//        for (int i = 0; i < input.Length; i++)
//        {
//            if (input[i] == 'b')
//                countB = countB + 1;

//        }
//        for (int i = 0; i < input.Length; i++)
//        {
//            if (input[i] == 'c')
//                countC = countC + 1;

//        }
//        //Assert
//        Console.WriteLine($"(a,{countA})");
//        Console.WriteLine($"(b,{countB})");
//        Console.WriteLine($"(c,{countC})");

//    }
//}





//    }
//}

//Input: "aaaabbbcca"
//        //Output:[("a", 4), ("b", 3), ("c", 2), ("a", 1)]

//Arrange

//Act

//Assert

//72. Write a C# Sharp program to check whether the average value of the elements of a given array of
//numbers is a whole number or not.

//Arrange

//int[] nums = { 1, 2, 3,1 };
//int sum;
////Act
//sum = nums.Sum();

//var avg = sum / nums.Length;
//var avg2 = sum / (nums.Length * 1.0);

////Console.WriteLine($"Average is whole number {avg}   {avg2}");


//if (sum / nums.Length == sum / (nums.Length * 1.0))
//{
//    Console.WriteLine($"Average is whole number");
//}
//else
//{
//    Console.WriteLine($"Average is not the whole number");
//}


//73  Write a C# Sharp program to convert the letters of a given string (same case-upper/lower) into alphabetical order. 

//Arrange
//string exerciseSeventyThree = "singlemaltlives";
//Act
//Convert to alphabetical order
//Console.WriteLine(exerciseSeventyThree.OrderBy(x => x).ToArray()); 
//string newString= new string((exerciseSeventyThree.OrderBy(x => x).ToArray()));
//Console.WriteLine(newString);

//Assert


//static void Main(string[] args)

//Console.WriteLine("Original string: singlemaltlives");
//Console.WriteLine("Convert the letters of the said string into alphabetical order: " + test("singlemaltlives"));
//Console.WriteLine("Original string: javascript");
//Console.WriteLine("Convert the letters of the said string into alphabetical order: " + test("javascript"));
//Console.WriteLine("Original string: python");
//Console.WriteLine("Convert the letters of the said string into alphabetical order: " + test("python"));

//static string test(string str1)
//{
//    return new string(str1.OrderBy(x => x).ToArray());
//}

//Assert

//Write a C# Sharp program to convert the letters of a given string (same case-upper/lower) into alphabetical order. 

//Arrange
//Console.WriteLine($"Original string: singlemaltlives");
//Console.WriteLine($"Conversion     :{test("singlemaltlives")}");
////Act 
////Assert 

//static string test (string str1 )
//{
//    return new string(str1.OrderBy(x => x).ToArray()); 
//}

//74. Write a C# Sharp program to check the length of a given string is odd or even.
//Return 'Odd length' if the string length is odd otherwise 'Even length'.
//Sample Output:
//Original string: PHP
//Odd length

//Arrange
//Console.WriteLine("Enter a word");
//string exerciseSeventyFour = Console.ReadLine();

////Act


//if ((exerciseSeventyFour.Length) % 2 == 0)
//{
//    Console.WriteLine($"{exerciseSeventyFour} is even length");
//}
//else
//{
//    Console.WriteLine($"{exerciseSeventyFour} is odd length");
//}

////Assert

//75. Write a C# Sharp program which takes a positive number and return the nth odd number.(Ask Abhay)
//Arrange
//Console.WriteLine("Enter a number");
//int exerciseSeventyFive= int.Parse(Console.ReadLine());
////Act
//2
////Assert

//{
//    Console.WriteLine("1st odd number: " + test(1));
//    Console.WriteLine("2nd odd number: " + test(2));
//    Console.WriteLine("4th odd number: " + test(4));
//    Console.WriteLine("100th odd number: " + test(100));
//}
//static int test(int n)
//{
//    return n * 2 - 1;
//}

//76. Write a C# Sharp program to get the ASCII value of a given character. (Not clear Ask Abhay)

//static void Main(string[] args)
//{
//    Console.WriteLine("Ascii value of 1 is: " + test('1'));
//    Console.WriteLine("Ascii value of A is: " + test('A'));
//    Console.WriteLine("Ascii value of a is: " + test('a'));
//    Console.WriteLine("Ascii value of # is: " + test('#'));

//}
//static int test(char ch)
//{
//    return (int)ch;
//}

//77. Write a C# Sharp program to check whether a given word is plural or not.

////Arrange
//string exerciseSeventySeven = "rooms";

////Act
//if (exerciseSeventySeven.EndsWith('s'))
//{
//    Console.WriteLine($"{exerciseSeventySeven} is plural");
//}
//else
//{
//    Console.WriteLine($"{exerciseSeventySeven} is not plural");
//}

////Assert

//78. Write a C# Sharp program to find sum of squares of elements of a given array of integers.

//Arrange
//int[] exerciseSeventyEight = { 1, 2, 3 };
//int sumOfSquares=0; 
////Act
//for (int i = 0; i <exerciseSeventyEight.Length; i++)
//{
//    exerciseSeventyEight[i] = exerciseSeventyEight[i] * exerciseSeventyEight[i]; 
//}

////Assert
//for (int i = 0; i < exerciseSeventyEight.Length; i++)
//{
//    sumOfSquares = sumOfSquares + exerciseSeventyEight[i]; 
//}

//Console.WriteLine(sumOfSquares);
//W3schools solution

//{
//    int[] nums = { 1, 2, 3 };
//    Console.WriteLine("Sum of squares of elements of the said array: " + test(nums));
//    int[] nums1 = { -2, 0, 3, 4 };
//    Console.WriteLine("Sum of squares of elements of the said array: " + test(nums1));
//}
//static int test(int[] nums)
//{
//    return nums.Sum(n => n * n);
//}


//79. Write a C# Sharp program to convert an integer to string and a string to an integer.(Ask Abhay)
//Original value and type: 50, System.String
//Convert string to integer:
//Return value and type: 50, System.Int32
//Original value and type: 122, System.Int32
//Convert integer to string:
//Return value and type: 122, System.String
//Arrange
//string exerciseSeventyNine = "cabo";
////Act
//Console.WriteLine(exerciseSeventyNine.ToString());
////Assert

//80. Write a C# Sharp program to convert all the values of a given array(Ask Abhay)
//of mixed values to string values.

//81. Write a C# Sharp program to swap a two digit given number and(Ask Abhay)
//check whether the given number is greater than its swap value.

////Arrange
//int exerciseEithtyOne = 40;
//int tempExerciseEightyOne;
////Act
//Console.WriteLine(exerciseEithtyOne.substring(0);
////Assert

//82.Write a C# Sharp program to remove all characters which are non-letters from a given string. 
//Arrange
//using System.Text.RegularExpressions;
/////
//string exercieseEithty = "Sa1a8";

////Act
//Console.WriteLine(Regex.Replace(exercieseEithty, @"[^a-zA-Z]", "")); 
////Assert

//With function

//using System.Text.RegularExpressions;

//string text;
//text = "Sa1a8"; 
//Console.WriteLine("Original String: Sa1a8");
//Console.WriteLine("Remove all characters from the said string which are non-letters:"+ test(text));

//static string test(string text)
//{
//    return Regex.Replace(text, @"[^a-zA-Z]", ""); 
//}

//83. Write a C# Sharp program to remove all vowels from a given string. 

//Arrange 
//using System.Text.RegularExpressions;
//string text;
//text = "Python";
//Console.WriteLine("Orginal string: " + text);
//Console.WriteLine("After removing all the vowels from the said string: " + test(text));
//text = "C Sharp";
//Console.WriteLine("\nOrginal string: " + text);
//Console.WriteLine("After removing all the vowels from the said string: " + test(text));
//text = "JavaScript";
//Console.WriteLine("\nOrginal string: " + text);
//Console.WriteLine("After removing all the vowels from the said string: " + test(text));
////Act
//static string test(string text)
//{
//    return new Regex(@"[aeiouAEIOU]").Replace(text, ""); 
//}
////Assert
//

//84.Write a C# Sharp program to get the index number of all 
//lower case letters in a given string. (Ask Abhay)

//Arrange
//string exerciseEightyFour = "SeeDotNet";
//Act


//Assert

//85.Write a C# Sharp program to find the cumulative sum of an array of number.(Ask Abhay)

//86. Write a C# Sharp program to get the number of letters and digits in a given string.

//Arrange
//string exerciseEigtySix = "Cabos2023";
//int letterCount;
//int digitCount;

////Act

//letterCount= exerciseEigtySix.Count(char.IsLetter); 
//digitCount= exerciseEigtySix.Count(char.IsDigit);

////Assert
//Console.WriteLine($"Count of letters is : {letterCount}");
//Console.WriteLine($"Count of letters is : {digitCount}");

// 87.Write a C# Sharp program to reverse a boolean value.
//Arrange
//bool cat = false;
//bool dog = true;
//Console.WriteLine($"Original value: {cat}");
//Console.WriteLine($"Reverse value: {testBool(cat)}");
//Console.WriteLine($"Original value: {dog}");
//Console.WriteLine($"Reverse value: {testBool(dog)}");
////Act
//static bool testBool(bool boolean)
//{
//    return !boolean;
//}

//Assert

//88. Write a C# Sharp program to find the sum of the interior angles (in degrees)
//of a given Polygon. Input number of straight line(s). 

//Arrange

//int exerciseEightyEight = 20;
//int sumOfInteriorAngles = 180 * (exerciseEightyEight - 2); 
////Act
//Console.WriteLine(sumOfInteriorAngles);
//Assert

//{
//    Console.WriteLine("Input number of straight lines of the polygon:");
//    int n = Convert.ToInt32(Console.ReadLine());
//    Console.WriteLine("Sum of the interior angles (in degrees) of the said polygon: " + test(n));
//}
//static int test(int num)
//{
//    return 180 * (num - 2);
//}

//89. Write a C# Sharp program to count positive and negative numbers in a given array of integers.

//Arrange
//int[] exerciseEithtyNine = { 7, -2, 4, -3, 1,-8 };
//int countPositiveNumbers = 0; 
//int countNegativeNumbers = 0;
////Act
//for (int i = 0; i < exerciseEithtyNine.Length; i++)
//{
//    if (exerciseEithtyNine[i]>=0)
//    {
//       countPositiveNumbers=countPositiveNumbers+1;
//    }
//    else
//    {
//        countNegativeNumbers=countNegativeNumbers+1;
//    }
//}
////Assert
//Console.WriteLine($"There are {countPositiveNumbers} positive numbers in this array ");
//Console.WriteLine($"There are {countNegativeNumbers} negetive numbers in this array");

//90. Write a C# Sharp program to count number of ones and zeros in
//the binary representation of a given integer. (Ask Abhay)

//91. Write a C# Sharp program to remove all the values except integer values
//from a given array of mixed values. (Ask Abhay)

//Arrange
//object [] exerciseNinetyOne = { "string", 12 , false, -112, 34.67, System.DateTime.Now};

////Act
//object[] newObject = { }; 
////Assert

//exerciseEightyFour.OfType<int>().ToArray();
//Console.WriteLine(exerciseEightyFour);


//    object[] mixedArray = new object[6];
//    mixedArray[0] = 25;
//    mixedArray[1] = "Anna";
//    mixedArray[2] = false;
//    mixedArray[3] = System.DateTime.Now;
//    mixedArray[4] = -112;
//    mixedArray[5] = -34.67;

//    Console.WriteLine("Original array elements:");
//    for (int i = 0; i < mixedArray.Length; i++)
//    {
//        Console.Write(mixedArray[i] + " ");
//    }
//    int[] new_nums = test(mixedArray);
//    Console.WriteLine("\n\nAfter removing all the values except integer values from the said array of mixed values:");
//    for (int i = 0; i < new_nums.Length; i++)
//    {
//        Console.Write(new_nums[i] + " ");
//    }

//static int[] test(object[] nums)
//{
//    return nums.OfType<int>().ToArray();
//}

//92. Write a C# Sharp program to find the next prime number of a given number.
//If the given number is a prime number, return the number.(Ask Abhay for later)

//93. Write a C# Sharp program to calculate the square root of a given number.
//Do not use any built-in-function, return integer part of the result.

//94. Write a C# program that finds the longest common prefix from an array of strings.

//Arrange
//string[] exerciseNinetyFour = { "Sandy", "Riverton", "Sojo", "Bojo" };

////Act
//for (int i = 0; i < exerciseNinetyFour.Length; i++)
//{

//}
//Assert

//95. Write a C# programme to check the said string is valid or not. The input string will be
//valid when open brackets and closed brackets are same type of brackets.Or
//open brackets will be closed in proper order.(Ask Abhay)

//Arrange

//Act
//Assert

//96. Write a C# Sharp program to check whether all the characters in a string are the same.
//Return true if all the characters in the said string are same otherwise false.

//Arrange
//string exerciseNinetySix = "bbv"; 

////Act 

//if (exerciseNinetySix.Length>1)
//{
//    var b = exerciseNinetySix[0];
//    for (int i = 0; i < exerciseNinetySix.Length; i++)
//    {
//        var c = exerciseNinetySix[i];
//        if (c != b)
//        {
//            Console.WriteLine("False");
//            break;
//        }
//        else
//        {
//            Console.WriteLine("True");
//            break;
//        }
//    }

//}


//Assert

//97. Write a C# Sharp program to check if a given string
//(floating point and negative numbers included) is numeric or not.
//Return True if the said string is numeric otherwise false.

//Arrange
//string text = "hello1";
//Console.WriteLine("Original Text"+ text);
//Console.WriteLine($"Original Text: {test(text)}");
//text = "1345";
//Console.WriteLine("Original Text" + text);
//Console.WriteLine($"Original Text: {test(text)}");
//text = "maltlives";
//Console.WriteLine("Original Text" + text);
//Console.WriteLine($"Original Text: {test(text)}");

////Act

//static bool test(string text)
//{
//    double result;
//    return (double.TryParse(text, out result));

//}

////Assert

//98.Write a C# Sharp program to create and display all prime numbers in strictly
//descending decimal digit order.(Ask Abhay)

//99.Write a C# Sharp program to create and display all prime numbers
//in strictly ascending decimal digit order.(Ask Abhay)

//100. Write a C# Sharp program to check the equality comparison (value and type )
//of two parameters.Return true if they are equal otherwise false. 
//Sample Data:
//("AAA", "BBB")->False
//(true, false)->False
//(true, "true")->False
//(10, 10)->True
//Arrange
//string text1 = "aaa";
//string text2 = "aaa";
//Console.WriteLine("original values: "+ text1 + ","+ text2);
//Console.WriteLine("Check the equality of the said values "+ test(text1, text2));

//bool v1 = true;
//bool v2 = false;
//Console.WriteLine($"Original values: {v1}, {v2}");
//Console.WriteLine("Check the equality of the said values " + test(v1, v2));

//Console.WriteLine($"Original values: {text1}, {v2}");
//Console.WriteLine("Check the equality of the said values " + test(text1, v2));


////Act
//static bool test(object x,object y)
//{
//    if (x!=y)
//    {
//        return false; 
//    }
//    if (x.GetType()!=y.GetType())
//    {
//        return false; 
//    }
//    return true;
//}
//Console.WriteLine(text1.GetType());
//Console.WriteLine(v1.GetType());
////Assert

//101. Write a C# Sharp program to calculate the value of e. (Look at formula)
//102. Write a C# Sharp program to create a identity matrix.(Look at formula)

//103.Write a C# Sharp program to sort characters in a
//given string (uppercase/lowercase letters and numbers). Return the new sorted string.(Revisit again)
//("AAAbfed231")-> "AAAbdef123"
//(" ")-> "Blank string!"
//("Python")-> "hnoPty"
//("W3resource")-> "ceeorrsuW3"
//Arrange
//var exerciseHundredAndThree = "Kathma2ndu";
//Console.WriteLine("Original string "+ exerciseHundredAndThree );
//Console.WriteLine("sorted string: " + returnExerciseHundredAndThree(exerciseHundredAndThree)); 
////Act


////Assert
//static string returnExerciseHundredAndThree(string exerciseHundredAndThree)
//{
//    bool flag = string.IsNullOrWhiteSpace(exerciseHundredAndThree);
//    if (flag)
//    {
//        return "Blank String";
//    }
//    var exerciseHunredAndThree_nums= exerciseHundredAndThree.Where(char.IsDigit).OrderBy(el=>el).ToList();
//    var exerciseHunredAndThree_chars= exerciseHundredAndThree.Where(char.IsLetter)

//    return new string 
//}

//104. Write a C# Sharp program to compare equality of three integers and
//calculate how many integers have the same value.
//Sample Data:
//(1, 2, 3)-> 0
//(1, 3, 3)-> 2
// (3, 3, 3)-> 3

//Arrange
//int x, y, z;
//x = 0;
//y = 3;
//z = 3; 

////Act

//if (x==y && y==z)
//{
//    Console.WriteLine("3");
//}
//if (x!=y&& y!=z && x!=z)
//{
//    Console.WriteLine("0");
//}
//else
//{
//    Console.WriteLine("2");

//}
////Assert

//{
//    int x = 1, y = 2, z = 3;
//    Console.WriteLine("Original numbers: " + x + ',' + y + ',' + z);
//    Console.WriteLine("Number of equality of the said numbers: " + test(x, y, z));
//    x = 1; y = 3; z = 3;
//    Console.WriteLine("Original numbers: " + x + ',' + y + ',' + z);
//    Console.WriteLine("Number of equality of the said numbers: " + test(x, y, z));
//    x = 3; y = 8; z = 3;
//    Console.WriteLine("Original numbers: " + x + ',' + y + ',' + z);
//    Console.WriteLine("Number of equality of the said numbers: " + test(x, y, z));
//}
//static int test(int x, int y, int z)
//{
//    return (x == y && y == z) ? 3 : (x != y && y != z && x != z) ? 0 : 2;
//}
