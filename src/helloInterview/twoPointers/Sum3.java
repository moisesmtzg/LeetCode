package helloInterview.twoPointers;

import java.util.*;

public class Sum3 {
    public static List<List<Integer>> threeSum(int[] nums){
        if ( nums.length < 3) return new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int i =0;
        while(i < nums.length -2){
            int j = nums.length-1;
            int k = i+1;
            while( k < j){
                if (nums[i] + nums[j] + nums[k] == 0 ){
                    List<Integer> listNum = new ArrayList<>();
                    listNum.add(nums[i]);
                    listNum.add(nums[j]);
                    listNum.add(nums[k]);
                    set.add(listNum);
                    j--;
                    k++;
                }else if (nums[i] + nums[j] + nums[k] > 0){
                    j--;
                } else {
                    k++;
                }
            }
            i++;
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args){
        System.out.println(threeSum(new int[]{1,1,-2}));
    }
}
/**
 *  -4  -1  -1  0   1   2
 */
