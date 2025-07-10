package ArrayDSA;

public class CountNegativeNumbersInASortedMatrix {

    public static int countNegatives(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void printMatrix(int[][] grid) {
        for (int[] row : grid) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] test1 = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };

        int[][] test2 = {
                {3, 2},
                {1, 0}
        };

        int[][] test3 = {
                {-1}
        };

        int[][] test4 = {
                {5, 1, 0},
                {-1, -2, -3},
                {-4, -5, -6}
        };

        int[][] test5 = {
                {-3, -2, -1, -1},
                {-2, -2, -1, -1},
                {-1, -1, -1, -1}
        };

        System.out.println("Test 1:");
        printMatrix(test1);
        System.out.println("Negative Count: " + countNegatives(test1));

        System.out.println("Test 2:");
        printMatrix(test2);
        System.out.println("Negative Count: " + countNegatives(test2));

        System.out.println("Test 3:");
        printMatrix(test3);
        System.out.println("Negative Count: " + countNegatives(test3));

        System.out.println("Test 4:");
        printMatrix(test4);
        System.out.println("Negative Count: " + countNegatives(test4));

        System.out.println("Test 5:");
        printMatrix(test5);
        System.out.println("Negative Count: " + countNegatives(test5));
    }
}