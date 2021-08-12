package mincoding;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 내가_좋아하는_문자의_수 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = {
				{ 'A', 'B', 'K', 'T'},
				{ 'K', 'F', 'C', 'F'},
				{ 'B', 'B', 'Q', 'Q'},
				{ 'T', 'P', 'Z', 'F'}
		};
		
		String s = br.readLine();
		char c1 = s.charAt(0);
		
		char c2 = s.charAt(2);
		int cnt = 0;
		
		for(int i =0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(map[i][j] == c1 || map[i][j] == c2) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
