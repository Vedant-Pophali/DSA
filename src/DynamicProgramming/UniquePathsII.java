package DynamicProgramming;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = (obstacleGrid[0][0] == 0) ? 1 : 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1) ? 1 : 0;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = (obstacleGrid[0][j] == 0 && dp[0][j - 1] == 1) ? 1 : 0;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        UniquePathsII solution = new UniquePathsII();

        int[][] test1 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] test2 = {
                {0, 1},
                {0, 0}
        };
        int[][] test3 = {
                {1}
        };
        int[][] test4 = {
                {0, 0},
                {1, 1},
                {0, 0}
        };
        int[][] test5 = {
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };

        System.out.println(solution.uniquePathsWithObstacles(test1)); // Expected: 2
        System.out.println(solution.uniquePathsWithObstacles(test2)); // Expected: 1
        System.out.println(solution.uniquePathsWithObstacles(test3)); // Expected: 0
        System.out.println(solution.uniquePathsWithObstacles(test4)); // Expected: 0
        System.out.println(solution.uniquePathsWithObstacles(test5)); // Expected: 3
    }

}
