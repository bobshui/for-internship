package test;
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
class DataWrap implements Comparable<DataWrap>
{
	int data;
	String flag;
	public DataWrap(int data, String flag)
	{
		this.data = data;
		this.flag = flag;
	}
	public String toString()
	{
		return data + flag;
	}
	//����dataʵ����������������DataWrap�Ĵ�С
	public int compareTo(DataWrap dw)
	{
		return this.data > dw.data ? 1 
			: (this.data == dw.data ? 0 : -1);
	}
}
public class MergeSort 
{
	//���ù鲢�����㷨������data�������� 
	public static void mergeSort(DataWrap[] data) 
	{
		//�鲢���� 
		sort(data , 0 , data.length - 1);
	}
	/** 
	 * ��������left��right��Χ������Ԫ�ؽ��й鲢���� 
	 * @param data �����������
	 * @param left �����������ĵ�һ��Ԫ������ 
	 * @param right ���������������һ��Ԫ�ص����� 
	 */ 
	private static void sort(DataWrap[] data
		 , int left, int right) 
	{ 
		if (left < right) 
		{
			//�ҳ��м�����
			int center = (left + right) / 2;
			//�����������еݹ�
			sort(data, left, center); 
			//���ұ�������еݹ�
			sort(data, center + 1, right); 
			//�ϲ�
			merge(data, left, center, right); 
			System.out.println(java.util.Arrays.toString(data));
		} 
	} 
	/** 
	 * ������������й鲢���鲢ǰ���������Ѿ����򣬹鲢����Ȼ���� 
	 * @param data ������� 
	 * @param left ������ĵ�һ��Ԫ�ص����� 
	 * @param center ����������һ��Ԫ�ص�������center+1���������һ��Ԫ�ص�����
	 * @param right ����������һ��Ԫ�ص����� 
	 */ 
	private static void merge(DataWrap[] data
		, int left, int center, int right) 
	{
		//����һ������������г�����ͬ����ʱ���� 
		DataWrap[] tmpArr = new DataWrap[data.length];
		int mid = center + 1;
		//third��¼�м����������
		int third = left; 
		int tmp = left; 
		while (left <= center && mid <= right) 
		{ 
			//������������ȡ��С�ķ����м����� 
			if (data[left].compareTo(data[mid]) <= 0) 
			{ 
				tmpArr[third++] = data[left++]; 
			} 
			else
			{
				tmpArr[third++] = data[mid++]; 
			}
		} 
		//ʣ�ಿ�����η����м����� 
		while (mid <= right) 
		{ 
			tmpArr[third++] = data[mid++]; 
		} 
		while (left <= center) 
		{ 
			tmpArr[third++] = data[left++]; 
		} 
		//���м������е����ݸ��ƿ���ԭ����
		//(ԭleft��right��Χ�����ݸ��ƻ�ԭ����) 
		while (tmp <= right)
		{
			data[tmp] = tmpArr[tmp++]; 
		}
	} 
	public static void main(String[] args)
	{
		DataWrap[] data = {
			new DataWrap(9 , ""),
			new DataWrap(-16 , ""),
			new DataWrap(-21 , "*"),
			new DataWrap(23 , ""),
			new DataWrap(-30 , ""),
			new DataWrap(49 , ""),
			new DataWrap(21 , ""),
			new DataWrap(31 , "*"),
			new DataWrap(30 , "")
		};
		System.out.println("����֮ǰ��\n"
			+ java.util.Arrays.toString(data));
		mergeSort(data);
		System.out.println("����֮��\n" 
			+ java.util.Arrays.toString(data));
	}
}