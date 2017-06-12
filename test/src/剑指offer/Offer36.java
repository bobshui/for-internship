package 剑指offer;

/* 36.两个链表的第一个公共结点
 * 输入两个链表，找出它们的第一个公共结点。
 */

public class Offer36 {

	//这是非常巧的办法，如果两个链表的长度不等，会在第二个循环中找到公共节点
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		ListNode p1 = pHead1;
		ListNode p2 = pHead2;
		while (p1 != p2) {
			if (p1 != null)
				p1 = p1.next;
			if (p2 != null)
				p2 = p2.next;
			if (p1 != p2) {
				if (p1 == null)
					p1 = pHead2;
				if (p2 == null)
					p2 = pHead1;
			}
		}
		return p1;
	}
	//一般的思路，应该是为从尾指针倒着遍历，直到不同，如此可以用栈来实现，但是需要额外的空间
	//如果统计出两个链表的长度，则可以直接找到公共节点
	//有点像找二叉树的共同祖先==
}
