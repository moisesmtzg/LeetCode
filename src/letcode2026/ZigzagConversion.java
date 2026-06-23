package letcode2026;

public class ZigzagConversion {
    public static String convert(String s, int numRows){
        int size = s.length();
        char[][] matrixChar = new char[numRows][size];

        int cont = 0;
        int i = 0, j = 0;

        while(cont < size) {
            if(i < numRows) {
                matrixChar[i++][j] = s.charAt(cont++);
            }
        }
        return readMatrix(matrixChar);
    }

    private static String readMatrix(char[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < matrix.length; i++) {
            for( int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(convert("PAYPALISHIRING",3));
    }
}
