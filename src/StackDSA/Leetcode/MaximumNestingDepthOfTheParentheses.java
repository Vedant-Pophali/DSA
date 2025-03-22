package StackDSA.Leetcode;

import java.util.Stack;

public class MaximumNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        Stack<Character> stk = new Stack<>();
        int max=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                stk.push(ch);
                count++;
                max = Math.max(max, count);
            }
            else if(!stk.isEmpty() && ch==')'){
                stk.pop();
                count--;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        MaximumNestingDepthOfTheParentheses solution = new MaximumNestingDepthOfTheParentheses();

        System.out.println(solution.maxDepth("(1+(2*3)+((8)/4))+1")); // Expected: 3
        System.out.println(solution.maxDepth("(1)+((2))+(((3)))"));   // Expected: 3
        System.out.println(solution.maxDepth("()(())((()()))"));      // Expected: 3
        System.out.println(solution.maxDepth("((()))"));              // Expected: 3
        System.out.println(solution.maxDepth("()"));                  // Expected: 1
        System.out.println(solution.maxDepth(""));                    // Expected: 0
    }
}
