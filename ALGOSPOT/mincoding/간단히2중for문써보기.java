package mincoding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 간단히2중for문써보기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[3];
		
		for(int i=0; i<3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int min = arr[0];
		int max = arr[1];
		int cnt = arr[2];
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<cnt ; i++) {
			for(int j=min; j<=max; j++){
				sb.append(j).append(" ");
			}
			sb.append("\r\n");
		}
		System.out.println(sb.toString());

	}

}
