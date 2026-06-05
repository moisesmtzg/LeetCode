package letcode2026;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if (sl > tl) return false;

        int p1 = 0;
        int p2 = 0;

        while(p1 < sl && p2 < tl){
            if(s.charAt(p1) == t.charAt(p2)){
                p1++;
            }
            p2++;
        }
        return p1 == sl;
    }
    public static void main(String[] args){
        System.out.println(isSubsequence("b", "c"));
    }
}
