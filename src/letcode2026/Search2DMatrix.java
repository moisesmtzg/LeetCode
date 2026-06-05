package letcode2026;

public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int sizeC = matrix.length;
        int sizeR = matrix[0].length;

        for(int i = 0; i< sizeC;){
            if (target == matrix[i][0]) return true;
            if (target > matrix[i][0]){
                int l = 0;
                int r = sizeR;
                while(l<r){
                    int m = l + (r-l)/2;
                    if(matrix[i][m] == target) return true;
                    if(matrix[i][m] > target){
                        r = m;
                    }else{
                        l = m+1;
                    }
                }
            }
            i++;
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20}, {23,30,34,60}},60));
    }
}
