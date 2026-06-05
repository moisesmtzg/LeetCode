package letcode2026;

public class lengthOfLastWord {
    public static int lengthOfLastWord(String s){
        String[] words = s.split(" ");
        return words[words.length-1].length();
    }

    public static void main(String[] args){
        System.out.println(lengthOfLastWord("Hello World"));
    }
}
