package letcode2026;

import java.util.HashMap;

public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        HashMap<String, String> relation = new HashMap<>();
        if (pattern.length() != words.length) return false;
        for(int i = 0; i<pattern.length(); i++){
            if(!relation.containsKey(String.valueOf(pattern.charAt(i))) && !relation.containsValue(words[i])){
                relation.put(String.valueOf(pattern.charAt(i)),words[i]);
            }else {
                String wordSaved = relation.get(String.valueOf(pattern.charAt(i)));
                if (wordSaved == null || !wordSaved.equals(words[i])){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main (String[] args){
        //System.out.println(wordPattern("abba","cat cat dog dog"));
        //System.out.println(wordPattern("abba","cat dog dog cat"));
        //System.out.println(wordPattern("abba","dog cat cat fish"));
        System.out.println(wordPattern("jquery","jquery"));
    }
}
