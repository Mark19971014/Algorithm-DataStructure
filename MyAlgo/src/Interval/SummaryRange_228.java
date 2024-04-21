package Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SummaryRange_228 {
    public List<String> summaryRanges(int[] nums) {
            if(nums == null) return null;
            List<String> res = new ArrayList<>();
            int left = 0;
            for(int right = 0; right < nums.length;right++){
                if( right + 1 == nums.length || nums[right] + 1 != nums[right + 1]){
                    if(left != right){
                        res.add(nums[left] + "->" + nums[right]);
                    }else{
                        // the range only contain a single element
                        res.add(String.valueOf(nums[left]));
                    }

                    // start a new range;
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
