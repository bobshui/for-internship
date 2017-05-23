package 剑指offer;

/* 32.把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Offer32 {
	public String PrintMinNumber(int [] numbers) {
		StringBuilder result=new StringBuilder();
		ArrayList<Integer> arr= new ArrayList<>();
		for(int i=0;i<numbers.length;i++){
			arr.add(numbers[i]);
		}
		Collections.sort(arr, new Comparator<Integer>() {
			public int compare(Integer in1,Integer in2){
				String s1=in1+""+in2;
				String s2=in2+""+in1;
				return(s1.compareTo(s2));
			}
		});
		
		for(int k:arr){
			result.append(k);
		}
		
		return result.toString();
	}
}
