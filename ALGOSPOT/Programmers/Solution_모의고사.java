package Programmers;

import java.util.ArrayList;

public class Solution_모의고사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solution(int[] answers) {
		int[] answer = new int[3];

		char[][] patterns = new char[][] { "12345".toCharArray(), "21232425".toCharArray(),
				"3311224455".toCharArray() };

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < answers.length; i++) {
			sb.append(answers[i]);
		}

		char[] ans = sb.toString().toCharArray();
		int max = -1;
		for (int i = 0; i < 3; i++) {
			int gap = patterns[i].length;

			int pidx = 0;
			int cnt = 0;
			for (int j = 0; j < ans.length; j++) {
				if (pidx == gap) {
					pidx = 0;
				}
				if (patterns[i][pidx++] == ans[j]) {
					cnt++;
				}
			}
			answer[i] = cnt;
			if (cnt > max) {
				max = cnt;
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			if (answer[i] == max) {
				list.add(i + 1);
			}
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
