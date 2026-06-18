package algoExpert;

import java.util.Arrays;

public class SearchForRange {
    public static int[] searchForRange(int[] array, int target) {
        int[] finalRange = {-1, -1};
        finalRange[0] = alteredBinarySearch(array, target, true);  // Busca el inicio
        finalRange[1] = alteredBinarySearch(array, target, false); // Busca el final
        return finalRange;
    }

    private static int alteredBinarySearch(int[] array, int target, boolean goLeft) {
        int l = 0;
        int r = array.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (array[mid] < target) {
                l = mid + 1;
            } else if (array[mid] > target) {
                r = mid - 1;
            } else {
                // ¡Encontramos el target! Ahora validamos si es un extremo
                if (goLeft) {
                    // Si es el primer elemento o el de atrás es diferente, este es el límite izquierdo
                    if (mid == 0 || array[mid - 1] != target) {
                        return mid;
                    } else {
                        r = mid - 1; // Sigue buscando a la izquierda
                    }
                } else {
                    // Si es el último elemento o el de adelante es diferente, este es el límite derecho
                    if (mid == array.length - 1 || array[mid + 1] != target) {
                        return mid;
                    } else {
                        l = mid + 1; // Sigue buscando a la derecha
                    }
                }
            }
        }
        return -1; // No se encontró
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(searchForRange(new int[]{5, 7, 7, 8, 8, 10},5)));
    }
}
