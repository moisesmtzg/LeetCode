package letcode2026;

import java.util.Arrays;

public class DefuseTheBomb {
    public static int[] decrypt(int[] code, int k){
        int n = code.length;
        int[] result = new int[n];

        if(n == 0) return result;

        int start = (k > 0)? 1: n+k;
        int end = (k > 0)? k: n-1;

        int currSum = 0;
        for(int i = start; i<= end; i++){
            currSum += code[i%n];
        }

        for(int i=0; i<n; i++){
            result[i] = currSum;
            currSum = currSum + code[(end+1+i)%n] -code[(start+i) %n];
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(decrypt(new int[]{2, 4, 9, 3}, -2)));
    }
}
