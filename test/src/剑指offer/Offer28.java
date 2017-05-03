package 剑指offer;

import java.util.HashMap;
import java.util.Map;

public class Offer28 {

	public static int MoreThanHalfNum_Solution(int [] array){
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<array.length;i++){
			if(map.containsKey(array[i])){
				map.put(array[i],map.get(array[i])+1);
			}
			else
				map.put(array[i], 1);
		}
		for(Integer i : map.keySet()){
			if(map.get(i)>array.length/2)
				return (int)i;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		
	}
}
