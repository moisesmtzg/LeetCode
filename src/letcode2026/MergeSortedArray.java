package letcode2026;

import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int zeros = m + n -1;
        int mValido = m-1;
        int nValido = n-1;

        while(mValido >= 0 && nValido>=0 ){
            if(nums1[mValido] > nums2[nValido]){
                nums1[zeros] = nums1[mValido];
                mValido--;
            }else{
                nums1[zeros] = nums2[nValido];
                nValido--;
            }
            zeros--;
        }
        System.out.println(Math.max(1,2));
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(nValido);
        while( nValido >= 0){
            nums1[zeros] = nums2[nValido];
            zeros--;
            nValido--;
        }
    }

    public static void main(String[] args){
        int[] nums1 = new int[]{4,0,0,0,0,0};
        int m =1;
        int[] nums2 = new int[]{1,2,3,5,6};
        int n = 5;
        merge(nums1,m, nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}

