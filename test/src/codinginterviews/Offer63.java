package codinginterviews;

import java.util.Comparator;
import java.util.PriorityQueue;

/* 63.数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如
 * 果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */

public class Offer63 {
	private int count = 0;
	private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2 - o1;
		}
	});

	public void Insert(Integer num) {
		if (count % 2 == 0) {
			minHeap.offer(num);
			int temp = minHeap.poll();
			maxHeap.offer(temp);
		} else {
			maxHeap.offer(num);
			int temp = maxHeap.poll();
			minHeap.offer(temp);
		}
		count++;
	}

	public Double GetMedian() {
		if (count % 2 == 0)
			return (double) (maxHeap.peek() + minHeap.peek()) / 2;
		else
			return (double) maxHeap.peek();
	}

}
