package ArrayDSA;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[][] testCases = {
                {1, 2, 3},
                {3, 2, 1},
                {1, 1, 5},
                {1, 3, 2},
                {2, 4, 3, 1}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            System.out.println("Test Case #" + (i + 1));
            System.out.println("Original: " + Arrays.toString(nums));

            nextPermutation(nums);

            System.out.println("Next Permutation: " + Arrays.toString(nums));
            System.out.println("---------------");
        }
    }

    // Generates the next lexicographic permutation
    public static void nextPermutation(int[] nums) {
        int index = -1;
        int len = nums.length;

        // Step 1: Find first decreasing element from right
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // Step 2: If not found, reverse whole array
        if (index == -1) {
            reverse(nums, 0, len - 1);
            return;
        }

        // Step 3: Find element just greater than nums[index]
        for (int i = len - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }

        // Step 4: Reverse remaining elements after index
        reverse(nums, index + 1, len - 1);
    }

    // Reverse elements from left to right index
    public static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    // Swap two elements
    public static void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}
