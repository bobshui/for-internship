package interview;

/*
 * 寻找数组的平衡点（该点左右的和相等）
 */

public class Tencent_other {

	
	public static void main(String[] args) {
		int[] array = {1,2,3,0,4,0,-4,0,1,2,3};
		System.out.println("------");
		show2(array);
	}
	
	//改进了一下，其实是类似的思路
	public static void show2(int[] question){
		int index=1;
		int sumAll=0;
		for(int i=0;i<question.length;i++){
			sumAll+=question[i];
		}
		int sum1=question[0];
		int sum2=sumAll-question[0]-question[1];
		while(index<question.length-1){
			if(sum1==sum2){
				System.out.println(index);
			}
			index++;
			sum1=sum1+question[index-1];
			sum2=sum2-question[index];
		}
	}
	
	//写得是两个指针的办法，但是写出来很有点丑陋，可以改进
	//有bug,只能找到一个平衡点（正数这样是可以的，有负数和0就gg）
	public static void show(int[] question){
		int sum1=0;
		int sum2=0;
		
		int index1=0;
		int index2=question.length-1;
		
		int temp1=0;
		int temp2=question.length-1;
		
		while(index1<index2){
			
			if(sum1==sum2&&index2-index1==2){
				System.out.println(index1+1);
				break;
			}
			if(sum1==sum2){
				sum1+=question[temp1];
				sum2+=question[temp2];
				index1=temp1;
				index2=temp2;
				temp1++;
				temp2--;
				continue;
			}
			if(sum1<sum2){
				sum1+=question[temp1];
				index1=temp1;
				temp1++;
				continue;
			}
			else{
				sum2+=question[temp2];
				index2=temp2;
				temp2--;
				continue;
			}
		}
	}
}
