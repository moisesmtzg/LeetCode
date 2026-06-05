package letcode2026;

public class FirstOccurrenceInAString {
    public static int strStr(String haystack, String needle) {
        int hSize = haystack.length();
        int nSize = needle.length();

        if(nSize > hSize) return -1;

        for (int i = 0; i <= hSize-nSize; i++) {
            int j = 0;
            while (j<nSize && haystack.charAt(i+j) == needle.charAt(j)){
                j++;
            }
            if (j == nSize)return i;
        }

        return -1;
    }
    public static void main(String[] args){
        System.out.println(strStr("leetcode","leeto"));
    }
}
