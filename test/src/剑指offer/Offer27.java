package 剑指offer;

/* 27.字符串的排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 
 */

//ps,书中的题目并没有要求按照字典序
//思路是，把第一个字符和后面所有的字符交换，然后固定第一个字符，在递归后面的字符

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Offer27 {

	// 字典生成算法，理解可参考http://blog.csdn.net/joylnwang/article/details/7064115
	public static ArrayList<String> Permutation(String str) {
		ArrayList<String> result = new ArrayList<>();

		if (str != null && str.length() > 0) {
			char[] ca = str.toCharArray();
			Arrays.sort(ca);
			result.add(String.valueOf(ca));

			int len = ca.length;
			while (true) {
				int p = len - 1;
				int q;
				while (p >= 1 && ca[p - 1] >= ca[p])
					--p;
				if (p == 0)
					break;
				q = p;
				--p;
				while (q < len && ca[q] > ca[p])
					q++;
				--q;
				swap(ca, q, p);
				reverse(ca, p + 1);
				result.add(String.valueOf(ca));
			}
		}
		return result;
	}

	public static void reverse(char[] cs, int start) {
		int len = cs.length;
		for (int i = 0; i < (len - start) / 2; i++) {
			int p = start + i;
			int q = len - 1 - i;
			if (p != q)
				swap(cs, p, q);
		}
	}

	public static void swap(char[] cs, int i, int j) {
		char temp;
		temp = cs[i];
		cs[i] = cs[j];
		cs[j] = temp;
	}

	//dfs遍历类似递归，可能的重复用set来解决即可
	public static ArrayList<String> Permutation2(String str) {
		ArrayList<String> result = new ArrayList<>();
		if (str != null && str.length() > 0) {
			PermutationHelper(str.toCharArray(), 0, result);
			Collections.sort(result);//这里排序的复杂度会不会比较高？
		}
		return result;
	}

	private static void PermutationHelper(char[] cs, int i, ArrayList<String> result) {
		// TODO Auto-generated method stub
		if (i == cs.length - 1) { // 解空间的一个叶节点
			result.add(String.valueOf(cs)); // 找到一个解
		} else {
			for (int j = i; j < cs.length; ++j) {
				if (j == i || cs[j] != cs[i]) {
					swap(cs, i, j);
					PermutationHelper(cs, i + 1, result);
					swap(cs, i, j); // 复位
				}
			}
		}
	}

	public static void main(String[] args) {
		String str = "1234";
		ArrayList<String> arr = Permutation(str);
		for (String i : arr)
			System.out.println(i);

	}
	//扩展一：获得字符串的所有组合
	public static void combiantion(char chs[]){  
	    if(chs.length == 0) return ;  
	      
	    Stack<Character> stack = new Stack<Character>();  
	    for(int i = 1; i <= chs.length; i++){  
	        combine(chs, 0, i, stack);  
	    }  
	}  
	//从字符数组中第begin个字符开始挑选number个字符加入list中  
	public static void combine(char []chs, int begin, int number, Stack<Character> stack){  
	       if(number == 0){  
	        System.out.println(stack.toString());  
	        return ;  
	       }  
	       if(begin == chs.length){  
	        return;  
	       }  
	       stack.push(chs[begin]);  
	       combine(chs, begin + 1, number - 1, stack);  
	       stack.pop();  
	       combine(chs, begin + 1, number, stack);  
	}  
	//扩展二：8皇后问题
	//剑指offer的全排列思想非常的不错，定义一个数组arr[8]，第i个数字就表示位于第i行的皇后所在的列。
	//分别用0-7初始化，然后全排列，这样子显然不会同列或者同一行，只需判断对角线即可
	//看没看过知乎上的八皇后一行？
}
