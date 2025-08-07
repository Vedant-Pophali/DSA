package ArrayDSA;

import java.util.Arrays;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            if (nums2[j] > nums1[i]) {
                nums1[k] = nums2[j];
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1a = {1, 2, 3, 0, 0, 0};
        int[] nums2a = {2, 5, 6};
        merge(nums1a, 3, nums2a, 3);
        System.out.println("Merged array 1: " + Arrays.toString(nums1a));

        // Test Case 2
        int[] nums1b = {4, 5, 6, 0, 0, 0};
        int[] nums2b = {1, 2, 3};
        merge(nums1b, 3, nums2b, 3);
        System.out.println("Merged array 2: " + Arrays.toString(nums1b));

        // Test Case 3
        int[] nums1c = {0};
        int[] nums2c = {1};
        merge(nums1c, 0, nums2c, 1);
        System.out.println("Merged array 3: " + Arrays.toString(nums1c));

        // Test Case 4
        int[] nums1d = {1};
        int[] nums2d = {};
        merge(nums1d, 1, nums2d, 0);
        System.out.println("Merged array 4: " + Arrays.toString(nums1d));

        // Test Case 5
        int[] nums1e = {2, 0};
        int[] nums2e = {1};
        merge(nums1e, 1, nums2e, 1);
        System.out.println("Merged array 5: " + Arrays.toString(nums1e));
    }
}
