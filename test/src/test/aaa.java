package test;

import java.util.LinkedList;

public class aaa {
	public static void main(String[] args) {
		LinkedList<Integer> help=new LinkedList<Integer>();
		int n=6;
	    for(int i=n;i>=1;i--){
	        help.addFirst(i);
	        help.addFirst(help.removeLast());
	        for(int j:help)
		    	System.out.print(j+"");
	        System.out.println();
	    }
	    //return help;
	    
	}
	
}
