package 剑指offer;

/* 34.第一个只出现一次的字符
 * 在一个字符串(1<=字符串长度<=10000，全部由大写字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * (原书中并无任何限制条件)
 */

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
	
	//类似题目，判断两个单词是否互为变位词(即包含的字母和该字母出现的次数相同),哈希表对每个字符，第一个字符串增加，第二个字符串减少，都为0即满足
}
