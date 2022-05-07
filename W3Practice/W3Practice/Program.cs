// See https://aka.ms/new-console-template for more information
using System.Linq; 
#region string
string text = "Single \nMalt \nLives :-) ";
string plan = "Plan my own time";
Console.WriteLine(text);
//string concatination 
string outlook = text + plan;
//string interpoltion 
string FinancialFreedom = $"My Financial Freedom plan is to expand {text}{plan}"; 
Console.WriteLine(FinancialFreedom);
//Find index of specfic character
Console.WriteLine(text.IndexOf("e"));
Console.WriteLine(outlook);
Console.WriteLine(text.ToUpper());
Console.WriteLine(text.ToLower());
Console.WriteLine(text);

//Substring
string name = "Clark Howard's";

int charPosition= name.IndexOf("H");
string lastname= name.Substring(charPosition);
Console.WriteLine(lastname);
#endregion

#region arrays
string [] bike = { "Hybrid", "Road", "Mountain", "Dirt" };
int[] anka = { 7, 12, 13, 20 }; 
Console.WriteLine(bike.Length);

//for (int i = 0; i <=bike.Length-1; i++)
//{
//    Console.Write(bike[i]+ ",");
        
//}
//for each
Array.Sort(bike);
foreach (string i in bike)
{
    Console.WriteLine(i);
}
Console.WriteLine(anka.Min());
Console.WriteLine(anka.Max());
Console.WriteLine(anka.Sum());

//Method
static void SoccerPlay()
{
    Console.WriteLine("I love playing soccer!Looking forward to world cup 2022");
}

SoccerPlay();   
#endregion