package letcode2026;

import java.util.HashMap;
import java.util.Map;

public class MinimumMovesToMakeArrayComplementary {

    public static int minMoves(int[] nums, int limit){
        int length = nums.length;
        int movements  = 0;
        int aux = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i =0; i<length/2; i++){
            int val = nums[i]+nums[length-1-i];
            hm.put(val, hm.getOrDefault(val,0)+1);

        }

        System.out.println(hm);
        return movements;
    }

    public static void main(String[] args){
        System.out.println(minMoves(new int[]{1,3,5,4,2,6},4));
    }
}
