package ArrayDSA;

import java.util.Arrays;

public class SortColorsDNF {

    public static void main(String[] args) {
        int[][] testCases = {
                {2, 0, 2, 1, 1, 0},
                {2, 0, 1},
                {0},
                {1, 2, 0},
                {2, 2, 1, 0, 0, 1, 2}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            System.out.println("Test Case #" + (i + 1));
            System.out.println("Original: " + Arrays.toString(nums));

            sortColors(nums);

            System.out.println("Sorted Colors: " + Arrays.toString(nums));
            System.out.println("---------------");
        }
    }

    // Dutch National Flag algorithm
    public static void sortColors(int[] nums) {
        int start = 0, mid = 0, end = nums.length - 1;

        while (mid <= end) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, start, mid);
                    start++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, end);
                    end--;
                    break;
            }
        }
    }

    // Swap two elements
    public static void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}