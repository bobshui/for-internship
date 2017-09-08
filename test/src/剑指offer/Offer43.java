package 剑指offer;

/* 43 左旋转字符串
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */


//书里面的反转，第一波cbaXYZdef,第二波cbafedZYX,第三波大反转XYZdefabc即符合要求

public class Offer43 {
	//这个是组装之后再截取
	public static String LeftRotateString(String str, int n) {
		int len = str.length();
		if (len == 0)
			return "";
		n = n % len;
		str = str+str;
		return str.substring(n, len+n);
	}
	
	public static void main(String[] args) {
		String string = LeftRotateString("abcdefg", 2);
		System.out.println(string);
	}
}
