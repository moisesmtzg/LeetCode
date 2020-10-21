package leetcode;

public class ZigZagConvertion {
	public String convert(String s , int rows) {
		char[][] matrix  = new char[rows][s.length()];
		int cont = 0;
		int i = 0, j = 0;

		while(cont < s.length() ) {
			if(i < rows) {
				matrix[i++][j] = s.charAt(cont++);
			}
		}
		return readMatrix(matrix);
	}
	
	private String readMatrix(char[][] matrix) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < matrix.length; i++) {
			for( int j = 0; j < matrix[i].length; j++) {
				sb.append(matrix[i][j]);
			}
		}
		return sb.toString();
	}
}
