package leetcode;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        char[] c = String.valueOf(x).toCharArray();
        if(c[0] == '-'){
            return false;
        }
        for(int i = 0, j = c.length-1; i<j;i++, j--){
            if(c[i] != c[j]){
                return false;
            }
        }
        return true;
    }
}
