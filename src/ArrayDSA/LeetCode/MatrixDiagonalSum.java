package ArrayDSA.LeetCode;

public class MatrixDiagonalSum {

    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i]; // Primary diagonal
            if (i != n - 1 - i) { // Avoid double-counting center in odd-length matrix
                sum += mat[i][n - 1 - i]; // Secondary diagonal
            }
        }
        return sum;
    }

    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] test1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] test2 = {
                {5}
        };

        int[][] test3 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        int[][] test4 = {
                {7, 1, 4, 3},
                {2, 8, 6, 4},
                {3, 5, 9, 1},
                {6, 2, 7, 5}
        };

        int[][] test5 = {
                {10, 20},
                {30, 40}
        };

        System.out.println("Test 1:");
        printMatrix(test1);
        System.out.println("Diagonal Sum: " + diagonalSum(test1));

        System.out.println("Test 2:");
        printMatrix(test2);
        System.out.println("Diagonal Sum: " + diagonalSum(test2));

        System.out.println("Test 3:");
        printMatrix(test3);
        System.out.println("Diagonal Sum: " + diagonalSum(test3));

        System.out.println("Test 4:");
        printMatrix(test4);
        System.out.println("Diagonal Sum: " + diagonalSum(test4));

        System.out.println("Test 5:");
        printMatrix(test5);
        System.out.println("Diagonal Sum: " + diagonalSum(test5));
    }
}