package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostFrequentKElements {

	public List<String> mostFElements(String arr[], int k){
		//se crea un mapa y se pone el string con el numero de veces que sale en el array
		Map<String, Integer> map = new HashMap<String, Integer>();
		int max = 0;
		for(int i = 0; i<arr.length;i++) {
			int freq  = map.getOrDefault(arr[i], 0)+1;
			map.put(arr[i], freq);
			//se obtiene el numero mas alto
			max = Math.max(max, freq);
		}
		
		//se crea una lista de tamaño "max" y en cada posicion de la lista se agrega la llave
		List<String>[] bucket = new List[max+1];
		for(String key : map.keySet()) {
			int freq = map.get(key); 
			if(bucket[freq] == null) {
				bucket[freq] = new ArrayList<String>();
			}
			bucket[freq].add(key);
		}
		
		List<String> res = new ArrayList<String>();
		for(int i = bucket.length-1; i >=0 && k >0; i--) {
			if(bucket[i] != null) {
				res.addAll(bucket[i]);
				k-=bucket[i].size();
			}
			
		}
		return res;
	}
	
	public List<String> mostFElementsLamda(String arr[], int k){
		//se crea un mapa con los elementos y sus frecuencias
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String s : arr) {
			map.put(s, map.getOrDefault(s, 0)+1);
		}
		
		//se empieza con el entry set, despues se hace el sort por el valor y se le aplica el limite "k"
		// luego se hace el mapa para tener la llave y se manda como lista
		List<String> temporal = 
				map.entrySet()
				.stream()
				.sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue()))
				.limit(k)
				.map(i -> i.getKey())
				.collect(Collectors.toList());
		return temporal;
	}
}
