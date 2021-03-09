package Algorithm;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {99, 55, 44, 12, 21, 35, 67, 82, 73, 99};
		
		quicksort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
		
	}

	public static void quicksort(int[] arr, int left, int right) {
		if (left >= right)
			return;

		int pivot = partition(arr, left, right);

		quicksort(arr, left, pivot - 1);
		quicksort(arr, pivot + 1, right);

	}

	public static int partition(int[] arr, int left, int right) {

		int pivot = arr[left];
		int i = left, j = right;

		while (i < j) {
			while (pivot < arr[j]) {
				j--;
			}
			while (i < j && pivot >= arr[i]) {
				i++;
			}
			swap(arr, i, j);
		}
		arr[left] = arr[i];
		arr[i] = pivot;
		
		return i;

	}
	
	public static void swap(int[] arr, int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}

}
