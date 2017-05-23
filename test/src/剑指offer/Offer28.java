package 剑指offer;

/* 28.数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
import java.util.HashMap;
import java.util.Map;

public class Offer28 {

	//hash的复杂度是O(n)，但是空间使用的比较多，没有充分利用数组特点
	public static int MoreThanHalfNum_Solution(int [] array){
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<array.length;i++){
			if(map.containsKey(array[i])){
				map.put(array[i],map.get(array[i])+1);
			}
			else
				map.put(array[i], 1);
		}
		for(Integer i : map.keySet()){
			if(map.get(i)>array.length/2)
				return (int)i;
		}
		return 0;
	}
	
	/* 剑指offer中，提到了打擂算法
	 * 如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。 
	 * 在遍历数组时保存两个值：一是数组中一个数字，一是次数。遍历下一个数字时，若它与之前保存的数字相同，则次数加1，否则次数减1；
	 * 若次数为0，则保存下一个数字，并将次数置为1。遍历结束后，所保存的数字即为所求。然后再判断它是否符合条件即可。
	 * 
	 * 还有一种基于快排中partition函数的排序方法，但是复杂稍高一些，可能不止1*n的复杂度
	*/
}
