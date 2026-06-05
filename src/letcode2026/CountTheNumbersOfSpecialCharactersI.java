package letcode2026;

import java.util.HashSet;
import java.util.Set;

public class CountTheNumbersOfSpecialCharactersI {
    public static int numberOfSpecialChars(String word){
        if (word.isEmpty()) return 0;

        // set con letras minusculas
        // 1. iterando sobre word
        // 2 si el caracter es letra minuscula ( char >= 97)
        // 2.1.1 sino esta en el set, le restamos 32 al caracter
        //       y revisamos si el char resultante esta en word
        //       si esta, agremos la letra al set
        // 3 regresamos el tama~no del set

        Set<Character> set = new HashSet<>();
        // paso 1
        for(char letter: word.toCharArray()){
            int letterValue = (int) letter;
            // paso 2
            if(letterValue >= 97 && !set.contains(letter) && word.contains(String.valueOf((char)(letterValue-32)))){
                set.add(letter);
            }
        }

        return set.size();
    }
    public static void main(String[] args){
        System.out.println(numberOfSpecialChars("aaAbcBC"));
    }
}
