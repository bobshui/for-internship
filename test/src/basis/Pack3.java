package basis;

/*
 * (3)多重背包
 * 有n种物品，每种物品有amount[i]个，每个物品的重量为weight[i]，每个物品的价值为value[i]。
 * 现在有一个背包，它所能容纳的重量为total，问：当你面对这么多有价值的物品时，你的背包所能带走的最大价值是多少？
 */

public class Pack3 {
	public static void main(String[] args) {
		int n = 5; // 物品
		int[] weight = { 5, 4, 7, 2, 6 }; // 重量
		int[] value = { 12, 3, 10, 3, 6 }; // 价值
		int[] amount = { 1, 3, 10, 3, 6 }; // 价值
		int total = 15; // 背包容量

		int[][] tab = new int[n][total + 1];
		for (int i = weight[0]; i <= total; i++) {
			for (int k = 1; k <= amount[0]; k++) {
				if (i >= k * weight[0])
					tab[n - 1][i] = value[0] * k;
				else
					tab[n - 1][i] = tab[n - 1][i - 1];
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= total; j++) {
				for (int k = 1; k <= amount[i]; k++) {
					if (j >= k * weight[i])
						tab[n - 1 - i][j] = Math.max(tab[n - i][j - k * weight[i]] + k * value[i],
								Math.max(tab[n - i][j], tab[n - 1 - i][j])); // 核心
					else
						tab[n - 1 - i][j] = Math.max(tab[n - i][j], tab[n - 1 - i][j]);
				}
			}

		}
		System.out.println(tab[0][total]);
	}
}
