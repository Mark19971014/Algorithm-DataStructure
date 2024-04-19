package Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SummaryRange_228 {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        List<String> res = new ArrayList<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            // If right is at the end of the array or the next number is not consecutive...
            if (right + 1 == nums.length || nums[right] + 1 != nums[right + 1]) {
                // If the current number is not the start of the range, add a range "left->right"
                if (left != right) {
                    res.add(nums[left] + "->" + nums[right]);
                } else {
                    // If the current number is the start of the range, add a single number
                    res.add(String.valueOf(nums[left]));
                }
                // Update left to the next new start of a range
                left = right + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums ={0,1,2,4,5,7};
        SummaryRange_228 test = new SummaryRange_228();
        System.out.println(test.summaryRanges(nums));
    }
}
