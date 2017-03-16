package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Solution {
	public static ArrayList<String> Permutation(String str) {
		ArrayList<String> re = new ArrayList<String>();
		if (str == null || str.length() == 0) {
			return re;
		}
		HashSet<String> set = new HashSet<String>();
		fun(set, str.toCharArray(), 0);
		re.addAll(set);
		Collections.sort(re);
		return re;
	}
	
	static void fun(HashSet<String> re, char[] str, int k) {
		if (k == str.length) {
			re.add(new String(str));
			return;
		}
		for (int i = k; i < str.length; i++) {
			swap(str, i, k);
			fun(re, str, k + 1);
			swap(str, i, k);
			}
		}
			
	static void swap(char[] str, int i, int j) {
			if (i != j) {char t = str[i];
			str[i] = str[j];str[j] = t;
		}
			}
	
	public static void main(String[] args) {
		String aa="abc";
		ArrayList<String> arr=new ArrayList<>();
		arr=Permutation(aa);
		for(String i:arr){
			System.out.println(i);
		}
	}
	}


           
       
    		
    	
    	
    	
    	

