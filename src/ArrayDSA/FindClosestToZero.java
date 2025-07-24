package ArrayDSA;

public class FindClosestToZero {

    public int findClosestNumber(int[] nums) {
        int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > 0) max = Math.min(max, num);
            else min = Math.max(min, num);
        }

        if (max == Integer.MAX_VALUE) return min;
        else if (min == Integer.MIN_VALUE) return max;
        else if (Math.abs(min) >= max) return max;
        else return min;
    }

    public static void main(String[] args) {
        FindClosestToZero finder = new FindClosestToZero();

        int[] nums1 = {-4, -2, 1, 4, 3};
        System.out.println("Closest to zero (nums1): " + finder.findClosestNumber(nums1)); // Output: 1

        int[] nums2 = {-10, -5, -3, -1};
        System.out.println("Closest to zero (nums2): " + finder.findClosestNumber(nums2)); // Output: -1

        int[] nums3 = {2, 3, 5, 7};
        System.out.println("Closest to zero (nums3): " + finder.findClosestNumber(nums3)); // Output: 2

        int[] nums4 = {-2, 2, -1, 1};
        System.out.println("Closest to zero (nums4): " + finder.findClosestNumber(nums4)); // Output: 1

        int[] nums5 = {0};
        System.out.println("Closest to zero (nums5): " + finder.findClosestNumber(nums5)); // Output: 0
    }
}