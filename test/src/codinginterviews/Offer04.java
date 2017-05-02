package codinginterviews;

/* 04重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。。
 */

public class Offer04 {
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length!=in.length)
        	return null;
        return reConstructBinaryTreeTest(pre, 0,pre.length-1,in,0,in.length-1);
    }

	//没记错应该就是抄的书中的思路了
	public TreeNode reConstructBinaryTreeTest(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
		// TODO Auto-generated method stub
		if(preStart>preEnd||inStart>inEnd)
			return null;
		TreeNode root = new TreeNode(pre[preStart]);
		for(int i=preStart;i<preEnd;i++){
			if(in[i]==pre[preStart]){
				root.left=reConstructBinaryTreeTest(pre, preStart+1, preStart+i-inStart, in, inStart, i-1);
				root.right=reConstructBinaryTreeTest(pre, preStart+i-inStart+1, preEnd, in, i+1, inEnd);
			}
		}
		return root;
	}


}
