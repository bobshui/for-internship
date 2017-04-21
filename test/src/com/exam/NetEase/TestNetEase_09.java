package com.exam.NetEase;

import java.util.Scanner;

/*
 * 小易有一块n*n的棋盘，棋盘的每一个格子都为黑色或者白色，小易现在要用他喜欢的红色去涂画棋盘。小易会找出棋盘中某一列中拥有相同颜色的最大的区域去涂画，
 * 帮助小易算算他会涂画多少个棋格。 
 * 
 * 输入描述:
 * 输入数据包括n+1行：
 * 第一行为一个整数n(1 ≤ n ≤ 50),即棋盘的大小
 * 接下来的n行每行一个字符串表示第i行棋盘的颜色，'W'表示白色，'B'表示黑色
 * 
 * 输出描述:
 * 输出小易会涂画的区域大小
 * 
 * 输入例子:
 * 3
 * BWW
 * BBB
 * BWB
 * 
 * 输出例子:
 * 3
 * 
 */
public class TestNetEase_09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		sc.nextLine();
		String[] strs = new String[count];
		for (int i = 0; i < count; i++) {
			strs[i] = sc.nextLine();
		}
		sc.close();

		int result = 0;
		for (int i = 0; i < count; i++) {
			int num = 1;
			for (int j = 0; j < count - 1; j++) {
				if (strs[j].charAt(i) == strs[j+1].charAt(i)) {
					num++;
					if (num > result)
						result = num;
				} else
					num = 1;
			}
		}
		System.out.println(result);
	}
}
