public class MissingNumber {
    public static int findMissing(int[] arr) {
        int n = arr.length;
        // numbers are distinct from 0..n, one missing, array size is n
        long total = (long)(n * (n + 1)) / 2;
        long sum = 0;
        for (int v : arr) sum += v;
        return (int)(total - sum);
    }

    public static void main(String[] args) {
        int[] arr = {3,0,1}; // n = 3 -> missing 2
        System.out.println("Missing: " + findMissing(arr));
    }
}
