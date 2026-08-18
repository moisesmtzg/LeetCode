package letcode2026;

import java.util.Arrays;

public class MinimumRemovalsToBalanceArray {
    public static int minRemoval(int[] nums, int k){
        if (nums.length == 1) return 0;
        Arrays.sort(nums);
        int res = 0;
        int start = 0;
        for (int end = 1; end < nums.length; end++) {
            while((long)nums[end] > (long)nums[start]*k){
                start++;
            }
            res = Math.max(res, end-start+1);
        }
        return nums.length - res;
    }

    public static void main(String[] args){
        System.out.println(minRemoval(new int[]{1,6,2,9}, 3));
    }
}
