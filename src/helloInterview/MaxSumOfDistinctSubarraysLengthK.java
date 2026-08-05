package helloInterview;

import java.util.*;

public class MaxSumOfDistinctSubarraysLengthK {
    public static long maxSum(int[] nums, int k){
        long max = Long.MIN_VALUE;
        long sum = 0;
        int start = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int num:nums) {
            //todo
            // si encuentro uno, saco el first y meto el num que tengo
            // restar de la sum el first
            // mter a la sum el que tengo
            if(queue.contains(num)){
                int rest = queue.poll();
                sum-=rest;
                queue.add(num);
                sum+=num;
            }else{
                queue.add(num);
                sum+=num;
            }
            System.out.println(sum);
            while(queue.size() == k){
                max = Math.max(max, sum);
                int rest = queue.poll();
                sum-=rest;
            }
        }

        return (max == Long.MIN_VALUE)?0:max;
    }

    /*
     * list 3 2 2 3
     *
     */

    public static void main(String[] args){
        System.out.println(maxSum(new int[]{1,1,1,1,1},1));
    }
}
