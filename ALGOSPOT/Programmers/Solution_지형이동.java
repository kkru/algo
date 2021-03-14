package Programmers;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_지형이동 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] land = { { 1, 4, 8, 10 }, { 5, 5, 5, 5 }, { 10, 10, 10, 10 }, { 10, 10, 10, 20 } };

		System.out.println(solution(land, 3));
	}

	static int N;

	public static int solution(int[][] land, int height) {
		int answer = 0;

		N = land.length;

		final int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		boolean[][] visited = new boolean[N][N];
		Queue<int[]> q = new LinkedList<int[]>();
		Queue<int[]> dq = new LinkedList<int[]>();
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});

		visited[0][0] = true;
		q.add(new int[] { 0, 0 });

		while (!q.isEmpty() && dq.size() <= N * N) {
			int size = q.size();
			while (!q.isEmpty()) {
				int[] temp = q.poll();
				for (int d = 0; d < 4; d++) {
					int ny = temp[0] + dir[d][0];
					int nx = temp[1] + dir[d][1];

					if (check(ny, nx) && !visited[ny][nx]) {
						int cost = Math.abs(land[ny][nx] - land[temp[0]][temp[1]]);
						if(cost <= height) {
							q.add(new int[] {ny,nx});
							visited[ny][nx] = true;
						} else {
							pq.add(new int[] {cost, ny, nx});
						}
					}
				}
				dq.add(temp);
			}
			while(!pq.isEmpty()) {
				int[] temp = pq.poll();
				if(visited[temp[1]][temp[2]])
					continue;
				answer += temp[0];
				q.add(new int[] {temp[1],temp[2]});
				visited[temp[1]][temp[2]] = true;
				break;
			}
		}

		return answer;
	}

	public static boolean check(int y, int x) {
		return y < N && x < N && y >= 0 && x >= 0;
	}

}
