    package HashTable.LeetCode;

    import java.util.HashMap;
    import java.util.Map;

    public class TwoSum {
        public static int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int key = target - nums[i];
                if (map.containsKey(key)) {
                    return new int[] { map.get(key), i }; // Return indices if found
                } else {
                    map.put(nums[i], i);
                }
            }
            return new int[]{}; // Return empty array instead of null
        }
        public static void main(String[] args) {
            // Test Case 1
            int[] nums1 = {2, 7, 11, 15};
            int target1 = 9;
            int[] result1 = twoSum(nums1, target1);
            System.out.println("Test Case 1: [" + result1[0] + ", " + result1[1] + "]");

            // Test Case 2
            int[] nums2 = {3, 2, 4};
            int target2 = 6;
            int[] result2 = twoSum(nums2, target2);
            System.out.println("Test Case 2: [" + result2[0] + ", " + result2[1] + "]");

            // Test Case 3
            int[] nums3 = {3, 3};
            int target3 = 6;
            int[] result3 = twoSum(nums3, target3);
            System.out.println("Test Case 3: [" + result3[0] + ", " + result3[1] + "]");

            // Test Case 4 (No valid pair)
            int[] nums4 = {1, 2, 3};
            int target4 = 7;
            int[] result4 = twoSum(nums4, target4);
            if (result4.length == 0) {
                System.out.println("Test Case 4: No valid pair found.");
            } else {
                System.out.println("Test Case 4: [" + result4[0] + ", " + result4[1] + "]");
            }
        }
    }