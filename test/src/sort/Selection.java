package sort;

public class Selection {
	public static void SelectionSort(int[] arr) {
		int temp;
		int index;
		for(int i=0;i<arr.length-1;i++){
			index=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[index])
					index=j;
			}
			temp=arr[i];
			arr[i]=arr[index];
			arr[index]=temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 4, 6, 7, 2, 9, 5, 1, 3, 8 };
		SelectionSort(arr);
		for (int i : arr)
			System.out.println(i);
	}
}
