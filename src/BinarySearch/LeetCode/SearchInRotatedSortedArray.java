package BinarySearch.LeetCode;
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int por = smallestElementIndex(nums); // index of smallest element (pivot = first β)

        // Decide which region (α or β) the target belongs to
        if (target >= nums[por] && target <= nums[nums.length - 1]) {
            // In β region → search right
            return bs(nums, target, por, nums.length - 1);
        } else {
            // In α region → search left
            return bs(nums, target, 0, por - 1);
        }
    }
    public static int bs(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    public static int smallestElementIndex(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;

            if (nums[mid] > nums[end]) {
                // I'm in α region → move right to reach β region
                start = mid + 1;
            } else {
                // I'm in β region → move left to find first β
                end = mid;
            }
        }

        return start; // index of first β (smallest element)
    }
    public static void main(String[] args) {
        int[][] testCases = {
                {4, 5, 6, 7, 0, 1, 2},
                {3, 1},
                {1, 3},
                {1},
                {6, 7, 8, 1, 2, 3, 4}
        };
        int[] targets = {0, 1, 3, 1, 8};

        for (int i = 0; i < testCases.length; i++) {
            int result = search(testCases[i], targets[i]);
            System.out.println("Test Case " + (i + 1) + ": Output = " + result);
        }
    }
}