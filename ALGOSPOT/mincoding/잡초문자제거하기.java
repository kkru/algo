package mincoding;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 잡초문자제거하기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int idx = Integer.parseInt(br.readLine());
		
		String output = s.substring(0, idx) + s.substring(idx+1, s.length());
		
		System.out.println(output);
		
	}

}
