package 暑期实习生2018;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 按层打印二叉树    
时间限制：C/C++语言 2000MS；其他语言 4000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
给定一棵二叉树的前序（根、左、右）和中序（左、根、右）的打印结果，输出此二叉树按层（从左往右）打印结果。
例如一棵二叉树前序：1 2 4 5 3；中序：4 2 5 1 3。可以构建出下图所示二叉树：


按层打印的结果则为：1 2 3 4 5。

输入
第一行只有一个数字，表示二叉树的节点数n（1<=n<=1000）;
第二行由a1,a2,...,an(1<=ai<=1000)组成的整数序列（用空格分隔）—表示前序打印结果；
第三行由b1,b2,...,bn(1<=bi<=1000)组成的整数序列（用空格分隔）—表示中序打印结果。

输出
c1,c2,...,cn，用空格分隔—表示按层打印的结果。


样例输入
5
1 2 4 5 3
4 2 5 1 3

样例输出
1 2 3 4 5

 * 
 */
public class TestQunar_1 {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] pre=new int[n];
		int[] in=new int[n];
		for(int i=0;i<n;i++){
			pre[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++){
			in[i]=sc.nextInt();
		}
		sc.close();
		
		TreeNode root=reConstructBinaryTree(pre, in);
		
		int[] out=new int[n];
		if (root == null)
			System.out.print("");

		int i=0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if (temp.left != null)
				queue.offer(temp.left);
			if (temp.right != null)
				queue.offer(temp.right);
			out[i++]=temp.val;
		}

		for(int j=0;j<n-1;j++)
			System.out.print(out[j]+" ");
		System.out.print(out[n-1]);
	}
	
	
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length!=in.length)
        	return null;
        return reConstructBinaryTreeTest(pre, 0,pre.length-1,in,0,in.length-1);
    }

	
	public static TreeNode reConstructBinaryTreeTest(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
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


// Definition for binary tree
  class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }


