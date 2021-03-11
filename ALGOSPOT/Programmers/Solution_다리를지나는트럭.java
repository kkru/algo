package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_다리를지나는트럭 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(2, 10, new int[] { 7, 4, 5, 6 }));
		System.out.println(solution(100, 100, new int[] {10}));
		System.out.println(solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10}));

	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {

		int timer = 0;
		int nextTruck = 0;
		int curWeight = 0;

		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < bridge_length-1; i++) {
			q.add(0);
		}
		timer++;

		do {
			
			if (nextTruck < truck_weights.length && curWeight + truck_weights[nextTruck] <= weight) {
				curWeight += truck_weights[nextTruck];
				q.add(truck_weights[nextTruck]);
				nextTruck++;
			} else {
				q.add(0);
			}
			int top = q.poll();
			if (top > 0) {
				curWeight -= top;
			}
			timer++;
		} while (nextTruck < truck_weights.length || curWeight > 0);

		return timer;
	}

}
