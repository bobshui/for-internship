﻿package other;

/*
 * 字典生成算法，理解可参考http://blog.csdn.net/joylnwang/article/details/7064115
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.omg.Messaging.SyncScopeHelper;

public class Dictionary_generation_algorithm {

	public static ArrayList<String> Permutation(String str) {
		ArrayList<String> res = new ArrayList<>();
		if (str != null && str.length() > 0) {
			char[] seq = str.toCharArray();
			Arrays.sort(seq); // 排列
			System.out.println(seq);
			res.add(String.valueOf(seq)); // 先输出一个解
			int len = seq.length;
			while (true) {
				int p = len - 1, q;// 从后向前找一个seq[p - 1] < seq[p]
				while (p >= 1 && seq[p - 1] >= seq[p])
					--p;
				if (p == 0)
					break; // 已经是“最小”的排列，退出
				// 从p向后找最后一个比seq[p]大的数
				q = p;
				--p;
				while (q < len && seq[q] > seq[p])
					q++;
				--q;// 交换这两个位置上的值
				swap(seq, q, p);// 将p之后的序列倒序排列
				reverse(seq, p + 1);
				System.out.println(seq);
				res.add(String.valueOf(seq));
			}
		}
		return res;
	}

	public static void reverse(char[] seq, int start) {
		int len;
		if (seq == null || (len = seq.length) <= start)
			return;
		for (int i = 0; i < ((len - start) >> 1); i++) {
			int p = start + i, q = len - 1 - i;
			if (p != q)
				swap(seq, p, q);
		}
	}

	public static void swap(char[] cs, int i, int j) {
		char temp = cs[i];
		cs[i] = cs[j];
		cs[j] = temp;
	}

	public static void main(String[] args) {
		String str = "abc";
		ArrayList<String> ss=Permutation(str);
		// list=aa.Permutation();
	}
}
