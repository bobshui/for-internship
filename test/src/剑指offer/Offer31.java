package 剑指offer;

public class Offer31 {

	public static int NumberOf1Between1AndN_Solution(int n) {
		int count = 1;
		int k;
		if(n==0)
			return 0;
		if(n==1)
			return count;
		for (int i = 2; i <= n; i++) {
			int p = i;
			while (p != 0) {
				k = p % 10;
				if (k == 1)
					count++;
				p = p / 10;
			}
		}
		return count;
	}
	

	public static void main(String[] args) {
		int pp = NumberOf1Between1AndN_Solution(10);
		System.out.println(pp);
	}
}
