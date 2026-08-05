package letcode2026;

import java.util.Arrays;

public class AppendKIntegersWithMinimalSum {
    public static long minimalKSum(int[] nums, int k){
        Arrays.sort(nums);
        int start = 0;
        int total = 0;
        int aux = 0;
        for(int i = 1; i< nums.length;i++){
            // revisamos cual es el limite mas pequeno, si de 0 a nums[start]
            // o de nums[i] - nums[start]
            int diffStart  = nums[start] - (start + 1);
            int diffNumbers =  nums[i] - nums[start];
            //llenar numeros
            if (diffNumbers > 1){
                int base = nums[start];
                while ( aux < k && base < nums[i]){
                    base = base + 1;
                    total += base;
                    aux++;
                }
            }

            if(diffStart > 1){
                //todo
            }
        }
        return total;
    }
    public static void main(String[] args){
        System.out.println(minimalKSum(new int[]{1,4,25,10,25}, 2));
    }
}
