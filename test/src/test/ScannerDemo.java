package test;
/*
 * A:����   import java.util.Scanner;
 * B:��������¼����� Scanner sc = new Scanner(System.in);
 * C:ͨ�������ȡ���� int x = sc.nextInt();
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
