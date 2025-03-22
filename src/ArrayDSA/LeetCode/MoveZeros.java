package ArrayDSA.LeetCode;

import java.util.Arrays;

public class MoveZeros {
    public static int[] moveZeroes(int[] nums) {
        int size=nums.length;
        int k=0;
        for(int i=0;i<size;i++){
            System.out.println("Loop iteration: "+i);

            if(nums[i]!=0){
                int temp=nums[k];
                nums[k]=nums[i];
                nums[i]=temp;
                k++;
            }

            System.out.println(Arrays.toString(nums));
            System.out.println("Value of k = "+k);
        }
        return nums;
    }

    public static void main(String[] args) {
        int arr[]={0,0,0,3,12};
        System.out.println(Arrays.toString(moveZeroes(arr)));

    }
}
