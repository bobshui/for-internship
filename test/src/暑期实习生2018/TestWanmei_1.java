package 暑期实习生2018;

/* 小鱼儿和安吉一起去参加爸爸去哪儿，村长交给他们一项任务，是用老乡的水果去给爸爸兑换一个礼物，要求水果和礼物等价，不能多也不能少。
 * 假设老乡有n种水果，每种水果的数量不限，每种水果的价值不同。请帮小鱼儿和安吉计算出他们最少要和老乡要几个水果。如果无法兑换返回-1.
 * 
 * 举例：
 * 1.有3种水果，价值分别是5，2，3。礼物的价值是20.用4个5元的水果正好兑换，其他的兑换方法都要更多的水果，所以返回4
 * 2.有两种水果，价值分别是5,3，礼物的价值是2.无法正好兑换，所以返回-1
 * 
 * 输入
 * 输入数据是一个数组和一个整数代表礼物价值
 * 
 * 输出
 * 对于每个测试实例，要求输出最少水果数
 * 
 * 样例输入
 * 5,2,3
 * 
 * 20
 * 
 * 样例输出
 * 4
 * 
 */

import java.util.Scanner;
import java.util.TreeSet;

public class TestWanmei_1 {

	public static TreeSet<Integer> treeSet = new TreeSet<>();
	public static boolean flag = false;
	public static int count = 0;

	public static void main(String[] args) {
		
		//有些细节可以改进，思路基本就这样了，是全排列的递归给我的思路，可以去复习一下全排列了......
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();// 奖品数量
		int total = Integer.parseInt(sc.nextLine());
		String[] temp = a.split(",");
		int[] weight = new int[temp.length];
		for (int i = 0; i < temp.length; i++) {
			weight[i] = Integer.parseInt(temp[i]);
		}
		sc.close();

		// int[] weight = { 6,3,2 };
		// int total = 20;
		Method(weight, total);
		if (flag == false)
			System.out.println(-1);
		else
			System.out.println(treeSet.pollFirst());

	}

	private static void Method(int[] weight, int total) {
		// TODO Auto-generated method stub
		if (total == 0) {
			treeSet.add(count);
			flag = true;
			return;
		}
		if (total < 0)
			return;
		for (int i = 0; i < weight.length; i++) {
			count++;
			Method(weight, total - weight[i]);
			count--;
		}
	}

}
