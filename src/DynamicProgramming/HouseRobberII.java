package DynamicProgramming;

public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp1 = new int[n - 1];
        int[] dp2 = new int[n - 1];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);

        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);

        for (int i = 2; i <= n - 2; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }

        for (int i = 2; i <= n - 2; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i + 1]);
        }

        return Math.max(dp1[n - 2], dp2[n - 2]);
    }

    public static void main(String[] args) {
        HouseRobberII solution = new HouseRobberII();

        int[] test1 = {2, 3, 2};
        int[] test2 = {1, 2, 3, 1};
        int[] test3 = {1, 2, 3};
        int[] test4 = {5, 1, 1, 5};
        int[] test5 = {6, 7, 1, 30, 8, 2, 4};

        System.out.println(solution.rob(test1)); // Expected: 3
        System.out.println(solution.rob(test2)); // Expected: 4
        System.out.println(solution.rob(test3)); // Expected: 3
        System.out.println(solution.rob(test4)); // Expected: 10
        System.out.println(solution.rob(test5)); // Expected: 41
    }
}
