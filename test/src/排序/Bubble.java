package 排序;

/*
 * 包含了两种改进的方法
 */

public class Bubble {
	public static void BubbleSort(int[] arr) {
		int temp;
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++)
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
		}
	}

	// 设置一个标志，如果这一趟发生了交换，则为true，否则为false。
	// 明显如果有一趟没有发生交换，说明排序已经完成。
	public static void BubbleSort2(int[] arr) {
		int temp;
		boolean flag = true;
		while (flag == true) {
			for (int i = arr.length - 1; i > 0; i--) {
				flag = false;
				for (int j = 0; j < i; j++)
					if (arr[j] > arr[j + 1]) {
						temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
						flag = true;
					}
			}
		}
	}

	// 从某个位置开始没有交换了，这个位置之后的数据必定已经有序了
	// 记录下这位置，第二次只要从数组头部遍历到这个位置就可以了。

	public static void BubbleSort3(int[] arr) {
		int temp;
		int k;
		int flag = arr.length - 1;
		while (flag > 0) {
			k = flag;
			flag = 0;
			for (int j = 0; j < k; j++)
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = j;
				}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 4, 6, 7, 2, 9, 5, 1, 3, 8 };
		BubbleSort3(arr);
		for (int i : arr)
			System.out.println(i);
	}
}
