package test;

import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

	public class Test
	{
	    static boolean foo(char c)
	    {
	        System.out.print(c);
	        return true;
	    }
	    public static void main( String[] argv )
	    {
	        int i = 0;
	        for ( foo('A'); foo('B') && (i < 2); foo('C'))
	        {
	            i++ ;
	            foo('D');
	        }
	    }
	}
	
