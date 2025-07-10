package ArrayDSA;
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int maxProd=nums[0];
        int minProd=nums[0];
        int res=nums[0];
        int temp=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>=0){
                maxProd*=nums[i];
                minProd*=nums[i];
                maxProd=Math.max(maxProd,nums[i]);
                minProd=Math.min(minProd,nums[i]);
            }
            else{
                temp=maxProd;
                maxProd=Math.max(nums[i],minProd*nums[i]);
                minProd=Math.min(nums[i],temp*nums[i]);
            }
            res=Math.max(maxProd,res);
        }
        return res;
    }
}