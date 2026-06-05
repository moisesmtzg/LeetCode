package letcode2026;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        if ( n == 1) return 1;
        if ( n == 2) return 2;

        int previous = 1;
        int current = 1;
        for(int i  =2; i<=n;i++){
            int temp = current;
            current = previous + current;
            previous = temp;
        }
        return current;
    }

    public static void main(String[] args){
        System.out.println(climbStairs(5));
    }
}
