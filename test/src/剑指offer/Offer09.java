package 剑指offer;

/* 09变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */

public class Offer09 {

	// 这个题没有办法简化，主要是数学思想，正经推理也行，但是下面的思路很简单
	// 每个台阶都有跳与不跳两种情况（除了最后一个台阶），最后一个台阶必须跳。所以共用2^(n-1)中情况
	public int JumpFloorII(int target) {
		int n = 1;
		while (--target > 0) {
			n = n * 2;
		}
		return n;
	}

}
