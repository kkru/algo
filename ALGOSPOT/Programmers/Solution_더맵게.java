package Programmers;

import java.util.PriorityQueue;

public class Solution_´õ¸Ê°Ô {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7));
	}

	public static int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

		for (int i = 0; i < scoville.length; i++) {
			queue.add(scoville[i]);
		}

		while (!queue.isEmpty()) {

			if (queue.peek() >= K) {
				break;
			}
			
			if (queue.size() == 1) {
				answer = -1;
				break;
			}

			int the_most_spicy = queue.poll();
			int second_spicy = queue.poll();

			int mixed_scoville = the_most_spicy + (second_spicy * 2);
			
			queue.add(mixed_scoville);

			answer++;
		}

		return answer;
	}
}
