package letcode2026;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target){
        int size = nums.length-1;
        int l = 0;
        int r = size;
        int aux;
        if (target > nums[r]) return r+1;

        while ( l< r){
            aux = (l+r)/2;
            if(nums[aux] == target) return aux;
            if(nums[aux] > target){
                r = aux;
            }else{
                l = aux +1;
            }
        }
        return l;
    }
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
    }
}
