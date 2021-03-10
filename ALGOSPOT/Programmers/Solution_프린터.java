package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_«¡∏∞≈Õ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 1, 9, 1, 1, 1 };

		System.out.println(solution(arr, 0));

		int[] arr2 = { 2, 1, 3, 2 };

		System.out.println(solution(arr2, 2));

	}

	public static int solution(int[] priorities, int location) {
		int answer = location;

		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < priorities.length; i++) {
			list.add(priorities[i]);
		}

		while (list.size() > 0) {
			int top = list.get(0);

			boolean flag = false;

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) > top) {
					list.remove(0);
					list.add(top);
					flag = true;
					answer--;
					if(answer == -1) {
						answer = list.size()-1; 
					}
					break;
				}
			}
			if (!flag) {
				q.add(top);
				list.remove(0);
				answer--;
				if(answer == -1) {
					answer = q.size();
					break;
				}
			}
		}

		return answer;
	}

}
