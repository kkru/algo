package Programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution_이중우선순위큐 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(solution(new String[] {"I 1","I 0","D 1","D 1","I -1"})));
	}

	public static int[] solution(String[] operations) {
		int[] answer = { 0, 0 };

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		int inserted = 0;
		int removed = 0;

		for (int i = 0; i < operations.length; i++) {
			String command = operations[i];

			if (command.charAt(0) == 'I') {
				int d = Integer.parseInt(command.substring(2));
				inserted++;
				pq.add(d);
				pq2.add(d);
			}
			if (command.charAt(0) == 'D' && pq.size() > 0) {
				if (command.charAt(2) == '-') {
					pq.poll();
					removed++;
				} else {
					pq2.poll();
					removed++;
				}
				if(removed == inserted) {
					pq.clear();
					pq2.clear();
				}
			}
		}
		if (pq.size() > 0 && inserted > removed) {
			answer[1] = pq.poll();
		}
		if (pq2.size() > 0 && inserted > removed) {
			answer[0] = pq2.poll();
		}
		return answer;
	}
}
