package helloInterview.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] mergeIntervals(int[][] intervals){
        if ( intervals.length == 0 ) return new int[][]{};
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> list= new ArrayList<>();

        for(int i =1 ; i < intervals.length; i++){
            if(end >= intervals[i][0]){
                end = Math.max(end, intervals[i][1]);
            }else{
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[]{start,end});
        return list.toArray(new int[list.size()][]);
    }
    public static void main (String[] args){
        System.out.println(Arrays.deepToString(mergeIntervals(new int[][]{{3, 5}, {1, 4}, {7, 9}, {6, 8}})));
    }
}
