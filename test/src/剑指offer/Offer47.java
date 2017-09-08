package 剑指offer;

/* 47 求1+2+3+...+n
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */

//没意义，略过

public class Offer47 {
	public static int Sum_Solution(int n) {
		int ans = n;
		boolean flag = (n > 0) && (ans += Sum_Solution(n - 1)) > 0;
		System.out.println(flag);
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(Sum_Solution(5));
	}
}
