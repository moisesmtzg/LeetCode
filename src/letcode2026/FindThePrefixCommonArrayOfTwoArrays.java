package letcode2026;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindThePrefixCommonArrayOfTwoArrays {
    public static int[] findThePrefixCommonArray(int[] A, int[] B){
        int size = A.length;
        int[] result = new int[size];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i< size;i++){
            map.put(A[i],map.getOrDefault(A[i],0)+1);
            map.put(B[i],map.getOrDefault(B[i],0)+1);

            int count = 0;
            for (int n : map.keySet()){
                if (map.get(n) != null && map.get(n) == 2) count ++;
            }
            result[i] = count;
        }
        return result;
        /*
        int[] ans = new int[A.length];
        int[] freq = new int[A.length + 1];
        int common = 0;
        for(int i = 0; i < A.length; i++){
            freq[A[i]]++;
            if(freq[A[i]] == 2){
                common++;
            }
            freq[B[i]]++;
            if(freq[B[i]] == 2){
                common++;
            }
            ans[i] = common;
        }
        return ans;
         */
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(findThePrefixCommonArray(new int[]{1, 3, 2, 4}, new int[]{3, 1, 2, 4})));
    }
}
