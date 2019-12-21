import java.util.Scanner;

public class Jumpgame {

	static int[][] map, cache;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cases = sc.nextInt();
		while (cases-- > 0) {
			N = sc.nextInt();
			map = new int[N][N];
			cache = new int[N][N];
			
			for(int y=0; y<N; y++) {
				for(int x=0; x<N; x++) {
					map[y][x] = sc.nextInt();
					cache[y][x] = -1;
				}
			}

			System.out.println(jump(0,0) ? "YES" : "NO");
		}
	}

	public static boolean jump(int y, int x) {

		if (y >= N || x >= N)
			return false;
		if (y == N - 1 && x == N - 1)
			return true;

		if (cache[y][x] == 1)
			return false;
		else
			cache[y][x] = 1;

		int jumpSize = map[y][x];
		return jump(y, x + jumpSize) || jump(y + jumpSize, x);
	}

}