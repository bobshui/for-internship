package codinginterviews;

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
