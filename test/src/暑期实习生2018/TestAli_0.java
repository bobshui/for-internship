package 暑期实习生2018;

/*
 * 题目掉了
 */

import java.util.HashSet;
import java.util.Scanner;

public class TestAli_0 {

	/** 请完成下面这个函数，实现题目要求的功能 **/
	/** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^ **/
	static long caculateSubs(int n, int[][] array) {
		HashSet<Integer> set = new HashSet<>();
		int sum = 0;
		int count=0;
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = count; j < n; j++) {
					if ((array[j][i]) == 1) {
						set.add(array[i][j]);
						break;
					}
				}
				count++;
			}
			count=0;
		}
		return 0;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long res;

		int _n;
		_n = Integer.parseInt(in.nextLine().trim());

		int _array_rows = 0;
		int _array_cols = 0;
		_array_rows = _n;
		_array_cols = _n;

		int[][] _array = new int[_array_rows][_array_cols];
		for (int _array_i = 0; _array_i < _array_rows; _array_i++) {
			for (int _array_j = 0; _array_j < _array_cols; _array_j++) {
				_array[_array_i][_array_j] = in.nextInt();

			}
		}

		if (in.hasNextLine()) {
			in.nextLine();
		}

		res = caculateSubs(_n, _array);
		System.out.println(String.valueOf(res));

	}
}
