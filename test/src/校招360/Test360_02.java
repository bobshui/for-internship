package 校招360;

//纯逻辑
import java.util.Scanner;

/*
 跳水比赛
时间限制：C/C++语言 2000MS；其他语言 4000MS
内存限制：C/C++语言 131072KB；其他语言 655360KB
题目描述：
一年一度的跳水比赛又开始了，全国各地的运动员都纷纷报名参加了比赛。在比赛之前，举办方让运动员抽签决定了比赛的出场顺序，运动员会根据这个顺序依次出场，完成自己的动作，然后裁判评分。
为了做好充分的准备和调整赛前心态，运动员希望了解其他运动员的实力，希望知道在自己出场之前，有多少位运动员上赛季的得分是高于自己的。现在你是一位数据分析家，你可以告诉运动员他们的情况么？
输入
第一行一个整数n，1≤n≤200000，
第二行n个整数，第i个整数表示本次比赛第i个出场的运动员上赛季的得分ai，1≤ai≤200000。
输出
一行输出n个整数，第i个整数表示本次比赛在第i个出场的运动员之前出场且得分比其高的运动员个数。不要在行末输出多余的空格。

样例输入
5
4 5 1 3 2
样例输出
0 0 2 2 3

Hint
第一位出场的运动员上赛季得分4，前面没有比其分高的；显然第二位出场的也没有；
第三位出场的运动员上赛季得分1，前面有2位比其高；第4位出场的运动员得分3，前面有2位比其高；
第5位出场的运动员得分2，前面有3位得分比其高。
 */

public class Test360_02 {
	public static void main(String[] args) {
		//笔试时自己写的解法
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] score = new int[n]; //得分
		int[] result = new int[n];
		for(int i=0;i<n;i++)
			score[i] = in.nextInt();
		for(int i=0;i<n;i++){
			int count=0;
			for(int j=0;j<i;j++){
				if(score[j]>score[i])
					count++;
			}
			result[i]=count;
		}
		for(int i=0;i<n-1;i++)
			System.out.println(result[i]+" ");
		System.out.println(result[n-1]);
		in.close();
	}
}
