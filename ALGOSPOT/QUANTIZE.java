import java.util.Arrays;
import java.util.Scanner;

public class QUANTIZE {

	static int N, S;
	static int[] list, psum, psqsum;
	static final int INF = 987654321;
	static int[][] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cases = sc.nextInt();
		while (cases-- > 0) {
			N = sc.nextInt();
			S = sc.nextInt();
			cache = new int[101][11];
			list = new int[N];
			psum = new int[N];
			psqsum = new int[N];

			for (int i = 0; i < 101; i++) {
				Arrays.fill(cache[i], -1);
			}

			for (int i = 0; i < N; i++) {
				list[i] = sc.nextInt();
			}

			precalc();
			System.out.println(quantize(0, S));
		}
	}

	public static void precalc() {
		Arrays.sort(list);
		psum[0] = list[0];
		psqsum[0] = list[0] * list[0];
		for (int i = 1; i < N; i++) {
			psum[i] = psum[i - 1] + list[i];
			psqsum[i] = psqsum[i - 1] + list[i] * list[i];
		}
	}

	public static int minError(int lo, int hi) {
		int ret = 0;

		int sum = psum[hi] - (lo == 0 ? 0 : psum[lo - 1]);
		int sqsum = psqsum[hi] - (lo == 0 ? 0 : psqsum[lo - 1]);

		int m = (int) (0.5 + (double)sum / (hi - lo + 1));

		ret = sqsum - 2 * m * sum + m * m * (hi - lo + 1);

		return ret;
	}

	public static int quantize(int from, int parts) {
		if (from == N)
			return 0;

		if (parts == 0)
			return INF;

		if (cache[from][parts] != -1)
			return cache[from][parts];

		int ret = INF;

		for (int partsize = 1; from + partsize <= N; partsize++) {
			ret = Math.min(ret, minError(from, from + partsize - 1) + quantize(from + partsize, parts - 1));
			cache[from][parts] = ret;
		}

		return ret;
	}

}