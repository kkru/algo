package Programmers;

public class Solution_멀쩡한사각형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcb(100000000, 100000000));
		System.out.println(solution(100000000, 100000000));
		long l = 100000000;
		System.out.println(l * l);
	}

	public static long gcb(int a, int b) {
		if (a % b == 0)
			return b;
		else
			return gcb(b, a % b);
	}

	public static long solution(int w, int h) {
		long answer = w * h;
		long minus = w + h - gcb(w, h);

		return answer - minus;
	}

}
