package StackDSA.Leetcode;
import java.util.Stack;
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stk.push(ch);
            }
            else if (!stk.isEmpty() &&
                    ((ch == '}' && stk.peek() == '{') ||
                            (ch == ']' && stk.peek() == '[') ||
                            (ch == ')' && stk.peek() == '('))) {
                stk.pop();
            }
            else {
                return false;
            }
        }
        return stk.isEmpty();
    }
    public static void main(String[] args) {
        ValidParentheses obj = new ValidParentheses();
        String s = "()[]{}";
        boolean result = obj.isValid(s);
        System.out.println("Is valid parentheses: " + result);
    }


}