package demo1;

import java.util.Arrays;

public class LeetTest {

    public static void main(String[] args) {

        int[] nums = new int[] {1,2,3,4};

        final int[] runningSum = runningSum(nums);

        Arrays.stream(runningSum).forEach(System.out::println);


    }

    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }
}
