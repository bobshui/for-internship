package codinginterviews;

/* 61.序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Offer61 {
	public  int index=-1;
	  String Serialize(TreeNode root) {
		  StringBuilder sBuilder=new StringBuilder();
	        if(root==null){
	        	sBuilder.append("#,");
	        	return sBuilder.toString();
	        }
	        sBuilder.append(root.val+",");
	        sBuilder.append(Serialize(root.left));
	        sBuilder.append(Serialize(root.right));
	        return sBuilder.toString();
	  }
	    
	 TreeNode Deserialize(String str) {
	       index++;
	       if(index>=str.length())
	    	   return null;
	       String[] strs = str.split(",");
	       TreeNode root=null;
	       if(!strs[index].equals("#")){
	    	   root = new TreeNode(Integer.valueOf(strs[index]));
	    	   root.left=Deserialize(str);
	    	   root.right=Deserialize(str);
	       }
	       return root;
	  }
}
