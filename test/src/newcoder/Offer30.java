package newcoder;

public class Offer30 {

	public static int FindGreatestSumOfSubArray(int[] array) {
		if (array.length == 0)
			return 0;
		int total = array[0];
		int maxSum = array[0];
		for (int i = 1; i < array.length; i++) {
			if (total > 0)
				total += array[i];
			else
				total = array[i];
			if (total > maxSum)
				maxSum = total;
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, -2, 4, -1 };
		System.out.println(FindGreatestSumOfSubArray(arr));
	}
}
