import java.util.Arrays;
import java.util.Scanner;

public class Numb3rs {

	static int n, d, p, t;
	static double[][] cache;
	static int[][] map;
	static int[] degs;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		cache = new double[51][101];
		map = new int[51][51];
		degs = new int[51];
		
		int cases = sc.nextInt();
		while (cases-- > 0) {
			n = sc.nextInt();
			d = sc.nextInt();
			p = sc.nextInt();
			
			StringBuilder sb = new StringBuilder();
			
			for (double[] arr : cache) {
				Arrays.fill(arr, -1.0);
			}

			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1)
						sum++;
				}
				degs[i] = sum;
			}
			
			t = sc.nextInt();
			
			for(int i=0; i<t; i++) {
				sb.append(search(sc.nextInt(),d)).append(" ");
			}
			
			System.out.println(sb.toString());
			
		}
	}

	public static double search(int here, int days) {

		if (days == 0)
			return (here == p ? 1.0 : 0.0);

		if (cache[here][days] > -0.5)
			return cache[here][days];

		cache[here][days] = 0.0;
		for (int there = 0; there < n; there++) {
			if (map[here][there] > 0) {
				cache[here][days] += search(there, days - 1) / degs[there];
			}
		}

		return cache[here][days];

	}

}