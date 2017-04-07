package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestHuawei_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] strings = s.split(",");
		sc.close();
		int[] arr = new int[3];
		for (int i = 0; i < 3; i++) {
			// 找出非法字符的异常
			try {
				arr[i] = Integer.valueOf(strings[i]);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(-1);
				return;
			}
		}
		if (arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) {
			System.out.println(-1);
			return;
		}

		ArrayList<Integer> arrayList = new ArrayList<>();

		int tempcount = arr[0] > arr[1] ? arr[0] : arr[1];
		int count = arr[2] > tempcount ? arr[2] : tempcount;
		
		//arrayList = getlist(arr);
		int temp=-1;
		int temp1=-1;
		for(int i=0;i<3;i++){
			if(arr[i]==2){
				temp=i;
			}
			if(arr[i]==5){
				temp=i;
			}
			if(arr[i]==6){
				temp1=i;
			}
			if(arr[i]==9){
				temp1=i;
			}
		}
		if(temp==-1&&temp1==-1)
			arrayList=getlist(arr);
		if(temp!=-1&&temp1!=-1){
			//arrayList=getlist(arr);
			arr[temp]=2;
			arrayList=getlist(arr);
			arr[temp]=5;
			arrayList.addAll(getlist(arr));
			arr[temp1]=6;
			arrayList=getlist(arr);
			arr[temp1]=9;
			arrayList.addAll(getlist(arr));
		}
		if(temp!=-1){
			arr[temp]=2;
			arrayList=getlist(arr);
			arr[temp]=5;
			arrayList.addAll(getlist(arr));
		}
		if(temp1!=-1){
			arr[temp1]=6;
			arrayList=getlist(arr);
			arr[temp1]=9;
			arrayList.addAll(getlist(arr));
		}

		ArrayList<Integer> result = new ArrayList<>();
		Collections.sort(arrayList);
		for (int num : arrayList) {
			if (!result.contains(num))
				result.add(num);
		}

	
		System.out.println(result.get(count - 1));

	}

	private static ArrayList<Integer> getlist(int[] arr) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arrayList = new ArrayList<>();
		// 1位
		for (int i = 0; i < 3; i++)
			arrayList.add(arr[i]);
		// 2位
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j != i)
					arrayList.add(arr[i] * 10 + arr[j]);
			}
		}
		// 3位
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if (j != i && k != i && k != j)
						arrayList.add(arr[i] * 100 + arr[j] * 10 + arr[k]);
				}
			}
		}

		// 输出

		return arrayList;
	}
}
