package algoExpert;

public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        // Write your code here.
        if (array.length == 0){
            return 0;
        }

        if (array.length == 1 && array[0] != target){
            return -1;
        }

        int size = array.length;
        int left = 0;
        int right = size-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(array[mid] == target){
                return mid;
            }
            if(array[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main (String[] args){
        System.out.println(binarySearch(new int[]{0,1,21,33,45,45,61,71,72,73}, 33));
    }
}
