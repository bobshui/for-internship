package com.exam.NetEase;

import java.util.Scanner;

//动态规划

/*
 * 小易有n块砖块，每一块砖块有一个高度。小易希望利用这些砖块堆砌两座相同高度的塔。为了让问题简单，砖块堆砌就是简单的高度相加，
 * 某一块砖只能使用在一座塔中一次。小易现在让能够堆砌出来的两座塔的高度尽量高，小易能否完成呢。 
 * 
 * 输入描述:
 * 输入包括两行：
 * 第一行为整数n(1 ≤ n ≤ 50)，即一共有n块砖块
 * 第二行为n个整数，表示每一块砖块的高度height[i] (1 ≤ height[i] ≤ 500000)
 * 
 * 输出描述:
 * 如果小易能堆砌出两座高度相同的塔，输出最高能拼凑的高度，如果不能则输出-1.
 * 保证答案不大于500000。
 * 
 * 输入例子:
 * 3
 * 2 3 5
 * 
 * 输出例子:
 * 5
 */

//纯抄袭，不是很好理解状态的转换，请看注释
public class TestNetEase_11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		sc.close();
		/*
		 * 假设砖块分为A，B两堆，dp[i][j]中的j表示B-A的长度。 因为B-A有可能是负的，所以j整体偏移sum个长度，即2*sum+1。
		 * 而dp[i][j]的值则表示当A-B的值为j时，B的最大长度是多少。 
		 * dp[i][j] = dp[i-1][j]表示我不用第i块砖
		 * dp[i][j] = max(dp[i-1][j-h], dp[i-1][j])表示我把砖放在A堆。
		 * dp[i][j] = max(dp[i-1][j+h]+h, dp[i-1][j])表示我把砖放在B堆。 
		 * 然后会爆内存，所以用了“滚动数组”。
		 */
		int[] dp0 = new int[sum * 2 + 1], dp1 = new int[sum * 2 + 1];
		//初始化，在一块砖的没有放的时候，B-A只能为0。
		for (int i = 0; i < dp0.length; i++)
			dp0[i] = -1;
		dp0[sum] = 0;
		for (int i = 1; i <= n; i++) {
			int v = arr[i - 1];
			for (int j = 0; j < 2 * sum + 1; j++) {
				dp1[j] = dp0[j];
				if (j - v >= 0 && dp0[j - v] != -1)
					dp1[j] = Math.max(dp0[j - v], dp1[j]);  //放在A堆
				if (j + v <= 2 * sum && dp0[j + v] != -1)
					dp1[j] = Math.max(dp0[j + v] + v, dp1[j]);  //放在B堆
			}
			//滚动数组
			int[] temp = dp1;
			dp1 = dp0;
			dp0 = temp;
		}
		if (dp0[sum] == 0)
			System.out.println(-1);
		else
			System.out.println(dp0[sum]);
	}
}
