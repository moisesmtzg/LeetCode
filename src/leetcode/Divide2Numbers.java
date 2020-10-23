package leetcode;

public class Divide2Numbers {

	public int divide(int dividend, int divisor) {
		int count = 0;
		if(Integer.MIN_VALUE == dividend && divisor == -1) return Integer.MAX_VALUE;
		if(dividend == divisor) return 1;
		if(divisor == 0 || divisor == Integer.MIN_VALUE) return 0;
		
		if(dividend == Integer.MIN_VALUE){
			count++;
            dividend += Math.abs(divisor);
        }
		
		int absDividend = Math.abs(dividend);
		int absDivisor = Math.abs(divisor);
		boolean flag = (dividend<0 && divisor > 0 || dividend > 0 && divisor < 0)?true:false;
		while(absDivisor <= absDividend) {
			absDividend -=absDivisor;
			count++;
		}
		if(flag) {
			count=-count;
		}
		return count;
	}
}
