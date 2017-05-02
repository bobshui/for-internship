package codinginterviews;

public class Offer52 {
	public boolean match(char[] str, char[] pattern) {
		if(str ==null||pattern==null)
			return false;
		int strindex=0;
		int patternindex=0;
		return matchmatch(str,strindex,pattern,patternindex);
	}

	public boolean matchmatch(char[] str,  int strindex,char[] pattern, int patternindex) {
		// TODO Auto-generated method stub
		//终止条件
		if(strindex==str.length&&patternindex==pattern.length)
			return true;
		
		if (strindex != str.length && patternindex == pattern.length)
			return false;

		//模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
		if (patternindex + 1 < pattern.length && pattern[patternindex + 1] == '*') {
			if ((strindex != str.length && pattern[patternindex] == str[strindex]) || (pattern[patternindex] == '.' && strindex != str.length)){
				return matchmatch(str, strindex, pattern, patternindex + 2)//模式后移2，视为x*匹配0个字符 
						|| matchmatch(str, strindex + 1, pattern, patternindex + 2)//视为模式匹配1个字符                 
						|| matchmatch(str, strindex + 1, pattern, patternindex);//*匹配1个，再匹配str中的下一个 
				} else {
					return matchmatch(str, strindex, pattern, patternindex + 2);
}
		}
		//模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false 
		if ((strindex != str.length && pattern[patternindex] == str[strindex]) || (pattern[patternindex] == '.' && strindex != str.length)){
			return matchmatch(str, strindex + 1, pattern, patternindex + 1);
		}
		return false;
	}
}
	

	

