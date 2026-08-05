package letcode2026;


public class SecondLargestDigitInAString {
    public static int secondHighest(String s) {
        int max = -1;
        int second = -1;
        for(char sChar : s.toCharArray()){
            if(sChar <= '9' && sChar >= '0' ){
                //is digit
                int sNum =  sChar - '0';
                if ( sNum > max){
                    second = max; // 4
                    max = sNum; // 8
                }else if(sNum > second && sNum < max){
                    second = sNum;
                }
            }
        }
        return second;
    }

    public static void main(String[] args){
        System.out.println(secondHighest("asd1jpb4pb90"));
    }
}
