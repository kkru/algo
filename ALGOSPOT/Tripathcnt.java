import java.util.Arrays;
import java.util.Scanner;

public class Tripathcnt {

	static int N;
	static int[][] cache;
	static int[][] cache2;
	static int[][] triangle;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cases = sc.nextInt();
		while (cases-- > 0) {
			N = sc.nextInt();
			cache = new int[100][100];
			cache2 = new int[100][100];
			triangle = new int[100][100];

			for (int i = 0; i < 100; i++) {
				Arrays.fill(cache[i], -1);
				Arrays.fill(cache2[i], -1);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					triangle[i][j] = sc.nextInt();
				}
			}
			
			System.out.println(count(0,0));
		}
	}

	public static int count(int y, int x) {
		if (y == N - 1)
			return 1;

		if (cache2[y][x] != -1)
			return cache2[y][x];
		cache2[y][x] = 0;

		if (path(y + 1, x + 1) >= path(y + 1, x))
			cache2[y][x] += count(y + 1, x + 1);
		if (path(y + 1, x + 1) <= path(y + 1, x))
			cache2[y][x] += count(y + 1, x);
		
		return cache2[y][x];
	}

	public static int path(int y, int x) {
		if (y == N - 1)
			return triangle[y][x];

		if (cache[y][x] != -1)
			return cache[y][x];

		return cache[y][x] = Math.max(path(y + 1, x), path(y + 1, x + 1)) + triangle[y][x];

	}

}