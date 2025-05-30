package DynamicProgramming;
public class DeleteANDEarn {
        public int deleteAndEarn(int[] nums) {
            int[] values = new int[10_002];
            for(int i:nums){
                values[i]+=i;
            }
            return houseRobber(values);
        }
        public int houseRobber(int[] values){
            int[] dp = new int[values.length];
            dp[0]=values[0];
            dp[1]=Math.max(dp[0],values[1]);

            for(int i=2;i<values.length;i++){
                dp[i]=Math.max(values[i]+dp[i-2],dp[i-1]);
            }
            return dp[values.length-1];
        }

    public static void main(String[] args) {
        DeleteANDEarn solution = new DeleteANDEarn();

        int[] test1 = {3, 4, 2};
        int[] test2 = {2, 2, 3, 3, 3, 4};
        int[] test3 = {1};
        int[] test4 = {1, 1, 1, 2, 4, 5, 5, 5, 6};
        int[] test5 = {8, 10, 4, 9, 1, 3, 5, 9, 4, 10};

        System.out.println(solution.deleteAndEarn(test1)); // Expected: 6
        System.out.println(solution.deleteAndEarn(test2)); // Expected: 9
        System.out.println(solution.deleteAndEarn(test3)); // Expected: 1
        System.out.println(solution.deleteAndEarn(test4)); // Expected: 18
        System.out.println(solution.deleteAndEarn(test5)); // Expected: 37
    }
}