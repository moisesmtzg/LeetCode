package letcode2026;

public class MaximumAverageSubarrayI {
    public static double findMaxAverage(int[] nums, int k){

        int size = nums.length;
        double average;
        int total = 0;
        for (int i = 0; i<k;i++){
            total += nums[i];
        }
        average = (double) total /k;

        for(int j=k;j<size;j++){
            total += nums[j] - nums[j-k];
            average = Math.max(average, (double) total /k);
        }

        return average;
    }

    public static void main(String[] args){
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
    }
}
