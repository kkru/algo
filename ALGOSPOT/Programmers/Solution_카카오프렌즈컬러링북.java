package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_카카오프렌즈컬러링북 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] map = { 
				{ 0, 1, 0},
				{ 1, 1, 0}, 
				{ 0, 0, 0} };
		System.out.println(Arrays.toString(solution(3, 3, map)));
	}

	static int M, N;

	public static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		M = m;
		N = n;

		int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[m][n];

		int area = 0;
		for (int y = 0; y < m; y++) {
			for (int x = 0; x < n; x++) {
				if (picture[y][x] != 0 && !visited[y][x]) {
					area = 1;
					numberOfArea++;
					q.clear();
					q.add(new int[] { y, x, picture[y][x] });
					visited[y][x] = true;
					while (!q.isEmpty()) {
						int[] temp = q.poll();

						for (int d = 0; d < 4; d++) {
							int ny = temp[0] + dir[d][0];
							int nx = temp[1] + dir[d][1];
							if (check(ny, nx) && !visited[ny][nx] && picture[ny][nx] == temp[2]) {
								area++;
								visited[ny][nx] = true;
								q.add(new int[] { ny, nx, picture[ny][nx] });
							}
						}
					}
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;

		return answer;

	}

	public static boolean check(int y, int x) {
		return y < M && x < N && y >= 0 && x >= 0;
	}

}
