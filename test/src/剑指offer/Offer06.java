package 剑指offer;

/* 06旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

public class Offer06 {
	//这样是一个遍历O(n)的解法，并不优秀
	public int minNumberInRotateArray(int [] array) {
	    for(int i=0;i<array.length-1;i++){
	    	if(array[i]>array[i+1])
	    		return array[i+1];
	    }
	    return array[0];
    }
	
	//无情抄袭，本质是二分的
	public int minNumberInRotateArray2(int [] array) {
	    int low =0,high=array.length-1;
	    while(low<high){
	    	int mid=low+(high-low)/2;
	    	if(array[mid]>array[high])
	    		low=mid+1;
	    	else if(array[mid]==array[high]) //没有办法的一通操作，为了应付诸如{1,2,2,2,2}之类的情况，极限情况下会退化到O(n)
	    		high=high-1;
	    	else {
				high=mid;
			}
	    }
	    return array[low];
    }
}
