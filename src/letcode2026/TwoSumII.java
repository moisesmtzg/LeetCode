package letcode2026;

import java.util.Arrays;

public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int p1 = 0;
        int p2 = numbers.length-1;
        int res = 0;

        while (p1 < p2 && numbers[p1] + numbers[p2] != target){
            if (numbers[p1] + numbers[p2] > target){
                p2--;
            } else{
                p1++;
            }
        }

        return new int[]{p1+1,p2+1};
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
