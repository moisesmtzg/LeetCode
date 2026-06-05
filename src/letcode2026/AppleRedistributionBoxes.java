package letcode2026;

import java.util.Arrays;

public class AppleRedistributionBoxes {
    public static int minimumBoxes(int[] apple, int[] capacity){
        int total = 0;
        int size = capacity.length -1;
        int aux = 0;
        Arrays.sort(capacity);

        for (int a : apple){
            total+=a;
        }

        while(total > 0){
            total -= capacity[size];
            size--;
            aux++;
        }
        return aux;
    }

    public static void main(String[] args){
        System.out.println(minimumBoxes(new int[]{1,3,2}, new int[]{4,3,5,1,2}));
    }
}
