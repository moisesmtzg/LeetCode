package helloInterview.fixedSlidingWindow;

import java.util.*;

/**
 * Given an integer array nums and an integer k,
 * write a function to identify the highest possible sum of
 * a subarray within nums, where the subarray meets the
 * following criteria:
 * its length is k, and all of its elements are unique.
 * If no such subarray exists, return 0.
 */
public class MaxSumOfDistinctSubarraysLengthK {
    public static long maxSum(int[] nums, int k){
        int left = 0;
        Set<Integer> set = new HashSet<>();
        long maxSum = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                set.remove(nums[left]);
                left++;
                set.add(nums[i]);
            }
            while(set.size() == k){
                long sum = 0;
                for(int num: set){
                    sum+=num;
                }
                maxSum = Math.max(maxSum, sum);
                set.remove(nums[left]);
                left++;
            }
        }
        return (maxSum == Long.MIN_VALUE)?0:maxSum;
    }

    /*
     * list 3 2 2 3
     *
     */

    public static void main(String[] args){
        System.out.println(maxSum(new int[]{4,2,4,5,6},4));
    }
}
