// See https://aka.ms/new-console-template for more information


/*Problem 1
 * You must print two lines of output:

Print Hello, World. on the first line.
Print Hello, Java. on the second line. */


Console.WriteLine("Hello, World!");
Console.WriteLine("Hello, C#!");

//Problem 2
//Given an integer,n , perform the following conditional actions:

//If n is odd, print Weird -Done

int n = 13;
if (n % 2 == 1)
{
    Console.WriteLine("Wierd because I am odd");
}

//If n is even and in the inclusive range of 2 to 5 , print Not Weird- Done
if (n % 2 == 0 && n > 1 && n < 6)
{
    Console.WriteLine("Not Wierd because I am even & between 2 to 5 ");
}

//If n is even and in the inclusive range of 6 to 20 , print Weird- Done
if (n % 2 == 0 && n > 5 && n < 21)
{
    Console.WriteLine("Wierd because I am even and between 6 to 20");
}
//If n is even and greater than 20 , print Not Weird
if (n % 2 == 0 && n > 20)
{
    Console.WriteLine("Not Wierd");
}

//Complete the stub code provided in your editor to print whether or not n is weird. Done


