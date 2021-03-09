package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main11723_bitMasking {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int M = Integer.parseInt(br.readLine());

		int S = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= M; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input);

			String op = st.nextToken();
			
			if(op.equals("add")) {
				S = S | (1 << Integer.parseInt(st.nextToken()));
			}
			else if(op.equals("remove")) {
				S = S & ~(1 << Integer.parseInt(st.nextToken()));
			}
			else if(op.equals("check")) {
				int res = S & (1<< Integer.parseInt(st.nextToken()));
				if(res > 0) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
			}
			else if(op.equals("toggle")) {
				S = S ^ (1 << Integer.parseInt(st.nextToken()));
			}
			else if(op.equals("all")) {
				S = (1<< M)-1;
			}
			else {
				S = 0;
			}

		}
		
		System.out.println(sb.toString());
	}

}
