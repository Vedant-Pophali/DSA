package LinkedList.LeetCode;
import java.util.*;
public class PascalsTriangle {
    public static void main(String[] args) {
        int[] testCases = {1, 2, 3, 5, 7};
        for (int i = 0; i < testCases.length; i++) {
            int numRows = testCases[i];
            System.out.println("Test Case #" + (i + 1) + ": Pascal's Triangle with " + numRows + " rows");
            List<List<Integer>> triangle = generate(numRows);
            printCenteredTriangle(triangle);
            System.out.println("---------------");
        }
    }
    // Generate Pascal's Triangle
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) return res;

        res.add(List.of(1)); // First row

        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = res.get(i - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(prev.get(j - 1) + prev.get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }

    // Print Pascal’s Triangle with spacing
    public static void printCenteredTriangle(List<List<Integer>> triangle) {
        int maxRowLength = triangle.get(triangle.size() - 1).size();

        for (List<Integer> row : triangle) {
            int spaces = (maxRowLength - row.size()) * 2;
            System.out.print(" ".repeat(spaces));
            for (int num : row) {
                System.out.printf("%4d", num); // 4-width spacing per number
            }
            System.out.println();
        }
    }
}