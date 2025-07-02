package ArrayDSA.LeetCode;

import java.util.Arrays;

public class MergeSortedArray {public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;       // Last valid element of nums1
    int j = n - 1;       // Last element of nums2
    int k = m + n - 1;   // Last index of nums1 after full merge

    // Merge in reverse order
    while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
            nums1[k--] = nums1[i--];
        } else {
            nums1[k--] = nums2[j--];
        }
    }

    // Copy remaining elements from nums2
    while (j >= 0) {
        nums1[k--] = nums2[j--];
    }
}

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println("Test 1: " + Arrays.toString(nums1)); // [1, 2, 2, 3, 5, 6]

        // Test Case 2
        int[] nums1b = {1};
        int[] nums2b = {};
        merge(nums1b, 1, nums2b, 0);
        System.out.println("Test 2: " + Arrays.toString(nums1b)); // [1]

        // Test Case 3
        int[] nums1c = {0};
        int[] nums2c = {1};
        merge(nums1c, 0, nums2c, 1);
        System.out.println("Test 3: " + Arrays.toString(nums1c)); // [1]
    }
}