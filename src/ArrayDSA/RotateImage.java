package ArrayDSA;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][][] testCases = {
                { {1, 2}, {3, 4} },
                { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} },
                { {5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16} },
                { {1} },
                { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16} }
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case #" + (i + 1));
            System.out.println("Original Matrix:");
            printMatrix(testCases[i]);

            rotate(testCases[i]);

            System.out.println("Rotated Matrix:");
            printMatrix(testCases[i]);
            System.out.println("---------------");
        }
    }

    // Rotates matrix 90° clockwise
    public static void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRows(matrix);
    }

    // Transpose: row becomes column
    public static void transpose(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (i != j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

    // Reverse each row
    public static void reverseRows(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            int left = 0, right = N - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    // Print helper
    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }
}