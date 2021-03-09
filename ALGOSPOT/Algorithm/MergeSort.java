package Algorithm;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {99, 55, 44, 12, 21, 35, 67, 82, 73, 99};
		
		mergeSort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
		
	}

	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;

			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	public static void merge(int[] arr, int left, int mid, int right) {
		int[] L = Arrays.copyOfRange(arr, left, mid + 1);
		int[] R = Arrays.copyOfRange(arr, mid + 1, right + 1);

		int i = 0, j = 0, k = left;
		int ll = L.length, rl = R.length;
		
		while(i< ll && j < rl) {
			if(L[i] <= R[j])
				arr[k] = L[i++];
			else
				arr[k] = R[j++];
			
			k++;
		}
		
		//���°� ó��
		while(i<ll) {
			arr[k++] = L[i++];
		}
		while(j<rl) {
			arr[k++] = R[j++];
		}
		
	}

}
