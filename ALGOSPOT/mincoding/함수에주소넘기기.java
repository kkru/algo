package mincoding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 함수에주소넘기기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[][] arr = new int[2][3];
		
		int[] max = new int[3];
		max[0] = Integer.MIN_VALUE;
		int[] min = new int[3];
		min[0] = Integer.MAX_VALUE;
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] > max[0]) {
					max[0] = arr[i][j];
					max[1] = i;
					max[2] = j;
				}
				if(arr[i][j] < min[0]) {
					min[0] = arr[i][j];
					min[1] = i;
					min[2] = j;
				}
			}
		}
		
		System.out.printf("(%d,%d)\r\n", max[1],max[2]);
		System.out.printf("(%d,%d)", min[1],min[2]);
	}

}
