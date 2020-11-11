package leetcode;

public class Pow {

	public double myPow(double x, int n) {
		if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if(x == 1)
        	return 1;
        if(n <= Integer.MIN_VALUE)
        	return 0;
        double res = 1;
		boolean flag = (n>0)?true:false;
		int i = 0;
		int absExp = Math.abs(n);
		while(i < absExp) {
			res *= x;
			i++;
		}
		if(!flag) {
			res = 1/res;
		}
		return res;
	}
}
