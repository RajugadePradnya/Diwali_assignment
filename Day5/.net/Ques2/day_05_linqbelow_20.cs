using System;
using System.Linq;

class Program
{
    static void Main()
    {
        int[] IntArray = { 12, 5, 24, 10, 9, 8, 4, 87, 23, 7, 11, 43 };

        var result = from num in IntArray
                     where num < 20
                     select num;

        Console.WriteLine("Numbers below 20:");
        foreach (var num in result)
        {
            Console.WriteLine(num);
        }

        Console.WriteLine("\nPress any key to exit...");
        Console.ReadKey();
    }
}