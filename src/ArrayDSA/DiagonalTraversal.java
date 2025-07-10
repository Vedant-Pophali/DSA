package ArrayDSA;
public class DiagonalTraversal {

    public static int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[0];
        }

        int rows = mat.length;
        int cols = mat[0].length;
        int[] res = new int[rows * cols];

        int i = 0, j = 0, index = 0;
        boolean up = true;  // true -> up-right, false -> down-left

        while (index < res.length) {
            res[index++] = mat[i][j];

            if (up) {
                if (j == cols - 1) {
                    i++;
                    up = false;
                } else if (i == 0) {
                    j++;
                    up = false;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (i == rows - 1) {
                    j++;
                    up = true;
                } else if (j == 0) {
                    i++;
                    up = true;
                } else {
                    i++;
                    j--;
                }
            }
        }

        return res;
    }

    public static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Case 1
        int[][] mat1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.print("Test 1: ");
        printArray(findDiagonalOrder(mat1));  // Expected: 1 2 4 7 5 3 6 8 9

        // Test Case 2
        int[][] mat2 = {
                {1, 2},
                {3, 4}
        };
        System.out.print("Test 2: ");
        printArray(findDiagonalOrder(mat2));  // Expected: 1 2 3 4

        // Test Case 3
        int[][] mat3 = {
                {1}
        };
        System.out.print("Test 3: ");
        printArray(findDiagonalOrder(mat3));  // Expected: 1

        // Test Case 4
        int[][] mat4 = {
                {1},
                {2},
                {3}
        };
        System.out.print("Test 4: ");
        printArray(findDiagonalOrder(mat4));  // Expected: 1 2 3

        // Test Case 5
        int[][] mat5 = {
                {1, 2, 3, 4}
        };
        System.out.print("Test 5: ");
        printArray(findDiagonalOrder(mat5));  // Expected: 1 2 3 4
    }
}
