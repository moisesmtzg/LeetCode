package letcode2026;

public class FindTheOcurrenceOfFirstAlmostEqualString {
    public static int minStartingIndex(String s, String pattern) {
        /**
         0   1   2   3   4   5   6   7   8   9
         a   b   a   b   b   a   b   a   b   a
         i                                           ^
         ^


         0   1   2   3   4   5
         b   a   b   a   b   a
         ^

         0   1   2   3   4   5
         b   a   c   a   b   a
         j                   ^

         startWin = 4
         cambios = 1
         minCambios = 5 = > 4 => 3 => 1


         sliding window 771/778 testcases

         for i en s iteramos
         cuando i >= pattern length -1
         obtenemos donde inicia la cadena i - pattern.length +1
         verificamos los caracteres de la cadena vs los del pattern
         si son diff sumamos 1 a los cambios



         for (int i = 0; i < s.length(); i++) {
            if (i >= pattern.length() - 1) {
                int start = i - pattern.length() + 1; // El inicio de la ventana
                int j = 0;
                int cambios = 0;
                while (j < pattern.length() && cambios < 2) {
                    if (s.charAt(start + j) != pattern.charAt(j)) {
                        cambios++;
                    }
                    j++;
                }
                if (cambios <= 1) {
                    return i - pattern.length() + 1;
                }
            }
         }
         */
        return -1;
    }

    public static void main(String[] args){
        System.out.println(minStartingIndex("ababbababa", "bacaba"));
    }
}
