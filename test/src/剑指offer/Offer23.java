package 剑指offer;

/*23.二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 后序遍历：先左子树，然后右子树，最后根节点。
 * 二叉搜索树，右子树全部大于根节点，左子树全部小于根节点。
 */
public class Offer23 {
	public boolean VerifySquenceOfBST(int[] sequence) {
		if(sequence==null||sequence.length==0)
			return false;
		int len=sequence.length;
		int start=0;
		return isVerify(sequence,start,len-1);
	}

	public boolean isVerify(int[] sequence, int start, int end) {
		// TODO Auto-generated method stub
		if(start>=end)
			return true;
		int temp=sequence[end];
		int i=start;
		for(;i<end;i++){
			if(sequence[i]>temp)
				break;
		}
		int j=i;
		for(;j<end;j++){
			if(sequence[j]<temp)
				return false;
		}
		
		boolean left=true;
		if(i>0)
			left=isVerify(sequence, start, i-1);
		
		boolean right=true;
		if(i<end)
			right=isVerify(sequence, i, end-1);
		
		return left&&right;
	}
	
	public static void main(String[] args) {
		Offer23 offer23=new Offer23();
		int[] sequence={5,9,8};
		boolean flag =offer23.VerifySquenceOfBST(sequence);
		System.out.println(flag);
	}
}

