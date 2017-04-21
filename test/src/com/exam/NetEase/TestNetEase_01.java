package com.exam.NetEase;

import java.util.Scanner;

//背包问题
/*
 * 
 * 一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，假设已知CPU的每个核1秒可以处理1kb，每个核同时只能处理一项任务。
 * n个任务可以按照任意顺序放入CPU进行处理，现在需要设计一个方案让CPU处理完这批任务所需的时间最少，求这个最小的时间。 
 * 
 * 输入描述:
 * 输入包括两行：
 * 第一行为整数n(1 ≤ n ≤ 50)
 * 第二行为n个整数length[i](1024 ≤ length[i] ≤ 4194304)，表示每个任务的长度为length[i]kb，每个数均为1024的倍数。
 * 
 * 输出描述:
 * 输出一个整数，表示最少需要处理的时间
 * 
 * 输入例子:
 * 5
 * 3072 3072 7168 3072 1024
 * 
 * 输出例子:
 * 9216
 */
public class TestNetEase_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] mission = new int[n]; //各个任务的长度
		int i = 0;
		int sum = 0;
		for (i = 0; i < n; i++) {
			mission[i] = sc.nextInt() / 1024;
			sum += mission[i];
		}
		sc.close();
		int halfsum = sum / 2;

		// 为何正经的背包没有解决此问题？因为这不是完全背包，是0-1背包！通过80%
		// int[] time = new int[halfsum + 1];
		// for (i = 0; i < mission.length; i++) {
		// for (int j = 0; j <= halfsum; j++) {
		// if(j >= mission[i])
		// time[j] = Math.max(time[j], time[j - mission[i]] + mission[i]);
		// }
		// }
		// System.out.println(Math.max(time[halfsum], sum - time[halfsum]) *
		// 1024);

		// 改变为0-1背包后，依然不对，90%，cnm
		// 调整完后可以使用了
		int[] value = mission;
		int[][] tab = new int[n][halfsum + 1];
		for (i = mission[0]; i <= halfsum; i++)
			tab[n - 1][i] = value[0];
		for (i = 1; i < n; i++) {
			for (int j = 0; j <= halfsum; j++) {
				if (j >= mission[i]) // 核心就是这里，博客中的背包问题有误
					tab[n - 1 - i][j] = Math.max(tab[n - i][j - mission[i]] + value[i], tab[n - i][j]); // 核心
				else
					tab[n - 1 - i][j] = tab[n - i][j];
			}
		}
		System.out.println((sum - tab[0][halfsum]) * 1024);

		// 为何牛客网答案可以用一维数组AC?非常奇怪！因为他是倒叙的！
		// int[] time = new int[halfsum + 1];
		// for (i = 0; i < mission.length; i++) {
		// for (int j = halfsum; j >= 0; j--) {
		// if (j >= mission[i])
		// time[j] = Math.max(time[j], time[j - mission[i]] + mission[i]);
		// }
		// }
		// System.out.println(Math.max(time[halfsum], sum - time[halfsum]) *
		// 1024);
	}
}
