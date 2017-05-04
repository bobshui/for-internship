package 剑指offer;

/* 12数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。不得使用库函数。
 * 书中不考虑大数问题。
 */

public class Offer12 {
	// 主要在于考虑各种条件，exponent的正负0取值
	// 对于自己想偷懒或者不确定的边界条件，不去实现的话也可以告诉面试官，表示自己考虑到了。

	// 写的啰嗦了一点，不过懒得改了
	public double Power(double base, int exponent) {
		if (base == 0) // 0的0次幂就当做0了
			return 0;
		if (exponent == 0)
			return 1;
		int flag = 0;
		if (exponent < 0) {
			exponent = -exponent;
			flag = 1;
		}
		double temp = base;
		while (--exponent > 0)
			temp *= base;
		return flag == 1 ? 1 / temp : temp;
	}

	// 书中用到了快速幂的解法，只针对exponent为正数的情况
	public double Power2(double base, int exponent) {
		if (exponent == 0)
			return 1;
		if (exponent == 1)
			return base;
		double result = Power2(base, exponent >> 1);
		result *= result;
		if ((exponent & 0x1) == 1)
			result *= base;
		return result;
	}

	// return Math.pow(base,exponent);
}
