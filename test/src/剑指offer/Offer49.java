package 剑指offer;


public class Offer49 {
	public int StrToInt(String str) {
		if (str == null || str.length() == 0)
			return 0;
		char[] cs = str.toCharArray();
		int flag = 1;
		int i = 0;
		if (cs[0] == '+') {
			flag = 1;
			i++;
		} else if (cs[0] == '-') {
			flag = -1;
			i++;
		}

		int result = toInt(cs, i);
		return flag * result;
	}

	public int toInt(char[] cs, int begin) {
		int result = 0;
		for (int i = begin; i < cs.length; i++) {
			if (cs[i] >= '0' && cs[i] <= '9') {
				result = result * 10 + (cs[i] - '0');
				if (result > Integer.MAX_VALUE/10&&i<cs.length-1) 
					return 0;
			} else
				return 0;
		}
		return result;
	}

	public static void main(String[] args) {
		Offer49 offer49 = new Offer49();
		System.out.println(offer49.StrToInt("+2147483647"));
	}
}
