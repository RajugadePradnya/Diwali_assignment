using System;

class Program
{
    static void Main()
    {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8, 9};

        int[] merged = MergeSortedArrays(nums1, nums2);

        Console.WriteLine("Merged Array: " + string.Join(", ", merged));
        Console.WriteLine("\nPress any key to exit...");
        Console.ReadKey();
    }

    static int[] MergeSortedArrays(int[] nums1, int[] nums2)
    {
        int n1 = nums1.Length, n2 = nums2.Length;
        int[] result = new int[n1 + n2];
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2)
        {
            if (nums1[i] <= nums2[j])
                result[k++] = nums1[i++];
            else
                result[k++] = nums2[j++];
        }

        while (i < n1) result[k++] = nums1[i++];
        while (j < n2) result[k++] = nums2[j++];

        return result;
    }
}
