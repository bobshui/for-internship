package newcoder;

import java.util.ArrayList;

public class Offer41 {
	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> arr1=new ArrayList<>();
		//ArrayList<Integer> arr2=new ArrayList<>();
		for(int i=(int)Math.sqrt(sum)*2;i>1;i--){
			if(i%2==0){
				if((sum*2)%i==0&&sum%i!=0&&sum/i>=i/2){
					ArrayList<Integer> arr2=new ArrayList<>();
					for(int j=0;j<i;j++){
						arr2.add(sum/i+j-i/2+1);
					}
					arr1.add(arr2);
				}
			}else{
				if(sum%i==0&&sum/i>i/2){
					ArrayList<Integer> arr2=new ArrayList<>();
					for(int j=0;j<i;j++){
						arr2.add(sum/i+j-i/2);
					}
					arr1.add(arr2);
				}
			}
		}
		return arr1;
    }
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> arr1=new ArrayList<>();
		arr1=FindContinuousSequence(3);
		for(ArrayList<Integer> arr2:arr1){
			for(Integer integer:arr2)
				System.out.print(integer+"  ");
			System.out.println();
		}
	}
}
