package 剑指offer;

/* 22.从上往下打印出二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Offer22 {

	// 其他遍历方法前中后更需要好好掌握，递归非递归
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		if (root == null)
			return list;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if (temp.left != null)
				queue.offer(temp.left);
			if (temp.right != null)
				queue.offer(temp.right);
			list.add(temp.val);
		}
		return list;
	}

	// 扩展：广度优先遍历有向图也是同理
}
