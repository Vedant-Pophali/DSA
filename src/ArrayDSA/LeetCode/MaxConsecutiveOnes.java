package ArrayDSA.LeetCode;
public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int ans=0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]==1){
                count++;
                ans=count;
            }
            else if(nums[i]==0){
                count=0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[]={1,1,0,1,1,1,0};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}