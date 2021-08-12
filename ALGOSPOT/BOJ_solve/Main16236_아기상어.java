package BOJ_solve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16236_아기상어 {

	static int N;
	static int[][] MAP;
	static int time;
	static int ans;

	static Shark baby;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Shark {
		int y, x;
		int size;
		int cnt;

		public Shark(int y, int x) {
			// TODO Auto-generated constructor stub
			this.y = y;
			this.x = x;
			size = 2;
			cnt = 0;
		}
	}

	static class Fish {
		int y, x;

		public Fish(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		MAP = new int[N][N];

		StringTokenizer st;
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				int d = Integer.parseInt(st.nextToken());
				MAP[y][x] = d;
				if (d == 9) {
					baby = new Shark(y, x);
					MAP[y][x] = 0;
				}
			}
		}
		boolean flag = true;
		while (flag) {
			Fish fish = new Fish(N, N);
			Queue<int[]> q = new LinkedList<int[]>();
			boolean[][] visited = new boolean[N][N];
			visited[baby.y][baby.x] = true;
			q.add(new int[] { baby.y, baby.x, baby.size, 0 });
			boolean find = false;
			time = 0;
			while (!q.isEmpty()) {
				time++;
				int qsize = q.size();
				for (int i = 0; i < qsize; i++) {
					int[] temp = q.poll();
					for (int d = 0; d < 4; d++) {
						int ny = temp[0] + dir[d][0];
						int nx = temp[1] + dir[d][1];

						if (chkidx(ny, nx) && !visited[ny][nx]) {
							if (MAP[ny][nx] > temp[2])
								continue;
							if (MAP[ny][nx] == temp[2] || MAP[ny][nx] == 0) {
								visited[ny][nx] = true;
								q.add(new int[] { ny, nx, temp[2], temp[3] + 1 });
							} else if (MAP[ny][nx] < temp[2]) {
								visited[ny][nx] = true;
								if (fish.y > ny) {
									fish.y = ny;
									fish.x = nx;
									find = true;
								}
							}
						}
					}
				}

				if (find) {
					ans += time;
					MAP[fish.y][fish.x] = 0;
					baby.y = fish.y;
					baby.x = fish.x;
					baby.cnt++;
					if (baby.cnt == baby.size) {
						baby.cnt = 0;
						baby.size++;
					}
					break;
				}
			}
			if (!find) {
				break;
			}
		}
		System.out.println(ans);
	}

	public static boolean chkidx(int y, int x) {
		return y < N && x < N && x >= 0 && y >= 0;
	}

}
