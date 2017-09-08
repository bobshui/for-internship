package 剑指offer;

/* 40.数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */

import java.util.HashSet;
import java.util.Set;

//书中要求时间复杂度为O(n),空间复杂度为O(1),采用的异或来实现,然而一共有两个只出现一次的数字，如何把他们依然通过异或区分出来呢？
//可以通过从头到尾异或后为1的那一位来把数组分为两部分，这两个数一定会被分开，但是这个其实很难想

//自己写的 并没有什么道理的方法
public class Offer40 {
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		 Set<Integer> set=new HashSet<>();
		 for(int i=0;i<array.length;i++){
			 if(set.contains(array[i]))
				 set.remove(array[i]);
				else
			 set.add(array[i]);
		 }
		 int[] newarr={0,0};
		 int j=0;
		 for(Integer integer:set){
			 newarr[j]=integer;
		 j++;
		 }
		 num1[0]=newarr[0];
		 num2[0]=newarr[1];
	}
}
