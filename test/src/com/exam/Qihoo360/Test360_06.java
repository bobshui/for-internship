package com.exam.Qihoo360;

import java.util.Scanner;

/*
 * 题目描述
 * 小明同学喜欢体育锻炼，他常常去操场上跑步。跑道是一个圆形，在本题中，我们认为跑道是一个半径为R的圆形，设圆心的坐标为原点(0,0)。
 * 小明跑步的起点坐标为(R,0)，他沿着圆形跑道跑步，而且一直沿着一个方向跑步。回到家后，他查看了自己的计步器，计步器显示他跑步的总路程为L。
 * 小明想知道自己结束跑步时的坐标，但是他忘记自己是沿着顺时针方向还是逆时针方向跑的了。他想知道在这两种情况下的答案分别是多少。
 * 
 * 输入
 * 输入两个整数L,R (1<=L,R<=100)。
 * 
 * 样例输入
 * 1 2
 * 
 * 输出
 * 输出两行，每行两个数，用空格隔开。第一行的两个数为顺时针情况下结束位置的坐标，第二行是逆时针情况下结束位置的坐标。所有数据小数点后四舍五入保留3位。
 * 
 * 样例输出
 * 1.755 -0.959
 * 1.755 0.959

 */

/* 标答
 * 根据跑步总长L，可以根据下式计算绕着圆心转动角度θ。θ=L/R，
 * 若顺时针跑步时，结束时坐标可以计算为：{x1=R*cosθ，y1=−R*sinθ}
 * 若为逆时针跑步时，结束时坐标可以计算为：{x2=R*cosθ，y2=R*sinθ}
 * 输出(x1,y1),(x2,y2)即为结束时顺时针坐标和逆时针坐标。
 */
public class Test360_06 {
	public static void main(String[] args) {
		//复杂了，多余了，但是就是一个数学题，不用太深究
		Scanner in = new Scanner(System.in);
		int l = in.nextInt();
		int r = in.nextInt();
		in.close();
		
		double length=l;
		while(length>Math.PI*r)
			length=length-Math.PI*r;
		
		double angle=length/(r*2);
		double lo=Math.sin(angle)*r*2;
		double x=lo*Math.sin(angle);
		double y=lo*Math.cos(angle);
		y=y>0?y:-y;
		System.out.println(String.format("%.3f",r-x)+" "+String.format("%.3f",-y));
		System.out.println(String.format("%.3f",r-x)+" "+String.format("%.3f",y));
		
		
	}
}
