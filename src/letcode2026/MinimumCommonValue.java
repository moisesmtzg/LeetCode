package letcode2026;

public class MinimumCommonValue {
    public static int getCommon(int[] nums1, int[] nums2){
        int p1 = 0;
        int p2 = 0;

        if(nums1.length == 0 || nums2.length == 0) return -1;

        while(p1 < nums1.length && p2 <nums2.length){
            if(nums1[p1] == nums2[p2]){
                return nums1[p1];
            }
            if(nums1[p1] > nums2[p2]){
                p2++;
            }else{
                p1++;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(getCommon(new int[]{3,5}, new int[]{2}));
    }
}
