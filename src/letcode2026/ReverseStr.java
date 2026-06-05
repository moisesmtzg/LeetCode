package letcode2026;

public class ReverseStr {
    public static String reverseStr(String s, int k) {
        StringBuilder text = new StringBuilder();
        boolean flag = true;
        int point1 = 0;
        int point2 = point1+1;

        while (point2<s.length()){
            if(point1 % k == 0 && flag){
                text.append(s.charAt(point2));
                text.append(s.charAt(point1));
                point1+=2;
                point2+=2;
                flag = false;
            }else{
                text.append(s.charAt(point1));
                text.append(s.charAt(point2));
                point1+=2;
                point2+=2;
                flag = true;
            }
        }
        if (point1 % s.length() !=0){
            text.append(s.charAt(point1));

        }

        return text.toString();
    }

    public static void main(String[] args){
        System.out.println(reverseStr("abcdef", 3));
    }
}
