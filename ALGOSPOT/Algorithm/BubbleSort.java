package Algorithm;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 55, 44, 12, 21, 35, 67, 82, 73, 99};
		
		bubbleSort(arr);
		
	}
	
	public static void bubbleSort(int[] arr) {
		int temp = 0;
		
		for(int i=0; i<arr.length; i++) {
			for (int j=1; j<arr.length-1; j++) {
				if(arr[j-1] > arr[j]) {
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
