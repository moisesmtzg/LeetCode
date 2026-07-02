package letcode2026;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> dictionary = new HashMap<>();
        for(int i=0;i<s.length(); i++){
            if(dictionary.containsKey(s.charAt(i))){
                char value = dictionary.get(s.charAt(i));
                if(t.charAt(i) != value) return false;
            }else if(dictionary.containsValue(t.charAt(i))){
                return false;
            }
            dictionary.put(s.charAt(i),t.charAt(i));
        }

        return true;
    }
    public static void main(String[] args){
        System.out.println(isIsomorphic("paper", "title"));
    }
}
