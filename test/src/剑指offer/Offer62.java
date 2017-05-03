package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/* 62.二叉搜索树的第k个结点
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */

//这样是不是略low？

public class Offer62 {
	
	List<TreeNode> list =new ArrayList<>();
	
	TreeNode KthNode(TreeNode pRoot, int k) {
		if(pRoot==null)
			return null;
		if (pRoot.left!= null) {
			KthNode(pRoot.left,k);
		}
		list.add(pRoot);
		if (pRoot.right != null) {
			KthNode(pRoot.right,k);
		}
		if(k==0||k>list.size())
			return null;
		return list.get(k-1);
	}
}
