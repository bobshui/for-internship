package 剑指offer;

import java.util.ArrayList;

public class Offer42 {
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
