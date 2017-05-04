package 剑指offer;

/* 11二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */

public class Offer11 {
	// 因为补码的原因，所以不能每次右移一位进行计算，书里面还是说的很清楚的
	public int NumberOf1(int n) {
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			if ((n & flag) != 0)
				count++;
			flag <<= 1;
		}
		return count;
	}

	// 这就不得不抄袭了，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0
	// 这是一个很重要的思路
	public int NumberOf1_2(int n) {
		int count = 0;
		while (n != 0) {
			++count;
			n = (n - 1) & n;
		}
		return count;
	}

	// 但是，这样的方法呢
	// return Integer.toBinaryString(n).replaceAll("0","").length();
	// return Integer.bitCount(n); 讲道理这个方法我还不知道

	/*
	 * 书中的拓展 
	 * a.判断一个整数是不是2的整数次方 
	 * b.计算需要改变m二进制中的多少位才能变成n //统计异或结果中1的位数
	 */
}
