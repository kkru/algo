package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_기능개발 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(solution(new int[] {93,30,55}, new int[] {1,30,5})));
		
		System.out.println(Arrays.toString(solution(new int[] {95,90,99,99,80,99}, new int[] {1,1,1,1,1,1})));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		final int count = progresses.length;

		int[] answer = {};

		boolean[] check = new boolean[count];
		
		int[] schedule = new int[101];
		
		int timer = 0;
		int step = 0;
		while (step < count) {

			for (int i = 0; i < count; i++) {
				if (!check[i]) {
					progresses[i] += speeds[i];

					if (progresses[i] >= 100)
						check[i] = true;
				}
			}
			while(step < count && check[step]) {
				schedule[timer]++;
				step++;
			}
			timer++;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		int num = 0;
		for(int i=0; i<schedule.length; i++) {
			if(schedule[i]!=0) {
				q.add(schedule[i]);
				num++;
			}
		}
		answer = new int[num];
		for(int i=0; i<num; i++) {
			answer[i] = q.poll();
		}

		return answer;
	}

}
