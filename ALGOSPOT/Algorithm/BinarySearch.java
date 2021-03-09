package Algorithm;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {99, 55, 44, 12, 21, 35, 67, 82, 73, 99};
		
		
		System.out.println(binarySearch(arr, 54));
		System.out.println(Arrays.toString(arr));
	}

	public static int binarySearch(int[] arr, int target) {

		Arrays.sort(arr);

		int start = 0;
		int end = arr.length-1;

		while (start <= end) {
			int sum = 0;
			int mid = (start + end) / 2;

			if (arr[mid] == target) {
				//찾으면 해당 값 인덱스 반환
				return mid;
			} else if (arr[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}
		// 못찾으면 -1
		return -1;

	}

}
