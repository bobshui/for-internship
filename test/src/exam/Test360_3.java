package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Test360_3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String n = in.nextLine();
		char[] cs = n.toCharArray();

		int count = 0;
		int i = 2;
		Map<Character, Integer> map = new HashMap<>();
		while (i <=cs.length) {
			for (int j = 0; j < cs.length - i + 1; j++) {
				int temp = i;
				int k = j;
				while (temp-- > 0) {
					if (map.containsKey(cs[k]))
						map.put(cs[k], map.get(cs[k]) + 1);
					else
						map.put(cs[k], 1);
					k++;
				}
				int flag = 1;
				for (Entry<Character, Integer> entry : map.entrySet()) {
					if (entry.getValue() % 2 != 0) {
						flag = 0;
						break;
					}
				}
				map.clear();
				count += flag;
			}
			i=i+2;
		}
		System.out.println(count);
		in.close();
	}

}
