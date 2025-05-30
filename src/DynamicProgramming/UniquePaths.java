package DynamicProgramming;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 ||j==0){
                    dp[i][j]=1;
                }
                else{
                    dp[i][j]=dp[i][j-1]+dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();

        System.out.println(solution.uniquePaths(3, 7));  // Expected: 28
        System.out.println(solution.uniquePaths(3, 2));  // Expected: 3
        System.out.println(solution.uniquePaths(7, 3));  // Expected: 28
        System.out.println(solution.uniquePaths(3, 3));  // Expected: 6
        System.out.println(solution.uniquePaths(1, 10)); // Expected: 1
    }
}