package DynamicProgramming;

public class HouseRobber {
    public static int rob(int[] nums) {
        int[][] dp = new int[2][2];
        dp[0][0]=0;
        dp[0][1]=0;
        dp[1][0]=0;
        dp[1][1]=0;
        for (int num : nums) {
            dp[0][1] = Math.max(dp[0][0], dp[1][0]);
            dp[1][1] = num + dp[0][0];
            dp[0][0] = dp[0][1];
            dp[1][0] = dp[1][1];
        }
        return Math.max(dp[0][1],dp[1][1]);
    }
    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 1};
        int[] test2 = {2, 7, 9, 3, 1};
        int[] test3 = {2, 1, 1, 2};
        int[] test4 = {5, 5, 10, 100, 10, 5};
        int[] test5 = {90, 1, 1, 90};

        System.out.println(rob(test1)); // Expected: 4
        System.out.println(rob(test2)); // Expected: 12
        System.out.println(rob(test3)); // Expected: 4
        System.out.println(rob(test4)); // Expected: 110
        System.out.println(rob(test5)); // Expected: 180
    }
}