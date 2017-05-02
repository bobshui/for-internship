package codinginterviews;

public class Offer48 {
	public int Add(int num1, int num2) {
		while(num2!=0){
			int temp=num1^num2;
			num2=(num1&num2)<<1;
			num1=temp;
		}
		return num1;
		
		
	}
	
	
	public static void main(String[] args) {
		Offer48 offer48=new Offer48();
		int a = offer48.Add(5, 7);
		System.out.println(a);
	}
}
