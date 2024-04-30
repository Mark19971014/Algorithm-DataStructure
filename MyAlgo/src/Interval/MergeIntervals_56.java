package Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> Interval = new ArrayList<>();
        int[] curInterval = intervals[0];
        Interval.add(curInterval);
        for (int i = 1; i < intervals.length; i++) {
            //[1,3] [2,6] -> [1,6]
            if (intervals[i][0] <= curInterval[1]) {
                // merge the ith and i+1th list
                curInterval[1] = Math.max(curInterval[1], intervals[i][1]);
            }
            else{
                curInterval = intervals[i];
                Interval.add(curInterval);
            }
        }
        return Interval.toArray(new int[Interval.size()][]);
    }
    public static void main(String[] args) {
        int[][] interval = {{1,3},{2,6},{8,10},{15,18}};
        int[][] ans = new int[interval.length][2];
        MergeIntervals_56 test = new MergeIntervals_56();
        System.out.println(Arrays.deepToString(test.merge(interval)));
    }
}
