//int x;
//int y;


//x = 10;
//y = 3

//Console.WriteLine(x / y);

//Score: 1 / 1
//---------- -
string x = "Pablo Picaaso";

//Find the first element
//Console.WriteLine(x[0]);
//Find the last element
//Console.WriteLine(x[x.Length - 1]);

//1.5 out of 2
//------------------

//create an array of string containing 3 names
//string[] arr = { "Sajag", "Sudipto", "Santosh" };

////1 / 1

////----------------------------------------

////print all elements of the array above

//for (int i = 0; i < arr.Length; i++)
//{
//    Console.WriteLine(arr[i]);
//}

//3 out of 3


//-------------------------------- -

//create a class Person containing 2 members: name and age
/*
public static class Person
(
string name, string age
)

class Person
{
    string name;
    string age;
}

//1 / 3

//------------------ -

//create an object of this class
Person p = new Person();

//1 out of 1

//-------------------- -
//initialize with data and correct some part of class to enable that
class Person
{
    public string name;
    public string age;
}

p.name = "Sajag";
p.age = 35;

//1 of ouf 2


--------------------------
//we then want to print the information bt calling a function 
1.5 out of 3


---------------------------------------

//write different types of loops in C#
while - entry controlled
do while - exit controlled
for
foreach

4 out of 5




15 out 21

******************************************************************************
*/


//using System;

//public class Person
//{
//    public string name;
//    public int age;

//    //implement a display function
//    public void Display()
//    {
//        Console.WriteLine(name + " is " + age + " years old");
//    }
//}

//class HelloWorld
//{
//    static void Main()
//    {
//        //create an object of this class
//        Person p = new Person();

//        p.name = "Sajag";
//        p.age = 35;

//        //call ur display function
//        p.Display();

//    }

//}

//Linear search
//Write a C# program to check if animal is present or not in array of animals. 

//Arrage
string[] animals = { "Dog,Pig,Elephant,Goat" };
Console.WriteLine("Enter an animal");
string animal = Console.ReadLine();
bool found = false;

for (int i = 0; i < animals.Length; i++)
{
    if (animals[i]==animal)
    {
        found = true;
        break; 
    }
}

if (found==true)
{
    Console.WriteLine($"{animal} is present in this group of animals");
}
else
{
    Console.WriteLine($"{animal} is not present in this group of animals");
}