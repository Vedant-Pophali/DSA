package ArrayDSA.LeetCode;

import java.util.Arrays;

public class TwoSum {
        public static int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) { // Start from i + 1 to avoid duplicate pairs
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j}; // Return the indices
                    }
                }
            }
            throw new IllegalArgumentException("No solution found!"); // Handle case where no solution exists
        }
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] result = TwoSum.twoSum(arr, target);
        System.out.println(Arrays.toString(result)); // Print result as [index1, index2]
    }
}
