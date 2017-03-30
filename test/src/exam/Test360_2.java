package exam;

import java.util.Scanner;

public class Test360_2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k=m;
		int[] work = new int[n];
		int[] tempwork = new int[m];
		int i=0;
		while (n-- > 0) {
			work[i++] = in.nextInt();
		}
		i=0;
		while (k-- > 0) {
			tempwork[i++] = in.nextInt();
		}
		int[] temptime = new int[m];
		if(work[0]!=1){
			for(i=0;i<m;i++){
				if(tempwork[i]<work[0])
					temptime[i]=1;
			}
		}
		
		for(i=0;i<work.length-1;i++){
			if(work[i+1]-work[i]>1){
				for(int j=0;j<m;j++){
					if(tempwork[j]<work[i+1]&&temptime[j]==0)
						temptime[j]=work[i]+1>tempwork[j]?work[i]+1:tempwork[j];
				}
			}
		}
		for(int j=0;j<m;j++){
			if(temptime[j]==0)
				temptime[j]=work[work.length-1]+1;
		}
		for(int res:temptime)
			System.out.println(res);
		in.close();
	}

}
