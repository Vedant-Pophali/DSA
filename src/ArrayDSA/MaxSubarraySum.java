package ArrayDSA;

import java.util.Arrays;

public class MaxSubarraySum {

    public static void main(String[] args) {
        int[][] testCases = {
                {-2, 1, -3, 4, -1, 2, 1, -5, 4},
                {1},
                {5, 4, -1, 7, 8},
                {-1, -2, -3, -4},
                {-2, -1}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            System.out.println("Test Case #" + (i + 1));
            System.out.println("Array: " + Arrays.toString(nums));

            int result = maxSubArray(nums);

            System.out.println("Max Subarray Sum: " + result);
            System.out.println("---------------");
        }
    }

    // Kadane's Algorithm to find max sum of subarray
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}