import java.util.Scanner;

public class JLIS {

	static int N, M;
	static int[] A, B;
	static int[][] cache;
	static long ninf = Long.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cases = sc.nextInt();
		while (cases-- > 0) {
			N = sc.nextInt();
			M = sc.nextInt();
			A = new int[N];
			B = new int[M];
			cache = new int[101][101];

			for (int i = 0; i < 101; i++) {
				for (int j = 0; j < 101; j++) {
					cache[i][j] = -1;
				}
			}

			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}
			
			System.out.println(getjlis(-1,-1)-2);

		}
	}

	public static int getjlis(int indexA, int indexB) {

		if (cache[indexA + 1][indexB + 1] != -1)
			return cache[indexA + 1][indexB + 1];

		cache[indexA + 1][indexB + 1] = 2;

		long a = (indexA == -1 ? ninf : A[indexA]);
		long b = (indexB == -1 ? ninf : B[indexB]);

		long max = Math.max(a, b);

		for (int nextA = indexA + 1; nextA < N; nextA++) {
			if (max < A[nextA]) {
				cache[indexA + 1][indexB + 1] = Math.max(cache[indexA + 1][indexB + 1], getjlis(nextA, indexB) + 1);
			}
		}
		for (int nextB = indexB + 1; nextB < M; nextB++) {
			if (max < B[nextB]) {
				cache[indexA + 1][indexB + 1] = Math.max(cache[indexA + 1][indexB + 1], getjlis(indexA, nextB) + 1);
			}
		}

		return cache[indexA + 1][indexB + 1];
	}

}