package newcoder;

import java.util.ArrayList;

public class Offer29 {
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
//		for(int p=0;p<k;p++){
//			arr.add(input[p]);
//		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] inttt= {1,23,4123,41,23};
		ArrayList<Integer> arr= GetLeastNumbers_Solution(inttt, 3);
		for(int i:arr){
			System.out.println(i);
		}
	}
}
