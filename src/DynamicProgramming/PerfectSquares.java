package DynamicProgramming;

class PerfectSquares {
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();

        int[] testCases = {12, 13, 1, 43, 100};
        for (int i = 0; i < testCases.length; i++) {
            int n = testCases[i];
            int result = ps.numSquares(n);
            System.out.println("Test Case " + (i + 1) + ": n = " + n);
            System.out.println("Minimum number of perfect squares: " + result);
            System.out.println("--------------------------------------");
        }
    }
}