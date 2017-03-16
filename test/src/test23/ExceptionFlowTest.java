package test23;



/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a> 
 * <br/>Copyright (C), 2001-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class ExceptionFlowTest
{
	public static void main(String[] args) 
	{
		String[] books = 
		{
			"���Java����",
			"������Java EE��ҵӦ��ʵս",
			"���Ajax����"
		};
		int i = 0;
		while(true)
		{
			try
			{
				System.out.println(books[i++]);
			}
			catch (IndexOutOfBoundsException ex)
			{
				//����ѭ��
				break;
			}
		}
	}
}
