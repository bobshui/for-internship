package com.exam.NetEase;

import java.util.Scanner;

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

//好难 今天不想了
public class TestNetEase_11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr=new int[n];
		int sum=0;
		for (int i = 0; i < n; i++) {
			arr[i]=sc.nextInt();
			sum+=arr[i];
		}
		sc.close();
		
		int[] dp0 = new int[sum * 2 + 1], dp1 = new int[sum * 2 + 1];
	}
}
