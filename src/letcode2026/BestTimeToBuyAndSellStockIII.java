package letcode2026;

public class BestTimeToBuyAndSellStockIII {
    public static int maxProfit(int[] prices){
        int buy1= -prices[0];
        int profit1 =0;
        int buy2= -prices[0];
        int total = 0;
        for(int price : prices){
            buy1= Math.max(buy1, -price);
            profit1 = Math.max(profit1, price+buy1);
            buy2 = Math.max(buy2,profit1-price);
            total = Math.max(total,price+buy2);
        }
        return total;
    }

    public static void main(String[] args){
        System.out.println(maxProfit(new int[] {3,3,5,0,0,3,1,4}));
    }
}
