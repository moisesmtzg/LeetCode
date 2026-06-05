package letcode2026;

public class AdditiveNumber {

    public static boolean isAdditiveNumber(String num) {
        int val1 = 0;
        int val2 = 1;
        for(int i= 2; i<num.length(); i++){
            //1 digit numbers
            if(num.charAt(val1)-'0' + num.charAt(val2)-'0' == num.charAt(i)-'0'){
                val1++;
                val2++;
            }else {
                if ( 1== 1){
                    System.out.println("a");
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isAdditiveNumber("12345"));
        System.out.println(isAdditiveNumber("112358"));
    }
}
