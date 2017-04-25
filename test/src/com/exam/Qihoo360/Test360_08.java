package com.exam.Qihoo360;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * 题目描述
 * 一个字符串S是偶串当且仅当S中的每一个字符都出现了偶数次。如字符串”aabccb”是一个偶串，因为字符a,b,c都出现了两次。
 * 而字符串”abbcc”不是偶串，因为字符a出现了一次。
 * 现在给出一个长度为n的字符串T=t1,t2,t3,…,tn。字符串的子串为其中任意连续一段。T长度为1的子串有n个，长度为2的子串有n-1个，以此类推，
 * T一共有n(n+1)/2个子串。给定T，你能算出它有多少个子串是偶串吗？
 * 输入
 * 输入一个字符串T，T中只有小写字母。T的长度不超过100000。
 * 
 * 样例输入
 * abbc
 * 
 * 输出
 * 输出一个数，T的所有子串中偶串的个数。
 * 
 * 样例输出
 * 1
 */
public class Test360_08 {
	public static void main(String[] args) {
		// 这个用了map，复杂度应为O(n*n),但是并不能通过
		Scanner in = new Scanner(System.in);
		String n = in.nextLine();
		char[] cs = n.toCharArray();

		int count = 0;
		int i = 2;
		Map<Character, Integer> map = new HashMap<>();
		while (i <= cs.length) {
			for (int j = 0; j < cs.length - i + 1; j++) {
				int temp = i;
				int k = j;
				while (temp-- > 0) {
					if (map.containsKey(cs[k]))
						map.put(cs[k], map.get(cs[k]) + 1);
					else
						map.put(cs[k], 1);
					k++;
				}
				int flag = 1;
				for (Entry<Character, Integer> entry : map.entrySet()) {
					if (entry.getValue() % 2 != 0) {
						flag = 0;
						break;
					}
				}
				map.clear();
				count += flag;
			}
			i = i + 2;
		}
		System.out.println(count);
		in.close();

		/*
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String T = sc.next();
			int count = 0;// 记录总的偶串数目
			int gi = 0; // gi是用低26bit（int是32bit）表示下标为[0,i]的子串所拥分别有的字母是偶数个（0）还是奇数个（1）。
			Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // 保存每个gi出现次数
			map.put(0, 1);// gi为0，表示所有的字母都出现偶数次，是1个偶串，所以赋初值1
			for (int i = 0; i < T.length(); i++) {
				int x = T.charAt(i) - 'a'; // 求得新加入的这个字符的bit位置
				gi ^= (1 << x); // 求加入这个字符后，原来的gi拥有字母个数的奇偶性。如果异或后是0，表示加入该字符后有偶数个字母，反之是奇数个。
				if (map.containsKey(gi)) {
					count += map.get(gi);// g0,g1,g2...g(i-1)和gi相等的，都可以得到一个偶串。有多个少个相等，就有多少个偶串。
					map.put(gi, map.get(gi) + 1); // 增加1
				} else {
					map.put(gi, 1);
				}

			}
			System.out.println(count);
		}
		*/

	}

}
