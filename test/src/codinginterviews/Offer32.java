package codinginterviews;

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
