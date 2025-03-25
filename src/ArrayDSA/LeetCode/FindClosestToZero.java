package ArrayDSA.LeetCode;

public class FindClosestToZero {
    public int findClosestNumber(int[] nums) {
        int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
        for (int num : nums)
            if (num > 0) max = Math.min(max, num);
            else min = Math.max(min, num);
        if (max == Integer.MAX_VALUE) return min;
        else if (min == Integer.MIN_VALUE) return max;
        else if (Math.abs(min) >= max) return max;
        else return min;
    }
}