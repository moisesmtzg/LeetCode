package letcode2026;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s.isEmpty() || words.length ==0) return result;

        Map<String, Integer> originalValues = new HashMap<>();
        int sTotal = s.length();
        int sWord = words[0].length();
        int window = sWord * words.length;
        for(String word : words){
            originalValues.put(word, originalValues.getOrDefault(word,0)+1);
        }

        for(int i = 0; i< sWord; i++){
            Map<String,Integer> currentM = new HashMap<>();
            int p1 = i;
            int p2 = i;
            while(p2 +sWord <= sTotal){
                String aux = s.substring(p2, p2+sWord);
                p2+=sWord;
                //ponemos en un mapa currentM
                currentM.put(aux, currentM.getOrDefault(aux,0)+1);
                if(p2 - p1 > window){
                    //reducimos la ventana
                    String borrar = s.substring(p1,p1+sWord);
                    currentM.put(borrar,currentM.get(borrar)-1);
                    if(currentM.get(borrar) == 0) currentM.remove(borrar);
                    p1+=sWord;
                }
                if(p2 - p1 == window){
                    // tenemos 2 cadenas y vemos si es valida
                    if(currentM.equals(originalValues)){
                        result.add(p1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"bar","foo"}));
    }
}


/*
*** Primera solucion
public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s.isEmpty() || words.length ==0) return result;

        Map<String, Integer> mp = new HashMap<>();
        int sTotal = s.length();
        int sWord = words[0].length();
        int nTime = sWord * words.length;
        for(String word : words){
            mp.put(word,mp.getOrDefault(word,0)+1);
        }
        Map<String, Integer> originalValues = Map.copyOf(mp);

        for (int i =0 ; i<= sTotal-nTime; i++){
            mp = new HashMap<>(originalValues);
            //primer segmento
            int wl = i;
            int wr = sWord+i;
            while(wr <=nTime+i){
                String aux = s.substring(wl,wr);
                if(mp.containsKey((aux))){
                    mp.replace(aux,mp.get(aux)-1);
                }
                wl =wr;
                wr +=sWord;
            }
            if(isValidSequence(mp)){
                result.add(i);
            }
        }
        return result;
    }

    public static boolean isValidSequence(Map<String, Integer> mp){
        for(String word: mp.keySet()){
            if(mp.get(word) != 0) return false;
        }
        return true;
    }
 */

