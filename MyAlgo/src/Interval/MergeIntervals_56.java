package Interval;

import java.util.Arrays;

public class MergeIntervals_56 {

    public int[][] merge(int[][] interval) {

        sort(interval);

        int length = interval.length;

        int[][] result = new int[length][2];
        int count = 0; // Track the number of merged intervals

        for (int i = 0; i < length; i++) {
            if (interval[i] == null) {
                continue;
            }

            int curStart = interval[i][0];
            int curEnd = interval[i][1];

            for (int j = i + 1; j < length; j++) {
                if (interval[j] == null) {
                    continue;
                }

                int start2 = interval[j][0];
                int end2 = interval[j][1];

                if (curStart <= end2 && curEnd >= start2) {
                    // Overlapping intervals, update the current interval
                    curStart = Math.min(curStart, start2);
                    curEnd = Math.max(curEnd, end2);

                    // Mark the interval as merged
                    interval[j] = null;
                }
            }

            // Add the merged interval to the result
            result[count][0] = curStart;
            result[count][1] = curEnd;
            count++;
        }

        // Copy the merged intervals to a new array of the correct size
        int[][] mergedIntervals = new int[count][2];
        System.arraycopy(result, 0, mergedIntervals, 0, count);

        return mergedIntervals;
    }

    public void sort(int[][] interval){
        int length = interval.length;

        for(int i  = 1; i < length; i++){
            int key = interval[i][0];
            int j = i - 1;
            int[] keyInterval = interval[i];

            while(j >= 0 && interval[j][0] > key ){
                interval[j + 1] = interval[j];
                j--;
            }

            interval[j + 1] = keyInterval;
        }
    }


    public static void main(String[] args) {

        int[][] interval = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] ans = new int[interval.length][2];
        MergeIntervals_56 test = new MergeIntervals_56();
        ans = test.merge(interval);
        for (int i = 0; i < interval.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
