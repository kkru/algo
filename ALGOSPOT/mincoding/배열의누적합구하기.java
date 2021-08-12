package mincoding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열의누적합구하기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[6];
		StringBuilder sb = new StringBuilder();
		
		arr[0] = Integer.parseInt(st.nextToken());
		
		for(int i =1; i<6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			arr[i] = arr[i] + arr[i-1];
		}
		
		for(int i=0; i<6; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

}
