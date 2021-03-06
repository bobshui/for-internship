package 暑期实习生2018;
/*
 * Paragraph
 * 
 * 题目描述：
 * 给定一个段落，由 N 个句子组成。第 i 个句子的长度为 L[i]，包含的单词个数为 W[i]。
 * 句子不包含任何除字母和空格( ) 外的符号。
 * 每个句子内部，含有若干个单词，由空格( ) 分隔。句子不会包含连续的空格。
 * 
 * 随后给定 M 个查询，每个查询包含一个句子，需要在段落中寻找相同单词数量最多的句子。重复的单词只计一次，且不区分大小写。
 * 输入数据将保证结果是存在且唯一的。
 * 
 * 输入
 * 第一行是两个整数 N 和 M。
 * 接下来的 N+M 行，每行包含一个句子。
 * 前 N 行代表段落中的句子，后 M 行表示查询。
 * 
 * 输出
 * 输出 M 行，每行代表查询的结果。
 * 
 * 样例输入
 * 6 3
 * An algorithm is an effective method that can be expressed within a finite amount of space and time
 * Starting from an initial state and initial input the instructions describe a computation
 * That when executed proceeds through a finite number of successive states
 * Eventually producing output and terminating at a final ending state
 * The transition from one state to the next is not necessarily deterministic
 * Some algorithms known as randomized algorithms incorporate random input
 * Next to the transition
 * Wormhole infinite time and space
 * The transition from one state to the next is not necessarily deterministic
 * 
 * 样例输出
 * The transition from one state to the next is not necessarily deterministic
 * An algorithm is an effective method that can be expressed within a finite amount of space and time
 * The transition from one state to the next is not necessarily deterministic
 * 
 * Hint
 * 数据规模
 * 0 < L[i] < 512
 * 0 < W[i] < 32
 * 对于 30% 的数据，0 < N < 30，0 < M < 30。
 * 对于 100% 的数据，0 < N <= 600，0 < M <= 800。
 */

import java.util.Scanner;

//复杂度虽然很高，但是通过40%，逻辑和大小写貌似都有问题
public class TestToutiao_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		String[] para=new String[n];
		for(int i=0;i<n;i++){
			para[i]=sc.nextLine().toLowerCase();
		}
		
		for(String s:para)
			System.out.println(s);
		
		String[] strings=new String[m];
		for(int i=0;i<m;i++){
			strings[i]=sc.nextLine().toLowerCase();
		}
		
		sc.close();
		
		for(int i=0;i<m;i++){
			String[] split1=strings[i].split(" ");
			int result=0;
			int position=0;
			for(int j=0;j<n;j++){
				int count=0;
				String[] split2=para[j].split(" ");
				for(int k=0;k<split1.length;k++){
					for(int l=0;l<split2.length;l++){
						if(split1[k].equals(split2[l])){
							count++;
							break;
						}
					}
				}
				if(count>result){
					System.out.println(count);
					result=count;
					position=j;
				}
			}
			System.out.println(para[position]);
		}
	}

}
