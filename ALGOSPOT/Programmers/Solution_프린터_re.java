package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_«¡∏∞≈Õ_re {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(new int[] {1, 1, 9, 1, 1, 1}, 0);
	}

	public static int solution(int[] priorities, int location) {
		int answer = 0;

		Queue<int[]> qlist = new LinkedList<>();

		int[] rank = new int[10];

		int max = -1;

		for (int i = 0; i < priorities.length; i++) {
			qlist.add(new int[] { priorities[i], i });
			rank[priorities[i]]++;
			if (priorities[i] >= max) {
				max = priorities[i];
			}
		}

		int printed = 0;

		while (!qlist.isEmpty()) {
			int[] i = qlist.poll();

			if (max > i[0]) {
				qlist.add(i);
			} else {
				//System.out.println(i[1]);
				rank[i[0]]--;
				for (int j = max; j >= 0; j--) {
					if(rank[j] > 0) {
						max = j;
						break;
					}
				}

				printed++;
				if (i[1] == location) {
					answer = printed;
					break;
				}
			}
		}
		//System.out.println("ans : " + answer);
		return answer;
	}

}
