package helloInterview.intervals;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static Integer nonOverlappingIntervals(int[][] intervals){
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        System.out.println(Arrays.deepToString(intervals));
        int end = intervals[0][1];
        int total = 0;
        for(int i =1; i< intervals.length;i++){
            if(end > intervals[i][0]){
                total++;
            }
            end = Math.min(end, intervals[i][1]);
        }
        return total;
    }
    public static void main (String[] args) {
        System.out.println(nonOverlappingIntervals(new int[][]{{1,3},{3,5},{4,6},{5,7}}));
    }
}

/*
0   1   2   3   4   5   6   7   8   9   10  11  12  13
    ^       ^
                    ^           ^
                ^                       ^
                                            ^       ^

 */
