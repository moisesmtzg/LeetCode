package letcode2026;


import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine){
        Map<Character, Integer> mapCharValue = new HashMap<>();
        for(char c:magazine.toCharArray()){
            mapCharValue.put(c, mapCharValue.getOrDefault(c,0)+1);
        }
        System.out.println(mapCharValue);
        for(char r : ransomNote.toCharArray()){
            if(mapCharValue.containsKey(r)){
                if(mapCharValue.get(r) > 0) {
                    mapCharValue.put(r, mapCharValue.getOrDefault(r, 0) - 1);
                }
                if(mapCharValue.get(r) == 0){
                    mapCharValue.remove(r);
                }
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(canConstruct("aa","ab"));
    }
}
