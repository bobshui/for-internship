package 排序;

public class Quick {
	public static void QuickSort(int[] arr, int start, int end) {
		if (start < end) {
			int i = start, j = end;
			int temp = arr[start];
			while (i < j) {
				while (arr[j] > temp & i < j)
					j--;
				arr[i++] = arr[j];
				while (arr[i] < temp & i < j)
					i++;
				arr[j--] = arr[i];
			}
			arr[i] = temp;
			QuickSort(arr, start, i - 1);
			QuickSort(arr, i + 1, end);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 4, 6, 7, 2, 9, 5, 1, 3, 8 };
		QuickSort(arr, 0, arr.length - 1);
		for (int i : arr)
			System.out.println(i);
	}
}
