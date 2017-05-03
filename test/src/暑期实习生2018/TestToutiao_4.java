package 暑期实习生2018;

/*
 * 数列
 * 
 * 题目描述：
 * 给定两个长度为 n 的整数数列 A 和 B。再给定 q 组查询，每次查询给出两个整数 x 和 y，求满足 Ai >= x 且 Bi >= y 这样的 i 的数量。
 * 
 * 输入
 * 第一行给定两个整数 n 和 q。
 * 第二行给定数列 A，包含 n 个整数。
 * 第三行给定数列 B，包含 n 个整数。
 * 接下来 q 行，每行两个整数 x 和 y，意义如上所述。
 * 
 * 输出
 * 对于每组查询，输出所求的下标数量。
 * 
 * 样例输入
 * 3 2
 * 3 2 4
 * 6 5 8
 * 1 1
 * 4 8
 * 
 * 样例输入
 * 3
 * 1

Hint
数据规模
对于 30% 的数据，1 <= n, q <= 100。
对于 100% 的数据，1 <= n, q, Ai, Bi <= 10^5。
 */
import java.util.Scanner;

//30%，算法没有任何优化，辣鸡
public class TestToutiao_4{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q=in.nextInt();
		int[] number1 = new int[n];
		int[] number2 = new int[n];
		for (int i = 0; i < number1.length; i++)
			number1[i] = in.nextInt();
		for (int i = 0; i < number2.length; i++)
			number2[i] = in.nextInt();
		
		int[] compare=new int[2*q];
		for (int i = 0; i < compare.length; i++)
			compare[i] = in.nextInt();
		
		in.close();
		
		int k=0;
		while(k<q){
			int count=0;
			for(int i=0;i<n;i++){
				if(number1[i]>=compare[2*k]&&number2[i]>=compare[2*k+1])
					count++;
			}
			System.out.println(count);
			k+=1;
		}
	}
}
