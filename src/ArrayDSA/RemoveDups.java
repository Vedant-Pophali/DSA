package ArrayDSA;

import java.util.Arrays;

public class RemoveDups {
        public int removeDuplicates(int[] nums) {
            int k = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    nums[k] = nums[i];
                    k++;
                }
            }
            System.out.println(Arrays.toString(nums));
            return k;
        }
    public static void main(String[] args) {
        RemoveDups r = new RemoveDups();
        System.out.println(r.removeDuplicates(new int[]{1,2,2}));
    }
}