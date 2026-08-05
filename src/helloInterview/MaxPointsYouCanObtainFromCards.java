package helloInterview;

public class MaxPointsYouCanObtainFromCards {
    public static int maxScore(int[] cards, int k){
        int max = 0;
        for(int card: cards){
            max+=card;
        }
        if ( k == cards.length) return max;

        int maxPoints = Integer.MIN_VALUE;
        int sum = 0;
        int count = 0;
        for(int i = 0; i< cards.length;i++){
            sum +=cards[i];
            if(i-count+1 == cards.length - k){
                maxPoints = Math.max(maxPoints, max-sum);
                sum-=cards[count];
                count++;
            }
        }
        return maxPoints;
    }
    public static void main(String[] args){
        System.out.println(maxScore(new int[]{1,2,3,4,5,6,1},3));
    }
}
