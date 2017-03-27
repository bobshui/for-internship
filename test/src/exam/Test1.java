package exam;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Test1 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n+"打车点");
        int temp=n;
        List<Integer> xIntegers=new ArrayList<>();
        List<Integer> yIntegers=new ArrayList<>();
        while(temp-->0)
        	xIntegers.add(sc.nextInt());
        while(n-->0)
        	yIntegers.add(sc.nextInt());
        for(int i:xIntegers)
        	System.out.println(i+"");
        for(int i:yIntegers)
        	System.out.println(i+"");
        int xdes=0,ydes=0,walktime=0,taxitime=0;
        int j=4;
        while(j-->0){
        	xdes=sc.nextInt();
        	ydes=sc.nextInt();
        	walktime=sc.nextInt();
        	taxitime=sc.nextInt();
        }
        sc.close();
        System.out.println(xdes+" "+ydes+" "+walktime+" "+taxitime);
        
	}
}