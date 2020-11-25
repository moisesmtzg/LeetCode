package leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepetingCharacters {
	
	public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int subString = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)) {
            	subString = Math.max(subString, map.get(c)+1);
            }
            map.put(c, i);
            int currS = ( i - subString) +1;
            max = Math.max(max,currS);
        }
        return max;
    }
}
