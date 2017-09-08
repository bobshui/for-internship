package 剑指offer;

/* 48 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */

//模拟的是加法中相加，进位的过程
public class Offer48 {
	public int Add(int num1, int num2) {
		while(num2!=0){
			int temp=num1^num2;
			num2=(num1&num2)<<1;
			num1=temp;
		}
		return num1;
	}
	
	public static void main(String[] args) {
		Offer48 offer48=new Offer48();
		int a = offer48.Add(5, 7);
		System.out.println(a);
	}
}
