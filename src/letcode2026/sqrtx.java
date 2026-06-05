package letcode2026;

public class sqrtx {
    public static int mysqrt(int x){
        if (x == 1) return 1;
        /*
        int start = 1;
        int end = x;

        while(start <= end){
            int m = start + (end-start)/ 2;
            if(m*m == x) return m;
            if (m*m > x){
                end = m-1;
            }else {
                start = m+1;
            }
        }
        return end;

         */
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;

    }

    public static void main(String[] args){
        System.out.println(mysqrt(2147395599));
    }
}
