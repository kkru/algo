package BOJ_solve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Shark {
		int y, x;
		int size;
		int cnt;

		public Shark(int y, int x) {
			this.y = y;
			this.x = x;
			this.size = 2;
			this.cnt = 0;
		}
	}

	static int n;
	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int ans;
	static Shark baby;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[n][n];
		Queue<int[]> q = new LinkedList<int[]>();
		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < n; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == 9) {
					baby = new Shark(y, x);
					q.add(new int[] { y, x });
					map[y][x] = 0;
				}
			}
		}

		int time = 0;
		boolean[][] visited = new boolean[n][n];
		visited[baby.y][baby.x] = true;

		boolean eat = false;
		while (!q.isEmpty()) {
			int qsize = q.size();
			time++;
			int mx = n;
			int my = n;
			for (int i = 0; i < qsize; i++) {
				int[] temp = q.poll();
				for (int d = 0; d < 4; d++) {
					int ny = temp[0] + dir[d][0];
					int nx = temp[1] + dir[d][1];
					if (chkIdx(ny, nx) && !visited[ny][nx]) {
						if (map[ny][nx] < baby.size && map[ny][nx] != 0) {
							visited[ny][nx] = true;
							if (my > ny) {
								my = ny;
								mx = nx;
								eat = true;
							}
						} else if (map[ny][nx] <= baby.size) {
							visited[ny][nx] = true;
							q.add(new int[] { ny, nx });
						}
					}
				} // d < 4
			} // i < qsize
			if (eat) {
				q.clear();
				ans += time;
				time = 0;
				baby.y = my;
				baby.x = mx;
				baby.cnt++;
				if (baby.size == baby.cnt) {
					baby.cnt = 0;
					baby.size++;
				}
				map[baby.y][baby.x] = 0;
				visited = new boolean[n][n];
				visited[baby.y][baby.x] = true;
				q.add(new int[] { baby.y, baby.x });
				eat = false;
				//System.out.println(ans + "//Eat " + baby.y + ", " + baby.x + " size :" + baby.size);
			}
		} // q.isEmpty()
		System.out.println(ans);

	}

	public static boolean chkIdx(int y, int x) {
		return y >= 0 && x >= 0 && y < n && x < n;
	}

}
