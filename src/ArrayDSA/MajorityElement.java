package ArrayDSA;
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int mc=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==mc){
                count++;
            }
            else{
                count--;
                if(count==0){
                    mc=nums[i];
                    count=1;
                }
            }
        }
        return mc;
    }

    public static void main(String[] args) {
        int arr[]={2,2,1,1,1,3,2,2,2};
        System.out.println(majorityElement(arr));
    }
}