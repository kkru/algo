package Programmers;

public class Solution_124나라의숫자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 1; i <= 16; i++)
			System.out.println(solution(i));
	}

	public static String solution(int n) {
		StringBuilder answer = new StringBuilder();

		int modBy3;

		while (n > 0) {
			modBy3 = n % 3;
			n = n / 3;

			if (modBy3 == 0) {
				answer.append(4);
				n--;
			} else {
				answer.append(modBy3);
			}
		}

		return answer.reverse().toString();
	}

}
