package 剑指offer;

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
