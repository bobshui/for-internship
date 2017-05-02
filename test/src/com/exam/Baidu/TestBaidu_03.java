package com.exam.Baidu;

import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;

public class TestBaidu_03 {
	
	private static int count=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] list = new int[n];
		for (int i = 0; i < n; i++)
			list[i] = i + 1;
		int result = permutation(list, 0, n - 1, k);
		System.out.println(result);

	}

	private static void swap(int list[], int i, int j)// 交换list中i和j位置的元素
	{
		int t = list[i];
		list[i] = list[j];
		list[j] = t;
	}

	private static int permutation(int list[], int m, int n, int k)// 输出list中m到n的全排列
	{
		
		int temp=0;
		if (m == n) {
			for (int i = 0; i <= n - 1; i++) {
				if (list[i] < list[i + 1])
					temp++;
			}
			if(temp==k){
				count++;
				temp=0;
			}
		} else {
			for (int i = m; i <= n; i++) {
				swap(list, m, i);// 把第i个和第一个(此时是m)交换
				permutation(list, m + 1, n, k);// 余下的继续递归
				swap(list, m, i);// 将第i个放回原处
			}
		}
		return count;
	}
}
