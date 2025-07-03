package ArrayDSA.LeetCode;

public class ToeplitzMatrix {

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows == 1 || cols == 1) {
            return true;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] test1 = {
                {1, 2, 3},
                {4, 1, 2},
                {5, 4, 1}
        };
        int[][] test2 = {
                {1, 2},
                {2, 2}
        };
        int[][] test3 = {
                {7}
        };
        int[][] test4 = {
                {3, 4, 5, 6},
                {7, 3, 4, 5},
                {8, 7, 3, 4}
        };
        int[][] test5 = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2},
                {8, 9, 5, 1}
        };

        System.out.println("Test 1: " + isToeplitzMatrix(test1)); // true
        System.out.println("Test 2: " + isToeplitzMatrix(test2)); // false
        System.out.println("Test 3: " + isToeplitzMatrix(test3)); // true
        System.out.println("Test 4: " + isToeplitzMatrix(test4)); // true
        System.out.println("Test 5: " + isToeplitzMatrix(test5)); // true
    }
}