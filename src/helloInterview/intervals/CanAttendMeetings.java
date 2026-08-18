package helloInterview.intervals;

import java.util.Arrays;
public class CanAttendMeetings {
    public static boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        int end = intervals[0][1];

        for (int i = 1; i< intervals.length; i++){
            if(end > intervals[i][0]){
                return false;
            }
            end = intervals[i][1];
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(canAttendMeetings(new int[][]{{10,12},{6,9},{13,15}}));
    }
}
