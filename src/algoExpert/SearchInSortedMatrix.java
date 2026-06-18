package algoExpert;

import java.util.Arrays;

public class SearchInSortedMatrix {
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int xSize = matrix.length - 1; // Empezamos abajo
        int ySize = 0;                  // Izquierda

        // El ciclo SOLO corre si estamos pisando terreno seguro dentro de la matriz
        while (xSize >= 0 && ySize < matrix[0].length) {

            if (matrix[xSize][ySize] == target) {
                return new int[] {xSize, ySize}; // ¡Encontrado!
            }

            if (matrix[xSize][ySize] > target) {
                xSize--; // Subimos una fila si el número es muy grande
            } else {
                ySize++; // Vamos a la derecha si es muy chico
            }
        }

        // Si el ciclo terminó y no entramos al "if == target", es que el número no existe
        return new int[]{-1, -1};
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(searchInSortedMatrix(new int[][]{
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004}
        },14)));
    }
}
