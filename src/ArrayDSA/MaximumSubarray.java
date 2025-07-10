package ArrayDSA;

import java.util.Scanner;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int maxSum=nums[0];
        int currSum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(currSum<0){
                currSum=0;
            }
            currSum+=nums[i];
            if(currSum>maxSum){
                maxSum=currSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Enter array length");
        Scanner sc = new Scanner(System.in);
        int size=sc.nextInt();
        System.out.println("Enter "+size+" array elements");
        int[] nums=new int[size];
        for(int i=0;i<size;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println("Result: "+maxSubArray(nums));
    }
}

