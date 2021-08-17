package Programmers;

import java.util.Arrays;
import java.util.Stack;

public class Solution_주식가격re {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(solution(new int[] { 1, 2, 3, 2, 3 })));
	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Stack<int[]> stack = new Stack<int[]>();

		stack.push(new int[] { prices[0], 0 });

		for (int time = 1; time < prices.length; time++) {

			int price = prices[time];

			while (!stack.isEmpty()) {
				int[] top = stack.peek();
				if (top[0] > price) {
					stack.pop();
					answer[top[1]] = time - top[1];
				} else {
					break;
				}
			}
			System.out.println(time + "/ stack size : " + stack.size());

			stack.push(new int[] { prices[time], time });
		}

		int price = prices[prices.length - 1];

		while (!stack.isEmpty()) {
			int[] top = stack.peek();
			if (top[0] <= price) {
				stack.pop();
				answer[top[1]] = prices.length - 1 - top[1];
			} else {
				break;
			}
		}

		return answer;
	}

}
