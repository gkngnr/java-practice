package recursion;

public class Basic {

    public static void main(String[] args) {
        System.out.println(triangle(1000));
        System.out.println(factorial(5));
        System.out.println("DENIM".equals(reverse("MINED")));
    }

    public static int triangle(int val) {
        if (val == 1) return 1;
        return val + triangle(val - 1);
    }

    public static int factorial(int val) {
        if (val == 0) return 1;
        return val * factorial(val - 1);
    }

    public static String reverse(String val) {
        if ("".equals(val)) {
            return "";
        }
        return reverse(val.substring(1)) + val.charAt(0);
    }

    public static boolean isPalindrome(String val) {
        if (val.isEmpty() || val.length() == 1)
            return true;
        if (val.charAt(0) != val.charAt(val.length() - 1))
            return false;

        return isPalindrome(val.substring(1, val.length() - 1));

    }


}
