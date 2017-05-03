package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;


public class Offer27 {
	public static ArrayList<String> Permutation(String str) {
		ArrayList<String> result=new ArrayList<>();
		
		if(str!=null&&str.length()>0){
			char[] ca=str.toCharArray();
			Arrays.sort(ca);
			result.add(String.valueOf(ca));
			
			int len=ca.length;
			while(true){
				int p=len-1;
				int q;
				while(p>=1&&ca[p-1]>=ca[p])
					--p;
				if(p==0)
					break;
				q=p;
				--p;
				while(q<len&&ca[q]>ca[p])
					q++;
				--q;
				swap(ca, q, p);
				reverse(ca, p+1);
				result.add(String.valueOf(ca));
			}
		}
		return result;
	}
	
	public static void reverse(char[] cs,int start){
		int len=cs.length;
		for(int i=0;i<(len-start)/2;i++){
			int p=start+i;
			int q=len-1-i;
			if(p!=q)
			swap(cs, p, q);
		}
	}
	
	public static void swap(char[] cs,int i,int j){
		char temp;
		temp=cs[i];
		cs[i]=cs[j];
		cs[j]=temp;
	}

	public static void main(String[] args) {
		String str="abcd";
		ArrayList<String> arr = Permutation(str);
		for(String i:arr)
			System.out.println(i);

	}
}
