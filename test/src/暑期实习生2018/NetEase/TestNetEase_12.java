package 暑期实习生2018.NetEase;

import java.util.Scanner;

//动态规划

/*
 * 易老师购买了一盒饼干，盒子中一共有k块饼干，但是数字k有些数位变得模糊了，看不清楚数字具体是多少了。
 * 易老师需要你帮忙把这k块饼干平分给n个小朋友，易老师保证这盒饼干能平分给n个小朋友。现在你需要计算出k有多少种可能的数值 
 * 
 * 输入描述:
 * 输入包括两行：
 * 第一行为盒子上的数值k，模糊的数位用X表示，长度小于18(可能有多个模糊的数位)
 * 第二行为小朋友的人数n
 * 
 * 输出描述:
 * 输出k可能的数值种数，保证至少为1
 * 
 * 输入例子:
 * 9999999999999X
 * 3
 * 
 * 输出例子:
 * 4
 */

public class TestNetEase_12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char[] cs = s.toCharArray();
		int n = sc.nextInt();
		sc.close();

		long[] mod = new long[n];
		mod[0] = 1;
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == 'X')
				transform(mod, n);
			else
				transform(mod, cs[i] - '0', n);
		}
		System.out.println(mod[0]);
	}

	private static void transform(long[] mod, int k, int n) {
		// TODO Auto-generated method stub
		long[] tmpMod = new long[n];
		for (int i = 0; i < n; i++) {
			tmpMod[(i * 10 + k) % n] += mod[i];
		}
		for (int i = 0; i < n; i++) {
			mod[i] = tmpMod[i];
		}
	}

	private static void transform(long[] mod, int n) {
		// TODO Auto-generated method stub
		long[] tmpMod = new long[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10; j++) {
				tmpMod[(i * 10 + j) % n] += mod[i];
			}
		}
		for (int i = 0; i < n; i++) {
			mod[i] = tmpMod[i];
		}
	}
}
