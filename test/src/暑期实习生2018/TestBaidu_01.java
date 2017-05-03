package 暑期实习生2018;

import java.util.Scanner;
import java.util.TreeSet;

public class TestBaidu_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		TreeSet<Integer> treeSet = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			treeSet.add(sc.nextInt());
		}
		sc.close();

		int i=0;
		for(int a:treeSet){
			i++;
			if(i==3){
				System.out.println(a);
			}
		}
		if(i<2)
			System.out.println(-1);
	}
}
