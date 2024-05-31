package Interval;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class InsertIntervals_57 {
    public int[][] insert1(int[][] intervals, int[] newInterval) {
        int length = intervals.length;
        List<int[]> result = new ArrayList<>();

        for(int i = 0; i < length; i++){
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            // [] _: before the current interval
            if(newInterval[1] < curStart){
                result.add(newInterval);
                // add the rest of original intervals
                for(int j = i; j < length; j++){
                    result.add(intervals[j]);
                }
                return result.toArray(new int[result.size()][]);
            }
            // _ []: after the current interval,add the original interval here,
            if (newInterval[0] > curEnd){
                result.add(intervals[i]);
            }else{
                // [_] overlap with current interavl,merge them:
                newInterval[0] = Math.min(curStart,newInterval[0]);
                newInterval[1] = Math.max(curEnd,newInterval[1]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][2]);
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                res.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    res.add(intervals[j]);
                }
                return res.toArray(new int[res.size()][]);
            } else if (newInterval[0] > intervals[i][1]) {
                res.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        InsertIntervals_57 test = new InsertIntervals_57();
        int[][] intervals = {{1,3},{6,9}};
        int[] newIntervals = {2,5};

        int[][] result = test.insert1(intervals, newIntervals);
        for(int[] interval: result){
            System.out.println(Arrays.toString(interval));
        }
    }
}
