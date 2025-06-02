package DynamicProgramming;

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[1], nums[0]);
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        HouseRobber solution = new HouseRobber();

        int[] test1 = {1, 2, 3, 1};
        int[] test2 = {2, 7, 9, 3, 1};
        int[] test3 = {2};
        int[] test4 = {1, 2};
        int[] test5 = {5, 5, 10, 100, 10, 5};

        System.out.println(solution.rob(test1)); // Expected: 4
        System.out.println(solution.rob(test2)); // Expected: 12
        System.out.println(solution.rob(test3)); // Expected: 2
        System.out.println(solution.rob(test4)); // Expected: 2
        System.out.println(solution.rob(test5)); // Expected: 110
    }
}
