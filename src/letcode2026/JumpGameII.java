package letcode2026;

public class JumpGameII {

    public static int canJump(int[] nums){
        int result = 0;
        int size = nums.length;

        if ( size == 1 || nums[0] == 0) return result;
        int l= 0, r= 0;

        while(r< size -1){
            int farthest = 0;
            for (int i = l; i < r+1; i++) {
                farthest = Math.max(farthest, i+nums[i]);
            }
            l = r+1;
            r= farthest;
            result +=1;
        }

        return result;
    }
    public static void main(String[] args){
        System.out.println(canJump(new int[]{2,3,1,4}));
    }
}
