package newcoder;

public class Offer45 {
	public static boolean isContinuous(int [] numbers) {
		if(numbers.length!=5)
			return false;
		int[] array=new int[14];
		int temp,max=-1,min=14;
		for(int i=0;i<numbers.length;i++){
			temp=numbers[i];
			if(temp==0)
				continue;
			if(temp<0||temp>13)
				return false;
			array[temp]++;
			if(array[temp]>1)
				return false;
			if(temp>max)
				max=temp;
			if(temp<min)
				min=temp;
			if(max-min>4)
				return false;
		}
		return true;
    }
	
/*
 * 感受牛客网位运算高手
 */
/*
	public static boolean isContinuous(int [] numbers) {
		if(numbers.length!=5)
			return false;
		int max=-1,min=14,flag=0;
		for(int i=0;i<numbers.length;i++){
			int number=numbers[i];
			if(number==0)
				continue;
			if(number<0||number>13)
				return false;
			if(((flag>>number)&1)==1)
				return false;
			flag |= (1<<number);
			if(number>max)
				max=number;
			if(number<min)
				min=number;
			if(max-min>4)
				return false;
		}
		return true;
    }
*/
	
	public static void main(String[] args) {
		int[] arr= {1,3,2,4,5};
		System.out.println(isContinuous(arr));
	}
}
