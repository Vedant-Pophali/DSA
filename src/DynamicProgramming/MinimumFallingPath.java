package DynamicProgramming;
public class MinimumFallingPath {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        System.arraycopy(matrix[0], 0, dp[0], 0, n);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = j > 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int up = dp[i - 1][j];
                int right = j < n - 1 ? dp[i - 1][j + 1] : Integer.MAX_VALUE;
                dp[i][j] = Math.min(Math.min(left, up), right) + matrix[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[m - 1][j]);
        }
        return min;
    }
    public static void main(String[] args) {
        MinimumFallingPath solver = new MinimumFallingPath();
        int[][][] testCases = {
                {
                        {2, 1, 3},
                        {6, 5, 4},
                        {7, 8, 9}
                },
                {
                        {-19, 57},
                        {-40, -5}
                },
                {
                        {100}
                },
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                },
                {
                        {1, 2},
                        {3, 4}
                }
        };
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ": Minimum Falling Path Sum = " +
                    solver.minFallingPathSum(testCases[i]));
        }
    }
}