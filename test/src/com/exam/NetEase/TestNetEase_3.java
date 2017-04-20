package com.exam.NetEase;

//排序
/*
 * 在幼儿园有n个小朋友排列为一个队伍，从左到右一个挨着一个编号为(0~n-1)。其中有一些是男生，有一些是女生，男生用'B'表示，女生用'G'表示。
 * 小朋友们都很顽皮，当一个男生挨着的是女生的时候就会发生矛盾。作为幼儿园的老师，你需要让男生挨着女生或者女生挨着男生的情况最少。
 * 你只能在原队形上进行调整，每次调整只能让相邻的两个小朋友交换位置，现在需要尽快完成队伍调整，你需要计算出最少需要调整多少次可以让上述情况最少。例如：
 * GGBBG -> GGBGB -> GGGBB
 * 这样就使之前的两处男女相邻变为一处相邻，需要调整队形2次 
 * 
 * 输入描述:
 * 输入数据包括一个长度为n且只包含G和B的字符串.n不超过50.
 * 
 * 输出描述:
 * 输出一个整数，表示最少需要的调整队伍的次数
 * 
 * 输入例子:
 * GGBBG
 * 
 * 输出例子:
 * 2
 */

import java.util.Scanner;

public class TestNetEase_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();

		//大致思路是这样，有的实现稍有不同，了解冒泡的本质
		char[] cs = str.toCharArray();
		int count = 0;
		int num = 0;
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == 'B') {
				count = count + i;
				num++;
			}
		}
		int a = 0, b = 0;
		for (int j = 0; j < num; j++) {
			a = a + j;
			b = b + cs.length - j - 1;
		}

		System.out.println(b - count > count - a ? count - a : b - count);

		// 考试的时候自己的冒泡法，复杂度令人发指
		// char[] cs1 = str.toCharArray();
		// char[] cs2 = str.toCharArray();
		//
		// int count1 = 0;
		// int count2 = 0;
		//
		// char temp1;
		// int k1;
		// int flag1 = cs1.length - 1;
		// while (flag1 > 0) {
		// k1 = flag1;
		// flag1 = 0;
		// for (int j = 0; j < k1; j++)
		// if (cs1[j] < cs1[j + 1]) {
		// temp1 = cs1[j];
		// cs1[j] = cs1[j + 1];
		// cs1[j + 1] = temp1;
		// flag1 = j;
		// count1++;
		// }
		// }
		//
		// char temp2;
		// int k2;
		// int flag2 = cs2.length - 1;
		// while (flag2 > 0) {
		// k2 = flag2;
		// flag2 = 0;
		// for (int j = 0; j < k2; j++)
		// if (cs2[j] > cs2[j + 1]) {
		// temp2 = cs2[j];
		// cs2[j] = cs2[j + 1];
		// cs2[j + 1] = temp2;
		// flag2 = j;
		// count2++;
		// }
		// }
		// System.out.println(count1>count2?count2:count1);

	}

}
