package 剑指offer;

/* 13调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

public class Offer13 {
	 public void reOrderArray(int [] array) {
	        if(array.length==0||array==null)
	        	return;
	        int i=0,j=array.length-1;
	        int temp;
	        while(i<j){
	        	if(i<j&&!func(array[i]))
	        		i++;
	        	if(i<j&&func(array[i]))
	        		j--;
	        	temp=array[i];
	        	array[i]=array[j];
	        	array[j]=temp;
	        }
	        	
	    }

	private boolean func(int i) {
		// TODO Auto-generated method stub
		if((i&1)==0)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
	}
}
