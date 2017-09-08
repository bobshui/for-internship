package test;


public class Test extends Test2{
	
	static
	{
		System.out.println("s1");
	}
	{
		System.out.println("s2");
	}
	
	

public Test(){
	System.out.println("s3");
}

public static void main(String[] args) {
	new Test();
}

}