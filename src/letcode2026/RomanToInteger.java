package letcode2026;

import java.util.Hashtable;

public class RomanToInteger {
    public static int romanToInt(String s) {
        Hashtable<Character, Integer> ht = new Hashtable<>();
        ht.put('I', 1);
        ht.put('V', 5);
        ht.put('X', 10);
        ht.put('L', 50);
        ht.put('C', 100);
        ht.put('D', 500);
        ht.put('M', 1000);

        int total = 0;
        for (int i = 0; i <= s.length()-1; i++){
            if (i< s.length()-1 && ht.get(s.charAt(i)) < ht.get(s.charAt(i+1))){
                total -= ht.get(s.charAt(i));
            }else{
                total += ht.get(s.charAt(i));
            }
        }
        return total;
    }

    public static void main (String[] args){
        System.out.println(romanToInt("MCMXCIV"));
    }
}
