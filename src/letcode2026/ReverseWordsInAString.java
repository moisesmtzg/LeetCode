package letcode2026;

import java.util.Arrays;

public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        int size = words.length-1;
        String result ="";
        System.out.println(Arrays.toString(words));
        for(int i = size; i>= 0 ; i--){
            if(i == 0){
                result+=words[i].trim();
            }else{
                result+=words[i].trim()+" ";
            }
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(reverseWords("  hello world  "));
    }
}
