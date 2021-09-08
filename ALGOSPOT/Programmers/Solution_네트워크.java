package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_네트워크 {

	static ArrayList<ArrayList<Integer>> map;
	static boolean[] check;
	static int answer;

	public int solution(int n, int[][] computers) {
		answer = 0;

		check = new boolean[n];

		map = new ArrayList<>();

		boolean flag = true;

		Queue<Integer> q = new LinkedList<Integer>();

		q.add(0);
		check[0] = true;

		while (!q.isEmpty()) {

			int num = q.poll();
			int[] net = computers[num];
			for (int i = 0; i < n; i++) {
				if (!check[i] && num != i && net[i] == 1) {
					q.add(i);
					check[i] = true;
				}
			}

			if (q.isEmpty()) {
				answer++;
				for (int i = 0; i < n; i++) {
					if (!check[i]) {
						q.add(i);
						check[i] = true;
						break;
					}
				}
			}

		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
