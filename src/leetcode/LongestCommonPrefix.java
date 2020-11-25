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

		//tomamos un prefijo vacio y vamosa tomar el 1er caracter
		// de la primera palabra y vamos a comparlo con el de las otras palabras
		String prefix = "";
		for(int charIndex = 0; charIndex < strs[0].length(); charIndex++) {
			//tomamos el 1er caracter de la primera palabra, este lo buscaremos en las otras palabras
			char c = strs[0].charAt(charIndex);
			for(int wordIndex = 1; wordIndex < strs.length; wordIndex++) {
				//revisamos si tamaño de la 1a palabra(charIndex) es mayor al de las otras, regresamos el prefijo que tenmos 
				if(charIndex >= strs[wordIndex].length()) {
					return prefix;
				}
				//si los caracteres son diferentes, regresamo el prefijo
				if(c != strs[wordIndex].charAt(charIndex)) {
					return prefix;
				}
			}
			//le añadimos el siguiente caracter al prefijo que tenemos
			prefix = strs[0].substring(0, charIndex+1);
		}
		return prefix;
	}
}
