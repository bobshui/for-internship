package 剑指offer;

import java.util.ArrayList;

/* 03从尾到头打印链表
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * */

public class Offer03 {
	//练一练链表的逆序,但是这个有一定问题，会打乱原有的链表结构
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> arrayList=new ArrayList<>();
        if(listNode==null)
            return arrayList;
		ListNode pre=null;
		ListNode tmp;
		while(listNode.next!=null){
			tmp=listNode.next;
			listNode.next=pre;
			pre=listNode;
			listNode=tmp;
		}
		listNode.next=pre;
		while(listNode!=null){
			arrayList.add(listNode.val);
			listNode=listNode.next;
		}
		return arrayList;
	}
	
	//方法一：借助stack，直接实现，就是所谓的先输出，再逆序
	//方法二：递归，本质也是堆栈，但是看起来很美丽
	/*
	 * 链接：https://www.nowcoder.com/questionTerminal/d0267f7f55b3412ba93bd35cfa8e8035
	       来源：牛客网
	public class Solution {
    	ArrayList<Integer> arrayList=new ArrayList<Integer>();
   		public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        	if(listNode!=null){
         	   this.printListFromTailToHead(listNode.next);
           	 arrayList.add(listNode.val);
        	}
        return arrayList;
    	}
	}  
	 */

	public static void main(String[] args) {
		ListNode a=new ListNode(5);
		ListNode b=new ListNode(4);
		ListNode c=new ListNode(3);
		a.next=b;
		b.next=c;
		ArrayList<Integer> arr=new Offer03().printListFromTailToHead(a);
		for(int aa:arr)
			System.out.println(aa);
		
	}
}
