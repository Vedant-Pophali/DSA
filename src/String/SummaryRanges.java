package String;

import java.util.ArrayList;
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
                } else
                    ans.add(start + "->" + end);
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
}
