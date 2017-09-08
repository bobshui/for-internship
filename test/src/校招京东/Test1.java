package 校招京东;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int n = 1;
		while (s.length() != 0) {
			if (s.charAt(0) == '(' && s.charAt(1) == ')')
				s = s.substring(2, s.length());
			else {
				char x1=s.charAt(0);
				char x2=s.charAt(s.length()-1);
				int temp=0;
				for(int i=s.length()-2;i>=0;i--){
					if(s.charAt(i)==x2&&s.charAt(s.length()-i-1)==x1){
						temp++;
					}else
						break;
				}
				n=n*(temp+1);
				s=s.substring(1,s.length()-1);
			}
		}
		System.out.println(n);
		in.close();
	}
}
