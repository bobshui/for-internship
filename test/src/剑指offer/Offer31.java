package 剑指offer;

/* 31.整数中1出现的次数（从1到n整数中1出现的次数）
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 */

public class Offer31 {

	//自己写的，强行计算法
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
	
	//真正的合理方法是分析数字的每一位为1的次数，并相加
	//https://www.nowcoder.com/questionTerminal/bd7f978302044eee894445e244c7eee6有空自己去理解理解

	public static void main(String[] args) {
		int pp = NumberOf1Between1AndN_Solution(10);
		System.out.println(pp);
	}
}
