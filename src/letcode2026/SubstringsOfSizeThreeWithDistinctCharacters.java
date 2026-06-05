package letcode2026;

import java.util.HashMap;
import java.util.Map;

public class SubstringsOfSizeThreeWithDistinctCharacters {
    public static int countGoodSubstrings(String s){
        int size = s.length();
        if(size < 3) return 0;

        Map<Character, Integer> map = new HashMap<>();

        int result = 0;

        for(int i= 0; i<size;i++){
            // 1. Agregar el carácter actual
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // 2. Si la ventana se pasó del tamaño (3), quitar el de atrás
            if (i >= 3) {
                char prev = s.charAt(i - 3);
                map.put(prev, map.get(prev) - 1);
                if (map.get(prev) == 0) {
                    map.remove(prev);
                }
            }

            // 3. Si tenemos 3 elementos únicos en el mapa, es un "Good Substring"
            // Nota: Solo checamos cuando el índice i es al menos 2 (ventana llena)
            if (i >= 2 && map.size() == 3) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(countGoodSubstrings("aababcabc"));
    }
}
