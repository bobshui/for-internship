package 剑指offer;

/*
 * 丢骰子，计数所有可能性
 */
public class Offerplus67 {
	
	public static int maxValue=3;
	
	public static void main(String[] args) {
		print(2);
	}
	
	//number为骰子的个数
	public static void print(int number){
		int n=number;
		int pos[][]=new int[2][maxValue*number+1];
		int flag=0;
		
		for(int i=0;i<maxValue*number+1;i++){
			pos[0][i]=0;
			pos[1][i]=0;
		}
		
		for(int i=1;i<=maxValue;i++)
			pos[flag][i]=1;
		
		for(int k=2;k<=number;k++){
			for(int i=0;i<k;i++)
				pos[1-flag][i]=0;
			for(int i=k;i<=maxValue*k;i++){
				pos[1-flag][i]=0;
				for(int j=1;j<=i&&j<=maxValue;j++){  //这个maxvalue是循环的上限关键
					pos[1-flag][i]+=pos[flag][i-j];
				}
			}
			
			flag=1-flag;
		}
		
		for(int i=number;i<=maxValue*number;i++)
			System.out.print(pos[flag][i]+" ");
		
	}
}
