package letcode2026;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int size = digits.length - 1;
        boolean carry = true;
        int index = size;
        while(index >=0 && carry){
            int digit = digits[index];
            if(carry && digit != 9){
                digits[index] +=1;
                carry = false;
            }
            if(digit == 9){
                digits[index] = 0;
            }
            index--;
        }
        if(carry){
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = 1;
            return newDigits;
        }
        return digits;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(plusOne(new int[]{1,9})));
    }
}
