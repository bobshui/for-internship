package 剑指offer;

import java.util.Stack;

/* 26二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */

//理解题意，把节点的left,right分别指向前后节点，并不是要新建一个链表结构，从小到大，可以从中序遍历来考虑
public class Offer26 {
	// https://www.nowcoder.com/questionTerminal/947f6eb80d944a84850b0538bf0ec3a5

	// 非递归的中序遍历
	public TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null)
			return null;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = pRootOfTree;
		TreeNode pre = null;
		boolean isFirst = true;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			p = stack.pop();
			if (isFirst) {
				pRootOfTree = p;
				pre = pRootOfTree;
				isFirst = false;
			} else {
				pre.right = p;
				p.left = pre;
				pre = p;
			}
			p = p.right;
		}
		return pRootOfTree;
	}

	public TreeNode Convert2(TreeNode pRootOfTree) {
		if (pRootOfTree == null)
			return null;
		if (pRootOfTree.left == null && pRootOfTree.right == null)
			return pRootOfTree;
		// 1.将左子树构造成双链表，并返回链表头节点
		TreeNode left = Convert(pRootOfTree.left);
		TreeNode p = left;
		// 2.定位至左子树双链表最后一个节点
		while (p != null && p.right != null) {
			p = p.right;
		}
		// 3.如果左子树链表不为空的话，将当前root追加到左子树链表
		if (left != null) {
			p.right = pRootOfTree;
			pRootOfTree.left = p;
		}
		// 4.将右子树构造成双链表，并返回链表头节点
		TreeNode right = Convert(pRootOfTree.right);
		// 5.如果右子树链表不为空的话，将该链表追加到root节点之后
		if (right != null) {
			right.left = pRootOfTree;
			pRootOfTree.right = right;
		}
		return left != null ? left : pRootOfTree;
	}
}
