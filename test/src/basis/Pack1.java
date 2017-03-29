package basis;

/*
 * 背包问题：http://www.cnblogs.com/daoluanxiaozi/archive/2012/05/06/2486105.html(有问题作者没有维护)
 * 
 * (1)0-1背包问题
 * 
 * 有n个物品，每个物品的重量为weight[i]，每个物品的价值为value[i]。现在有一个背包，它所能容纳的重量为total，问：
 * 当你面对这么多有价值的物品时，你的背包所能带走的最大价值是多少？
 * 
 * 例子：5个物品，（重量，价值）分别为：（5，12），（4，3），（7，10），（2，3），（6，6）
 * 背包大小为12
 */

public class Pack1 {
	// 要注意细节，if/else是我自己补充的
	public static void main(String[] args) {
		int n = 5; //物品
		int[] weight = { 5, 4, 7, 2, 6 }; //重量
		int[] value = { 12, 3, 10, 3, 6 }; //价值
		int total = 12; //背包
		int[][] tab = new int[n][total + 1];
		for (int i = weight[0]; i <= total; i++)
			tab[n - 1][i] = value[0];
		for (int i = 1; i < n; i++) {
			// 有误的源代码
			// for (int j = weight[i]; j <= total; j++) {
			// tab[n - 1 - i][j] = Math.max(tab[n - i][j - weight[i]] +
			// value[i], tab[n - i][j]); // 核心
			//
			// }
			for (int j = 0; j <= total; j++) {
				if (j >= weight[i])
					tab[n - 1 - i][j] = Math.max(tab[n - i][j - weight[i]] + value[i], tab[n - i][j]); // 核心
				else
					tab[n - 1 - i][j] = tab[n - i][j];
			}
		}
		System.out.println(tab[0][4]);
	}
}
