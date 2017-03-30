package exam;

/*
 * 孙聪的VMware试题
 * 输入的数字k是一个数的阶乘后面的0的个数，求满足条件的数的最小值。1<=k<=1000000000
 */

public class TestVMvare {
	public static void main(String[] args) {
		int k = 100000000;
		int[] count=new int[13];  //存储5，25，125里面0的个数
		
		int five=1;
		for(int i=0;i<=12;i++){
			int count1=0;
			five=five*5;
			int temp=five;
			while(temp!=0){
				temp=temp/5;
				count1+=temp;
			}
			count[i]=count1;
			
		}
			
		int amount[]=new int[13]; //存储多少个5相乘
		while(k>0){
			for(int i=amount.length-1;i>=0;i--){
				for(int j=5;j>=1;j--)
				if(j*count[i]<=k){
					amount[i]=j;
					k=k-j*count[i];
					break;
				}
			}
		}
		
		int temp=5;
		int result=0;
		for(int i:amount){
			result+=temp*i;
			temp=temp*5;
		}
	
		System.out.println(result);
	}
}
