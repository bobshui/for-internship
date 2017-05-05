package 剑指offer;

import java.util.ArrayList;

/* 19顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

public class Offer19 {

	// 首先判断有几圈数字，然后进行循环处理，每次循环是四行,剑指offer上也是这个思路
	// 没有数据结构，但是要现场实现，其实有点困难
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		int row = matrix.length;
		int col = matrix[0].length;
		if (row == 0 || col == 0)
			return arrayList;

		int layer = Math.min(row, col) / 2 + 1;
		for (int i = 0; i < layer; i++) {
			for (int k = i; k < col - i; k++)
				arrayList.add(matrix[i][k]);
			for (int j = i + 1; j < row - i; j++)
				arrayList.add(matrix[j][col - i - 1]);
			for (int k = col - i - 2; (k >= i) && (row - i - 1 != i); k--)
				arrayList.add(matrix[row - i - 1][k]);
			for (int j = row - i - 2; (j > i) && (col - i - 1 != i); j--)
				arrayList.add(matrix[j][i]);
		}
		return arrayList;
	}
}
