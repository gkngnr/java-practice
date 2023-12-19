package demo1;

import java.util.Arrays;

public class Hello {

    static int s;

    public static void main(String[] args) {
        Hello p = new Hello();
        p.start();
        System.out.println(s);

        // Test the anagram method
        System.out.println(p.isAnagram("heart", "earth"));  // Returns true
    }

    void start() {
        int x = 7;
        twice(x);
        System.out.print(x + " ");
    }

    void twice(int x) {
        x = x*2;
        s = x;
    }

    // Method to check if two strings are anagram
    boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}