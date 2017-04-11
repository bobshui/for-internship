package exam;

import java.util.Scanner;

/*
 * 有一个整数n，将n分解成若干个不同自然数之和，问如何分解能使这些数的乘积最大，输出这个乘积m
输入
一个整数，不超过50
输出
一个整数

样例输入
15
样例输出
144
 */

public class TestXiecheng_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		if (n == 2 || n == 3) {
			System.out.println(2);
			return;
		}
		if (n == 4) {
			System.out.println(4);
			return;
		}
		int[] arr = { 2, 3, 4, 5, 6, 7, 8, 9 ,10};
		int index = 0;
		int sum = 0;
		while (sum <= n) {
			sum = sum + arr[index];
			index++;
		}

		sum=sum-arr[index-1];
//		if(sum==n)
//			index--;
//		else
		index=index-2;

		
		int count = n - sum;

		for (int i = 0; i < 2; i++) {
			for (int j = index; j >= 0; j--) {
				if (count > 0){
					arr[j]++;
					count--;
				}
				else
					break;
			}
		}

		int result = 1;
		for (int i = 0; i <= index; i++) {
			result *= arr[i];
		}
		System.out.println(result);
	}
}
