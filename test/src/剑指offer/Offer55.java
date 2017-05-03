package 剑指offer;

import java.util.HashSet;

/* 55.链表中环的入口节点
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */

/*
public class ListNode {
   int val;
   ListNode next = null;

   ListNode(int val) {
       this.val = val;
   }
}
*/

public class Offer55 {
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		HashSet<ListNode> set = new HashSet<>();
		ListNode temp = pHead;
		while (temp.next != null) {
			if (!set.contains(temp))
				set.add(temp);
			else {
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}
}

// 链接：https://www.nowcoder.com/questionTerminal/253d2c59ec3e4bc68da16833f79a38e4
// 来源：牛客网

/* 看看这种思路
 * 第一步，找环中相汇点。
 * 分别用p1，p2指向链表头部，p1每次走一步，p2每次走二步，直到p1==p2找到在环中的相汇点。
 * 第二步，找环的入口。接上步，当p1==p2时，p2所经过节点数为2x,p1所经过节点数为x,设环中有n个节点,p2比p1多走一圈有2x=n+x;
 * n=x;可以看出p1实际走了一个环的步数，再让p2指向链表头部，p1位置不变，p1,p2每次走一步直到p1==p2;
 * 此时p1指向环的入口。
 * ps：并不一定是多走了一圈
 * 
  public class Solution {
  ListNode EntryNodeOfLoop(ListNode pHead){
  	if(pHead == null || pHead.next == null)
  		return null;
  	ListNode p1 = pHead;
  	ListNode p2 = pHead;
  	while(p2 != null && p2.next != null ){
  		p1 = p1.next;
  		p2 = p2.next.next;
  		if(p1 == p2){
  			p2 = pHead;
  			while(p1 != p2){
  				p1 = p1.next;
  				p2 = p2.next;
  			}
  			if(p1 == p2)
  				return p1;
  		}
  }
  	return null;
  }}
*/

//还有一种毁坏链表大法
//时间复杂度为O（n），两个指针，一个在前面，另一个紧邻着这个指针，在后面。两个指针同时向前移动，每移动一次，前面的指针的next指向NULL。
//也就是说：访问过的节点都断开，最后到达的那个节点一定是尾节点的下一个，也就是循环的第一个。
//这时候已经是第二次访问循环的第一节点了，第一次访问的时候我们已经让它指向了NULL，所以到这结束。