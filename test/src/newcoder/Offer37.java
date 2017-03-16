package newcoder;

public class Offer37 {
	 public static int GetNumberOfK(int [] array , int k) {
	       int low=0,high=array.length-1;
	       int mid=0;
	       int count=0;
	       while(low<high){
	    	   mid=(low+high)/2;
	    	   if(array[mid]==k)
	    		   break;
	    	   else if(array[mid]<k)
	    		   low=mid+1;
	    	   else 
	    		   high=mid-1;
	       }
	       int i,j;
	       for(j=mid;j<array.length-1;j++)
	    	   if(array[j]==k)
	    		   count++;
	    	   else {
				break;
			}
	       for(i=mid-1;i>=0;i--)
	    	   if(array[i]==k)
	    		   count++;
	    	   else {
				break;
			}
	       return count;
	    }
	 
	 public static void main(String[] args) {
		int [] array={3,3,3,3,4,5};
		System.out.println(GetNumberOfK(array, 3));
	}
}
