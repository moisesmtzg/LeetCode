package helloInterview;

public class MaxSum {
    public static int maxSum(int[] nums, int k) {
        // Your code goes here
        int max = Integer.MIN_VALUE;
        int start = 0;
        int sum = 0;
        for ( int i = 0; i< nums.length;i++){
            sum += nums[i];
            while(i - start == k-1){
                max = Math.max(max, sum);
                sum-=nums[start];
                start++;
            }
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(maxSum(new int[]{4,2,4,5,6}, 4));
    }
}
