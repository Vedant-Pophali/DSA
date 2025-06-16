package BinarySearch.LeetCode;

import java.util.Arrays;

public class FirstAndLastElement {

    public int[] searchRange(int[] nums, int target) {
        int[] fin = new int[2];
        fin[0] = -1;
        fin[1] = -1;

        if (nums.length == 0) {
            return fin;
        }

        fin[0] = searchLeft(nums, target);
        fin[1] = searchRight(nums, target);
        return fin;
    }

    public int searchLeft(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                end = mid - 1; // Move left to find first occurrence
            }
        }

        return ans;
    }

    public int searchRight(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1; // Move right to find last occurrence
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FirstAndLastElement finder = new FirstAndLastElement();

        // Test Case 1: Normal case with multiple occurrences
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        System.out.println("Test Case 1: " + Arrays.toString(finder.searchRange(nums1, target1))); // [3, 4]

        // Test Case 2: Target not found
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        System.out.println("Test Case 2: " + Arrays.toString(finder.searchRange(nums2, target2))); // [-1, -1]

        // Test Case 3: Single element - match
        int[] nums3 = {1};
        int target3 = 1;
        System.out.println("Test Case 3: " + Arrays.toString(finder.searchRange(nums3, target3))); // [0, 0]

        // Test Case 4: Empty array
        int[] nums4 = {};
        int target4 = 0;
        System.out.println("Test Case 4: " + Arrays.toString(finder.searchRange(nums4, target4))); // [-1, -1]

        // Test Case 5: All elements are the target
        int[] nums5 = {2, 2, 2, 2, 2};
        int target5 = 2;
        System.out.println("Test Case 5: " + Arrays.toString(finder.searchRange(nums5, target5))); // [0, 4]
    }
}