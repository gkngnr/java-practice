package demo1;

import java.util.Arrays;

public class Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("ab", "abc"));
        System.out.println(isAnagram("abc", "ab"));
        System.out.println(isAnagram("abc", "abc"));
        System.out.println(isAnagram("abcaa", "aabac"));
    }


    public static boolean isAnagram(String str1, String str2) {
        if (checkParamsAreInvalid(str1, str2)) {
            return false; // throw IllegalArgumentException
        }
        var charArray1 = str1.toCharArray();
        var charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    private static boolean isEmptyOrNull(String str) {
        return str == null || str.isEmpty();
    }

    private static boolean checkParamsAreInvalid(String str1, String str2) {
        return isEmptyOrNull(str1) || isEmptyOrNull(str2) || str1.length() != str2.length();
    }
}
