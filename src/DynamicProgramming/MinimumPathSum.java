package DynamicProgramming;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
    public static void main(String[] args) {
        MinimumPathSum solution = new MinimumPathSum();

        int[][] test1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int[][] test2 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] test3 = {
                {5}
        };

        int[][] test4 = {
                {1, 2},
                {1, 1}
        };

        int[][] test5 = {
                {7, 1, 3},
                {2, 8, 1},
                {1, 1, 1}
        };

        System.out.println(solution.minPathSum(test1)); // Expected: 7
        System.out.println(solution.minPathSum(test2)); // Expected: 12
        System.out.println(solution.minPathSum(test3)); // Expected: 5
        System.out.println(solution.minPathSum(test4)); // Expected: 3
        System.out.println(solution.minPathSum(test5)); // Expected: 11
    }
}