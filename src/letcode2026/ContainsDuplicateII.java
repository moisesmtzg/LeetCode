package letcode2026;

import java.util.HashSet;

public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicate(int[] nums, int k){
        int size = nums.length;
        HashSet<Integer> window = new HashSet<>();

        for (int i = 0; i< size; i++){
            if (window.contains(nums[i])){
                return true;
            }
            window.add(nums[i]);

            if (window.size() > k){
                window.remove(nums[i-k]);
            }
        }

        return false;
    }

    public static void main(String[] args){
        System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1},1));
    }
}
