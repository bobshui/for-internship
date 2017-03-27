package exam;

import java.util.Scanner;

public class TestNetEase_5 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int count = in.nextInt();
		int[] arr = new int[n];
		int i = 0;
		while (n-- > 0) {
			arr[i++] = in.nextInt();
			if (arr[i - 1] > 100)
				arr[i - 1] %= 100;
		}
		in.close();

		while (count-- > 0) {
			int temp = arr[0];
			for (int j = 0; j < arr.length - 1; j++) {
				arr[j] = arr[j] + arr[j + 1];
				if (arr[j] > 100)
					arr[j] %= 100;
			}
			arr[arr.length - 1] = temp + arr[arr.length - 1];
			if (arr[arr.length - 1] > 100)
				arr[arr.length - 1] %= 100;
		}

		for (int k = 0; k < arr.length - 1; k++)
			System.out.print(arr[k] + " ");
		System.out.print(arr[arr.length - 1]);
	}
}
