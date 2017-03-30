package exam;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
 * 
 * 绘制括号序列
时间限制：C/C++语言 2000MS；其他语言 4000MS
内存限制：C/C++语言 131072KB；其他语言 655360KB
题目描述：
垂直绘制一个中括号的序列 并用中括号的大小表示层次关系
绘制 [[[]]][] 这个括号序列
如图：



绘图遵守以下原则：
   各个括号之间没有空格 只有在左右括号在最里层配对时 中间才会有一条空行
   里层的括号必定小于外层的括号
   同一层次的括号大小相同（比如上述的样例 最下面的括号和上面的大括号相同大小）
输入
输入一个以括号组成的字符串
输出
输出绘制的图形 保证括号匹配序列合法

样例输入
[][][]
样例输出
+-+
| |
 
| |
+-+
+-+
| |
 
| |
+-+
+-+
| |
 
| |
+-+
（下图为样例输出的图片格式，供参考）


Hint
数据范围：
30%的数据 括号层数只有1
100%的数据 括号层数 <= 6
100%的数据 字符串长度 <= 100

每行行末不要输出多余的空格
 */
public class TestToutiao_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();

		char[] cs = str.toCharArray();
		
		Stack<Character> stack=new Stack<>();
		for(char s:cs){
			if(s=='['){
				System.out.println("+-+");
				System.out.println("| |");
				System.out.println();
				System.out.println("| |");
				System.out.println("+-+");
			}
				
		}
		
		
		
	}
}
