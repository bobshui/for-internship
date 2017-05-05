package 剑指offer;

import java.util.Stack;

/* 20包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */

public class Offer20 {

	Stack<Integer> data = new Stack<Integer>();
	Stack<Integer> min = new Stack<Integer>();
	Integer temp = null;

	public void push(int node) {
		if (temp != null) {
			if (node <= temp) {
				temp = node;
				min.push(node);
			}
			data.push(node);
		} else {
			temp = node;
			data.push(node);
			min.push(node);
		}
	}

	public void pop() {
		if(data.peek()!=min.peek())
			data.pop();
		else{
			data.pop();
			min.pop();
		}
	}

	public int top() {
		int num = data.peek();
		return num;
	}

	public int min() {
		int num = min.peek();
		return num;
	}
}
