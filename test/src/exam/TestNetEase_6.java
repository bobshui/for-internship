package exam;


import java.util.Scanner;

/*
 * 现在有n位工程师�?6项工�?(编号�?0�?5)，现在给出每个人能够胜任的工作序号表(用一个字符串表示，比如：045，表示某位工程师能够胜任0号，4号，5号工�?)�?
 * 现在�?要进行工作安排，每位工程师只能被安排到自己能够胜任的工作当中去，两位工程师不能安排到同一项工作当中去�?
 * 如果两种工作安排中有�?个人被安排在的工作序号不�?样就被视为不同的工作安排，现在需要计算出有多少种不同工作安排计划�? 
 * 
 * 输入描述:
 * 输入数据有n+1行：
 * 第一行为工程师人数n(1 �? n �? 6)
 * 接下来的n行，每行�?个字符串表示第i(1 �? i �? n)个人能够胜任的工�?(字符串不�?定等长的)
 * 
 * 输出描述:
 * 输出�?个整数，表示有多少种不同的工作安排方�?
 * 
 * 输入例子:
 * 6
 * 012345 
 * 012345
 * 012345 
 * 012345
 * 012345
 * 012345
 *  
 * 输出例子:
 * 720
 */

public class TestNetEase_6 {

	private static int count = 0,n=0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int[][] nums = new int[n][6];
		in.nextLine();
		for (int i = 0; i < n; i++) {
			String str=in.nextLine();
			char[] chars = str.toCharArray();
			for (int j = 0; j < chars.length; j++)
				nums[i][chars[j] - '0'] = 1;
		}
		in.close();

		boolean[] visited = new boolean[6]; // 六项工作
		dfs(nums, 0, visited);
		System.out.println(count);
	}

	public static void dfs(int[][] nums, int index, boolean[] visited) {
		if (index == n) {
			count++;
			return;
		}
		for (int i = 0; i < 6; i++) {
			if (!visited[i] && nums[index][i] == 1) {
				visited[i] = true;
				dfs(nums, index + 1, visited);
				visited[i] = false;
			}
		}
	}

}
