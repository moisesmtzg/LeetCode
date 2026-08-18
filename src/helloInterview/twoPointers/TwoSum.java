package helloInterview.twoPointers;

public class TwoSum {
    public static boolean twoSum(int[] nums, Integer target) {
        // Your code goes here
        int start = 0;
        int end = nums.length-1;

        while(start<end){
            if(nums[start] + nums[end] > target){
                end--;
            }else if (nums[start] + nums[end] < target){
                start++;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(twoSum(new int[]{1,3,4,6,7,10,13}, 13));
    }
}
