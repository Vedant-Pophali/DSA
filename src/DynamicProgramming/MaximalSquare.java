package DynamicProgramming;
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int maxSide = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = Math.min(dp[i - 1][j],
                                Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        MaximalSquare solver = new MaximalSquare();

        char[][][] testMatrices = {
                {   // Test 1
                        {'1'}
                },
                {   // Test 2
                        {'0'}
                },
                {   // Test 3
                        {'1', '1'},
                        {'1', '1'}
                },
                {   // Test 4
                        {'0', '1'},
                        {'1', '0'}
                },
                {   // Test 5
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}
                },
                {   // Test 6
                        {'0', '0', '0'},
                        {'0', '0', '0'},
                        {'0', '0', '0'}
                },
                {   // Test 7
                        {'1', '1', '0', '1'}
                },
                {   // Test 8
                        {'1'},
                        {'1'},
                        {'1'},
                        {'1'}
                },
                {   // Test 9
                        {'1', '1', '1', '1'},
                        {'1', '1', '1', '1'},
                        {'1', '1', '1', '1'},
                        {'1', '1', '1', '1'}
                },
                {   // Test 10
                        {'1', '0', '1', '0'},
                        {'0', '1', '0', '1'},
                        {'1', '0', '1', '0'},
                        {'0', '1', '0', '1'}
                }
        };

        for (int i = 0; i < testMatrices.length; i++) {
            int area = solver.maximalSquare(testMatrices[i]);
            System.out.println("Test Case " + (i + 1) + ": Maximal square area = " + area);
        }
    }
}
