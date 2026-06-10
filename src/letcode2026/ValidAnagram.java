package letcode2026;

import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t){
        // revisamos si el tamano es diferente entonces false
        if(s.length() != t.length()) return false;
        // si tienen mismo tamano pueden ser anagrama
        HashMap<Character, Integer> mpS = new HashMap<>();
        // tomamos la 1a palabra y guardamos en map el cracter y el numero de veces
        for(char c: s.toCharArray()){
            mpS.put(c, mpS.getOrDefault(c,0)+1);
        }
        //hacemos lo mismo con el word t
        HashMap<Character, Integer> mpT = new HashMap<>();
        for(char c: t.toCharArray()){
            mpT.put(c, mpT.getOrDefault(c,0)+1);
        }
        return mpT.equals(mpS);
    }
    public static void main(String[] args){
        System.out.println(isAnagram("cat", "tac"));
    }
}
