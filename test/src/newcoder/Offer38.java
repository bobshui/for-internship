package newcoder;

import java.util.LinkedList;
import java.util.Queue;

public class Offer38 {

	class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	public static int TreeDepth(TreeNode root) {
		if (root == null)
			return 0;
		else {
			TreeNode left = root.left;
			TreeNode right = root.right;
			return Math.max(TreeDepth(left) + 1, TreeDepth(right) + 1);
		}
	}

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
