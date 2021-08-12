package mincoding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳순서대로배열채우기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] arr = new char[6][3];
		
		char c = 'A';
		
		for(int i=2; i>=0; i--) {
			for(int j=5; j>=0; j--) {
				arr[j][i] = c++;
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		System.out.println(arr[y][x]);
		
	}

}
