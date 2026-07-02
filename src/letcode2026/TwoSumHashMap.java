package letcode2026;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumHashMap {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int count= 0;
        for(int num:nums){
            int valueToSearch = target-num;
            if(map.containsKey(valueToSearch)){
                int c = map.get(valueToSearch);
                return new int[]{count, c};
            }else{
                map.put(num, count);
            }
            count++;
        }
        return new int[]{0,0};
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 9)));
    }
}
