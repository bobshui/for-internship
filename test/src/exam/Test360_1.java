package exam;

import java.util.Scanner;

public class Test360_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		// int count=in.nextInt();
		int[] number = new int[n];
		int[] possibility = new int[n];
		int i = 0, j = 0;
		while (n-- > 0) {
			number[i++] = in.nextInt();
			possibility[j++] = in.nextInt();
		}
		float result = 0;
		for (int k = 0; k < number.length; k++)
			result += number[k] * possibility[k];
		result /= 100;
		//java.text.DecimalFormat df = new java.text.DecimalFormat("#.000");
		//System.out.println(df.format(result));
		System.out.println(String .format("%.3f",result));
		in.close();
	}

}
