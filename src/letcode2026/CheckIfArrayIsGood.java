package letcode2026;

import java.util.Arrays;

public class CheckIfArrayIsGood {

    public static boolean isGood(int[] nums) {

        Arrays.sort(nums);
        boolean flag = false;
        int length = nums.length;
        int n = nums[length-1];
        int aux = n;

        if(length == n+1) {
            int i = n-1;
            while(i>=0){
                if(nums[i] != aux) {
                    return false;
                }
                aux--;
                i--;
            }
            flag = true;
        }
        return flag;
    }

    public static void main(String[] args){
        System.out.println(isGood(new int[]{1,3,4,5,5,2}));
    }
}
