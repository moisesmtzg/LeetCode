package letcode2026;

public class JumpGame {

    public static boolean canJump(int[] nums){
        int size = nums.length;
        if ( size == 1 ) return true;
        if (nums[0] == 0) return false;

        int maxReach = nums[0];
        for (int i = 0; i < size-1; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= size-1) return true;
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(canJump(new int[]{2,0,0}));
    }
}
