package algoExpert;

public class QuickSelect {
    public static int quickselect(int[] array, int k) {
        // Define los límites iniciales de búsqueda: cubrimos todo el arreglo
        int start = 0;
        int end = array.length - 1;

        // Inicia un bucle iterativo que se ejecutará hasta encontrar el elemento k
        while (true) {
            // Llama a partition para acomodar el subarreglo actual alrededor de un pivote.
            // Recibe el índice final real en donde quedó parado dicho pivote.
            int pivotIdx = partition(array, start, end);

            // CASO IDEAL: Si el índice del pivote coincide exactamente con la posición k (ajustada a base 0),
            // significa que el elemento correcto ya está en su lugar final ordenado.
            if (pivotIdx == (k - 1)) {
                return array[pivotIdx]; // Retorna el valor encontrado y rompe el bucle/método.

                // CASO IZQUIERDA: Si el pivote quedó a la derecha de nuestro objetivo (índice > k-1),
                // el valor buscado es menor. Descartamos la derecha moviendo el límite 'end'.
            } else if (pivotIdx > (k - 1)) {
                end = pivotIdx - 1;

                // CASO DERECHA: Si el pivote quedó a la izquierda de nuestro objetivo (índice < k-1),
                // el valor buscado es mayor. Descartamos la izquierda moviendo el límite 'start'.
            } else {
                start = pivotIdx + 1;
            }
        }
    }

    private static int partition(int[] array, int start, int end) {
        // Selecciona el último elemento del rango actual como el "pivote" de comparación
        int pivot = array[end];

        // 'i' actúa como la frontera de los elementos que son menores o iguales al pivote.
        // Comienza justo antes de 'start' porque aún no hemos verificado ningún elemento.
        int i = start - 1;

        // El puntero explorador 'j' recorre desde 'start' hasta justo antes de 'end' (donde está el pivote)
        for (int j = start; j < end; j++) {
            // Si el elemento actual analizado por 'j' es menor o igual al pivote...
            if (array[j] <= pivot) {
                i++; // Expandimos la frontera de elementos menores incrementando 'i'

                // Intercambiamos array[j] con array[i] para mover el elemento menor hacia adelante
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }

        // Al salir del for, todos los elementos menores al pivote están antes o en 'i'.
        // Colocamos el pivote en su posición correcta final intercambiándolo con el elemento en 'i + 1'
        int temp = array[end];
        array[end] = array[i + 1];
        array[i + 1] = temp;

        // Devolvemos el índice definitivo donde se ubicó el pivote
        return i + 1;
    }

    public static void main(String[] args){
        System.out.println(quickselect(new int[]{8, 5, 2, 9, 7, 6, 3}, 3));
    }
}
