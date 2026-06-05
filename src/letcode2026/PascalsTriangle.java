package letcode2026;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        //base case
        result.add(List.of(1));
        if (numRows == 1){
            return result;
        }
        result.add(List.of(1,1));
        if (numRows == 2){
            return result;
        }

        for(int i = 2; i< numRows; i++){
                List<Integer> interList = new ArrayList<>();
                interList.add(1);
                List<Integer> prevRow = result.get(i - 1);
                for(int j = 1; j<i;j++){
                    int sum = prevRow.get(j-1) + prevRow.get(j);
                    interList.add(sum);
                }
                interList.add(1);
                result.add(interList);
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(generate(5));
    }
}
