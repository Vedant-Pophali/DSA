package ArrayDSA;

import java.util.Arrays;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][][] testCases = {
                { {1, 1, 1}, {1, 0, 1}, {1, 1, 1} },
                { {0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5} },
                { {1, 2}, {3, 0} },
                { {0, 0}, {0, 0} },
                { {5, 4, 3, 9}, {2, 0, 7, 6}, {1, 3, 4, 0}, {9, 8, 3, 4} }
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case #" + (i + 1));
            System.out.println("Original Matrix:");
            printMatrix(testCases[i]);

            setZeroes(testCases[i]);

            System.out.println("Modified Matrix:");
            printMatrix(testCases[i]);
            System.out.println("---------------");
        }
    }

    // Set entire row and column to zero if any element is zero
    public static void setZeroes(int[][] matrix) {
        boolean firstRow = false, firstCol = false;
        int m = matrix.length;
        int n = matrix[0].length;

        // Identify zeroes and mark first row and col
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRow = true;
                    if (j == 0) firstCol = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set zeroes for non-first rows/cols based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set zeroes for first row if needed
        if (firstRow) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Set zeroes for first column if needed
        if (firstCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // Helper to print matrix
    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }
}
