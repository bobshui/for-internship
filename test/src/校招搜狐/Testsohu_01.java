package 校招搜狐;

import java.util.Scanner;

/*
 * kolakoski序列生成
 */
public class Testsohu_01 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] number = new int[m];
		int[] result = new int[n];
		for (int i = 0; i < m; i++)
			number[i] = in.nextInt();

		int count = 0;// 结果数列长度
		int numberindex = 0;// 原始数组计数
		int actindex = 0;
		int flag = 0;
		if (number[numberindex] == 1) {
			result[count] = number[numberindex];
			count++;
			actindex++;
			numberindex++;
			flag = 1;
		}
		while (count < n) {
			if (flag == 0) {
				int temp = number[numberindex];
				while (temp >= 1) {
					result[count] = number[numberindex];
					temp--;
					count++;
				}
				actindex++;
				numberindex++;
				flag = 1;
			} else {
				int temp=result[actindex];
					if(temp==0)
						temp=number[numberindex];
				while (temp >= 1) {
					result[count] = number[numberindex];
					temp--;
					count++;
					if(count>=n)
						break;
				}
				actindex++;
				numberindex++;
			}
			if (numberindex > m - 1)
				numberindex %= m;
		}

		for (

		int i = 0; i < n; i++)
			System.out.println(result[i]);
		in.close();
	}
}
