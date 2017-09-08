package 剑指offer;

/* 41 和为S的连续正数序列
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
import java.util.ArrayList;

public class Offer41 {
	//自己写的方法，不想看了
	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> arr1=new ArrayList<>();
		//ArrayList<Integer> arr2=new ArrayList<>();
		for(int i=(int)Math.sqrt(sum)*2;i>1;i--){
			if(i%2==0){
				if((sum*2)%i==0&&sum%i!=0&&sum/i>=i/2){
					ArrayList<Integer> arr2=new ArrayList<>();
					for(int j=0;j<i;j++){
						arr2.add(sum/i+j-i/2+1);
					}
					arr1.add(arr2);
				}
			}else{
				if(sum%i==0&&sum/i>i/2){
					ArrayList<Integer> arr2=new ArrayList<>();
					for(int j=0;j<i;j++){
						arr2.add(sum/i+j-i/2);
					}
					arr1.add(arr2);
				}
			}
		}
		return arr1;
    }
	
	//small和big依次查询的方法,类似左指针右指针
	public static void FindContinuousSequence2(int sum) {
		
		int small =1 ;
		int big = 2;
		int nowSum=small+big;
		int middle=(1+sum)/2;
		
		while(small<middle){
			if(nowSum==sum)
				System.out.println(small+"---"+big);
			
			while(nowSum>sum&&small<middle){
				nowSum=nowSum-small;
				small++;
				if(nowSum==sum)
					System.out.println(small+"---"+big);
			}
			
			big++;
			nowSum+=big;
		}
    }
	
	public static void main(String[] args) {
//		ArrayList<ArrayList<Integer>> arr1=new ArrayList<>();
//		arr1=FindContinuousSequence(3);
//		for(ArrayList<Integer> arr2:arr1){
//			for(Integer integer:arr2)
//				System.out.print(integer+"  ");
//			System.out.println();
//		}
		FindContinuousSequence2(100);
	}
}
