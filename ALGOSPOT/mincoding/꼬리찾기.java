package mincoding;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ²¿¸®Ã£±â {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input;
		StringBuilder output = new StringBuilder();
		for(int i=0; i<3; i++) {
			input = br.readLine();
			output.append(input.charAt(input.length()-1));
		}
		System.out.println(output.toString());
	}

}
