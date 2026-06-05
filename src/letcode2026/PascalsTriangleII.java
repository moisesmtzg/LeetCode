package letcode2026;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public static List<Integer> generate(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        //base case
        result.add(List.of(1));
        if (rowIndex == 0 ) return result.get(0);
        result.add(List.of(1,1));
        if(rowIndex == 1) return result.get(1);

        for(int i = 2; i< rowIndex+1; i++){
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
        return result.get(rowIndex);
    }
    public static void main(String[] args){
        System.out.println(generate(3));
    }
}
