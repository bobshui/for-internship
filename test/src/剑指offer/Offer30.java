package 剑指offer;

/* 30.连续子数组的最大和
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)
 */

public class Offer30 {

	//注意这个连续并不一定从0开始计算，这是牛客网上的很好的一个思路，动态规划的转变反而有可能会出问题
	public static int FindGreatestSumOfSubArray(int[] array) {
		if (array.length == 0)
			return 0;
		int total = array[0];
		int maxSum = array[0];
		for (int i = 1; i < array.length; i++) {
			if (total > 0)
				total += array[i];
			else
				total = array[i];
			if (total > maxSum)
				maxSum = total;
		}
		return maxSum;
	}

	/* 动态规划的思路，用f(i)表示以第i个数字结尾的子数组的最大和，则有
	 * 
	 * f(i)=p[i]  i=0|f(i-1)<0
	 * f(i)=p[i]+f(i-1)  i!=0&f(i-1)>0
	 * 
	 */
	
	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, -2, 4, -1 };
		System.out.println(FindGreatestSumOfSubArray(arr));
	}
}
