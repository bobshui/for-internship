package other;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Test360 {
	public static void main(String[] args) {
		int[] arr = { 4, 7, 2, 9, 5, 2 };
		int low = 0, high = arr.length - 1;
		int sum = 0;
		int count1, count2;
		for (int i : arr)
			sum = sum + i;
		count1 = choose(arr, sum, low, high);
		count2 = sum - count1;
		System.out.println(count1 + "---" + count2);
		choose2();
	}

	public static int choose(int[] array, int sum, int low, int high) {
		if (low == high)
			return array[low];
		else {
			return Math.max(sum - choose(array, sum - array[low], low + 1, high),
					sum - choose(array, sum - array[high], low, high - 1));
		}
	}

	
	//看不懂
	public static void choose2() {
		Scanner sca = new Scanner(System.in);
		// int m = sca.nextInt();
		// for(int k=1; k<=m; k++){
		int n = sca.nextInt();
		int[] array = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			array[i] = sca.nextInt();
		}
		int[] sum = new int[n + 1];
		sum[0] = 0;
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + array[i];
		}
		int[][] dp = new int[n + 2][n + 2];
		for (int i = 0; i <= n - 1; i++) {
			for (int j = 1; j <= n - i; j++) {
				dp[j][j + i] = sum[j + i] - sum[j - 1] - Math.min(dp[j + 1][j + i], dp[j][j + i - 1]);
			}
		}
		System.out.println(dp[1][n] + "---" + (sum[n] - dp[1][n]));
		// }
		sca.close();
	}
}
