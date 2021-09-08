package Programmers;

public class Solution_Ä«Æê {

	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];

		int length = 0, height = 0;

		for (int i = 3; i <= brown; i++) {
			height = i;
			for (int j = i; j <= brown; j++) {
				if (2 * i + 2 * j - 4 == brown && i * j - brown == yellow) {
					length = j;
					i = brown;
				}
			}
		}

		answer[0] = length;
		answer[1] = height;

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
