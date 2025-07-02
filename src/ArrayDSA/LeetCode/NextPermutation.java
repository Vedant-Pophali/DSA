package ArrayDSA.LeetCode;

import java.util.Arrays;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
    int n = nums.length;
    int i = n - 2;

    // Step 1: Find the first decreasing element from the right
    while (i >= 0 && nums[i] >= nums[i + 1]) {
        i--;
    }

    // Step 2: If such an element is found, find the element just larger and swap
    if (i >= 0) {
        int j = n - 1;
        // Find the next bigger element from the right
        while (j >= 0 && nums[j] <= nums[i]) {
            j--;
        }
        swap(nums, i, j);
    }

    // Step 3: Reverse the remaining part from i+1 to end
    reverse(nums, i + 1, n - 1);
}

    // Helper method to reverse part of the array
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    // Helper method to swap two values
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Main method with 5 test cases
    public static void main(String[] args) {
        int[][] testCases = {
                {1, 2, 3},         // Expected: [1, 3, 2]
                {3, 2, 1},         // Expected: [1, 2, 3]
                {1, 1, 5},         // Expected: [1, 5, 1]
                {1, 3, 2},         // Expected: [2, 1, 3]
                {2, 3, 1, 3, 3}    // Expected: [2, 3, 3, 1, 3]
        };

        for (int i = 0; i < testCases.length; i++) {
            nextPermutation(testCases[i]);
            System.out.println("Test " + (i + 1) + ": " + Arrays.toString(testCases[i]));
        }
    }
}
