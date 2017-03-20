package newcoder;

import newcoder.Offer38.TreeNode;

public class Offer39 {
	
	public class Solution {

		public boolean flag = true;

		public boolean IsBalanced_Solution(TreeNode root) {
			Jugde(root);
			return flag;
		}

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
