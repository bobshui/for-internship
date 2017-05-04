package 剑指offer;

import java.util.Stack;

/* 05用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

//另外，如何用两个队列实现栈
public class Offer05 {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	//思路是有的，可以考虑一些异常情况
	public void push(int node) {
		stack2.push(node);
	}

	public int pop() {
		if(!stack1.isEmpty())
			return stack1.pop();
		else if(!stack2.isEmpty()){
			while(!stack2.isEmpty())
				stack1.push(stack2.pop());
		}
		return stack1.pop();
	}
}
