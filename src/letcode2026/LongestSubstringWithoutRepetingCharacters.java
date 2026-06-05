package letcode2026;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepetingCharacters {

    public static int lengthoFLongesSubstring(String s){
        if(s.isEmpty()) return 0;
        int longest = 0;
        int p1 = 0;
        Set<Character> set = new HashSet<>();
        for(int i =0; i<s.length();i++){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
            }else{
                while(set.contains(s.charAt(i))){
                    set.remove(s.charAt(p1));
                    p1++;
                }
                set.add(s.charAt(i));
            }
            longest = Math.max(longest,i-p1 + 1);
        }
        return longest;
    }

    public static void main(String[] args){
        System.out.println(lengthoFLongesSubstring("abcabcbb"));
    }
}
