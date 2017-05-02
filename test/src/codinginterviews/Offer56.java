package codinginterviews;

/* 56.删除链表中重复的节点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */

public class Offer56 {
	public ListNode deleteDuplication(ListNode pHead) {
		ListNode head = new ListNode(0);
		head.next = pHead;
		ListNode temp = pHead;
		ListNode tempo = head;

		while (temp != null && temp.next != null) {
			if (temp.next.val == temp.val) {
				int val = temp.val;
				while (temp != null && temp.val == val)
					temp = temp.next;
				tempo.next = temp;
			} else {
				tempo = temp;
				temp = temp.next;
			}
		}
		return head.next;
	}
}
