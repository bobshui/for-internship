package 排序;

public class Insertion {
	public static void InsertionSort(int[] arr) {
		int temp;
		int j;
		for (int i = 1; i < arr.length; i++) {
			j = i;
			temp = arr[j];
			while (j > 0 && arr[j - 1] > temp) {
				arr[j] = arr[j - 1];
				--j;
			}
			arr[j] = temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 4, 6, 7, 2, 9, 5, 1, 3, 8 };
		InsertionSort(arr);
		for (int i : arr)
			System.out.println(i);
	}
}
