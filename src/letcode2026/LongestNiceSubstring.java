package letcode2026;

public class LongestNiceSubstring {
    public static String longestNiceSubstring(String s){
        if(s.length() < 2) return "";
        for(char c: s.toCharArray()) {
            // checar si esta en el set y tmb su contraparte y en s, sino obtendremos el unico
            int contraParte = (c > 96) ? c - 32 : c + 32;
            if (s.indexOf(contraParte) == -1) {
                String izq = longestNiceSubstring(s.substring(0,s.indexOf(c)));
                String der = longestNiceSubstring(s.substring(s.indexOf(c)+1));
                return (izq.length() >= der.length()) ? izq : der;
            }
        }
        return s;
    }

    public static void main(String[] args){
        System.out.println(longestNiceSubstring("HkhBubUYy"));
    }
}
