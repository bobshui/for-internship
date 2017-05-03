package 暑期实习生2018.NetEase;

import java.util.Scanner;

//矩阵快速幂

/*
 * 小易拥有一个拥有魔力的手环上面有n个数字(构成一个环),当这个魔力手环每次使用魔力的时候就会发生一种奇特的变化：每个数字会变成自己跟后面一个数字的和
 * (最后一个数字的后面一个数字是第一个),一旦某个位置的数字大于等于100就马上对100取模(比如某个位置变为103,就会自动变为3).
 * 现在给出这个魔力手环的构成，请你计算出使用k次魔力之后魔力手环的状态。 
 * 
 * 输入描述:
 * 输入数据包括两行：
 * 第一行为两个整数n(2 ≤ n ≤ 50)和k(1 ≤ k ≤ 2000000000),以空格分隔
 * 第二行为魔力手环初始的n个数，以空格分隔。范围都在0至99.
 * 
 * 输出描述:
 * 输出魔力手环使用k次之后的状态，以空格分隔，行末无空格。
 * 
 * 输入例子:
 * 3 2
 * 1 2 3
 * 
 * 输出例子:
 * 8 9 7
 */

//主要思想是矩阵的快速幂，在剑指offer的斐波那契数列里面有讲到
public class TestNetEase_05 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int count = in.nextInt();
		int[][] nums = new int[1][n];
		int[][] math = new int[n][n];
		for (int i = 0; i < n; i++) {
			nums[0][i] = in.nextInt();
			math[i][i] = 1;
			math[(i + 1) % n][i] = 1;
		}
		in.close();
		int[][] ans = multi(nums, math, count, n);
		for (int i = 0; i < n - 1; i++) {
			System.out.print(ans[0][i]+ " ");
		}
		System.out.println(ans[0][n - 1]);

		// 通过40%的强行计算方法是没有未来的
		// int[] arr = new int[n];
		// int i = 0;
		// while (n-- > 0) {
		// arr[i++] = in.nextInt();
		// if (arr[i - 1] > 100)
		// arr[i - 1] %= 100;
		// }
		// in.close();
		//
		// while (count-- > 0) {
		// int temp = arr[0];
		// for (int j = 0; j < arr.length - 1; j++) {
		// arr[j] = arr[j] + arr[j + 1];
		// if (arr[j] > 100)
		// arr[j] %= 100;
		// }
		// arr[arr.length - 1] = temp + arr[arr.length - 1];
		// if (arr[arr.length - 1] > 100)
		// arr[arr.length - 1] %= 100;
		// }
		//
		// for (int k = 0; k < arr.length - 1; k++)
		// System.out.print(arr[k] + " ");
		// System.out.print(arr[arr.length - 1]);
	}

	private static int[][] multi(int[][] nums, int[][] math, int count, int n) {
		// TODO Auto-generated method stub
		while (count > 0) {
			if ((count&1) == 1) {
				nums = multiple(nums, math, 1, n);
			}
			math = multiple(math, math, n, n);
			count /= 2;
		}
		return nums;
	}

	private static int[][] multiple(int[][] nums, int[][] math, int c,int n) {
		// TODO Auto-generated method stub
		int[][] res = new int[n][n];
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					res[i][j] += nums[i][k] * math[k][j];
				}
				if(res[i][j]>100)
					res[i][j]%=100;
			}
		}
		return res;
	}
}
