package letcode2026;

import java.util.HashMap;
import java.util.Map;

public class RearangeCharactersToMakeTargetString {
    public static int rearrangeCharacters(String s, String target) {
        if(target.length() > s.length()) return 0;

        Map<Character, Integer> mapTarget = new HashMap<>();
        Map<Character, Integer> mapS = new HashMap<>();
        int min = Integer.MAX_VALUE;


        for(char c: target.toCharArray()){
            mapTarget.put(c, mapTarget.getOrDefault(c,0)+1);
        }

        for(char c: s.toCharArray()){
            if(mapTarget.containsKey(c)){
                mapS.put(c, mapS.getOrDefault(c,0)+1);
            }
        }

        if(mapTarget.size() != mapS.size()) return 0;

        for(char key : mapS.keySet()){
            min = Math.min(min,mapS.get(key)/mapTarget.get(key));
        }

        return min;
    }

    public static void main(String[] args){
        System.out.println(rearrangeCharacters("abbaccaddaeea","aaaaa"));
    }
}
