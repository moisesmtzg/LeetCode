package ordenamiento;

public class QuickSort {

	private int array[];
	private int length;

	public void sort(int[] arr) {
		if(arr == null || arr.length == 0) {
			return;
		}
		this.array = arr;
		this.length = arr.length;
		doQuickSort(0, length-1);
	}

	private void doQuickSort(int low, int high) {
		int l = low;
		int h = high;

		int pivot = array[l + (h-l)/2];
		
		while(l <= h) {
			while(array[l] < pivot) {
				l++;
			}
			while(array[h] > pivot) {
				h--;
			}
			if(l <= h) {
				swap(l,h);
				l++;
				h--;
			}
		}

		if(low < h) doQuickSort(low, h);
		if(l < high) doQuickSort(l, high);
	}

	private void swap(int l, int h) {
		int temp = array[l];
		array[l] = array[h];
		array[h] = temp;
	}
}
