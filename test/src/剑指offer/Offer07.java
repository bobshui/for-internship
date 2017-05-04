package 剑指offer;

/* 07斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 */

public class Offer07 {

	public int Fibonacci(int n) {
		int temp1 = 0;
		int temp2 = 1;
		int temp;
		if (n == 1)
			return 1;
		if (n == 0)
			return 0;
		while (n - 1 > 0) {
			temp = temp1;
			temp1 = temp2;
			temp2 = temp + temp2;
			n--;
		}
		return temp2;
	}

	// 递归的麻烦已经说的差不多了，快速幂的东西比较复杂，在网易的笔试题里面有，但是有个简略的
	// 很简约,抄袭
	public int Fibonacci2(int n) {
		int f = 0, g = 1;
		while (n-- > 0) {
			g += f;
			f = g - f;
		}
		return f;
	}

	public static void main(String[] args) {
		System.out.println(new Offer07().Fibonacci(4));
	}
}
