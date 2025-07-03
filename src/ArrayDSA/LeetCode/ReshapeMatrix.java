package ArrayDSA.LeetCode;

public class ReshapeMatrix {

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int iniR = mat.length;
        int iniC = mat[0].length;
        int inter[] = new int[r * c];
        int[][] ans = new int[r][c];
        if ((iniC * iniR) != (r * c)) {
            return mat;
        } else {
            int k = 0;
            for (int i = 0; i < iniR; i++) {
                for (int j = 0; j < iniC; j++) {
                    inter[k++] = mat[i][j];
                }
            }
            k = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    ans[i][j] = inter[k++];
                }
            }
            return ans;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] test1 = {
                {1, 2},
                {3, 4}
        };

        int[][] test2 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] test3 = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        int[][] test4 = {
                {1}
        };

        int[][] test5 = {
                {1, 2, 3, 4}
        };

        System.out.println("Test 1:");
        printMatrix(matrixReshape(test1, 1, 4));

        System.out.println("Test 2:");
        printMatrix(matrixReshape(test2, 3, 2));

        System.out.println("Test 3:");
        printMatrix(matrixReshape(test3, 2, 3)); // invalid reshape, should return original
        // Verify by printing
        System.out.println("Returned original:");
        printMatrix(matrixReshape(test3, 4, 2)); // valid reshape

        System.out.println("Test 4:");
        printMatrix(matrixReshape(test4, 1, 1));

        System.out.println("Test 5:");
        printMatrix(matrixReshape(test5, 2, 2)); // invalid, returns original
    }
}