package DynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[][] dp = new int[height + 1][height + 1];

        for (int level = height - 1; level > -1; level--) {
            for (int i = 0; i <= level; i++) {
                dp[level][i] = triangle.get(level).get(i) + Math.min(dp[level + 1][i], dp[level + 1][i + 1]);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        Triangle solution = new Triangle();

        List<List<Integer>> test1 = Arrays.asList(
                List.of(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );

        List<List<Integer>> test2 = List.of(
                List.of(-10)
        );

        List<List<Integer>> test3 = Arrays.asList(
                List.of(1),
                Arrays.asList(2, 3),
                Arrays.asList(3, 6, 7),
                Arrays.asList(8, 9, 6, 10)
        );

        List<List<Integer>> test4 = Arrays.asList(
                Arrays.asList(5),
                Arrays.asList(9, 6),
                Arrays.asList(4, 6, 8),
                Arrays.asList(0, 7, 1, 5)
        );

        List<List<Integer>> test5 = Arrays.asList(
                List.of(1),
                Arrays.asList(1, 1),
                Arrays.asList(1, 1, 1),
                Arrays.asList(1, 1, 1, 1)
        );

        System.out.println(solution.minimumTotal(test1)); // Expected: 11
        System.out.println(solution.minimumTotal(test2)); // Expected: -10
        System.out.println(solution.minimumTotal(test3)); // Expected: 14
        System.out.println(solution.minimumTotal(test4)); // Expected: 15
        System.out.println(solution.minimumTotal(test5)); // Expected: 4
    }

}