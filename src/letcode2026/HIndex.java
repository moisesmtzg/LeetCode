package letcode2026;

import java.util.Arrays;

public class HIndex {
    public static int hIndex(int[] citations){
        int size = citations.length;
        Arrays.sort(citations);
        int citas = 0;
        for(int citation = size-1; citation >= 0; citation--){
            if (citations[citation] > citas){
                citas++;
            }else{
                break;
            }
        }
        return citas;
    }

    public static void main(String[] args){
        System.out.println(hIndex(new int[]{1}));
    }
}

/*
[0, 1, 3, 5, 6]
    |
 */