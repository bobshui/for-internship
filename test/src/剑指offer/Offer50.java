package 剑指offer;

/* 50 数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */

public class Offer50 {
	// Parameters:
	// numbers: an array of integers
	// length: the length of array numbers
	// duplication: (Output) the duplicated number in the array number,length of
	// duplication array is 1,so using duplication[0] = ? in implementation;
	// Here duplication like pointor in C/C++, duplication[0] equal *duplication
	// in C/C++
	// 这里要特别注意~返回任意重复的一个，赋值duplication[0]
	// Return value: true if the input is valid, and there are some duplications
	// in the array number
	// otherwise false
	 
	//老通不过，很奇怪，在[]输入下回返回空指针异常。
	public boolean duplicate(int numbers[], int length, int[] duplication) {
		duplication[0] = -1;
		boolean flag = false;
		if (numbers.length == 0 || numbers == null)
			return flag;
		int[] array = new int[length];
		for (int i = 0; i < array.length; i++) {
			if (array[numbers[i]] == 1) {
				flag = true;
				duplication[0] = numbers[i];
				break;
			}
			array[numbers[i]]++;
		}
		return flag;
	}

	// 充分利用特点可以不需要额外的空间,不用太纠结数字大小越界
	public boolean duplicate2(int numbers[], int length, int[] duplication) {
		for (int i = 0; i < numbers.length; i++) {
			int index = numbers[i];
			if (index >= length)
				index -= length;
			if (numbers[index] >= length) {
				duplication[0] = index;
				return true;
			}
			numbers[index] += length;
		}
		return false;
	}

//	public boolean duplicate3(int numbers[], int length, int[] duplication) {
//		StringBuffer sb = new StringBuffer();
//		for (int i = 0; i < length; i++) {
//			sb.append(numbers[i] + "");
//		}
//		for (int j = 0; j < length; j++) {
//			if (sb.indexOf(numbers[j] + "") != sb.lastIndexOf(numbers[j] + "")) {
//				duplication[0] = numbers[j];
//				return true;
//			}
//		}
//		return false;
//
//	}
}
