package 剑指offer;

/* 38.二叉树的深度
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */

import java.util.LinkedList;
import java.util.Queue;

public class Offer38 {

	//递归
	public static int TreeDepth(TreeNode root) {
		if (root == null)
			return 0;
		else {
			TreeNode left = root.left;
			TreeNode right = root.right;
			return Math.max(TreeDepth(left) + 1, TreeDepth(right) + 1);
		}
	}

	//非递归
	public static int TreeDepth2(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode node;
		int depth = 0, count = 0, nextcount = 1;
		queue.add(root);
		while (queue.size() != 0) {
			node = queue.poll();
			count++;
			if (node.left != null)
				queue.add(root.left);
			if (node.right != null)
				queue.add(root.right);
			if (count == nextcount) {
				nextcount = queue.size();
				count = 0;
				depth++;
			}
		}
		return depth;
	}

	public static void main(String[] args) {

	}

}
