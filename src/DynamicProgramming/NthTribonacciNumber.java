package DynamicProgramming;

public class NthTribonacciNumber {
    public int trib(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <=n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NthTribonacciNumber obj = new NthTribonacciNumber();
        int[] testCases = {0, 1, 2, 3, 4, 5, 10, 15, 20, 25}; // Multiple test cases

        for (int n : testCases) {
            System.out.println("The " + n + "th Tribonacci number is: " + obj.trib(n));
        }
    }
}