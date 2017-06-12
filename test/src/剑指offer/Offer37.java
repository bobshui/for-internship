package 剑指offer;

/* 37.数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。
 */

//书中解法，利用二分递归找到第一个k和最后一个k，复杂度是O(logn)

public class Offer37 {
	//二分查找无法确认具体位置，只能左右计数，本质还是O(n)的算法，与遍历一次没有区别？(我认为还是有区别的)
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
