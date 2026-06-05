package letcode2026;

public class MinimunSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums){
        if(nums.length == 0) return 0;

        int sum;
        int min = Integer.MAX_VALUE;

        sum =0;
        int p1=0;
        for(int i =0; i< nums.length;i++){
            sum+=nums[i];
            while(sum>=target){
                min = Math.min(min, i-p1+1);
                sum-=nums[p1];
                p1++;
            }
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }

    public static void main(String[] args){
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
