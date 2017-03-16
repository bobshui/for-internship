package sort;

/*
 * 考慮gap的取值有什么讲究
 */

public class Shell {
	public static void ShellSort(int[] arr) {
		int temp;
		int j;
		int gap = arr.length / 2;
		//int gap=3;
		while (gap >= 1) {
			for (int i = gap; i < arr.length; i++) {
				temp = arr[i];
				for (j = i - gap; j >= 0 && temp < arr[j]; j = j - gap)
					arr[j + gap] = arr[j];
				arr[j + gap] = temp;
			}
			gap=gap/2;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 4, 6, 7, 2, 9, 5, 1, 3, 8 };
		ShellSort(arr);
		for (int i : arr)
			System.out.println(i);
	}
}
