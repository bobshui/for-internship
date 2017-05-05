package 剑指offer;

/* 16合并两个排序的链表
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Offer16 {

	public ListNode Merge(ListNode list1, ListNode list2) {
		ListNode head = new ListNode(0);
		ListNode head2 = head;
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				head.next = list1;
				head = list1;
				list1 = list1.next;
			} else {
				head.next = list2;
				head = list2;
				list2 = list2.next;
			}
		}
		
		if(list1!=null)
			head.next=list1;
		else
			head.next=list2;
		// 复杂了改进下
		// while(list1!=null){
		// head.next=list1;
		// head=list1;
		// list1=list1.next;
		// }
		// while(list2!=null){
		// head.next=list2;
		// head=list2;
		// list2=list2.next;
		// }
		return head2.next;
	}
	
	//递归要稍微慢一些，总觉得有点不对
	public ListNode Merge2(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		if(list1.val<=list2.val){
			list1.next=Merge2(list1.next, list2);
			return list1;
		}
		if(list1.val>list2.val){
			list2.next=Merge2(list1, list2.next);
			return list2;
		}
		return null;
	}
}
