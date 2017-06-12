package 剑指offer;

/* 25复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */

class RandomListNode {
	int label;
	RandomListNode next = null;
	RandomListNode random = null;

	RandomListNode(int label) {
		this.label = label;
	}
}

public class Offer25 {
	
	//递归法是有点开玩笑了，但是书中提到的hash表的方法，感觉并没有那么容易
	public RandomListNode Clone(RandomListNode pHead) {
		if(pHead==null)
			return null;
		cloneNodes(pHead);
		connectRandom(pHead);
		return seperate(pHead);
	}

	// 复制原始链表，把每个新节点放在原节点之后
	public void cloneNodes(RandomListNode pHead) {
		RandomListNode p = pHead;
		while (p != null) {
			RandomListNode pClone = new RandomListNode(p.label);
			pClone.next = p.next;
			p.next = pClone;
			p = pClone.next;
		}
	}

	// 处理特殊指针
	public void connectRandom(RandomListNode pHead) {
		RandomListNode p = pHead;
		while (p != null) {
			RandomListNode pClone = p.next;
			if (p.random != null)
				pClone.random = p.random.next;
			p = pClone.next;
		}
	}

	// 分离两个链表
	public RandomListNode seperate(RandomListNode pHead) {
		RandomListNode p = pHead;
		RandomListNode pClonehead = pHead.next;
		RandomListNode pClone = pClonehead;
		while (p != null) {
			p.next = p.next.next;
			if (pClone.next != null)
				pClone.next = p.next.next;
			p = p.next;
			pClone = pClone.next;
		}
		return pClonehead;
	}
}
