package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum3numbers {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>> ();
		// si el tamaño de nums es menor a 3 o si esta vacia regresamos una lista vacia
		if(nums.length < 3 || nums == null) {
			return res;
		}
		
		//debemos de formar las listas que contengan 3 numeros y que la suma de 0
		//se crea un set de listas pq nos piden que sean unicas las triadas
		Set<List<Integer>> listas = new HashSet<List<Integer>> ();
		
		//se ordenan los numeros
		Arrays.sort(nums);

		//vamos recorriendo los nums, usaremos 2 apuntadores mas el i, el i se usara para ir recorriendo los nums
		int apuntador1, apuntador2;
		for(int i = 0; i< nums.length-2; i++) {
			apuntador1 = i+1;
			apuntador2 = nums.length-1;
			
			while(apuntador1 < apuntador2) {
				//sumamos para ver si tenemos que mover algun aputador
				if(nums[apuntador1] + nums[apuntador2] + nums[i] > 0) {
				//pq estan ordenoamos los nums le bajamos al apuntador2
					apuntador2--;
				}else if(nums[apuntador1] + nums[apuntador2] + nums[i] < 0) {
					apuntador1++;
				//si suman 0, creamos una lista y la agregamos al set
				}else {
					listas.add(Arrays.asList(nums[apuntador1], nums[apuntador2], nums[i]));
					apuntador1++;
				}
			}
		}
		//recorremos el set, para crear solo una lista
		for(List<Integer> list : listas) {
			res.add(list);
		}
		return res;
	}
}
