using System;

class Program
{
    static void Main()
    {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        Console.WriteLine("Original Array: " + string.Join(", ", nums));

        Console.Write("Enter k (steps to rotate): ");
        int k = int.Parse(Console.ReadLine());

        RotateRight(nums, k);

        Console.WriteLine("Rotated Array: " + string.Join(", ", nums));
        Console.WriteLine("\nPress any key to exit...");
        Console.ReadKey();
    }

    static void RotateRight(int[] nums, int k)
    {
        int n = nums.Length;
        k = k % n; // handle k > n
        Reverse(nums, 0, n - 1);
        Reverse(nums, 0, k - 1);
        Reverse(nums, k, n - 1);
    }

    static void Reverse(int[] nums, int start, int end)
    {
        while (start < end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
