package 校招京东;

import java.util.Scanner;

/*
 * 
 */
public class Test2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if (n == 1){
			System.out.println(1);
			return;
		}
//		if(n==2){
//			System.out.println(6);
//			return;
//		}
		int total = n*n;
		if(total>1000000007)
			total=total%1000000007;
		//total=total+(n-1)*sum;
		//System.out.println(total);
	}
}
