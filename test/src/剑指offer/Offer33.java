package 剑指offer;

/* 33丑数
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */

public class Offer33 {
	//一看就是硬算，无聊
	public static int GetUglyNumber_Solution2(int index) {
		int count=8;
		if(index<7)
			return index;
		index=index-6;
		for(;;count++){
			if(isUgly(count))
				index--;
			while(index==0)
				return count;
		}
	}
	
	public static boolean isUgly(int count){
		while(count%2==0)
			count=count/2;
		while(count%3==0)
			count=count/3;
		while(count%5==0)
			count=count/5;
		return(count<7);
	}
	
	public static int GetUglyNumber_Solution(int index) {
		//int count=8;
		if(index<7)
			return index;
		int[] arr = new int[index-1];
		arr[0]=1;
		int t2=0,t3=0,t5=0,i;
		for(i = 1;i<index;i++){
			arr[i]=Math.min(arr[t2]*2, Math.min(arr[t3]*3, arr[t5]*5));
			if(arr[i]==arr[t2]*2) t2++;
			if(arr[i]==arr[t3]*3) t3++;
			if(arr[i]==arr[t5]*5) t5++;
		}
		return arr[index-1];
	}
	
	public static void main(String[] args) {
		int i=GetUglyNumber_Solution(100);
		System.out.println(i);
	}
}
