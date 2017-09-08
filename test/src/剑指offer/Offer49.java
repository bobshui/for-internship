package 剑指offer;

/* 49 把字符串转换成整数
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 */

public class Offer49 {
	public int StrToInt(String str) {
		if (str == null || str.length() == 0)
			return 0;
		char[] cs = str.toCharArray();
		int flag = 1;
		int i = 0;
		if (cs[0] == '+') {
			flag = 1;
			i++;
		} else if (cs[0] == '-') {
			flag = -1;
			i++;
		}

		int result = toInt(cs, i);
		return flag * result;
	}

	public int toInt(char[] cs, int begin) {
		int result = 0;
		for (int i = begin; i < cs.length; i++) {
			if (cs[i] >= '0' && cs[i] <= '9') {
				result = result * 10 + (cs[i] - '0');
				if (result > Integer.MAX_VALUE/10&&i<cs.length-1) 
					return 0;
			} else
				return 0;
		}
		return result;
	}

	public static void main(String[] args) {
		Offer49 offer49 = new Offer49();
		System.out.println(offer49.StrToInt("+2147483647"));
	}
}
