package 剑指offer;

import java.util.ArrayList;
import java.util.List;

public class Offer46 {
	public int LastRemaining_Solution(int n, int m) {
		if(m==0||n==0)
			return -1;
		List<Integer> list = new ArrayList<>();
		int count = -1;
		for (int i = 0; i <n; i++)
			list.add(i);
		while (list.size() > 1) {
			count = (count + m) % n;
			list.remove(count);
			count--;
			n=n-1;
		}
		return list.get(0);
	}
}
