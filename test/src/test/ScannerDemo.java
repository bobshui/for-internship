package test;
/*
 * A:导包   import java.util.Scanner;
 * B:创建键盘录入对象 Scanner sc = new Scanner(System.in);
 * C:通过对象获取数据 int x = sc.nextInt();
 */

import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int x = sc.nextInt();
	int y = sc.nextInt();
	System.out.println("x = y?"+ (x == y));
	sc.close();
	}
}
