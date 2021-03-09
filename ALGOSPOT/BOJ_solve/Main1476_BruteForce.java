package BOJ_solve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1476_BruteForce {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int e = 0, s = 0, m = 0, value = 0;

		while (value <= 15 * 28 * 19) {
			e++;
			s++;
			m++;
			if (e > 15) {
				e = 1;
			}
			if (s > 28) {
				s = 1;
			}
			if (m > 19) {
				m = 1;
			}
			value++;
			if (e == E && s == S && m == M) {
				System.out.println(value);
				break;
			}
		}

	}

}
