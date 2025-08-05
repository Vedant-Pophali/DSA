package ArrayDSA;

import java.util.Arrays;

public class BestTimeToBuyAndSellAStock{
    public static void main(String[] args) {
        int[][] testCases = {
                {7, 1, 5, 3, 6, 4},
                {7, 6, 4, 3, 1},
                {1, 2, 3, 4, 5},
                {3, 3, 5, 0, 0, 3, 1, 4},
                {2, 4, 1}
        };
        for (int i = 0; i < testCases.length; i++) {
            int[] prices = testCases[i];
            System.out.println("Test Case #" + (i + 1));
            System.out.println("Prices: " + Arrays.toString(prices));

            int profit = maxProfit(prices);

            System.out.println("Max Profit: " + profit);
            System.out.println("---------------");
        }
    }

    // One-pass profit calculation
    public static int maxProfit(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int buyPrice = nums[0];
        int maxProf = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < buyPrice) {
                buyPrice = nums[i];
            } else {
                int currProf = nums[i] - buyPrice;
                maxProf = Math.max(maxProf, currProf);
            }
        }
        return maxProf;
    }
}