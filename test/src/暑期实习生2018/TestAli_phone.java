package 暑期实习生2018;

import java.util.HashSet;
import java.util.TreeSet;

import tree.binarytree;

/*
 * 一个无序，可能有重复数字的集合(默认为数组，整数)，使用二分查找确定某一个数的位置(排序并删除重复数据后?)
 */

public class TestAli_phone {

	// 不排序怎么查，快排把数字分到两边去？不行
	// 排序
	// 和二分查找没有任何联系啊
	public static int numFind(int[] array, int number) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		for (int a : array)
			treeSet.add(a);
		int count = 1;
		if (treeSet.last() < number)
			return -1;
		for (int b : treeSet) {
			if (b == number)
				break;
			if (b > number) {
				count = -1;
				break;
			}
			count++;
		}
		return count;
	}

	// 先去重再快排？无序数组的去重？
	// 强行二分查找
	public static int numFind2(int[] array, int number) {
		HashSet<Integer> hashSet = new HashSet<>(16);
		for (int a : array)
			hashSet.add(a);
		int[] arr = new int[hashSet.size()];
		int i = 0;
		for (int a : hashSet)
			arr[i++] = a;
		return binarySearch(arr, number);
	}

	private static int binarySearch(int[] array, int num) {
		int low = 0, high = array.length - 1;
		int m, l, h;
		while (low <= high) {
			m = array[low];
			l = low;
			h = high;
			while (l < h) {
				while (l < h && array[h] > m)
					h--;
				array[l] = array[h];
				while (l < h && array[l] < m)
					l++;
				array[h] = array[l];
			}
			array[l] = m;
			if (m == num)
				return l + 1;
			if (m > num)
				high = l - 1;
			else
				low = l + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = {-1,0,1,2,3,4,5,6,7,8,10,13,14,16,18,19,40};
		System.out.println(numFind2(array, 6));
	}
}
