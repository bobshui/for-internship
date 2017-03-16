package sort;

public class Heap {
	public static void HeapSort(int[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {
			CreateHeap(arr, i);
			swap(arr, 0, i);
		}
	}

	public static void CreateHeap(int[] arr, int end) {
		for (int i = (end - 1) / 2; i >= 0; i--) {
			int k = i;
			while (2 * k + 1 <= end) {
				int biggerIndex = 2 * k + 1;
				if (biggerIndex < end) {
					if (arr[biggerIndex] < arr[biggerIndex + 1]) {
						biggerIndex++;
					}
				}
				if (arr[k] < arr[biggerIndex]) {
					swap(arr, k, biggerIndex);
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 6, 7, 2, 9, 5, 1, 3, 8 };
		HeapSort(arr);
		for (int i : arr)
			System.out.println(i);
	}
}
