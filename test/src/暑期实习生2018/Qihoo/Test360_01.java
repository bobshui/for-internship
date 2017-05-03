package 暑期实习生2018.Qihoo;

//纯逻辑
import java.util.Scanner;

/*
 * 现在现在有一台机器，这台机器可以接收两种形式任务：（1）任务列表，任务列表里面有N个任务，对于第i个任务，机器在Ti时间开始执行，并在1个单位时间内做完。
 * （2）临时任务，机器可以在任意时间接收一个临时任务，但任务列表里面的任务优先级要高于临时任务，也就是说当机器空闲的时候才会执行临时任务。
 * 现在机器已经接收一个任务列表。接下来会有M个临时任务，我们想知道每个临时任务何时被执行。
 * 为了简化问题我们可以认为这M个临时任务是独立无关即任务是可以同时执行的，互不影响的。
 * 
 * 输入
 * 输入数据有多组，每组数据第一行包括两个整数N和M（1<=N, M<=10^5）。
 * 接下来一行有N个不同数字T1,T2,T3.....TN（1<=T1,Ti）
 * 接下来又M行，每行一个数字Qi（1<=Qi<=10^9），表示第i个临时任务的的接收时间。
 * 
 * 样例输入
 * 5 6
 * 1 2 3 5 6
 * 3
 * 2
 * 1
 * 4
 * 5
 * 6
 * 
 * 输出
 * 对于每个临时任务，输出它被执行的时间。
 * 
 * 样例输出
 * 4
 * 4
 * 4
 * 4
 * 7
 * 7
 */

public class Test360_01 {
	public static void main(String[] args) {
		//笔试时自己写的解法
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] work = new int[n]; //常规任务
		int[] tempwork = new int[m];  //临时任务
		for(int i=0;i<n;i++)
			work[i] = in.nextInt();
		for(int i=0;i<m;i++)
			tempwork[i] = in.nextInt();
		int[] temptime = new int[m];
		if(work[0]!=1){
			for(int i=0;i<m;i++){
				if(tempwork[i]<work[0])
					temptime[i]=1;
			}
		}
		for(int i=0;i<work.length-1;i++){
			if(work[i+1]-work[i]>1){
				for(int j=0;j<m;j++){
					if(tempwork[j]<work[i+1]&&temptime[j]==0)
						temptime[j]=work[i]+1>tempwork[j]?work[i]+1:tempwork[j];
				}
			}
		}
		for(int i=0;i<m;i++){
			if(temptime[i]==0)
				temptime[i]=work[work.length-1]+1;
		}
		for(int res:temptime)
			System.out.println(res);
		in.close();

		/*思路差不多，写的更加简略
		Scanner scanner = new Scanner(System.in);
		int n,m;
		n=scanner.nextInt();
		m=scanner.nextInt();
		int t[]=new int[n];
		int q[]=new int[m];
		for (int i = 0; i < t.length; i++) {
			t[i]=scanner.nextInt();
		}
		for (int i = 0; i < q.length; i++) {
			q[i]=scanner.nextInt();
		}
		scanner.close();
		int result[]=new int[m];
		boolean flag;
		for (int i = 0; i < q.length; i++) {
			flag=true;
			for (int j = 0; j < t.length; j++) {
				if (t[j]==q[i]) {
					flag = false;
					q[i]++;
					j=0;
				}
				if (t[j]!=q[i]&&j==t.length-1) {
					flag=true;
				}
			}
			if (flag) {
				result[i] = q[i];
			}else{
				result[i] = t[n-1]+1;
			}
		}
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		*/

	// TreeMap还是有点意思

	/*
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, Integer> map = null;
		while (sc.hasNext()) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			map = new TreeMap<Integer, Integer>();
			for (int k = 0; k < N; k++) {
				map.put(sc.nextInt(), 0);
			}

			int index = 0;
			int tempIndex = 0;
			for (int i = 0; i < M; i++) {
				index = sc.nextInt();
				if (!map.containsKey(index)) {
					System.out.println(index);
				} else {
					tempIndex = index;
					while (map.containsKey(tempIndex)) {
						tempIndex++;
					}
					System.out.println(tempIndex);
				}
			}
		}
		*/
	}
}
