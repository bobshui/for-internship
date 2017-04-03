package exam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.naming.directory.SchemaViolationException;
import javax.swing.event.InternalFrameAdapter;

import org.omg.Messaging.SyncScopeHelper;

/*
 * 进制转换
时间限制：C/C++语言 2000MS；其他语言 4000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
用英文字母a-z来分别表示数值0-25, 形成一个26进制的数值表示法。需要你写一个方法，将用a-z表示的26进制数值的字符串，转化为对应的10进制数值。

输入
输入数据有多组，每组占一行，包含多个a-z之间的字符。

输出
所对应表示的10进制数。


样例输入
ba
bcd
gibbon
goodboy

样例输出
26
731
74962693
2026285376


Hint
做进制转换逻辑。
 */
public class TestQunar_2 {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		Queue<String> queue = new LinkedList<>();
		String str=null;
		int count;
		do{
			str=sc.nextLine();
			queue.offer(str);}
		while(!str.equals(""));
		
		//queue.remove();
		
		while(!queue.isEmpty()){
			int sum=0;
			count=1;
			String string=queue.poll();
			if(string.equals(""))
				break;
			//System.out.println(string);
			char[] cs=string.toCharArray();
			for(int j=cs.length-1;j>=0;j--){
				sum+=count*(cs[j]-'0'-49);
				count*=26;
			}
			System.out.println(sum);
			
		}
		sc.close();
		
		
		
	}
}
	



