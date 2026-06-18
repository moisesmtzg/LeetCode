package algoExpert;

public class ShiftedBinarySearch {
    public static int shiftedBinarySearch(int[] array, int target) {
        // Write your code here.
        int l = 0;
        int r = array.length-1;

        while(l<=r){
            int mid = l + (r-l)/2;
            if(array[mid] == target){
                return mid;
            }
            if(array[l] <= array[mid]){
                if(target >= array[l] && target <array[mid]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }else{
                if(target <= array[r] && target > array[mid]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(shiftedBinarySearch(new int[]{45, 61, 71, 72, 73, 0, 1, 21, 33, 37},72));
    }
}
