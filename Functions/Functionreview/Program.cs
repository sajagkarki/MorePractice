
//create a class Person containing 2 members: name and age
public class Person
{
    ////initialize with data and correct some part of class to enable that
    public string name;
    public int age;

    //implement a display function
    public void Display()
    {
        Console.WriteLine(name + " is " + age + " years old");
    }
}

class HelloWorld
{
    static void Main()
    {
        //create an object of this class
        Person p = new Person();

        p.name = "Sajag";
        p.age = 35;

        //call ur display function
        p.Display();

    }

}