package ArrayDSA;
public class FindDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        // Phase 1: Detect the meeting point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle (duplicate number)
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {2, 6, 4, 1, 3, 1, 5};
        System.out.println("Duplicate in nums1: " + findDuplicate(nums1)); // Output: 1

        // Test case 2
        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println("Duplicate in nums2: " + findDuplicate(nums2)); // Output: 3

        // Test case 3
        int[] nums3 = {1, 3, 4, 2, 2};
        System.out.println("Duplicate in nums3: " + findDuplicate(nums3)); // Output: 2

        // Test case 4
        int[] nums4 = {5, 4, 3, 2, 1, 5};
        System.out.println("Duplicate in nums4: " + findDuplicate(nums4)); // Output: 5
    }
}
