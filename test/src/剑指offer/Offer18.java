package 剑指offer;

import java.util.Stack;

/* 18二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。 
        输入描述:
        二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 */

public class Offer18 {
	public void Mirror(TreeNode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			return;
		TreeNode temp = new TreeNode(0);
		temp = root.left;
		root.left = root.right;
		root.right = temp;

		if (root.left != null)
			Mirror(root.left);
		if (root.right != null)
			Mirror(root.right);
	}
	
	//扩展，如何使用非递归来做，可以借助stack,但就性能来说似乎并不优秀
	public void Mirror2(TreeNode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node=stack.pop();
			if(node.left!=null||node.right!=null){
				TreeNode temp = node.left;
				node .left=node.right;
				node.right=temp;
			}
			if(node.left!=null)
				stack.push(node.left);
			if(node.right!=null)
				stack.push(node.right);
		}
	}
}
