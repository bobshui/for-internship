package 剑指offer;

/* 14链表中倒数第k个结点
 * 输入一个链表，输出该链表中倒数第k个结点。
 */

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Offer14 {
	
	//这些边界条件是不是也太怪了点，没有看到合适的别的思路
    public ListNode FindKthToTail(ListNode head,int k) {
    	ListNode p1=head;
    	ListNode p2=head;
    	if(head==null||k<=0)
    		return null;
    	while(--k>0)
    		p1=p1.next;
    	if(p1==null)
    		return null;
    	while(p1.next!=null){
    		p1=p1.next;
    		p2=p2.next;
    	}
    	return p2;
    }
    
    //扩展一：求链表的中间节点(一个一次走两步，一个一次走一步)
    //扩展二：判断一个单向链表是否形成了环形结构(同上，看是否被追上)
}
