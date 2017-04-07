package exam;

public class TestHuawei_1 {
	public static void main(String[] args) {
		int sum=0;
		int count=1;
		for(int i=100;i<1000;i++){
			int temp=i;
			int a1=temp%10;
			temp=temp/10;
			int a2=temp%10;
			temp=temp/10;
			int a3=temp;
			if(a1*a1*a1+a2*a2*a2+a3*a3*a3==i){
				System.out.println("第"+count+"个水仙花数: "+i);
				count+=1;
				sum+=i;
			}
		}
		System.out.println("水仙花数总和为: "+sum);
	}
}
