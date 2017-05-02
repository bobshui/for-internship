package codinginterviews;

import java.util.LinkedHashMap;

public class Offer34 {
	public static int FirstNotRepeatingChar(String str) {
		char[] cs = str.toCharArray();
		LinkedHashMap<Character, Integer> map=new LinkedHashMap<>();
		for(char i:cs){
			if(!map.containsKey(i))
				map.put(i, 1);
			else
				map.put(i, map.get(i)+1);
		}
		for(char ch:map.keySet()){
			if(map.get(ch)==1)
				return str.indexOf(ch);
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(FirstNotRepeatingChar("abcabcs"));
	}
}
