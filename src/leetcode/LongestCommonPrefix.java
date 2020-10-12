package leetcode;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		// si es vacio o nulo regresamos comillas
		if(strs.length == 0 || strs == null) {
			return "";
		}
		
		//si solo tiene una palabra esa sera el prefijo a regresar
		if(strs.length == 1) {
			return strs[0];
		}

		//tomamos la 1er palabra como prefijo y comparamos con las siguientes, quitamos caracteres
		String prefix = strs[0];
		
		//recorremos las otras palabras
		for(int i = 1; i<strs.length; i++) {
			prefix = comparePrefix(strs[i], prefix.toCharArray());
		}
		
		return prefix;
	}
	
	private String comparePrefix(String s, char[] prefix) {
		char[] word = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<prefix.length-1 ; i++) {
			if(prefix[i] == word[i]) {
				sb.append(prefix[i]);
			}else {
				break;
			}
		}
		return sb.toString();
	}
}
