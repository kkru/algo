package mincoding;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 문장A추가하기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int num = Integer.parseInt(br.readLine());
		
		String front = s.substring(0, num);
		//System.out.println(front);
		String behind = s.substring(num, s.length());
		//System.out.println(behind);
		
		String output = front + "A" + behind;
		System.out.println(output);
	}

}
