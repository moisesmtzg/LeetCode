package letcode2026;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s){
        if (s.length() == 1) return s;
        int max = 0;
        int i = 0;
        int p2 = s.length()-1;
        int start = 0;
        int end = 1;

        while(i< s.length()) {
            while(p2 >= i){
                if(s.charAt(i) == s.charAt(p2)){
                    if (isPalindrome(s.substring(i, p2+1))){
                        if(max < p2-i+1){
                            max = p2-i+1;
                            start = i;
                            end = p2+1;
                        }
                    }
                }
                p2--;
            }
            p2 = s.length()-1;
            i++;
        }
        return s.substring(start, end);
    }

    public static boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(end > start){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("aacabdkacaa"));
    }
}

/**
 *  b   a   b   a   d
 *      ^
 *      ^
 *
 *  b,a,b
 *
 */
