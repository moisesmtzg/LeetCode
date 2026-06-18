package algoExpert;

import java.util.Arrays;

public class FindThreeLargestNumbers {
    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        int size = array.length;
        int left = 0;
        int i = size-1;
        while (i >= 0){
            if(array[left] > array[i]){
                i--;
            }else{
                int aux = array[i];
                array[i] = array[left];
                array[left] = aux;
                i--;
            }
            //reach index and increase left and resutn i to size-1
            if(i == left){
                left++;
                i=size-1;
            }
            if(left == size-1){
                break;
            }
        }
        //we have the 3 first elemets order in desc order
        int[] result = new int[3];
        for(int k =2; k>=0;k--){
            result[k] = array[2-k];
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(findThreeLargestNumbers(new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7})));
    }
}
