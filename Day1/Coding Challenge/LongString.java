import java.util.*;

public class LongString {
    public static void main(String[] args) {
        // Example array of strings
        String[] arr = {"apple", "banana", "kiwi", "strawberry"};

        int maxLength = 0;

        for (String s : arr) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }

        System.out.println("Length of the longest string: " + maxLength);
    }
}
