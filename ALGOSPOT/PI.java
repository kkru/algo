import java.util.Arrays;
import java.util.Scanner;

public class PI {

	static int INF = 987654321;
	static String N;
	static int cache[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cases = sc.nextInt();
		while (cases-- > 0) {
			N = sc.next();
			cache = new int[10002];
			Arrays.fill(cache, -1);
			System.out.println(memorize(0));
		}
	}

	public static int classify(int a, int b) {
//		System.out.println(a + "//" + b);
		String M = N.substring(a, b+1);
//		System.out.println(M);
		char[] case_1 = new char[M.length()];
		Arrays.fill(case_1, M.charAt(0));

		if (M.equals(new String(case_1)))
			return 1;

		boolean progressive = true;
		for (int i = 0; i < M.length() - 1; i++) {
			if (M.charAt(i + 1) - M.charAt(i) != M.charAt(1) - M.charAt(0))
				progressive = false;
		}

		if (progressive && Math.abs(M.charAt(1) - M.charAt(0)) == 1)
			return 2;

		boolean alternating = true;
		for (int i = 0; i < M.length(); i++) {
			if (M.charAt(i) != M.charAt(i % 2))
				alternating = false;
		}
		if (alternating)
			return 4;
		if (progressive)
			return 5;

		return 10;
	}

	public static int memorize(int begin) {
		if (begin == N.length())
			return 0;

		if (cache[begin] != -1)
			return cache[begin];

		cache[begin] = INF;
		for (int l = 3; l <= 5; l++) {
			if (begin + l <= N.length()) {
				cache[begin] = Math.min(cache[begin],
						memorize(begin + l) + classify(begin, begin + l - 1));
			}
		}

		return cache[begin];
	}

}