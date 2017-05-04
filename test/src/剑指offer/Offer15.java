package 剑指offer;

/* 15反转链表
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Offer15 {

	//基本思路，需要好好掌握
	public ListNode ReverseList(ListNode head) {
		ListNode pre=null,temp;
		if(head==null)
			return null;
		if(head.next==null)
			return head;
		while(head.next!=null){
			temp=head.next;
			head.next=pre;
			pre=head;
			head=temp;
		}
		head.next=pre;
		return head;
	}

	//也有使用栈来做的，没仔细看，目测一般
	
	//剑指offer上并没有提到的递归方法，抄
	//巧的有点过分啊
	public ListNode ReverseList2(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode reverseNode = ReverseList2(head.next);
		head.next.next=head;
		head.next=null;
		return reverseNode;
	}
}
