package codinginterviews;

/* 02替换空格
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * */

public class Offer02 {
	public String replaceSpace(StringBuffer str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				sb.append(str.charAt(i));
			} else {
				sb.append("%20");
			}
		}
		return sb.toString();
	}

	// return str.toString().replaceAll("\\s", "%20");这样的代码呢

	// 不使用新空间，则应该在计算好新的字符串的长度后，从后往前移动
	
	public String replaceSpace2(StringBuffer str) {
		int spacenum=0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==' ')
				spacenum++;
		}
		int indexold = str.length()-1;
		int newlength=str.length()+spacenum*2;
		int indexnew=newlength-1;
		str.setLength(newlength);
		for(;indexold>=0&&indexold<newlength;--indexold){
			if(str.charAt(indexold)==' '){
				str.setCharAt(indexnew--, '0');
				str.setCharAt(indexnew--, '2');
				str.setCharAt(indexnew--, '%');
			}else{
				str.setCharAt(indexnew--, str.charAt(indexold));
			}
		}
		return str.toString();
	}

	public static void main(String[] args) {
		String a = "hello bob";
		StringBuffer sb = new StringBuffer();
		sb.append(a);
		System.out.println(new Offer02().replaceSpace2(sb));
	}
}
