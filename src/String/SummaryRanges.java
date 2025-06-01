package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0)
            return ans;

        int start = nums[0], end = start;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] == 1) {
                end = nums[i + 1];
            } else {
                if (start == end) {
                    ans.add(start + "");
                } else {
                    ans.add(start + "->" + end);
                }
                start = nums[i + 1];
                end = start;
            }
        }

        if (start == end) {
            ans.add(start + "");
        } else {
            ans.add(start + "->" + end);
        }

        return ans;
    }

    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();

        int[][] testCases = {
                {},                          // Test 1: Empty input
                {1},                         // Test 2: Single element
                {1, 2, 3},                   // Test 3: Continuous range
                {1, 3, 5, 7},                // Test 4: All isolated numbers
                {0, 1, 2, 4, 5, 7},          // Test 5: Mixed range and gaps
                {-3, -2, -1, 0, 1},          // Test 6: Negative to positive range
                {-5, -3, -2, -1, 0, 2, 3},   // Test 7: Negative with gaps
                {1, 3, 4, 5, 7, 8, 10},      // Test 8: Multiple groups
                {0, 2, 3, 4, 6, 8, 9},       // Test 9: Grouped with gaps
                {Integer.MIN_VALUE, Integer.MIN_VALUE + 1, Integer.MAX_VALUE}  // Test 10: Edge integers
        };

        for (int i = 0; i < testCases.length; i++) {
            List<String> result = sr.summaryRanges(testCases[i]);
            System.out.println("Test Case " + (i + 1) + ": " + Arrays.toString(testCases[i]));
            System.out.println("Summary: " + result + "\n");
        }
    }
}
