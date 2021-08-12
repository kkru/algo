package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_기능개발_re {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 })));

		System.out.println(
				Arrays.toString(solution(new int[] { 95, 90, 99, 99, 80, 99 }, new int[] { 1, 1, 1, 1, 1, 1 })));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int timer = 0;

		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < progresses.length; i++) {
			q.add(new int[] { progresses[i], speeds[i], i });
		}

		ArrayList<int[]> deploy = new ArrayList<>();

		while (!q.isEmpty()) {
			timer++;
			int q_count = q.size();
			for (int i = 0; i < q_count; i++) {
				int[] progress = q.poll();
//				System.out.println(timer + "/" + progress[0]);
				progress[0] += progress[1];
				if (progress[0] >= 100) {
					deploy.add(new int[] { progress[2], timer });
//					System.out.println(progress[2] + " / " + timer);
				} else {
					q.add(progress);
				}
			}
		}

		deploy.sort(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}

		});

		ArrayList<Integer> answerList = new ArrayList<Integer>();

		for (int i = 0; i < deploy.size(); i++) {
			System.out.println(Arrays.toString(deploy.get(i)));
		}

		for (int i = 0; i < deploy.size();) {
			int[] completed = deploy.get(i);
			int cnt = 0;
			for (int j = i; j < deploy.size(); j++) {
				if (i == deploy.size() - 1) {
					answerList.add(1);
					i++;
					break;
				}

				int[] nextProgress = deploy.get(j);
				if (completed[1] >= nextProgress[1]) {
					cnt++;
					if (j == deploy.size() - 1) {
						answerList.add(cnt);
						i = j + 1;
						break;
					}
					continue;
				} else {
					i = j;
					answerList.add(cnt);
					break;
				}
			}
		}

		return answerList.stream().mapToInt(Integer::intValue).toArray();
	}

}
