package test;

public class test {
	public static void main(String[] args) {
		int count = 1;
		for (int i = 0; i < 20; i++) {
			count = count * 10 + i;
			if(count>Integer.MAX_VALUE/10)
				break;
			System.out.println(count);
		}
	}
}
