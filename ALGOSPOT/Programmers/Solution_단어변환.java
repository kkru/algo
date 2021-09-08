package Programmers;

import java.util.Arrays;

public class Solution_단어변환 {

	static int answer;
	static boolean found = false;
	static boolean[] check;

	public static int solution(String begin, String target, String[] words) {
		answer = 50;
		check = new boolean[words.length];

		convert(begin, target, words, 0);

		return answer == 50 ? 0 : answer;
	}

	public static void convert(String str, String target, String[] words, int cnt) {

		if (str.equals(target)) {
			answer = Math.min(answer, cnt);
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (check[i])
				continue;
			check[i] = true;
			int c = 0;
			for (int j = 0; j < words[i].length(); j++) {
				if (str.charAt(j) - words[i].charAt(j) != 0) {
					c++;
				}
			}
			if (c == 1) {
				convert(words[i], target, words, cnt + 1);
			}
			check[i] = false;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(solution(begin, target, words));
	}

}
