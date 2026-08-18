package helloInterview.VariableSlidingWindow;


import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {
    public static int maxFruitsInBasket(int[] fruits){
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxNum = Integer.MIN_VALUE;
        for(int i=0; i< fruits.length; i++){
            map.put(fruits[i],map.getOrDefault(fruits[i],0)+1);
            while(map.size() > 2){
                map.replace(fruits[left], map.get(fruits[left]) -1);
                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxNum = Math.max(maxNum, i-left + 1);
        }
        return (maxNum == Integer.MIN_VALUE)? 0:maxNum;
    }

    public static void main(String[] args){
        System.out.println(maxFruitsInBasket(new int[]{1,2,1}));
    }
}
