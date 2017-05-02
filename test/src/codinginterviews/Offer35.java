package codinginterviews;

public class Offer35 {
	public static int InversePaors(int[] array) {
		int count = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] < array[i + 1])
				count++;
		}
		return count % 1000000007;
	}

	public static int count;

	public static void MergeSort(int[] arr, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			MergeSort(arr, low, mid);
			MergeSort(arr, mid + 1, high);
			MergeArray(arr, low, mid, high);
		}
		return;
	}

	public static void MergeArray(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low, j = mid + 1, k = high, m = mid;
		int t = 0;
		while (i <= m && j <= k) {
			if (arr[i] <= arr[j])
				temp[t++] = arr[i++];
			else {
				temp[t++] = arr[j++];
				count += m - i + 1;
			}
			if (count > 1000000007)
				count %= 1000000007;
		}

		while (i <= m)
			temp[t++] = arr[i++];

		while (j <= k)
			temp[t++] = arr[j++];

		for (int p = 0; p < t; p++)
			arr[low + p] = temp[p];

	}

	public static void main(String[] args) {
		int[] arr = { 4, 6, 7, 2, 9, 5, 1, 3, 8 };
		// int[] arr = { 5, 1 };
		count = 0;
		MergeSort(arr, 0, arr.length - 1);
		for (int i : arr)
			System.out.println(i);
		System.out.println("count:" + count);
	}
}
