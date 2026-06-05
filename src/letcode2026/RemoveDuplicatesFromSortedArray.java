package letcode2026;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums){
        int size = nums.length;
        if ( size == 1) return 1;
        if ( size == 2 && nums[0] != nums[1]) {
            return size;
        }
        int left = 0;
        int right = 1;
        while(right < size){
            if (nums[left] != nums[right]){
                int aux = nums[left+1];
                nums[left+1] = nums[right];
                nums[right] = aux;
                left++;
            }
            right++;
        }
        System.out.println(Arrays.toString(nums));
        return left+1;
    }
    public static void main(String[] args){
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));

    }
}
