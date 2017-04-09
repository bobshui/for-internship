package exam;

import java.util.Scanner;

/*
 * 除夕夜A
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
在大年三十的晚上，小明不想看春晚，就在网上报名了一场网络程序设计比赛，比赛将于20:00开始，持续4个小时，之到午夜。
比赛中会有n个问题，按照难度排序，也就是说，第一个问题是最简单的，最后一个问题是最难的。
小明知道他解决第k个问题需要k * 5分钟。小明的父母允许小明不看春晚，但要求他必须参加跨年，
就是小明必须在12.00或者12.00之前赶到客厅和父母一起跨年。他需要m分钟从房间走到客厅。
请问，小明在去参加跨年之前最多能解决多少问题。
输入
每个样例输入两行，每行一个整数，n和m，(1 ≤ n ≤ 10, 1 ≤ m ≤ 240) 。
输出
输出小明最多能解决的问题数。

样例输入
4
210
样例输出
3
 */

public class TestRenren_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m =sc.nextInt();
		sc.close();
		int time=240-m;
		int count=0;
		for(int i=1;i<=n;i++){
			time=time-i*5;
			if(time>=0){
				count++;
			}else{
				break;
			}
		}
		System.out.println(count);
	}
}
