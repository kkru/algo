package Programmers;

import java.util.HashSet;

public class Solution_소수찾기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("011"));
	}

	public static int solution(String numbers) {
		int answer = 0;

		findNumbers(0, numbers.length(), numbers);

		for (int temp : set) {
			if (temp == 1 || temp == 0)
				continue;

			int num = (int) Math.sqrt(temp);
			boolean isDivided = false;
			for (int i = 2; i <= num; i++) {
				isDivided = temp % i == 0;
				//System.out.println(temp + "//" + i);
				if (isDivided)
					break;
			}
			if (!isDivided)
				answer++;
		}

		return answer;
	}

	static HashSet<Integer> set = new HashSet<Integer>();
	static String str = "";
	static boolean[] check = new boolean[7];

	public static void findNumbers(int depth, int limit, String numbers) {
		if (depth == limit)
			return;

		for (int i = 0; i < limit; i++) {
			if (!check[i]) {
				check[i] = true;
				str += String.valueOf(numbers.charAt(i));
				set.add(Integer.parseInt(str));
				findNumbers(depth + 1, limit, numbers);
				str = str.substring(0, str.length() - 1);
				check[i] = false;
			}
		}

	}

}
