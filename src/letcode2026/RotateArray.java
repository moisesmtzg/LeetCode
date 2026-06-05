package letcode2026;

import java.util.Arrays;

public class RotateArray {

    public static void rotate(int[] nums, int k){
        int numsSize = nums.length;
        int mod = k%numsSize;

        int l =0, r =numsSize-1;
        while(l< r){
            int aux = nums[l];
            nums[l] = nums[r];
            nums[r] = aux;
            l++;
            r--;
        }
        l = 0;
        r = mod -1;
        while(l< r){
            int aux = nums[l];
            nums[l] = nums[r];
            nums[r] = aux;
            l++;
            r--;
        }
        l = mod;
        r = numsSize-1;
        while(l< r){
            int aux = nums[l];
            nums[l] = nums[r];
            nums[r] = aux;
            l++;
            r--;
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        int k = 2;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
