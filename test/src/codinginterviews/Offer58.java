package codinginterviews;

/* 58.对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Offer58 {
	boolean isSymmetrical(TreeNode pRoot) {
		if(pRoot==null)
			return true;
		if(pRoot.left==null&&pRoot.right==null)
			return true;
		return isMirror(pRoot.left,pRoot.right);
		//return true;
	}

	private boolean isMirror(TreeNode left, TreeNode right) {
		// TODO Auto-generated method stub 
		if(left==null&&right==null)
			return true;
		if(left!=null&&right!=null)
			return (left.val==right.val)&&isMirror(left.right, right.left)&&isMirror(left.left, right.right);
		return false;
	}
}

//非递归的话，通过改变一些遍历方式来判断是可行的，但是仅仅通过中序遍历看是否对称是不行的