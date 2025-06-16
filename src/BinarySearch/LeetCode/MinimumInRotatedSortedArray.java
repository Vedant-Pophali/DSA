package BinarySearch.LeetCode;

public class MinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        int ans = nums[0];
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= nums[0]) { // alpha region
                start = mid + 1;
            } else {
                ans = nums[mid];
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumInRotatedSortedArray sol = new MinimumInRotatedSortedArray();

        int[][] testCases = {
                {4,5,6,7,0,1,2},     // rotated
                {3,4,5,1,2},         // rotated
                {11,13,15,17},       // not rotated
                {2,1},               // small, rotated
                {1}                  // single element
        };

        for (int i = 0; i < testCases.length; i++) {
            int result = sol.findMin(testCases[i]);
            System.out.println("Test case " + (i + 1) + " → Min: " + result);
        }
    }
}