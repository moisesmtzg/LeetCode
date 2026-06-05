package letcode2026;

public class BestTimeToBuyAndSellStockII {
    public static int maxProfit(int[] prices){
        int min = prices[0];
        int count = 0;
        int curr_diff = 0;
        for(int i =1; i< prices.length; i++){
            if (prices[i] <= prices[i-1]){
                count += curr_diff;
                curr_diff = 0;
                min = prices[i];
            }else{
                curr_diff = Math.max(curr_diff, prices[i] - min);
            }
        }
        count += curr_diff;
        return count;
    }
    public static void main(String[] args){
        System.out.println(maxProfit(new int[]{2,1,4,5,2,9,7}));
    }
}
