package 剑指offer;

/* 51 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */

//硬算是n*n的，使用的方法是两个乘积的方法，就是O(n)了，对两部分乘积进行控制

public class Offer51 {
	    public int[] multiply(int[] A) {
	    	int len=A.length;
	    	int[] result=new int[len];
	    	for(int i=0;i<len;i++){
	    		int j=len;
	    		int count=1;
	    		while(j-->0){
	    		if(j+i==len-1){
	    			continue;
	    		}
	    		count=count*A[len-j-1];
	    	}
	    		result[i]=count;
	    	}
	    	return result;
	    }
	    
	    public static void main(String[] args) {
			Offer51 offer51=new Offer51();
			int[] arr={1,2,3,4};
			for(int j:offer51.multiply(arr))
				System.out.println(j);
		}
}
