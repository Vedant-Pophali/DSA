package ArrayDSA;

import java.util.*;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new IntervalComparator());

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        // Test case 1
        int[][] intervals1 = { {1,3}, {2,6}, {8,10}, {15,18} };
        printTestResult(intervals1, "Test Case 1");

        // Test case 2
        int[][] intervals2 = { {1,4}, {4,5} };
        printTestResult(intervals2, "Test Case 2");

        // Test case 3
        int[][] intervals3 = { {1,4}, {2,3} };
        printTestResult(intervals3, "Test Case 3");

        // Test case 4
        int[][] intervals4 = { {1,3}, {2,6}, {8,10}, {9,12}, {15,18} };
        printTestResult(intervals4, "Test Case 4");

        // Test case 5
        int[][] intervals5 = { {1,2}, {3,4}, {5,6} };
        printTestResult(intervals5, "Test Case 5");
    }

    private static void printTestResult(int[][] intervals, String testCase) {
        System.out.println(testCase + " - Input: " + Arrays.deepToString(intervals));
        int[][] merged = merge(intervals);
        System.out.println("Output: " + Arrays.deepToString(merged));
        System.out.println("--------------------------------------------------");
    }
}
// Custom Comparator Class
class IntervalComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        return Integer.compare(a[0], b[0]);
    }
}