package exam;

/*
 * 找出函数的最宽尖峰
时间限制：C/C++语言 2000MS；其他语言 4000MS
内存限制：C/C++语言 131072KB；其他语言 655360KB
题目描述：
按数组的形式给出函数f(x)的取值，即数组A的A[0]元素为f(0)的取值，数组的取值都为整数，
函数在每个点都是严格单调递增或者严格递减（即A[i-1] != A[i] != A[i+1]），
要求找出最宽的先上升后下降的区间（这个区间内函数的值必须先上升到一个点然后下降，
区间的上升段和下降段长度必须都大于0）。
1. 如果找到符合条件的最大区间输出数组对应的左右下标（有多个最大区间时，输出最左边的那个”）
2. 找不到那么输出-1 -1
输入
n
n长度的整数数组
输出
区间的范围

样例输入
10
1 3 1 2 5 4 3 1 9 10
样例输出
2 7

Hint
数据规模
对于 100% 的数据，1 <=n <=10, 000, 000
 */
import java.util.Scanner;

//暂时通过90%,找不到的输出没有解决
public class TestToutiao_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] number = new int[n];
		for (int i = 0; i < n; i++)
			number[i] = in.nextInt();

		int left = 0, leftresult = 0;
		int right = 0, rightresult = 0;
		int count = 0;

		// for (int i = 0; i < n - 1; i++) {
		int i = 0;
		while (i < n - 1) {
			if (number[i] < number[i + 1]) {
				left = i;
				while (i < n - 1 && number[i] < number[i + 1])
					i++;
				int top = i;
				while (i < n - 1 && number[i] > number[i + 1])
					i++;
				right = i;
				if (right == top || left == top) {
					right = 0;
					left = 0;
					break;
				}
				if ((right - left) > count) {
					count = right - left;
					leftresult = left;
					rightresult = right;
				}
			} else
				i++;
		}
		if (right == 0 && left == 0)
			System.out.println(-1 + " " + -1);
		else
			System.out.println(leftresult + " " + rightresult);
		in.close();
	}
}
