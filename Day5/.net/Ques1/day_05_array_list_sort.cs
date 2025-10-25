using System;
using System.Collections;

class Program
{
    static void Main()
    {
        ArrayList names = new ArrayList();

        Console.WriteLine("Enter 10 names:");

        for (int i = 0; i < 10; i++)
        {
            Console.Write($"Name {i + 1}: ");
            string input = Console.ReadLine();
            names.Add(input);
        }

        names.Sort();

        Console.WriteLine("\nSorted Names:");
        foreach (string name in names)
        {
            Console.WriteLine(name);
        }

        Console.WriteLine("\nPress any key to exit...");
        Console.ReadKey();
    }
}
