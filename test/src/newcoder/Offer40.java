package newcoder;

/*
 * 书中要求时间复杂度为O(n),空间复杂度为O(1),采用的异或来实现
 */
import java.util.HashSet;
import java.util.Set;

public class Offer40 {
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		 Set<Integer> set=new HashSet<>();
		 for(int i=0;i<array.length;i++){
			 if(set.contains(array[i]))
				 set.remove(array[i]);
				else
			 set.add(array[i]);
		 }
		 int[] newarr={0,0};
		 int j=0;
		 for(Integer integer:set){
			 newarr[j]=integer;
		 j++;
		 }
		 num1[0]=newarr[0];
		 num2[0]=newarr[1];
	}
}
