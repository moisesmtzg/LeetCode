package letcode2026;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices){
        int result = 0;
        int minPrice = prices[0];
        for(int price: prices){
            if (price < minPrice){
                minPrice = price;
            } else{
                result = Math.max(result, price - minPrice);
            }
        }

        return result;
    }
    public static void main(String[] args){
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
