package letcode2026;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        int words = strs.length;
        String w1 = strs[0];
        StringBuilder sb = new StringBuilder();

        for(int i =1; i<words; i++){
            String w2 = strs[i];
            int aux = 0;
            while(aux < w2.length() && aux<w1.length()){
                if(w1.charAt(aux) == w2.charAt(aux)){
                    sb.append(w1.charAt(aux));
                }else{
                    break;
                }
                aux++;
            }
            w1 = sb.toString();
            sb = new StringBuilder();
        }
        return w1;

        // usar indexOf
    }
    public static void main(String[] args){
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
