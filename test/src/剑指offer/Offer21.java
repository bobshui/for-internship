package 剑指offer;

import java.util.ArrayList;
import java.util.Stack;

/* 21栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */

public class Offer21 {

	// 抄袭的答案，似乎要比书中的代码简洁不少
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		Stack<Integer> stack = new Stack<>();
		int index = 0;
		for (int i = 0; i < pushA.length; i++) {
			stack.push(pushA[i]);
			while (!stack.isEmpty() && stack.peek() == popA[index]) {
				stack.pop();
				index++;
			}
		}
		return stack.isEmpty();
	}

	// 话是这么说，但是原题中给的是import arraylist,这个思路也还是不错的
	public boolean IsPopOrder2(int[] pushA, int[] popA) {
		if (pushA.length == 0 || popA.length == 0)
			return false;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int j = 0;
		for (int i = 0; i < pushA.length; i++) {
			if (pushA[i] != popA[j])
				list.add(pushA[i]);
			else
				j++;
		}
		for (int i = list.size() - 1; i >= 0; i--) {
			if (list.get(i) != popA[j])
				return false;
			j++;
		}
		return true;
	}
}
