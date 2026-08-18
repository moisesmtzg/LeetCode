package helloInterview.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
c >= a && c<= b
a >= c && a <= d
d >= a && d <= b
b >= c && b <=d
 */

public class InsertedIntervals {

    public static int[][] insertIntervals(int[][] intervals, int[] newInterval) {
        // Interval insertion with merging: three-phase approach
        List<int[]> merged = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Phase 1: Add all intervals that end before newInterval starts (no overlap)
        while (i < n && intervals[i][1] < newInterval[0]) {
            merged.add(intervals[i]);
            i++;
        }

        // Phase 2: Merge all overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            // Expand newInterval to encompass current overlapping interval
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        // Add the merged newInterval
        merged.add(newInterval);

        // Phase 3: Add all remaining intervals (after newInterval)
        for (int j = i; j < n; j++) {
            merged.add(intervals[j]);
        }

        return merged.toArray(new int[merged.size()][]);
    /*
    public static int[][] insertIntervals(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if(         intervals[i][0] >= newInterval[0]  && intervals[i][0] <= newInterval[1]
                    ||  intervals[i][1] >= newInterval[0] && intervals[i][1] <= newInterval[1]
                    ||  newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1]
                    ||  newInterval[1] >= intervals[i][0] && newInterval[1] <= intervals[i][1]
            ) {
                newInterval = new int[]{Math.min(intervals[i][0], newInterval[0]), Math.max(intervals[i][1], newInterval[1])};
            }else if (intervals[i][1] < newInterval[0]){
                list.add(intervals[i]);
            }else{
                list.add(newInterval);
                newInterval = intervals[i];
            }
        }
        list.add(newInterval);
        return list.toArray(new int[list.size()][]);

     */
    }
    public static void main (String[] args){
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10}};
        int[] newInterval = {5,6};

        System.out.println(Arrays.deepToString(insertIntervals(intervals, newInterval)));
    }
}
