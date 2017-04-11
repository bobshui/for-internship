package exam;

import java.util.Scanner;

/*
 * 均等
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
一天，小明带来了一大堆巧克力，共n条且长短不一。他想分成每条都相同长度的巧克力条分给同事，但又想偷懒，
于是他想知道在能均分巧克力的前提下，用最少分割次数分割后能得到的巧克力的长度是多少。
输入
输入第一行一个整数n(1<=n<=50)，表示巧克力条数。
接下来第二行n个整数Li(1<=Li<=100000)，分别表示第i条巧克力的长度。
输出
输出一行一个整数，表示用最少分割次数分割后能得到的巧克力的长度。

样例输入
4
4 22 8 12
样例输出
2
 */
public class TestRenren_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] bars = new int[n];
		for (int i = 0; i < n; i++) {
			bars[i] = sc.nextInt();
		}
		sc.close();
		int result = 0;
		if (n == 1) {
			System.out.println(bars[0]);
		} else if (n == 2) {
			result = maxCommonDivisor2(bars[0], bars[1]);
			System.out.println(result);
			return;
		} else {
			result = maxCommonDivisor2(bars[0], bars[1]);
			for (int i = 2; i < bars.length; i++) {
				result = maxCommonDivisor2(result, bars[i]);
				if (result == 1)
					break;
			}
			System.out.println(result);
		}
	}

	public static int maxCommonDivisor2(int m, int n) {

		if (m < n) {
			int temp = m;
			m = n;
			n = temp;
		}
		while (m % n != 0) {
			int temp = m % n;
			m = n;
			n = temp;
		}
		return n;// 返回最大公约数
	}
}
