package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//数学
/*
 * 小易有一个长度为n序列，小易想移除掉里面的重复元素，但是小易想是对于每种元素保留最后出现的那个。小易遇到了困难,希望你来帮助他。
 * 
 * 输入描述:
 * 输入包括两行：
 * 第一行为序列长度n(1 ≤ n ≤ 50)
 * 第二行为n个数sequence[i](1 ≤ sequence[i] ≤ 1000)，以空格分隔
 * 
 * 输出描述:
 * 输出消除重复元素之后的序列，以空格分隔，行末无空格
 * 
 * 输入例子:
 * 9
 * 100 100 100 99 99 99 100 100 100
 * 
 * 输出例子:
 * 99 100
 */

public class TestNetEase_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] sequence = new int[n];
		int i = 0;
		for (i = 0; i < n; i++) {
			sequence[i] = sc.nextInt();
		}
		sc.close();

		//暂时没看到厉害的解法，hashset/hashmap的效率和实现这个顺序是否要更优秀呢？
		StringBuilder stringBuilder = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		for (i = sequence.length - 1; i >= 0; i--) {
			if (!list.contains(sequence[i]))
				list.add(sequence[i]);
		}

		for (i = list.size() - 1; i >= 0; i--)
			stringBuilder.append(list.get(i).toString() + " ");
		System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));
	}

}
