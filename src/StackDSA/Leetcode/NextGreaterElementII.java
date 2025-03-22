    package StackDSA.Leetcode;

    import java.util.Arrays;
    import java.util.Stack;
    public class NextGreaterElementII {
        public int[] nextGreaterElements(int[] nums) {
            Stack<Integer> stack =  new Stack<>();
            stack.push(0);
            int ans[] = new int[nums.length];
            for(int i=1;i<nums.length;i++){
                while(stack.size()>0 && nums[stack.peek()]<nums[i]){
                    ans[stack.peek()]=nums[i];
                    stack.pop();
                }
                stack.push(i);
            }
            for(int i=0 ;i<nums.length;i++){
                while(stack.size()>0 && nums[stack.peek()]<nums[i]){
                    ans[stack.peek()]=nums[i];
                    stack.pop();
                }
            }
            while(stack.size()>0){
                ans[stack.peek()]=-1;
                stack.pop();
            }
            return ans;
        }
        public static void main(String[] args) {
            NextGreaterElementII obj = new NextGreaterElementII();
            int[] nums = {1, 2, 1};
            int[] result = obj.nextGreaterElements(nums);
            System.out.println("Next Greater Elements: " + Arrays.toString(result));
        }
    }
