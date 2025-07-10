package ArrayDSA;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int prod=1;
        int left[]= new int[nums.length];
        int right[]= new int[nums.length];

        int size=nums.length;

        left[0]=1;
        right[size-1]=1;

        int ans[]= new int[nums.length];
        for(int i=1;i<nums.length;i++){
            left[i]=left[i-1]*nums[i-1];
        }
        for(int i=nums.length-2;i>-1;i--){
            right[i]=right[i+1]*nums[i+1];
        }
        for(int i=0;i<nums.length;i++){
            ans[i]=left[i]*right[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};
        int[] result = obj.productExceptSelf(nums);

        System.out.print("Product array except self: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

}
