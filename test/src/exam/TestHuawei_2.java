package exam;

import java.util.Scanner;

//输入：[1.80.1.10]|[2.20.11.15]|[3.50.21.10]|[4.120.31.10]|[5.100.41.10]
public class TestHuawei_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		String[] strings=s.split("\\|");
		int[] id=new int[5];
		int[] pri=new int[5];
		int[] starttime=new int[5];
		int[] time=new int[5];
		for(String ss:strings){
			int count=0;
			ss=ss.substring(1, ss.length()-1);
			//System.out.println(ss);
			String[] sss=ss.split("\\.");
			id[count]=Integer.valueOf(sss[0]);
			pri[count]=Integer.valueOf(sss[1]);
			starttime[count]=Integer.valueOf(sss[2]);
			time[count]=Integer.valueOf(sss[3]);
			count++;
			//System.out.println(ss);
		}
		sc.close();
		
		
	}
}
