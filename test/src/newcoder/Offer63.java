package newcoder;

import java.util.Comparator;
import java.util.PriorityQueue;

/* 63.数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如
 * 果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */

public class Offer63 {
	public static void main(String[] args) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(15,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		minHeap.offer(2);
		minHeap.offer(4);
		minHeap.offer(3);
		while(!minHeap.isEmpty())
		System.out.println(minHeap.poll());
	}
}
