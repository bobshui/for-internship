package 剑指offer;

/* 24二叉树中和为某一值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */

import java.util.ArrayList;

public class Offer24 {

	//和剑指offer中的方法本质是相同的，但是写的简略，和c++好像还有点不同
	public ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

	public ArrayList<Integer> list = new ArrayList<>();

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		if(root==null)
		return arrayLists;
		list.add(root.val);
		target = target - root.val;
		if (target == 0 && root.left == null && root.right == null)
			arrayLists.add(new ArrayList<>(list));

		FindPath(root.left, target);
		FindPath(root.right, target);
		list.remove(list.size()-1);
		return arrayLists;
	}
}
