package tree;

/*
 *包括了 
 */

import java.util.Stack;

class Node {
	private int data;
	private Node leftNode;
	private Node rightNode;
	public Node(int data, Node leftNode, Node rightNode){
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	public Node getRightNode() {
		return rightNode;
	}
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
}



public class binarytree {

	public Node init() {
		//注意必须逆序建立，先建立子节点，再逆序往上建立，
		//因为非叶子结点会使用到下面的节点，而初始化是按顺序初始化的，不逆序建立会报错
		Node J = new Node(8, null, null);
		Node H = new Node(4, null, null);
		Node G = new Node(2, null, null);
		Node F = new Node(7, null, J);
		Node E = new Node(5, H, null);
		Node D = new Node(1, null, G);
		Node C = new Node(9, F, null);
		Node B = new Node(3, D, E);
		Node A = new Node(6, B, C);
		return A;   //返回根节点
	}
	
	public void printNode(Node node){
		System.out.print(node.getData());
	}
	
	//先序遍历
	public void theFirstTraversal(Node root) {  
		printNode(root);
		if (root.getLeftNode() != null) {  //使用递归进行遍历左孩子
			theFirstTraversal(root.getLeftNode());
		}
		if (root.getRightNode() != null) {  //递归遍历右孩子
			theFirstTraversal(root.getRightNode());
		}
	}
	
	//中序遍历
	public void theInOrderTraversal(Node root) { 
		if (root.getLeftNode() != null) {
			theInOrderTraversal(root.getLeftNode());
		}
		printNode(root);
		if (root.getRightNode() != null) {
			theInOrderTraversal(root.getRightNode());
		}
	}
	
	//后序遍历
	public void thePostOrderTraversal(Node root) {  
		if (root.getLeftNode() != null) {
			thePostOrderTraversal(root.getLeftNode());
		}
		if(root.getRightNode() != null) {
			thePostOrderTraversal(root.getRightNode());
		}
		printNode(root);
	}
	
	//非递归先序遍历，中左右
	public void theFirstTraversal_Stack(Node root) {  
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		while (node != null || stack.size() > 0) {  //将所有左孩子压栈
			if (node != null) {   //压栈之前先访问
				printNode(node);
				stack.push(node);
				node = node.getLeftNode();
			} else {
				node = stack.pop();
				node = node.getRightNode();
			}
		}
	}
	
	//非递归中序遍历，左中右
	public void theInOrderTraversal_Stack(Node root) {  
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		while (node != null || stack.size() > 0) {
			if (node != null) {
				stack.push(node);   //直接压栈
				node = node.getLeftNode();
			} else {
				node = stack.pop(); //出栈并访问
				printNode(node);
				node = node.getRightNode();
			}
		}
	}
	
	//非递归后序遍历，左右中
	public void thePostOrderTraversal_Stack(Node root) { 
		Stack<Node> stack = new Stack<Node>();
		Stack<Node> output = new Stack<Node>();//构造一个中间栈来存储逆后序遍历的结果
		Node node = root;
		while (node != null || stack.size() > 0) {
			if (node != null) {
				output.push(node);
				stack.push(node);				
				node = node.getRightNode();
			} else {
				node = stack.pop();				
				node = node.getLeftNode();
				
			}
		}
		while (output.size() > 0) {
			printNode(output.pop());
		}
	}
	
	
	public static void main(String[] args) {
		binarytree tree = new binarytree();
		Node root = tree.init();
		System.out.println("先序遍历");
		tree.theFirstTraversal(root);
		System.out.println("");
		System.out.println("中序遍历");
		tree.theInOrderTraversal(root);
		System.out.println("");
		System.out.println("后序遍历");
		tree.thePostOrderTraversal(root);
		System.out.println("");
	}
}
