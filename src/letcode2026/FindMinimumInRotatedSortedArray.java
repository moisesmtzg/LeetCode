package letcode2026;

public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums){
        int l = 0,r = nums.length-1,m = 0;

        while(l < r){
            m = (l + r)/2;
            if(nums[m] > nums[r]){
                l = m+1;
            }else{
                r = m;
            }
        }
        return nums[l];
    }

    public static void main(String []args){
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2,3}));
    }
}
