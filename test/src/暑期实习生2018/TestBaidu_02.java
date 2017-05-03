package 暑期实习生2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class TestBaidu_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		List<String> list_r = new ArrayList<>();
		List<String> list_g = new ArrayList<>();
		List<String> list_b = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String a = sc.nextLine();
			if (a.charAt(0) == 'R')
				list_r.add(a);
			if (a.charAt(0) == 'G')
				list_g.add(a);
			if (a.charAt(0) == 'B')
				list_b.add(a);
		}
		sc.close();

		String[] r = (String[]) list_r.toArray(new String[list_r.size()]);
		String[] g = (String[]) list_g.toArray(new String[list_g.size()]);
		String[] b = (String[]) list_b.toArray(new String[list_b.size()]);

		double max = 0;
		double count = 0;
		for (int i = 0; i < r.length - 2; i++) {
			for (int j = i + 1; j < r.length - 1; j++) {
				for (int k = j + 1; k < r.length; k++) {
					count = getArea(r[i], r[j], r[k]);
					max=max>count?max:count;
					count=0;
				}
			}
		}
		for (int i = 0; i < g.length - 2; i++) {
			for (int j = i + 1; j < g.length - 1; j++) {
				for (int k = j + 1; k < g.length; k++) {
					count = getArea(g[i], g[j], g[k]);
					max=max>count?max:count;
					count=0;
				}
			}
		}
		for (int i = 0; i < b.length - 2; i++) {
			for (int j = i + 1; j < b.length - 1; j++) {
				for (int k = j + 1; k < b.length; k++) {
					count = getArea(b[i], b[j], b[k]);
					max=max>count?max:count;
					count=0;
				}
			}
		}
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < g.length - 1; j++) {
				for (int k = 0; k < b.length; k++) {
					count = getArea(r[i], g[j], b[k]);
					max=max>count?max:count;
					count=0;
				}
			}
		}
		System.out.println(max);
	}

	private static double getArea(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		String[] s=string.split(" ");
		String[] s2=string2.split(" ");
		String[] s3=string3.split(" ");
		double a = Math.sqrt(Math.pow(Integer.parseInt(s[1])-Integer.parseInt(s2[1]), 2)+
				Math.pow(Integer.parseInt(s[2])-Integer.parseInt(s2[2]), 2)+
				Math.pow(Integer.parseInt(s[3])-Integer.parseInt(s2[3]), 2)
				);
		double b = Math.sqrt(Math.pow(Integer.parseInt(s3[1])-Integer.parseInt(s2[1]), 2)+
				Math.pow(Integer.parseInt(s3[2])-Integer.parseInt(s2[2]), 2)+
				Math.pow(Integer.parseInt(s3[3])-Integer.parseInt(s2[3]), 2)
				);
		double c = Math.sqrt(Math.pow(Integer.parseInt(s[1])-Integer.parseInt(s3[1]), 2)+
				Math.pow(Integer.parseInt(s[2])-Integer.parseInt(s3[2]), 2)+
				Math.pow(Integer.parseInt(s[3])-Integer.parseInt(s3[3]), 2)
				);
		double p=(a+b+c)/2;
		return Double.parseDouble(String.format("%.5f", Math.sqrt(p*(p-a)*(p-b)*(p-c))));
	}
}
