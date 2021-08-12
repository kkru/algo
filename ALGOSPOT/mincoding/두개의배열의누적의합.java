package mincoding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두개의배열의누적의합 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr1 = new int[4];
		int[] arr2 = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<4; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<4; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<4; i++) {
			sb.append(arr1[i]+arr2[3-i]).append(" ");
		}
		
		System.out.println(sb.toString());
		
	}

}
