package DynamicProgramming;

public class KadanesAlgorithm {
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum= nums[0];
        for(int i=1;i<nums.length;i++){
            if(currentSum<0){
                currentSum= 0;
            }
            currentSum += nums[i];
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // Expected: 6
        int[] nums2 = {1};                             // Expected: 1
        int[] nums3 = {5, 4, -1, 7, 8};               // Expected: 23

        System.out.println( maxSubArray(nums1)); // Output: 6
        System.out.println( maxSubArray(nums2)); // Output: 1
        System.out.println( maxSubArray(nums3)); // Output: 23
    }
}
