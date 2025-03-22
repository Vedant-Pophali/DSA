package StackDSA.Leetcode;
import java.util.Stack;
public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for(String token : tokens){
        if(isOperator(token)){
            int operand2=stack.pop();
            int operand1=stack.pop();
            int res = evaluate(token,operand1,operand2);
            stack.push(res);
        }
        else{
            stack.push(Integer.parseInt(token));
        }
    }
    return stack.pop();
}
    public static boolean isOperator(String token){
        return  token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/");
    }
    public static int evaluate(String token,int op1,int op2){
        if(token.equals("+")){
            return op1+op2;
        }
        else if(token.equals("-")){
            return op1-op2;
        }
        else if(token.equals("*")){
            return op1*op2;
        }
        else{
            return op1/op2;
        }
    }
    public static void main(String[] args) {
        ReversePolishNotation obj = new ReversePolishNotation();
        String[] tokens = {"2", "1", "+", "3", "*"};
        int result = obj.evalRPN(tokens);
        System.out.println("Evaluated Result: " + result);
    }
}
