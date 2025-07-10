package ArrayDSA;

import java.util.Arrays;

public class SortColours {
    public static void sortColors(int[] nums) {
        int size=nums.length;
        int left=0;int right=size-1;
        int i=0;
        while(i<=right) {
            System.out.println("Iteration "+ i);
            if(nums[i]==0){
                int tmp=nums[left];
                nums[left]=nums[i];
                nums[i]=tmp;
                left++;
                i++;
            }
            else if(nums[i]==2){
                int tmp=nums[right];
                nums[right]=nums[i];
                nums[i]=tmp;
                right--;
            }
            else{
                i++;
            }
            System.out.println(Arrays.toString(nums)+"\n");
        }
        System.out.println(Arrays.toString(nums));

    }
    public static void main(String[] args) {
        int arr[]={1,0,2};
        sortColors(arr);
    }
}