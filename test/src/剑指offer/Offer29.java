package 剑指offer;

/* 29.最小的k个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
import java.util.ArrayList;

public class Offer29 {
	
	//目测是我自己写的选择排序？复杂度就是k*n了，直接排序了再取是n*logn
	public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input,int k){
		int temp;
		ArrayList<Integer> arr= new ArrayList<>();
		if(k>input.length)
			return arr;
		for(int i=0;i<k;i++)
			for(int j=i+1;j<input.length;j++)
				if(input[i]>input[j]){
					temp=input[i];
					input[i]=input[j];
					input[j]=temp;
				}
		return arr;
	}
	
	//剑指offer1,基于partition函数找到第k+1大的数(会修改原数组)
	
	//剑指offer2，维护一个容器(比如二叉树)，可以搞定n*logk，针对海量数据不用一次全不加载进入内存中
	
	public static void main(String[] args) {
		int[] inttt= {1,23,4123,41,23};
		ArrayList<Integer> arr= GetLeastNumbers_Solution(inttt, 3);
		for(int i:arr){
			System.out.println(i);
		}
	}
}
