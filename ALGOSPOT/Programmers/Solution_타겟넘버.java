package Programmers;

public class Solution_Å¸°Ù³Ñ¹ö {

	static boolean[] check;
	static int t, a;

	public static int solution(int[] numbers, int target) {
		check = new boolean[numbers.length];
		t = target;
		a = 0;

		findWay(numbers, 0, 0);

		return a;
	}

	public static void findWay(int[] numbers, int idx, int number) {

		if (idx == numbers.length) {
			if (number == t)
				a++;

			return;
		}

		if (!check[idx]) {
			check[idx] = true;
			findWay(numbers, idx + 1, number + numbers[idx]);
			findWay(numbers, idx + 1, number - numbers[idx]);
			check[idx] = false;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] { 1, 1, 1, 1, 1 }, 3));

	}
}
