package letcode2026;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElement(int[] nums){
        // time  y spaceO(n)
        Map<Integer, Integer> mp = new HashMap<>();
        for(int num: nums){
            mp.put(num, mp.getOrDefault(num,0)+1);
        }
        int total = 0;
        int result = 0;
        for (int key : mp.keySet()){
            if (mp.get(key) > total) {
                total = mp.get(key);
                result = key;
            }
        }
        return result;
    }
    public static int majorityElement2(int[] nums){
        // time o(n) y spaceO(1)
        int result= 0;
        int count =0;

        for (int num : nums) {
            if (count == 0) {
                result = num;
            }
            if (num == result) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
    public static void main (String[] args){
        System.out.println(majorityElement2(new int[] {2,2,1,1,1,2,2}));
    }
}
