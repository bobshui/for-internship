package exam;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(str);
		//sc.close();

		char[] cs1 = str.toCharArray();
		char[] cs2 = str.toCharArray();
		
		int count1 = 0;
		int count2 = 0;

		char temp1;
		int k1;
		int flag1 = cs1.length - 1;
		while (flag1 > 0) {
			k1 = flag1;
			flag1 = 0;
			for (int j = 0; j < k1; j++)
				if (cs1[j] < cs1[j + 1]) {
					temp1 = cs1[j];
					cs1[j] = cs1[j + 1];
					cs1[j + 1] = temp1;
					flag1 = j;
					count1++;
				}
		}
		
		char temp2;
		int k2;
		int flag2 = cs2.length - 1;
		while (flag2 > 0) {
			k2 = flag2;
			flag2 = 0;
			for (int j = 0; j < k2; j++)
				if (cs2[j] > cs2[j + 1]) {
					temp2 = cs2[j];
					cs2[j] = cs2[j + 1];
					cs2[j + 1] = temp2;
					flag2 = j;
					count2++;
				}
		}
		System.out.println(count1>count2?count2:count1);
		sc.close();
	}

}
