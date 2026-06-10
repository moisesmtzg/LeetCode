package letcode2026;

public class isPalindrome {
    public static boolean isPalindrome(String s){
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]","");
        int p1 = 0;
        int p2 = s.length()-1;
        if(p2 == 0) return true;
        while(p1 < p2){
            if(s.charAt(p1) == s.charAt(p2)){
                p1++;
                p2--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isPalindrome("A man, a plan a canal Panama"));
    }
}
