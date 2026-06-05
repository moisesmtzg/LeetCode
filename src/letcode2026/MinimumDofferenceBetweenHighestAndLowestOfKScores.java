package letcode2026;

import java.util.Arrays;
public class MinimumDofferenceBetweenHighestAndLowestOfKScores {

    public static int minimumDifference(int[] nums, int k){
        int result = 0;
        int size = nums.length;
        if (k == 1) return result;

        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;

        for(int i =0; i<= size-k; i++){
            int curr = nums[i+k-1]- nums[i];
            diff= Math.min(diff, curr);
        }

        return diff;
    }

    public static void main(String[] args){
        System.out.println(minimumDifference(new int[] {20980,13353,51423,11920,41836,51586,54445}, 5));
    }
}
