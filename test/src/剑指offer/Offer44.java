package 剑指offer;

public class Offer44 {
	public static String ReverseSentence(String str) {
		if (str.trim().equals("")) {
			return str;
		}
		String[] a = str.split(" ");
		StringBuffer o = new StringBuffer();
		int i;
		for (i = a.length; i > 0; i--) {
			o.append(a[i - 1]);
			if (i > 1) {
				o.append(" ");
			}
		}
		return o.toString();
	}

	//
	public static String ReverseSentence2(String str) {
		return (str.lastIndexOf(" ") == -1) ? str
				: str.substring(str.lastIndexOf(" ") + 1) + " "
						+ ReverseSentence2(str.substring(0, str.lastIndexOf(" ")));
	}

	public static void main(String[] args) {
		System.out.println(ReverseSentence("student. a am I"));
	}
}