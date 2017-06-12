package 剑指offer;

/* 39.平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */

import 剑指offer.TreeNode;

public class Offer39 {
	
	public class Solution {

		public boolean flag = true;

		public boolean IsBalanced_Solution(TreeNode root) {
			Jugde(root);
			return flag;
		}

		//其实是后续遍历，一边遍历一边求子树的高度，所以总节点只需要遍历一次即可
		public int Jugde(TreeNode root) {
			if (root == null)
				return 0;
			int left = Jugde(root.left);
			int right = Jugde(root.right);
			if (Math.abs(left - right) > 1) {
				flag = false;
				return 0;
			}
			return right>left ?right+1:left+1;
		}
	}
}
