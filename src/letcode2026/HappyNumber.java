package letcode2026;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        return isHappy(n, set);
    }

    private static boolean isHappy(int n, Set<Integer> set){
        int[] cuad = {0,1,4,9,16,25,36,49,64,81};
        int sum = 0;
        while(n>0){
            int lastNum = n%10;
            sum += cuad[lastNum];
            n = n/10;
        }
        if(set.contains(sum)) return false;
        if (sum == 1 ) return true;
        set.add(sum);
        return isHappy(sum,set);
    }

    public static void main(String[] args){
        System.out.println(isHappy(19));
    }
}
