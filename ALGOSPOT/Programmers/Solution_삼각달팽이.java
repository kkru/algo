package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_ªÔ∞¢¥ﬁ∆ÿ¿Ã {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(solution(6)));

	}

	public static int[] solution(int n) {
		int[] answer = {};
		int[][] map = new int[n][n];
		boolean[][] visited = new boolean[n][n];

		int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, -1 } };

		Queue<int[]> q = new LinkedList<int[]>();
		Queue<Integer> list = new LinkedList<Integer>();

		q.add(new int[] { 0, 0, 0, 1 });
		list.add(1);
		map[0][0] = 1;
		visited[0][0] = true;

		int cnt = 1;
		while (!q.isEmpty()) {

			int[] temp = q.poll();
			cnt++;
			int ny = temp[0] + dir[temp[2]][0];
			int nx = temp[1] + dir[temp[2]][1];
			if (check(ny, nx, n) && !visited[ny][nx]) {
				map[ny][nx] = temp[3] + 1;
				q.add(new int[] { ny, nx, temp[2], temp[3] + 1 });
				visited[ny][nx] = true;
			} else {
				int next = 0;
				if (temp[2] == 0) {
					next = 1;
				} else if (temp[2] == 1) {
					next = 2;
				} else {
					next = 0;
				}
				ny = temp[0] + dir[next][0];
				nx = temp[1] + dir[next][1];

				if (check(ny, nx, n) && !visited[ny][nx]) {
					map[ny][nx] = temp[3] + 1;
					q.add(new int[] { ny, nx, next, temp[3] + 1 });
					visited[ny][nx] = true;
				}
			}

		}
		answer = new int[cnt-1];
		
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0) {
					answer[index++] = map[i][j];
				}
			}
		}

		return answer;
	}

	public static boolean check(int y, int x, int n) {
		return y < n && x < n && x >= 0 && y >= 0;
	}

}
