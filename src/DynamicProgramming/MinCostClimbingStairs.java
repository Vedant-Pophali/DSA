package DynamicProgramming;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] minCost = new int[n + 1];
        minCost[0] = 0;
        minCost[1] = 0;
        for (int i = 2; i <= n; i++) {
            minCost[i] = Math.min(minCost[i - 1] + cost[i - 1], minCost[i - 2] + cost[i - 2]);
        }
        return minCost[n];
    }

    public static void main(String[] args) {
        MinCostClimbingStairs solver = new MinCostClimbingStairs();

        int[][] testCases = {
                {10, 15, 20},
                {1, 100, 1, 1, 1, 100, 1, 1, 100, 1},
                {0, 0, 0, 0},
                {1, 2},
                {5, 5, 10, 1, 100, 1}
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ": Minimum cost = " + solver.minCostClimbingStairs(testCases[i]));
        }
    }
}
