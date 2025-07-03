package ArrayDSA.LeetCode;

import java.util.Arrays;

public class FlippingAnImage {
    public static int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int[][] flip = new int[n][n];
        for (int i = 0; i < n; i++) {
            int k = n - 1;
            for (int j = 0; j < n; j++) {
                flip[i][j] = image[i][k];
                k--;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (flip[i][j] == 1) {
                    flip[i][j] = 0;
                } else {
                    flip[i][j] = 1;
                }
            }
        }

        return flip;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        int[][] image1 = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };
        System.out.println("Test 1:");
        printMatrix(flipAndInvertImage(image1));

        // Test Case 2
        int[][] image2 = {
                {1, 1},
                {0, 0}
        };
        System.out.println("\nTest 2:");
        printMatrix(flipAndInvertImage(image2));

        // Test Case 3
        int[][] image3 = {
                {1}
        };
        System.out.println("\nTest 3:");
        printMatrix(flipAndInvertImage(image3));

        // Test Case 4
        int[][] image4 = {
                {0, 1, 1},
                {1, 1, 0},
                {1, 0, 0}
        };
        System.out.println("\nTest 4:");
        printMatrix(flipAndInvertImage(image4));

        // Test Case 5
        int[][] image5 = {
                {0, 0, 1},
                {1, 1, 1},
                {0, 1, 0}
        };
        System.out.println("\nTest 5:");
        printMatrix(flipAndInvertImage(image5));
    }
}