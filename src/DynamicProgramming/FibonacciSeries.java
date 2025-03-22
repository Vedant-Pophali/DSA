package DynamicProgramming;

public class FibonacciSeries {
    public static int fibonacci(int n) {
        int[] dp = new int[n+1];
        return helper(n,dp);
    }

    public static int helper(int n, int[] dp){
        if(n<=1) return n;
        if(dp[n]!=0) return dp[n];
        return helper(n-1,dp)+helper(n-2,dp);
    }
    public static void main(String[] args) {
        System.out.println("fib(2) = " + fibonacci(2)); // Expected: 1
        System.out.println("fib(3) = " + fibonacci(3)); // Expected: 2
        System.out.println("fib(4) = " + fibonacci(4)); // Expected: 3
        System.out.println("fib(5) = " + fibonacci(5)); // Expected: 5
        System.out.println("fib(6) = " + fibonacci(6)); // Expected: 8
        System.out.println("fib(10) = " + fibonacci(10)); // Expected: 55
    }
}
