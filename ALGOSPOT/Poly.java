import java.util.Arrays;
import java.util.Scanner;

public class Poly {

	static final int mod = 10000000;
	static int n;
	static int[][] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		cache = new int[101][101];

		int cases = sc.nextInt();
		while (cases-- > 0) {
			n = sc.nextInt();

			for (int[] arr : cache) {
				Arrays.fill(arr, -1);
			}

			int sum = 0;
			
			for(int i=1; i<=n; i++) {
				sum += poly(n, i);
				sum %= mod;
			}
			
			System.out.println(sum);
		}
	}

	public static int poly(int n, int first) {

		if (n == first)
			return 1;

		if (cache[n][first] != -1)
			return cache[n][first];

		cache[n][first] = 0;

		for (int second = 1; second <= n - first; second++) {
			int add = second + first - 1;
			add *= poly(n - first, second);
			add %= mod;
			cache[n][first] += add;
			cache[n][first] %= mod;
		}

		return cache[n][first];

	}

}