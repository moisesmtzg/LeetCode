package letcode2026;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int i =0;
        for(int num: nums){
            i ^= num;
        }
        return i;
    }

    public static void main(String[] args){
        System.out.println(singleNumber(new int[]{1,1,2,3,4,5,5,4,2}));
    }
}
