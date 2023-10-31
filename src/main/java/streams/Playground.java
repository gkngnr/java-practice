package streams;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.NONE)
public class Playground {

    public static void main(String[] args) {
        var words = List.of("abc","aba", "aaa", "abba", "bcbd");
        appendPalindromeCheck(words).forEach(System.out::println);
    }

    //Find sum of only the even numbers in a collection
    public static int calculateSum(List<Integer> nums) {
        return nums.stream()
                .filter(i -> i % 2 == 0)
                .reduce(0, Integer::sum);
    }

    /*
    * Display the words in a collection are palindrome or not
    * ex: abba is a palindrome, abc is not a palindrome: we get the same word when we read from both the ends
    * */
    public static List<String> appendPalindromeCheck(List<String> words) {
        return words.stream()
                .map(word -> word + "->" + isPalindrome(word)).toList();
    }


    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // Find the maximum of the odd numbers in a collection (collection includes both odd and even numbers)
    public static int getMaxOfOdd(List<Integer> nums) {
        return nums.stream()
                .filter(i -> i % 2 == 1)
                .reduce(-1, Integer::max);
    }
}
