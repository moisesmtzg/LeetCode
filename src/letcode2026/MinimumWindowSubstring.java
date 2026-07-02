package letcode2026;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t){
            Map<Character, Long> map_t = t.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            int n = map_t.size();
            int s_size = s.length();
            int count = Integer.MAX_VALUE;
            int right = 0;
            int diff = 0;
            char r_val = ' ';
            String ans = "";


            for (int left = 0; left < s_size; left++) {
                while (right < s_size && n > 0) {
                    r_val = s.charAt(right);
                    if (map_t.containsKey(r_val)) {
                        map_t.computeIfPresent(r_val, (k, v) -> v - 1);
                        if (map_t.get(r_val) == 0) {
                            n--;
                        }
                    }
                    right++;
                }

                if (n == 0) {
                    diff = right - left;

                    if (diff < count) {
                        count = diff;
                        ans = s.substring(left,right);
                    }
                }
                if (map_t.containsKey(s.charAt(left))) {
                    if (map_t.get(s.charAt(left)) == 0) {
                        n++;
                    }
                    map_t.computeIfPresent(s.charAt(left), (k, v) -> v + 1);
                }
            }

            return ans;
        }

    public static void main(String[] args){
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
}
