package HashTable.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int i=0;int n=nums.length;
        while(i<n){
            if(i>=1 && nums[i]==nums[i-1]){
                i++;
                continue;
            }
            int target=-nums[i];
            List<List<Integer>> pairs = twoSum(nums,i+1,target);
            for(List<Integer> pair:pairs){
                List<Integer> triplet = new ArrayList<>();
                triplet.add(nums[i]);
                triplet.add(pair.get(0));
                triplet.add(pair.get(1));
                ans.add(triplet);
            }
            i++;
        }
        return ans;
    }
    private static List<List<Integer>> twoSum(int nums[], int start, int target){
        int f=start,s=nums.length-1;
        int end=nums.length-1;

        List<List<Integer>> pairs = new ArrayList<>();

        while(f<s){
            if(f-1>=start && nums[f]==nums[f-1]){
                f++;
                continue;
            }
            if(s+1<=end && nums[s]==nums[s+1]){
                s--;
                continue;
            }
            if(nums[f]+nums[s]<target){
                f++;
            }
            else if(nums[f]+nums[s]>target){
                s--;
            }
            else{
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[f]);
                pair.add(nums[s]);
                pairs.add(pair);
                f++;
            }
        }
        return pairs;
    }
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test Case 1 Output: " + threeSum(nums1));

        // Test Case 2
        int[] nums2 = {0, 0, 0, 0};
        System.out.println("Test Case 2 Output: " + threeSum(nums2));

        // Test Case 3
        int[] nums3 = {-2, 0, 1, 1, 2};
        System.out.println("Test Case 3 Output: " + threeSum(nums3));

        // Test Case 4
        int[] nums4 = {};
        System.out.println("Test Case 4 Output: " + threeSum(nums4));

        // Test Case 5
        int[] nums5 = {1, 2, -2, -1};
        System.out.println("Test Case 5 Output: " + threeSum(nums5));
    }

}
