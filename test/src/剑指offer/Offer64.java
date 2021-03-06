package 剑指offer;

import java.util.ArrayList;

/* 64.
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： 
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */

//主流：双端队列保留下标
public class Offer64 {
	public static ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> arrayList = new ArrayList<>();

		if(size==0||size >  num.length)
			return arrayList;
		int max = 0;
		int index = 0;
		for (int i = 0; i < size; i++) {
			if (max <= num[i]) {
				max = num[i];
				index = i;
			}
		}
		arrayList.add(max);
		for (int i = size; i < num.length; i++) {
			if (max < num[i]) {
				max = num[i];
				arrayList.add(max);
				index = i;
			} else if (index == i - size) {
				max = 0;
				for (int j = i - size + 1; j < i + 1; j++) {
					if (max <= num[j]) {
						max = num[j];
						index = j;
					}
				}
				arrayList.add(max);
			} else
				arrayList.add(max);
		}
		return arrayList;
	}

	public static void main(String[] args) {
		int arr[] = {6, 2, 5, 1 };
		int num = 3;
		ArrayList<Integer> arrayList = maxInWindows(arr, num);
		for (int i : arrayList)
			System.out.println(i);
	}
}
