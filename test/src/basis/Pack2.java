package basis;

/*
 * (2)完全背包
 * 
 * 有n种物品，每种物品有无限个，每个物品的重量为weight[i]，每个物品的价值为value[i]。
 * 现在有一个背包，它所能容纳的重量为total，问：当你面对这么多有价值的物品时，你的背包所能带走的最大价值是多少？
 * 
 */

public class Pack2 {
	public static void main(String[] args) {
		int n = 5; //物品
		int[] weight = { 5, 4, 7, 2, 6 }; //重量
		int[] value = { 12, 3, 10, 3, 6 }; //价值
		int total = 12; //背包容量
		int[] tab=new int[total+1];
		for(int i=0;i<n;i++){
			for(int j=weight[i];j<=total;j++){
				//if(j>=weight[i])
				 tab[j] = Math.max(tab[j-weight[i]]+value[i],tab[j]);
			}
		}
		System.out.println(tab[total]);
	}
}

