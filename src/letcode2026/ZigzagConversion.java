package letcode2026;


public class ZigzagConversion {
    public static String convert(String s, int numRows){
        if ( numRows  == 1 ) return s;
        StringBuilder[] sb = new StringBuilder[numRows];

        for(int i = 0; i< numRows; i++){
            sb[i] = new StringBuilder();
        }

        int index = 0;
        char[] arr = s.toCharArray();
        int sizeArr = arr.length;
        while (index < sizeArr){
            for(int i = 0; i< numRows && index < sizeArr; i++){
                sb[i].append(arr[index++]);
            }
            for(int i = numRows -2; i>0 && index < sizeArr; i--){
                sb[i].append(arr[index++]);
            }
        }

        StringBuilder res = sb[0];
        for (int i = 1; i < numRows; i++) {
            res.append(sb[i].toString());
        }
        return res.toString();
    }


    public static void main(String[] args){
        System.out.println(convert("PAYPALISHIRING",3));
    }
}
