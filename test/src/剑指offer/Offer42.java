package 剑指offer;

/* 42 和为S的两个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * (原题目为输出任意一对即可)
 * 
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
import java.util.ArrayList;

public class Offer42 {
	
	//这个是我自己写的查找法（和这个题目有任何关系吗？？）
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		int j;
		for (int i = 0; i < array.length; i++) {
			j = sum - array[i];
			if (Contains(array, j)) {
				arrayList.add(array[i]);
				arrayList.add(j);
				break;
			}
		}
		return arrayList;
	}

	public static boolean Contains(int[] array, int j) {
		boolean flag = false;
		int low = 0, high = array.length - 1;
		int mid;
		while (low < high) {
			mid = (low + high) / 2;
			if (array[mid] < j)
				low = mid + 1;
			else if (array[mid] > j)
				high = mid - 1;
			else {
				flag = true;
				break;
			}
		}
		return flag;
	}

	//类似于书里面的解法
	public ArrayList<Integer> FindNumbersWithSum2(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (array == null || array.length < 2) {
			return list;
		}
		int i = 0, j = array.length - 1;
		while (i < j) {
			if (array[i] + array[j] == sum) {
				list.add(array[i]);
				list.add(array[j]);
				return list;
			} else if (array[i] + array[j] > sum) {
				j--;
			} else {
				i++;
			}
		}
		return list;
	}
}
