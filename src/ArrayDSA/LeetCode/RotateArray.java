package ArrayDSA.LeetCode;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        k=k%size;
        System.out.println(Arrays.toString(nums));
        reverse(nums, 0, size-1);
        reverse(nums,0,k-1);
        reverse(nums, k, size-1);
        System.out.println("Array after rotation is: "+ Arrays.toString(nums));
    }

    void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;  // Increment start pointer
            end--;    // Decrement end pointer
        }
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int arr[]={-1,-100,3,99};
        int nums[] = {1,2,3,4,5,6,7};
        rotateArray.rotate(arr,2);
//        rotateArray.rotate(nums,3);
    }
}
