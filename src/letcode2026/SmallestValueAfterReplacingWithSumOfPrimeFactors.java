package letcode2026;

public class SmallestValueAfterReplacingWithSumOfPrimeFactors {
    public static int smallestVale(int n){
        int r = getFacfors(n);
        return (n == r)?n:smallestVale(r);
    }

    public static int getFacfors(int n){
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0 && n > 0) {
                ans += i;
                n = n / i;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(smallestVale(15));
    }
}
