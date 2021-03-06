package 暑期实习生2018;

import java.util.Scanner;

/*
 * 一个一维数组，记录n天中每天的携程股价。
股市交易规则如下：
a）一天只能有买进或者卖出一种操作，也可以不做任何操作，卖出时价格减买入时价格即为收益
b）每次卖出操作后有冻结期，k天之后才能进行下一次买进操作（k>=1）
c）买进之后必须卖出才能再次买进
设计一个算法，找到交易收益最大化的买进卖出策略，返回最后的最大收益值

输入
一维正整数数组，表示每天股价
正整数k，表示冷冻期

输出
返回最大收益

样例输入
int[] sotckPrice = {1,2,3,5,2,6,3,7};
int k = 2;
输入为
8（表示数组长度）
1（开始依次输入数组元素）
2
3
5
2
6
3
7
2（输入k）
样例输出
8
(1买进，5卖出，3买进，7卖出，收益最大为8)

Hint
没有头绪的话，先从k=1开始思考吧
 */
public class TestXiecheng_3 {
	static int maxProfit(int[] stockPrices, int k) {
		return 0;
	}

	/****************************** 结束写代码 ******************************/

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;

		int _stockPrices_size = 0;
		_stockPrices_size = Integer.parseInt(in.nextLine().trim());
		int[] _stockPrices = new int[_stockPrices_size];
		int _stockPrices_item;
		for (int _stockPrices_i = 0; _stockPrices_i < _stockPrices_size; _stockPrices_i++) {
			_stockPrices_item = Integer.parseInt(in.nextLine().trim());
			_stockPrices[_stockPrices_i] = _stockPrices_item;
		}

		int _k;
		_k = Integer.parseInt(in.nextLine().trim());

		res = maxProfit(_stockPrices, _k);
		System.out.println(String.valueOf(res));

	}
}
