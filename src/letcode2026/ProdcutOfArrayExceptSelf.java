package letcode2026;

import java.util.Arrays;

public class ProdcutOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] resArray = new int[size];

        //we are going to make 2 rouds
        // 1 from left and other from right

        //left
        resArray[0] = 1;
        for(int i =1; i<size;i++){
            resArray[i] = resArray[i-1] * nums[i-1];
        }

        //right
        int right = 1;
        for(int i = size-1; i >= 0;i--){
            resArray[i] = resArray[i] *  right;
            right *= nums[i];
        }

        return resArray;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }
}
