package letcode2026;

public class MaximunDistanceBetweenAPairOfValues {
    public static int maxDistance(int[] nums1, int[] nums2){
        /*
         * Fuerza brua
        int distance = 0;
        for (int i = 0; i <nums1.length; i++) {
            int j = i;
            while(j < nums2.length){
                if( i <= j && nums1[i] <= nums2[j]){
                    distance = Math.max(distance, j-i);
                }
                j++;
            }
        }
        return distance;
         */
        int distance = 0;
        for(int i=0;i<nums1.length;i++){
            int start = i;
            int end = nums2.length -1;
            while( start <= end){
                int mid = start + (end -start)/2;
                if(nums1[i] <= nums2[mid]){
                    distance = Math.max(distance, mid-i);
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return distance;
    }

    public static void main(String[] args){
        System.out.println(maxDistance(new int[]{2,2,2}, new int[]{10,10,1}));
    }
}
/**
 *  0   1   2   3   4
 *  55  30  5   4   2
 *
 *  100 20  10  10  5
 */