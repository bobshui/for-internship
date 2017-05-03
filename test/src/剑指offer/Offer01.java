package 剑指offer;


/* 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

public class Offer01 {
	//考查的就是一个思路
	public static boolean Find(int target, int [][] array) {
		int a = array.length; //行
		int b = array[0].length;  //列
		int arr=0,col=b-1;
		boolean flag=false;
		while(arr<a&&col>=0){
			if(array[arr][col]>target){
				col--;
				continue;
			}
			if(array[arr][col]<target){
				arr++;
				continue;
			}
			if(array[arr][col]==target){
				flag=true;
				break;
			}
		}
		return flag;
    }
	
	public static void main(String[] args) {
		int[][] array={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		int a =5;
		System.out.println(Offer01.Find(a, array));
	}
}
