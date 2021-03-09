package BOJ_solve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1107_BruteForce {

	static boolean[] broken = new boolean[10];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int target = Integer.parseInt(br.readLine());
		int x = Integer.parseInt(br.readLine());

		int ans = Math.abs(100 - target);
		StringTokenizer st;
		if (x != 0) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
		}
		for (int i = 0; i <= 1000000; i++) {
			int len = check(i);
			if (len > 0) {
				ans = Math.min(Math.abs(target - i) + len, ans);
			}

		}
		System.out.println(ans);

	}

	public static int check(int num) {
		String s = String.valueOf(num);
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (broken[s.charAt(i) - '0'])
				return 0;
		}
		return len;
	}

}
