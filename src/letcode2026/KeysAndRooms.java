package letcode2026;

import java.util.*;

public class KeysAndRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Set<Integer> visitedRooms = new HashSet<>();
        Stack<Integer> keys = new Stack<>();

        // 1- metemos la primer llave hab 0 a la stack de llaves

        keys.push(0);
        while(!keys.empty()){
            int currentKey = keys.pop();
            visitedRooms.add(currentKey);
            List<Integer> keysRoom = rooms.get(currentKey);
            for(Integer keyRoom: keysRoom){
                if(!visitedRooms.contains(keyRoom)){
                    keys.push(keyRoom);
                }
            }
        }
        return visitedRooms.size() == rooms.size();
    }
    public static void main(String[] args){
        List<Integer> listN = new ArrayList<>();
        listN.add(1);
        listN.add(3);
        List<Integer> listN2 = new ArrayList<>();
        listN2.add(3);
        listN2.add(0);
        listN2.add(1);
        List<Integer> listN3 = new ArrayList<>();
        listN3.add(2);
        List<Integer> listN4 = new ArrayList<>();
        listN4.add(0);
        List<List<Integer>> list = new ArrayList<>();
        list.add(listN);
        list.add(listN2);
        list.add(listN3);
        list.add(listN4);
        System.out.println(list);
        System.out.println(canVisitAllRooms(list));
    }
}
