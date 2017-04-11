package newcoder;

/* 66.机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 *  例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */

public class Offer66 {
	public int movingCount(int threshold, int rows, int cols) {
		if (rows < 1 || cols < 1)
			return 0;
		boolean[] visited = new boolean[rows * cols];
		int count = countCore(threshold, rows, cols, 0, 0, visited);
		return count;
	}

	private int countCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
		// TODO Auto-generated method stub
		int count = 0;
		if (check(threshold, rows, cols, row, col, visited)) {
			visited[row * cols + col] = true;
			count = 1 + countCore(threshold, rows, cols, row - 1, col, visited)
					+ countCore(threshold, rows, cols, row, col - 1, visited)
					+ countCore(threshold, rows, cols, row + 1, col, visited)
					+ countCore(threshold, rows, cols, row, col + 1, visited);
		}
		return count;
	}

	private boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
		// TODO Auto-generated method stub
		if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col]
				&& getSum(row) + getSum(col) <= threshold)
			return true;
		return false;
	}

	private int getSum(int num) {
		// TODO Auto-generated method stub
		int sum = 0;
		while (num > 0) {
			sum = sum + num % 10;
			num /= 10;
		}
		return sum;
	}
}
