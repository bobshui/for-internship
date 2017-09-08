package 剑指offer;

/* 44 翻转单词顺序列
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */

//在Java的函数库中，实现的方法还是很多的
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

	//递归的抓取，其实是差不多的
	public static String ReverseSentence2(String str) {
		return (str.lastIndexOf(" ") == -1) ? str
				: str.substring(str.lastIndexOf(" ") + 1) + " "
						+ ReverseSentence2(str.substring(0, str.lastIndexOf(" ")));
	}

	public static void main(String[] args) {
		System.out.println(ReverseSentence("student. a am I"));
	}
}