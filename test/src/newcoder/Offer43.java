package newcoder;

public class Offer43 {
	public static String LeftRotateString(String str, int n) {
		int len = str.length();
		if (len == 0)
			return "";
		n = n % len;
		str = str+str;
		return str.substring(n, len+n);
	}
	
	public static void main(String[] args) {
		String string = LeftRotateString("abcdefg", 2);
		System.out.println(string);
	}
}
